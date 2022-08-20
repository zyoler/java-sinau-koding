package com.example.TugasAkhir_Perpustakaan.controller;

import com.example.TugasAkhir_Perpustakaan.common.Response;
import com.example.TugasAkhir_Perpustakaan.model.Anggota;
import com.example.TugasAkhir_Perpustakaan.model.dto.AnggotaDto;
import com.example.TugasAkhir_Perpustakaan.service.AnggotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/anggota")
public class AnggotaController {
    @Autowired
    AnggotaService anggotaService;

    @GetMapping
    public Response findAllAnggota(){
        return new Response(anggotaService.findAllAnggota(),anggotaService.findAllAnggota().size(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public Response findById(@PathVariable Integer id){
        return new Response(anggotaService.findByIdAnggota(id),"Berhasil di tampilkan",HttpStatus.OK);
    }
    @PostMapping
    public Response saveAnggota(@RequestBody AnggotaDto anggota){
        return new Response(anggotaService.createAnggota(anggota),"Berhasil disimpan",HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public Response deleteBarang(@PathVariable Integer id){
        if(anggotaService.deleteAnggota(id)){
            return new Response("Berhasil dihapus",HttpStatus.OK);
        }else{
            return new Response("Gagal dihapus",HttpStatus.OK);
        }
    }
    @PutMapping("/{id}")
    public Response updateAnggota(@PathVariable Integer id, @RequestBody Anggota anggota){
        return new Response(anggotaService.updateAnggota(id,anggota),"Berhasil di update",HttpStatus.OK);
    }
}
