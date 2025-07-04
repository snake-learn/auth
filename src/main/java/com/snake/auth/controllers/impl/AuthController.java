package com.snake.auth.controllers.impl;

import com.snake.common.dtos.wrappers.AppResponse;
import com.snake.auth.controllers.AuthApi;
import com.snake.auth.controllers.dtos.requests.LoginRequest;
import com.snake.auth.controllers.dtos.responses.LoginResponse;
import com.snake.auth.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController implements AuthApi {

    private final AuthService authService;

    @Override
    public AppResponse<LoginResponse> login(LoginRequest request) {
        return AppResponse.ok(authService.login(request));
    }
}
