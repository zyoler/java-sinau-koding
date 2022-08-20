package com.sinaukoding21.belajar.controller;

import com.sinaukoding21.belajar.model.Pembayaran;
import com.sinaukoding21.belajar.model.dto.PembayaranDto;
import com.sinaukoding21.belajar.service.PembayaranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pembayaran")
public class PembayaranController {
    @Autowired
    PembayaranService pembayaranService;

    @GetMapping
    public ResponseEntity<?> findAllPembayaran(){
        return new ResponseEntity<>(pembayaranService.findAllPembayaran(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> savePembayaran(@RequestBody PembayaranDto pembayaran){
        return new ResponseEntity<>(pembayaranService.createPembayaran(pembayaran),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePembayaran(@PathVariable Integer id){
        if(pembayaranService.deletePembayaran(id)){
            return new ResponseEntity<> ("Berhasil dihapus",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Gagal dihapus",HttpStatus.OK);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePembayaran(@PathVariable Integer id, @RequestBody Pembayaran pembayaran){
        return  new ResponseEntity<>(pembayaranService.updatePembayaran(id,pembayaran),HttpStatus.OK);
    }
}
