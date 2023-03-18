package miu.edu.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Membership {
    @Id
    @GeneratedValue
    private long id;

    @Past(message = "Start date must be in the past")
    private LocalDate startDate;

    @Future(message = "End date must be in the future")
    private LocalDate endDate;

}
