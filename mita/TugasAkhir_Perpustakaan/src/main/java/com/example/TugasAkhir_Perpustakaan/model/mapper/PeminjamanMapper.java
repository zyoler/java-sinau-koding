package com.example.TugasAkhir_Perpustakaan.model.mapper;

import com.example.TugasAkhir_Perpustakaan.model.Peminjaman;
import com.example.TugasAkhir_Perpustakaan.model.dto.PeminjamanDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PeminjamanMapper {
    PeminjamanMapper INSTANCE = Mappers.getMapper(PeminjamanMapper.class);

    Peminjaman toEntity(PeminjamanDto e);

    PeminjamanDto toDto(Peminjaman e);

    List<Peminjaman> toEntityList(List<PeminjamanDto> e);

    List<PeminjamanDto> toDtoList(List<Peminjaman> e);
}
