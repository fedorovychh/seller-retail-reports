package com.app.sellerretailreports.dto.user;

import com.app.sellerretailreports.validation.FieldMatch;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@FieldMatch
public class UserRegisterRequestDto {
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Length(min = 8, max = 35, message = "should be between 8 and 35 letters and symbols")
    private String password;
    @NotBlank
    @Length(min = 8, max = 35, message = "should be between 8 and 35 letters and symbols")
    private String repeatPassword;
    @NotBlank
    @Length(min = 2, max = 35, message = "should be between 2 and 35 letters")
    private String firstName;
    @NotBlank
    @Length(min = 2, max = 35, message = "should be between 2 and 35 letters")
    private String lastName;
}
