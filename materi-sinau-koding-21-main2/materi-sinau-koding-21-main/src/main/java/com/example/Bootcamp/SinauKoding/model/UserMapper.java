package com.example.Bootcamp.SinauKoding.model;

import com.example.Bootcamp.SinauKoding.model.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toEntity (UserDto dto);

    UserDto toDto (User data);

    List<UserDto> toListDto(List<User> list);

    List<User> toListUser(List<UserDto> list);
}
