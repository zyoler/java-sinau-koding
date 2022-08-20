package com.sinaukoding21.belajar.model.mapper;

import com.sinaukoding21.belajar.model.Transaksi;
import com.sinaukoding21.belajar.model.dto.TransaksiDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TransaksiMapper {
    TransaksiMapper INSTANCE = Mappers.getMapper(TransaksiMapper.class);

    Transaksi toEntity(TransaksiDto e);

    TransaksiDto toDto(Transaksi e);

    List<TransaksiDto> toDtoList(List<Transaksi> e);
}
