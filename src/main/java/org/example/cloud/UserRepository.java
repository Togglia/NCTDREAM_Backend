package org.example.cloud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(value = "SELECT u FROM User u WHERE u.userId = :userId")
    Optional<User> findMemberByUserId(@Param(value = "userId") String userId);

    @Query(value = "SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.userId = :userId")
    boolean existsUserByUserId(@Param(value = "userId")String userId);
}
