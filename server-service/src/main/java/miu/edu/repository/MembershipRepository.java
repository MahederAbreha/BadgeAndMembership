package miu.edu.repository;

import miu.edu.domain.Member;
import miu.edu.domain.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipRepository extends JpaRepository<Membership, Long> {
//    @Query("SELECT m FROM Membership m " +
//            "JOIN m.member mem " +
//            "JOIN m.plan p " +
//            "JOIN p.locations l " +
//            "WHERE mem.id = :memberId " +
//            "AND p.id = :planId " +
//            "AND l.id = :locationId")
//    Membership findByMemberAndPlanAndLocation(@Param("member_id") Long memberId,
//                                              @Param("plan_id") Long planId,
//                                              @Param("location_id") Long locationId);
}
