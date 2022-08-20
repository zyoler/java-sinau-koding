package com.neophyte;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Mahasiswa {
    String nama;
    int nilai;
    String status;

    public Mahasiswa(String nama, int nilai, String status){
        this.nama = nama;
        this.nilai = nilai;
        this.status = status;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);

        System.out.print("Masukan jumlah mahasiswa : ");
        int total = input.nextInt();

        HashMap<Integer, Mahasiswa> data = new HashMap<>();
        for(int a = 1; a <= total; a++) {
            System.out.println("Mahasiswa ke : " + a);
            System.out.print("Nama : ");
            String nama = input2.nextLine();
            System.out.print("Nilai : ");
            int nilai = input.nextInt();

            data.put(a, new Mahasiswa(nama, nilai, nilai>=65? "Lulus":"Tidak lulus"));
        }

        System.out.println("No\tNama\tNilai\tStatus");
        for (int a = 1; a <= data.size(); a++){
            System.out.println(a + "\t" + data.get(a).nama + "\t" + data.get(a).nilai + "\t\t" + data.get(a).status);
        }
    }
}