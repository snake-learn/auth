package com.snake.auth.controllers.dtos.responses;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import io.swagger.v3.oas.annotations.media.Schema; // add import

/**
 * DTO đại diện cho phản hồi đăng nhập trả về cho client.
 * <p>
 * Chứa token xác thực, tên người dùng và thời gian hết hạn token.
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Schema(description = "DTO đại diện cho phản hồi đăng nhập trả về cho client. Chứa token xác thực, tên người dùng và thời gian hết hạn token.")
public class LoginResponse {

    /**
     * Token xác thực JWT trả về sau khi đăng nhập thành công.
     */
    @Schema(description = "Token xác thực JWT trả về sau khi đăng nhập thành công.", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...")
    String token;

    /**
     * Tên đăng nhập của người dùng.
     */
    @Schema(description = "Tên đăng nhập của người dùng.", example = "user123")
    String username;

    /**
     * Thời gian hết hạn của token (epoch seconds).
     */
    @Schema(description = "Thời gian hết hạn của token (epoch seconds).", example = "1718000000")
    Long exp;
}
