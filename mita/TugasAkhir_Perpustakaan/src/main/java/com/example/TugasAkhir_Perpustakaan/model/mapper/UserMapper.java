package com.example.TugasAkhir_Perpustakaan.model.mapper;

import com.example.TugasAkhir_Perpustakaan.model.User;
import com.example.TugasAkhir_Perpustakaan.model.dto.RegistrationDto;
import com.example.TugasAkhir_Perpustakaan.model.dto.UserDto;
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

    RegistrationDto toRegistrationDto(User e);

    User toUserFromRegistrationDto(RegistrationDto e);
}
