 package GameMaze;
/**
 *
 * @author by okta vadinda (175314107)
 */
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

public class Pintu extends Pixel {
    public Pintu(int x, int y) {
        super(x, y); //mengakses constructor superclass(pixel) oleh subclass(pintu) dan langsung di set nilai xy pintu
        URL loc = this.getClass().getResource("pintu.png");
        ImageIcon g = new ImageIcon(loc);
        Image image = g.getImage();
        this.setImage(image);
    }
}
