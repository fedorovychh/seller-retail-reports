package com.app.sellerretailreports.security;

import com.app.sellerretailreports.dto.user.UserLoginRequestDto;
import com.app.sellerretailreports.dto.user.UserLoginResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public UserLoginResponseDto authenticate(UserLoginRequestDto requestDto) {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(requestDto.getEmail(), requestDto.getPassword())
        );

        String generatedToken = jwtUtil.generateToken(authentication.getName());
        UserLoginResponseDto responseDto = new UserLoginResponseDto();
        responseDto.setToken(generatedToken);
        return responseDto;
    }
}
