package com.snake.auth.repositories;

import com.snake.auth.entities.UserEntity;
import com.snake.auth.enums.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findFirstByUserType(UserType userType);

    Optional<UserEntity> findByUsername(String username);
}
