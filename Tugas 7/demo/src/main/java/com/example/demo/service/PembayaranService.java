package com.example.demo.service;

import com.example.demo.models.dto.PembayaranDto;
import com.example.demo.models.mapper.PembayaranMapper;
import com.example.demo.repository.PembayaranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PembayaranService {
    @Autowired
    PembayaranRepository pembayaranRepository;

    public List<PembayaranDto> findAll() {
        return PembayaranMapper.INSTANCE.toDtoList(pembayaranRepository.findAll());
    }

    public PembayaranDto getById(Integer id){
        return PembayaranMapper.INSTANCE.toDto(pembayaranRepository.findById(id).orElseThrow(null));
    }

    public PembayaranDto createPembayaran(PembayaranDto pembayaran){
        return PembayaranMapper.INSTANCE.toDto(pembayaranRepository.save(PembayaranMapper.INSTANCE.toEntitiy(pembayaran)));
    }
}
