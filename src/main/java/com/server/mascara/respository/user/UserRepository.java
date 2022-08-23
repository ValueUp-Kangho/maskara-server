package com.server.mascara.respository.user;

import com.server.mascara.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByusername(String username);
}
