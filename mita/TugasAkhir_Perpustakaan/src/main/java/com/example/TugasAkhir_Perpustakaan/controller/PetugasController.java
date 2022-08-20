package com.example.TugasAkhir_Perpustakaan.controller;

import com.example.TugasAkhir_Perpustakaan.common.Response;
import com.example.TugasAkhir_Perpustakaan.model.Petugas;
import com.example.TugasAkhir_Perpustakaan.model.dto.PetugasDto;
import com.example.TugasAkhir_Perpustakaan.service.PetugasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/petugas")
public class PetugasController {
    @Autowired
    PetugasService petugasService;

    @GetMapping
    public Response findAllPetugas(){
        return new Response(petugasService.findAllPetugas(),petugasService.findAllPetugas().size(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public Response findById(@PathVariable Integer id){
        return new Response(petugasService.findByIdPetugas(id),"Berhasil di tampilkan",HttpStatus.OK);
    }
    @PostMapping
    public Response savePetugas(@RequestBody PetugasDto petugas){
        return new Response(petugasService.createPetugas(petugas),"Berhasil disimpan",HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public Response deleteBarang(@PathVariable Integer id){
        if(petugasService.deletePetugas(id)){
            return new Response("Berhasil dihapus",HttpStatus.OK);
        }else{
            return new Response("Gagal dihapus",HttpStatus.OK);
        }
    }
    @PutMapping("/{id}")
    public Response updatePetugas(@PathVariable Integer id, @RequestBody Petugas petugas){
        return new Response(petugasService.updatePetugas(id,petugas),"Berhasil di update",HttpStatus.OK);
    }
}
