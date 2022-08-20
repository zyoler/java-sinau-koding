package com.sinaukoding21.belajar.controller;

import com.sinaukoding21.belajar.model.Barang;
import com.sinaukoding21.belajar.model.dto.BarangDto;
import com.sinaukoding21.belajar.service.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/barang")
public class BarangController {
    @Autowired
    BarangService barangService;

    @GetMapping
    public ResponseEntity<?> findAllBarang(){
        return new ResponseEntity<>(barangService.findAllBarang(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> saveBarang(@RequestBody BarangDto barang){
        return new ResponseEntity<>(barangService.createBarang(barang),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBarang(@PathVariable Integer id)   {
        if(barangService.deleteBarang(id)) {
            return new ResponseEntity<>("Berhasil dihapus", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Gagal dihapus",HttpStatus.OK);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateBarang(@PathVariable Integer id, @RequestBody Barang barang){
        return new ResponseEntity<>(barangService.updateBarang(id,barang),HttpStatus.OK);
    }
}
