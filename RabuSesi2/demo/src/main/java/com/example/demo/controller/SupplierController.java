package com.example.demo.controller;

import com.example.demo.common.Response;
import com.example.demo.models.Supplier;
import com.example.demo.models.dto.SupplierDto;
import com.example.demo.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {
    @Autowired
    SupplierService supplierService;

    @GetMapping
    public Response findAllBarang(){
        return new Response(
                supplierService.findAll(),
                supplierService.findAll().size(),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable Integer id){
        return new Response(
                supplierService.findById(id),
                "Berhasil ditemukan",
                HttpStatus.OK);
    }

    @PostMapping
    public Response postBarang(@RequestBody SupplierDto supplier){
        return new Response(
                supplierService.createSupplier(supplier),
                "Berhasil disimpan",
                HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public Response putBarang(@PathVariable Integer id,@RequestBody Supplier supplier){
        return new Response(
                supplierService.updateSupplier(id, supplier),
                "Berhasil diupdate",
                HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public Response deleteBarang(@PathVariable Integer id){
        supplierService.deleteSupplier(id);
        return new Response("Berhasil didelete", HttpStatus.OK);
    }

    @DeleteMapping("/all")
    public Response deleteAllBarang(){
        supplierService.deleteAllSupplier();
        return new Response("Berhasil delete all", HttpStatus.OK);
    }
}
