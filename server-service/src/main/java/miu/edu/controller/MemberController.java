package miu.edu.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.dto.MemberDTO;
import miu.edu.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
    @Autowired
    private final MemberService memberService;
    @PostMapping
    public ResponseEntity<?> addMember(MemberDTO memberDTO){
        return new ResponseEntity<MemberDTO>(memberService.addMember(memberDTO), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<?> getAllMembers(){
        return new ResponseEntity<List<MemberDTO>>(memberService.findAllMembers(), HttpStatus.OK);
    }
    @GetMapping("/{member_id}")
    public ResponseEntity<?> getMember(@PathVariable Long member_id){
        return new ResponseEntity<MemberDTO>(memberService.findById(member_id), HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<?> updateMember(MemberDTO memberDTO){
        return new ResponseEntity<MemberDTO>(memberService.updateMember(memberDTO), HttpStatus.OK);
    }
    @DeleteMapping("/{member_id}")
    public ResponseEntity<?> deleteMember(@PathVariable Long id){
        return new ResponseEntity<String>(memberService.deleteById(id), HttpStatus.OK);
    }
}
