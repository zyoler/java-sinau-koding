package com.example.demo.controller;

import com.example.demo.models.dto.TransaksiDto;
import com.example.demo.service.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaksis")
public class TransaksiController {
    @Autowired
    TransaksiService transaksiService;

    @GetMapping
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(transaksiService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        return new ResponseEntity<>(transaksiService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createTransaksi(@RequestBody TransaksiDto transaksi){
        return new ResponseEntity<>(transaksiService.createTransaksi(transaksi), HttpStatus.OK);
    }
}
