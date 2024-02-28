package com.app.sellerretailreports.controller;

import com.app.sellerretailreports.dto.user.UserLoginRequestDto;
import com.app.sellerretailreports.dto.user.UserLoginResponseDto;
import com.app.sellerretailreports.dto.user.UserRegisterRequestDto;
import com.app.sellerretailreports.dto.user.UserRegisterResponseDto;
import com.app.sellerretailreports.exception.RegistrationException;
import com.app.sellerretailreports.security.AuthenticationService;
import com.app.sellerretailreports.service.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/auth")
@Tag(name = "Authentication management",
        description = "Endpoints for managing authentication.")
public class AuthenticationController {
    private final UserService userService;
    private final AuthenticationService authenticationService;

    @PostMapping(value = "/login")
    @Operation(summary = "Login")
    public UserLoginResponseDto login(@RequestBody @Valid UserLoginRequestDto requestDto) {
        return authenticationService.authenticate(requestDto);
    }

    @PostMapping(value = "/register")
    @Operation(summary = "Register")
    public UserRegisterResponseDto register(@RequestBody @Valid UserRegisterRequestDto requestDto)
            throws RegistrationException {
        return userService.register(requestDto);
    }
}
