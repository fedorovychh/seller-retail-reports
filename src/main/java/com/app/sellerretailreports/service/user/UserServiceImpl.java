package com.app.sellerretailreports.service.user;

import com.app.sellerretailreports.dto.user.UserRegisterRequestDto;
import com.app.sellerretailreports.dto.user.UserRegisterResponseDto;
import com.app.sellerretailreports.entity.User;
import com.app.sellerretailreports.exception.RegistrationException;
import com.app.sellerretailreports.mapper.UserMapper;
import com.app.sellerretailreports.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserRegisterResponseDto register(UserRegisterRequestDto requestDto)
            throws RegistrationException {
        if (userRepository.findByEmail(requestDto.getEmail()).isPresent()) {
            throw new RegistrationException(String.format(
                    "Can't register user with email %s", requestDto.getEmail())
            );
        }
        User user = userMapper.toUser(requestDto);
        user.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        return userMapper.toDto(userRepository.save(user));
    }
}
