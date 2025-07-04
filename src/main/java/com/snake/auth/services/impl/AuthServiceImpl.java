package com.snake.auth.services.impl;

import com.snake.common.securities.AppJwtTokenProvider;
import com.snake.common.securities.AppUserDetails;
import com.snake.auth.controllers.dtos.requests.LoginRequest;
import com.snake.auth.controllers.dtos.responses.LoginResponse;
import com.snake.auth.repositories.UserRepository;
import com.snake.auth.services.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AppJwtTokenProvider jwtTokenProvider;

    // <editor-fold desc="LOGIN METHODS">
    @Override
    public LoginResponse login(LoginRequest request) {


        return null;
    }

    private LoginResponse loginDatabase(LoginRequest request) {
        val user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        val isNotSamePassword = !passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        );

        if (isNotSamePassword) {
            throw new RuntimeException("Password does not match");
        }

        val token = jwtTokenProvider.genToken(() -> {
            return AppUserDetails.builder()
                    .sub(String.valueOf(user.getId()))
                    .username(user.getUsername())
                    .build();
        });
        return null;
    }

    private LoginResponse loginGoogle(LoginRequest request) {
        return null;
    }
    // </editor-fold>

}
