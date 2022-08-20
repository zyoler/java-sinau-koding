package com.example.TugasAkhir_Perpustakaan.controller;

import com.example.TugasAkhir_Perpustakaan.common.Response;
import com.example.TugasAkhir_Perpustakaan.model.Buku;
import com.example.TugasAkhir_Perpustakaan.model.dto.BukuDto;
import com.example.TugasAkhir_Perpustakaan.service.BukuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/buku")
public class BukuController {
    @Autowired
    BukuService bukuService;

    @GetMapping
    public Response findAllBuku(){
        return new Response(bukuService.findAllBuku(),bukuService.findAllBuku().size(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public Response findById(@PathVariable Integer id){
        return new Response(bukuService.findByIdBuku(id),"Berhasil di tampilkan",HttpStatus.OK);
    }
    @PostMapping
    public Response saveBuku(@RequestBody BukuDto buku){
        return new Response(bukuService.createBuku(buku),"Berhasil disimpan",HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public Response deleteBarang(@PathVariable Integer id){
        if(bukuService.deleteBuku(id)){
            return new Response("Berhasil dihapus",HttpStatus.OK);
        }else{
            return new Response("Gagal dihapus",HttpStatus.OK);
        }
    }
    @PutMapping("/{id}")
    public Response updateBuku(@PathVariable Integer id, @RequestBody Buku buku){
        return new Response(bukuService.updateBuku(id,buku),"Berhasil di update",HttpStatus.OK);
    }
}
