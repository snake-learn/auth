package com.snake.auth.inits;

import com.snake.auth.entities.UserEntity;
import com.snake.auth.enums.UserType;
import com.snake.auth.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class UserInit implements ApplicationRunner {

    @Value("${app.admin.username:admin}")
    private String adminUsername;
    @Value("${app.admin.password:Admin@123456}")
    private String adminPassword;

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) {
        this.initAdminUser();
    }

    private void initAdminUser() {
        val user = userRepository.findFirstByUserType(UserType.ADMIN);

        if (Objects.nonNull(user)) {
            return;
        }

        val password = passwordEncoder.encode(adminPassword);
        val adminUser = UserEntity.builder()
                .username(adminUsername)
                .password(password)
                .userType(UserType.ADMIN)
                .build();
        userRepository.save(adminUser);
    }

}
