package miu.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BadgeMembershipServerApplication {

        public static void main(String[] args) {
            SpringApplication.run(BadgeMembershipServerApplication.class, args);
            System.out.println("Server is running!!!!!!");
        }

}
