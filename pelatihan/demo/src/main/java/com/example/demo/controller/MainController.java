package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MainController {

    @GetMapping("/home")
    public List<Integer> home(){
        //int[] numbers= {1,2,3};
        List<Integer> number = new ArrayList<>();
        number.add(1);
        number.add(2);
        number.add(3);
        number.add(4);
        number.add(5);
        return number;
    }

    @GetMapping("/object")
    public Map<String,Object> object(){
        Map<String,Object> a = new HashMap<>();
        a.put("Nama :","Dani <3");
        a.put("Umur :",20);
        a.put("Status :","15 20 13 24 1 _ 12 8 19 1");

        Map<String,Object> detail = new HashMap<>();
        detail.put("Jurusan :", "D3 MI");
        detail.put("Semester :",4);

        a.put("b",detail);
        return a;
    }
}
