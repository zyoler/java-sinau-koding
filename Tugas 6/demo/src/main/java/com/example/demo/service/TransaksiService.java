package com.example.demo.service;

import com.example.demo.models.Transaksi;
import com.example.demo.repository.TransaksiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransaksiService {
    @Autowired
    TransaksiRepository transaksiRepository;

    public List<Transaksi> findAll(){
        return transaksiRepository.findAll();
    }

    public Transaksi getById(Integer id){
        return transaksiRepository.findById(id).orElseThrow(null);
    }

    public Transaksi createTransaksi(Transaksi transaksi){
        return transaksiRepository.save(transaksi);
    }
}
