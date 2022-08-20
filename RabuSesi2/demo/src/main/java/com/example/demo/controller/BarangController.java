package com.example.demo.controller;

import com.example.demo.common.Response;
import com.example.demo.models.Barang;
import com.example.demo.models.dto.BarangDto;
import com.example.demo.service.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/barangs")
public class BarangController {
    @Autowired
    BarangService barangService;

    @GetMapping
    public Response findAllBarang() {
        return new Response(
                barangService.findAllBarang(),
                barangService.findAllBarang().size(),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable Integer id){
        return new Response(
                barangService.getBarangById(id),
                "Data ditemukan",
                HttpStatus.OK);
    }

    @PostMapping
    public Response saveUser(@RequestBody BarangDto barang) {
        return new Response(
                barangService.createBarang(barang),
                "Data berhasil disimpan",
                HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public Response deleteUser(@PathVariable Integer id){
        if(barangService.deleteBarang(id)){
            return new Response("Berhasil didelete" , HttpStatus.OK);
        }
        return new Response("Gagal dihapus" , HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public Response updateUser(@PathVariable Integer id, @RequestBody Barang barang){
        return new Response(
                barangService.updateBarang(id, barang),
                "Berhasil di update",
                HttpStatus.OK);
    }
}
