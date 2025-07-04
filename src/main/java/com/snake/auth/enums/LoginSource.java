package com.snake.auth.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * Enum đại diện cho các nguồn đăng nhập vào hệ thống.
 * <ul>
 *     <li>DATABASE: Đăng nhập qua cơ sở dữ liệu nội bộ</li>
 *     <li>LDAP: Đăng nhập qua LDAP</li>
 *     <li>GOOGLE: Đăng nhập qua Google</li>
 *     <li>FACEBOOK: Đăng nhập qua Facebook</li>
 *     <li>SSO: Đăng nhập qua Single Sign-On</li>
 * </ul>
 */
@Getter
@AllArgsConstructor
public enum LoginSource {
    /**
     * Đăng nhập qua cơ sở dữ liệu nội bộ.
     */
    DATABASE(1, "LOGIN_SOURCE.DATABASE"),
    /**
     * Đăng nhập qua LDAP.
     */
    LDAP(1, "LOGIN_SOURCE.LDAP"),
    /**
     * Đăng nhập qua Google.
     */
    GOOGLE(1, "LOGIN_SOURCE.GOOGLE"),
    /**
     * Đăng nhập qua Facebook.
     */
    FACEBOOK(1, "LOGIN_SOURCE.FACEBOOK"),
    /**
     * Đăng nhập qua Single Sign-On.
     */
    SSO(1, "LOGIN_SOURCE.SSO"),
    ;

    /**
     * Giá trị số đại diện cho nguồn đăng nhập.
     */
    private final int key;
    /**
     * Tên mã hóa của nguồn đăng nhập.
     */
    private final String codeName;

    /**
     * Lấy {@link LoginSource} dựa trên giá trị số.
     *
     * @param data giá trị số của nguồn đăng nhập
     * @return {@link LoginSource} tương ứng
     * @throws IllegalArgumentException nếu không tìm thấy nguồn phù hợp
     */
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static LoginSource of(int data) {
        return Stream.of(values())
                .filter(s -> Objects.equals(s.getKey(), data))
                .findFirst()
                .orElseThrow(
                        () -> new IllegalArgumentException(String.format(
                                "Invalid %s: %s",
                                LoginSource.class.getSimpleName(),
                                data
                        ))
                );
    }

    /**
     * Lấy giá tr�� số đại diện cho nguồn đăng nhập.
     *
     * @return giá trị số của nguồn đăng nhập
     */
    @JsonValue
    public int getKey() {
        return this.key;
    }
}
