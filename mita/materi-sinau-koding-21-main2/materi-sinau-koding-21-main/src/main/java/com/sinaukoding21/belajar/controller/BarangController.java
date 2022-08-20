package com.sinaukoding21.belajar.controller;

import com.sinaukoding21.belajar.common.Response;
import com.sinaukoding21.belajar.model.Barang;
import com.sinaukoding21.belajar.model.dto.BarangDto;
import com.sinaukoding21.belajar.service.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/barang")
public class BarangController {
    @Autowired
    BarangService barangService;

    @GetMapping
    public Response findAllBarang(){
        return new Response(barangService.findAllBarang(),barangService.findAllBarang().size(), HttpStatus.OK);
    }
    @PostMapping
    public Response saveBarang(@RequestBody BarangDto barang){
        return new Response(barangService.createBarang(barang),"Data berhasil disimpan",HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public Response deleteBarang(@PathVariable Integer id)   {
        if(barangService.deleteBarang(id)) {
            return new Response("Berhasil dihapus", HttpStatus.OK);
        }else{
            return new Response("Gagal dihapus",HttpStatus.OK);
        }
    }
    @PutMapping("/{id}")
    public Response updateBarang(@PathVariable Integer id, @RequestBody Barang barang){
        return new Response(barangService.updateBarang(id,barang),"Berhasil di update",HttpStatus.OK);
    }
}
