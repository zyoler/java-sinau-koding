package com.neophyte;

public class Lingkaran implements MainInterface{
    private double r;

    public static void main(String[] args){
        Lingkaran lingkaran = new Lingkaran();
        lingkaran.r = 7;

        lingkaran.keliling();
        lingkaran.luas();
    }

    @Override
    public void keliling() {
        double keliling = 2 * 3.14 * r;
        System.out.println("Keliling : " + keliling);
    }

    @Override
    public void luas() {
        double luas = 3.14 * r * r;
        System.out.println("Luas : " + luas);
    }
}
