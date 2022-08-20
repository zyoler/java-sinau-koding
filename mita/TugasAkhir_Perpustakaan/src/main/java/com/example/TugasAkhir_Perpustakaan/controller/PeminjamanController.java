package com.example.TugasAkhir_Perpustakaan.controller;

import com.example.TugasAkhir_Perpustakaan.common.Response;
import com.example.TugasAkhir_Perpustakaan.model.Peminjaman;
import com.example.TugasAkhir_Perpustakaan.model.dto.DetailDto;
import com.example.TugasAkhir_Perpustakaan.model.dto.PeminjamanDto;
import com.example.TugasAkhir_Perpustakaan.service.PeminjamanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/peminjaman")
public class PeminjamanController {
    @Autowired
    PeminjamanService peminjamanService;


    @PostMapping("/detail")
    public Response createManytoMany(@RequestBody DetailDto param){
        return new Response(
                peminjamanService.createMany(param),
                "Berhasil",
                HttpStatus.OK
        );
    }

    @GetMapping
    public Response findAllPeminjaman(){
        return new Response(peminjamanService.findAllPeminjaman(),peminjamanService.findAllPeminjaman().size(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public Response findById(@PathVariable Integer id){
        return new Response(peminjamanService.findByIdPeminjaman(id),"Berhasil di tampilkan",HttpStatus.OK);
    }
    @PostMapping
    public Response savePeminjaman(@RequestBody PeminjamanDto peminjaman){
        return new Response(peminjamanService.createPeminjaman(peminjaman),"Berhasil disimpan",HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public Response deleteBarang(@PathVariable Integer id){
        if(peminjamanService.deletePeminjaman(id)){
            return new Response("Berhasil dihapus",HttpStatus.OK);
        }else{
            return new Response("Gagal dihapus",HttpStatus.OK);
        }
    }
    @PutMapping("/{id}")
    public Response updatePeminjaman(@PathVariable Integer id, @RequestBody Peminjaman peminjaman){
        return new Response(peminjamanService.updatePeminjaman(id,peminjaman),"Berhasil di update",HttpStatus.OK);
    }
}
