 package GameMaze;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

public class Pintu extends Pixel {
    public Pintu(int x, int y) {
        super(x, y); //mengakses constructor superclass(pixel) oleh subclass(gawang) dan langsung di set nilai xy gawang
        URL loc = this.getClass().getResource("pintu.png");
        ImageIcon g = new ImageIcon(loc);
        Image image = g.getImage();
        this.setImage(image);
    }
}
