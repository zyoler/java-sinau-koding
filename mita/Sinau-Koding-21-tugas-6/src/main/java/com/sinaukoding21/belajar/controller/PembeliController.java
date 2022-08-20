package com.sinaukoding21.belajar.controller;

import com.sinaukoding21.belajar.model.Barang;
import com.sinaukoding21.belajar.model.Pembeli;
import com.sinaukoding21.belajar.service.PembeliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pembeli")
public class PembeliController {
    @Autowired
    PembeliService pembeliService;


    @GetMapping
    public ResponseEntity<?> findAllPembeli(){
        return new ResponseEntity(pembeliService.findAllPembeli(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> savePembeli(@RequestBody Pembeli pembeli){
        return new ResponseEntity(pembeliService.createPembeli(pembeli),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePembeli(@PathVariable Integer id){
        pembeliService.deletePembeli(id);
        return new ResponseEntity<>("Berhasil dihapus",HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePembeli(@PathVariable Integer id, @RequestBody Pembeli pembeli){
        return new ResponseEntity(pembeliService.updatePembeli(id,pembeli),HttpStatus.OK);
    }
}
