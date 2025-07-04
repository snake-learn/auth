package com.snake.auth.controllers;

import com.snake.common.dtos.wrappers.AppResponse;
import com.snake.auth.controllers.dtos.requests.LoginRequest;
import com.snake.auth.controllers.dtos.responses.LoginResponse;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Validated
@RequestMapping("/auth")
@Tag(name = "Authentication", description = "APIs liên quan đến xác thực người dùng") // add tag for controller
public interface AuthApi {
    @PostMapping("/login")
    @Operation(
        summary = "Đăng nhập",
        description = "API cho phép người dùng đăng nhập vào hệ thống bằng tên đăng nhập và mật khẩu.",
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Thông tin đăng nhập của người dùng",
            required = true
        ),
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Đăng nhập thành công, trả về token và thông tin người dùng"
            ),
            @ApiResponse(
                responseCode = "400",
                description = "Yêu cầu không hợp lệ"
            ),
            @ApiResponse(
                responseCode = "401",
                description = "Sai tên đăng nhập hoặc mật khẩu"
            )
        }
    )
    AppResponse<LoginResponse> login(@Valid @RequestBody LoginRequest request);
}
