package com.app.sellerretailreports.mapper;

import com.app.sellerretailreports.dto.user.UserRegisterRequestDto;
import com.app.sellerretailreports.dto.user.UserRegisterResponseDto;
import com.app.sellerretailreports.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    UserRegisterResponseDto toDto(User user);

    User toUser(UserRegisterRequestDto requestDto);
}
