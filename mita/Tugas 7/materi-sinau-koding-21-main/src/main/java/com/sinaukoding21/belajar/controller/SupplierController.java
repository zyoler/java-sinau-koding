package com.sinaukoding21.belajar.controller;

import com.sinaukoding21.belajar.model.Supplier;
import com.sinaukoding21.belajar.model.dto.SupplierDto;
import com.sinaukoding21.belajar.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    SupplierService supplierService;

    @GetMapping
    public ResponseEntity<?> findAllSupplier(){
        return new ResponseEntity<>(supplierService.findAllSupplier(),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> saveSupplier(@RequestBody SupplierDto supplier){
        return new ResponseEntity<>(supplierService.createSupplier(supplier),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSupplier(@PathVariable Integer id){
        if(supplierService.deleteSupplier(id)){
            return new ResponseEntity<>("Berhasil dihapus",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Gagal dihapus",HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSupplier(@PathVariable Integer id, @RequestBody Supplier supplier){
        return new ResponseEntity<>(supplierService.updateSupplier(id,supplier),HttpStatus.OK);
    }
}
