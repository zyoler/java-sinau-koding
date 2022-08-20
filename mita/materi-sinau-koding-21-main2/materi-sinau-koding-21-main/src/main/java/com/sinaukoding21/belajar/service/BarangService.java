package com.sinaukoding21.belajar.service;

import com.sinaukoding21.belajar.model.Barang;
import com.sinaukoding21.belajar.model.dto.BarangDto;
import com.sinaukoding21.belajar.model.mapper.BarangMapper;
import com.sinaukoding21.belajar.repositoy.BarangRepository;
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

    public boolean deleteBarang(int id){
        Barang data = barangRepository.findById(id).orElseThrow(null);
        try{
            barangRepository.delete(data);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public Barang updateBarang(int id, Barang barang){
        Barang data = barangRepository.findById(id).orElseThrow(null);
        data.setNama_barang(barang.getNama_barang()!=null? barang.getNama_barang(): data.getNama_barang());
        data.setStok(barang.getStok()!=null? barang.getStok():data.getStok());
        data.setHarga(barang.getHarga()!=null?barang.getHarga():data.getHarga());
        data.setSupplier(barang.getSupplier()!=null?barang.getSupplier():data.getSupplier());
        return barangRepository.save(data);
    }
}
