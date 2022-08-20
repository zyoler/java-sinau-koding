package com.sinaukoding21.belajar.model.mapper;

import com.sinaukoding21.belajar.model.Supplier;
import com.sinaukoding21.belajar.model.dto.SupplierDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SupplierMapper {
    SupplierMapper INSTANCE = Mappers.getMapper(SupplierMapper.class);

    Supplier toEntitiy(SupplierDto e);

    SupplierDto toDto(Supplier e);

    List<SupplierDto> toDtoList(List<Supplier> e);
}
