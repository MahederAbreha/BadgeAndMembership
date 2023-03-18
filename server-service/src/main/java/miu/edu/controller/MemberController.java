package miu.edu.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.dto.MemberDTO;
import miu.edu.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
    @Autowired
    private final MemberService memberService;
    @PostMapping
    public ResponseEntity<?> addMember(MemberDTO memberDTO){
        memberService.addMember(memberDTO);
        return new ResponseEntity<String>("Member Saved successfully.", HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<?> getAllMembers(){
        return new ResponseEntity<List<MemberDTO>>(memberService.findAllMembers(), HttpStatus.OK);
    }
}
