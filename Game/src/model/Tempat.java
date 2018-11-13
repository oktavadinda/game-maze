/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author okta v.
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
     * Fungsi pembaca file konfigurasi. Hasil pembacaan file akan disimpan di
     * atribut 'isi' dan juga di atribut daftarSel
     *
     * @param file
     */
    public void bacaKonfigurasi(File file) {
        this.isi = "";
        int data;
        int baris = 0;
        int kolom = 0;
        boolean hasil = false; //boolean untuk menentukan hasil yaitu false
        Tempat pointer = new Tempat(); //variable pointer meenggunakan tipe class tempat
        try {
            FileInputStream input = new FileInputStream(file); //buat variable input 
            while ((data = input.read()) != -1) {  // while dengan parameter data = input.read tidak sama dengan -1
                isi = isi + (char) data;
                if ((char) data != '\n') {  //deklarasi if dengan parameter data tidak sama dengan tab
                    Sel sel = new Sel(baris, kolom, (char) data);
                    this.tambahSel(sel);
                    kolom++; //kolom = kolom + 1
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tempat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Tempat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Fungsi penambah daftar sel.
     *
     * @param sel
     */
    public void tambahSel(Sel sel) {
        daftarSel.add(sel);
    }

    /**
     * @return the tinggi
     */
    public int getTinggi() {
        return tinggi;
    }

//    public void perintahGerak(String input){
//        String in[] = input.split(" ");
//        if (in.length > 2) {
//            JOptionPane.showMessageDialog(null, "Jumlah");
//        }
        
//    }
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

//    public int geserKiri() {
//        return 0;
//    }
//
//    public int geserKanan() {
//        return 0;
//    }
//
//    public int geserAtas() {
//        return 0;
//    }
//    public int geserBawah(){
//        return 0;
//    }
}
