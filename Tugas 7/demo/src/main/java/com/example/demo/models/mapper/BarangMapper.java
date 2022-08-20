package com.example.demo.models.mapper;


import com.example.demo.models.Barang;
import com.example.demo.models.dto.BarangDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BarangMapper {
    BarangMapper INSTANCE = Mappers.getMapper(BarangMapper.class);

    Barang toEntity(BarangDto e);

    BarangDto toDto(Barang e);

    List<Barang> toEntityList(List<BarangDto> e);

    List<BarangDto> toDtoList(List<Barang> e);
}
