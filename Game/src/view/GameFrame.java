/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Sel;

/**
 *
 * @author user only
 */
public class GameFrame extends JFrame {

    private TempatPanel tempatPanel;

    private JLabel perintahlabel;
    private JTextField perintahText;
    private JButton pindahKananButton;
    private JButton pindahKiriButton;
    private JButton pindahAtasButton;
    private JButton pindahBawahButton;
    private JButton tambahButton;
    private JButton hapusButton;

    private JMenuBar menuBar;
    private JMenu gameMenu;
    private JMenuItem exitMenuItem;
    private JMenuItem bacaKonfigurasiMenuItem;

    public GameFrame(String title) {
        this.setTitle(title);
        this.init();
    }

    public GameFrame(String title, TempatPanel tempatPanel) {
        setTitle(title);
        this.tempatPanel = tempatPanel;
        this.init();
    }

    public void init() {
        // set ukuran dan layout
        this.setSize(800, 500);
        this.setLayout(new BorderLayout());

        // set menu Bar
        menuBar = new JMenuBar();
        gameMenu = new JMenu("Game");
        exitMenuItem = new JMenuItem("Keluar");
        bacaKonfigurasiMenuItem = new JMenuItem("Baca");
        gameMenu.add(bacaKonfigurasiMenuItem);
        gameMenu.add(exitMenuItem);
        menuBar.add(gameMenu);
        setJMenuBar(menuBar);

        //action perform for exitMenuItem
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }
        );

        // panel selatan
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout());

        this.perintahlabel = new JLabel("Perintah");
        southPanel.add(perintahlabel);

        this.perintahText = new JTextField(20);
        southPanel.add(perintahText);

        this.pindahKananButton = new JButton("Kanan");
        southPanel.add(pindahKananButton);

        pindahKananButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pindahKanan();
            }
        });

        this.pindahKiriButton = new JButton("Kiri");
        southPanel.add(pindahKiriButton);

        pindahKiriButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pindahKiri();
            }
        });

        this.pindahAtasButton = new JButton("Atas");
        southPanel.add(pindahAtasButton);

        pindahAtasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pindahAtas();
            }
        });
        
        this.pindahBawahButton = new JButton("Bawah");
        southPanel.add(pindahBawahButton);

        pindahBawahButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pindahBawah();
            }
        });

        this.tambahButton = new JButton("tambahBola");
        southPanel.add(tambahButton);
        tambahButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tambahBola();
            }
        });

        this.hapusButton = new JButton("hapusBola");
        southPanel.add(hapusButton);

        hapusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hapusBola();
            }
        });
        // set contentPane
        Container cp = this.getContentPane();
        if (tempatPanel != null) {
            cp.add(getTempatPanel(), BorderLayout.CENTER);
        }
        cp.add(southPanel, BorderLayout.SOUTH);

        // set visible= true
        this.setVisible(true);
    }

    /**
     * Fungsi untuk tambahBola
     */
    public void tambahBola() {
        tempatPanel.getTempat().tambahSel(new Sel(0, 0, 25, 25, '#', Color.BLUE));
    }

    /**
     * Fungsi hapus bola
     */
    public void hapusBola() {
        tempatPanel.getTempat().hapusSel();
    }

    /**
     * Fungsi untuk memindahkan sel dan menggambar ulang
     */
    public void pindahKanan() {
        // posisiX seluruh sel ditambah 20
        // sehingga sel akan terlihat bergerak ke kanan
        for (int i = 0; i < getTempatPanel().getTempat().getDaftarSel().size(); i++) {
            // set posisiX yang baru
            getTempatPanel().getTempat().getDaftarSel().get(i).geserKanan();
        }
        // gambar ulang tempat Panel
        getTempatPanel().repaint();
    }

    /**
     * Fungsi untuk memindahkan sel dan menggambar ulang
     */
    public void pindahKiri() {
        // posisiX seluruh sel ditambah 20
        // sehingga sel akan terlihat bergerak ke kiri
        for (int i = 0; i < getTempatPanel().getTempat().getDaftarSel().size(); i++) {
            // set posisiX yang baru
            getTempatPanel().getTempat().getDaftarSel().get(i).geserKiri();
        }
        // gambar ulang tempat Panel
        getTempatPanel().repaint();
    }
    
     /**
     * Fungsi untuk memindahkan sel dan menggambar ulang
     */
    public void pindahAtas() {
        // posisiX seluruh sel ditambah 20
        // sehingga sel akan terlihat bergerak ke atas
        for (int i = 0; i < getTempatPanel().getTempat().getDaftarSel().size(); i++) {
            // set posisiX yang baru
            getTempatPanel().getTempat().getDaftarSel().get(i).geserAtas();
        }
        // gambar ulang tempat Panel
        getTempatPanel().repaint();
    }
    
     /**
     * Fungsi untuk memindahkan sel dan menggambar ulang
     */
    public void pindahBawah() {
        // posisiX seluruh sel ditambah 20
        // sehingga sel akan terlihat bergerak ke bawah
        for (int i = 0; i < getTempatPanel().getTempat().getDaftarSel().size(); i++) {
            // set posisiX yang baru
            getTempatPanel().getTempat().getDaftarSel().get(i).geserBawah();
        }
        // gambar ulang tempat Panel
        getTempatPanel().repaint();
    }

    /**
     * @return the tempatPanel
     */
    public TempatPanel getTempatPanel() {
        return tempatPanel;
    }

    /**
     * @param tempatPanel the tempatPanel to set
     */
    public void setTempatPanel(TempatPanel tempatPanel) {
        this.tempatPanel = tempatPanel;
    }

}
