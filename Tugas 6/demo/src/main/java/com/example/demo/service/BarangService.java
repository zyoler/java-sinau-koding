package com.example.demo.service;

import com.example.demo.models.Barang;
import com.example.demo.repository.BarangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarangService {
    @Autowired
    BarangRepository barangRepository;

    public List<Barang> findAllBarang(){
        return barangRepository.findAll();
    }

    public Barang createBarang(Barang param){
        return barangRepository.save(param);
    }

    public Barang getBarangById(int id){
        Barang barang = barangRepository.findById(id).orElseThrow(null);
        return barang;
    }

    public void deleteBarang(int id){
        Barang barang = barangRepository.findById(id).orElseThrow(null);
        barangRepository.delete(barang);
    }

    public Barang updateBarang(int id, Barang barang){
        Barang data = barangRepository.findById(id).orElseThrow(null);
        data.setNama_barang(barang.getNama_barang() == null ? data.getNama_barang() : barang.getNama_barang());
        data.setHarga(barang.getHarga() == null ? data.getHarga() :  barang.getHarga());
        data.setStok(barang.getStok() == null ? data.getStok() :  barang.getStok());
        data.setSupplier(barang.getSupplier() == null ? data.getSupplier() :  barang.getSupplier());
        return barangRepository.save(data);
    }
}
