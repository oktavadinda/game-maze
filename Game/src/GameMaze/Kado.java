package GameMaze;
/**
 * 
 * @author by okta vadinda (175314107)
 */
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

public class Kado extends Pixel {
    
    public Kado(int x, int y) {
        super(x, y);//mengakses constructor superclass (pixel) oleh subclass (kado) dan langsung di set nilai xy kado.
        URL loc = this.getClass().getResource("kado.png");
        ImageIcon g = new ImageIcon(loc);
        Image image = g.getImage();
        this.setImage(image);
    }
    
    public void Gerak(int x, int y) {
        int nx = this.getPosisiX() + x;//bergerak kiri atau kanan, tergantung nilai x jika negative maka ke kiri, positive maka ke kanan
        int ny = this.getPosisiY() + y;//bergerak kiri atau kanan, tergantung nilai y jika negative maka ke atas, positive maka ke bawah
        this.setPosisiX(nx);
        this.setPosisiY(ny);
    }
}
