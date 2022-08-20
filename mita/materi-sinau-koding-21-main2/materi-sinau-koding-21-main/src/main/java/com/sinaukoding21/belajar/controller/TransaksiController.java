package com.sinaukoding21.belajar.controller;

import com.sinaukoding21.belajar.common.Response;
import com.sinaukoding21.belajar.model.Barang;
import com.sinaukoding21.belajar.model.Transaksi;
import com.sinaukoding21.belajar.model.dto.TransaksiDto;
import com.sinaukoding21.belajar.service.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaksi")
public class TransaksiController {
    @Autowired
    TransaksiService transaksiService;

    @GetMapping
    public Response findAllTransaksi(){
        return new Response(transaksiService.findAllTransaksi(), transaksiService.findAllTransaksi().size(),HttpStatus.OK);
    }
    @PostMapping
    public Response saveTransaksi(@RequestBody TransaksiDto transaksi){
        return new Response(transaksiService.createTransaksi(transaksi),"Berhasil disimpan",HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public Response deleteTransaksi(@PathVariable Integer id){
        if(transaksiService.deleteTransaksi(id)){
            return new Response("Berhasil dihapus",HttpStatus.OK);
        }else{
            return new Response("Gagal dihapus",HttpStatus.OK);
        }
    }
    @PutMapping("/{id}")
    public Response updateTransaksi(@PathVariable Integer id, @RequestBody Transaksi transaksi){
        return new Response(transaksiService.updateTransaksi(id,transaksi),"Berhasil di update",HttpStatus.OK);

    }
}
