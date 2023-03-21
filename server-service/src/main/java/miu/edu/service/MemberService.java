package miu.edu.service;

import miu.edu.dto.*;

import java.util.List;

public interface MemberService {
    public MemberPlanDTO addMember(MemberPlanDTO memberDTO);
    public List<MemberDTO> findAllMembers();
    public MemberDTO findById(Long id);
    public MemberDTO updateMember(MemberDTO memberDTO);
    public String deleteById(Long id);
    public List<PlanDTO> findPlansByMemberId(Long id);
    public List<BadgeDTOs> findBadgeByMemberId(Long id);
    public MemberDTO findMembershipsByMemberId(Long id);
    public List<TransactionDTO> findTransactionsByMemberId(Long id);

}
