package com.example.demo.service;

import com.example.demo.models.Barang;
import com.example.demo.models.dto.BarangDto;
import com.example.demo.models.mapper.BarangMapper;
import com.example.demo.repository.BarangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarangService {
    @Autowired
    BarangRepository barangRepository;

    public List<BarangDto> findAllBarang(){
        return BarangMapper.INSTANCE.toDtoList(barangRepository.findAll());
    }

    public BarangDto createBarang(BarangDto param){
        Barang barang = BarangMapper.INSTANCE.toEntity(param);
        return BarangMapper.INSTANCE.toDto(barangRepository.save(barang));
    }

    public BarangDto getBarangById(int id){
        Barang barang = barangRepository.findById(id).orElseThrow(null);
        return BarangMapper.INSTANCE.toDto(barang);
    }

    public boolean deleteBarang(int id){
        Barang barang = barangRepository.findById(id).orElseThrow(null);
        try{
            barangRepository.delete(barang);
            return  true;
        } catch (Exception e){
            return false;
        }
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
