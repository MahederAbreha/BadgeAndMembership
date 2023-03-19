package miu.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.domain.Plan;
import miu.edu.domain.Transaction;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MembershipDTO {
    private long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<Plan> plan = new ArrayList<>();

    public MembershipDTO(LocalDate startDate, LocalDate endDate, List<Plan> plan) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.plan = plan;
    }
}
