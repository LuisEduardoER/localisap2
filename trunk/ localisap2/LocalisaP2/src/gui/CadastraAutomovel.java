/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CadastraAutomovel.java
 *
 * Created on 05/11/2010, 23:20:00
 */
package gui;

import agencias.Filial;
import clientes.Endereco;
import java.util.ArrayList;
import persistencia.ArmazenaDados;
import veiculos.*;

/**
 *
 * @author Filipe
 */
public class CadastraAutomovel extends javax.swing.JFrame {
    static ArmazenaDados arquivo;

    /** Creates new form CadastraAutomovel */
    public CadastraAutomovel(ArmazenaDados arquivo) {
        initComponents();
        this.arquivo = arquivo;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        label4 = new java.awt.Label();
        textField1 = new java.awt.TextField();
        textField2 = new java.awt.TextField();
        textField3 = new java.awt.TextField();
        label5 = new java.awt.Label();
        textField4 = new java.awt.TextField();
        label6 = new java.awt.Label();
        textField5 = new java.awt.TextField();
        label7 = new java.awt.Label();
        textField6 = new java.awt.TextField();
        label8 = new java.awt.Label();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        button1 = new java.awt.Button();
        button2 = new java.awt.Button();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jComboBox4 = new javax.swing.JComboBox();
        label9 = new java.awt.Label();
        label10 = new java.awt.Label();
        label11 = new java.awt.Label();
        label12 = new java.awt.Label();
        LabelException = new java.awt.Label();
        jSlider1 = new javax.swing.JSlider();
        label13 = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);

        label1.setFont(new java.awt.Font("Verdana", 0, 18));
        label1.setText("Cadastre o automóvel");

        label2.setName("Renavam"); // NOI18N
        label2.setText("RENAVAM");

        label3.setText("Modelo");

        label4.setText("Marca");

        textField1.setText("Digite o RENAVAM do veiculo");
        textField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textField1MouseClicked(evt);
            }
        });

        textField2.setText("Digite o modelo");
        textField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textField2MouseClicked(evt);
            }
        });

        textField3.setText("Digite a marca");
        textField3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textField3MouseClicked(evt);
            }
        });

        label5.setText("Potência");

        textField4.setText("Digite a potencia");
        textField4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textField4MouseClicked(evt);
            }
        });

        label6.setText("Ano");

        textField5.setText("Digite o ano do veiculo");
        textField5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textField5MouseClicked(evt);
            }
        });

        label7.setText("Data de Aquisição");

        textField6.setText("Digite a data de aquisicao");
        textField6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textField6MouseClicked(evt);
            }
        });

        label8.setText("Acessorios");

        jRadioButton1.setText("Duas Portas");

        jRadioButton2.setText("GPS");

        jRadioButton3.setText("Quatro Portas");

        jRadioButton4.setText("Ar Condicionado");

        jRadioButton5.setText("Direção Hidraulica");

        jRadioButton6.setText("Vidro Eletrico");

        jRadioButton7.setText("Trava Eletrica");

        jRadioButton8.setText("Air Bag");
        jRadioButton8.setToolTipText("");

        jRadioButton9.setText("Bancos de Couro");
        jRadioButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton9ActionPerformed(evt);
            }
        });

        button1.setLabel("Voltar");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button2.setLabel("Cadastrar");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "VERMELHO", "AMARELO", "AZUL", "VERDE", "CINZA", "PRATA", "PRETO", "DOURADO", "VINHO", "BRANCO" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ALCOOL", "GASOLINA", "GAS", "DIESEL", "FLEX" }));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ABS", "DISCO", "TAMBOR" }));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "HP", "CV" }));

        label9.setText("Cor");

        label10.setText("Combustivel");

        label11.setText("Freio");

        label12.setText("Tipo de Potencia");

        LabelException.setForeground(new java.awt.Color(255, 0, 0));

        jSlider1.setValue(100);

        label13.setText("Nivel do Combustivel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(612, 612, 612))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(textField3, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                                            .addComponent(textField4, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                                            .addComponent(textField5, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                                            .addComponent(textField6, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                                            .addComponent(textField2, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                                            .addComponent(textField1, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(label10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(53, 53, 53)
                                                .addComponent(label11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                                                .addComponent(label12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBox4, 0, 97, Short.MAX_VALUE)))
                                .addGap(60, 60, 60))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(label9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(436, 436, 436)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(label13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jRadioButton1)
                                        .addComponent(jRadioButton3)
                                        .addComponent(jRadioButton4))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jRadioButton2)
                                                .addComponent(jRadioButton5)
                                                .addComponent(jRadioButton6))
                                            .addGap(4, 4, 4)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jRadioButton8)
                                                .addComponent(jRadioButton7)
                                                .addComponent(jRadioButton9)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(LabelException, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE))
                            .addContainerGap()))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(119, Short.MAX_VALUE)
                        .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2)
                            .addComponent(jRadioButton7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton3)
                            .addComponent(jRadioButton5)
                            .addComponent(jRadioButton8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton4)
                            .addComponent(jRadioButton9)
                            .addComponent(jRadioButton6))
                        .addGap(25, 25, 25)
                        .addComponent(label13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(label9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(label10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(label11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(label12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(LabelException, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );

        button1.getAccessibleContext().setAccessibleName("Voltar");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton9ActionPerformed

    private void textField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textField1MouseClicked
        textField1.setText("");
    }//GEN-LAST:event_textField1MouseClicked

    private void textField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textField2MouseClicked
        textField2.setText("");
    }//GEN-LAST:event_textField2MouseClicked

    private void textField3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textField3MouseClicked
        textField3.setText("");
    }//GEN-LAST:event_textField3MouseClicked

    private void textField4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textField4MouseClicked
        textField4.setText("");
    }//GEN-LAST:event_textField4MouseClicked

    private void textField5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textField5MouseClicked
        textField5.setText("");
    }//GEN-LAST:event_textField5MouseClicked

    private void textField6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textField6MouseClicked
        textField6.setText("");
    }//GEN-LAST:event_textField6MouseClicked

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        new MenuInicial(arquivo).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        String renavam = textField1.getText();
        String modelo = textField2.getText();
        String marca = textField3.getText();
        int potencia = Integer.parseInt(textField4.getText());
        int ano = Integer.parseInt(textField5.getText());
        String dataDeAquisicao = textField6.getText();

        Cor cor = Cor.valueOf((String) jComboBox1.getSelectedItem());
        TipoDeCombustivel tipoDeCombustivel = TipoDeCombustivel.valueOf((String) jComboBox2.getSelectedItem());
        TipoDeFreio tipoDeFreio = TipoDeFreio.valueOf((String) jComboBox3.getSelectedItem());
        TipoDePotencia tipoDePotencia = TipoDePotencia.valueOf((String) jComboBox4.getSelectedItem());
        int nivelDoTanque = jSlider1.getValue();
        ArrayList<Acessorios> listaDeAcessorios = new ArrayList<Acessorios>();
        Boolean duasPortas = jRadioButton1.isSelected();
        Boolean quatroPortas = jRadioButton3.isSelected();
        Boolean arCondicionado = jRadioButton4.isSelected();
        Boolean gps = jRadioButton2.isSelected();
        Boolean direcaoHidraulica = jRadioButton5.isSelected();
        Boolean vidroEletrico = jRadioButton6.isSelected();
        Boolean travaEletrico = jRadioButton7.isSelected();
        Boolean airBag = jRadioButton8.isSelected();
        Boolean bancoCouro = jRadioButton9.isSelected();
        if(duasPortas)
            listaDeAcessorios.add(Acessorios.values()[0]);
        if(quatroPortas)
           listaDeAcessorios.add(Acessorios.values()[1]);
        if(arCondicionado)
            listaDeAcessorios.add(Acessorios.values()[2]);
        if(gps)
            listaDeAcessorios.add(Acessorios.values()[3]);
        if(direcaoHidraulica)
            listaDeAcessorios.add(Acessorios.values()[4]);
        if(vidroEletrico)
            listaDeAcessorios.add(Acessorios.values()[5]);
        if(travaEletrico)
            listaDeAcessorios.add(Acessorios.values()[6]);
        if(airBag)
            listaDeAcessorios.add(Acessorios.values()[7]);
        if(bancoCouro)
            listaDeAcessorios.add(Acessorios.values()[8]);
        try {
            Veiculo v = new Automovel(renavam, modelo, marca, potencia, ano, cor, tipoDeFreio, tipoDeCombustivel, dataDeAquisicao, nivelDoTanque, listaDeAcessorios, tipoDePotencia);
             new MenuInicial(arquivo).setVisible(true);
             this.dispose();
        } catch (Exception e) {
            LabelException.setText(e.getMessage());
        }
       

    }//GEN-LAST:event_button2ActionPerformed

    /*

ArrayList<Acessorios> listaDeAcessorios = pegarAcessorios();
    nivelDoTanque = readIntegerOption("Nivel do tanque(0-100): ", MINIMO_NIVEL_TANQUE, MAXIMO_NIVEL_TANQUE);
    v = null;
    try {
    v = new Automovel(renavam, modelo, marca, potencia, ano, cor, tipoDeFreio, tipoDeCombustivel, dataDeAquisicao, nivelDoTanque, listaDeAcessorios, tipoDePotencia);
    } catch (Exception e) {
    System.out.println(e.getMessage());
    menuPrincipal();
    }
    listaDeVeiculos.add(v);
    System.out.println("O carro foi adicionado com sucesso!");
     */
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new CadastraAutomovel(arquivo).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label LabelException;
    private java.awt.Button button1;
    private java.awt.Button button2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JSlider jSlider1;
    private java.awt.Label label1;
    private java.awt.Label label10;
    private java.awt.Label label11;
    private java.awt.Label label12;
    private java.awt.Label label13;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private java.awt.Label label7;
    private java.awt.Label label8;
    private java.awt.Label label9;
    private java.awt.TextField textField1;
    private java.awt.TextField textField2;
    private java.awt.TextField textField3;
    private java.awt.TextField textField4;
    private java.awt.TextField textField5;
    private java.awt.TextField textField6;
    // End of variables declaration//GEN-END:variables
}
