package com.example.TugasAkhir_Perpustakaan.model.mapper;

import com.example.TugasAkhir_Perpustakaan.model.Anggota;
import com.example.TugasAkhir_Perpustakaan.model.dto.AnggotaDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AnggotaMapper {
    AnggotaMapper INSTANCE = Mappers.getMapper(AnggotaMapper.class);

    Anggota toEntity(AnggotaDto e);

    AnggotaDto toDto(Anggota e);

    List<Anggota> toEntityList(List<AnggotaDto> e);

    List<AnggotaDto> toDtoList(List<Anggota> e);
}
