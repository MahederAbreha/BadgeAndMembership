package miu.edu.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.adapter.PlanAdapter;
import miu.edu.domain.enums.DurationType;
import miu.edu.domain.enums.MembershipType;

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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "membership_id")
    private List<Plan> plan = new ArrayList<>();

    @Column(name = "membership_type", nullable = false)
    private MembershipType membershipType;

    @Column(name = "access_limit", nullable = true)
    private Integer limit;

    @Column(name = "allow_multiple", nullable = false)
    @NotBlank(message = "Allow multiple is required")
    private Boolean allowMultiple;

    @Column(name = "duration_type", nullable = false)
    private DurationType durationType;

    @ManyToOne()
    @JoinColumn(name = "member_id")
    private Member member;

    public Membership(long id, LocalDate startDate, LocalDate endDate, List<Plan> plan) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.plan = plan;
    }

}
