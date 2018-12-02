package game_maze;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author okta vadinda
 */
public class Peta extends JPanel {

    private ArrayList tembok = new ArrayList(); //menyimpan data tembok
    private ArrayList bola = new ArrayList(); // menyimpan data bola
    private ArrayList gawang = new ArrayList(); // menyimpan data gawang
    public static ArrayList map = new ArrayList(); //menyimpan data tembok, gawang, bola, soko
    private Pemain maze;
    private int lebar = 0;
    private int tinggi = 0;
    private int jarak = 20; //untuk menentukan besarnya pixel/jarak space gambar didalam panel.

    private File Alamatpeta; // digunakan untuk merestart level
    private ArrayList Allperintah = new ArrayList(); // menyimpan semua perintah yang dimasukkan

    public Peta(File file) {
        setPeta(file);
    }

    public void setPeta(File file) {
        try {
            if (file != null) {
                FileInputStream input = new FileInputStream(file);
                Alamatpeta = file;
                int posisiX = 0;
                int posisiY = 0;
                Tembok wall;
                Bola b;
                Gawang a;
                int data;
                while ((data = input.read()) != -1) {
                    char item = (char) data;
                    if (item == '\n') {
                        posisiY += jarak;
                        lebar = posisiX;
                        posisiX = 0;
                    } else if (item == '#') {
                        wall = new Tembok(posisiX, posisiY);
                        tembok.add(wall);
                        posisiX += jarak;
                    } else if (item == 'x') {
                        b = new Bola(posisiX, posisiY);
                        bola.add(b);
                        posisiX += jarak;
                    } else if (item == 'o') {
                        a = new Gawang(posisiX, posisiY);
                        gawang.add(a);
                        posisiX += jarak;
                    } else if (item == '@') {
                        maze = new Pemain(posisiX, posisiY);
                        posisiX += jarak;
                    } else if (item == '.') {
                        posisiX += jarak;
                    }
                    tinggi = posisiY;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Peta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); //Hapus background
        //Tempat gambar :
        g.setColor(new Color(255, 255, 255)); //set panel warna putih
        g.fillRect(0, 0, this.getLebar(), this.getTinggi()); //set tinggi lebar sesuai konfigurasi
        map.addAll(tembok);
        map.addAll(gawang);
        map.addAll(bola);
        map.add(maze);
        for (int i = 0; i < map.size(); i++) {
            if (map.get(i) != null) {
                Pixel item = (Pixel) map.get(i); //map dterjemahkan dalam kelas pixel.
                g.drawImage(item.getImage(), item.getPosisiX(), item.getPosisiY(), this); //proses gambar di panel.
            }
        }
    }

    public int getLebar() {
        return this.lebar;
    }

    public int getTinggi() {
        return this.tinggi;
    }
    public void PerintahGerak(String input) {
        String in[] = input.split(" ");
        if (in.length > 2) {
            JOptionPane.showMessageDialog(null, "Jumlah kata lebih dari 2");
        } 
}
