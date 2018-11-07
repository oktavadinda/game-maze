/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author user only
 */
public class Tempat {
    private int tinggi; // tinggi tempat Game
    private int lebar;  // lebar tempat Game
    private ArrayList<Sel> daftarSel; // daftar sel

    private String isi; // isi file konfigurasi
    
    public static int batasKanan;
    public static int batasBawah;
    
    public Tempat() {
        daftarSel = new ArrayList<Sel>();
    }
    
    
    
    /**
     * Fungsi pembaca file konfigurasi.
     * Hasil pembacaan file akan disimpan di atribut 'isi'.
     * @param file 
     */
    public void bacaKonfigurasi(File file){
        
    }
    /**
     * Fungsi penambah daftar sel.
     * @param sel 
     */
    public void tambahSel(Sel sel){
        daftarSel.add(sel);
    }

    /**
     * @return the tinggi
     */
    public int getTinggi() {
        return tinggi;
    }

    /**
     * @param tinggi the tinggi to set
     */
    public void setTinggi(int tinggi) {
        this.tinggi = tinggi;
    }

    /**
     * @return the lebar
     */
    public int getLebar() {
        return lebar;
    }

    /**
     * @param lebar the lebar to set
     */
    public void setLebar(int lebar) {
        this.lebar = lebar;
    }

    /**
     * @return the daftarSel
     */
    public ArrayList<Sel> getDaftarSel() {
        return daftarSel;
    }

    /**
     * @param daftarSel the daftarSel to set
     */
    public void setDaftarSel(ArrayList<Sel> daftarSel) {
        this.daftarSel = daftarSel;
    }

    /**
     * @return the isi
     */
    public String getIsi() {
        return isi;
    }

    /**
     * @param isi the isi to set
     */
    public void setIsi(String isi) {
        this.isi = isi;
    }
}
