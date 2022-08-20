package com.sinaukoding21.belajar.model.mapper;

import com.sinaukoding21.belajar.model.Admin;
import com.sinaukoding21.belajar.model.dto.AdminDto;
import com.sinaukoding21.belajar.model.dto.RegistrationDto;
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
