package com.example.demo.controller;

import com.example.demo.common.Response;
import com.example.demo.models.dto.TransaksiDto;
import com.example.demo.service.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaksis")
public class TransaksiController {
    @Autowired
    TransaksiService transaksiService;

    @GetMapping
    public Response findAll(){
        return new Response(
                transaksiService.findAll(),
                transaksiService.findAll().size(),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable Integer id){
        return new Response(
                transaksiService.getById(id),
                "Data ditemukan",
                HttpStatus.OK);
    }

    @PostMapping
    public Response createTransaksi(@RequestBody TransaksiDto transaksi){
        return new Response(
                transaksiService.createTransaksi(transaksi),
                "Berhasil disimpan",
                HttpStatus.OK);
    }
}
