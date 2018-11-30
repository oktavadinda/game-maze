/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_maze;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author okta vadinda
 */
public class Bola extends Pixel {
    
    public Bola(int x, int y) {
        super(x, y);//mengakses constructor superclass (pixel) oleh subclass (bola) dan langsung di set nilai xy bola.
        URL loc = this.getClass().getResource("bola.jpg");
        ImageIcon i = new ImageIcon(loc);
        Image image = i.getImage();
        this.setImage(image);
        
    }

    public void Gerak(int x, int y) {
        int nx = this.getPosisiX() + x;
        int ny = this.getPosisiY() + y;
        this.setPosisiX(nx);
        this.setPosisiY(ny);
    }
}
