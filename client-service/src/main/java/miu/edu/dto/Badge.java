package miu.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Badge {

    private long id;
    private Boolean isActive;
    private Member memberDTO;

    public Badge(long id, Boolean isActive) {
        this.id = id;
        this.isActive = isActive;
    }
}
