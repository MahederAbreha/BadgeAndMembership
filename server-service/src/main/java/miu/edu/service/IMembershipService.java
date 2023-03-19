package miu.edu.service;

import miu.edu.dto.MembershipDTO;

import java.util.List;
import java.util.Optional;

public interface IMembershipService {
    Optional<MembershipDTO> getMembershipsById(Long id);

    MembershipDTO createMemberships(MembershipDTO membershipDTO);
    MembershipDTO updateMemberships(MembershipDTO membershipDTO);
    boolean deleteMembership(Long id);
    List<MembershipDTO> getAllMemberships();
}
