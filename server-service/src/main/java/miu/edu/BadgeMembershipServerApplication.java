package miu.edu;

import miu.edu.domain.Transaction;
import miu.edu.repository.MemberRepository;
import miu.edu.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BadgeMembershipServerApplication{

    @Autowired
    TransactionRepository transactionRepository;
    public static void main(String[] args) {
        SpringApplication.run(BadgeMembershipServerApplication.class, args);
        System.out.println("Server is running!!!!!!");
    }

}
