package miu.edu.adapter;

import miu.edu.domain.Member;
import miu.edu.domain.Membership;
import miu.edu.dto.MemberDTO;
import miu.edu.dto.MembershipDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MembershipAdapter {
    public MembershipDTO entityToDTO(Membership membership){
        return new MembershipDTO(membership.getId(), membership.getStartDate(), membership.getEndDate(), membership.getPlan(), membership.getTransactions());
    }
    public List<MembershipDTO> entityToDTOAll(List<Membership> membership){
        return membership.stream().map(memberships -> entityToDTO(memberships)).collect(Collectors.toList());
    }
    public Membership DtoToEntity(MembershipDTO membershipDTO){
        return new Membership(membershipDTO.getId(), membershipDTO.getStartDate(), membershipDTO.getEndDate(), membershipDTO.getPlan(), membershipDTO.getTransactions());
    }
    public List<Membership> DtoToEntityAll(List<MembershipDTO> membershipDTO){
        return membershipDTO.stream().map(memberDTO -> DtoToEntity(memberDTO)).collect(Collectors.toList());
    }
}
