package com.sinaukoding21.belajar.controller;

import com.sinaukoding21.belajar.model.Barang;
import com.sinaukoding21.belajar.model.Transaksi;
import com.sinaukoding21.belajar.service.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaksi")
public class TransaksiController {
    @Autowired
    TransaksiService transaksiService;

    @GetMapping
    public ResponseEntity<?> findAllTransaksi(){
        return new ResponseEntity(transaksiService.findAllTransaksi(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> saveTransaksi(@RequestBody Transaksi transaksi){
        return new ResponseEntity(transaksiService.createTransaksi(transaksi),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTransaksi(@PathVariable Integer id){
        transaksiService.deleteTransaksi(id);
        return new ResponseEntity<>("Berhasil dihapus",HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateTransaksi(@PathVariable Integer id, @RequestBody Transaksi transaksi){
        return new ResponseEntity(transaksiService.updateTransaksi(id,transaksi),HttpStatus.OK);
    }
}
