package com.example.TugasAkhir_Perpustakaan.service;

import com.example.TugasAkhir_Perpustakaan.model.Anggota;
import com.example.TugasAkhir_Perpustakaan.model.dto.AnggotaDto;
import com.example.TugasAkhir_Perpustakaan.model.mapper.AnggotaMapper;
import com.example.TugasAkhir_Perpustakaan.repository.AnggotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnggotaService {
    @Autowired
    AnggotaRepository anggotaRepository;

    public List<AnggotaDto> findAllAnggota(){
        return AnggotaMapper.INSTANCE.toDtoList(anggotaRepository.findAll());
    }
    public AnggotaDto findByIdAnggota(Integer id){
        return AnggotaMapper.INSTANCE.toDto(anggotaRepository.findById(id).orElseThrow(null));
    }

    public AnggotaDto createAnggota(AnggotaDto param){
        Anggota anggota = AnggotaMapper.INSTANCE.toEntity(param);
        return AnggotaMapper.INSTANCE.toDto(anggotaRepository.save(anggota));
    }
    public boolean deleteAnggota(int id){
        Anggota data = anggotaRepository.findById(id).orElseThrow(null);
        try{
            anggotaRepository.delete(data);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public Anggota updateAnggota(int id,Anggota anggota){
        Anggota data = anggotaRepository.findById(id).orElseThrow(null);
        data.setNama(anggota.getNama()!=null?anggota.getNama():data.getNama());
        data.setJenis_kelamin(anggota.getJenis_kelamin()!=null?anggota.getJenis_kelamin():data.getJenis_kelamin());
        data.setAlamat(anggota.getAlamat()!=null?anggota.getAlamat():data.getAlamat());
        data.setTelp(anggota.getTelp()!=null?anggota.getTelp():data.getTelp());
        data.setUser(anggota.getUser()!=null?anggota.getUser():data.getUser());
        return anggotaRepository.save(data);
    }
}
