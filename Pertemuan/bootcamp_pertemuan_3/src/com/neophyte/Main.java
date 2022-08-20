package com.neophyte;

import java.util.Scanner;

import static java.lang.Math.sqrt;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        boolean ulangi = true;

        do{
            System.out.println("<=================================================>");
            System.out.println("<=== Menghitung luas dan keliling bangun datar ===>");
            System.out.println("<=================================================>");
            System.out.println("1. Persegi");
            System.out.println("2. Lingkaran");
            System.out.println("3. Segi tiga");
            System.out.println("4. Keluar");
            System.out.println("<=================================================>");
            System.out.print("Masukan pilihan : ");
            int pilih = input.nextInt();

            if(pilih == 1 || pilih == 2 || pilih == 3) {
                System.out.println("<=================================================>");
                System.out.println("1. Keliling");
                System.out.println("2. Luas");
                System.out.println("3. Keluar");
                System.out.print("Masukan pilihan : ");
                int pilih2 = input.nextInt();

                if(pilih == 1){
                    if(pilih2 == 1)
                        kelilingPersegi();
                    else if(pilih2 == 2)
                        luasPersegi();
                    else if(pilih2 == 3)
                        System.out.println("Anda keluar");
                    else
                        System.out.println("Inputan salah");
                }else if(pilih == 2){
                    if(pilih2 == 1)
                        kelilingLingkaran();
                    else if(pilih2 == 2)
                        luasLingkaran();
                    else if(pilih2 == 3)
                        System.out.println("Anda keluar");
                    else
                        System.out.println("Inputan salah");
                }else if(pilih == 3){
                    if(pilih2 == 1)
                        kelilingSegitiga();
                    else if(pilih2 == 2)
                        luasSegitiga();
                    else if(pilih2 == 3)
                        System.out.println("Anda keluar");
                    else
                        System.out.println("Inputan salah");
                }
            }
            else if(pilih == 4){
                ulangi = false;
            }else{
                System.out.println("Input salah");
            }
        }while(ulangi);
        System.out.println("Program selesai");
    }

    static void kelilingPersegi() {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukan sisi : ");
        double sisi = input.nextDouble();
        double keliling = hitungKelPersegi(sisi);
        System.out.println("Keliling persegi : " + keliling);
    }

    static double hitungKelPersegi(double s){
        return s * 4;
    }

    static void luasPersegi() {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukan sisi : ");
        double sisi = input.nextDouble();
        double luas = hitungLuasPersegi(sisi);
        System.out.println("Luas persegi : " + luas);
    }

    static double hitungLuasPersegi(double s){
        return s * s;
    }

    static void kelilingLingkaran() {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukan jari-jari : ");
        double r = input.nextDouble();
        double keliling = hitungKelLingkaran(r);
        System.out.println("Keliling persegi : " + keliling);
    }

    static double hitungKelLingkaran(double r){
        return 2 * 3.14 * r;
    }

    static void luasLingkaran() {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukan jari-jari : ");
        double r = input.nextDouble();
        double luas = hitungLuasLingkaran(r);
        System.out.println("Luas lingkaran : " + luas);
    }

    static double hitungLuasLingkaran(double r){
        return 3.14 * r * r;
    }

    static void kelilingSegitiga() {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukan alas : ");
        double alas = input.nextDouble();
        System.out.print("Masukan tinggi : ");
        double tinggi = input.nextDouble();

        double keliling = hitungKelSegitiga(alas, tinggi);
        System.out.println("Keliling persegi : " + keliling);
    }

    static double hitungKelSegitiga(double a, double t){
        double sisic = sqrt((a*a) + (t*t));
        return a + t + sisic;
    }

    static void luasSegitiga() {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukan alas : ");
        double alas = input.nextDouble();
        System.out.print("Masukan tinggi : ");
        double tinggi = input.nextDouble();

        double luas = hitungLuasSegitiga(alas, tinggi);
        System.out.println("Luas lingkaran : " + luas);
    }

    static double hitungLuasSegitiga(double a, double t){
        return a * t / 2;
    }
}
