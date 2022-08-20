package com.example.TugasAkhir_Perpustakaan.model.mapper;

import com.example.TugasAkhir_Perpustakaan.model.Penerbit;
import com.example.TugasAkhir_Perpustakaan.model.dto.PenerbitDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PenerbitMapper {
    PenerbitMapper INSTANCE = Mappers.getMapper(PenerbitMapper.class);

    Penerbit toEntity(PenerbitDto e);

    PenerbitDto toDto(Penerbit e);

    List<Penerbit> toEntityList(List<PenerbitDto> e);

    List<PenerbitDto> toDtoList(List<Penerbit> e);

}
