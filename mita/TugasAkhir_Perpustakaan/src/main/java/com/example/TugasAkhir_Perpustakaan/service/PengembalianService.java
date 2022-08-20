package com.example.TugasAkhir_Perpustakaan.service;

import com.example.TugasAkhir_Perpustakaan.model.Pengembalian;
import com.example.TugasAkhir_Perpustakaan.model.dto.PengembalianDto;
import com.example.TugasAkhir_Perpustakaan.model.mapper.PengembalianMapper;
import com.example.TugasAkhir_Perpustakaan.repository.PengembalianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PengembalianService {
    @Autowired
    PengembalianRepository pengembalianRepository;

    public List<PengembalianDto> findAllPengembalian(){
        return PengembalianMapper.INSTANCE.toDtoList(pengembalianRepository.findAll());
    }
    public PengembalianDto findByIdPengembalian(Integer id){
        return PengembalianMapper.INSTANCE.toDto(pengembalianRepository.findById(id).orElseThrow(null));
    }

    public PengembalianDto createPengembalian(PengembalianDto param){
        Pengembalian pengembalian = PengembalianMapper.INSTANCE.toEntity(param);
        return PengembalianMapper.INSTANCE.toDto(pengembalianRepository.save(pengembalian));
    }
    public boolean deletePengembalian(int id){
        Pengembalian data = pengembalianRepository.findById(id).orElseThrow(null);
        try{
            pengembalianRepository.delete(data);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public Pengembalian updatePengembalian(int id, Pengembalian pengembalian){
        Pengembalian data = pengembalianRepository.findById(id).orElseThrow(null);
        data.setTgl_pengembalian(pengembalian.getTgl_pengembalian()!=null?pengembalian.getTgl_pengembalian(): data.getTgl_pengembalian());
        data.setDenda(pengembalian.getDenda()!=null?pengembalian.getDenda(): data.getDenda());
        data.setPeminjaman(pengembalian.getPeminjaman()!=null?pengembalian.getPeminjaman(): data.getPeminjaman());
        data.setAnggota(pengembalian.getAnggota()!=null?pengembalian.getAnggota(): data.getAnggota());
        data.setPetugas(pengembalian.getPetugas()!=null?pengembalian.getPetugas(): data.getPetugas());
        return pengembalianRepository.save(data);
    }
}
