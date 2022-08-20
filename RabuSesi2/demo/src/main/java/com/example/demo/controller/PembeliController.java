package com.example.demo.controller;

import com.example.demo.common.Response;
import com.example.demo.models.Pembeli;
import com.example.demo.models.dto.PembeliDto;
import com.example.demo.service.PembeliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pembelis")
public class PembeliController {
    @Autowired
    PembeliService pembeliService;

    @GetMapping
    public Response findAll(){
        return new Response(
                pembeliService.findAll(),
                pembeliService.findAll().size(),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable Integer id){
        return new Response(
                pembeliService.findById(id),
                "Data ditemukan",
                HttpStatus.OK);
    }

    @PostMapping
    public Response createPembeli(@RequestBody PembeliDto pembeli){
        return new Response(
                pembeliService.createPembeli(pembeli),
                "Berhasil disimpan",
                HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public Response deletePembeli(@PathVariable Integer id){
        if(pembeliService.deletePembeli(id)){
            return new Response("Berhasil dihapus", HttpStatus.OK);
        }
        return new Response("Gagal dihapus", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public Response updatePembeli(@PathVariable Integer id, Pembeli pembeli){
        return new Response(
                pembeliService.updatePembeli(id, pembeli),
                "Berhasil diupdate",
                HttpStatus.OK);
    }
}
