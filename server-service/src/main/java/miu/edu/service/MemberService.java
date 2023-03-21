package miu.edu.service;

import miu.edu.dto.BadgeDTO;
import miu.edu.dto.MemberDTO;
import miu.edu.dto.PlanDTO;
import miu.edu.dto.TransactionDTO;

import java.util.List;

public interface MemberService {
    public MemberDTO addMember(MemberDTO memberDTO);
    public List<MemberDTO> findAllMembers();
    public MemberDTO findById(Long id);
    public MemberDTO updateMember(MemberDTO memberDTO);
    public String deleteById(Long id);
    public List<PlanDTO> findPlansByMemberId(Long id);
    public List<BadgeDTO> findBadgeByMemberId(Long id);
    public MemberDTO findMembershipsByMemberId(Long id);
    public List<TransactionDTO> findTransactionsByMemberId(Long id);

}
