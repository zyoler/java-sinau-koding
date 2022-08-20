package com.example.demo.service;

import com.example.demo.models.Supplier;
import com.example.demo.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class SupplierService {
    @Autowired
    SupplierRepository supplierRepository;

    public List<Supplier> findAll(){
        return supplierRepository.findAll();
    }

    public Supplier createSupplier(Supplier param){
        return supplierRepository.save(param);
    }

    public Supplier findById(Integer id){
        return supplierRepository.findById(id).orElseThrow(null);
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
