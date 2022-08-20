package com.example.TugasAkhir_Perpustakaan.controller;

import com.example.TugasAkhir_Perpustakaan.common.Response;
import com.example.TugasAkhir_Perpustakaan.model.Pengarang;
import com.example.TugasAkhir_Perpustakaan.model.dto.PengarangDto;
import com.example.TugasAkhir_Perpustakaan.service.PengarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pengarang")
public class PengarangController {
    @Autowired
    PengarangService pengarangService;

    @GetMapping
    public Response findAllPengarang(){
        return new Response(pengarangService.findAllPengarang(),pengarangService.findAllPengarang().size(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public Response findById(@PathVariable Integer id){
        return new Response(pengarangService.findByIdPengarang(id),"Berhasil di tampilkan",HttpStatus.OK);
    }
    @PostMapping
    public Response savePengarang(@RequestBody PengarangDto pengarang){
        return new Response(pengarangService.createPengarang(pengarang),"Berhasil disimpan",HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public Response deleteBarang(@PathVariable Integer id){
        if(pengarangService.deletePengarang(id)){
            return new Response("Berhasil dihapus",HttpStatus.OK);
        }else{
            return new Response("Gagal dihapus",HttpStatus.OK);
        }
    }
    @PutMapping("/{id}")
    public Response updatePengarang(@PathVariable Integer id, @RequestBody Pengarang pengarang){
        return new Response(pengarangService.updatePengarang(id,pengarang),"Berhasil di update",HttpStatus.OK);
    }
}
