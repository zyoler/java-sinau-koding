package com.example.TugasAkhir_Perpustakaan.model.mapper;

import com.example.TugasAkhir_Perpustakaan.model.Petugas;
import com.example.TugasAkhir_Perpustakaan.model.dto.PetugasDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PetugasMapper {
    PetugasMapper INSTANCE = Mappers.getMapper(PetugasMapper.class);

    Petugas toEntity(PetugasDto e);

    PetugasDto toDto(Petugas e);

    List<Petugas> toEntityList(List<PetugasDto> e);

    List<PetugasDto> toDtoList(List<Petugas> e);
}
