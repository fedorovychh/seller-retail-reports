package com.app.sellerretailreports.dto.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UserLoginRequestDto {
    @NotBlank
    private String email;
    @NotBlank
    @Length(min = 8, max = 35, message = "should be between 8 and 35 letters and symbols")
    private String password;
}
