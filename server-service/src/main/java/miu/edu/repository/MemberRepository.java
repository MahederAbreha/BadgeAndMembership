package miu.edu.repository;

import miu.edu.domain.Member;
import miu.edu.domain.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query("SELECT p FROM Membership ms JOIN ms.plan p WHERE ms.member.id = :member_id")
    List<Plan> findPlansByMemberId(@Param("member_id") Long member_id);
}
