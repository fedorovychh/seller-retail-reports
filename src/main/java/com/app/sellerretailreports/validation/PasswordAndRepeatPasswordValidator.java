package com.app.sellerretailreports.validation;

import com.app.sellerretailreports.dto.user.UserRegisterRequestDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Objects;

public class PasswordAndRepeatPasswordValidator implements
        ConstraintValidator<FieldMatch, UserRegisterRequestDto> {
    @Override
    public boolean isValid(UserRegisterRequestDto requestDto,
                           ConstraintValidatorContext constraintValidatorContext) {
        return Objects.equals(requestDto.getPassword(), requestDto.getRepeatPassword());
    }
}
