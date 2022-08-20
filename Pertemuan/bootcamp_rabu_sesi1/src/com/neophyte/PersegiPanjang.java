package com.neophyte;

public class PersegiPanjang implements MainInterface {
    private double panjang, lebar;

    public static void main(String[] args){
        PersegiPanjang persegiPanjang = new PersegiPanjang();
        persegiPanjang.panjang = 5;
        persegiPanjang.lebar = 5;

        persegiPanjang.keliling();
        persegiPanjang.luas();
    }

    @Override
    public void keliling() {
        double keliling = 2 * (panjang + lebar);
        System.out.println("Keliling : " + keliling);
    }

    @Override
    public void luas() {
        double luas = panjang * lebar;
        System.out.println("Luas : " + luas);
    }

}
