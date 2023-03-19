package miu.edu.service.Impl;

import lombok.RequiredArgsConstructor;
import miu.edu.adapter.MemberAdapter;
import miu.edu.domain.Audit;
import miu.edu.domain.Member;
import miu.edu.dto.MemberDTO;
import miu.edu.repository.MemberRepository;
import miu.edu.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    @Autowired
    private final MemberAdapter memberAdapter;
    @Autowired
    private final MemberRepository memberRepository;

    @Override
    public MemberDTO addMember(MemberDTO memberDTO) {
        Member member = memberAdapter.DtoToEntity(memberDTO);
        member.setAudit(new Audit(LocalDateTime.now()));
        try {
            memberRepository.save(member);
        }catch (RuntimeException e){
            throw new RuntimeException("Failed to add this member");
        }
        return memberAdapter.entityToDTO(member);
    }

    @Override
    public List<MemberDTO> findAllMembers() {
        try {
            return memberAdapter.entityToDTOAll(memberRepository.findAll());
        }catch (RuntimeException e){
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
    public MemberDTO updateById(MemberDTO memberDTO) {
        try {
            memberRepository.save(memberAdapter.DtoToEntity(memberDTO));
        }catch (EntityNotFoundException e){
            throw new EntityNotFoundException("Member not found");
        }
        return memberDTO;
    }

    @Override
    public void deleteById(Long id) {
        try {
            memberRepository.deleteById(id);
        }catch (EntityNotFoundException e){
            throw new EntityNotFoundException("Member not found");
        }
    }
}
