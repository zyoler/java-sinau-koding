package com.example.demo.service;

import com.example.demo.models.Supplier;
import com.example.demo.models.dto.SupplierDto;
import com.example.demo.models.mapper.SupplierMapper;
import com.example.demo.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class SupplierService {
    @Autowired
    SupplierRepository supplierRepository;

    public List<SupplierDto> findAll(){
        return SupplierMapper.INSTANCE.toDtoList(supplierRepository.findAll());
    }

    public SupplierDto createSupplier(SupplierDto param){
        return SupplierMapper.INSTANCE.toDto(supplierRepository.save(SupplierMapper.INSTANCE.toEntitiy(param)));
    }

    public SupplierDto findById(Integer id){
        return SupplierMapper.INSTANCE.toDto(supplierRepository.findById(id).orElseThrow(null));
    }

    public void deleteSupplier(Integer id){
        Supplier supplier = supplierRepository.findById(id).orElseThrow(null);
        supplierRepository.delete(supplier);
    }

    public void deleteAllSupplier(){
        supplierRepository.deleteAll();
    }

    public Supplier updateSupplier(Integer id, Supplier supplier){
        Supplier data = supplierRepository.findById(id).orElseThrow(null);
        data.setAlamat(supplier.getAlamat());
        data.setNama_supplier(supplier.getNama_supplier());
        data.setBarangList(supplier.getBarangList());
        data.setNo_telp(supplier.getNo_telp());
        return supplierRepository.save(data);
    }
}
