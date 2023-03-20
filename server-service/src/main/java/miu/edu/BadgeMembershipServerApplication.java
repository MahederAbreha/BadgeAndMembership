package miu.edu;

import miu.edu.adapter.MemberAdapter;
import miu.edu.domain.Member;
import miu.edu.domain.Membership;
import miu.edu.domain.Plan;
import miu.edu.dto.MemberDTO;
import miu.edu.dto.MembershipDTO;
import miu.edu.repository.MemberRepository;
import miu.edu.repository.MembershipRepository;
import miu.edu.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BadgeMembershipServerApplication {
    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    MembershipRepository membershipRepository;

    public static void main(String[] args) {
        SpringApplication.run(BadgeMembershipServerApplication.class, args);
        System.out.println("Server is running!!!!!!");
    }
}
