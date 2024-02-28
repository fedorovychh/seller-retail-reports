package com.app.sellerretailreports.controller;

import com.app.sellerretailreports.dto.user.UserLoginRequestDto;
import com.app.sellerretailreports.dto.user.UserLoginResponseDto;
import com.app.sellerretailreports.dto.user.UserRegisterRequestDto;
import com.app.sellerretailreports.dto.user.UserRegisterResponseDto;
import com.app.sellerretailreports.exception.RegistrationException;
import com.app.sellerretailreports.security.AuthenticationService;
import com.app.sellerretailreports.service.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/auth")
public class AuthenticationController {
    private final UserService userService;
    private final AuthenticationService authenticationService;

    @PostMapping(value = "/login")
    public UserLoginResponseDto login(@RequestBody @Valid UserLoginRequestDto requestDto) {
        return authenticationService.authenticate(requestDto);
    }

    @PostMapping(value = "/register")
    public UserRegisterResponseDto register(@RequestBody @Valid UserRegisterRequestDto requestDto)
            throws RegistrationException {
        return userService.register(requestDto);
    }
}
