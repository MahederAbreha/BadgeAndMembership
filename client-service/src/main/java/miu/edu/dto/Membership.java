package miu.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Membership {
    private long id;
    @Past(message = "Start date must be in the past")
    private LocalDate startDate;
    private LocalDate endDate;
    private List<Plan> planDTO = new ArrayList<>();
    private Member memberDTO;
    private Integer limit;
    private MembershipType membershipType;
    private DurationType durationType;

    private Boolean allowMultiple;

    public Membership(long id, LocalDate startDate, LocalDate endDate, int limit, Boolean allowMultiple, MembershipType membershipType, DurationType durationType) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.limit = limit;
        this.allowMultiple = allowMultiple;
        this.membershipType = membershipType;
        this.durationType = durationType;
    }

    public Membership(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MembershipDTO{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", planDTO=" + planDTO +
                ", memberDTO=" + memberDTO +
                ", limit=" + limit +
                ", allowMultiple=" + allowMultiple +
                '}';
    }
}
