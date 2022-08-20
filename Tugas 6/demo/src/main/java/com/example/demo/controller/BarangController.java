package com.example.demo.controller;

import com.example.demo.models.Barang;
import com.example.demo.service.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/barangs")
public class BarangController {
    @Autowired
    BarangService barangService;

    @GetMapping
    public ResponseEntity<?> findAllBarang() {
        return new ResponseEntity<>(barangService.findAllBarang(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        return new ResponseEntity<>(barangService.getBarangById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody Barang barang) {
        return new ResponseEntity<>(barangService.createBarang(barang), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id){
        barangService.deleteBarang(id);
        return new ResponseEntity<>("Berhasil di delete" , HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Integer id, @RequestBody Barang barang){
        return new ResponseEntity<>(barangService.updateBarang(id, barang), HttpStatus.OK);
    }
}
