package miu.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.domain.Member;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BadgeDTOs {

    private long id;
    private Boolean isActive;
}