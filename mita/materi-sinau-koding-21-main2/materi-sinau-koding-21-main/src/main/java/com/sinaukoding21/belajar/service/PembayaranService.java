package com.sinaukoding21.belajar.service;

import com.sinaukoding21.belajar.model.Barang;
import com.sinaukoding21.belajar.model.Pembayaran;
import com.sinaukoding21.belajar.model.Transaksi;
import com.sinaukoding21.belajar.model.dto.PembayaranDto;
import com.sinaukoding21.belajar.model.mapper.BarangMapper;
import com.sinaukoding21.belajar.model.mapper.PembayaranMapper;
import com.sinaukoding21.belajar.model.mapper.TransaksiMapper;
import com.sinaukoding21.belajar.repositoy.PembayaranRepository;
import com.sinaukoding21.belajar.repositoy.TransaksiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PembayaranService {
    @Autowired
    PembayaranRepository pembayaranRepository;


    public List<PembayaranDto> findAllPembayaran(){
        return PembayaranMapper.INSTANCE.toDtoList(pembayaranRepository.findAll());
    }

    public PembayaranDto createPembayaran(PembayaranDto param){
        Pembayaran pembayaran = PembayaranMapper.INSTANCE.toEntitiy(param);
        return PembayaranMapper.INSTANCE.toDto(pembayaranRepository.save(pembayaran));

    }
    public boolean deletePembayaran(int id){
        Pembayaran data =  pembayaranRepository.findById(id).orElseThrow(null);
        try{
            pembayaranRepository.delete(data);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public Pembayaran updatePembayaran(int id, Pembayaran pembayaran){
        Pembayaran data = pembayaranRepository.findById(id).orElseThrow(null);
        data.setTotal(pembayaran.getTotal()!=null? pembayaran.getTotal():data.getTotal());
        data.setTgl_bayar(pembayaran.getTgl_bayar()!=null?pembayaran.getTgl_bayar(): data.getTgl_bayar());
        data.setTransaksi(pembayaran.getTransaksi()!=null?pembayaran.getTransaksi():data.getTransaksi());

        return pembayaranRepository.save(data);
    }
}
