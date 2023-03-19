package miu.edu.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Badge {
    @Id
    @GeneratedValue
    @Column(name = "badge_id")
    private long id;

    @Column(name ="badge_status_active", nullable = false)
     private Boolean active;


}
