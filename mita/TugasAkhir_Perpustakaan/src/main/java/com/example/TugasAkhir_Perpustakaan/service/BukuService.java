package com.example.TugasAkhir_Perpustakaan.service;

import com.example.TugasAkhir_Perpustakaan.model.Buku;
import com.example.TugasAkhir_Perpustakaan.model.dto.BukuDto;
import com.example.TugasAkhir_Perpustakaan.model.mapper.BukuMapper;
import com.example.TugasAkhir_Perpustakaan.repository.BukuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BukuService {
    @Autowired
    BukuRepository bukuRepository;

    public List<BukuDto> findAllBuku(){
        return BukuMapper.INSTANCE.toDtoList(bukuRepository.findAll());
    }

    public BukuDto findByIdBuku(Integer id){
        return BukuMapper.INSTANCE.toDto(bukuRepository.findById(id).orElseThrow(null));
    }

    public BukuDto createBuku(BukuDto param){
        Buku buku = BukuMapper.INSTANCE.toEntity(param);
        return BukuMapper.INSTANCE.toDto(bukuRepository.save(buku));
    }

    public boolean deleteBuku(int id){
        Buku data = bukuRepository.findById(id).orElseThrow(null);
        try{
            bukuRepository.delete(data);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public Buku updateBuku(int id, Buku buku){
        Buku data =  bukuRepository.findById(id).orElseThrow(null);
        data.setJudul(buku.getJudul()!=null?buku.getJudul():data.getJudul());
        data.setTahun_terbit(buku.getTahun_terbit()!=null?buku.getTahun_terbit():data.getTahun_terbit());
        data.setJumlah(buku.getJumlah()!=null?buku.getJumlah():data.getJumlah());
        data.setIsbn(buku.getIsbn()!=null?buku.getIsbn():data.getIsbn());
        data.setPengarang(buku.getPengarang()!=null?buku.getPengarang():data.getPengarang());
        data.setPenerbit(buku.getPenerbit()!=null?buku.getPenerbit():data.getPenerbit());
        return bukuRepository.save(data);



    }
}
