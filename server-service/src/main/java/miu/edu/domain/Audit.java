package miu.edu.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Audit {
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt = LocalDateTime.now();
    private long createdBy;
    private long updatedBy;
}
