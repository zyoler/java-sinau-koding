package com.sinaukoding21.belajar.model.mapper;

import com.sinaukoding21.belajar.model.Pembeli;
import com.sinaukoding21.belajar.model.dto.PembeliDto;
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
