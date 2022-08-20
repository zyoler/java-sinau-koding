package com.example.demo.models.mapper;

import com.example.demo.models.Pembeli;
import com.example.demo.models.dto.PembeliDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PembeliMapper {
        PembeliMapper INSTANCE = Mappers.getMapper(PembeliMapper.class);

        Pembeli toEntity(PembeliDto e);

        PembeliDto toDto(Pembeli e);

        List<PembeliDto> toDtoList(List<Pembeli> e);
}
