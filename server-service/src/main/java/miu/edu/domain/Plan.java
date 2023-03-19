package miu.edu.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.domain.enums.MembershipType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Plan {

    @Id
    @GeneratedValue
    @Column (name = "plan_id")
    private long id;

    @Column (name = "plan_name", nullable = false)
    @NotBlank(message = "Plan name is required")
    private String name;

    @Column (name = "plan_description", nullable = false)
    @NotBlank(message = "Plan description is required")
    private String description;

    @Column (name = "membership_type", nullable = false)
    @NotBlank(message = "Membership type is required")
    private MembershipType membershipType;
}
