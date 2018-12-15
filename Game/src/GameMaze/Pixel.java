package GameMaze;

import java.awt.Image;

public class Pixel {
    
    private int posisiX;
    private int posisiY;
    private Image image;
    
    private int Jarak = 20;
    
    public Pixel(int x, int y) {
        this.posisiX = x;
        this.posisiY = y;
    }
    
    public int getPosisiX() {
        return posisiX;
    }

    public void setPosisiX(int posisiX) {
        this.posisiX = posisiX;
    }

    public int getPosisiY() {
        return posisiY;
    }

    public void setPosisiY(int posisiY) {
        this.posisiY = posisiY;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
    
    public boolean PosisiKiriObjek(Pixel Objek) {
        if (((this.getPosisiX() - Jarak) == Objek.getPosisiX()) && (this.getPosisiY() == Objek.getPosisiY())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean PosisiKananObjek(Pixel Objek) {
        if (((this.getPosisiX() + Jarak) == Objek.getPosisiX()) && (this.getPosisiY() == Objek.getPosisiY())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean PosisiAtasObjek(Pixel Objek) {
        if (((this.getPosisiY() - Jarak) == Objek.getPosisiY()) && (this.getPosisiX() == Objek.getPosisiX())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean PosisiBawahObjek(Pixel Objek) {
        if (((this.getPosisiY() + Jarak) == Objek.getPosisiY()) && (this.getPosisiX() == Objek.getPosisiX())) {
            return true;
        } else {
            return false;
        }
    }
}
