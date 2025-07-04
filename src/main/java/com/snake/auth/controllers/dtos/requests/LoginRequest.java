package com.snake.auth.controllers.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import io.swagger.v3.oas.annotations.media.Schema; // add import

/**
 * DTO đại diện cho yêu cầu đăng nhập của người dùng.
 * <p>
 * Class này chứa thông tin tên đăng nhập và mật khẩu được gửi từ client khi thực hiện đăng nhập.
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Schema(description = "DTO đại diện cho yêu cầu đăng nhập của người dùng. Chứa thông tin tên đăng nhập và mật khẩu được gửi từ client khi thực hiện đăng nhập.")
public class LoginRequest {

    /**
     * Tên đăng nhập của người dùng.
     */
    @NotBlank
    @Schema(description = "Tên đăng nhập của người dùng.", example = "user123")
    String username;

    /**
     * Mật khẩu của người dùng.
     */
    @NotBlank
    @Schema(description = "Mật khẩu của người dùng.", example = "password123")
    String password;
}
