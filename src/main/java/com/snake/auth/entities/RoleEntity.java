package com.snake.auth.entities;

import com.snake.common.entities.AuditEntity;
import com.snake.common.enums.AppState;
import com.snake.common.enums.converters.jakarta.AppStateConverter;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.SuperBuilder;

/**
 * Thực thể đại diện cho bảng "roles" trong cơ sở dữ liệu.
 * <p>
 * Class này lưu trữ thông tin về vai trò (role) trong hệ thống, bao gồm trạng thái,
 * tên vai trò, và mô tả vai trò.
 * <p>
 * Kế thừa từ {@link AuditEntity} để bao gồm các thông tin về thời gian tạo và cập nhật.
 */
@Getter
@Setter
@Entity
@Table(name = "roles")
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleEntity extends AuditEntity {

    /**
     * ID của vai trò, là khóa chính trong bảng "roles".
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    /**
     * Trạng thái của vai trò, sử dụng enum {@link AppState}.
     * <p>
     * Mặc định là {@link AppState#ACTIVE}.
     */
    @Builder.Default
    @Convert(converter = AppStateConverter.class)
    @Column(name = "state", columnDefinition = "INTEGER DEFAULT 0")
    AppState state = AppState.ACTIVE;

    /**
     * Cờ đánh dấu vai trò có bị ẩn hay không.
     * <p>
     * Mặc định là {@code false}.
     */
    @Builder.Default
    @Column(name = "is_hidden", columnDefinition = "BOOLEAN DEFAULT false")
    Boolean isHidden = Boolean.FALSE;

    /**
     * Cờ đánh dấu vai trò có bị xóa hay không.
     * <p>
     * Mặc định là {@code false}.
     */
    @Builder.Default
    @Column(name = "is_deleted", columnDefinition = "BOOLEAN DEFAULT false")
    Boolean isDeleted = Boolean.FALSE;

    /**
     * Tên của vai trò, là giá trị duy nhất để nhận diện vai trò trong hệ thống.
     * <p>
     * Thuộc tính này là bắt buộc.
     */
    @Column(name = "name", nullable = false, unique = true)
    String name;

    /**
     * Mô tả vai trò, cung cấp thông tin chi tiết về vai trò.
     * <p>
     * Thuộc tính này là bắt buộc.
     */
    @Column(name = "des", nullable = false, unique = true)
    String des;
}
