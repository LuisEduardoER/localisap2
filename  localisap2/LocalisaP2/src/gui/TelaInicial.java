/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TelaInicial.java
 *
 * Created on 05/11/2010, 21:29:24
 */
package gui;

import agencias.Filial;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import org.pushingpixels.substance.api.skin.SubstanceNebulaLookAndFeel;

/**
 *
 * @author Filipe
 */
public class TelaInicial extends javax.swing.JFrame {

    private static FileInputStream arquivoInfosRead;
    private static ObjectInputStream objInfosRead;
    private static Filial dadosAgencia;

    /** Creates new form TelaInicial */
    public TelaInicial() {
        dadosAgencia = carregaFilial();
        initComponents();
        setWindowPos();

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        campoUsuario = new javax.swing.JTextField();
        campoSenha = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocationByPlatform(true);
        setName("Localisa"); // NOI18N
        setResizable(false);

        jButton1.setText("Entrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Localisa tm18.png"))); // NOI18N
        jLabel1.setText("LOCALISA");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel2.setText("Usuário");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel3.setText("Senha");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                            .addComponent(campoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))))
                .addGap(52, 52, 52))
            .addGroup(layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jButton1)
                .addContainerGap(128, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(campoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addComponent(jButton1)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limparCampos() {
        campoSenha.setText("");
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            if (campoUsuario.getText().equals("admin") && campoSenha.getText().equals("localisa")) {
                new MenuInicial(dadosAgencia).setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Login incorreto! Tente novamente.");
                limparCampos();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Login incorreto! Tente novamente.");
            limparCampos();
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public void setWindowPos() {
        Dimension dimension = this.getToolkit().getScreenSize();
        int x = (int) (dimension.getWidth() - this.getSize().getWidth()) / 2;
        int y = (int) (dimension.getHeight() - this.getSize().getHeight()) / 2;
        this.setLocation(x, y);
        URL url = this.getClass().getResource("/images/icon2.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
    }

    private static void splashDelay() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
        }
    }

    public static void main(String args[]) {
      //  splashDelay();
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    UIManager.setLookAndFeel(new SubstanceNebulaLookAndFeel());
                } catch (Exception e) {
                    System.out.println("Falha ao carregar a skin!");
                }
                new TelaInicial().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField campoSenha;
    private javax.swing.JTextField campoUsuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables

    public Filial carregaFilial() {
        Filial dadosAgencia;
        try {
            arquivoInfosRead = new FileInputStream("./infosAgencia.dat");
        } catch (FileNotFoundException ex) {
            return new Filial();
        }
        try {
            objInfosRead = new ObjectInputStream(arquivoInfosRead);
            try {
                dadosAgencia = (Filial) objInfosRead.readObject();
                objInfosRead.close();
                arquivoInfosRead.close();
                return dadosAgencia;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                return new Filial();
            }
        } catch (IOException ex) {
        }
        return new Filial();
    }

}
