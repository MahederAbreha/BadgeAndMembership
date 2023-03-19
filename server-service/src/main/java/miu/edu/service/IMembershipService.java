package miu.edu.service;

import miu.edu.dto.MembershipDTO;

import java.util.List;
import java.util.Optional;

public interface IMembershipService {
    Optional<MembershipDTO> getMembershipById(Long id);

    MembershipDTO createMembership(MembershipDTO membershipDTO);
    MembershipDTO updateMembership(MembershipDTO membershipDTO);
    boolean deleteMembership(Long id);
    List<MembershipDTO> getAllMembership();
}
