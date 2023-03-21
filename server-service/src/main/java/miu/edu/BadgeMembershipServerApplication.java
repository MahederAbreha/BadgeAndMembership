package miu.edu;


import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@RequiredArgsConstructor
@EnableDiscoveryClient
public class BadgeMembershipServerApplication  {

    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }


//    @Autowired
//    private  UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(BadgeMembershipServerApplication.class, args);
        System.out.println("Server is running!!!!!!");

    }



//    @Override
//    public void run(String... args) throws Exception {
////        userRepository.deleteAll();
////        List<Role> roles = Arrays.asList(
////                new Role(RoleType.ADMIN),
////                new Role(RoleType.STAFF)
////        );
////       List<User> user = Stream.of(
////               new User("Bijay", "bijay", roles)).collect(Collectors.toList());
////         userRepository.saveAll(user);
//
//        System.out.println("Server is running!!!!!!");
//
//    }
}
