package miu.edu;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BadgeMembershipServerApplication  implements  CommandLineRunner{


    public static void main(String[] args) {
        SpringApplication.run(BadgeMembershipServerApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Server is running!!!!!!");

    }
}
