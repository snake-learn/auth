package com.snake.auth.entities;

import com.snake.common.entities.AuditEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.SuperBuilder;

/**
 * Thực thể đại diện cho bảng "user_role_rel" trong cơ sở dữ liệu.
 * <p>
 * Class này lưu trữ mối quan hệ giữa người dùng (user) và vai trò (role) trong hệ thống.
 * <p>
 * Kế thừa từ {@link AuditEntity} để bao gồm các thông tin về thời gian tạo và cập nhật.
 */
@Getter
@Setter
@Entity
@Table(name = "user_role_rel")
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRoleEntity extends AuditEntity {

    /**
     * ID của mối quan hệ, là khóa chính trong bảng "user_role_rel".
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    /**
     * Cờ đánh dấu mối quan hệ có bị xóa hay không.
     * <p>
     * Mặc định là {@code false}.
     */
    @Builder.Default
    @Column(name = "is_deleted", columnDefinition = "BOOLEAN DEFAULT false")
    Boolean isDeleted = Boolean.FALSE;

    /**
     * ID của người dùng (user) liên kết với vai trò.
     * <p>
     * Thuộc tính này là bắt buộc.
     */
    @Column(name = "user_id", nullable = false)
    Long userId;

    /**
     * ID của vai trò (role) liên kết với người dùng.
     * <p>
     * Thuộc tính này là bắt buộc.
     */
    @Column(name = "role_id", nullable = false)
    Long roleId;
}
