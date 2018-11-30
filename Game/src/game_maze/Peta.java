package game_maze;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

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
}
