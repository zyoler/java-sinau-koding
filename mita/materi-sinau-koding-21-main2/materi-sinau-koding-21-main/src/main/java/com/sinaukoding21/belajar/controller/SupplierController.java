package com.sinaukoding21.belajar.controller;

import com.sinaukoding21.belajar.common.Response;
import com.sinaukoding21.belajar.model.Barang;
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
    public Response findAllSupplier(){
        return new Response(supplierService.findAllSupplier(), supplierService.findAllSupplier().size(),HttpStatus.OK);
    }
    @PostMapping
    public Response saveSupplier(@RequestBody SupplierDto supplier){
        return new Response(supplierService.createSupplier(supplier),"Berhasil disimpan",HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public Response deleteSupplier(@PathVariable Integer id){
        if(supplierService.deleteSupplier(id)){
            return new Response("Berhasil dihapus",HttpStatus.OK);
        }else{
            return new Response("Gagal dihapus",HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    public Response updateSupplier(@PathVariable Integer id, @RequestBody Supplier supplier){
        return new Response(supplierService.updateSupplier(id,supplier),"Berhasil di update",HttpStatus.OK);
    }
}
