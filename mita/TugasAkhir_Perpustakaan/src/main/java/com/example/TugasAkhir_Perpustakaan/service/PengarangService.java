package com.example.TugasAkhir_Perpustakaan.service;

import com.example.TugasAkhir_Perpustakaan.model.Pengarang;
import com.example.TugasAkhir_Perpustakaan.model.dto.PengarangDto;
import com.example.TugasAkhir_Perpustakaan.model.mapper.PengarangMapper;
import com.example.TugasAkhir_Perpustakaan.repository.PengarangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PengarangService {
    @Autowired
    PengarangRepository pengarangRepository;

    public List<PengarangDto> findAllPengarang(){
        return PengarangMapper.INSTANCE.toDtoList(pengarangRepository.findAll());
    }
    public PengarangDto findByIdPengarang(Integer id){
        return PengarangMapper.INSTANCE.toDto(pengarangRepository.findById(id).orElseThrow(null));
    }

    public PengarangDto createPengarang(PengarangDto param){
        Pengarang pengarang = PengarangMapper.INSTANCE.toEntity(param);
        return PengarangMapper.INSTANCE.toDto(pengarangRepository.save(pengarang));
    }
    public boolean deletePengarang(int id){
        Pengarang data = pengarangRepository.findById(id).orElseThrow(null);
        try{
            pengarangRepository.delete(data);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public Pengarang updatePengarang(int id, Pengarang pengarang){
        Pengarang data = pengarangRepository.findById(id).orElseThrow(null);
        data.setNama(pengarang.getNama()!=null?pengarang.getNama():data.getNama());
        data.setAlamat(pengarang.getAlamat()!=null?pengarang.getAlamat():data.getAlamat());
        data.setTelp(pengarang.getTelp()!=null?pengarang.getTelp():data.getTelp());
        return pengarangRepository.save(data);
    }
}
