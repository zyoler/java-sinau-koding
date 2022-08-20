package com.example.demo.service;

import com.example.demo.models.Transaksi;
import com.example.demo.models.dto.TransaksiDto;
import com.example.demo.models.mapper.TransaksiMapper;
import com.example.demo.repository.TransaksiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransaksiService {
    @Autowired
    TransaksiRepository transaksiRepository;

    public List<TransaksiDto> findAll(){
        return TransaksiMapper.INSTANCE.toDtoList(transaksiRepository.findAll());
    }

    public TransaksiDto getById(Integer id){
        return TransaksiMapper.INSTANCE.toDto(transaksiRepository.findById(id).orElseThrow(null));
    }

    public TransaksiDto createTransaksi(TransaksiDto transaksi){
        Transaksi data = TransaksiMapper.INSTANCE.toEntitiy(transaksi);
        data = transaksiRepository.save(data);
        return TransaksiMapper.INSTANCE.toDto(data);
    }
}
