package miu.edu.service.Impl;

import lombok.RequiredArgsConstructor;
import miu.edu.adapter.*;
import miu.edu.domain.*;
import miu.edu.dto.*;
import miu.edu.repository.MemberRepository;
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
    private final MemberRepository memberRepository;
    private final BadgeAdapter badgeAdapter;
    private final MembershipAdapter membershipAdapter;
    private final RoleAdapter roleAdapter;
    private final PlanAdapter planAdapter;
    private final TransactionAdapter transactionAdapter;

    @Override
    public MemberDTO addMember(MemberDTO memberDTO) {

        try {
            var member = memberAdapter.DtoToEntity(memberDTO);
            var badge = badgeAdapter.dtoToEntityAll(memberDTO.getBadgeDTOS());
            badge.forEach(item->item.setMember(member));
//            for (Badge badgeItem : badge) {
//                badgeItem.setMember(member);
//            }

            List<Membership> allMemberships = new ArrayList<>();
            var listOfMembershipDto = memberDTO.getMembershipDTOS();
            for (MembershipDTO membershipDTO : listOfMembershipDto) {
                var membership = membershipAdapter.dtoToEntity(membershipDTO);
                List<Plan> plan = planAdapter.dtoToEntityAll(membershipDTO.getPlanDTO());
                membership.setPlan(plan);
                membership.setMember(member);
                allMemberships.add(membership);
            }
            var roleTypes = roleAdapter.dtoToEntityAll(memberDTO.getRoleTypes());
            member.setBadges(badge);
            member.setMemberships(allMemberships);
            member.setRoleTypes(roleTypes);
            member.setAudit(new Audit(LocalDateTime.now()));
            memberRepository.save(member);

            return memberAdapter.entityToDTO(member);
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
    public List<BadgeDTO> findBadgeByMemberId(Long id) {
        try {
//            var badgeByMemberId = memberRepository.findBadgeByMemberId(id);
//            var memberDto = memberAdapter.entityToDTO(badgeByMemberId);
//            var badgesDto = badgeAdapter.entityToDTOAll(badgeByMemberId.getBadges());
//            memberDto.setBadgeDTOS(badgesDto);
            var badgeByMemberId = memberRepository.findBadgeByMemberId(id);
            return badgeAdapter.entityToDTOAll(badgeByMemberId);

        } catch (RuntimeException e) {
            throw new RuntimeException("Failed to find the badge");
        }
    }

    @Override
    public List<MembershipDTO> findMembershipsByMemberId(Long id) {
        try {
            List<Membership> memberships = memberRepository.findMembershipsByMemberId(id);
//            var memberDto = memberAdapter.entityToDTO(membershipsByMemberId);
//
//            var membershipPlans = membershipsByMemberId.getMemberships();
//            var membershipsDto = membershipAdapter.entityToDTOAll(membershipsByMemberId.getMemberships());
//            List<PlanDTO> planDTOS = membershipPlans.stream()
//                    .flatMap(membership -> membership.getPlan().stream())
//                    .map(planAdapter::entityToDto).collect(Collectors.toList());
//
//            membershipsDto.stream().map(membership -> {
//                membership.setPlanDTO(planDTOS);
//                return membership;
//            }).collect(Collectors.toList());
//
//            memberDto.setMembershipDTOS(membershipsDto);
//            return memberDto;
            return membershipAdapter.entityToDTOAll(memberships);

        } catch (RuntimeException e) {
            throw new RuntimeException("Failed to find the badge");
        }
    }

    @Override
    public List<TransactionDTO> findTransactionsByMemberId(Long id) {
        try{
            List<Transaction> transactions = memberRepository.findTransactionsByMemberId(id);
            return transactionAdapter.entityToDtoAll(transactions);
        }catch(RuntimeException e){
            throw new RuntimeException("Failed to find the transations.");
        }
    }


}
