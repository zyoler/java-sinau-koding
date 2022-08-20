package com.example.demo.models.mapper;

import com.example.demo.models.Supplier;
import com.example.demo.models.dto.SupplierDto;
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
