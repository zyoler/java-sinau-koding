package com.example.demo.controller;

import com.example.demo.common.Response;
import com.example.demo.models.dto.PembayaranDto;
import com.example.demo.service.PembayaranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pembayarans")
public class PembayaranController {
    @Autowired
    PembayaranService pembayaranService;

    @GetMapping
    public Response findAll(){
        return new Response(
                pembayaranService.findAll(),
                pembayaranService.findAll().size(),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable Integer id){
        return new Response(
                pembayaranService.getById(id),
                "Data ditemukan",
                HttpStatus.OK);
    }

    @PostMapping
    public Response createPembayaran(@RequestBody PembayaranDto pembayaran){
        return new Response(
                pembayaranService.createPembayaran(pembayaran),
                "Berhasil disimpan",
                HttpStatus.OK);
    }
}
