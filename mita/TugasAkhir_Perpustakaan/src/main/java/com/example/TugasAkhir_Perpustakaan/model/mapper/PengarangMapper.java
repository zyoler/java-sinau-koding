package com.example.TugasAkhir_Perpustakaan.model.mapper;

import com.example.TugasAkhir_Perpustakaan.model.Pengarang;
import com.example.TugasAkhir_Perpustakaan.model.dto.PengarangDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PengarangMapper {
    PengarangMapper INSTANCE = Mappers.getMapper(PengarangMapper.class);

    Pengarang toEntity(PengarangDto e);

    PengarangDto toDto(Pengarang e);

    List<Pengarang> toEntityList(List<PengarangDto> e);

    List<PengarangDto> toDtoList(List<Pengarang> e);
}
