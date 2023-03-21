package miu.edu;

import miu.edu.dto.Location;
import miu.edu.dto.Membership;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class BadgeMembershipSystemClientApplication {
    RestTemplate restTemplate = new RestTemplate();

    private String url = "http://localhost:8761/scan";
    String planId = "123";
    String locationId = "456";
    String checkerId = "789";
    String badgeId = "ABC";
    String memberId = "987";
    public static void main(String[] args) {
         SpringApplication.run(BadgeMembershipSystemClientApplication.class, args);
        System.out.println("BadgeMembershipSystemClientApplication is running");
    }
    public void run(String... args) throws Exception {
        //return a list of memberships using above.
        List<Membership> memberships = restTemplate.exchange(
                        "http://localhost:8080/members/" + memberId + "/memberships",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<Membership>>(){})
                .getBody();


        //For a plan, return the list of Locations (GET /plans/{planId}/locations)
        List<Location> locations = restTemplate.exchange(
                        "http://localhost:8080/plans/" + planId + "/locations",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<Location>>(){})
                .getBody();

        //Post Transaction
        restTemplate.postForLocation(url, new Transaction (planId, locationId, checkerId, badgeId, memberId));
        //Transaction transactionResponse = restTemplate.getForEntity(url + "?planId={planId}&locationId={locationId}&checkerId={checkerId}&badgeId={badgeId}&memberId={memberId}", String.class, planId, locationId, checkerId, badgeId, memberId);
//        ResponseEntity<Transaction> transactionResponse = restTemplate.getForEntity(url,Transaction.class, "");
//        if (transactionResponse.getStatusCodeValue() == 200) {
//            Transaction responseBody = transactionResponse.getBody();
//            System.out.println(responseBody);
//        } else {
//            System.out.println("Error: " + transactionResponse.getStatusCodeValue() + " - " + transactionResponse.getStatusCode().getReasonPhrase());
//        }


    }
}


