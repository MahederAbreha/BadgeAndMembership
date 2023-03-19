package miu.edu.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.adapter.PlanAdapter;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Membership {
    @Id
    @GeneratedValue
    @Column(name = "membership_id")
    private long id;

    @Past(message = "Start date must be in the past")
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Future(message = "End date must be in the future")
    @Column(name = "end_date",nullable = false)
    private LocalDate endDate;

    @OneToMany()
    @JoinColumn(name = "membership_id")
    @NotBlank(message = "Plan is required")
    private List<Plan> plan = new ArrayList<>();
    @OneToMany()
    @JoinColumn(name = "membership_id")
    private List<Transaction> transactions = new ArrayList<>();

}
