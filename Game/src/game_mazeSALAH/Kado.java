/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_mazeSALAH;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author okta vadinda
 */
public class Kado extends Pixel {

    public Kado(int x, int y) {
        super(x, y);//mengakses constructor superclass (pixel) oleh subclass (bola) dan langsung di set nilai xy bola.
        URL loc = this.getClass().getResource("kado.png");
        ImageIcon i = new ImageIcon(loc);
        Image image = i.getImage();
        this.setImage(image);

    }

    public void Gerak(int x, int y) {
        int nx = this.getPosisiX() + x;//bergerak kiri atau kanan, tergantung nilai x jika negative maka ke kiri, positive maka ke kanan
        int ny = this.getPosisiY() + y;//bergerak kiri atau kanan, tergantung nilai y jika negative maka ke atas, positive maka ke bawah
        this.setPosisiX(nx);
        this.setPosisiY(ny);
    }
}
