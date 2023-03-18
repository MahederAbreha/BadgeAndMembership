package miu.edu;

import miu.edu.repository.MemberRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BadgeMembershipServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BadgeMembershipServerApplication.class, args);
        System.out.println("Server is running!!!!!!");
    }

}
