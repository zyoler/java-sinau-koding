package com.sinaukoding21.belajar.service;

import com.sinaukoding21.belajar.model.Transaksi;
import com.sinaukoding21.belajar.repositoy.TransaksiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransaksiService {
    @Autowired
    TransaksiRepository transaksiRepository;

    public List<Transaksi> findAllTransaksi(){
        return transaksiRepository.findAll();
    }
    public Transaksi createTransaksi(Transaksi param){
        return transaksiRepository.save(param);
    }
    public void deleteTransaksi(int id){
        Transaksi data = transaksiRepository.findById(id).orElseThrow(null);
        transaksiRepository.delete(data);
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
