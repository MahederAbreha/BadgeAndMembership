package miu.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberPlan {
    private Long id;
    private String firstname;
    private String lastname;
    private String  email;
    private String  password;
    private List<Badge> badgeDTOS = new ArrayList<>();
    private List<Role> roleTypes = new ArrayList<>();
    private List<Membership> memberships = new ArrayList<>();
    private List<Long> plansId = new ArrayList<>();
    public MemberPlan(Long id , String firstname, String lastname, String email, String password) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }
}
