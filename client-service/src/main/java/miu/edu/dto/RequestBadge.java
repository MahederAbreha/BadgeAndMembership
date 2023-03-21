package miu.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestBadge {

    private long id;
    private Boolean isActive;
    private long memberId;

    public RequestBadge(long id, Boolean isActive) {
        this.id = id;
        this.isActive = isActive;
    }
}
