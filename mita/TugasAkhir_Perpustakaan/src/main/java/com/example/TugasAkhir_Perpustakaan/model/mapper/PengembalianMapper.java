package com.example.TugasAkhir_Perpustakaan.model.mapper;

import com.example.TugasAkhir_Perpustakaan.model.Pengembalian;
import com.example.TugasAkhir_Perpustakaan.model.dto.PengembalianDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PengembalianMapper {
    PengembalianMapper INSTANCE = Mappers.getMapper(PengembalianMapper.class);

    Pengembalian toEntity(PengembalianDto e);

    PengembalianDto toDto(Pengembalian e);

    List<Pengembalian> toEntityList(List<PengembalianDto> e);

    List<PengembalianDto> toDtoList(List<Pengembalian> e);
}
