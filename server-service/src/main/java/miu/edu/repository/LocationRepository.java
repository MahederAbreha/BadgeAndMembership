package miu.edu.repository;

import miu.edu.domain.Location;
import miu.edu.domain.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    @Query("SELECT ts FROM Location l JOIN l.timeSlots ts " +
            "WHERE :currentTime BETWEEN ts.startTime AND ts.endTime " +
            "AND l.id = :locationId")
    TimeSlot getCurrentTimeSlot(@Param("locationId") Long locationId,
                                @Param("currentTime") LocalDateTime currentTime);
}
