package miu.edu.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.domain.enums.TransactionStatusType;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue
    @Column (name = "transaction_id")
    private long id;

    @Column (name = "transaction_status_type", nullable = false)
    @NotBlank(message = "Transaction_status_type is required")
    private TransactionStatusType transactionStatusType; //Data Type ???? String or TransactionStatusType

    @Column (name = "transaction_date_time", nullable = false)
    @NotBlank(message = "Transaction_date_time is required")
    private LocalDateTime transactionDateTime;

    //1-1 relationship with Membership
    @OneToOne
    @JoinColumn(name="membership_id")
    private Membership membership;

    //1-1 relationship with Location
    @OneToOne
    @JoinColumn(name="location_id")
    private Location location;

    @Embedded
    private Audit audit;

    public Transaction(long id, TransactionStatusType transactionStatusType, LocalDateTime transactionDateTime, Membership membership, Location location) {
        this.id = id;
        this.transactionStatusType = transactionStatusType;
        this.transactionDateTime = transactionDateTime;
        this.membership = membership;
        this.location = location;
    }
}
