package com.example.TugasAkhir_Perpustakaan.controller;

import com.example.TugasAkhir_Perpustakaan.common.Response;
import com.example.TugasAkhir_Perpustakaan.model.User;
import com.example.TugasAkhir_Perpustakaan.model.dto.UserDto;
import com.example.TugasAkhir_Perpustakaan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public Response findAllUser(){
        return new Response(userService.findAllUser(),userService.findAllUser().size(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public Response findById(@PathVariable Integer id){
        return new Response(userService.findByIdUser(id),"Berhasil di tampilkan",HttpStatus.OK);
    }
    @PostMapping
    public Response saveUser(@RequestBody UserDto user){
        return new Response(userService.createUser(user),"Berhasil disimpan",HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public Response deleteBarang(@PathVariable Integer id){
        if(userService.deleteUser(id)){
            return new Response("Berhasil dihapus",HttpStatus.OK);
        }else{
            return new Response("Gagal dihapus",HttpStatus.OK);
        }
    }
    @PutMapping("/{id}")
    public Response updateUser(@PathVariable Integer id, @RequestBody User user){
        return new Response(userService.updateUser(id,user),"Berhasil di update",HttpStatus.OK);
    }
}
