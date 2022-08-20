package com.example.demo.models.mapper;

import com.example.demo.models.Transaksi;
import com.example.demo.models.dto.TransaksiDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TransaksiMapper {
    TransaksiMapper INSTANCE = Mappers.getMapper(TransaksiMapper.class);

    Transaksi toEntitiy(TransaksiDto e);
    TransaksiDto toDto(Transaksi e);

    List<TransaksiDto> toDtoList(List<Transaksi> e);
}
