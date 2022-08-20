package com.example.demo.service;

import com.example.demo.models.Pembayaran;
import com.example.demo.repository.PembayaranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PembayaranService {
    @Autowired
    PembayaranRepository pembayaranRepository;

    public List<Pembayaran> findAll() {
        return pembayaranRepository.findAll();
    }

    public Pembayaran getById(Integer id){
        return pembayaranRepository.findById(id).orElseThrow(null);
    }

    public Pembayaran createPembayaran(Pembayaran pembayaran){
        return pembayaranRepository.save(pembayaran);
    }
}
