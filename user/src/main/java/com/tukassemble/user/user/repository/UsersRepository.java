package com.tukassemble.user.user.repository;

import com.tukassemble.user.user.Users;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsersRepository extends JpaRepository<Users, Long> {

  @Query(value = "select u from Users u where u.id = :id")
  Optional<Users> findUsersById(@Param("id") Long id);
}
