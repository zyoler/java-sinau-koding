package com.example.demo.controller;

import com.example.demo.models.Barang;
import com.example.demo.models.Supplier;
import com.example.demo.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {
    @Autowired
    SupplierService supplierService;

    @GetMapping
    public ResponseEntity<?> findAllBarang(){
        return new ResponseEntity<>(supplierService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        return new ResponseEntity<>(supplierService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> postBarang(@RequestBody Supplier supplier){
        return new ResponseEntity<>(supplierService.createSupplier(supplier), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putBarang(@PathVariable Integer id,@RequestBody Supplier supplier){
        return new ResponseEntity<>(supplierService.updateSupplier(id, supplier), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBarang(@PathVariable Integer id){
        supplierService.deleteSupplier(id);
        return new ResponseEntity<>("Berhasil didelete", HttpStatus.OK);
    }

    @DeleteMapping("/all")
    public ResponseEntity<?> deleteAllBarang(){
        supplierService.deleteAllSupplier();
        return new ResponseEntity<>("Berhasil delete all", HttpStatus.OK);
    }
}
