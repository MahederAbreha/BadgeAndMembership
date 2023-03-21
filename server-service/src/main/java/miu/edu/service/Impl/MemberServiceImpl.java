package miu.edu.service.Impl;

import lombok.RequiredArgsConstructor;
import miu.edu.adapter.*;
import miu.edu.domain.*;
import miu.edu.dto.*;
import miu.edu.repository.MemberRepository;
import miu.edu.repository.PlanRepository;
import miu.edu.service.MemberService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberAdapter memberAdapter;
    private final PlanRepository planRepository;

    //  private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final MemberRepository memberRepository;
    private final BadgeAdapter badgeAdapter;
    private final BadgeDtosAdapter badgeDtosAdapter;
    private final MembershipAdapter membershipAdapter;
    private final MemberPlanAdapter memberPlanAdapter;
    private final RoleAdapter roleAdapter;
    private final PlanAdapter planAdapter;
    private final TransactionAdapter transactionAdapter;

    @Override
    public MemberPlanDTO addMember(MemberPlanDTO memberDTO) {

        try {
            var member = memberPlanAdapter.DtoToEntity(memberDTO);
            //    String encpasswd = bCryptPasswordEncoder.encode("User.getPassword()");
            //    User user = new User();
            //     user.setPassword(encpasswd);
            var badge = badgeAdapter.dtoToEntityAll(memberDTO.getBadgeDTOS());
            badge.forEach(item -> item.setMember(member));

            List<Plan> plansLists = new ArrayList<>();
            for (var plan : memberDTO.getPlansId()) {
                plansLists.add(planRepository.findById(plan).get());
            }
            List<Membership> allMemberships = new ArrayList<>();
            var listOfMembershipDto = memberDTO.getMembershipDTOS();
            for (MembershipDTO membershipDTO : listOfMembershipDto) {
                var membership = membershipAdapter.dtoToEntity(membershipDTO);
                membership.setPlan(plansLists);
                membership.setMember(member);
                allMemberships.add(membership);
            }
            var roleTypes = roleAdapter.dtoToEntityAll(memberDTO.getRoleTypes());
            member.setBadges(badge);
            member.setMemberships(allMemberships);
            // member.setRoleTypes(roleTypes);
            member.setAudit(new Audit(LocalDateTime.now()));
            memberRepository.save(member);

            return memberPlanAdapter.entityToDTO(member);
        } catch (RuntimeException e) {
            throw new RuntimeException("Failed to add this member" + e.getMessage() + e.getCause());
        }
    }

    @Override
    public List<MemberDTO> findAllMembers() {
        try {
            return memberAdapter.entityToDTOAll(memberRepository.findAll());
        } catch (RuntimeException e) {
            throw new RuntimeException("Failed to find the members");
        }
    }

    @Override
    public MemberDTO findById(Long id) {
        Optional<Member> memberOptional = memberRepository.findById(id);
        Member member = memberOptional.orElseThrow(() -> new EntityNotFoundException("Member with id " + id + " not found"));
        return memberAdapter.entityToDTO(member);
    }

    @Override
    public MemberDTO updateMember(MemberDTO memberDTO) {
        try {
            memberRepository.save(memberAdapter.DtoToEntity(memberDTO));
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Failed to update the member");
        }
        return memberDTO;
    }

    @Override
    public String deleteById(Long id) {
        try {
            memberRepository.deleteById(id);
            return "Member deleted successfully";
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Failed to delete this member");
        }
    }

    @Override
    public List<PlanDTO> findPlansByMemberId(Long id) {
        try {
            var plansByMemberId = memberRepository.findPlansByMemberId(id);
            return planAdapter.entityToDtoAll(plansByMemberId);
        } catch (RuntimeException e) {
            throw new RuntimeException("Failed to find the plans");
        }
    }

    @Override
    public List<BadgeDTOs> findBadgeByMemberId(Long id) {
        try {
            var badgeByMemberId = memberRepository.findBadgeByMemberId(id);
            var badgesDto = badgeDtosAdapter.entityToDTOAll(badgeByMemberId);
            return badgesDto;

        } catch (RuntimeException e) {
            throw new RuntimeException("Failed to find the badge");
        }
    }

    @Override
    public MemberDTO findMembershipsByMemberId(Long id) {
        try {
            var membershipsByMemberId = memberRepository.findMembershipsByMemberId(id);
            var memberDto = memberAdapter.entityToDTO(membershipsByMemberId);

            var membershipPlans = membershipsByMemberId.getMemberships();
            var membershipsDto = membershipAdapter.entityToDTOAll(membershipsByMemberId.getMemberships());
            List<PlanDTO> planDTOS = membershipPlans.stream()
                    .flatMap(membership -> membership.getPlan().stream())
                    .map(planAdapter::entityToDto).collect(Collectors.toList());

            membershipsDto.stream().map(membership -> {
                membership.setPlanDTO(planDTOS);
                return membership;
            }).collect(Collectors.toList());

           memberDto.setMembershipDTOS(membershipsDto);
            return memberDto;

        } catch (RuntimeException e) {
            throw new RuntimeException("Failed to find the badge");
        }
    }

    @Override
    public List<TransactionDTO> findTransactionsByMemberId(Long id) {
        try {
            List<Transaction> transactions = memberRepository.findTransactionsByMemberId(id);
            return transactionAdapter.entityToDtoAll(transactions);
        } catch (RuntimeException e) {
            throw new RuntimeException("Failed to find the transations.");
        }
    }


}
