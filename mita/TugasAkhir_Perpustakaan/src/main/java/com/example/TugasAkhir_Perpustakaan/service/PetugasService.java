package com.example.TugasAkhir_Perpustakaan.service;

import com.example.TugasAkhir_Perpustakaan.model.Petugas;
import com.example.TugasAkhir_Perpustakaan.model.dto.PetugasDto;
import com.example.TugasAkhir_Perpustakaan.model.mapper.PetugasMapper;
import com.example.TugasAkhir_Perpustakaan.repository.PetugasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetugasService {
    @Autowired
    PetugasRepository petugasRepository;

    public List<PetugasDto> findAllPetugas(){
        return PetugasMapper.INSTANCE.toDtoList(petugasRepository.findAll());
    }
    public PetugasDto createPetugas(PetugasDto param){
        Petugas petugas = PetugasMapper.INSTANCE.toEntity(param);
        return PetugasMapper.INSTANCE.toDto(petugasRepository.save(petugas));
    }
    public PetugasDto findByIdPetugas(Integer id){
        return PetugasMapper.INSTANCE.toDto(petugasRepository.findById(id).orElseThrow(null));
    }

    public boolean deletePetugas(int id){
        Petugas data = petugasRepository.findById(id).orElseThrow(null);
        try{
            petugasRepository.delete(data);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public Petugas updatePetugas(int id,Petugas petugas){
        Petugas data=petugasRepository.findById(id).orElseThrow(null);
        data.setNama(petugas.getNama()!=null? petugas.getNama() : data.getNama());
        data.setTelp(petugas.getTelp()!=null? petugas.getTelp() : data.getTelp());
        data.setAlamat(petugas.getAlamat()!=null? petugas.getAlamat() : data.getAlamat());
        data.setUser(petugas.getUser()!=null? petugas.getUser() : data.getUser());
        return petugasRepository.save(data);

    }
}
