package miu.edu.repository;

import miu.edu.domain.*;
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

    @Query("SELECT ms FROM Membership ms where ms.member.id = :id")
    List<Membership> findMembershipsByMemberId(@Param("id") Long id);

    @Query("SELECT t FROM Transaction t where t.membership.member.id = :id")
    List<Transaction> findTransactionsByMemberId(@Param("id") Long id);
}
