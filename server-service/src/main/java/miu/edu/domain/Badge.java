package miu.edu.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Embedded
    private Audit audit;

    public Badge(long id, Boolean isActive) {
        this.id = id;
        this.isActive = isActive;
    }
}
