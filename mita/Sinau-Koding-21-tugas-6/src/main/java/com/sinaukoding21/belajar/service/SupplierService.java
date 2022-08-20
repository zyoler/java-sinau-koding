package com.sinaukoding21.belajar.service;

import com.sinaukoding21.belajar.model.Supplier;
import com.sinaukoding21.belajar.repositoy.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    @Autowired
    SupplierRepository supplierRepository;

    public List<Supplier> findAllSupplier(){
        return supplierRepository.findAll();
    }
    public Supplier createSupplier(Supplier param){
        return supplierRepository.save(param);
    }
    public  void deleteSupplier(int id){
        Supplier data = supplierRepository.findById(id).orElseThrow(null);
        supplierRepository.delete(data);
    }
    public Supplier updateSupplier(int id, Supplier supplier){
        Supplier data = supplierRepository.findById(id).orElseThrow(null);
        data.setNama_supplier(supplier.getNama_supplier()!=null?supplier.getNama_supplier(): data.getNama_supplier());
        data.setAlamat(supplier.getAlamat()!=null?supplier.getAlamat(): data.getAlamat());
        data.setNo_telp(supplier.getNo_telp()!=null?supplier.getNo_telp():data.getNo_telp());

        return supplierRepository.save(data);
    }
}
