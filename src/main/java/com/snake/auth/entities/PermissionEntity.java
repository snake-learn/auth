package com.snake.auth.entities;

import com.snake.common.enums.AppState;
import com.snake.common.enums.converters.jakarta.AppStateConverter;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.SuperBuilder;

/**
 * Thực thể đại diện cho bảng "permissions" trong cơ sở dữ liệu.
 * <p>
 * Class này lưu trữ thông tin về quyền (permission) trong hệ thống, bao gồm trạng thái,
 * mã quyền, và mô tả quyền.
 */
@Getter
@Setter
@Entity
@Table(name = "permissions")
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PermissionEntity {

    /**
     * ID của quyền, là khóa chính trong bảng "permissions".
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    /**
     * Trạng thái của quyền, sử dụng enum {@link AppState}.
     * <p>
     * Mặc định là {@link AppState#ACTIVE}.
     */
    @Builder.Default
    @Convert(converter = AppStateConverter.class)
    @Column(name = "state", columnDefinition = "INTEGER DEFAULT 0")
    AppState state = AppState.ACTIVE;

    /**
     * Cờ đánh dấu quyền có bị ẩn hay không.
     * <p>
     * Mặc định là {@code false}.
     */
    @Builder.Default
    @Column(name = "is_hidden", columnDefinition = "BOOLEAN DEFAULT false")
    Boolean isHidden = Boolean.FALSE;

    /**
     * Cờ đánh dấu quyền có bị xóa hay không.
     * <p>
     * Mặc định là {@code false}.
     */
    @Builder.Default
    @Column(name = "is_deleted", columnDefinition = "BOOLEAN DEFAULT false")
    Boolean isDeleted = Boolean.FALSE;

    /**
     * Mã quyền, là giá trị duy nhất để nhận diện quyền trong hệ thống.
     * <p>
     * Thuộc tính này là bắt buộc.
     */
    @Column(name = "code", nullable = false, unique = true)
    String code;

    /**
     * Mô tả quyền, cung cấp thông tin chi tiết về quyền.
     * <p>
     * Thuộc tính này là bắt buộc.
     */
    @Column(name = "des", nullable = false, unique = true)
    String des;
}
