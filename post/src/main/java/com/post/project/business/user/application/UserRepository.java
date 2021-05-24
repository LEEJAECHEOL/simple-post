package com.post.project.business.user.application;

import com.post.project.business.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

  @Query(value = "select count(*) from user where username = :username", nativeQuery = true)
  int findByUsername(String username);
}
