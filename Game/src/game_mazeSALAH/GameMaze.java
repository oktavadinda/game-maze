package game_mazeSALAH;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class GameMaze extends javax.swing.JFrame {

    Peta peta;
    File file;

    public GameMaze() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        MP = new javax.swing.JLabel();
        outtextperintah = new javax.swing.JTextField();
        OP = new javax.swing.JLabel();
        tekarea = new javax.swing.JTextField();
        Restart = new javax.swing.JButton();
        TP = new javax.swing.JLabel();
        PixelPanel = new javax.swing.JPanel();
        perintah = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        Game = new javax.swing.JMenu();
        Open = new javax.swing.JMenuItem();
        Exit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 255, 204));

        MP.setText("Masukkan Perintah");

        outtextperintah.setBackground(new java.awt.Color(255, 204, 255));
        outtextperintah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outtextperintahActionPerformed(evt);
            }
        });

        OP.setText("Output Perintah");

        tekarea.setBackground(new java.awt.Color(102, 255, 204));
        tekarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tekareaActionPerformed(evt);
            }
        });

        Restart.setText("RESTART");
        Restart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RestartActionPerformed(evt);
            }
        });

        TP.setText("Terjemahan Perintah");

        javax.swing.GroupLayout PixelPanelLayout = new javax.swing.GroupLayout(PixelPanel);
        PixelPanel.setLayout(PixelPanelLayout);
        PixelPanelLayout.setHorizontalGroup(
            PixelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PixelPanelLayout.setVerticalGroup(
            PixelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 188, Short.MAX_VALUE)
        );

        perintah.setBackground(new java.awt.Color(255, 204, 255));
        perintah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perintahActionPerformed(evt);
            }
        });

        Game.setText("GAME");

        Open.setText("Open");
        Open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenActionPerformed(evt);
            }
        });
        Game.add(Open);

        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        Game.add(Exit);

        jMenuBar1.add(Game);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(OP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MP, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                    .addComponent(Restart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tekarea)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(perintah, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(TP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(outtextperintah, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addComponent(PixelPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PixelPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(MP, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(perintah, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(outtextperintah, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TP, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(OP, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addComponent(Restart)
                        .addContainerGap())
                    .addComponent(tekarea)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tekareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tekareaActionPerformed
        // TODO add your handling code here:
//        peta.PerintahGerak(perintah.getText());
//        perintah.getAction();
    }//GEN-LAST:event_tekareaActionPerformed

    private void outtextperintahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outtextperintahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outtextperintahActionPerformed

    private void OpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenActionPerformed
        // TODO add your handling code here:
        int returnVal = jFileChooser1.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = jFileChooser1.getSelectedFile();
            peta = new Peta(file);
            PixelPanel.add(peta);
            peta.setSize(peta.getLebar(), peta.getTinggi());

            //Setelah diset panel pixel, kita letakan posisi peta sokoban ditengah pixel panel
            int lebar = PixelPanel.getWidth();
            int tinggi = PixelPanel.getHeight();
            //mendapatkan titik koordinat x,y
            int x = (lebar - peta.getWidth()) / 2;
            int y = (tinggi - peta.getHeight()) / 2;
            peta.setLocation(x, y);
        }
    }//GEN-LAST:event_OpenActionPerformed

    private void RestartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RestartActionPerformed
        // TODO add your handling code here:
        peta.restartLevel();
        outtextperintah.setText("");
    }//GEN-LAST:event_RestartActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_ExitActionPerformed

    private void perintahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perintahActionPerformed
        // TODO add your handling code here:
        String input = perintah.getText();
        String output = penerjemah.terjemahan(input);
        outtextperintah.setText(output);
//        peta.output(perintah.getText());

        peta.PerintahGerak(perintah.getText());
        tekarea.setText(peta.getTeksPerintah());
        perintah.setText("");
    }//GEN-LAST:event_perintahActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameMaze.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameMaze.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameMaze.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameMaze.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameMaze().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Exit;
    private javax.swing.JMenu Game;
    private javax.swing.JLabel MP;
    private javax.swing.JLabel OP;
    private javax.swing.JMenuItem Open;
    private javax.swing.JPanel PixelPanel;
    private javax.swing.JButton Restart;
    private javax.swing.JLabel TP;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JTextField outtextperintah;
    private javax.swing.JTextField perintah;
    private javax.swing.JTextField tekarea;
    // End of variables declaration//GEN-END:variables
}
