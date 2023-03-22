package miu.edu;
import miu.edu.dto.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Scanner;

@SpringBootApplication
public class BadgeMembershipSystemClientApplication implements CommandLineRunner {

    private RestTemplate restTemplate = new RestTemplate();
    private String url = "http://localhost:8080";
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SpringApplication.run(BadgeMembershipSystemClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Long checkerId;
        //Long memberId;
        Long planId;
        Long locationId;
        MemberDTO loginResponse = new MemberDTO(74L, "Mahi", "Abebeb", "mahi@miu.edu", "qwert");
        //MemberDTO loginResponse = login().getBody();
        checkerId = loginResponse.getId();
        MembershipDTO membershipDTO = getMembership(checkerId);
        if(membershipDTO.getMembershipType().equals(MembershipType.CHECKER)){
            System.out.println(membershipDTO);
            PlanDTO[] plans = membershipDTO.getPlanDTO().toArray(new PlanDTO[0]);
            System.out.println(Arrays.toString(plans));
            for (int i = 0; i < plans.length; i++) {
                System.out.println("[" + i + "] " + plans[i]);
            }
            System.out.print("Choose Your Plan: ");
            int index = scanner.nextInt();
            PlanDTO planDTO = plans[index];
            planId = (planDTO.getId());
            locationId = selectLocation(planId).getId();
            scan(checkerId, planId, locationId);
        }
        else {
            System.out.println("You are not a CHECKER!!");
        }

    }
    private ResponseEntity<MemberDTO> login(){
        System.out.println("= = = = = = = = = BADGE AND MEMBERSHIP MANAGEMENT SYSTEM  = = = = = = = = =");
        System.out.println("= = = = = = = = = = = = = =   SIGN IN PLEASE  = = = = = = = = = = = = = = =");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        LoginDTO loginDTO = new LoginDTO(username,password);
        ResponseEntity<MemberDTO> response = restTemplate.postForEntity(url+"/authentication", loginDTO, MemberDTO.class);
        return response;
    }
    private MembershipDTO getMembership(long memberId){
        System.out.println(" = = = = = = = = = Memberships = = = = = = = = = =  ");
       // System.out.printf(url+"/members/"+memberId+"/memberships");

        MembershipDTO[] memberships = restTemplate.getForObject(url+"/members/"+memberId+"/memberships", MembershipDTO[].class, memberId);
        for (int i = 0; i < memberships.length; i++) {
            System.out.println("[" + i + "] " + memberships[i]);
        }
        System.out.print("Choose Your Membership: ");
        int index = scanner.nextInt();
        System.out.println(memberships[index].getMembershipType());
        return memberships[index];
    }
    private LocationDTO selectLocation(long planId){
        System.out.println("Your Locations are: ");
        LocationDTO[] locations = restTemplate.getForObject(url+"/plans/"+planId+"/locations", LocationDTO[].class, planId);
        for (int i = 0; i < locations.length; i++) {
            System.out.println("[" + i + "] " + locations[i]);
        }
        System.out.print("Choose Your Location: ");
        int index = scanner.nextInt();
        return locations[index];
    }
    private void scan(long checkerId, long planId, long locationId) {
        while (true) {
            System.out.print("Scan a member's badge: ");
            if (scanner.hasNextLong()) {
                //get badgeID from scan and query for memberID?
                Long memberId = scanner.nextLong();
                //Bapi?? can yuo build the "data" map and request the post?
                //ResponseEntity<TransactionDTO> transactionDTO = restTemplate.postForEntity(url+"/scan", data, TransactionDTO.class )
            } else {
                break;
            }
        }
    }
}
