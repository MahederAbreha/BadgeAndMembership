package miu.edu.repository;

import miu.edu.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


  @Query("select u from User u where u.username = ?1")
  Optional<User>  findByUserName(String username);
}
