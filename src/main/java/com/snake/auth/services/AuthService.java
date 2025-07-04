package com.snake.auth.services;

import com.snake.auth.controllers.dtos.requests.LoginRequest;
import com.snake.auth.controllers.dtos.responses.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest request);
}
