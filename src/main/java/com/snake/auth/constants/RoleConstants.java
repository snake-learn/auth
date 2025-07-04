package com.snake.auth.constants;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.UtilityClass;

/**
 * Chứa các hằng số liên quan đến vai trò (role) trong hệ thống.
 * <p>
 * Class này cung cấp các giá trị cố định để sử dụng cho việc kiểm tra hoặc gán vai trò cho người dùng.
 */
@UtilityClass
@FieldDefaults(level = AccessLevel.PUBLIC, makeFinal = true)
public class RoleConstants {
    /**
     * Giá trị đại diện cho vai trò quản trị viên (ADMIN).
     */
    String ADMIN = "ADMIN";
}
