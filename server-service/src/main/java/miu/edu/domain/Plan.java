package miu.edu.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Plan {

    @Id
    @GeneratedValue
    @Column(name = "plan_id")
    private long id;

    @Column(name = "plan_name", nullable = false)
    @NotBlank(message = "Plan name is required")
    private String name;

    @Column(name = "plan_description", nullable = false)
    @NotBlank(message = "Plan description is required")
    private String description;

    @OneToMany
    @JoinColumn(name = "plan_id")
    private List<Location> locations = new ArrayList<>();
}
