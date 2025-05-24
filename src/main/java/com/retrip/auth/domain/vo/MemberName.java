package com.retrip.auth.domain.vo;

import com.retrip.auth.domain.exception.common.InvalidValueException;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
public class MemberName {
    private static final int NAME_LENGTH_LIMIT = 10;

    @Column(name = "name", nullable = false, length = NAME_LENGTH_LIMIT)
    private String value;

    public MemberName(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        if (value.length() > NAME_LENGTH_LIMIT) {
            throw new InvalidValueException("유저 이름은 " + NAME_LENGTH_LIMIT + "자를 넘을 수 없습니다.");
        }
    }

}
