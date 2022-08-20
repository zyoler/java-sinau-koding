package com.example.TugasAkhir_Perpustakaan.controller;

import com.example.TugasAkhir_Perpustakaan.common.Response;
import com.example.TugasAkhir_Perpustakaan.model.Pengembalian;
import com.example.TugasAkhir_Perpustakaan.model.dto.PengembalianDto;
import com.example.TugasAkhir_Perpustakaan.service.PengembalianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pengembalian")
public class PengembalianController {
    @Autowired
    PengembalianService pengembalianService;

    @GetMapping
    public Response findAllPengembalian(){
        return new Response(pengembalianService.findAllPengembalian(),pengembalianService.findAllPengembalian().size(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public Response findById(@PathVariable Integer id){
        return new Response(pengembalianService.findByIdPengembalian(id),"Berhasil di tampilkan",HttpStatus.OK);
    }
    @PostMapping
    public Response savePengembalian(@RequestBody PengembalianDto pengembalian){
        return new Response(pengembalianService.createPengembalian(pengembalian),"Berhasil disimpan",HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public Response deleteBarang(@PathVariable Integer id){
        if(pengembalianService.deletePengembalian(id)){
            return new Response("Berhasil dihapus",HttpStatus.OK);
        }else{
            return new Response("Gagal dihapus",HttpStatus.OK);
        }
    }
    @PutMapping("/{id}")
    public Response updatePengembalian(@PathVariable Integer id, @RequestBody Pengembalian pengembalian){
        return new Response(pengembalianService.updatePengembalian(id,pengembalian),"Berhasil di update",HttpStatus.OK);
    }
}
