package com.sinaukoding21.belajar.service;

import com.sinaukoding21.belajar.model.Barang;
import com.sinaukoding21.belajar.repositoy.BarangRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BarangService {
    @Autowired
    BarangRepository barangRepository;

    public List<Barang> findAllBarang(){
        return barangRepository.findAll();
    }

    //@Transactional
    public Barang createBarang(Barang param){
        //Barang barang = param;
        //barang = barangRepository.save(barang);
        return barangRepository.save(param);

        //return barang;
    }

    public void deleteBarang(int id){
        Barang data = barangRepository.findById(id).orElseThrow(null);
        barangRepository.delete(data);
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
