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
public class Gawang extends Pixel {

    public Gawang(int x, int y) {
        super(x, y); //mengakses constructor superclass(pixel) oleh subclass(gawang) dan langsung di set nilai xy gawang
        URL loc = this.getClass().getResource("gawang.jpg");
        ImageIcon g = new ImageIcon(loc);
        Image image = g.getImage();
        this.setImage(image);
    }
}
