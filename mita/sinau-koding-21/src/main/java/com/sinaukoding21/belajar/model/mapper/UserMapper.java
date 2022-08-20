package com.sinaukoding21.belajar.model.mapper;

import com.sinaukoding21.belajar.model.User;
import com.sinaukoding21.belajar.model.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toEntity(UserDto e);

    UserDto toDto(User e);

    List<User> toEntityList(List<UserDto> e);

    List<UserDto> toDtoList(List<User> e);
}
