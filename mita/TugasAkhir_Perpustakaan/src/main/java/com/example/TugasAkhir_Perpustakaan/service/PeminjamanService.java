package com.example.TugasAkhir_Perpustakaan.service;

import com.example.TugasAkhir_Perpustakaan.model.Buku;
import com.example.TugasAkhir_Perpustakaan.model.Peminjaman;
import com.example.TugasAkhir_Perpustakaan.model.dto.DetailDto;
import com.example.TugasAkhir_Perpustakaan.model.dto.PeminjamanDto;
import com.example.TugasAkhir_Perpustakaan.model.mapper.PeminjamanMapper;
import com.example.TugasAkhir_Perpustakaan.repository.BukuRepository;
import com.example.TugasAkhir_Perpustakaan.repository.PeminjamanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeminjamanService {
    @Autowired
    PeminjamanRepository peminjamanRepository;

    @Autowired
    BukuRepository bukuRepository;

    public PeminjamanDto createMany(DetailDto param){
        Peminjaman peminjaman = peminjamanRepository.findById(param.getPeminjaman()).orElseThrow(null);
        Buku buku = bukuRepository.findById(param.getBuku()).orElseThrow(null);
        peminjaman.getBuku().add(buku);
        peminjaman = peminjamanRepository.save(peminjaman);
        return PeminjamanMapper.INSTANCE.toDto(peminjaman);
    }

    public List<PeminjamanDto> findAllPeminjaman(){
        return PeminjamanMapper.INSTANCE.toDtoList(peminjamanRepository.findAll());
    }

    public PeminjamanDto findByIdPeminjaman(Integer id){
        return PeminjamanMapper.INSTANCE.toDto(peminjamanRepository.findById(id).orElseThrow(null));
    }

    public PeminjamanDto createPeminjaman(PeminjamanDto param){
        Peminjaman peminjaman = PeminjamanMapper.INSTANCE.toEntity(param);
        return PeminjamanMapper.INSTANCE.toDto(peminjamanRepository.save(peminjaman));
    }

    public boolean deletePeminjaman(int id){
        Peminjaman data = peminjamanRepository.findById(id).orElseThrow(null);
        try{
            peminjamanRepository.delete(data);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public Peminjaman updatePeminjaman(int id, Peminjaman peminjaman){
        Peminjaman data = peminjamanRepository.findById(id).orElseThrow(null);
        data.setTgl_pinjam(peminjaman.getTgl_pinjam()!=null?peminjaman.getTgl_pinjam():data.getTgl_pinjam());
        data.setTgl_kembali(peminjaman.getTgl_kembali()!=null?peminjaman.getTgl_kembali():data.getTgl_kembali());
        data.setAnggota(peminjaman.getAnggota()!=null?peminjaman.getAnggota():data.getAnggota());
        data.setPetugas(peminjaman.getPetugas()!=null?peminjaman.getPetugas():data.getPetugas());
        return peminjamanRepository.save(data);
    }
}
