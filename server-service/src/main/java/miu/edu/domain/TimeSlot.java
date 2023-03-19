package miu.edu.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class TimeSlot {

    @Id
    @GeneratedValue
    @Column(name = "time_slot_id")
    private long id;

    @NotBlank(message = "Start time is required")
    @Column(name = "start_time", nullable = false)
    private LocalDate startTime;

    @NotBlank(message = "End time is required")
    @Column(name = "end_time", nullable = false)
    private LocalDate endTime;
}
