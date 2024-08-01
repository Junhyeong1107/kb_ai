package com.example.sanback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.example.sanback.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserid(String userid);
}
