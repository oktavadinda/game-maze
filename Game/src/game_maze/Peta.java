package game_maze;

import java.io.File;
import java.util.ArrayList;
import javax.swing.JPanel;



public class Peta extends JPanel {

    private ArrayList tembok = new ArrayList(); //menyimpan data tembok
    private ArrayList bola = new ArrayList(); // menyimpan data bola
    private ArrayList gawang = new ArrayList(); // menyimpan data gawang
    public static ArrayList map = new ArrayList(); //menyimpan data tembok, gawang, bola, soko
    private Pemain soko;
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
                    }
                }
            }
        }
    }
}