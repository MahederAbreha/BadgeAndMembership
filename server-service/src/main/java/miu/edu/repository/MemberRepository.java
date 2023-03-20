package miu.edu.repository;

import miu.edu.domain.Member;
import miu.edu.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    //return the list of all transactions (GET /members/{memberId}/transactions)
//    @Query("SELECT m FROM MEMBER m JOIN m.membership ms JOIN ms.TRANSACTION t WHERE t.member_id =: member_id");
//    List<Transaction> getTransactionByMemberId(@Param("member_id") long member_id);

}
