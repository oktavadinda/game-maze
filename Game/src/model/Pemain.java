/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author asus
 */
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

public class Pemain extends Pixel {

    public Pemain(int x, int y) {
        super(x, y); //mengakses constructor superclass (pixel) oleh subclass (Pemain) dan lansung di set nilai xy Pemain 
        URL loc = this.getClass().getResource("pemain.jpg");
        ImageIcon iia = new ImageIcon(loc);
        Image image = iia.getImage();
        this.setImage(image);
    }

    public void Gerak(int x, int y) {
        int nx = this.getPosisiX() + x;//bergerak kiri atau kanan, tergantung nilai x jika negative maka ke kiri, positive maka ke kanan
        int ny = this.getPosisiY() + y;//bergerak atas atau bawah, tergantung nilai y jika negative maka ke atas, positive maka ke bawah
        this.setPosisiX(nx);
        this.setPosisiY(ny);
    }
}
