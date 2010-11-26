/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MenuInicial.java
 *
 * Created on 05/11/2010, 21:40:08
 */
package gui;

import agencias.Filial;
import clientes.Cliente;
import clientes.Endereco;
import clientes.Endereco.UnidadeFederativa;
import clientes.PessoaFisica;
import clientes.PessoaJuridica;
import funcionarios.Locador;
import funcionarios.Pessoa;
import funcionarios.Seguranca;
import funcionarios.Zelador;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import locacao.Devolucao;
import locacao.Locacao;
import locacao.Problema;
import org.pushingpixels.substance.api.skin.SubstanceNebulaLookAndFeel;
import planos.Plano;
import planos.PlanoAutomovel;
import planos.PlanoMoto;
import veiculos.Acessorio;
import veiculos.Automovel;
import veiculos.Cor;
import veiculos.Motocicleta;
import veiculos.TipoDeCombustivel;
import veiculos.TipoDeFreio;
import veiculos.TipoDePotencia;
import veiculos.Veiculo;

/**
 *
 * @author Filipe
 */
public class MenuInicial extends javax.swing.JFrame {

    private static FileOutputStream arquivoInfosWrite;
    private static ObjectOutputStream objInfosWrite;
    Timer timer;
    private static Filial dadosAgencia;
    private Object[] opcoes = {"Sim", "Nao"};

    /** Creates new form MenuInicial */
    public MenuInicial(Filial dadosAgencia) {
        initComponents();
        setWindowPos();
        setTimer();
        setarMascaras();
        this.dadosAgencia = dadosAgencia;
        atualizarAgenciaGerente();
        if (dadosAgencia.getClientes().size() > 0) {
            atualizarListaDeClientes();
        }
        if (dadosAgencia.getFuncionario().size() > 0) {
            atualizarListaDeFuncionarios();
        }
        if (dadosAgencia.getVeiculos().size() > 0) {
            atualizarListaDeVeiculos();
        }
        if (dadosAgencia.getPlano().size() > 0) {
            atualizarListaDePlanos();
        }
        if(dadosAgencia.getLocacao().size() > 0){
            atualizarListaDeLocacoes();
        }
    }

    public Cliente getClienteSelecionado() {
        if (dadosAgencia.getClientes().toArray()[jListaClientes.getSelectedIndex()] instanceof PessoaFisica) {
            return (PessoaFisica) dadosAgencia.getClientes().toArray()[jListaClientes.getSelectedIndex()];
        } else {
            return (PessoaJuridica) dadosAgencia.getClientes().toArray()[jListaClientes.getSelectedIndex()];
        }

    }

    public Veiculo getVeiculoSelecionado() {
        if (dadosAgencia.getVeiculos().toArray()[jListaVeiculos.getSelectedIndex()] instanceof Automovel) {
            return (Automovel) dadosAgencia.getVeiculos().toArray()[jListaVeiculos.getSelectedIndex()];
        } else {
            return (Motocicleta) dadosAgencia.getVeiculos().toArray()[jListaVeiculos.getSelectedIndex()];
        }

    }
    public Plano getPlanoSelecionado() {
        if (dadosAgencia.getPlano().toArray()[jListaPlanos.getSelectedIndex()] instanceof PlanoAutomovel) {
            return (PlanoAutomovel) dadosAgencia.getPlano().toArray()[jListaPlanos.getSelectedIndex()];
        } else {
            return (PlanoMoto) dadosAgencia.getPlano().toArray()[jListaPlanos.getSelectedIndex()];
        }

    }
    private void atualizarAgenciaGerente() {
        //TODO Deixar visivel o estado!
        cnpjAgencia.setText(dadosAgencia.getCnpj());
        inscEstadualAgencia.setText(dadosAgencia.getInscEstadual());
        cidadeAgencia.setText(dadosAgencia.getEndereco().getCidade());
        bairroAgencia.setText(dadosAgencia.getEndereco().getBairro());
        numeroAgencia.setText("" + dadosAgencia.getEndereco().getNumero());
        ruaAgencia.setText(dadosAgencia.getEndereco().getRua());
        telefoneAgencia.setText(dadosAgencia.getTelefone());
        cepAgencia.setText(dadosAgencia.getEndereco().getCep());
        estadoAgencia.setSelectedItem(dadosAgencia.getEndereco().getEstado().toString());

        nomeGerente.setText(dadosAgencia.getGerente().getNome());
        cpfGerente.setText(dadosAgencia.getGerente().getCpf());
        nascimentoGerente.setText(dadosAgencia.getGerente().getNascimento());
        rgGerente.setText(dadosAgencia.getGerente().getRg());
        naturalidadeGerente.setText(dadosAgencia.getGerente().getNaturalidade());
        emailGerente.setText(dadosAgencia.getGerente().getEmail());
        cidadeGerente.setText(dadosAgencia.getGerente().getEndereco().getCidade());
        bairroGerente.setText(dadosAgencia.getGerente().getEndereco().getBairro());
        numeroGerente.setText(""+dadosAgencia.getGerente().getEndereco().getNumero());
        ruaGerente.setText(dadosAgencia.getGerente().getEndereco().getRua());
        telefoneGerente.setText(dadosAgencia.getGerente().getTelefone());
        cepGerente.setText(dadosAgencia.getGerente().getEndereco().getCep());
        estadoGerente.setSelectedItem(dadosAgencia.getGerente().getEndereco().getEstado().toString());
    }

    public Pessoa getFuncionarioSelecionado() {
        return (Pessoa) (dadosAgencia.getFuncionario().toArray()[jListaFuncionario.getSelectedIndex()]);
    }

    public void atualizarListaDeLocacoes(){
        int i =0;
        String[] lista = new String[dadosAgencia.getLocacao().size()];
        for(Locacao l : dadosAgencia.getLocacao())
            lista[i++] = l.getCliente().getNome() + " - " + l.getPlano().getNome();
        jList4.setListData(lista);
    }

    public void atualizarListaDeClientes() {

        int i = 0;
        String[] lista = new String[dadosAgencia.getClientes().size()];
        for (Cliente p : dadosAgencia.getClientes()) {
            if (p instanceof PessoaFisica) {
                lista[i++] = p.getNome() + " (F)";
            } else {
                lista[i++] = p.getNome() + " (J)";
            }
        }
        jListaClientes.setListData(lista);
    }

    public void atualizarListaDeFuncionarios() {
        int i = 0;
        String[] lista = new String[dadosAgencia.getFuncionario().size()];
        for (Pessoa p : dadosAgencia.getFuncionario()) {
            if (p instanceof Locador) {
                lista[i++] = p.getNome() + " (L)";
            } else if (p instanceof Seguranca) {
                lista[i++] = p.getNome() + " (S)";
            } else {
                lista[i++] = p.getNome() + " (Z)";
            }
        }
        jListaFuncionario.setListData(lista);
    }



    public void atualizarListaDePlanos() {
        int i = 0;
        String[] lista = new String[dadosAgencia.getPlano().size()];
        for (Plano p : dadosAgencia.getPlano()) {
            if(p instanceof PlanoAutomovel){
               lista[i++] = p.getNome() + " - R$:" + p.getPreco() + " (C)";
            }else{
            lista[i++] = p.getNome() + " - R$:" + p.getPreco() + " (M)";
        }
            }
        jListaPlanos.setListData(lista);
    }

    public void atualizarListaDeVeiculos() {
        int i = 0;
        String[] lista = new String[dadosAgencia.getVeiculos().size()];

        for (Veiculo v : dadosAgencia.getVeiculos()) {
            if (v instanceof Automovel) {
                if(v.getLocado())
                    lista[i] = v.getMarca() + " - " + v.getModelo() + " (C) - Locado";
                else
                    lista[i] = v.getMarca() + " - " + v.getModelo() + " (C)";
            } else {
                if(v.getLocado())
                    lista[i] = v.getMarca() + " - " + v.getModelo() + " (M) - Locado";
                else
                    lista[i] = v.getMarca() + " - " + v.getModelo() + " (M)";
            }
            i++;
        }
        jListaVeiculos.setListData(lista);

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListaClientes = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        cadastrarCliente = new javax.swing.JButton();
        editarCliente = new javax.swing.JButton();
        apagarCliente = new javax.swing.JButton();
        verificarDebito = new javax.swing.JButton();
        realizarPagamento = new javax.swing.JButton();
        realizarLocacao = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        nome = new javax.swing.JTextField();
        naturalidade = new javax.swing.JTextField();
        cidade = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        bairro = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        rua = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        nascimento = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        estado = new javax.swing.JComboBox();
        email = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cpf = new javax.swing.JFormattedTextField();
        telefone = new javax.swing.JFormattedTextField();
        cep = new javax.swing.JFormattedTextField();
        jLabel16 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        limparCampos = new javax.swing.JButton();
        rg = new javax.swing.JFormattedTextField();
        numero = new javax.swing.JFormattedTextField();
        jPanel9 = new javax.swing.JPanel();
        nome1 = new javax.swing.JTextField();
        cidade1 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        bairro1 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        rua1 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        numero1 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        email1 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        cnpj = new javax.swing.JFormattedTextField();
        telefone1 = new javax.swing.JFormattedTextField();
        cep1 = new javax.swing.JFormattedTextField();
        jLabel29 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        limparCampos1 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        rzSocial = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        inscEstadual = new javax.swing.JTextField();
        estado1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListaFuncionario = new javax.swing.JList();
        jLabel30 = new javax.swing.JLabel();
        editarFuncionario = new javax.swing.JButton();
        apagarFuncionario = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        nome2 = new javax.swing.JTextField();
        rg1 = new javax.swing.JTextField();
        naturalidade1 = new javax.swing.JTextField();
        cidade2 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        bairro4 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        rua2 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        numero2 = new javax.swing.JTextField();
        nascimento1 = new javax.swing.JFormattedTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        estado2 = new javax.swing.JComboBox();
        email2 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        cpf1 = new javax.swing.JFormattedTextField();
        telefone2 = new javax.swing.JFormattedTextField();
        cep2 = new javax.swing.JFormattedTextField();
        jLabel43 = new javax.swing.JLabel();
        cadastrarFuncionario = new javax.swing.JButton();
        limparCampos3 = new javax.swing.JButton();
        jComboTipoFuncionario = new javax.swing.JComboBox();
        jLabel44 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListaVeiculos = new javax.swing.JList();
        cadastrarVeiculo = new javax.swing.JButton();
        editarVeiculo = new javax.swing.JButton();
        apagarVeiculo = new javax.swing.JButton();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel13 = new javax.swing.JPanel();
        cadastrarMoto = new javax.swing.JButton();
        limparCamposMoto = new javax.swing.JButton();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        renavamMoto = new javax.swing.JTextField();
        dataAquisicaoMoto = new javax.swing.JFormattedTextField();
        marcaMoto = new javax.swing.JFormattedTextField();
        jTipoCorMoto = new javax.swing.JComboBox();
        jLabel79 = new javax.swing.JLabel();
        potenciaMoto = new javax.swing.JTextField();
        jLabel80 = new javax.swing.JLabel();
        jTipoFreioMoto = new javax.swing.JComboBox();
        modeloMoto = new javax.swing.JTextField();
        jLabel81 = new javax.swing.JLabel();
        jTipoPotenciaMoto = new javax.swing.JComboBox();
        jLabel82 = new javax.swing.JLabel();
        jTipoCombustivelMoto = new javax.swing.JComboBox();
        jLabel83 = new javax.swing.JLabel();
        jSpinnerCombustivelMoto = new javax.swing.JSpinner();
        jLabel84 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        cilindradasMoto = new javax.swing.JTextField();
        anoMoto = new javax.swing.JFormattedTextField();
        jPanel12 = new javax.swing.JPanel();
        renavamCarro = new javax.swing.JTextField();
        potenciaCarro = new javax.swing.JTextField();
        marcaCarro = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        dataAquisicaoCarro = new javax.swing.JFormattedTextField();
        jLabel68 = new javax.swing.JLabel();
        modeloCarro = new javax.swing.JFormattedTextField();
        cadastrarCarro = new javax.swing.JButton();
        limparCamposCarro = new javax.swing.JButton();
        jLabel67 = new javax.swing.JLabel();
        freioCarro = new javax.swing.JComboBox();
        jLabel71 = new javax.swing.JLabel();
        quatroPortas = new javax.swing.JRadioButton();
        arCondicionado = new javax.swing.JRadioButton();
        gps = new javax.swing.JRadioButton();
        direcaoHidraulica = new javax.swing.JRadioButton();
        vidroEletrico = new javax.swing.JRadioButton();
        travaEletrica = new javax.swing.JRadioButton();
        airBag = new javax.swing.JRadioButton();
        bancoDeCouro = new javax.swing.JRadioButton();
        nivelCombustivelCarro = new javax.swing.JSpinner();
        jLabel72 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        tipoPotenciaCarro = new javax.swing.JComboBox();
        combustivelCarro = new javax.swing.JComboBox();
        jLabel66 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        corCarro = new javax.swing.JComboBox();
        anoCarro = new javax.swing.JFormattedTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList4 = new javax.swing.JList();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        apagarLocacao = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        clienteLocacao = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        dataDevolucaoLocacao = new javax.swing.JFormattedTextField();
        jLabel59 = new javax.swing.JLabel();
        locar = new javax.swing.JButton();
        limparCamposLocacao = new javax.swing.JButton();
        jLabel53 = new javax.swing.JLabel();
        boxSeguro = new javax.swing.JComboBox();
        boxPlanos = new javax.swing.JComboBox();
        jLabel54 = new javax.swing.JLabel();
        boxVeiculos = new javax.swing.JComboBox();
        jLabel69 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        locarCarro = new javax.swing.JRadioButton();
        locarMoto = new javax.swing.JRadioButton();
        efetuarDevolucao = new javax.swing.JButton();
        jLabel52 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel95 = new javax.swing.JLabel();
        arranhoes = new javax.swing.JCheckBox();
        perdaTotalOuRoubo = new javax.swing.JCheckBox();
        amassadosLeves = new javax.swing.JCheckBox();
        amassadosGraves = new javax.swing.JCheckBox();
        confirmarProblemas = new javax.swing.JToggleButton();
        tanqueErrado = new javax.swing.JCheckBox();
        nivelTanqueNovo = new javax.swing.JSpinner();
        atraso = new javax.swing.JCheckBox();
        dataAtraso = new javax.swing.JFormattedTextField();
        jLabel111 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jListaPlanos = new javax.swing.JList();
        jLabel112 = new javax.swing.JLabel();
        cadastrarPlanoDeLocacao = new javax.swing.JButton();
        jLabel113 = new javax.swing.JLabel();
        editarPlanoDeLocacao = new javax.swing.JButton();
        apagarPlanoDeLocacao = new javax.swing.JButton();
        jTabbedPane6 = new javax.swing.JTabbedPane();
        jPanel17 = new javax.swing.JPanel();
        nomePlanoCarro = new javax.swing.JTextField();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        precoPlanoCarro = new javax.swing.JFormattedTextField();
        cadastrarPlanoCarro = new javax.swing.JButton();
        limparCamposPlanoCarro = new javax.swing.JButton();
        quatroPortasPlanoCarro = new javax.swing.JRadioButton();
        arCondicionadoPlanoCarro = new javax.swing.JRadioButton();
        jLabel47 = new javax.swing.JLabel();
        GPSPlanoCarro = new javax.swing.JRadioButton();
        direcaoHidraulicaPlanoCarro = new javax.swing.JRadioButton();
        vidroEletricoPlanoCarro = new javax.swing.JRadioButton();
        travaEletricaPlanoCarro = new javax.swing.JRadioButton();
        airBagPlanoCarro = new javax.swing.JRadioButton();
        bancosCouraPlanoCarro = new javax.swing.JRadioButton();
        jPanel18 = new javax.swing.JPanel();
        cadastrarPlanoMoto = new javax.swing.JButton();
        limparCamposPlanoMoto = new javax.swing.JButton();
        jLabel116 = new javax.swing.JLabel();
        nomePlanoMoto = new javax.swing.JTextField();
        jLabel117 = new javax.swing.JLabel();
        precoPlanoMoto = new javax.swing.JFormattedTextField();
        jLabel48 = new javax.swing.JLabel();
        cilindradasPlanoMoto = new javax.swing.JFormattedTextField();
        jPanel14 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        estadoAgencia = new javax.swing.JComboBox();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        inscEstadualAgencia = new javax.swing.JTextField();
        jLabel91 = new javax.swing.JLabel();
        cidadeAgencia = new javax.swing.JTextField();
        jLabel92 = new javax.swing.JLabel();
        bairroAgencia = new javax.swing.JTextField();
        numeroAgencia = new javax.swing.JTextField();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        ruaAgencia = new javax.swing.JTextField();
        jLabel96 = new javax.swing.JLabel();
        telefoneAgencia = new javax.swing.JFormattedTextField();
        cepAgencia = new javax.swing.JFormattedTextField();
        jLabel97 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        cnpjAgencia = new javax.swing.JFormattedTextField();
        jLabel98 = new javax.swing.JLabel();
        nomeGerente = new javax.swing.JTextField();
        jLabel99 = new javax.swing.JLabel();
        cpfGerente = new javax.swing.JFormattedTextField();
        rgGerente = new javax.swing.JTextField();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        estadoGerente = new javax.swing.JComboBox();
        nascimentoGerente = new javax.swing.JFormattedTextField();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        naturalidadeGerente = new javax.swing.JTextField();
        jLabel104 = new javax.swing.JLabel();
        cidadeGerente = new javax.swing.JTextField();
        jLabel105 = new javax.swing.JLabel();
        bairroGerente = new javax.swing.JTextField();
        numeroGerente = new javax.swing.JTextField();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        ruaGerente = new javax.swing.JTextField();
        jLabel108 = new javax.swing.JLabel();
        emailGerente = new javax.swing.JTextField();
        jLabel109 = new javax.swing.JLabel();
        telefoneGerente = new javax.swing.JFormattedTextField();
        cepGerente = new javax.swing.JFormattedTextField();
        jLabel110 = new javax.swing.JLabel();
        atualizarAgenciaGerente = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOCALISA - Menu Principal");
        setLocationByPlatform(true);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Localisa tm18.png"))); // NOI18N

        jPanel1.setPreferredSize(new java.awt.Dimension(104, 124));

        jScrollPane1.setViewportView(jListaClientes);

        jLabel2.setText("Lista de Clientes:");

        cadastrarCliente.setText("Cadastrar Cliente");
        cadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarClienteActionPerformed(evt);
            }
        });

        editarCliente.setText("Editar Cliente");
        editarCliente.setEnabled(false);
        editarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarClienteActionPerformed(evt);
            }
        });

        apagarCliente.setText("Apagar Cliente");
        apagarCliente.setEnabled(false);
        apagarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apagarClienteActionPerformed(evt);
            }
        });

        verificarDebito.setText("Verificar Debito");
        verificarDebito.setEnabled(false);
        verificarDebito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verificarDebitoActionPerformed(evt);
            }
        });

        realizarPagamento.setText("Realizar Pgmto");
        realizarPagamento.setEnabled(false);
        realizarPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                realizarPagamentoActionPerformed(evt);
            }
        });

        realizarLocacao.setText("Realizar Locação");
        realizarLocacao.setEnabled(false);
        realizarLocacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                realizarLocacaoActionPerformed(evt);
            }
        });

        jTabbedPane2.setEnabled(false);

        nome.setFont(new java.awt.Font("Tahoma", 0, 10));
        nome.setEnabled(false);

        naturalidade.setFont(new java.awt.Font("Tahoma", 0, 10));
        naturalidade.setEnabled(false);

        cidade.setFont(new java.awt.Font("Tahoma", 0, 10));
        cidade.setEnabled(false);

        jLabel4.setText("Nome:");
        jLabel4.setEnabled(false);

        jLabel5.setText("CPF:");
        jLabel5.setEnabled(false);

        jLabel6.setText("RG:");
        jLabel6.setEnabled(false);

        jLabel7.setText("Naturalidade:");
        jLabel7.setEnabled(false);

        jLabel8.setText("Cidade:");
        jLabel8.setEnabled(false);

        jLabel9.setText("Bairro:");
        jLabel9.setEnabled(false);

        bairro.setFont(new java.awt.Font("Tahoma", 0, 10));
        bairro.setEnabled(false);

        jLabel10.setText("Rua:");
        jLabel10.setEnabled(false);

        rua.setFont(new java.awt.Font("Tahoma", 0, 10));
        rua.setEnabled(false);

        jLabel11.setText("Nº:");
        jLabel11.setEnabled(false);

        nascimento.setEnabled(false);
        nascimento.setFont(new java.awt.Font("Tahoma", 0, 10));

        jLabel12.setText("Data Nasc:");
        jLabel12.setEnabled(false);

        jLabel13.setText("Estado:");
        jLabel13.setEnabled(false);

        estado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        estado.setEnabled(false);

        email.setFont(new java.awt.Font("Tahoma", 0, 10));
        email.setEnabled(false);

        jLabel14.setText("E-mail:");
        jLabel14.setEnabled(false);

        jLabel15.setText("Telefone:");
        jLabel15.setEnabled(false);

        cpf.setEnabled(false);
        cpf.setFont(new java.awt.Font("Tahoma", 0, 10));

        telefone.setEnabled(false);
        telefone.setFont(new java.awt.Font("Tahoma", 0, 10));

        cep.setEnabled(false);
        cep.setFont(new java.awt.Font("Tahoma", 0, 10));

        jLabel16.setText("CEP:");
        jLabel16.setEnabled(false);

        jButton1.setText("Cadastrar");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        limparCampos.setText("Limpar Campos");
        limparCampos.setEnabled(false);
        limparCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparCamposActionPerformed(evt);
            }
        });

        rg.setEnabled(false);

        numero.setEnabled(false);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9)
                                .addComponent(jLabel8)
                                .addComponent(jLabel10)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4)
                                .addComponent(jLabel14)
                                .addComponent(jLabel15)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addComponent(bairro, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numero, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(email, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(nascimento)
                                    .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rg))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(naturalidade, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                            .addComponent(nome, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16)
                                .addGap(2, 2, 2)
                                .addComponent(cep, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))
                            .addComponent(cidade, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                            .addComponent(rua, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(limparCampos)
                        .addGap(65, 65, 65)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(87, 87, 87))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(rg, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(naturalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cidade, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bairro, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(numero, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rua, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cep, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)))
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(limparCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jLabel7.getAccessibleContext().setAccessibleName("jLabel7");

        jTabbedPane2.addTab("Pessoa Física", jPanel8);

        nome1.setFont(new java.awt.Font("Tahoma", 0, 10));
        nome1.setEnabled(false);

        cidade1.setFont(new java.awt.Font("Tahoma", 0, 10));
        cidade1.setEnabled(false);

        jLabel17.setText("Nome:");
        jLabel17.setEnabled(false);

        jLabel18.setText("CNPJ:");
        jLabel18.setEnabled(false);

        jLabel21.setText("Cidade:");
        jLabel21.setEnabled(false);

        jLabel22.setText("Bairro:");
        jLabel22.setEnabled(false);

        bairro1.setFont(new java.awt.Font("Tahoma", 0, 10));
        bairro1.setEnabled(false);

        jLabel23.setText("Rua:");
        jLabel23.setEnabled(false);

        rua1.setFont(new java.awt.Font("Tahoma", 0, 10));
        rua1.setEnabled(false);

        jLabel24.setText("Nº:");
        jLabel24.setEnabled(false);

        numero1.setFont(new java.awt.Font("Tahoma", 0, 10));
        numero1.setEnabled(false);

        jLabel26.setText("Estado:");
        jLabel26.setEnabled(false);

        email1.setFont(new java.awt.Font("Tahoma", 0, 10));
        email1.setEnabled(false);

        jLabel27.setText("E-mail:");
        jLabel27.setEnabled(false);

        jLabel28.setText("Telefone:");
        jLabel28.setEnabled(false);

        cnpj.setEnabled(false);
        cnpj.setFont(new java.awt.Font("Tahoma", 0, 10));

        telefone1.setEnabled(false);
        telefone1.setFont(new java.awt.Font("Tahoma", 0, 10));

        cep1.setEnabled(false);
        cep1.setFont(new java.awt.Font("Tahoma", 0, 10));

        jLabel29.setText("CEP:");
        jLabel29.setEnabled(false);

        jButton8.setText("Cadastrar");
        jButton8.setEnabled(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        limparCampos1.setText("Limpar Campos");
        limparCampos1.setEnabled(false);
        limparCampos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparCampos1ActionPerformed(evt);
            }
        });

        jLabel19.setText("Rz.Social: ");
        jLabel19.setEnabled(false);

        rzSocial.setFont(new java.awt.Font("Tahoma", 0, 10));
        rzSocial.setEnabled(false);

        jLabel20.setText("Ins. Estadual: ");
        jLabel20.setEnabled(false);

        inscEstadual.setFont(new java.awt.Font("Tahoma", 0, 10));
        inscEstadual.setEnabled(false);

        estado1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        estado1.setEnabled(false);
        estado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estado1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel21)
                            .addComponent(jLabel23)
                            .addComponent(jLabel18)
                            .addComponent(jLabel17)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28)
                            .addComponent(jLabel19))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cidade1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addComponent(bairro1, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numero1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(rzSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(estado1, 0, 96, Short.MAX_VALUE))
                            .addComponent(nome1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addComponent(email1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addComponent(rua1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addComponent(cnpj, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(telefone1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel29)
                                .addGap(2, 2, 2)
                                .addComponent(cep1, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(limparCampos1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inscEstadual, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(nome1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(cnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel19)
                    .addComponent(rzSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(estado1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(inscEstadual, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cidade1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bairro1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numero1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rua1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(email1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(telefone1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cep1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29)))
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(limparCampos1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Pessoa Jurídica", jPanel9);

        jLabel3.setText("Opções:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(editarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                    .addComponent(apagarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                    .addComponent(cadastrarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(verificarDebito, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                                    .addComponent(realizarPagamento, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                                    .addComponent(realizarLocacao, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))))
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cadastrarCliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(editarCliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(apagarCliente))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(verificarDebito, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(realizarLocacao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(realizarPagamento)))
                        .addGap(56, 56, 56)
                        .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane2.getAccessibleContext().setAccessibleName("tab 1");

        jTabbedPane1.addTab("Clientes", jPanel1);

        jLabel25.setText("Lista de Funcionarios:");

        jScrollPane2.setViewportView(jListaFuncionario);

        jLabel30.setText("Opções:");

        editarFuncionario.setText("Editar Funcionario");
        editarFuncionario.setEnabled(false);
        editarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarFuncionarioActionPerformed(evt);
            }
        });

        apagarFuncionario.setText("Apagar Funcionario");
        apagarFuncionario.setEnabled(false);
        apagarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apagarFuncionarioActionPerformed(evt);
            }
        });

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel10.setEnabled(false);

        nome2.setFont(new java.awt.Font("Tahoma", 0, 10));
        nome2.setEnabled(false);

        rg1.setFont(new java.awt.Font("Tahoma", 0, 10));
        rg1.setEnabled(false);

        naturalidade1.setFont(new java.awt.Font("Tahoma", 0, 10));
        naturalidade1.setEnabled(false);

        cidade2.setFont(new java.awt.Font("Tahoma", 0, 10));
        cidade2.setEnabled(false);

        jLabel31.setText("Nome:");
        jLabel31.setEnabled(false);

        jLabel32.setText("CPF:");
        jLabel32.setEnabled(false);

        jLabel33.setText("RG:");
        jLabel33.setEnabled(false);

        jLabel34.setText("Naturalidade:");
        jLabel34.setEnabled(false);

        jLabel35.setText("Cidade:");
        jLabel35.setEnabled(false);

        jLabel36.setText("Bairro:");
        jLabel36.setEnabled(false);

        bairro4.setFont(new java.awt.Font("Tahoma", 0, 10));
        bairro4.setEnabled(false);

        jLabel37.setText("Rua:");
        jLabel37.setEnabled(false);

        rua2.setFont(new java.awt.Font("Tahoma", 0, 10));
        rua2.setEnabled(false);

        jLabel38.setText("Nº:");
        jLabel38.setEnabled(false);

        numero2.setFont(new java.awt.Font("Tahoma", 0, 10));
        numero2.setEnabled(false);

        nascimento1.setEnabled(false);
        nascimento1.setFont(new java.awt.Font("Tahoma", 0, 10));

        jLabel39.setText("Data Nasc:");
        jLabel39.setEnabled(false);

        jLabel40.setText("Estado:");
        jLabel40.setEnabled(false);

        estado2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        estado2.setEnabled(false);

        email2.setFont(new java.awt.Font("Tahoma", 0, 10));
        email2.setEnabled(false);

        jLabel41.setText("E-mail:");
        jLabel41.setEnabled(false);

        jLabel42.setText("Telefone:");
        jLabel42.setEnabled(false);

        cpf1.setEnabled(false);
        cpf1.setFont(new java.awt.Font("Tahoma", 0, 10));

        telefone2.setEnabled(false);
        telefone2.setFont(new java.awt.Font("Tahoma", 0, 10));

        cep2.setEnabled(false);
        cep2.setFont(new java.awt.Font("Tahoma", 0, 10));

        jLabel43.setText("CEP:");
        jLabel43.setEnabled(false);

        cadastrarFuncionario.setText("Cadastrar");
        cadastrarFuncionario.setEnabled(false);
        cadastrarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarFuncionarioActionPerformed(evt);
            }
        });

        limparCampos3.setText("Limpar Campos");
        limparCampos3.setEnabled(false);
        limparCampos3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparCampos3ActionPerformed(evt);
            }
        });

        jComboTipoFuncionario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Locador", "Zelador", "Segurança" }));
        jComboTipoFuncionario.setEnabled(false);

        jLabel44.setText("Cargo:");
        jLabel44.setEnabled(false);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel36)
                                .addComponent(jLabel35)
                                .addComponent(jLabel37)
                                .addComponent(jLabel32)
                                .addComponent(jLabel31)
                                .addComponent(jLabel41)
                                .addComponent(jLabel42)
                                .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel39)
                            .addComponent(jLabel44))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                        .addComponent(bairro4, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel38)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(numero2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(email2, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(nascimento1)
                                            .addComponent(cpf1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel10Layout.createSequentialGroup()
                                                .addComponent(jLabel33)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(rg1, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                                            .addGroup(jPanel10Layout.createSequentialGroup()
                                                .addComponent(jLabel40)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(estado2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(naturalidade1, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                                    .addComponent(nome2, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                                    .addComponent(cidade2, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                                    .addComponent(rua2, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(telefone2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel43)
                                        .addGap(2, 2, 2)
                                        .addComponent(cep2, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)))
                                .addGap(23, 23, 23))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jComboTipoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addComponent(limparCampos3)
                        .addGap(45, 45, 45)
                        .addComponent(cadastrarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(nome2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(cpf1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rg1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addGap(7, 7, 7)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nascimento1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39)
                    .addComponent(jLabel40)
                    .addComponent(estado2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(naturalidade1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cidade2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bairro4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numero2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rua2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(email2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel41))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel42)
                            .addComponent(telefone2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cep2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel43)))
                    .addComponent(jLabel36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboTipoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44))
                .addGap(30, 30, 30)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(limparCampos3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadastrarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(172, Short.MAX_VALUE))
        );

        jButton2.setText("Cadastrar Funcionario");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel30)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(jButton2)
                                    .addGap(18, 18, 18)
                                    .addComponent(editarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(67, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(24, 24, 24)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(apagarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(editarFuncionario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(apagarFuncionario)
                        .addGap(25, 25, 25)
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Funcionarios", jPanel2);

        jLabel45.setText("Lista de Automoveis:");

        jLabel46.setText("Opções:");

        jScrollPane3.setViewportView(jListaVeiculos);

        cadastrarVeiculo.setText("Cadastrar Veiculo");
        cadastrarVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarVeiculoActionPerformed(evt);
            }
        });

        editarVeiculo.setText("Editar Veiculo");
        editarVeiculo.setEnabled(false);
        editarVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarVeiculoActionPerformed(evt);
            }
        });

        apagarVeiculo.setText("Apagar Veiculo");
        apagarVeiculo.setEnabled(false);
        apagarVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apagarVeiculoActionPerformed(evt);
            }
        });

        jTabbedPane4.setEnabled(false);

        jPanel13.setEnabled(false);
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cadastrarMoto.setText("Cadastrar");
        cadastrarMoto.setEnabled(false);
        cadastrarMoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarMotoActionPerformed(evt);
            }
        });
        jPanel13.add(cadastrarMoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 98, 17));

        limparCamposMoto.setText("Limpar Campos");
        limparCamposMoto.setEnabled(false);
        limparCamposMoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparCamposMotoActionPerformed(evt);
            }
        });
        jPanel13.add(limparCamposMoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, 17));

        jLabel73.setText("Renavam:");
        jLabel73.setEnabled(false);
        jPanel13.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 13, 70, -1));

        jLabel74.setText("Modelo:");
        jLabel74.setEnabled(false);
        jPanel13.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 37, -1, -1));

        jLabel75.setText("Marca:");
        jLabel75.setEnabled(false);
        jPanel13.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 76, -1));

        jLabel76.setText("Potência:");
        jLabel76.setEnabled(false);
        jPanel13.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 83, -1, -1));

        jLabel77.setText("Data Aquisição:");
        jLabel77.setEnabled(false);
        jPanel13.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 108, -1, -1));

        renavamMoto.setFont(new java.awt.Font("Tahoma", 0, 10));
        renavamMoto.setEnabled(false);
        jPanel13.add(renavamMoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 12, 84, 17));

        dataAquisicaoMoto.setEnabled(false);
        dataAquisicaoMoto.setFont(new java.awt.Font("Tahoma", 0, 10));
        jPanel13.add(dataAquisicaoMoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 84, 17));

        marcaMoto.setEnabled(false);
        marcaMoto.setFont(new java.awt.Font("Tahoma", 0, 10));
        jPanel13.add(marcaMoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 59, 84, 17));

        jTipoCorMoto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "VERMELHO", "AMARELO", "AZUL", "VERDE", "CINZA", "PRATA", "PRETO", "DOURADO", "VINHO", "BRANCO" }));
        jTipoCorMoto.setEnabled(false);
        jPanel13.add(jTipoCorMoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 110, 17));

        jLabel79.setText("Cor:");
        jLabel79.setEnabled(false);
        jPanel13.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 40, -1));

        potenciaMoto.setFont(new java.awt.Font("Tahoma", 0, 10));
        potenciaMoto.setEnabled(false);
        jPanel13.add(potenciaMoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 82, 84, 17));

        jLabel80.setText("Freio:");
        jLabel80.setEnabled(false);
        jPanel13.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, -1, -1));

        jTipoFreioMoto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ABS", "DISCO", "TAMBOR" }));
        jTipoFreioMoto.setEnabled(false);
        jPanel13.add(jTipoFreioMoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 36, 70, 17));

        modeloMoto.setFont(new java.awt.Font("Tahoma", 0, 10));
        modeloMoto.setEnabled(false);
        jPanel13.add(modeloMoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 36, 84, 17));

        jLabel81.setText("Tipo de Pot.:");
        jLabel81.setEnabled(false);
        jPanel13.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, -1, -1));

        jTipoPotenciaMoto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "HP", "CV" }));
        jTipoPotenciaMoto.setEnabled(false);
        jPanel13.add(jTipoPotenciaMoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 50, 17));

        jLabel82.setText("Combustivel:");
        jLabel82.setEnabled(false);
        jPanel13.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 159, -1, -1));

        jTipoCombustivelMoto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ALCOOL", "GASOLINA", "GAS", "DIESEL", "FLEX" }));
        jTipoCombustivelMoto.setEnabled(false);
        jPanel13.add(jTipoCombustivelMoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 100, 17));

        jLabel83.setText("Niv. Combus");
        jLabel83.setEnabled(false);
        jPanel13.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, -1, -1));

        jSpinnerCombustivelMoto.setEnabled(false);
        jPanel13.add(jSpinnerCombustivelMoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 50, -1));

        jLabel84.setText("Ano:");
        jLabel84.setEnabled(false);
        jPanel13.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        jLabel139.setText("Cilindradas:");
        jLabel139.setEnabled(false);
        jPanel13.add(jLabel139, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 133, -1, -1));

        cilindradasMoto.setFont(new java.awt.Font("Tahoma", 0, 10));
        cilindradasMoto.setEnabled(false);
        jPanel13.add(cilindradasMoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 132, 84, 17));

        anoMoto.setEnabled(false);
        jPanel13.add(anoMoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 70, 17));

        jTabbedPane4.addTab("Moto", jPanel13);

        jPanel12.setEnabled(false);
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        renavamCarro.setFont(new java.awt.Font("Tahoma", 0, 10));
        renavamCarro.setEnabled(false);
        jPanel12.add(renavamCarro, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 11, 84, 17));

        potenciaCarro.setFont(new java.awt.Font("Tahoma", 0, 10));
        potenciaCarro.setEnabled(false);
        jPanel12.add(potenciaCarro, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 92, 84, 17));

        marcaCarro.setFont(new java.awt.Font("Tahoma", 0, 10));
        marcaCarro.setEnabled(false);
        jPanel12.add(marcaCarro, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 62, 84, 17));

        jLabel60.setText("Renavam:");
        jLabel60.setEnabled(false);
        jPanel12.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 12, 70, -1));

        jLabel61.setText("Modelo:");
        jLabel61.setEnabled(false);
        jPanel12.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 38, 70, -1));

        jLabel62.setText("Ano:");
        jLabel62.setEnabled(false);
        jPanel12.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, -1));

        jLabel63.setText("Potência:");
        jLabel63.setEnabled(false);
        jPanel12.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 93, -1, -1));

        jLabel64.setText("Data Aquisição:");
        jLabel64.setEnabled(false);
        jPanel12.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 117, -1, -1));

        dataAquisicaoCarro.setEnabled(false);
        dataAquisicaoCarro.setFont(new java.awt.Font("Tahoma", 0, 10));
        jPanel12.add(dataAquisicaoCarro, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 84, 17));

        jLabel68.setText("Marca:");
        jLabel68.setEnabled(false);
        jPanel12.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 63, 45, -1));

        modeloCarro.setEnabled(false);
        modeloCarro.setFont(new java.awt.Font("Tahoma", 0, 10));
        jPanel12.add(modeloCarro, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 35, 84, 17));

        cadastrarCarro.setText("Cadastrar");
        cadastrarCarro.setEnabled(false);
        cadastrarCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarCarroActionPerformed(evt);
            }
        });
        jPanel12.add(cadastrarCarro, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, 87, 17));

        limparCamposCarro.setText("Limpar Campos");
        limparCamposCarro.setEnabled(false);
        limparCamposCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparCamposCarroActionPerformed(evt);
            }
        });
        jPanel12.add(limparCamposCarro, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, -1, 17));

        jLabel67.setText("Freio:");
        jLabel67.setEnabled(false);
        jPanel12.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, -1, -1));

        freioCarro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ABS", "DISCO", "TAMBOR" }));
        freioCarro.setEnabled(false);
        jPanel12.add(freioCarro, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 70, 17));

        jLabel71.setText("Acessórios:");
        jLabel71.setEnabled(false);
        jPanel12.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 173, -1, -1));

        quatroPortas.setText("Quatro Portas");
        quatroPortas.setEnabled(false);
        jPanel12.add(quatroPortas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        arCondicionado.setText("Ar Condicionado");
        arCondicionado.setEnabled(false);
        jPanel12.add(arCondicionado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        gps.setText("GPS");
        gps.setEnabled(false);
        jPanel12.add(gps, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, -1, -1));

        direcaoHidraulica.setText("Direção Hidraulica");
        direcaoHidraulica.setEnabled(false);
        jPanel12.add(direcaoHidraulica, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, -1, -1));

        vidroEletrico.setText("Vidro Eletrico");
        vidroEletrico.setEnabled(false);
        jPanel12.add(vidroEletrico, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        travaEletrica.setText("Trava Eletrica");
        travaEletrica.setEnabled(false);
        jPanel12.add(travaEletrica, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        airBag.setText("Air Bag");
        airBag.setToolTipText("");
        airBag.setEnabled(false);
        jPanel12.add(airBag, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, -1, -1));

        bancoDeCouro.setText("Banc. Couro");
        bancoDeCouro.setEnabled(false);
        bancoDeCouro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bancoDeCouroActionPerformed(evt);
            }
        });
        jPanel12.add(bancoDeCouro, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, -1, -1));

        nivelCombustivelCarro.setEnabled(false);
        jPanel12.add(nivelCombustivelCarro, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 50, 17));

        jLabel72.setText("Niv. Combus");
        jLabel72.setEnabled(false);
        jPanel12.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, -1, -1));

        jLabel70.setText("Tipo de Pot.:");
        jLabel70.setEnabled(false);
        jPanel12.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, -1, -1));

        tipoPotenciaCarro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "HP", "CV" }));
        tipoPotenciaCarro.setEnabled(false);
        jPanel12.add(tipoPotenciaCarro, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 51, 17));

        combustivelCarro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ALCOOL", "GASOLINA", "GAS", "DIESEL", "FLEX" }));
        combustivelCarro.setEnabled(false);
        jPanel12.add(combustivelCarro, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, -1, 17));

        jLabel66.setText("Combustivel:");
        jLabel66.setEnabled(false);
        jPanel12.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, -1, -1));

        jLabel65.setText("Cor:");
        jLabel65.setEnabled(false);
        jPanel12.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 151, -1, -1));

        corCarro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "VERMELHO", "AMARELO", "AZUL", "VERDE", "CINZA", "PRATA", "PRETO", "DOURADO", "VINHO", "BRANCO" }));
        corCarro.setEnabled(false);
        jPanel12.add(corCarro, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 110, 17));

        anoCarro.setEnabled(false);
        jPanel12.add(anoCarro, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 70, 17));

        jTabbedPane4.addTab("Automóvel", jPanel12);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel45)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel46)
                            .addComponent(jTabbedPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(apagarVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(cadastrarVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(editarVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(32, 32, 32))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(jLabel46))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cadastrarVeiculo)
                            .addComponent(editarVeiculo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(apagarVeiculo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Automoveis", jPanel3);

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel55.setText("Seguro Total:");

        jLabel56.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel56.setText("em cima da taxa de locação.");

        jLabel57.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel57.setText("Seguro Parcial:");

        jLabel58.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel58.setText("Cobre todos os danos e é cobrado 50% de taxa em cima da locação.");

        jLabel85.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel85.setText("Cobre  arranhões, amassados leves, acessórios danificados e é cobrado 25%");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel55)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel58))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel57)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel85, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(96, 96, 96)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(278, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Seguros", jPanel4);

        jScrollPane4.setViewportView(jList4);

        jLabel49.setText("Lista de Locações:");

        jLabel50.setText("Opções:");

        apagarLocacao.setText("Apagar Locação");
        apagarLocacao.setEnabled(false);
        apagarLocacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apagarLocacaoActionPerformed(evt);
            }
        });

        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        clienteLocacao.setFont(new java.awt.Font("Tahoma", 0, 10));
        clienteLocacao.setEnabled(false);

        jLabel51.setText("Cliente:");
        jLabel51.setEnabled(false);

        dataDevolucaoLocacao.setEnabled(false);
        dataDevolucaoLocacao.setFont(new java.awt.Font("Tahoma", 0, 10));

        jLabel59.setText("Data Devolucao:");
        jLabel59.setEnabled(false);

        locar.setText("Registrar Locacao");
        locar.setEnabled(false);
        locar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locarActionPerformed(evt);
            }
        });

        limparCamposLocacao.setText("Limpar Campos");
        limparCamposLocacao.setEnabled(false);
        limparCamposLocacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparCamposLocacaoActionPerformed(evt);
            }
        });

        jLabel53.setText("Tipo do Seguro:");
        jLabel53.setEnabled(false);

        boxSeguro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sem Seguro", "Seguro Parcial", "Seguro Completo" }));
        boxSeguro.setEnabled(false);
        boxSeguro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxSeguroActionPerformed(evt);
            }
        });

        boxPlanos.setEnabled(false);
        boxPlanos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                boxPlanosItemStateChanged(evt);
            }
        });

        jLabel54.setText("Plano:");
        jLabel54.setEnabled(false);

        boxVeiculos.setEnabled(false);

        jLabel69.setText("Veiculo:");
        jLabel69.setEnabled(false);

        jLabel78.setText("Tipo Veiculo:");
        jLabel78.setEnabled(false);

        locarCarro.setText("Carro");
        locarCarro.setEnabled(false);
        locarCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locarCarroActionPerformed(evt);
            }
        });

        locarMoto.setText("Moto");
        locarMoto.setEnabled(false);
        locarMoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locarMotoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                                    .addComponent(jLabel51)
                                    .addGap(53, 53, 53)
                                    .addComponent(clienteLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel59)
                                        .addComponent(jLabel53))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(dataDevolucaoLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(boxSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel69)
                                        .addComponent(jLabel54))
                                    .addGap(53, 53, 53)
                                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(boxPlanos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(boxVeiculos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel11Layout.createSequentialGroup()
                                            .addComponent(locarCarro)
                                            .addGap(30, 30, 30)
                                            .addComponent(locarMoto))
                                        .addComponent(locar, javax.swing.GroupLayout.Alignment.TRAILING))))
                            .addComponent(jLabel78)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(limparCamposLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(clienteLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel78)
                    .addComponent(locarCarro)
                    .addComponent(locarMoto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(boxPlanos, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel69)
                    .addComponent(boxVeiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(dataDevolucaoLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(boxSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(limparCamposLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(locar, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        efetuarDevolucao.setText("Efetuar Devolucão");
        efetuarDevolucao.setEnabled(false);
        efetuarDevolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                efetuarDevolucaoActionPerformed(evt);
            }
        });

        jLabel52.setText("-> A locação deve ser iniciada na aba de Clientes <-");
        jLabel52.setEnabled(false);

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel7.setEnabled(false);
        jPanel7.setLayout(null);

        jLabel95.setText("Problemas com o veiculo:");
        jLabel95.setEnabled(false);
        jPanel7.add(jLabel95);
        jLabel95.setBounds(13, 13, 120, 14);

        arranhoes.setText("Arranhões");
        arranhoes.setEnabled(false);
        jPanel7.add(arranhoes);
        arranhoes.setBounds(13, 42, 120, 23);

        perdaTotalOuRoubo.setText("Perda total / Roubo");
        perdaTotalOuRoubo.setEnabled(false);
        jPanel7.add(perdaTotalOuRoubo);
        perdaTotalOuRoubo.setBounds(180, 40, 160, 23);

        amassadosLeves.setText("Amassados Leves");
        amassadosLeves.setEnabled(false);
        jPanel7.add(amassadosLeves);
        amassadosLeves.setBounds(13, 76, 170, 23);

        amassadosGraves.setText("Amassados Graves");
        amassadosGraves.setEnabled(false);
        jPanel7.add(amassadosGraves);
        amassadosGraves.setBounds(180, 80, 160, 23);

        confirmarProblemas.setText("Confirmar");
        confirmarProblemas.setEnabled(false);
        confirmarProblemas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarProblemasActionPerformed(evt);
            }
        });
        jPanel7.add(confirmarProblemas);
        confirmarProblemas.setBounds(136, 166, 91, 23);

        tanqueErrado.setText("Tanque Errado");
        tanqueErrado.setEnabled(false);
        jPanel7.add(tanqueErrado);
        tanqueErrado.setBounds(13, 104, 130, 23);

        nivelTanqueNovo.setEnabled(false);
        jPanel7.add(nivelTanqueNovo);
        nivelTanqueNovo.setBounds(210, 110, 60, 20);

        atraso.setText("Entregou com atraso");
        atraso.setEnabled(false);
        jPanel7.add(atraso);
        atraso.setBounds(13, 138, 150, 23);

        dataAtraso.setEnabled(false);
        jPanel7.add(dataAtraso);
        dataAtraso.setBounds(270, 140, 70, 20);

        jLabel111.setText("Data:");
        jLabel111.setEnabled(false);
        jPanel7.add(jLabel111);
        jLabel111.setBounds(215, 141, 50, 14);

        jLabel118.setText("->");
        jLabel118.setEnabled(false);
        jPanel7.add(jLabel118);
        jLabel118.setBounds(157, 109, 20, 14);

        jLabel119.setText("->");
        jLabel119.setEnabled(false);
        jPanel7.add(jLabel119);
        jLabel119.setBounds(170, 140, 30, 14);

        jLabel120.setText("Devolução:");

        jLabel121.setText("Locação:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel49)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(efetuarDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(apagarLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel50)))
                            .addComponent(jLabel120)
                            .addComponent(jLabel121)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel52)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(jLabel50))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(efetuarDevolucao)
                            .addComponent(apagarLocacao))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel120)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel121)
                        .addGap(4, 4, 4)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel52)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Locações", jPanel5);

        jScrollPane5.setViewportView(jListaPlanos);

        jLabel112.setText("Lista de Planos:");

        cadastrarPlanoDeLocacao.setText("Cadastrar Plano de Locação");
        cadastrarPlanoDeLocacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarPlanoDeLocacaoActionPerformed(evt);
            }
        });

        jLabel113.setText("Opções:");

        editarPlanoDeLocacao.setText("Editar Plano de Locação");
        editarPlanoDeLocacao.setEnabled(false);
        editarPlanoDeLocacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarPlanoDeLocacaoActionPerformed(evt);
            }
        });

        apagarPlanoDeLocacao.setText("Apagar Plano de Locação");
        apagarPlanoDeLocacao.setEnabled(false);
        apagarPlanoDeLocacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apagarPlanoDeLocacaoActionPerformed(evt);
            }
        });

        jTabbedPane6.setEnabled(false);

        jPanel17.setEnabled(false);

        nomePlanoCarro.setFont(new java.awt.Font("Tahoma", 0, 10));
        nomePlanoCarro.setEnabled(false);

        jLabel114.setText("Nome:");
        jLabel114.setEnabled(false);

        jLabel115.setText("Preço:");
        jLabel115.setEnabled(false);

        precoPlanoCarro.setEnabled(false);
        precoPlanoCarro.setFont(new java.awt.Font("Tahoma", 0, 10));

        cadastrarPlanoCarro.setText("Cadastrar");
        cadastrarPlanoCarro.setEnabled(false);
        cadastrarPlanoCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarPlanoCarroActionPerformed(evt);
            }
        });

        limparCamposPlanoCarro.setText("Limpar Campos");
        limparCamposPlanoCarro.setEnabled(false);
        limparCamposPlanoCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparCamposPlanoCarroActionPerformed(evt);
            }
        });

        quatroPortasPlanoCarro.setText("Quatro Portas");
        quatroPortasPlanoCarro.setEnabled(false);

        arCondicionadoPlanoCarro.setText("Ar Condicionado");
        arCondicionadoPlanoCarro.setEnabled(false);

        jLabel47.setText("Acessórios cobertos pelo plano:");
        jLabel47.setEnabled(false);

        GPSPlanoCarro.setText("GPS");
        GPSPlanoCarro.setEnabled(false);

        direcaoHidraulicaPlanoCarro.setText("Dir. Hidraulica");
        direcaoHidraulicaPlanoCarro.setEnabled(false);

        vidroEletricoPlanoCarro.setText("Vidro Eletrico");
        vidroEletricoPlanoCarro.setEnabled(false);

        travaEletricaPlanoCarro.setText("Trava Eletrico");
        travaEletricaPlanoCarro.setEnabled(false);

        airBagPlanoCarro.setText("Air Bag");
        airBagPlanoCarro.setEnabled(false);

        bancosCouraPlanoCarro.setText("Bancos de Couro");
        bancosCouraPlanoCarro.setEnabled(false);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel115)
                                    .addComponent(jLabel114))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(precoPlanoCarro, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nomePlanoCarro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)))
                            .addComponent(jLabel47)))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(limparCamposPlanoCarro))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(GPSPlanoCarro)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(quatroPortasPlanoCarro)
                                    .addComponent(arCondicionadoPlanoCarro)
                                    .addComponent(airBagPlanoCarro))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(direcaoHidraulicaPlanoCarro)
                                    .addComponent(vidroEletricoPlanoCarro)
                                    .addComponent(travaEletricaPlanoCarro)
                                    .addComponent(bancosCouraPlanoCarro)
                                    .addComponent(cadastrarPlanoCarro, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel114)
                    .addComponent(nomePlanoCarro, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel115)
                    .addComponent(precoPlanoCarro, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel47)
                .addGap(14, 14, 14)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(travaEletricaPlanoCarro)
                            .addComponent(airBagPlanoCarro))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(quatroPortasPlanoCarro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(arCondicionadoPlanoCarro))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(direcaoHidraulicaPlanoCarro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(vidroEletricoPlanoCarro)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GPSPlanoCarro)
                    .addComponent(bancosCouraPlanoCarro))
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(limparCamposPlanoCarro, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadastrarPlanoCarro, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jTabbedPane6.addTab("Automóvel", jPanel17);

        jPanel18.setEnabled(false);

        cadastrarPlanoMoto.setText("Cadastrar");
        cadastrarPlanoMoto.setEnabled(false);
        cadastrarPlanoMoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarPlanoMotoActionPerformed(evt);
            }
        });

        limparCamposPlanoMoto.setText("Limpar Campos");
        limparCamposPlanoMoto.setEnabled(false);
        limparCamposPlanoMoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparCamposPlanoMotoActionPerformed(evt);
            }
        });

        jLabel116.setText("Nome:");

        nomePlanoMoto.setFont(new java.awt.Font("Tahoma", 0, 10));
        nomePlanoMoto.setEnabled(false);

        jLabel117.setText("Preço (R$):");

        precoPlanoMoto.setEnabled(false);
        precoPlanoMoto.setFont(new java.awt.Font("Tahoma", 0, 10));

        jLabel48.setText("Cilindrada coberta pelo plano:");

        cilindradasPlanoMoto.setEnabled(false);
        cilindradasPlanoMoto.setFont(new java.awt.Font("Tahoma", 0, 10));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(jLabel48)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cilindradasPlanoMoto, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(jLabel117)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(precoPlanoMoto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(limparCamposPlanoMoto)
                        .addGap(18, 18, 18)
                        .addComponent(cadastrarPlanoMoto, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel116)
                        .addGap(28, 28, 28)
                        .addComponent(nomePlanoMoto, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel116)
                    .addComponent(nomePlanoMoto, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel48)
                    .addComponent(cilindradasPlanoMoto, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel117)
                    .addComponent(precoPlanoMoto, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(limparCamposPlanoMoto, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadastrarPlanoMoto, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(87, 87, 87))
        );

        jTabbedPane6.addTab("Moto", jPanel18);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel112)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel113))
                            .addComponent(apagarPlanoDeLocacao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(editarPlanoDeLocacao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cadastrarPlanoDeLocacao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jTabbedPane6, 0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel112)
                    .addComponent(jLabel113))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(cadastrarPlanoDeLocacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editarPlanoDeLocacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(apagarPlanoDeLocacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                        .addComponent(jTabbedPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))))
        );

        jTabbedPane1.addTab("Planos de Locação", jPanel6);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel86.setText("Agência:");

        jLabel87.setText("Gerente:");

        estadoAgencia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        jLabel89.setText("Estado:");

        jLabel90.setText("Ins. Estadual: ");

        inscEstadualAgencia.setFont(new java.awt.Font("Tahoma", 0, 10));

        jLabel91.setText("Cidade:");

        cidadeAgencia.setFont(new java.awt.Font("Tahoma", 0, 10));

        jLabel92.setText("Bairro:");

        bairroAgencia.setFont(new java.awt.Font("Tahoma", 0, 10));

        numeroAgencia.setFont(new java.awt.Font("Tahoma", 0, 10));

        jLabel93.setText("Nº:");

        jLabel94.setText("Rua:");

        ruaAgencia.setFont(new java.awt.Font("Tahoma", 0, 10));

        jLabel96.setText("Telefone:");

        telefoneAgencia.setFont(new java.awt.Font("Tahoma", 0, 10));

        cepAgencia.setFont(new java.awt.Font("Tahoma", 0, 10));

        jLabel97.setText("CEP:");

        jLabel88.setText("CNPJ:");

        cnpjAgencia.setFont(new java.awt.Font("Tahoma", 0, 10));

        jLabel98.setText("Nome:");

        nomeGerente.setFont(new java.awt.Font("Tahoma", 0, 10));

        jLabel99.setText("CPF:");

        cpfGerente.setFont(new java.awt.Font("Tahoma", 0, 10));

        rgGerente.setFont(new java.awt.Font("Tahoma", 0, 10));

        jLabel100.setText("RG:");

        jLabel101.setText("Estado:");

        estadoGerente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        nascimentoGerente.setFont(new java.awt.Font("Tahoma", 0, 10));

        jLabel102.setText("Data Nasc:");

        jLabel103.setText("Naturalidade:");

        naturalidadeGerente.setFont(new java.awt.Font("Tahoma", 0, 10));

        jLabel104.setText("Cidade:");

        cidadeGerente.setFont(new java.awt.Font("Tahoma", 0, 10));

        jLabel105.setText("Bairro:");

        bairroGerente.setFont(new java.awt.Font("Tahoma", 0, 10));

        numeroGerente.setFont(new java.awt.Font("Tahoma", 0, 10));

        jLabel106.setText("Nº:");

        jLabel107.setText("Rua:");

        ruaGerente.setFont(new java.awt.Font("Tahoma", 0, 10));

        jLabel108.setText("E-mail:");

        emailGerente.setFont(new java.awt.Font("Tahoma", 0, 10));

        jLabel109.setText("Telefone:");

        telefoneGerente.setFont(new java.awt.Font("Tahoma", 0, 10));

        cepGerente.setFont(new java.awt.Font("Tahoma", 0, 10));

        jLabel110.setText("CEP:");

        atualizarAgenciaGerente.setText("Atualizar");
        atualizarAgenciaGerente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarAgenciaGerenteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel86)
                        .addGap(235, 235, 235))
                    .addComponent(jLabel88)
                    .addComponent(jLabel89)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel96)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(telefoneAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel97)
                                .addGap(2, 2, 2)
                                .addComponent(cepAgencia, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                            .addComponent(estadoAgencia, javax.swing.GroupLayout.Alignment.TRAILING, 0, 227, Short.MAX_VALUE)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel92)
                            .addComponent(jLabel91)
                            .addComponent(jLabel94))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cidadeAgencia, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                                .addComponent(bairroAgencia, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel93)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numeroAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ruaAgencia, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel90)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cnpjAgencia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                            .addComponent(inscEstadualAgencia, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel14Layout.createSequentialGroup()
                            .addComponent(jLabel87)
                            .addGap(235, 235, 235))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel14Layout.createSequentialGroup()
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel105)
                                    .addComponent(jLabel104)
                                    .addComponent(jLabel107)
                                    .addComponent(jLabel99)
                                    .addComponent(jLabel98)
                                    .addComponent(jLabel108)
                                    .addComponent(jLabel109)
                                    .addComponent(jLabel103, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addComponent(jLabel102))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                                    .addComponent(bairroGerente, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel106)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(numeroGerente, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(emailGerente, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                                .addGroup(jPanel14Layout.createSequentialGroup()
                                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(nascimentoGerente)
                                        .addComponent(cpfGerente, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel14Layout.createSequentialGroup()
                                            .addComponent(jLabel100)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(rgGerente, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                                        .addGroup(jPanel14Layout.createSequentialGroup()
                                            .addComponent(jLabel101)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(estadoGerente, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addComponent(naturalidadeGerente, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                                .addComponent(nomeGerente, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                                .addComponent(cidadeGerente, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                                .addComponent(ruaGerente, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                                .addGroup(jPanel14Layout.createSequentialGroup()
                                    .addComponent(telefoneGerente, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel110)
                                    .addGap(2, 2, 2)
                                    .addComponent(cepGerente, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)))
                            .addContainerGap()))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addComponent(atualizarAgenciaGerente)
                        .addContainerGap())))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel86)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel88)
                                    .addComponent(cnpjAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel90)
                                    .addComponent(inscEstadualAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cidadeAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel91))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(bairroAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(numeroAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel93))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(ruaAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel94)))
                                    .addComponent(jLabel92))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel96)
                                    .addComponent(telefoneAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cepAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel97))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel89)
                                    .addComponent(estadoAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel87)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel98)
                                    .addComponent(nomeGerente, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel99)
                                    .addComponent(cpfGerente, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rgGerente, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel100))
                                .addGap(7, 7, 7)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(nascimentoGerente, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel102)
                                    .addComponent(jLabel101)
                                    .addComponent(estadoGerente, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel103)
                                    .addComponent(naturalidadeGerente, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cidadeGerente, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel104))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(bairroGerente, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(numeroGerente, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel106))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(ruaGerente, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel107))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(emailGerente, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel108))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel109)
                                            .addComponent(telefoneGerente, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cepGerente, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel110)))
                                    .addComponent(jLabel105))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 315, Short.MAX_VALUE)
                        .addComponent(atualizarAgenciaGerente))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Agência", jPanel14);

        jMenu1.setText("Sobre");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu1MousePressed(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenuSair.setText("Sair");
        jMenuSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuSairMousePressed(evt);
            }
        });
        jMenuBar1.add(jMenuSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(239, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(231, 231, 231))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarClienteActionPerformed
        ativarCadastro();
    }//GEN-LAST:event_cadastrarClienteActionPerformed

    public static boolean verificaInt( String str ){
        boolean bool = false;
        try{
            int num = Integer.parseInt( str );
            bool = true;
        }catch( NumberFormatException exception ){
            bool = false;
        }   
        return bool;
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Cliente cliente = null;
        String nomeC = nome.getText();
        String cpfC = cpf.getText();
        String rgC = rg.getText();
        String nascimentoC = nascimento.getText();
        UnidadeFederativa estadoC = UnidadeFederativa.valueOf((String) estado.getSelectedItem());
        String naturalidadeC = naturalidade.getText();
        String cidadeC = cidade.getText();
        String bairroC = bairro.getText();
        String ruaC = rua.getText();
        String numeroC = numero.getText();
        String emailC = email.getText();
        String telefoneC = telefone.getText();
        String cepC = cep.getText();

        if (!(verificaInt(numeroC)))
            JOptionPane.showMessageDialog(rootPane, "Numero deve ser um inteiro valido!","Aviso",2);
        else{
            if (jButton1.getText().equals("Cadastrar")) {
                if (nomeC.equals("") || cpfC.replace(" ", "").length() < 5 || rgC.equals("")
                        || nascimentoC.replace(" ", "").length() < 5 || estadoC == null || naturalidadeC.equals("")
                        || cidadeC.equals("") || bairroC.equals("") || ruaC.equals("") || numeroC.equals("")
                        || emailC.equals("") || telefoneC.replace(" ", "").length() < 5 || cepC.replace(" ", "").length() < 5) {
                    JOptionPane.showMessageDialog(rootPane, "Voce deve preencher todos os dados!","Aviso",2);
                } else {
                    try {
                        Endereco end = new Endereco(estadoC, cidadeC, bairroC, ruaC, Integer.parseInt(numeroC), cepC);
                        cliente = new PessoaFisica(cpfC, nomeC, rgC, nascimentoC, naturalidadeC, end, telefoneC, emailC);
                        dadosAgencia.adicionaCliente(cliente);
                        atualizarFilial(dadosAgencia);
                        JOptionPane.showMessageDialog(rootPane, "Cliente cadastrado com sucesso!");
                        atualizarListaDeClientes();
                        limparCampos.doClick();
                        desativarCadastro();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(rootPane, e.getMessage(),"Erro",2);
                    }
                }

            } else {
                if (nomeC.equals("") || cpfC.replace(" ", "").length() < 5 || rgC.equals("")
                        || nascimentoC.replace(" ", "").length() < 5 || estadoC == null || naturalidadeC.equals("")
                        || cidadeC.equals("") || bairroC.equals("") || ruaC.equals("") || numeroC.equals("")
                        || emailC.equals("") || telefoneC.replace(" ", "").length() < 5 || cepC.replace(" ", "").length() < 5) {
                    JOptionPane.showMessageDialog(rootPane, "Voce deve preencher todos os dados!","Aviso",2);
                } else {
                    try {
                        PessoaFisica clienteS = (PessoaFisica) getClienteSelecionado();
                        Endereco end = new Endereco(estadoC, cidadeC, bairroC, ruaC, Integer.parseInt(numeroC), cepC);
                        clienteS.setCpf(cpfC);
                        clienteS.setEmail(emailC);
                        clienteS.setNascimento(nascimentoC);
                        clienteS.setNaturalidade(naturalidadeC);
                        clienteS.setNome(nomeC);
                        clienteS.setRg(rgC);
                        clienteS.setTelefone(telefoneC);
                        clienteS.setEndereco(end);
                        atualizarFilial(dadosAgencia);
                        atualizarListaDeClientes();
                        JOptionPane.showMessageDialog(rootPane, "A edicao foi completada com sucesso!");
                        limparCampos.setText("Limpar Campos");
                        limparCampos.doClick();
                        desativarCadastro();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(rootPane, e.getMessage(),"Erro",2);
                    }
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        Cliente cliente = null;
        String nomeF = nome1.getText();
        String cnpjF = cnpj.getText();
        String rzSocialF = rzSocial.getText();
        UnidadeFederativa estadoF = UnidadeFederativa.valueOf((String) estado1.getSelectedItem());
        String inscEstadualF = inscEstadual.getText();
        String cidadeF = cidade1.getText();
        String bairroF = bairro1.getText();
        String numeroF = numero1.getText();
        String ruaF = rua1.getText();
        String emailF = email1.getText();
        String telefoneF = telefone1.getText();
        String cepF = cep1.getText();
        if (!(verificaInt(numeroF)))
            JOptionPane.showMessageDialog(rootPane, "Numero deve ser um inteiro valido!","Aviso",2);
        else{
            if (jButton8.getText().equals("Cadastrar")) {
                if (nomeF.equals("") || cnpjF.replace(" ", "").length() < 5 || rzSocialF.equals("")
                        || inscEstadualF.replace(" ", "").equals("") || estadoF == null
                        || cidadeF.equals("") || bairroF.equals("") || ruaF.equals("") || numeroF.equals("")
                        || emailF.equals("") || telefoneF.replace(" ", "").length() < 5 || cepF.replace(" ", "").length() < 5) {
                    JOptionPane.showMessageDialog(rootPane, "Voce deve preencher todos os dados!","Aviso",2);
                } else {
                    try {
                        Endereco end = new Endereco(estadoF, cidadeF, bairroF, ruaF, Integer.parseInt(numeroF), cepF);
                        cliente = new PessoaJuridica(cnpjF, rzSocialF, nomeF, inscEstadualF, end, telefoneF, emailF);
                        dadosAgencia.adicionaCliente(cliente);
                        atualizarFilial(dadosAgencia);
                        atualizarListaDeClientes();
                        JOptionPane.showMessageDialog(rootPane, "Cliente cadastrado com sucesso!");
                        limparCampos1.doClick();
                        desativarCadastro();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(rootPane, e.getMessage(),"Erro",2);
                    }
                }
            } else {
                if (nomeF.equals("") || cnpjF.replace(" ", "").length() < 5 || rzSocialF.equals("")
                        || inscEstadualF.replace(" ", "").length() < 5 || estadoF == null
                        || cidadeF.equals("") || bairroF.equals("") || ruaF.equals("") || numeroF.equals("")
                        || emailF.equals("") || telefoneF.replace(" ", "").length() < 5 || cepF.replace(" ", "").length() < 5) {
                    JOptionPane.showMessageDialog(rootPane, "Voce deve preencher todos os dados!","Aviso",2);
                } else {
                    try {
                        PessoaJuridica pessoaS = (PessoaJuridica) getClienteSelecionado();
                        Endereco end = new Endereco(estadoF, cidadeF, bairroF, ruaF, Integer.parseInt(numeroF), cepF);
                        pessoaS.setNome(nomeF);
                        pessoaS.setRazaoSocial(rzSocialF);
                        pessoaS.setEndereco(end);
                        pessoaS.setInscricaoEstadual(inscEstadualF);
                        pessoaS.setEmail(emailF);
                        pessoaS.setTelefone(telefoneF);
                        pessoaS.setCnpj(cnpjF);

                        atualizarFilial(dadosAgencia);
                        atualizarListaDeClientes();
                        JOptionPane.showMessageDialog(rootPane, "A edicao foi completada com sucesso!");
                        limparCampos1.setText("Limpar Campos");
                        limparCampos1.doClick();
                        desativarCadastro();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(rootPane, e.getMessage(),"Erro",2);
                    }
                }
            }
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void cadastrarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarFuncionarioActionPerformed
        String nomeF = nome2.getText();
        String cpfF = cpf1.getText();
        String rgF = rg1.getText();
        UnidadeFederativa estadoF = UnidadeFederativa.valueOf((String) estado2.getSelectedItem());
        String nascimentoF = nascimento1.getText();
        String naturalidadeF = naturalidade1.getText();
        String cidadeF = cidade2.getText();
        String bairroF = bairro4.getText();
        String numeroF = numero2.getText();
        String ruaF = rua2.getText();
        String emailF = email2.getText();
        String telefoneF = telefone2.getText();
        String cepF = cep2.getText();
        Pessoa funcionario;
        if (cadastrarFuncionario.getText().equals("Cadastrar")) {
            if (nomeF.equals("") || cpfF.replace(" ", "").length() < 5 || rgF.equals("")
                    || nascimentoF.replace(" ", "").length() < 5 || estadoF == null || naturalidadeF.equals("")
                    || cidadeF.equals("") || bairroF.equals("") || ruaF.equals("") || numeroF.equals("")
                    || emailF.equals("") || telefoneF.replace(" ", "").length() < 5 || cepF.replace(" ", "").length() < 5) {
                JOptionPane.showMessageDialog(rootPane, "Voce deve preencher todos os dados!","Aviso",2);
            } else {
                try {
                    Endereco end = new Endereco(estadoF, cidadeF, bairroF, ruaF, Integer.parseInt(numeroF), cepF);
                    if (jComboTipoFuncionario.getSelectedIndex() == 0) {
                        funcionario = new Locador(cpfF, nomeF, rgF, nascimentoF, naturalidadeF, end, telefoneF, emailF);
                    } else if (jComboTipoFuncionario.getSelectedIndex() == 1) {
                        funcionario = new Zelador(cpfF, nomeF, rgF, nascimentoF, naturalidadeF, end, telefoneF, emailF);
                    } else {
                        funcionario = new Seguranca(cpfF, nomeF, rgF, nascimentoF, naturalidadeF, end, telefoneF, emailF);
                    }
                    dadosAgencia.adicionaFuncionario(funcionario);
                    atualizarFilial(dadosAgencia);
                    JOptionPane.showMessageDialog(rootPane, "Funcionario cadastrado com sucesso!");
                    atualizarListaDeFuncionarios();
                    limparCampos3.doClick();
                    desativarCadastroFuncionarios();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, e.getMessage(),"Erro",2);
                }
            }
        } else {
            if (nomeF.equals("") || cpfF.replace(" ", "").length() < 5 || rgF.equals("")
                    || nascimentoF.replace(" ", "").length() < 5 || estadoF == null || naturalidadeF.equals("")
                    || cidadeF.equals("") || bairroF.equals("") || ruaF.equals("") || numeroF.equals("")
                    || emailF.equals("") || telefoneF.replace(" ", "").length() < 5 || cepF.replace(" ", "").length() < 5) {
                JOptionPane.showMessageDialog(rootPane, "Voce deve preencher todos os dados!","Aviso",2);
            } else {
                try {
                    Pessoa funcionarioS = getFuncionarioSelecionado();
                    Endereco end = new Endereco(estadoF, cidadeF, bairroF, ruaF, Integer.parseInt(numeroF), cepF);
                    funcionarioS.setCpf(cpfF);
                    funcionarioS.setEmail(emailF);
                    funcionarioS.setNascimento(nascimentoF);
                    funcionarioS.setNaturalidade(naturalidadeF);
                    funcionarioS.setNome(nomeF);
                    funcionarioS.setRg(rgF);
                    funcionarioS.setTelefone(telefoneF);
                    funcionarioS.setEndereco(end);
                    atualizarFilial(dadosAgencia);
                    atualizarListaDeFuncionarios();
                    JOptionPane.showMessageDialog(rootPane, "A edicao foi completada com sucesso!");
                    limparCampos3.setText("Limpar Campos");
                    limparCampos3.doClick();
                    desativarCadastroFuncionarios();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, e.getMessage(),"Erro",2);
                }
            }
        }
    }//GEN-LAST:event_cadastrarFuncionarioActionPerformed

    private void cadastrarVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarVeiculoActionPerformed
        ativarCadastroVeiculo();
    }//GEN-LAST:event_cadastrarVeiculoActionPerformed

    private void cadastrarCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarCarroActionPerformed
        ArrayList<Acessorio> listaAcessorios = new ArrayList<Acessorio>();
        String renavanC = renavamCarro.getText();
        String modeloC = modeloCarro.getText();
        String marcaC = marcaCarro.getText();
        String potenciaC = potenciaCarro.getText();
        String dataAquisicaoC = dataAquisicaoCarro.getText();
        String anoC = anoCarro.getText();

        TipoDeFreio freioC = TipoDeFreio.valueOf((String) freioCarro.getSelectedItem());
        TipoDePotencia tipoPotenciaC = TipoDePotencia.valueOf((String) tipoPotenciaCarro.getSelectedItem());
        int nivelCombustivelC = ((Integer) nivelCombustivelCarro.getValue()).intValue();
        Cor corC = Cor.valueOf((String) corCarro.getSelectedItem());
        TipoDeCombustivel combustivelC = TipoDeCombustivel.valueOf((String) combustivelCarro.getSelectedItem());
        if (quatroPortas.isSelected()) {
            listaAcessorios.add(Acessorio.QP);
        }
        if (arCondicionado.isSelected()) {
            listaAcessorios.add(Acessorio.AC);
        }
        if (vidroEletrico.isSelected()) {
            listaAcessorios.add(Acessorio.VE);
        }
        if (travaEletrica.isSelected()) {
            listaAcessorios.add(Acessorio.TE);
        }
        if (gps.isSelected()) {
            listaAcessorios.add(Acessorio.GPS);
        }
        if (direcaoHidraulica.isSelected()) {
            listaAcessorios.add(Acessorio.DH);
        }
        if (bancoDeCouro.isSelected()) {
            listaAcessorios.add(Acessorio.BC);
        }
        if (airBag.isSelected()) {
            listaAcessorios.add(Acessorio.AB);
        }
        if (cadastrarCarro.getText().equals("Cadastrar")) {
            try {
                dadosAgencia.adicionaVeiculo(new Automovel(renavanC, modeloC, marcaC, Integer.parseInt(potenciaC), Integer.parseInt(anoC), corC, freioC, combustivelC, dataAquisicaoC, nivelCombustivelC, listaAcessorios, tipoPotenciaC));
                atualizarFilial(dadosAgencia);
                atualizarListaDeVeiculos();
                JOptionPane.showMessageDialog(rootPane, "Carro cadastrado com sucesso!");
                limparCamposCarro.doClick();
                desativarCadastroVeiculo();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e.getMessage(),"Erro",2);
            }
        } else {
            try {
                Automovel auto = (Automovel) getVeiculoSelecionado();
                auto.setRenavam(renavanC);
                auto.setModelo(modeloC);
                auto.setMarca(marcaC);
                auto.setPotencia(Integer.parseInt(potenciaC));
                auto.setAno(Integer.parseInt(anoC));
                auto.setCor(corC);
                auto.setTipoDeFreios(freioC);
                auto.setTipoDeCombustivel(combustivelC);
                auto.setDataDeAquisicao(dataAquisicaoC);
                auto.setNivelDoTanque(nivelCombustivelC);
                auto.setOpcionais(listaAcessorios);
                auto.setTipoDePotencia(tipoPotenciaC);
                JOptionPane.showMessageDialog(rootPane, "A edicao foi completada com sucesso!");
                limparCamposCarro.setText("Limpar Campos");
                limparCamposCarro.doClick();
                desativarCadastroVeiculo();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e.getMessage(),"Erro",2);
            }
        }
    }//GEN-LAST:event_cadastrarCarroActionPerformed

    private void cadastrarMotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarMotoActionPerformed
        String renavam = renavamMoto.getText();
        String modelo = modeloMoto.getText();
        String marca = marcaMoto.getText();
        String potencia = potenciaMoto.getText();
        String data = dataAquisicaoMoto.getText();
        String cilindradas = cilindradasMoto.getText();
        String ano = anoMoto.getText();

        TipoDeCombustivel combustivelMoto = TipoDeCombustivel.valueOf((String) jTipoCombustivelMoto.getSelectedItem());
        TipoDeFreio freioMoto = TipoDeFreio.valueOf((String) jTipoFreioMoto.getSelectedItem());
        TipoDePotencia tipoPotenciaMoto = TipoDePotencia.valueOf((String) jTipoPotenciaMoto.getSelectedItem());
        Cor corMoto = Cor.valueOf((String) jTipoCorMoto.getSelectedItem());
        int nivelTanque = ((Integer) jSpinnerCombustivelMoto.getValue()).intValue();
        if (renavam.equals("") || modelo.equals("") || marca.equals("")
                || potencia.equals("") || data.equals("") || cilindradas.equals("") || ano.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Voce deve preencher todos os dados!","Aviso",2);
        } else {
            if (cadastrarMoto.getText().equals("Cadastrar")) {
                try {
                    int potencia1 = Integer.parseInt(potencia);
                    int cilindradas1 = Integer.parseInt(cilindradas);
                    int ano1 = Integer.parseInt(ano);
                    Motocicleta moto = new Motocicleta(renavam, modelo, marca, tipoPotenciaMoto,freioMoto,potencia1, cilindradas1, ano1, corMoto, combustivelMoto, data, nivelTanque);
                    dadosAgencia.adicionaVeiculo(moto);
                    atualizarFilial(dadosAgencia);
                    atualizarListaDeVeiculos();
                    JOptionPane.showMessageDialog(rootPane, "Moto cadastrada com sucesso!");
                    limparCamposMoto.doClick();
                    desativarCadastroVeiculo();
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(rootPane, "Digitar apenas numeros nos campos de potencia, cilindradas e ano.");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, e.getMessage(),"Erro",2);
                }
            } else {
                try {
                    Motocicleta moto = (Motocicleta) getVeiculoSelecionado();
                    moto.setAno(Integer.parseInt(ano));
                    moto.setRenavam(renavam);
                    moto.setModelo(modelo);
                    moto.setMarca(marca);
                    moto.setTipoDePotencia(tipoPotenciaMoto);
                    moto.setPotencia(Integer.parseInt(potencia));
                    moto.setCilindradas(Integer.parseInt(cilindradas));
                    moto.setCor(corMoto);
                    moto.setTipoDeCombustivel(combustivelMoto);
                    moto.setDataDeAquisicao(data);
                    moto.setNivelDoTanque(nivelTanque);
                    JOptionPane.showMessageDialog(rootPane, "A edicao foi completada com sucesso!");
                    limparCamposMoto.setText("Limpar Campos");
                    limparCamposMoto.doClick();
                    desativarCadastroVeiculo();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, e.getMessage(),"Erro",2);
                }
            }
        }
    }//GEN-LAST:event_cadastrarMotoActionPerformed

    private void cadastrarPlanoDeLocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarPlanoDeLocacaoActionPerformed
        ativarCadastroPlanos();
    }//GEN-LAST:event_cadastrarPlanoDeLocacaoActionPerformed

    private void cadastrarPlanoCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarPlanoCarroActionPerformed
        String nome = nomePlanoCarro.getText();
        String preco = precoPlanoCarro.getText();
        ArrayList<Acessorio> listaAcessorios = new ArrayList<Acessorio>();
        if (quatroPortasPlanoCarro.isSelected()) {
            listaAcessorios.add(Acessorio.QP);
        }
        if (arCondicionadoPlanoCarro.isSelected()) {
            listaAcessorios.add(Acessorio.AC);
        }
        if (vidroEletricoPlanoCarro.isSelected()) {
            listaAcessorios.add(Acessorio.VE);
        }
        if (travaEletricaPlanoCarro.isSelected()) {
            listaAcessorios.add(Acessorio.TE);
        }
        if (GPSPlanoCarro.isSelected()) {
            listaAcessorios.add(Acessorio.GPS);
        }
        if (direcaoHidraulicaPlanoCarro.isSelected()) {
            listaAcessorios.add(Acessorio.DH);
        }
        if (bancosCouraPlanoCarro.isSelected()) {
            listaAcessorios.add(Acessorio.BC);
        }
        if (airBagPlanoCarro.isSelected()) {
            listaAcessorios.add(Acessorio.AB);
        }
        if (cadastrarPlanoCarro.getText().equals("Cadastrar")) {
            try {
                PlanoAutomovel plano = new PlanoAutomovel(nome, Double.parseDouble(preco));
                plano.adicionaListaAcessorios(listaAcessorios);
                dadosAgencia.adicionaPlano(plano);
                atualizarFilial(dadosAgencia);
                atualizarListaDePlanos();
                desativarCadastroPlanos();
                JOptionPane.showMessageDialog(rootPane, "Plano cadastrado com sucesso!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e.getMessage(),"Erro",2);
            }
        } else {
            try {
                PlanoAutomovel pla = (PlanoAutomovel) getPlanoSelecionado();
                pla.setNome(nome);
                pla.setPreco(Double.parseDouble(preco));
                pla.adicionaListaAcessorios(listaAcessorios);
                JOptionPane.showMessageDialog(rootPane, "A edicao foi completada com sucesso!");
                atualizarFilial(dadosAgencia);
                limparCamposPlanoCarro.setText("Limpar Campos");
                limparCamposPlanoCarro.doClick();
                desativarCadastroPlanos();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e.getMessage(),"Erro",2);
            }
        }
    }//GEN-LAST:event_cadastrarPlanoCarroActionPerformed

    private void bancoDeCouroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bancoDeCouroActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_bancoDeCouroActionPerformed

    private void cadastrarPlanoMotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarPlanoMotoActionPerformed
        String nome = nomePlanoMoto.getText();
        String preco = precoPlanoMoto.getText();
        String cilindradas = cilindradasPlanoMoto.getText();
        if (cadastrarPlanoMoto.getText().equals("Cadastrar")) {
            try {
                PlanoMoto plano = new PlanoMoto(nome, Double.parseDouble(preco));
                plano.adicionaCilindradas(Integer.parseInt(cilindradas));
                dadosAgencia.adicionaPlano(plano);
                atualizarFilial(dadosAgencia);
                atualizarListaDePlanos();
                desativarCadastroPlanos();
                JOptionPane.showMessageDialog(rootPane, "Plano cadastrado com sucesso!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e.getMessage(),"Erro",2);
            }
        } else {
            try {
                PlanoMoto pla = (PlanoMoto) getPlanoSelecionado();
                pla.setNome(nome);
                pla.setPreco(Double.parseDouble(preco));
                pla.adicionaCilindradas(Integer.parseInt(cilindradas));
                JOptionPane.showMessageDialog(rootPane, "A edicao foi completada com sucesso!");
                limparCamposPlanoMoto.setText("Limpar Campos");
                limparCamposPlanoMoto.doClick();
                atualizarFilial(dadosAgencia);
                 desativarCadastroPlanos();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e.getMessage(),"Erro",2);
            }
        }
}//GEN-LAST:event_cadastrarPlanoMotoActionPerformed

    private void locarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locarActionPerformed
        if(boxPlanos.getSelectedObjects()== null || boxVeiculos.getSelectedObjects()==null||dataDevolucaoLocacao.getText().replace(" ", "").length()<5)
            JOptionPane.showMessageDialog(rootPane, "Voce deve preencher todos os dados da locação!","Aviso",2);
        else{
            Cliente clienteL = getClienteSelecionado();
            Plano planoL = null;
            Veiculo veiculoL = null;

            ArrayList<PlanoAutomovel> listaPlanoCarro = new ArrayList<PlanoAutomovel>();
            ArrayList<PlanoMoto> listaPlanoMoto = new ArrayList<PlanoMoto>();
            for(Plano p : dadosAgencia.getPlano()){
                if(p instanceof PlanoAutomovel)
                    listaPlanoCarro.add((PlanoAutomovel)p);
                else
                    listaPlanoMoto.add((PlanoMoto) p);
            }

            ArrayList<Automovel> listaCarro = new ArrayList<Automovel>();
            ArrayList<Motocicleta> listaMoto = new ArrayList<Motocicleta>();
            if (locarCarro.isSelected()){
                for(Veiculo v : atualizarListaVeiculosDisponiveisParaPlanoLocacao(listaPlanoCarro.get(boxPlanos.getSelectedIndex()))){
                        listaCarro.add((Automovel)v);
                }
            }else{
                for(Veiculo v : atualizarListaVeiculosDisponiveisParaPlanoLocacao(listaPlanoMoto.get(boxPlanos.getSelectedIndex()))){
                        listaMoto.add((Motocicleta)v);
                }
            }

            if (locarCarro.isSelected()) {
                planoL = (PlanoAutomovel) listaPlanoCarro.toArray()[boxPlanos.getSelectedIndex()];
                veiculoL = (Automovel) listaCarro.toArray()[boxVeiculos.getSelectedIndex()];
            } else if (locarMoto.isSelected()) {
                planoL = (PlanoMoto) listaPlanoMoto.toArray()[boxPlanos.getSelectedIndex()];
                veiculoL = (Motocicleta) listaMoto.toArray()[boxVeiculos.getSelectedIndex()];
            }
            String dataEntregaL = dataDevolucaoLocacao.getText();
            int seguroL = boxSeguro.getSelectedIndex();
            try {
                dadosAgencia.adicionaLocacao(new Locacao(veiculoL, clienteL, planoL, dataEntregaL, dataEntregaL, seguroL));
                veiculoL.setLocado(true);
                JOptionPane.showMessageDialog(rootPane, "Locacao adicionada com sucesso!");
                atualizarFilial(dadosAgencia);
                atualizarListaDeVeiculos();
                atualizarListaDeLocacoes();
                limparCamposLocacao.doClick();
                desativarLocacao();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e.getMessage(),"Erro",2);
            }
        }
    }//GEN-LAST:event_locarActionPerformed

    private void boxSeguroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxSeguroActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_boxSeguroActionPerformed

    private void editarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarClienteActionPerformed
        Cliente cliente = getClienteSelecionado();
        if (cliente instanceof PessoaFisica) {
            PessoaFisica clienteP = (PessoaFisica) cliente;
            jTabbedPane2.setSelectedComponent(jPanel8);
            nome.setText(clienteP.getNome());
            cpf.setText(clienteP.getCpf());
            rg.setText(clienteP.getRg());
            estado.setSelectedItem(clienteP.getEndereco().getEstado().toString());
            nascimento.setText(clienteP.getNascimento());
            naturalidade.setText(clienteP.getNaturalidade());
            cidade.setText(clienteP.getEndereco().getCidade());
            bairro.setText(clienteP.getEndereco().getBairro());
            numero.setText(Integer.toString(clienteP.getEndereco().getNumero()));
            rua.setText(clienteP.getEndereco().getRua());
            email.setText(clienteP.getEmail());
            telefone.setText(clienteP.getTelefone());
            cep.setText(clienteP.getEndereco().getCep());
            jButton1.setText("Atualizar");
            limparCampos.setText("Cancelar");
        } else {
            PessoaJuridica clienteP = (PessoaJuridica) cliente;
            jTabbedPane2.setSelectedComponent(jPanel9);
            nome1.setText(clienteP.getNome());
            cnpj.setText(clienteP.getCnpj());
            rzSocial.setText(clienteP.getRazaoSocial());
            inscEstadual.setText(clienteP.getInscricaoEstadual());
            cidade1.setText(clienteP.getEndereco().getCidade());
            bairro1.setText(clienteP.getEndereco().getBairro());
            numero1.setText(Integer.toString(clienteP.getEndereco().getNumero()));
            rua1.setText(clienteP.getEndereco().getRua());
            email1.setText(clienteP.getEmail());
            telefone1.setText(clienteP.getTelefone());
            cep1.setText(clienteP.getEndereco().getCep());
            jButton8.setText("Atualizar");
            limparCampos1.setText("Cancelar");
        }
        ativarCadastro();
    }//GEN-LAST:event_editarClienteActionPerformed

    private void apagarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apagarClienteActionPerformed
        int n = JOptionPane.showOptionDialog(rootPane, "Confirmar exclusão de cliente?", "Confirmarção", JOptionPane.YES_NO_OPTION, 0, null, opcoes, opcoes[1]);
        if (n == 0) {
            dadosAgencia.removeCliente(jListaClientes.getSelectedIndex());
            atualizarFilial(dadosAgencia);
            atualizarListaDeClientes();
        }
    }//GEN-LAST:event_apagarClienteActionPerformed

    private void verificarDebitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verificarDebitoActionPerformed
        Cliente pessoa = (Cliente) dadosAgencia.getClientes().toArray()[jListaClientes.getSelectedIndex()];
        if (pessoa.getEmDebito()) {
            JOptionPane.showMessageDialog(rootPane, "O debito do cliente " + pessoa.getNome() + " eh de R$" + pessoa.getDivida());
        } else {
            JOptionPane.showMessageDialog(rootPane, "O cliente " + pessoa.getNome() + " nao esta em debito!");
        }
    }//GEN-LAST:event_verificarDebitoActionPerformed

    private void realizarLocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_realizarLocacaoActionPerformed
        Cliente cliente = (Cliente) getClienteSelecionado();
        clienteLocacao.setText(cliente.getNome());
        jTabbedPane1.setSelectedComponent(jPanel5);
        ativarLocacao();;
    }//GEN-LAST:event_realizarLocacaoActionPerformed

    private void ativarLocacao(){
        locarCarro.setEnabled(true);
        locarMoto.setEnabled(true);
        boxPlanos.setEnabled(true);
        boxVeiculos.setEnabled(true);
        dataDevolucaoLocacao.setEnabled(true);
        boxSeguro.setEnabled(true);
        jLabel51.setEnabled(true);
        jLabel78.setEnabled(true);
        jLabel54.setEnabled(true);
        jLabel69.setEnabled(true);
        jLabel59.setEnabled(true);
        jLabel53.setEnabled(true);
        limparCamposLocacao.setEnabled(true);
        locar.setEnabled(true);
    }

    private void desativarLocacao(){
        locarCarro.setEnabled(false);
        locarMoto.setEnabled(false);
        boxPlanos.setEnabled(false);
        boxVeiculos.setEnabled(false);
        dataDevolucaoLocacao.setEnabled(false);
        boxSeguro.setEnabled(false);
        jLabel51.setEnabled(false);
        jLabel78.setEnabled(false);
        jLabel54.setEnabled(false);
        jLabel69.setEnabled(false);
        jLabel59.setEnabled(false);
        jLabel53.setEnabled(false);
        limparCamposLocacao.setEnabled(false);
        locar.setEnabled(false);
    }

    private void realizarPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_realizarPagamentoActionPerformed
        Cliente pessoa = (Cliente) dadosAgencia.getClientes().toArray()[jListaClientes.getSelectedIndex()];
        pessoa.setEmDebito(false);
        pessoa.setDivida(0);
        JOptionPane.showMessageDialog(rootPane, "A divida do cliente " + pessoa.getNome() + " foi quitada com sucesso!");
    }//GEN-LAST:event_realizarPagamentoActionPerformed

    private void limparCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparCamposActionPerformed
        if (limparCampos.getText().equals("Limpar Campos")) {
            nome.setText("");
            cpf.setText("");
            rg.setText("");
            nascimento.setText("");
            naturalidade.setText("");
            cidade.setText("");
            bairro.setText("");
            numero.setText("");
            rua.setText("");
            email.setText("");
            telefone.setText("");
            cep.setText("");
        } else {
            limparCampos.setText("Limpar Campos");
            jButton1.setText("Cadastrar");
            limparCampos.doClick();
            desativarCadastro();
            JOptionPane.showMessageDialog(rootPane, "A operacao de edicao foi cancelada.");
        }
    }//GEN-LAST:event_limparCamposActionPerformed

    private void apagarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apagarFuncionarioActionPerformed
        int z = JOptionPane.showOptionDialog(rootPane, "Confirmar exclusão de funcionario?", "Confirmarção", JOptionPane.YES_NO_OPTION, 0, null, opcoes, opcoes[1]);
        if (z == 0) {
            dadosAgencia.removeFuncionario(jListaFuncionario.getSelectedIndex());
            atualizarFilial(dadosAgencia);
            atualizarListaDeFuncionarios();
        }
    }//GEN-LAST:event_apagarFuncionarioActionPerformed

    private void limparCampos3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparCampos3ActionPerformed
       if (limparCampos3.getText().equals("Limpar Campos")) {
            nome2.setText("");
            cpf1.setText("");
            rg1.setText("");
            nascimento1.setText("");
            naturalidade1.setText("");
            cidade2.setText("");
            bairro4.setText("");
            numero2.setText("");
            rua2.setText("");
            email2.setText("");
            telefone2.setText("");
            cep2.setText("");
        } else {
            limparCampos3.setText("Limpar Campos");
            cadastrarFuncionario.setText("Cadastrar");
            limparCampos3.doClick();
            desativarCadastroFuncionarios();
            JOptionPane.showMessageDialog(rootPane, "A operacao de edicao foi cancelada.");
        }
    }//GEN-LAST:event_limparCampos3ActionPerformed

    private void editarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarFuncionarioActionPerformed
        Pessoa funcionario = getFuncionarioSelecionado();
        nome2.setText(funcionario.getNome());
        cpf1.setText(funcionario.getCpf());
        rg1.setText(funcionario.getRg());
        nascimento1.setText(funcionario.getNascimento());
        naturalidade1.setText(funcionario.getNaturalidade());
        cidade2.setText(funcionario.getEndereco().getCidade());
        bairro4.setText(funcionario.getEndereco().getBairro());
        numero2.setText(Integer.toString(funcionario.getEndereco().getNumero()));
        rua2.setText(funcionario.getEndereco().getRua());
        email2.setText(funcionario.getEmail());
        telefone2.setText(funcionario.getTelefone());
        cep2.setText(funcionario.getEndereco().getCep());
        estado2.setSelectedItem(funcionario.getEndereco().getEstado().toString());
        cadastrarFuncionario.setText("Atualizar");
        limparCampos3.setText("Cancelar");
        ativarCadastroFuncionarios();

    }//GEN-LAST:event_editarFuncionarioActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ativarCadastroFuncionarios();
        jComboTipoFuncionario.setEnabled(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void limparCamposMotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparCamposMotoActionPerformed
       if (limparCamposMoto.getText().equals("Limpar Campos")) {
            renavamMoto.setText("");
            modeloMoto.setText("");
            marcaMoto.setText("");
            potenciaMoto.setText("");
            dataAquisicaoMoto.setText("");
            cilindradasMoto.setText("");
            anoMoto.setText("");
            jSpinnerCombustivelMoto.setValue(0);
        } else {
            limparCamposMoto.setText("Limpar Campos");
            cadastrarMoto.setText("Cadastrar");
            limparCamposMoto.doClick();
            desativarCadastroVeiculo();
            JOptionPane.showMessageDialog(rootPane, "A operacao de edicao foi cancelada.");
        }
    }//GEN-LAST:event_limparCamposMotoActionPerformed

    private void limparCampos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparCampos1ActionPerformed
        if (limparCampos1.getText().equals("Limpar Campos")) {
            nome1.setText("");
            cnpj.setText("");
            rzSocial.setText("");
            inscEstadual.setText("");
            cidade1.setText("");
            bairro1.setText("");
            numero1.setText("");
            rua1.setText("");
            email1.setText("");
            telefone1.setText("");
            cep1.setText("");
        } else {
            limparCampos1.setText("Limpar Campos");
            jButton8.setText("Cadastrar");
            limparCampos1.doClick();
            desativarCadastro();
            JOptionPane.showMessageDialog(rootPane, "A operacao de edicao foi cancelada.");
        }
    }//GEN-LAST:event_limparCampos1ActionPerformed

    private void editarVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarVeiculoActionPerformed
        Veiculo veiculo = getVeiculoSelecionado();
        if (veiculo instanceof Automovel) {
            Automovel auto = (Automovel) veiculo;
            ArrayList<Acessorio> listaAcessorios = auto.getOpcionais();
            if (listaAcessorios.contains(Acessorio.QP)) {
                quatroPortas.setSelected(true);
            }
            if (listaAcessorios.contains(Acessorio.AC)) {
                arCondicionado.setSelected(true);
            }
            if (listaAcessorios.contains(Acessorio.VE)) {
                vidroEletrico.setSelected(true);
            }
            if (listaAcessorios.contains(Acessorio.TE)) {
                travaEletrica.setSelected(true);
            }
            if (listaAcessorios.contains(Acessorio.GPS)) {
                gps.setSelected(true);
            }
            if (listaAcessorios.contains(Acessorio.DH)) {
                direcaoHidraulica.setSelected(true);
            }
            if (listaAcessorios.contains(Acessorio.BC)) {
                bancoDeCouro.setSelected(true);
            }
            if (listaAcessorios.contains(Acessorio.AB)) {
                airBag.setSelected(true);
            }
            corCarro.setSelectedItem(auto.getCor().toString());
            freioCarro.setSelectedItem(auto.getTipoDeFreios().toString());
            tipoPotenciaCarro.setSelectedItem(auto.getTipoDePotencia().toString());
            combustivelCarro.setSelectedItem(auto.getTipoDeCombustivel().toString());
            jTabbedPane4.setSelectedComponent(jPanel12);
            nivelCombustivelCarro.setValue(auto.getNivelDoTanque());
            renavamCarro.setText(auto.getRenavam());
            modeloCarro.setText(auto.getModelo());
            marcaCarro.setText(auto.getMarca());
            potenciaCarro.setText("" + auto.getPotencia());
            dataAquisicaoCarro.setText(auto.getDataDeAquisicao());
            anoCarro.setText("" + auto.getAno());
            cadastrarCarro.setText("Atualizar");
            limparCamposCarro.setText("Cancelar");
        } else {
            Motocicleta moto = (Motocicleta) veiculo;
            jTabbedPane4.setSelectedComponent(jPanel13);
            jSpinnerCombustivelMoto.setValue(moto.getNivelDoTanque());
            renavamMoto.setText(moto.getRenavam());
            modeloMoto.setText(moto.getModelo());
            marcaMoto.setText(moto.getMarca());
            potenciaMoto.setText("" + moto.getPotencia());
            dataAquisicaoMoto.setText(moto.getDataDeAquisicao());
            cilindradasMoto.setText("" + moto.getCilindradas());
            jTipoCorMoto.setSelectedItem(moto.getCor().toString());
            jTipoFreioMoto.setSelectedItem(moto.getTipoDeFreios().toString());
            jTipoPotenciaMoto.setSelectedItem(moto.getTipoDePotencia().toString());
            jTipoCombustivelMoto.setSelectedItem(moto.getTipoDeCombustivel().toString());
            anoMoto.setText("" + moto.getAno());
            cadastrarMoto.setText("Atualizar");
            limparCamposMoto.setText("Cancelar");
        }
        ativarCadastroVeiculo();        // TODO add your handling code here:
    }//GEN-LAST:event_editarVeiculoActionPerformed

    private void estado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estado1ActionPerformed
    }//GEN-LAST:event_estado1ActionPerformed

    private void limparCamposCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparCamposCarroActionPerformed
        if (limparCamposCarro.getText().equals("Limpar Campos")) {
            renavamCarro.setText("");
            modeloCarro.setText("");
            marcaCarro.setText("");
            potenciaCarro.setText("");
            dataAquisicaoCarro.setText("");
            anoCarro.setText("");
            nivelCombustivelCarro.setValue(0);
            quatroPortas.setSelected(false);
            arCondicionado.setSelected(false);
            vidroEletrico.setSelected(false);
            travaEletrica.setSelected(false);
            gps.setSelected(false);
            direcaoHidraulica.setSelected(false);
            bancoDeCouro.setSelected(false);
            airBag.setSelected(false);
        } else {
            limparCamposCarro.setText("Limpar Campos");
            cadastrarCarro.setText("Cadastrar");
            limparCamposCarro.doClick();
            desativarCadastroVeiculo();
            JOptionPane.showMessageDialog(rootPane, "A operacao de edicao foi cancelada.");
        }
    }//GEN-LAST:event_limparCamposCarroActionPerformed

    private void apagarVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apagarVeiculoActionPerformed
        int n = JOptionPane.showOptionDialog(rootPane, "Confirmar exclusão de veiculo?", "Confirmação", JOptionPane.YES_NO_OPTION, 0, null, opcoes, opcoes[1]);
        if (n == 0) {
            dadosAgencia.removeVeiculos(jListaVeiculos.getSelectedIndex());
            atualizarFilial(dadosAgencia);
            atualizarListaDeVeiculos();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_apagarVeiculoActionPerformed

    private void atualizarAgenciaGerenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarAgenciaGerenteActionPerformed
        String cnpj = cnpjAgencia.getText();
        String insEstadual = inscEstadualAgencia.getText();
        String cidade1 = cidadeAgencia.getText();
        String bairro1 = bairroAgencia.getText();
        String numero1 = numeroAgencia.getText();
        String rua1 = ruaAgencia.getText();
        String telefone1 = telefoneAgencia.getText();
        String cep1 = cepAgencia.getText();
        UnidadeFederativa estado1 = UnidadeFederativa.valueOf((String) estadoAgencia.getSelectedItem());

        UnidadeFederativa estado2 = UnidadeFederativa.valueOf((String) estadoGerente.getSelectedItem());
        String nome = nomeGerente.getText();
        String cpf = cpfGerente.getText();
        String nascimento = nascimentoGerente.getText();
        String rg = rgGerente.getText();
        String naturalidade = naturalidadeGerente.getText();
        String email = emailGerente.getText();
        String cidade2 = cidadeGerente.getText();
        String bairro2 = bairroGerente.getText();
        String numero2 = numeroGerente.getText();
        String rua2 = ruaGerente.getText();
        String telefone2 = telefoneGerente.getText();
        String cep2 = cepGerente.getText();

        try {
            int numeroA = Integer.parseInt(numero1);
            int numeroG = Integer.parseInt(numero2);
            Endereco enderecoAgencia = new Endereco(estado1, cidade1, bairro1, rua1, numeroA, cep1);
            Endereco enderecoGerente = new Endereco(estado2, cidade2, bairro2, rua2, numeroG, cep2);
            dadosAgencia.setTelefone(telefone1);
            dadosAgencia.setCnpj(cnpj);
            dadosAgencia.setInscEstadual(insEstadual);
            dadosAgencia.setEndereco(enderecoAgencia);
            dadosAgencia.getGerente().setCpf(cpf);
            dadosAgencia.getGerente().setEmail(email);
            dadosAgencia.getGerente().setEndereco(enderecoGerente);
            dadosAgencia.getGerente().setNascimento(nascimento);
            dadosAgencia.getGerente().setNaturalidade(naturalidade);
            dadosAgencia.getGerente().setNome(nome);
            dadosAgencia.getGerente().setRg(rg);
            dadosAgencia.getGerente().setTelefone(telefone2);
            atualizarFilial(dadosAgencia);
            JOptionPane.showMessageDialog(rootPane, "Agencia atualizada com sucesso!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "Digitar apenas numeros nos campos de numero");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(),"Erro",2);
        }
}//GEN-LAST:event_atualizarAgenciaGerenteActionPerformed

    private void efetuarDevolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_efetuarDevolucaoActionPerformed
        int n = JOptionPane.showOptionDialog(rootPane, "Registrar problemas com o veiculo?", "Devolução", JOptionPane.YES_NO_OPTION, 3, null, opcoes, opcoes[1]);
        if (n == 0){
            ativarProblemas();
            JOptionPane.showMessageDialog(rootPane, "Selecione os problemas abaixo e em seguida clique em confirmar para completar a devolução.");
        }else{
            Locacao l = ((ArrayList<Locacao>)dadosAgencia.getLocacao()).get(jList4.getSelectedIndex());
            try{
                Devolucao d = new Devolucao(l, l.getNivelInicialTanque(), l.getDataDevolucao(), null);
                ((Veiculo)l.getVeiculo()).setLocado(false);
                ((ArrayList<Locacao>)dadosAgencia.getLocacao()).remove(l);
                JOptionPane.showMessageDialog(rootPane, "Devolução efetuada com sucesso!");
                atualizarFilial(dadosAgencia);
                atualizarListaDeVeiculos();
                atualizarListaDeLocacoes();
            }catch(Exception e){
                JOptionPane.showMessageDialog(rootPane, e);
            }
        }

    }//GEN-LAST:event_efetuarDevolucaoActionPerformed

    private void atualizarBoxPlanos(){
        String[] lista = null;
        int i = 0;
        int planosCarro = 0;
        int planosMoto = 0;
        for (Plano p : dadosAgencia.getPlano())
            if(p instanceof PlanoAutomovel)
                planosCarro++;
            else
                planosMoto++;
        if (locarCarro.isSelected()) {
            lista = new String[planosCarro];
            for (Plano p : dadosAgencia.getPlano())
                if(p instanceof PlanoAutomovel)
                    lista[i++] = p.getNome();
        } else if (locarMoto.isSelected()) {
            lista = new String[planosMoto];
            for (Plano p : dadosAgencia.getPlano())
                if(p instanceof PlanoMoto)
                    lista[i++] = p.getNome();
        }
        DefaultComboBoxModel model = new DefaultComboBoxModel(lista);
        boxPlanos.setModel(model);
    }

    private ArrayList<Veiculo> atualizarListaVeiculosDisponiveisParaPlanoLocacao(Plano p){
        ArrayList<Veiculo> listaDeVeiculos = new ArrayList<Veiculo>();
        if (p instanceof PlanoMoto){
            for(Veiculo v : dadosAgencia.getVeiculos())
                if(v instanceof Motocicleta){
                    Motocicleta moto = (Motocicleta) v;
                    if(moto.getCilindradas() == ((PlanoMoto)p).getCilindradas() && !(moto.getLocado()))
                        listaDeVeiculos.add(moto);
                }
        }else{
            for(Veiculo v :dadosAgencia.getVeiculos())
                if(v instanceof Automovel){
                    Automovel auto = (Automovel)v;
                    if(auto.getOpcionais().equals(((PlanoAutomovel)p).getAcessorios()) || (auto.getOpcionais().isEmpty() && ((PlanoAutomovel) p).getAcessorios().isEmpty()))
                        if(!(v.getLocado()))
                            listaDeVeiculos.add(auto);
                }
        }
        return listaDeVeiculos;
    }
    private void atualizarBoxVeiculos(){
        ArrayList<PlanoAutomovel> planosAutomovel= new ArrayList<PlanoAutomovel>();
        ArrayList<PlanoMoto> planosMoto = new ArrayList<PlanoMoto>();
        String[] lista = null;
        for (Plano p : dadosAgencia.getPlano()){
            if(p instanceof PlanoAutomovel)
                planosAutomovel.add((PlanoAutomovel)p);
            else
                planosMoto.add((PlanoMoto)p);
        }
        int i = 0;
        if (locarCarro.isSelected()) {
            Plano planoSelecionado = planosAutomovel.get(boxPlanos.getSelectedIndex());
            lista = new String[atualizarListaVeiculosDisponiveisParaPlanoLocacao(planoSelecionado).size()];
            for (Veiculo v : atualizarListaVeiculosDisponiveisParaPlanoLocacao(planoSelecionado))
                lista[i++] = v.getMarca() + " - " + v.getModelo();
        } else if (locarMoto.isSelected()) {
            Plano planoSelecionado = planosMoto.get(boxPlanos.getSelectedIndex());
            lista = new String[atualizarListaVeiculosDisponiveisParaPlanoLocacao(planoSelecionado).size()];
            for (Veiculo v : atualizarListaVeiculosDisponiveisParaPlanoLocacao(planoSelecionado))
                lista[i++] = v.getMarca() + " - " + v.getModelo();
        }
        DefaultComboBoxModel model = new DefaultComboBoxModel(lista);
        boxVeiculos.setModel(model);
    }
    private void limparCamposLocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparCamposLocacaoActionPerformed
        String[] list = new String[1];
        DefaultComboBoxModel model = new DefaultComboBoxModel(list);
        clienteLocacao.setText("");
        buttonGroup1.clearSelection();
        locarCarro.setSelected(false);
        locarMoto.setSelected(false);
        boxPlanos.setModel(model);
        boxVeiculos.setModel(model);
        dataDevolucaoLocacao.setText("");
        boxSeguro.setSelectedItem(null);
        desativarLocacao();
    }//GEN-LAST:event_limparCamposLocacaoActionPerformed

    private void limparCamposPlanoCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparCamposPlanoCarroActionPerformed
        if (limparCamposPlanoCarro.getText().equals("Limpar Campos")) {
            nomePlanoCarro.setText("");
            precoPlanoCarro.setText("");
            quatroPortasPlanoCarro.setSelected(false);
            arCondicionadoPlanoCarro.setSelected(false);
            vidroEletricoPlanoCarro.setSelected(false);
            travaEletricaPlanoCarro.setSelected(false);
            GPSPlanoCarro.setSelected(false);
            direcaoHidraulicaPlanoCarro.setSelected(false);
            bancosCouraPlanoCarro.setSelected(false);
            airBagPlanoCarro.setSelected(false);
        } else {
            limparCamposPlanoCarro.setText("Limpar Campos");
            cadastrarPlanoCarro.setText("Cadastrar");
            limparCamposPlanoCarro.doClick();
            desativarCadastroPlanos();
            JOptionPane.showMessageDialog(rootPane, "A operacao de edicao foi cancelada.");
        }
    }//GEN-LAST:event_limparCamposPlanoCarroActionPerformed

        private void limparCamposPlanoMotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparCamposPlanoMotoActionPerformed
        if (limparCamposPlanoMoto.getText().equals("Limpar Campos")) {
            nomePlanoMoto.setText("");
            precoPlanoMoto.setText("");
            cilindradasPlanoMoto.setText("");

        } else {
            limparCamposPlanoMoto.setText("Limpar Campos");
            cadastrarPlanoMoto.setText("Cadastrar");
            limparCamposPlanoMoto.doClick();
            desativarCadastroPlanos();
            JOptionPane.showMessageDialog(rootPane, "A operacao de edicao foi cancelada.");
            }
        }//GEN-LAST:event_limparCamposPlanoMotoActionPerformed

        private void editarPlanoDeLocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarPlanoDeLocacaoActionPerformed
        Plano plano = getPlanoSelecionado();
        if (plano instanceof PlanoAutomovel) {
            PlanoAutomovel plano1 = (PlanoAutomovel) plano;
            List<Acessorio> listaAcessorios = plano1.getAcessorios();
            if (listaAcessorios.contains(Acessorio.QP)) {
                quatroPortasPlanoCarro.setSelected(true);
            }
            if (listaAcessorios.contains(Acessorio.AC)) {
                arCondicionadoPlanoCarro.setSelected(true);
            }
            if (listaAcessorios.contains(Acessorio.VE)) {
                vidroEletricoPlanoCarro.setSelected(true);
            }
            if (listaAcessorios.contains(Acessorio.TE)) {
                travaEletricaPlanoCarro.setSelected(true);
            }
            if (listaAcessorios.contains(Acessorio.GPS)) {
                GPSPlanoCarro.setSelected(true);
            }
            if (listaAcessorios.contains(Acessorio.DH)) {
                direcaoHidraulicaPlanoCarro.setSelected(true);
            }
            if (listaAcessorios.contains(Acessorio.BC)) {
                bancosCouraPlanoCarro.setSelected(true);
            }
            if (listaAcessorios.contains(Acessorio.AB)) {
                airBagPlanoCarro.setSelected(true);
            }
            jTabbedPane6.setSelectedComponent(jPanel17);
            nomePlanoCarro.setText(plano1.getNome());
            precoPlanoCarro.setText(""+plano1.getPreco());
            cadastrarPlanoCarro.setText("Atualizar");
            limparCamposPlanoCarro.setText("Cancelar");
        } else {
            PlanoMoto plano1 = (PlanoMoto) plano;
            jTabbedPane6.setSelectedComponent(jPanel18);
            nomePlanoMoto.setText(plano1.getNome());
            precoPlanoMoto.setText(""+plano1.getPreco());
            cilindradasPlanoMoto.setText(""+plano1.getCilindradas());
            cadastrarPlanoMoto.setText("Atualizar");
            limparCamposPlanoMoto.setText("Cancelar");
        }
        ativarCadastroPlanos();        // TODO add your handling code here:
        }//GEN-LAST:event_editarPlanoDeLocacaoActionPerformed

        private void apagarPlanoDeLocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apagarPlanoDeLocacaoActionPerformed
        int z = JOptionPane.showOptionDialog(rootPane, "Confirmar exclusão de Plano?", "Confirmarção", JOptionPane.YES_NO_OPTION, 0, null, opcoes, opcoes[1]);
        if (z == 0) {
            dadosAgencia.removePlano(jListaFuncionario.getSelectedIndex());
            atualizarFilial(dadosAgencia);
            atualizarListaDePlanos();
        }
        }//GEN-LAST:event_apagarPlanoDeLocacaoActionPerformed

        private void apagarLocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apagarLocacaoActionPerformed
            int n = JOptionPane.showOptionDialog(rootPane, "Confirmar exclusão da locação?", "Confirmarção", JOptionPane.YES_NO_OPTION, 0, null, opcoes, opcoes[1]);
            if (n == 0) {
               ((ArrayList<Locacao>)dadosAgencia.getLocacao()).get(jList4.getSelectedIndex()).getVeiculo().setLocado(false);
                atualizarListaDeVeiculos();
                dadosAgencia.getLocacao().remove(((ArrayList<Locacao>)dadosAgencia.getLocacao()).get(jList4.getSelectedIndex()));
                atualizarListaDeLocacoes();
                atualizarFilial(dadosAgencia);
            }
        }//GEN-LAST:event_apagarLocacaoActionPerformed

        private void confirmarProblemasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarProblemasActionPerformed
            Devolucao d = null;
            ArrayList<Problema> listaDeProblemas = new ArrayList<Problema>();
            if(perdaTotalOuRoubo.isSelected())
                listaDeProblemas.add(Problema.PERDA_TOTAL);
            else{
                if(arranhoes.isSelected())
                    listaDeProblemas.add(Problema.ARRANHÕES);
                if(amassadosGraves.isSelected())
                    listaDeProblemas.add(Problema.AMASSADOS_GRAVES);
                if(amassadosLeves.isSelected())
                    listaDeProblemas.add(Problema.AMASSADOS_LEVES);
            }
            if(atraso.isSelected() && dataAtraso.getText().replace(" ", "").length()<5){
                JOptionPane.showMessageDialog(rootPane, "Se voce selecionou atraso, deve informar a data de entrega.","Aviso", 2);
            }else{
                int nivelTanque = ((Integer) nivelTanqueNovo.getValue()).intValue();
                String dataEntrega = dataAtraso.getText();
                try{
                    Locacao l = (Locacao)((ArrayList)dadosAgencia.getLocacao()).get(jList4.getSelectedIndex());
                    if(atraso.isSelected() && tanqueErrado.isSelected())
                        d = new Devolucao(l, nivelTanque, dataEntrega, listaDeProblemas);
                    else if(atraso.isSelected() && !(tanqueErrado.isSelected()))
                        d = new Devolucao(l, l.getNivelInicialTanque(), dataEntrega, listaDeProblemas);
                    else if(!(atraso.isSelected()) && tanqueErrado.isSelected())
                        d = new Devolucao(l, nivelTanque, l.getDataDevolucao(), listaDeProblemas);
                    else if(!(atraso.isSelected()) && !(tanqueErrado.isSelected()))
                        d = new Devolucao(l, l.getNivelInicialTanque(), l.getDataDevolucao(), listaDeProblemas);

                    ((Veiculo)l.getVeiculo()).setLocado(false);
                    ((ArrayList<Locacao>)dadosAgencia.getLocacao()).remove(l);
                    JOptionPane.showMessageDialog(rootPane, "Devolução efetuada com sucesso!");
                    JOptionPane.showMessageDialog(rootPane, "O cliente "+l.getCliente().getNome()+" agora está com uma divida de R$:"+l.getCliente().getDivida());
                    limparProblemas();
                    desativarProblemas();
                    atualizarFilial(dadosAgencia);
                    atualizarListaDeVeiculos();
                    atualizarListaDeLocacoes();
                }catch(Exception e){
                    JOptionPane.showMessageDialog(rootPane, e.getMessage(),"Erro",2);
                }
            }
        }//GEN-LAST:event_confirmarProblemasActionPerformed

        private void jMenu1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MousePressed
            new telaSobre().setVisible(true);
        }//GEN-LAST:event_jMenu1MousePressed

        private void jMenuSairMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuSairMousePressed
            System.exit(0);
        }//GEN-LAST:event_jMenuSairMousePressed

        private void locarCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locarCarroActionPerformed
            atualizarBoxPlanos();
            atualizarBoxVeiculos();
        }//GEN-LAST:event_locarCarroActionPerformed

        private void locarMotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locarMotoActionPerformed
            atualizarBoxPlanos();
            atualizarBoxVeiculos();
        }//GEN-LAST:event_locarMotoActionPerformed

        private void boxPlanosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_boxPlanosItemStateChanged
            atualizarBoxVeiculos();
        }//GEN-LAST:event_boxPlanosItemStateChanged
        
    private void setarMascaras() {
        try {
            buttonGroup1.add(locarCarro);
            buttonGroup1.add(locarMoto);

            MaskFormatter mascaraCPF = new MaskFormatter("###.###.###-##");
            MaskFormatter mascaraData = new MaskFormatter("##/##/####");
            MaskFormatter mascaraTelefone = new MaskFormatter("(##)####-####");
            MaskFormatter mascaraCep = new MaskFormatter("#####-###");
            MaskFormatter mascaraCnpj = new MaskFormatter("##.###.###/####-##");
            MaskFormatter mascaraAno = new MaskFormatter("####");
            mascaraAno.setValidCharacters("0123456789");
            mascaraData.setValidCharacters("0123456789");
            mascaraCPF.setValidCharacters("0123456789");
            mascaraTelefone.setValidCharacters("0123456789");
            mascaraCep.setValidCharacters("0123456789");
            mascaraCnpj.setValidCharacters("0123456789");
            DefaultFormatterFactory anoFormatter = new DefaultFormatterFactory(mascaraAno, mascaraAno);
            DefaultFormatterFactory cpfFormatter = new DefaultFormatterFactory(mascaraCPF, mascaraCPF);
            DefaultFormatterFactory dataFormatter = new DefaultFormatterFactory(mascaraData, mascaraData);
            DefaultFormatterFactory telefoneFormatter = new DefaultFormatterFactory(mascaraTelefone, mascaraTelefone);
            DefaultFormatterFactory cepFormatter = new DefaultFormatterFactory(mascaraCep, mascaraCep);
            DefaultFormatterFactory cnpjFormatter = new DefaultFormatterFactory(mascaraCnpj, mascaraCnpj);
            anoMoto.setFormatterFactory(anoFormatter);
            anoCarro.setFormatterFactory(anoFormatter);
            dataAtraso.setFormatterFactory(dataFormatter);
            dataAquisicaoMoto.setFormatterFactory(dataFormatter);
            dataAquisicaoCarro.setFormatterFactory(dataFormatter);
            dataDevolucaoLocacao.setFormatterFactory(dataFormatter);
            cpf.setFormatterFactory(cpfFormatter);
            cpfGerente.setFormatterFactory(cpfFormatter);
            cnpj.setFormatterFactory(cpfFormatter);
            nascimento.setFormatterFactory(dataFormatter);
            nascimentoGerente.setFormatterFactory(dataFormatter);
            telefone.setFormatterFactory(telefoneFormatter);
            telefone1.setFormatterFactory(telefoneFormatter);
            telefoneGerente.setFormatterFactory(telefoneFormatter);
            cep.setFormatterFactory(cepFormatter);
            cep1.setFormatterFactory(cepFormatter);
            cepGerente.setFormatterFactory(cepFormatter);
            cepAgencia.setFormatterFactory(cepFormatter);
            cnpj.setFormatterFactory(cnpjFormatter);
            cnpjAgencia.setFormatterFactory(cnpjFormatter);
            telefoneAgencia.setFormatterFactory(telefoneFormatter);
            //campos funcionario
            cpf1.setFormatterFactory(cpfFormatter);
            nascimento1.setFormatterFactory(dataFormatter);
            telefone2.setFormatterFactory(telefoneFormatter);
            cep2.setFormatterFactory(cepFormatter);
            dataDevolucaoLocacao.setFormatterFactory(dataFormatter);
        } catch (Exception e) {
        }
    }

    public void atualizarFilial(Filial dadosAgencia) {
        try {
            arquivoInfosWrite = new FileOutputStream("./infosAgencia.dat");
            objInfosWrite = new ObjectOutputStream(arquivoInfosWrite);
            objInfosWrite.writeObject(dadosAgencia);
            objInfosWrite.flush();
            objInfosWrite.close();
            arquivoInfosWrite.close();
        } catch (Exception ex) {
            System.out.println("Nao foi possivel atualizar os dados das agencias.");
        }
    }

    public void setWindowPos() {
        Dimension dimension = this.getToolkit().getScreenSize();
        int x = (int) (dimension.getWidth() - this.getSize().getWidth()) / 2;
        int y = (int) (dimension.getHeight() - this.getSize().getHeight()) / 2;
        this.setLocation(x, y);
        URL url = this.getClass().getResource("/images/icon2.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
    }

    public void procedimentoDeBotoes() {
        if (jListaClientes.getSelectedValue() == null) {
            editarCliente.setEnabled(false);
            apagarCliente.setEnabled(false);
            verificarDebito.setEnabled(false);
            realizarPagamento.setEnabled(false);
            realizarLocacao.setEnabled(false);
        } else {
            editarCliente.setEnabled(true);
            apagarCliente.setEnabled(true);
            verificarDebito.setEnabled(true);
            realizarPagamento.setEnabled(true);
            realizarLocacao.setEnabled(true);
        }
        if (jListaPlanos.getSelectedValue() == null) {
            editarPlanoDeLocacao.setEnabled(false);
            apagarPlanoDeLocacao.setEnabled(false);
        } else {
            editarPlanoDeLocacao.setEnabled(true);
            apagarPlanoDeLocacao.setEnabled(true);
        }
        if (jListaFuncionario.getSelectedValue() == null) {
            editarFuncionario.setEnabled(false);
            apagarFuncionario.setEnabled(false);
        } else {
            editarFuncionario.setEnabled(true);
            apagarFuncionario.setEnabled(true);
        }

        if (jListaVeiculos.getSelectedValue() == null) {
            editarVeiculo.setEnabled(false);
            apagarVeiculo.setEnabled(false);
        } else {
            editarVeiculo.setEnabled(true);
            apagarVeiculo.setEnabled(true);
        }

        if (!(locarCarro.isSelected()) && !(locarMoto.isSelected())) {
            boxPlanos.setEnabled(false);
        } else {
            boxPlanos.setEnabled(true);
        }

        if (boxPlanos.getSelectedItem() == null) {
            boxVeiculos.setEnabled(false);
        } else {
            boxVeiculos.setEnabled(true);
        }

        if(jList4.getSelectedValue() == null){
            efetuarDevolucao.setEnabled(false);
            apagarLocacao.setEnabled(false);
        } else {
           efetuarDevolucao.setEnabled(true);
           apagarLocacao.setEnabled(true);
            }
        if(atraso.isSelected())
            dataAtraso.setEnabled(true);
        else
            dataAtraso.setEnabled(false);
        if(tanqueErrado.isSelected())
            nivelTanqueNovo.setEnabled(true);
        else
            nivelTanqueNovo.setEnabled(false);
    }

    public void setTimer() {
        ActionListener action = new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                procedimentoDeBotoes();
            }
        };
        this.timer = new Timer(500, action);
        this.timer.start();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    UIManager.setLookAndFeel(new SubstanceNebulaLookAndFeel());
                } catch (Exception e) {
                    System.out.println("Falha ao carregar a skin!");
                }
                new MenuInicial(dadosAgencia).setVisible(true);

            }
        });
    }

    private void desativarProblemas(){
        confirmarProblemas.setEnabled(false);
        jPanel7.setEnabled(false);
        jLabel95.setEnabled(false);
        jLabel118.setEnabled(false);
        jLabel119.setEnabled(false);
        jLabel111.setEnabled(false);
        arranhoes.setEnabled(false);
        amassadosGraves.setEnabled(false);
        amassadosLeves.setEnabled(false);
        perdaTotalOuRoubo.setEnabled(false);
        tanqueErrado.setEnabled(false);
        nivelTanqueNovo.setEnabled(false);
        dataAtraso.setEnabled(false);
        atraso.setEnabled(false);
    }

    private void ativarProblemas(){
        confirmarProblemas.setEnabled(true);
        jPanel7.setEnabled(true);
        jLabel95.setEnabled(true);
        jLabel118.setEnabled(true);
        jLabel119.setEnabled(true);
        jLabel111.setEnabled(true);
        arranhoes.setEnabled(true);
        amassadosGraves.setEnabled(true);
        amassadosLeves.setEnabled(true);
        perdaTotalOuRoubo.setEnabled(true);
        tanqueErrado.setEnabled(true);
        nivelTanqueNovo.setEnabled(true);
        dataAtraso.setEnabled(true);
        atraso.setEnabled(true);
    }

    private void limparProblemas(){
        arranhoes.setSelected(false);
        amassadosGraves.setSelected(false);
        amassadosLeves.setSelected(false);
        perdaTotalOuRoubo.setSelected(false);
        tanqueErrado.setSelected(false);
        atraso.setSelected(false);
        nivelTanqueNovo.setValue(0);
        dataAtraso.setText("");
    }

    private void ativarCadastroPlanos() {
        cadastrarPlanoCarro.setEnabled(true);
        cadastrarPlanoMoto.setEnabled(true);
        precoPlanoCarro.setEnabled(true);
        nomePlanoCarro.setEnabled(true);
        jLabel115.setEnabled(true);
        jLabel114.setEnabled(true);
        limparCamposPlanoCarro.setEnabled(true);
        jLabel47.setEnabled(true);
        bancosCouraPlanoCarro.setEnabled(true);
        vidroEletricoPlanoCarro.setEnabled(true);
        quatroPortasPlanoCarro.setEnabled(true);
        travaEletricaPlanoCarro.setEnabled(true);
        jTabbedPane6.setEnabled(true);
        GPSPlanoCarro.setEnabled(true);
        airBagPlanoCarro.setEnabled(true);
        jPanel17.setEnabled(true);
        jPanel18.setEnabled(true);
        arCondicionadoPlanoCarro.setEnabled(true);
        direcaoHidraulicaPlanoCarro.setEnabled(true);
        jLabel48.setEnabled(true);
        nomePlanoMoto.setEnabled(true);
        jLabel116.setEnabled(true);
        jTabbedPane6.setEnabled(true);
        cilindradasPlanoMoto.setEnabled(true);
        precoPlanoMoto.setEnabled(true);
        jLabel117.setEnabled(true);
        cadastrarPlanoCarro.setEnabled(true);
        limparCamposPlanoMoto.setEnabled(true);

    }

    private void ativarCadastroFuncionarios() {
        estado2.setEnabled(true);
        jLabel31.setEnabled(true);
        jLabel32.setEnabled(true);
        jLabel33.setEnabled(true);
        jLabel34.setEnabled(true);
        jLabel35.setEnabled(true);
        jLabel36.setEnabled(true);
        jLabel37.setEnabled(true);
        jLabel38.setEnabled(true);
        jLabel39.setEnabled(true);
        jLabel40.setEnabled(true);
        jLabel41.setEnabled(true);
        jLabel42.setEnabled(true);
        jLabel43.setEnabled(true);
        jLabel44.setEnabled(true);
        nome2.setEnabled(true);
        cpf1.setEnabled(true);
        rg1.setEnabled(true);
        nascimento1.setEnabled(true);
        naturalidade1.setEnabled(true);
        cidade2.setEnabled(true);
        bairro4.setEnabled(true);
        numero2.setEnabled(true);
        rua2.setEnabled(true);
        email2.setEnabled(true);
        telefone2.setEnabled(true);
        cep2.setEnabled(true);
        jComboTipoFuncionario.setEnabled(false);
        jPanel10.setEnabled(true);
        cadastrarFuncionario.setEnabled(true);
        limparCampos3.setEnabled(true);
    }

    private void ativarCadastroVeiculo() {
        jTabbedPane4.setEnabled(true);
        jPanel12.setEnabled(true);
        jPanel13.setEnabled(true);
        jLabel83.setEnabled(true);
        jLabel79.setEnabled(true);

        jLabel80.setEnabled(true);
        jLabel73.setEnabled(true);
        jLabel76.setEnabled(true);
        jLabel75.setEnabled(true);
        jLabel84.setEnabled(true);
        jLabel74.setEnabled(true);
        jLabel77.setEnabled(true);
        jLabel81.setEnabled(true);
        jLabel139.setEnabled(true);
        jLabel82.setEnabled(true);
        marcaMoto.setEnabled(true);
        renavamMoto.setEnabled(true);
        potenciaMoto.setEnabled(true);
        modeloMoto.setEnabled(true);
        cilindradasMoto.setEnabled(true);
        dataAquisicaoMoto.setEnabled(true);
        jTipoFreioMoto.setEnabled(true);
        jTipoCombustivelMoto.setEnabled(true);
        anoMoto.setEnabled(true);
        jTipoCorMoto.setEnabled(true);
        jTipoPotenciaMoto.setEnabled(true);

        jSpinnerCombustivelMoto.setEnabled(true);
        cadastrarMoto.setEnabled(true);
        cadastrarCarro.setEnabled(true);
        jLabel68.setEnabled(true);
        jLabel70.setEnabled(true);
        jLabel66.setEnabled(true);
        jLabel62.setEnabled(true);

        jLabel64.setEnabled(true);
        jLabel65.setEnabled(true);
        jLabel72.setEnabled(true);
        jLabel67.setEnabled(true);
        jLabel60.setEnabled(true);
        jLabel71.setEnabled(true);
        jLabel61.setEnabled(true);
        jLabel63.setEnabled(true);
        modeloCarro.setEnabled(true);
        corCarro.setEnabled(true);
        marcaCarro.setEnabled(true);
        dataAquisicaoCarro.setEnabled(true);
        combustivelCarro.setEnabled(true);
        potenciaCarro.setEnabled(true);
        tipoPotenciaCarro.setEnabled(true);
        nivelCombustivelCarro.setEnabled(true);
        renavamCarro.setEnabled(true);
        anoCarro.setEnabled(true);
        freioCarro.setEnabled(true);

        arCondicionado.setEnabled(true);
        cadastrarCarro.setEnabled(true);
        gps.setEnabled(true);
        airBag.setEnabled(true);
        jLabel71.setEnabled(true);
        bancoDeCouro.setEnabled(true);
        quatroPortas.setEnabled(true);
        travaEletrica.setEnabled(true);
        limparCamposMoto.setEnabled(true);
        limparCamposCarro.setEnabled(true);
        vidroEletrico.setEnabled(true);
        direcaoHidraulica.setEnabled(true);
    }

    private void ativarCadastro() {
        jTabbedPane2.setEnabled(true);
        jPanel9.setEnabled(true);
        jPanel8.setEnabled(true);
        jLabel4.setEnabled(true);
        jLabel5.setEnabled(true);
        jLabel6.setEnabled(true);
        jLabel7.setEnabled(true);
        jLabel8.setEnabled(true);
        jLabel9.setEnabled(true);
        jLabel10.setEnabled(true);
        jLabel11.setEnabled(true);
        jLabel12.setEnabled(true);
        jLabel13.setEnabled(true);
        jLabel14.setEnabled(true);
        jLabel15.setEnabled(true);
        jLabel16.setEnabled(true);
        jLabel17.setEnabled(true);
        jLabel18.setEnabled(true);
        jLabel19.setEnabled(true);
        jLabel20.setEnabled(true);
        jLabel21.setEnabled(true);
        jLabel22.setEnabled(true);
        jLabel23.setEnabled(true);
        jLabel24.setEnabled(true);
        jLabel26.setEnabled(true);
        jLabel27.setEnabled(true);
        jLabel28.setEnabled(true);
        jLabel29.setEnabled(true);
        nome.setEnabled(true);
        cpf.setEnabled(true);
        rg.setEnabled(true);
        nascimento.setEnabled(true);
        naturalidade.setEnabled(true);
        cidade.setEnabled(true);
        bairro.setEnabled(true);
        numero.setEnabled(true);
        rua.setEnabled(true);
        email.setEnabled(true);
        telefone.setEnabled(true);
        cep.setEnabled(true);
        estado.setEnabled(true);
        nome1.setEnabled(true);
        cnpj.setEnabled(true);
        rzSocial.setEnabled(true);
        estado1.setEnabled(true);
        inscEstadual.setEnabled(true);
        cidade1.setEnabled(true);
        bairro1.setEnabled(true);
        numero1.setEnabled(true);
        rua1.setEnabled(true);
        email1.setEnabled(true);
        telefone1.setEnabled(true);
        cep1.setEnabled(true);
        limparCampos1.setEnabled(true);
        jButton8.setEnabled(true);
        limparCampos.setEnabled(true);
        jButton1.setEnabled(true);
    }

    private void desativarCadastroPlanos() {
        cadastrarPlanoCarro.setEnabled(false);
        precoPlanoCarro.setEnabled(false);
        nomePlanoCarro.setEnabled(false);
        jLabel115.setEnabled(false);
        jLabel114.setEnabled(false);
        limparCamposPlanoCarro.setEnabled(false);
        jLabel47.setEnabled(false);
        bancosCouraPlanoCarro.setEnabled(false);
        vidroEletricoPlanoCarro.setEnabled(false);
        quatroPortasPlanoCarro.setEnabled(false);
        travaEletricaPlanoCarro.setEnabled(false);
        jTabbedPane6.setEnabled(false);
        GPSPlanoCarro.setEnabled(false);
        airBagPlanoCarro.setEnabled(false);
        jPanel17.setEnabled(false);
        arCondicionadoPlanoCarro.setEnabled(false);
        direcaoHidraulicaPlanoCarro.setEnabled(false);
        jLabel48.setEnabled(false);
        nomePlanoMoto.setEnabled(false);
        jLabel116.setEnabled(false);
        jTabbedPane6.setEnabled(false);
        cilindradasPlanoMoto.setEnabled(false);
        precoPlanoMoto.setEnabled(false);
        jLabel117.setEnabled(false);
        cadastrarPlanoCarro.setEnabled(false);
        limparCamposPlanoMoto.setEnabled(false);

    }

    private void desativarCadastro() {
        jTabbedPane2.setEnabled(false);
        jPanel9.setEnabled(false);
        jPanel8.setEnabled(false);
        jLabel4.setEnabled(false);
        jLabel5.setEnabled(false);
        jLabel6.setEnabled(false);
        jLabel7.setEnabled(false);
        jLabel8.setEnabled(false);
        jLabel9.setEnabled(false);
        jLabel10.setEnabled(false);
        jLabel11.setEnabled(false);
        jLabel12.setEnabled(false);
        jLabel13.setEnabled(false);
        jLabel14.setEnabled(false);
        jLabel15.setEnabled(false);
        jLabel16.setEnabled(false);
        jLabel17.setEnabled(false);
        jLabel18.setEnabled(false);
        jLabel19.setEnabled(false);
        jLabel20.setEnabled(false);
        jLabel21.setEnabled(false);
        jLabel22.setEnabled(false);
        jLabel23.setEnabled(false);
        jLabel24.setEnabled(false);
        jLabel26.setEnabled(false);
        jLabel27.setEnabled(false);
        jLabel28.setEnabled(false);
        jLabel29.setEnabled(false);
        nome.setEnabled(false);
        cpf.setEnabled(false);
        rg.setEnabled(false);
        nascimento.setEnabled(false);
        naturalidade.setEnabled(false);
        cidade.setEnabled(false);
        bairro.setEnabled(false);
        numero.setEnabled(false);
        rua.setEnabled(false);
        email.setEnabled(false);
        telefone.setEnabled(false);
        cep.setEnabled(false);
        estado.setEnabled(false);
        nome1.setEnabled(false);
        cnpj.setEnabled(false);
        rzSocial.setEnabled(false);
        estado1.setEnabled(false);
        inscEstadual.setEnabled(false);
        cidade1.setEnabled(false);
        bairro1.setEnabled(false);
        numero1.setEnabled(false);
        rua1.setEnabled(false);
        email1.setEnabled(false);
        telefone1.setEnabled(false);
        cep1.setEnabled(false);
        limparCampos1.setEnabled(false);
        jButton8.setEnabled(false);
        limparCampos.setEnabled(false);
        jButton1.setEnabled(false);
    }

    private void desativarCadastroFuncionarios() {
        jLabel31.setEnabled(false);
        jLabel32.setEnabled(false);
        jLabel33.setEnabled(false);
        jLabel34.setEnabled(false);
        jLabel35.setEnabled(false);
        jLabel36.setEnabled(false);
        jLabel37.setEnabled(false);
        jLabel38.setEnabled(false);
        jLabel39.setEnabled(false);
        jLabel40.setEnabled(false);
        jLabel41.setEnabled(false);
        jLabel42.setEnabled(false);
        jLabel43.setEnabled(false);
        jLabel44.setEnabled(false);
        nome2.setEnabled(false);
        cpf1.setEnabled(false);
        rg1.setEnabled(false);
        nascimento1.setEnabled(false);
        naturalidade1.setEnabled(false);
        cidade2.setEnabled(false);
        bairro4.setEnabled(false);
        numero2.setEnabled(false);
        rua2.setEnabled(false);
        email2.setEnabled(false);
        telefone2.setEnabled(false);
        cep2.setEnabled(false);
        jComboTipoFuncionario.setEnabled(false);
        jPanel10.setEnabled(false);
        cadastrarFuncionario.setEnabled(false);
        limparCampos3.setEnabled(false);
    }

    private void desativarCadastroVeiculo() {
        jTabbedPane4.setEnabled(false);
        jPanel12.setEnabled(false);
        jPanel13.setEnabled(false);
        jLabel83.setEnabled(false);
        jLabel79.setEnabled(false);

        jLabel80.setEnabled(false);
        jLabel73.setEnabled(false);
        jLabel76.setEnabled(false);
        jLabel75.setEnabled(false);
        jLabel84.setEnabled(false);
        jLabel74.setEnabled(false);
        jLabel77.setEnabled(false);
        jLabel81.setEnabled(false);
        jLabel139.setEnabled(false);
        jLabel82.setEnabled(false);
        marcaMoto.setEnabled(false);
        renavamMoto.setEnabled(false);
        potenciaMoto.setEnabled(false);
        modeloMoto.setEnabled(false);
        cilindradasMoto.setEnabled(false);
        dataAquisicaoMoto.setEnabled(false);
        jTipoFreioMoto.setEnabled(false);
        jTipoCombustivelMoto.setEnabled(false);
        anoMoto.setEnabled(false);
        jTipoCorMoto.setEnabled(false);
        jTipoPotenciaMoto.setEnabled(false);

        jSpinnerCombustivelMoto.setEnabled(false);
        cadastrarMoto.setEnabled(false);
        cadastrarCarro.setEnabled(false);
        jLabel68.setEnabled(false);
        jLabel70.setEnabled(false);
        jLabel66.setEnabled(false);
        jLabel62.setEnabled(false);

        jLabel64.setEnabled(false);
        jLabel65.setEnabled(false);
        jLabel72.setEnabled(false);
        jLabel67.setEnabled(false);
        jLabel60.setEnabled(false);
        jLabel71.setEnabled(false);
        jLabel61.setEnabled(false);
        jLabel63.setEnabled(false);
        modeloCarro.setEnabled(false);
        corCarro.setEnabled(false);
        marcaCarro.setEnabled(false);
        dataAquisicaoCarro.setEnabled(false);
        combustivelCarro.setEnabled(false);
        potenciaCarro.setEnabled(false);
        tipoPotenciaCarro.setEnabled(false);
        nivelCombustivelCarro.setEnabled(false);
        renavamCarro.setEnabled(false);
        anoCarro.setEnabled(false);
        freioCarro.setEnabled(false);

        arCondicionado.setEnabled(false);
        cadastrarCarro.setEnabled(false);
        gps.setEnabled(false);
        airBag.setEnabled(false);
        jLabel71.setEnabled(false);
        bancoDeCouro.setEnabled(false);
        quatroPortas.setEnabled(false);
        travaEletrica.setEnabled(false);
        limparCamposCarro.setEnabled(false);
        vidroEletrico.setEnabled(false);
        direcaoHidraulica.setEnabled(false);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton GPSPlanoCarro;
    private javax.swing.JRadioButton airBag;
    private javax.swing.JRadioButton airBagPlanoCarro;
    private javax.swing.JCheckBox amassadosGraves;
    private javax.swing.JCheckBox amassadosLeves;
    private javax.swing.JFormattedTextField anoCarro;
    private javax.swing.JFormattedTextField anoMoto;
    private javax.swing.JButton apagarCliente;
    private javax.swing.JButton apagarFuncionario;
    private javax.swing.JButton apagarLocacao;
    private javax.swing.JButton apagarPlanoDeLocacao;
    private javax.swing.JButton apagarVeiculo;
    private javax.swing.JRadioButton arCondicionado;
    private javax.swing.JRadioButton arCondicionadoPlanoCarro;
    private javax.swing.JCheckBox arranhoes;
    private javax.swing.JCheckBox atraso;
    private javax.swing.JButton atualizarAgenciaGerente;
    private javax.swing.JTextField bairro;
    private javax.swing.JTextField bairro1;
    private javax.swing.JTextField bairro4;
    private javax.swing.JTextField bairroAgencia;
    private javax.swing.JTextField bairroGerente;
    private javax.swing.JRadioButton bancoDeCouro;
    private javax.swing.JRadioButton bancosCouraPlanoCarro;
    private javax.swing.JComboBox boxPlanos;
    private javax.swing.JComboBox boxSeguro;
    private javax.swing.JComboBox boxVeiculos;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cadastrarCarro;
    private javax.swing.JButton cadastrarCliente;
    private javax.swing.JButton cadastrarFuncionario;
    private javax.swing.JButton cadastrarMoto;
    private javax.swing.JButton cadastrarPlanoCarro;
    private javax.swing.JButton cadastrarPlanoDeLocacao;
    private javax.swing.JButton cadastrarPlanoMoto;
    private javax.swing.JButton cadastrarVeiculo;
    private javax.swing.JFormattedTextField cep;
    private javax.swing.JFormattedTextField cep1;
    private javax.swing.JFormattedTextField cep2;
    private javax.swing.JFormattedTextField cepAgencia;
    private javax.swing.JFormattedTextField cepGerente;
    private javax.swing.JTextField cidade;
    private javax.swing.JTextField cidade1;
    private javax.swing.JTextField cidade2;
    private javax.swing.JTextField cidadeAgencia;
    private javax.swing.JTextField cidadeGerente;
    private javax.swing.JTextField cilindradasMoto;
    private javax.swing.JFormattedTextField cilindradasPlanoMoto;
    private javax.swing.JTextField clienteLocacao;
    private javax.swing.JFormattedTextField cnpj;
    private javax.swing.JFormattedTextField cnpjAgencia;
    private javax.swing.JComboBox combustivelCarro;
    private javax.swing.JToggleButton confirmarProblemas;
    private javax.swing.JComboBox corCarro;
    private javax.swing.JFormattedTextField cpf;
    private javax.swing.JFormattedTextField cpf1;
    private javax.swing.JFormattedTextField cpfGerente;
    private javax.swing.JFormattedTextField dataAquisicaoCarro;
    private javax.swing.JFormattedTextField dataAquisicaoMoto;
    private javax.swing.JFormattedTextField dataAtraso;
    private javax.swing.JFormattedTextField dataDevolucaoLocacao;
    private javax.swing.JRadioButton direcaoHidraulica;
    private javax.swing.JRadioButton direcaoHidraulicaPlanoCarro;
    private javax.swing.JButton editarCliente;
    private javax.swing.JButton editarFuncionario;
    private javax.swing.JButton editarPlanoDeLocacao;
    private javax.swing.JButton editarVeiculo;
    private javax.swing.JButton efetuarDevolucao;
    private javax.swing.JTextField email;
    private javax.swing.JTextField email1;
    private javax.swing.JTextField email2;
    private javax.swing.JTextField emailGerente;
    private javax.swing.JComboBox estado;
    private javax.swing.JComboBox estado1;
    private javax.swing.JComboBox estado2;
    private javax.swing.JComboBox estadoAgencia;
    private javax.swing.JComboBox estadoGerente;
    private javax.swing.JComboBox freioCarro;
    private javax.swing.JRadioButton gps;
    private javax.swing.JTextField inscEstadual;
    private javax.swing.JTextField inscEstadualAgencia;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox jComboTipoFuncionario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JList jList4;
    private javax.swing.JList jListaClientes;
    private javax.swing.JList jListaFuncionario;
    private javax.swing.JList jListaPlanos;
    private javax.swing.JList jListaVeiculos;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuSair;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner jSpinnerCombustivelMoto;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane6;
    private javax.swing.JComboBox jTipoCombustivelMoto;
    private javax.swing.JComboBox jTipoCorMoto;
    private javax.swing.JComboBox jTipoFreioMoto;
    private javax.swing.JComboBox jTipoPotenciaMoto;
    private javax.swing.JButton limparCampos;
    private javax.swing.JButton limparCampos1;
    private javax.swing.JButton limparCampos3;
    private javax.swing.JButton limparCamposCarro;
    private javax.swing.JButton limparCamposLocacao;
    private javax.swing.JButton limparCamposMoto;
    private javax.swing.JButton limparCamposPlanoCarro;
    private javax.swing.JButton limparCamposPlanoMoto;
    private javax.swing.JButton locar;
    private javax.swing.JRadioButton locarCarro;
    private javax.swing.JRadioButton locarMoto;
    private javax.swing.JTextField marcaCarro;
    private javax.swing.JFormattedTextField marcaMoto;
    private javax.swing.JFormattedTextField modeloCarro;
    private javax.swing.JTextField modeloMoto;
    private javax.swing.JFormattedTextField nascimento;
    private javax.swing.JFormattedTextField nascimento1;
    private javax.swing.JFormattedTextField nascimentoGerente;
    private javax.swing.JTextField naturalidade;
    private javax.swing.JTextField naturalidade1;
    private javax.swing.JTextField naturalidadeGerente;
    private javax.swing.JSpinner nivelCombustivelCarro;
    private javax.swing.JSpinner nivelTanqueNovo;
    private javax.swing.JTextField nome;
    private javax.swing.JTextField nome1;
    private javax.swing.JTextField nome2;
    private javax.swing.JTextField nomeGerente;
    private javax.swing.JTextField nomePlanoCarro;
    private javax.swing.JTextField nomePlanoMoto;
    private javax.swing.JFormattedTextField numero;
    private javax.swing.JTextField numero1;
    private javax.swing.JTextField numero2;
    private javax.swing.JTextField numeroAgencia;
    private javax.swing.JTextField numeroGerente;
    private javax.swing.JCheckBox perdaTotalOuRoubo;
    private javax.swing.JTextField potenciaCarro;
    private javax.swing.JTextField potenciaMoto;
    private javax.swing.JFormattedTextField precoPlanoCarro;
    private javax.swing.JFormattedTextField precoPlanoMoto;
    private javax.swing.JRadioButton quatroPortas;
    private javax.swing.JRadioButton quatroPortasPlanoCarro;
    private javax.swing.JButton realizarLocacao;
    private javax.swing.JButton realizarPagamento;
    private javax.swing.JTextField renavamCarro;
    private javax.swing.JTextField renavamMoto;
    private javax.swing.JFormattedTextField rg;
    private javax.swing.JTextField rg1;
    private javax.swing.JTextField rgGerente;
    private javax.swing.JTextField rua;
    private javax.swing.JTextField rua1;
    private javax.swing.JTextField rua2;
    private javax.swing.JTextField ruaAgencia;
    private javax.swing.JTextField ruaGerente;
    private javax.swing.JTextField rzSocial;
    private javax.swing.JCheckBox tanqueErrado;
    private javax.swing.JFormattedTextField telefone;
    private javax.swing.JFormattedTextField telefone1;
    private javax.swing.JFormattedTextField telefone2;
    private javax.swing.JFormattedTextField telefoneAgencia;
    private javax.swing.JFormattedTextField telefoneGerente;
    private javax.swing.JComboBox tipoPotenciaCarro;
    private javax.swing.JRadioButton travaEletrica;
    private javax.swing.JRadioButton travaEletricaPlanoCarro;
    private javax.swing.JButton verificarDebito;
    private javax.swing.JRadioButton vidroEletrico;
    private javax.swing.JRadioButton vidroEletricoPlanoCarro;
    // End of variables declaration//GEN-END:variables
}
