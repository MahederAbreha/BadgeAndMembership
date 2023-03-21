package miu.edu.service.Impl;

import miu.edu.adapter.LocationAdapter;
import miu.edu.adapter.MemberAdapter;
import miu.edu.adapter.PlanAdapter;
import miu.edu.domain.*;
import miu.edu.domain.enums.TransactionStatusType;
import miu.edu.dto.MemberDTO;
import miu.edu.dto.TransactionDTO;
import miu.edu.repository.LocationRepository;
import miu.edu.repository.MembershipRepository;
import miu.edu.repository.TransactionRepository;
import miu.edu.service.LocationService;
import miu.edu.service.MemberService;
import miu.edu.service.PlanService;
import miu.edu.service.ScanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional
public class ScanServiceImpl implements ScanService {
    @Autowired
    LocationService locationService;
    @Autowired
    LocationAdapter locationAdapter;
    @Autowired
    MembershipRepository membershipRepository;
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    LocationRepository locationRepository;
    @Override
    public TransactionDTO processRequest(Long checker_id, Long plan_id, Long location_id, Long member_id) {
        Location location = locationAdapter.dtoToEntity(locationService.findById(location_id));
        try {
            Membership membership = membershipRepository.findByMemberAndPlanAndLocation(member_id, plan_id, location_id);
            Transaction transaction = new Transaction();
            transaction.setAudit(new Audit(LocalDateTime.now()));
            transaction.setLocation(location);
            transaction.setMembership(membership);
            transaction.setTransactionDateTime(LocalDateTime.now());
//            transaction.setTransactionStatusType(TransactionStatusType.ALLOWED);
            Optional<TimeSlot> timeSlot = Optional.ofNullable(locationRepository.getCurrentTimeSlot(location_id, LocalDateTime.now()));
            if(timeSlot.isPresent()){
                switch (membership.getMembershipType()){
                    case LIMITED:
                        Integer transactionCount;
                        switch (membership.getDurationType()){
                            case DAILY -> transactionCount = transactionRepository.countTotalTransactionToday(location_id, membership.getId());
                            case WEEKLY -> transactionCount = transactionRepository.countTotalTransactionThisWeek(location_id, membership.getId());
                            case MONTHLY -> transactionCount = transactionRepository.countTotalTransactionThisMonth(location_id, membership.getId());
                            default -> transactionCount = 0;
                        }
                        if (transactionCount >= membership.getLimit()){
                            transaction.setTransactionStatusType(TransactionStatusType.DECLINED);
                        }else {
                            transaction.setTransactionStatusType(TransactionStatusType.ALLOWED);
                        }
                        break;
                    default:
                        transaction.setTransactionStatusType(TransactionStatusType.ALLOWED);
                }
            }else {
                transaction.setTransactionStatusType(TransactionStatusType.DECLINED);
            }
            transactionRepository.save(transaction);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
}
