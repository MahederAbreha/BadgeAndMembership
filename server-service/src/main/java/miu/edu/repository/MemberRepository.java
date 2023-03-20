package miu.edu.repository;

import miu.edu.domain.Badge;
import miu.edu.domain.Member;
import miu.edu.domain.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query("SELECT p FROM Membership ms JOIN ms.plan p WHERE ms.member.id = :id")
    List<Plan> findPlansByMemberId(@Param("id") Long id);

    @Query("SELECT b FROM Badge b WHERE b.member.id = :id")
    List<Badge> findBadgeByMemberId(@Param("id") Long id);

    @Query("SELECT m FROM Member m JOIN m.memberships b WHERE m.id = :id")
    Member findMembershipsByMemberId(@Param("id") Long id);
}
