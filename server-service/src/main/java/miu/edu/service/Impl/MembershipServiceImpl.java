package miu.edu.service.Impl;

import lombok.RequiredArgsConstructor;
import miu.edu.adapter.MembershipAdapter;
import miu.edu.domain.Membership;
import miu.edu.dto.MembershipDTO;
import miu.edu.repository.MembershipRepository;
import miu.edu.service.IMembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MembershipServiceImpl implements IMembershipService {

    private final MembershipRepository membershipRepository;
    private final MembershipAdapter membershipAdapter;

    @Override
    public Optional<MembershipDTO> getMembershipById(Long id) {
        try {
            Optional<Membership> getMemberById = membershipRepository.findById(id);
            if (getMemberById.isPresent()) {
                var membershipDTO = membershipAdapter.entityToDTO(getMemberById.get());
                membershipDTO.setPlan(getMemberById.get().getPlan());
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
            membershipRepository.save(membership);
            return membershipAdapter.entityToDTO(membership);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create the membership");
        }
    }

    @Override
    public MembershipDTO updateMembership(MembershipDTO membershipDTO) {
        try {
            Membership membershipEntity = membershipAdapter.DtoToEntity(membershipDTO);
            Optional<Membership> membership = membershipRepository.findById(membershipEntity.getId());
            if (membership.isPresent()){
                 membershipRepository.save(membershipEntity);
                return membershipAdapter.entityToDTO(membershipEntity);
            }else {
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
