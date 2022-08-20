package com.example.TugasAkhir_Perpustakaan.service;

import com.example.TugasAkhir_Perpustakaan.model.Penerbit;
import com.example.TugasAkhir_Perpustakaan.model.dto.PenerbitDto;
import com.example.TugasAkhir_Perpustakaan.model.mapper.PenerbitMapper;
import com.example.TugasAkhir_Perpustakaan.repository.PenerbitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PenerbitService {
    @Autowired
    PenerbitRepository penerbitRepository;

    public List<PenerbitDto> findAllPenerbit(){
        return PenerbitMapper.INSTANCE.toDtoList(penerbitRepository.findAll());
    }
    public PenerbitDto findByIdPenerbit(Integer id){
        return PenerbitMapper.INSTANCE.toDto(penerbitRepository.findById(id).orElseThrow(null));
    }

    public PenerbitDto createPenerbit(PenerbitDto param){
        Penerbit penerbit = PenerbitMapper.INSTANCE.toEntity(param);
        return PenerbitMapper.INSTANCE.toDto(penerbitRepository.save(penerbit));
    }
    public boolean deletePenerbit(int id){
        Penerbit data = penerbitRepository.findById(id).orElseThrow(null);
        try{
            penerbitRepository.delete(data);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public Penerbit updatePenerbit(int id, Penerbit penerbit){
        Penerbit data = penerbitRepository.findById(id).orElseThrow(null);
        data.setNama(penerbit.getNama()!=null?penerbit.getNama():data.getNama());
        data.setAlamat(penerbit.getAlamat()!=null?penerbit.getAlamat():data.getAlamat());
        data.setTelp(penerbit.getTelp()!=null?penerbit.getTelp():data.getTelp());
        return penerbitRepository.save(data);
    }
}
