package com.example.ericagustianwinardi;

import java.util.HashMap;
import java.util.Map;

public class EricAgustianWinardi {
    private double lama,persen,jumlah,jumlahperbulan,perbulan,bungaPerBulan;

    private final Map<String, Map> pinjaman = new HashMap<>();

    public EricAgustianWinardi(double JumlahPinjaman, double LamaAngsuran, double PersenanPinjaman) {
        lama = LamaAngsuran;
        jumlah = JumlahPinjaman;
        jumlahperbulan = JumlahPinjaman;
        persen = PersenanPinjaman;
        Jumlahkan();
    }

    public void Jumlahkan() {
        int bulan = 0;
        perbulan = jumlah / lama;
        bungaPerBulan = persen / 12;
        if(bulan == 0){
            Map<String, Double> angsuran = new HashMap<>();

            angsuran.put("Bunga", 0.0);
            angsuran.put("Pokok", 0.0);
            angsuran.put("Total", 0.0);
            angsuran.put("Sisa", jumlahperbulan);
            pinjaman.put(Integer.toString(bulan), angsuran);
        }
        for (bulan = 1; bulan < lama + 1; bulan++) {
            double bunga = jumlahperbulan * bungaPerBulan / 100;
            jumlahperbulan = jumlahperbulan - perbulan;
            Map<String, Double> angsuran = new HashMap<>();

            angsuran.put("Bunga", bunga);
            angsuran.put("Pokok", perbulan);
            angsuran.put("Total", bunga + perbulan);
            angsuran.put("Sisa", jumlahperbulan);

            pinjaman.put(Integer.toString(bulan), angsuran);
        }
    }

    public Map Hasil() {
        return pinjaman;
    }
}
