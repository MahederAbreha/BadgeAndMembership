package miu.edu.service;

import miu.edu.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MemberService {
    public void addMember(MemberDTO memberDTO);
    public List<MemberDTO> findAllMembers();
}
