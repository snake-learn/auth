package com.snake.auth.entities;

import com.snake.common.entities.AuditEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.SuperBuilder;

/**
 * Thực thể đại diện cho bảng "role_permission_rel" trong cơ sở dữ liệu.
 * <p>
 * Class này lưu trữ mối quan hệ giữa vai trò (role) và quyền (permission) trong hệ thống.
 * <p>
 * Kế thừa từ {@link AuditEntity} để bao gồm các thông tin về thời gian tạo và cập nhật.
 */
@Getter
@Setter
@Entity
@Table(name = "role_permission_rel")
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RolePermissionEntity extends AuditEntity {

    /**
     * ID của mối quan hệ, là khóa chính trong bảng "role_permission_rel".
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
     * ID của vai trò (role) liên kết với quyền.
     * <p>
     * Thuộc tính này là bắt buộc.
     */
    @Column(name = "role_id", nullable = false)
    Long roleId;

    /**
     * ID của quyền (permission) liên kết với vai trò.
     * <p>
     * Thuộc tính này là bắt buộc.
     */
    @Column(name = "permission_id", nullable = false)
    Long permissionId;
}
