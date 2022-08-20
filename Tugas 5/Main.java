package com.neophyte;

public class Main implements MainInterface{
    private double sisi;

    public static void main(String[] args) {
        Main main = new Main();
        main.sisi = 6;

        main.keliling();
        main.luas();
    }

    @Override
    public void keliling(){
        double keliling = sisi * 4;
        System.out.println("Keliling : " + keliling);
    }

    @Override
    public void luas(){
        double luas = sisi * sisi;
        System.out.println("Luas : " + luas);
    }
}
