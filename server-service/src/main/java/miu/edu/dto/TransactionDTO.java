package miu.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.domain.Location;
import miu.edu.domain.Membership;
import miu.edu.domain.enums.TransactionStatusType;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransactionDTO {
    private Long id;
    private TransactionStatusType status;
    private LocalDateTime dateTime;
    private Membership membership;
    private Location location;


}
