package com.sinaukoding21.belajar.service;

import com.sinaukoding21.belajar.model.Barang;
import com.sinaukoding21.belajar.model.Transaksi;
import com.sinaukoding21.belajar.model.dto.TransaksiDto;
import com.sinaukoding21.belajar.model.mapper.BarangMapper;
import com.sinaukoding21.belajar.model.mapper.TransaksiMapper;
import com.sinaukoding21.belajar.repositoy.TransaksiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransaksiService {
    @Autowired
    TransaksiRepository transaksiRepository;

    public List<TransaksiDto> findAllTransaksi(){
        return TransaksiMapper.INSTANCE.toDtoList(transaksiRepository.findAll());
    }

    public TransaksiDto createTransaksi(TransaksiDto param){
        Transaksi transaksi = TransaksiMapper.INSTANCE.toEntity(param);
        return TransaksiMapper.INSTANCE.toDto(transaksiRepository.save(transaksi));
    }
    public boolean deleteTransaksi(int id){
        Transaksi data = transaksiRepository.findById(id).orElseThrow(null);
        try{
            transaksiRepository.delete(data);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public Transaksi updateTransaksi(int id, Transaksi transaksi){
        Transaksi data = transaksiRepository.findById(id).orElseThrow(null);
        data.setTgl_transaksi(transaksi.getTgl_transaksi()!=null?transaksi.getTgl_transaksi(): data.getTgl_transaksi());
        data.setBarang(transaksi.getBarang()!=null?transaksi.getBarang(): data.getBarang());
        data.setPembeli(transaksi.getPembeli()!=null?transaksi.getPembeli():data.getPembeli());
        data.setKeterangan(transaksi.getKeterangan()!=null?transaksi.getKeterangan(): data.getKeterangan());

        return transaksiRepository.save(data);

    }
}
