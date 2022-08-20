package com.example.demo.controller;

import com.example.demo.models.Pembeli;
import com.example.demo.service.PembeliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pembelis")
public class PembeliController {
    @Autowired
    PembeliService pembeliService;

    @GetMapping
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(pembeliService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        return new ResponseEntity<>(pembeliService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createPembeli(@RequestBody Pembeli pembeli){
        return new ResponseEntity<>(pembeliService.createPembeli(pembeli), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePembeli(@PathVariable Integer id){
        pembeliService.deletePembeli(id);
        return new ResponseEntity<>("Berhasil dihapus", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePembeli(@PathVariable Integer id, Pembeli pembeli){
        return new ResponseEntity<>(pembeliService.updatePembeli(id, pembeli), HttpStatus.OK);
    }
}
