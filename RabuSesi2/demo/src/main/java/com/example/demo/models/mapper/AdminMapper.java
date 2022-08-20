package com.example.demo.models.mapper;

import com.example.demo.models.Admin;
import com.example.demo.models.dto.AdminDto;
import com.example.demo.models.dto.RegistrationDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdminMapper {
    AdminMapper INSTANCE = Mappers.getMapper(AdminMapper.class);

    Admin toEntity(AdminDto e);

    AdminDto toDto(Admin e);

    RegistrationDto toRegistrationDto(Admin e);

    Admin toUserFromRegistrationDto(RegistrationDto e);
}
