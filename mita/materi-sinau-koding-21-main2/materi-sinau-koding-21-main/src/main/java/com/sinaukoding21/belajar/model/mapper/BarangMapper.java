package com.sinaukoding21.belajar.model.mapper;

import com.sinaukoding21.belajar.model.Barang;
import com.sinaukoding21.belajar.model.dto.BarangDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BarangMapper {
    BarangMapper INSTANCE = Mappers.getMapper(BarangMapper.class);

    Barang toEntity(BarangDto e);

    BarangDto toDto(Barang e);

    List<BarangDto> toDtoList(List<Barang> e);

}
