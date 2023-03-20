package miu.edu.service.Impl;

import lombok.RequiredArgsConstructor;
import miu.edu.adapter.MemberAdapter;
import miu.edu.adapter.MembershipAdapter;
import miu.edu.adapter.PlanAdapter;
import miu.edu.domain.Membership;
import miu.edu.domain.enums.DurationType;
import miu.edu.domain.enums.MembershipType;
import miu.edu.dto.MembershipDTO;
import miu.edu.repository.MembershipRepository;
import miu.edu.service.IMembershipService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MembershipServiceImpl implements IMembershipService {


    private final MembershipRepository membershipRepository;

    private final MembershipAdapter membershipAdapter;

    private final PlanAdapter planAdapter;

    private final MemberAdapter memberAdapter;

    @Override
    public Optional<MembershipDTO> getMembershipsById(Long id) {
        try {
            Optional<Membership> getMemberShipById = membershipRepository.findById(id);
            if (getMemberShipById.isPresent()) {
                var membershipDTO = membershipAdapter.entityToDTO(getMemberShipById.get());
                var planDtoList = planAdapter.entityToDtoAll(getMemberShipById.get().getPlan());
                var memberDtoList = memberAdapter.entityToDTO(getMemberShipById.get().getMember());
                membershipDTO.setPlanDTO(planDtoList);
                membershipDTO.setMemberDTO(memberDtoList);
                return Optional.of(membershipDTO);
            }
            return Optional.empty();
        } catch (Exception e) {
            throw new RuntimeException("Failed to get the membership");

        }
    }

    @Override
    public MembershipDTO createMembership(MembershipDTO membershipDTO) {

        try {
            var membership = membershipAdapter.DtoToEntity(membershipDTO);
            var plan = planAdapter.dtoToEntityAll(membershipDTO.getPlanDTO());
            var member = memberAdapter.DtoToEntity(membershipDTO.getMemberDTO());
            membership.setMembershipType(MembershipType.LIMITED);
            membership.setDurationType(DurationType.DAILY);
            membership.setPlan(plan);
            membership.setMember(member);
            membershipRepository.save(membership);
            var membershipDto = membershipAdapter.entityToDTO(membership);
            var planDtoList = planAdapter.entityToDtoAll(membership.getPlan());
            var memberDtoList = memberAdapter.entityToDTO(membership.getMember());
            membershipDto.setPlanDTO(planDtoList);
            membershipDto.setMemberDTO(memberDtoList);
            return membershipDto;
        } catch (Exception e) {
            throw new RuntimeException("Failed to create the membership");
        }


    }

    @Override
    public MembershipDTO updateMembership(MembershipDTO membershipDTO) {
        try {
            Membership membershipEntity = membershipAdapter.DtoToEntity(membershipDTO);
            Optional<Membership> membership = membershipRepository.findById(membershipEntity.getId());
            if (membership.isPresent()) {
                var plan = planAdapter.dtoToEntityAll(membershipDTO.getPlanDTO());
                var member = memberAdapter.DtoToEntity(membershipDTO.getMemberDTO());
                membershipEntity.setMember(member);
                membershipEntity.setPlan(plan);
                membershipRepository.save(membershipEntity);
                return membershipAdapter.entityToDTO(membershipEntity);
            } else {
                throw new RuntimeException("Membership id not found");
            }


        } catch (Exception e) {
            throw new RuntimeException("Failed to update the membership");
        }
    }

    @Override
    public boolean deleteMembership(Long id) {
        try {
            var findMembership = membershipRepository.findById(id);
            if (findMembership.isPresent()) {
                membershipRepository.deleteById(id);
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            throw new RuntimeException("Failed to delete the membership");
        }
    }

    @Override
    public List<MembershipDTO> getAllMembership() {
        try {
            return membershipAdapter.entityToDTOAll(membershipRepository.findAll());
        } catch (Exception e) {
            throw new RuntimeException("Failed to get all the membership");
        }
    }
}
