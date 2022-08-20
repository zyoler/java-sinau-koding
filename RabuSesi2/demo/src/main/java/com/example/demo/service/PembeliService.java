package com.example.demo.service;

import com.example.demo.models.Pembeli;
import com.example.demo.models.dto.PembeliDto;
import com.example.demo.models.mapper.PembeliMapper;
import com.example.demo.repository.PembeliRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PembeliService {
    @Autowired
    PembeliRepository pembeliRepository;

    public List<PembeliDto> findAll(){
        return PembeliMapper.INSTANCE.toDtoList(pembeliRepository.findAll());
    }

    public PembeliDto findById(Integer id){
        return PembeliMapper.INSTANCE.toDto(pembeliRepository.findById(id).orElseThrow(null));
    }

    public PembeliDto createPembeli(PembeliDto pembeli){
        return PembeliMapper.INSTANCE.toDto(pembeliRepository.save(PembeliMapper.INSTANCE.toEntity(pembeli)));
    }

    public boolean deletePembeli(Integer id){
        try {
            pembeliRepository.delete(pembeliRepository.findById(id).orElseThrow(null));
            return true;
        } catch (Exception e){
            return false;
        }
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
