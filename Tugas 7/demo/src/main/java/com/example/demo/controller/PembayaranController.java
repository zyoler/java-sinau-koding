package com.example.demo.controller;

import com.example.demo.models.dto.PembayaranDto;
import com.example.demo.service.PembayaranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pembayarans")
public class PembayaranController {
    @Autowired
    PembayaranService pembayaranService;

    @GetMapping
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(pembayaranService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        return new ResponseEntity<>(pembayaranService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createPembayaran(@RequestBody PembayaranDto pembayaran){
        return new ResponseEntity<>(pembayaranService.createPembayaran(pembayaran), HttpStatus.OK);
    }
}
