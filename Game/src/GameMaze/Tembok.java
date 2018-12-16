package GameMaze;
/**
 *
 * @author by okta vadinda (175314107)
 */
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

public class Tembok extends Pixel{
    public Tembok(int x, int y) {
        super(x, y);//mengakses constructor superclass (pixel) oleh subclass (Tembok) dan langsung di set nilai xy Tembok 
        URL loc = this.getClass().getResource("tembok.jpg");
        ImageIcon g = new ImageIcon(loc);
        Image image = g.getImage();
        this.setImage(image);
    }
}
