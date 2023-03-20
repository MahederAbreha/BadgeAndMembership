package miu.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.domain.Member;
import miu.edu.domain.Plan;
import miu.edu.domain.Transaction;
import miu.edu.domain.enums.DurationType;
import miu.edu.domain.enums.MembershipType;

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
    private List<PlanDTO> planDTO = new ArrayList<>();
    private MemberDTO memberDTO;
    private Integer limit;
    private MembershipType membershipType;
    private DurationType durationType;

    private Boolean allowMultiple;

    public MembershipDTO(long id, LocalDate startDate, LocalDate endDate,int limit,Boolean allowMultiple, MembershipType membershipType, DurationType durationType) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.limit = limit;
        this.allowMultiple = allowMultiple;
        this.membershipType = membershipType;
        this.durationType = durationType;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public MembershipType getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(MembershipType membershipType) {
        this.membershipType = membershipType;
    }

    public DurationType getDurationType() {
        return durationType;
    }

    public void setDurationType(DurationType durationType) {
        this.durationType = durationType;
    }

    public Boolean getAllowMultiple() {
        return allowMultiple;
    }

    public void setAllowMultiple(Boolean allowMultiple) {
        this.allowMultiple = allowMultiple;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<PlanDTO> getPlanDTO() {
        return planDTO;
    }

    public void setPlanDTO(List<PlanDTO> planDTO) {
        this.planDTO = planDTO;
    }

    public MemberDTO getMemberDTO() {
        return memberDTO;
    }

    public void setMemberDTO(MemberDTO memberDTO) {
        this.memberDTO = memberDTO;
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
