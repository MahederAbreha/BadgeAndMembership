package miu.edu.service.Impl;

import lombok.RequiredArgsConstructor;
import miu.edu.adapter.MemberAdapter;
import miu.edu.domain.Member;
import miu.edu.dto.MemberDTO;
import miu.edu.repository.MemberRepository;
import miu.edu.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    @Autowired
    private final MemberAdapter memberAdapter;
    @Autowired
    private final MemberRepository memberRepository;

    @Override
    public void addMember(MemberDTO memberDTO) {
        Member member = memberAdapter.DtoToEntity(memberDTO);
        memberRepository.save(member);
    }

    @Override
    public List<MemberDTO> findAllMembers() {
        return memberAdapter.entityToDTOAll(memberRepository.findAll());
    }
}
