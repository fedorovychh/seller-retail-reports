package com.app.sellerretailreports.service.user;

import com.app.sellerretailreports.dto.user.UserRegisterRequestDto;
import com.app.sellerretailreports.dto.user.UserRegisterResponseDto;
import com.app.sellerretailreports.exception.RegistrationException;

public interface UserService {
    UserRegisterResponseDto register(UserRegisterRequestDto requestDto) throws RegistrationException;
}
