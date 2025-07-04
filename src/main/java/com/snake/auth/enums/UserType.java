package com.snake.auth.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.snake.common.enums.AppState;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * Enum đại diện cho các loại người dùng trong hệ thống.
 * <ul>
 *     <li>ADMIN: Quản trị viên</li>
 *     <li>MEMBER: Thành viên thông thường</li>
 *     <li>TEST: Người dùng thử nghiệm</li>
 *     <li>GOOGLE: Người dùng đăng nhập qua Google</li>
 * </ul>
 */
@Getter
@AllArgsConstructor
public enum UserType {
    /**
     * Quản trị viên.
     */
    ADMIN(0, "USER_TYPE.ADMIN"),
    /**
     * Thành viên thông thường.
     */
    MEMBER(1, "USER_TYPE.MEMBER"),
    /**
     * Người dùng thử nghiệm.
     */
    TEST(2, "USER_TYPE.TEST"),
    /**
     * Người dùng đăng nhập qua Google.
     */
    GOOGLE(3, "USER_TYPE.GOOGLE"),
    ;

    /**
     * Giá trị số đại diện cho loại người dùng.
     */
    private final int key;
    /**
     * Tên mã hóa của loại người dùng.
     */
    private final String codeName;

    /**
     * Lấy {@link UserType} dựa trên giá trị số.
     *
     * @param data giá trị số của loại người dùng
     * @return {@link UserType} tương ứng
     * @throws IllegalArgumentException nếu không tìm thấy loại phù hợp
     */
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static UserType of(int data) {
        return Stream.of(values())
                .filter(s -> Objects.equals(s.getKey(), data))
                .findFirst()
                .orElseThrow(
                        () -> new IllegalArgumentException(String.format(
                                "Invalid %s: %s",
                                AppState.class.getSimpleName(),
                                data
                        ))
                );
    }

    /**
     * Lấy giá trị số đại diện cho loại người dùng.
     *
     * @return giá trị số của loại người dùng
     */
    @JsonValue
    public int getKey() {
        return this.key;
    }
}
