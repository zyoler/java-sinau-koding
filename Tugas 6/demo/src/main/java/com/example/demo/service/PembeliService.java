package com.example.demo.service;

import com.example.demo.models.Pembeli;
import com.example.demo.repository.PembeliRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.util.Pem;

import java.util.List;

@Service
public class PembeliService {
    @Autowired
    PembeliRepository pembeliRepository;

    public List<Pembeli> findAll(){
        return pembeliRepository.findAll();
    }

    public Pembeli findById(Integer id){
        return pembeliRepository.getById(id);
    }

    public Pembeli createPembeli(Pembeli pembeli){
        return pembeliRepository.save(pembeli);
    }

    public void deletePembeli(Integer id){
        pembeliRepository.delete(pembeliRepository.findById(id).orElseThrow(null));
    }

    public Pembeli updatePembeli(Integer id, Pembeli pembeli){
        Pembeli data = pembeliRepository.findById(id).orElseThrow(null);
        data.setNama_pembeli(pembeli.getNama_pembeli() == null ? data.getNama_pembeli() : pembeli.getNama_pembeli());
        data.setAlamat(pembeli.getAlamat() == null ? data.getAlamat() : pembeli.getAlamat());
        data.setNo_telp(pembeli.getNo_telp() == null ? data.getNo_telp() : pembeli.getNo_telp());
        data.setTransaksi(pembeli.getTransaksi() == null ? data.getTransaksi() : pembeli.getTransaksi());
        return pembeliRepository.save(data);
    }
}
