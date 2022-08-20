package com.example.TugasAkhir_Perpustakaan.model.mapper;

import com.example.TugasAkhir_Perpustakaan.model.Buku;
import com.example.TugasAkhir_Perpustakaan.model.dto.BukuDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BukuMapper {
    BukuMapper INSTANCE = Mappers.getMapper(BukuMapper.class);

    Buku toEntity(BukuDto e);

    BukuDto toDto(Buku e);

    List<Buku> toEntityList(List<BukuDto> e);

    List<BukuDto> toDtoList(List<Buku> e);
}
