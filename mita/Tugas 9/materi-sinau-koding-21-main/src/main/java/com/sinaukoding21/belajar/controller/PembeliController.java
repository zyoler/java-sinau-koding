package com.sinaukoding21.belajar.controller;

import com.sinaukoding21.belajar.common.Response;
import com.sinaukoding21.belajar.model.Barang;
import com.sinaukoding21.belajar.model.Pembeli;
import com.sinaukoding21.belajar.model.dto.PembeliDto;
import com.sinaukoding21.belajar.service.PembeliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pembeli")
public class PembeliController {
    @Autowired
    PembeliService pembeliService;


    @GetMapping
    public Response findAllPembeli(){
        return new Response(pembeliService.findAllPembeli(), pembeliService.findAllPembeli().size(),HttpStatus.OK);
    }
    @PostMapping
    public Response savePembeli(@RequestBody PembeliDto pembeli){
        return new Response(pembeliService.createPembeli(pembeli),"Berhasil disimpan",HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public Response deletePembeli(@PathVariable Integer id){
        if(pembeliService.deletePembeli(id)){
            return new Response("Berhasil dihapus",HttpStatus.OK);
        }else{
            return new Response("Gagal dihapus",HttpStatus.OK);
        }
    }
    @PutMapping("/{id}")
    public Response updatePembeli(@PathVariable Integer id, @RequestBody Pembeli pembeli){
        return new Response (pembeliService.updatePembeli(id,pembeli),"Berhasil di update",HttpStatus.OK);
    }
}
