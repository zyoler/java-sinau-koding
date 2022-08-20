package com.sinaukoding21.belajar.controller;

import com.sinaukoding21.belajar.common.Response;
import com.sinaukoding21.belajar.model.Pembayaran;
import com.sinaukoding21.belajar.model.dto.PembayaranDto;
import com.sinaukoding21.belajar.service.PembayaranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pembayaran")
public class PembayaranController {
    @Autowired
    PembayaranService pembayaranService;

    @GetMapping
    public Response findAllPembayaran(){
        return new Response(pembayaranService.findAllPembayaran(),pembayaranService.findAllPembayaran().size(), HttpStatus.OK);
    }
    @PostMapping
    public Response savePembayaran(@RequestBody PembayaranDto pembayaran){
        return new Response(pembayaranService.createPembayaran(pembayaran),"Berhasil disimpan",HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public Response deletePembayaran(@PathVariable Integer id){
        if(pembayaranService.deletePembayaran(id)){
            return new Response ("Berhasil dihapus",HttpStatus.OK);
        }else{
            return new Response("Gagal dihapus",HttpStatus.OK);
        }
    }
    @PutMapping("/{id}")
    public Response updatePembayaran(@PathVariable Integer id, @RequestBody Pembayaran pembayaran){
        return  new Response(pembayaranService.updatePembayaran(id,pembayaran),"Berhasil di update",HttpStatus.OK);
    }
}
