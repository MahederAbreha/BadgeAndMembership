package miu.edu.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Transaction {
    private long id;
    private TransactionStatusType status;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss", iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateTime;
    private Membership membership;
    private Location locationDTO;

    public Transaction(TransactionStatusType status, LocalDateTime dateTime, Membership membership, Location locationDTO) {
        this.status = status;
        this.dateTime = dateTime;
        this.membership = membership;
        this.locationDTO = locationDTO;
    }

    public Transaction(TransactionStatusType status, LocalDateTime dateTime, Membership membership) {
        this.status = status;
        this.dateTime = dateTime;
        this.membership = membership;
    }
}
