/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package locacao;

import clientes.Cliente;
import clientes.PessoaFisica;
import clientes.PessoaJuridica;
import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import planos.Plano;
import seguro.Seguro;
import veiculos.Veiculo;
import verificacoes.Validacao;

/**
 * Classe Locacao
 * Lida com transacoes referentes a locacao
 * 
 * @author Filipe Alencar   -twitter.com/filipealencar_
 * @author Felipe Jose      -twitter.com/felipejosefc
 * @author Emilio Farias    -twitter.com/militofarias
 *
 * http://code.google.com/p/localisap2/
 * Universidade Federal de Campina Grande - Computacao
 *
 */
public class Locacao implements Serializable{

    private int codigo;
    private Cliente cliente;
    private Veiculo veiculo;
    private int nivelDoTanqueInicial;
    private Plano planoDaLocacao;
    private String dataEntrega, dataDevolucao;
    private Seguro tipoDoSeguro;
    private int tipoSeguro;
    private static final long serialVersionUID = 1L;

    /**
     * Construtor de Locacao
     *
     * @param veiculo
     * @param cliente
     * @param planoDaLocacao
     * @param dataEntrega
     * @param dataDevolucao
     * @param tipoSeguro
     * @throws Exception
     */
    public Locacao(Veiculo veiculo, Cliente cliente, Plano planoDaLocacao, String dataEntrega, String dataDevolucao, int tipoSeguro) throws Exception {
        setVeiculo(veiculo);
        if (!(cliente instanceof PessoaFisica) && (!(cliente instanceof PessoaJuridica))) {
            throw new Exception("Eh preciso receber um objeto que seja cliente");
        }
        setCliente(cliente);
        setPlano(planoDaLocacao);
        setDataEntrega(dataEntrega);
        setDataDevolucao(dataDevolucao);
        this.tipoSeguro = tipoSeguro;
        if (tipoSeguro == 2) {
            Seguro seguro = new Seguro(true, planoDaLocacao);
            tipoDoSeguro = seguro;
        }
        if (tipoSeguro == 1) {
            Seguro seguro = new Seguro(false, planoDaLocacao);
            tipoDoSeguro = seguro;
        }
        setCodigo();

    }

    /**
     * Metodo que gera o codigo de locacao.
     */
    public void setCodigo() {
        Random numero = new Random();
        int numeroAleatorio = (int) (numero.nextDouble() * 100000);
        codigo = numeroAleatorio;
    }

    /**
     * Metodo que permite saber o codigo de locacap
     * @return - em int o codigo de locacao
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Metodo que permite pegar o cliente.
     * @return - O cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Metodo que verifica se o cliente pode locar e efetua a locacao
     * @throws Exception - Erro de cliente com divida ou com mais locacoes que o permitido
     */
    public void efetuaLocacao() throws Exception {
        if (cliente instanceof PessoaFisica) {
            if (cliente.getQuantidadeDeLocacao() > 3) {
                throw new Exception("O cliente ja locou mais que tres veiculos");
            }
            if (cliente.getEmDebito()) {
                throw new Exception("O cliente está devendo , favor pagar as contas primeiro");
            }
            cliente.setQuantidadeLocacao(1);
        }
        if (cliente instanceof PessoaJuridica) {
            if (cliente.getQuantidadeDeLocacao() > 10) {
                throw new Exception("O cliente ja locou mais que dez veiculos");
            }
            if (cliente.getEmDebito()) {
                throw new Exception("O cliente está devendo , favor pagar as contas primeiro");
            }
            cliente.setQuantidadeLocacao(1);
        }

    }

    /**
     * Metodo que permite mudar a data que o carro foi entregue ao cliente.
     * @param dataEntrega - data de entrega (XX-XX-XXXX)
     * @throws Exception - Erro de data invalida.
     */
    public void setDataEntrega(String dataEntrega) throws Exception {
        Validacao testaData = new Validacao();
        if (!(testaData.validaData(dataEntrega))) {
            throw new Exception("Data invalida");
        }
        this.dataEntrega = dataEntrega;
    }

    /**
     * Metodo que permite mudar a data de indicacao da devolucao
     * @param dataDevolucao - Data de devolucao (XX-XX-XXXX)
     * @throws Exception - Erro de data invalida.
     */
    public void setDataDevolucao(String dataDevolucao) throws Exception {
        Validacao testaData = new Validacao();
        if (!(testaData.validaData(dataDevolucao))) {
            throw new Exception("Data invalida");
        }
        this.dataDevolucao = dataDevolucao;

    }

    /**
     * Metodo que permite mudar o cliente da devolucao
     * @param cliente - Recebe o cliente
     */
    private void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Metodo que permite mudar o veiculo
     * @param veiculo - Recebe o veiculo
     */
    private void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
        nivelDoTanqueInicial = veiculo.getNivelDoTanque();
    }

    /**
     * Metodo que permite mudar o plano
     * @param plano - Recebe o plano
     */
    private void setPlano(Plano planoDaLocacao) {
        this.planoDaLocacao = planoDaLocacao;
    }

    /**
     * Retorna o plano da locacao
     * @return - o plano da locacao
     */
    public Plano getPlano() {
        return planoDaLocacao;
    }

    /**
     * Retorna a data da locacao
     * @return - a data que o carro foi entregue ao cliente
     */
    public String getDataEntrega() {
        return this.dataEntrega;
    }

    /**
     * Retorna a data que o carro ira ser devolvido
     * @return - A data que o carro ira ser devolvido
     */
    public String getDataDevolucao() {
        return this.dataDevolucao;
    }

    /**
     * Retorna o preco da locacao
     * @return - o preco da locacao
     */
    public Double getPrecoLocacao() {
        if (tipoSeguro == 0 || tipoSeguro == 1) {
            Double preco = diferencaData(dataEntrega, dataDevolucao) * tipoDoSeguro.getPrecoDoSeguro();
            return preco;
        }
        return diferencaData(dataEntrega, dataDevolucao) * planoDaLocacao.getPreco();
    }

    /**
     * Metodo que calcula a diferenca entre duas datas
     * @param dataEntrega - Recebe a data que o carro foi entregue ao cliente.
     * @param dataDevolucao - Recebe a data da devolucao.
     * @return - Os dias de diferenca.
     */
    public long diferencaData(String dataEntrega, String dataDevolucao) {
        dataEntrega = dataEntrega.replace("/", " ");
        dataEntrega = dataEntrega.replace(".", " ");
        dataEntrega = dataEntrega.replace(" ", "");
        dataDevolucao = dataDevolucao.replace("/", " ");
        dataDevolucao = dataDevolucao.replace(".", " ");
        dataDevolucao = dataDevolucao.replace(" ", "");
        int dia1 = Integer.parseInt(dataEntrega.substring(0, 2));
        int mes1 = Integer.parseInt(dataEntrega.substring(2, 4));
        int ano1 = Integer.parseInt(dataEntrega.substring(4, 8));
        int dia2 = Integer.parseInt(dataDevolucao.substring(0, 2));
        int mes2 = Integer.parseInt(dataDevolucao.substring(2, 4));
        int ano2 = Integer.parseInt(dataDevolucao.substring(4, 8));
        Calendar calendario = new GregorianCalendar(ano1, mes1, dia1);
        Calendar calendario2 = new GregorianCalendar(ano2, mes2, dia2);
        long diferencaMilisegundos = calendario2.getTimeInMillis() - calendario.getTimeInMillis();
        long resultadoDias = diferencaMilisegundos / 86400000;
        return resultadoDias;
    }

    /**
     * Retorna o nivel inicial do tanque de gasolina do veiculo locado
     * @return - o nivel inicial do tanque de gasolina do veiculo locado
     */
    public int getNivelInicialTanque() {
        return nivelDoTanqueInicial;
    }
}
