package com.snake.auth.entities;

import com.snake.common.entities.AuditEntity;
import com.snake.common.enums.AppState;
import com.snake.common.enums.converters.jakarta.AppStateConverter;
import com.snake.auth.enums.UserType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.SuperBuilder;

/**
 * Thực thể đại diện cho bảng "users" trong cơ sở dữ liệu.
 * <p>
 * Class này lưu trữ thông tin người dùng, bao gồm trạng thái, thông tin đăng nhập,
 * và các thuộc tính khác liên quan đến người dùng.
 * <p>
 * Kế thừa từ {@link AuditEntity} để bao gồm các thông tin về thời gian tạo và cập nhật.
 */
@Getter
@Setter
@Entity
@Table(name = "users")
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntity extends AuditEntity {

    /**
     * ID của người dùng, là khóa chính trong bảng "users".
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    /**
     * Trạng thái của người dùng, sử dụng enum {@link AppState}.
     * <p>
     * Mặc định là {@link AppState#ACTIVE}.
     */
    @Builder.Default
    @Convert(converter = AppStateConverter.class)
    @Column(name = "state", columnDefinition = "INTEGER DEFAULT 0")
    AppState state = AppState.ACTIVE;

    /**
     * Cờ đánh dấu người dùng có bị ẩn hay không.
     * <p>
     * Mặc định là {@code false}.
     */
    @Builder.Default
    @Column(name = "is_hidden", columnDefinition = "BOOLEAN DEFAULT false")
    Boolean isHidden = Boolean.FALSE;

    /**
     * Cờ đánh dấu người dùng có bị xóa hay không.
     * <p>
     * Mặc định là {@code false}.
     */
    @Builder.Default
    @Column(name = "is_deleted", columnDefinition = "BOOLEAN DEFAULT false")
    Boolean isDeleted = Boolean.FALSE;

    /**
     * Tên đăng nhập của người dùng.
     * <p>
     * Thuộc tính này là bắt buộc.
     */
    @Column(name = "username", nullable = false)
    String username;

    /**
     * Mật khẩu của người dùng.
     * <p>
     * Thuộc tính này là bắt buộc.
     */
    @Column(name = "password", nullable = false)
    String password;

    /**
     * Loại hình đăng nhập của người dùng, sử dụng enum {@link UserType}.
     * <p>
     * Mặc định là {@link UserType#MEMBER}.
     */
    @Builder.Default
    @Column(name = "user_type", columnDefinition = "TINYINT DEFAULT 1")
    UserType userType = UserType.MEMBER;
}
