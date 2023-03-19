package miu.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.domain.enums.MembershipType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanDTO {
    private long id;
    private String name;
    private String description;


}
