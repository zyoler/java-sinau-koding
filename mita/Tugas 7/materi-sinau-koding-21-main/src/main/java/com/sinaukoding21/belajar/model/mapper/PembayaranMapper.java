package com.sinaukoding21.belajar.model.mapper;

import com.sinaukoding21.belajar.model.Pembayaran;
import com.sinaukoding21.belajar.model.dto.PembayaranDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PembayaranMapper {
    PembayaranMapper INSTANCE = Mappers.getMapper(PembayaranMapper.class);

    Pembayaran toEntitiy(PembayaranDto e);

    PembayaranDto toDto(Pembayaran e);

    List<Pembayaran> toEntityList(List<PembayaranDto> e);

    List<PembayaranDto> toDtoList(List<Pembayaran> e);
}
