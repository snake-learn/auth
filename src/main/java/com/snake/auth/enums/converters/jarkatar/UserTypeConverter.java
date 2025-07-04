package com.snake.auth.enums.converters.jarkatar;

import com.snake.auth.enums.UserType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * Bộ chuyển đổi giữa enum {@link UserType} và giá trị số trong cơ sở dữ liệu.
 * <p>
 * Dùng cho JPA để tự động chuyển đổi khi lưu và truy vấn dữ liệu.
 */
@Slf4j
@Converter(autoApply = true)
public class UserTypeConverter implements AttributeConverter<UserType, Integer> {

    /**
     * Chuyển đổi từ {@link UserType} sang giá trị số để lưu vào cơ sở dữ liệu.
     *
     * @param att giá trị enum UserType
     * @return giá trị s�� tương ứng hoặc null nếu giá trị truyền vào là null
     */
    @Override
    public Integer convertToDatabaseColumn(UserType att) {
        if (Objects.isNull(att)) {
            return null;
        }

        return att.getKey();
    }

    /**
     * Chuyển đổi từ giá trị số trong cơ sở dữ liệu sang {@link UserType}.
     *
     * @param dbData giá trị số lấy từ cơ sở dữ liệu
     * @return giá trị enum UserType tương ứng hoặc null nếu không hợp lệ hoặc null
     */
    @Override
    public UserType convertToEntityAttribute(Integer dbData) {
        if (Objects.isNull(dbData)) {
            return null;
        }

        try {
            return UserType.of(dbData);
        } catch (IllegalArgumentException e) {
            log.error("LoginTypeConverter error when convert: mess {}", e.getMessage(), e);
            return null;
        }
    }
}
