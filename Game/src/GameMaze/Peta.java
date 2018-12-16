package GameMaze;
/**
 * 
 * @author by okta vadinda (175314107)
 */
import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Peta extends JPanel {

    private ArrayList tembok = new ArrayList(); //menyimpan data tembok
    private ArrayList kado = new ArrayList(); // menyimpan data bola
    private ArrayList pintu = new ArrayList(); // menyimpan data gawang
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
                Kado b;
                Pintu a;
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
                        b = new Kado(posisiX, posisiY);
                        kado.add(b);
                        posisiX += jarak;
                    } else if (item == 'o') {
                        a = new Pintu(posisiX, posisiY);
                        pintu.add(a);
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
        map.addAll(pintu);
        map.addAll(kado);
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
        } else if (in.length == 2) {
            if (in[0].matches("[udrlz]")) {
                Allperintah.add(input);
                if (in[0].equalsIgnoreCase("u")) {
                    for (int i = 0; i < Integer.parseInt(String.valueOf(in[1])); i++) {
                        if (cekObjekNabrakTembok(maze, "u")) {
                            return;
                        } else if (cekKadoPemainTembok("u")) {
                            return;
                        } else {
                            maze.Gerak(0, -jarak);
                            repaint();
                        }
                    }
                } else if (in[0].equalsIgnoreCase("d")) {
                    for (int i = 0; i < Integer.parseInt(String.valueOf(in[1])); i++) {
                        if (cekObjekNabrakTembok(maze, "d")) {
                            return;
                        } else if (cekKadoPemainTembok("d")) {
                            return;
                        } else {
                            maze.Gerak(0, jarak);
                            repaint();
                        }
                    }
                } else if (in[0].equalsIgnoreCase("r")) {
                    for (int i = 0; i < Integer.parseInt(String.valueOf(in[1])); i++) {
                        if (cekObjekNabrakTembok(maze, "r")) {
                            return;
                        } else if (cekKadoPemainTembok("r")) {
                            return;
                        } else {
                            maze.Gerak(jarak, 0);
                            repaint();
                        }
                    }
                } else if (in[0].equalsIgnoreCase("l")) {
                    for (int i = 0; i < Integer.parseInt(String.valueOf(in[1])); i++) {
                        if (cekObjekNabrakTembok(maze, "l")) {
                            return;
                        } else if (cekKadoPemainTembok("l")) {
                            return;
                        } else {
                            maze.Gerak(-jarak, 0);
                            repaint();
                        }
                    }
                } else if (in[0].equalsIgnoreCase("z")) {
                    for (int i = 0; i < Integer.parseInt(String.valueOf(in[1])); i++) {
                        UndoPerintah();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Kata Tidak Dikenal");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Kata Tidak Dikenal");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Jumlah kata hanya satu");
        }
    }

    private boolean cekObjekNabrakTembok(Pixel pemain, String input) {
        boolean bantu = false;
        if (input.equalsIgnoreCase("l")) {
            for (int i = 0; i < tembok.size(); i++) {
                Tembok wall = (Tembok) tembok.get(i);//ambil posisi tembok
                if (pemain.PosisiKiriObjek(wall)) {
                    bantu = true;
                    break;
                }
            }

        } else if (input.equalsIgnoreCase("r")) {
            for (int i = 0; i < tembok.size(); i++) {
                Tembok wall = (Tembok) tembok.get(i);//ambil posisi tembok
                if (pemain.PosisiKananObjek(wall)) {
                    bantu = true;
                    break;
                }
            }
        } else if (input.equalsIgnoreCase("u")) {
            for (int i = 0; i < tembok.size(); i++) {
                Tembok wall = (Tembok) tembok.get(i);//ambil posisi tembok
                if (pemain.PosisiAtasObjek(wall)) {
                    bantu = true;
                    break;
                }
            }
        } else if (input.equalsIgnoreCase("d")) {
            for (int i = 0; i < tembok.size(); i++) {
                Tembok wall = (Tembok) tembok.get(i);//ambil posisi tembok
                if (pemain.PosisiBawahObjek(wall)) {
                    bantu = true;
                    break;
                }
            }
        } else if (input.equalsIgnoreCase("z")) {
            UndoPerintah();
        }
        return bantu;//default return false
    }

    private boolean cekKadoNabrakKado(Pixel objek, String input) {
        boolean bantu = false;
        if (input.equalsIgnoreCase("l")) {
            for (int i = 0; i < kado.size(); i++) {
                Kado bol = (Kado) kado.get(i);//ambil posisi kado
                if (objek.PosisiKiriObjek(bol)) {
                    bantu = true;
                    break;
                }
            }
        } else if (input.equalsIgnoreCase("r")) {
            for (int i = 0; i < kado.size(); i++) {
                Kado bol = (Kado) kado.get(i);//ambil posisi kado
                if (objek.PosisiKananObjek(bol)) {
                    bantu = true;
                    break;
                }
            }

        } else if (input.equalsIgnoreCase("u")) {
            for (int i = 0; i < kado.size(); i++) {
                Kado bol = (Kado) kado.get(i);//ambil posisi kado
                if (objek.PosisiAtasObjek(bol)) {
                    bantu = true;
                    break;
                }
            }

        } else if (input.equalsIgnoreCase("d")) {
            for (int i = 0; i < kado.size(); i++) {
                Kado bol = (Kado) kado.get(i);//ambil posisi kado
                if (objek.PosisiBawahObjek(bol)) {
                    bantu = true;
                    break;
                }
            }
        } else if (input.equalsIgnoreCase("z")) {
            UndoPerintah();
        }
        return bantu;//default return false
    }

    private boolean cekKadoPemainTembok(String input) {
        boolean bantu = false;
        if (input.equalsIgnoreCase("l")) {
            for (int i = 0; i < kado.size(); i++) {
                Kado bol1 = (Kado) kado.get(i);//ambil posisi kado
                if (maze.PosisiKiriObjek(bol1)) {//cek apakah pemain sebelah kiri kado ke i
                    if (cekKadoNabrakKado(bol1, "l")) {//cek apakah kado ke satu nabrak tembok.
                        bantu = true;//ya, tidak boleh bergerak.
                        break;//hentikan proses looping i
                    } else if (cekObjekNabrakTembok(bol1, "l")) {//cek apakah kado ke satu nabrak tembok.
                        bantu = true;//ya, tidak boleh bergerak.
                        break;//hentikan proses looping i
                    } else {
                        bol1.Gerak(-jarak, 0);//kado ikut bergerak ke kiri
                        isCompleted();
                    }
                }
            }
        } else if (input.equalsIgnoreCase("r")) {
            for (int i = 0; i < kado.size(); i++) {
                Kado bol1 = (Kado) kado.get(i);//ambil posisi kado
                if (maze.PosisiKananObjek(bol1)) {//cek apakah pemain sebelah kanan kado ke i
                    if (cekKadoNabrakKado(bol1, "r")) {//cek apakah kado ke satu nabrak tembok.
                        bantu = true;//ya, tidak boleh bergerak.
                        break;//hentikan proses looping i
                    } else if (cekObjekNabrakTembok(bol1, "r")) {//cek apakah kado ke satu nabrak tembok.
                        bantu = true;//ya, tidak boleh bergerak.
                        break;//hentikan proses looping i
                    } else {
                        bol1.Gerak(jarak, 0);//kado ikut bergerak ke kanan
                        isCompleted();
                    }
                }
            }
        } else if (input.equalsIgnoreCase("u")) {
            for (int i = 0; i < kado.size(); i++) {
                Kado bol1 = (Kado) kado.get(i);//ambil posisi kado
                if (maze.PosisiAtasObjek(bol1)) {//cek apakah kado 1 di atas pemain
                    if (cekKadoNabrakKado(bol1, "u")) {//cek apakah kado ke satu nabrak tembok.
                        bantu = true;//ya, tidak boleh bergerak.
                        break;//hentikan proses looping i
                    } else if (cekObjekNabrakTembok(bol1, "u")) {//cek apakah kado ke satu nabrak tembok.
                        bantu = true;//ya, tidak boleh bergerak.
                        break;//hentikan proses looping i
                    } else {
                        bol1.Gerak(0, -jarak);//kado ikut bergerak ke atas
                        isCompleted();
                    }
                }
            }
        } else if (input.equalsIgnoreCase("d")) {
            for (int i = 0; i < kado.size(); i++) {
                Kado bol1 = (Kado) kado.get(i);//ambil posisi kado
                if (maze.PosisiBawahObjek(bol1)) {//cek apakah kado 1 di bawah pemain
                    if (cekKadoNabrakKado(bol1, "d")) {//cek apakah kado ke satu nabrak tembok.
                        bantu = true;//ya, tidak boleh bergerak.
                        break;//hentikan proses looping i
                    } else if (cekObjekNabrakTembok(bol1, "d")) {//cek apakah kado ke satu nabrak tembok.
                        bantu = true;//ya, tidak boleh bergerak.
                        break;//hentikan proses looping i
                    } else {
                        bol1.Gerak(0, jarak);//kado ikut bergerak ke bawah
                        isCompleted();
                    }
                }
            }
        } else if (input.equalsIgnoreCase("z")) {
            UndoPerintah();
        }
        return bantu;
    }

    public void UndoPerintah() {
        for (int i = Allperintah.size() - 1; i >= 0; i--) {
            String input = Allperintah.get(i).toString();
            String in[] = input.split(" ");
            if (in[0].equalsIgnoreCase("u")) {
                if (cekObjekNabrakTembok(maze, "d")) {
                    return;
                } else if (cekUndoKado("d")) {
                    return;
                } else {
                    maze.Gerak(0, jarak);
                    repaint();
                }
                break;
            } else if (in[0].equalsIgnoreCase("d")) {
                if (cekObjekNabrakTembok(maze, "u")) {
                    return;
                } else if (cekUndoKado("u")) {
                    return;
                } else {
                    maze.Gerak(0, -jarak);
                    repaint();
                }
                break;
            } else if (in[0].equalsIgnoreCase("r")) {
                if (cekObjekNabrakTembok(maze, "l")) {
                    return;
                } else if (cekUndoKado("l")) {
                    return;
                } else {
                    maze.Gerak(-jarak, 0);
                    repaint();
                }
                break;
            } else if (in[0].equalsIgnoreCase("l")) {
                if (cekObjekNabrakTembok(maze, "r")) {
                    return;
                } else if (cekUndoKado("r")) {
                    return;
                } else {
                    maze.Gerak(jarak, 0);
                    repaint();
                }
                break;
            }
        }
    }

    private boolean cekUndoKado(String type) {
        if (type == "u") {
            for (int i = 0; i < kado.size(); i++) {
                Kado bol = (Kado) kado.get(i);
                if (maze.PosisiBawahObjek(bol)) {
                    for (int j = 0; j < kado.size(); j++) {
                        Kado item = (Kado) kado.get(j);
                        if (!bol.equals(item)) {
                            if (bol.PosisiBawahObjek(item)) {
                                return true;
                            }
                        }
                        if (cekObjekNabrakTembok(bol, "u")) {
                            return true;
                        }
                    }
                    bol.Gerak(0, -jarak);
                    isCompleted();
                }
            }
            return false;
        } else if (type == "d") {
            for (int i = 0; i < kado.size(); i++) {
                Kado bol = (Kado) kado.get(i);
                if (maze.PosisiAtasObjek(bol)) {
                    for (int j = 0; j < kado.size(); j++) {
                        Kado item = (Kado) kado.get(j);
                        if (!bol.equals(item)) {
                            if (bol.PosisiAtasObjek(item)) {
                                return true;
                            }
                        }
                        if (cekObjekNabrakTembok(bol, "d")) {
                            return true;
                        }
                    }
                    bol.Gerak(0, jarak);
                    isCompleted();
                }
            }
            return false;
        } else if (type == "l") {
            for (int i = 0; i < kado.size(); i++) {
                Kado bol = (Kado) kado.get(i);
                if (maze.PosisiKananObjek(bol)) {
                    for (int j = 0; j < kado.size(); j++) {
                        Kado item = (Kado) kado.get(j);
                        if (!bol.equals(item)) {
                            if (bol.PosisiKananObjek(item)) {
                                return true;
                            }
                        }
                        if (cekObjekNabrakTembok(bol, "l")) {
                            return true;
                        }
                    }
                    bol.Gerak(-jarak, 0);
                    isCompleted();
                }
            }
            return false;
        } else if (type == "r") {
            for (int i = 0; i < kado.size(); i++) {
                Kado bol = (Kado) kado.get(i);
                if (maze.PosisiKiriObjek(bol)) {
                    for (int j = 0; j < kado.size(); j++) {
                        Kado item = (Kado) kado.get(j);
                        if (!bol.equals(item)) {
                            if (bol.PosisiKiriObjek(item)) {
                                return true;
                            }
                        }
                        if (cekObjekNabrakTembok(bol, "r")) {
                            return true;
                        }
                    }
                    bol.Gerak(jarak, 0);
                    isCompleted();
                }
            }
        }
        return false;
    }

    public void isCompleted() {
        int jumBola = kado.size();//jumlah bola
        int goal = 0;
        for (int i = 0; i < kado.size(); i++) {
            Kado bol = (Kado) kado.get(i);//ambil posisi bola
            for (int j = 0; j < pintu.size(); j++) {
                Pintu gaw = (Pintu) pintu.get(j);//ambil posisi gawang
                if (bol.getPosisiX() == gaw.getPosisiX() && bol.getPosisiY() == gaw.getPosisiY()) {
                    //cek posisi bola sama dengan bola.
                    goal += 1;
                }
            }
        }
        if (goal == jumBola) {//jika semua gawang sudah terisi bola
            JOptionPane.showMessageDialog(null, "Selamat anda berhasil menyelesaikan game ini.");
            int poin = Allperintah.size();
            if (Allperintah.size() <= 20) {
                poin = 100;
                JOptionPane.showMessageDialog(null, "Total perintah yang anda masukkan : " + Allperintah.size());
                JOptionPane.showMessageDialog(null, "Poin Akhir anda : " + poin);
            } else if (Allperintah.size() > 20 || Allperintah.size() >= 40) {
                poin = 80;
                JOptionPane.showMessageDialog(null, "Total perintah yang anda masukkan : " + Allperintah.size());
                JOptionPane.showMessageDialog(null, "Poin Akhir anda : " + poin);
            } else if (Allperintah.size() > 40 || Allperintah.size() >= 60) {
                poin = 60;
                JOptionPane.showMessageDialog(null, "Total perintah yang anda masukkan : " + Allperintah.size());
                JOptionPane.showMessageDialog(null, "Poin Akhir anda : " + poin);
            } else if (Allperintah.size() > 60 || Allperintah.size() >= 80) {
                poin = 50;
                JOptionPane.showMessageDialog(null, "Total perintah yang anda masukkan : " + Allperintah.size());
                JOptionPane.showMessageDialog(null, "Poin Akhir anda : " + poin);
            } else if (Allperintah.size() > 80 || Allperintah.size() >= 100) {
                poin = 50;
                JOptionPane.showMessageDialog(null, "Total perintah yang anda masukkan : " + Allperintah.size());
                JOptionPane.showMessageDialog(null, "Poin Akhir anda : " + poin);
            } else {
                poin = 40;
                JOptionPane.showMessageDialog(null, "Total perintah yang anda masukkan : " + Allperintah.size());
                JOptionPane.showMessageDialog(null, "Poin Akhir anda : " + poin);
            }
        }
    }

    public void restartLevel() {
        Allperintah.clear();//hapus semua perintah yang tersimpan
        pintu.clear();//hapus pintu
        kado.clear();//hapus kado
        tembok.clear();//hapus tembok
        map.clear();//hapus map
        setPeta(Alamatpeta);//set ulang gambar peta
        repaint();//gambar ulang
    }

    public String getTeksPerintah() {
        String bantu = "";
        for (int i = 0; i < Allperintah.size(); i++) {
            bantu = bantu + Allperintah.get(i) + " ";
        }
        return bantu;
    }

}
