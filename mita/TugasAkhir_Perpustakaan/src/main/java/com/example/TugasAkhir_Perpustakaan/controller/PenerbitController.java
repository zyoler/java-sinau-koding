package com.example.TugasAkhir_Perpustakaan.controller;

import com.example.TugasAkhir_Perpustakaan.common.Response;
import com.example.TugasAkhir_Perpustakaan.model.Penerbit;
import com.example.TugasAkhir_Perpustakaan.model.dto.PenerbitDto;
import com.example.TugasAkhir_Perpustakaan.service.PenerbitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/penerbit")
public class PenerbitController {
    @Autowired
    PenerbitService penerbitService;

    @GetMapping
    public Response findAllPenerbit(){
        return new Response(penerbitService.findAllPenerbit(),penerbitService.findAllPenerbit().size(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public Response findById(@PathVariable Integer id){
        return new Response(penerbitService.findByIdPenerbit(id),"Berhasil di tampilkan",HttpStatus.OK);
    }
    @PostMapping
    public Response savePenerbit(@RequestBody PenerbitDto penerbit){
        return new Response(penerbitService.createPenerbit(penerbit),"Berhasil disimpan",HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public Response deleteBarang(@PathVariable Integer id){
        if(penerbitService.deletePenerbit(id)){
            return new Response("Berhasil dihapus",HttpStatus.OK);
        }else{
            return new Response("Gagal dihapus",HttpStatus.OK);
        }
    }
    @PutMapping("/{id}")
    public Response updatePenerbit(@PathVariable Integer id, @RequestBody Penerbit penerbit){
        return new Response(penerbitService.updatePenerbit(id,penerbit),"Berhasil di update",HttpStatus.OK);
    }
}
