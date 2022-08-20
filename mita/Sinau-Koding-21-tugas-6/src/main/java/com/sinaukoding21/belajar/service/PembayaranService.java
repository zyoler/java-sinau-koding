package com.sinaukoding21.belajar.service;

import com.sinaukoding21.belajar.model.Pembayaran;
import com.sinaukoding21.belajar.model.Transaksi;
import com.sinaukoding21.belajar.repositoy.PembayaranRepository;
import com.sinaukoding21.belajar.repositoy.TransaksiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PembayaranService {
    @Autowired
    PembayaranRepository pembayaranRepository;

    @Autowired
    TransaksiRepository transaksiRepository;
    public List<Pembayaran> findAllPembayaran(){
        return pembayaranRepository.findAll();
    }

    public Pembayaran createPembayaran(Pembayaran param){
    //    Pembayaran pembayaran = param;
  //      pembayaran = pembayaranRepository.save(pembayaran);
        //return pembayaran;
        return pembayaranRepository.save(param);

    }
    public void deletePembayaran(int id){
        Pembayaran data =  pembayaranRepository.findById(id).orElseThrow(null);
        pembayaranRepository.delete(data);
    }
    public Pembayaran updatePembayaran(int id, Pembayaran pembayaran){
        Pembayaran data = pembayaranRepository.findById(id).orElseThrow(null);
        data.setTotal(pembayaran.getTotal()!=null? pembayaran.getTotal():data.getTotal());
        data.setTgl_bayar(pembayaran.getTgl_bayar()!=null?pembayaran.getTgl_bayar(): data.getTgl_bayar());
        data.setTransaksi(pembayaran.getTransaksi()!=null?pembayaran.getTransaksi():data.getTransaksi());

        return pembayaranRepository.save(data);
    }
}
