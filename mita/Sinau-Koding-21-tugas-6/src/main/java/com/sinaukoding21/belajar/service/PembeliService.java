package com.sinaukoding21.belajar.service;

import com.sinaukoding21.belajar.model.Pembeli;
import com.sinaukoding21.belajar.repositoy.PembeliRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PembeliService {
    @Autowired
    PembeliRepository pembeliRepository;

    public List<Pembeli> findAllPembeli(){
        return pembeliRepository.findAll();
    }
    public Pembeli createPembeli(Pembeli param){
        return pembeliRepository.save(param);
    }
    public void deletePembeli(int id){
        Pembeli data= pembeliRepository.findById(id).orElseThrow(null);
        pembeliRepository.delete(data);
    }
    public Pembeli updatePembeli(int id, Pembeli pembeli){
        Pembeli data = pembeliRepository.findById(id).orElseThrow(null);
        data.setNama_pembeli(pembeli.getNama_pembeli()!=null? pembeli.getNama_pembeli() : data.getNama_pembeli());
        data.setAlamat(pembeli.getAlamat()!=null? pembeli.getAlamat() : data.getAlamat());
        data.setNo_telp(pembeli.getNo_telp()!=null? pembeli.getNo_telp() : data.getNo_telp());
        return pembeliRepository.save(data);
    }
}
