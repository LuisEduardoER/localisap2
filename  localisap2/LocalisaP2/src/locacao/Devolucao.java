/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package locacao;

import clientes.Cliente;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import verificacoes.Validacao;

/**
 * Classe Devolucao
 * Lida com transacoes de devolucao de automovel
 *
 * @author Filipe Alencar   -twitter.com/filipealencar_
 * @author Felipe Jose      -twitter.com/felipejosefc
 * @author Emilio Farias    -twitter.com/militofarias
 *
 * http://code.google.com/p/localisap2/
 * Universidade Federal de Campina Grande - Computacao
 *
 */
public class Devolucao{

    private double multaTanque = 0;
    private double multaAtraso = 0;
    private double multaProblema = 0;
    private int nivelDoTanqueInicial;
    private int nivelDoTanqueFinal;
    private double precoMulta;
    private String dataEntrega, dataDevolucao;
    private Locacao locacao;
    private ArrayList<Problema> problemas;
    private Cliente cliente;

    /**
     * Construtor de Devolucao
     *
     * @param loc - Locacao
     * @param nivelDoTanqueFinal - nivel do tanque na devolucao
     * @param dataDevolucao - data da devolucao
     * @param problemas - problemas do veiculo na devolucao
     * @throws Exception - Erro proveniente dos sets
     */
    public Devolucao(Locacao loc, int nivelDoTanqueFinal, String dataDevolucao, ArrayList<Problema> problemas) throws Exception {
        nivelDoTanqueInicial = loc.getNivelInicialTanque();
        this.nivelDoTanqueFinal = nivelDoTanqueFinal;
        setDataDevolucao(dataDevolucao);
        setDataEntrega(loc.getDataDevolucao());
        locacao = loc;
        this.problemas = problemas;
        cliente = locacao.getCliente();
        setCliente(cliente);
        this.efetuaDevolucao();
        cliente.setDivida(precoMulta);
    }

    /**
     * Metodo que verifica se o cliente tem dividas e efetua a devolucao.
     */
    public void efetuaDevolucao() {
        if (getMultas() != 0) {
            cliente.setEmDebito(true);
            cliente.setQuantidadeLocacao(-1);
        }
    }

    /**
     * Metodo que retorna o valor da multa.
     * @return - Em double o valor da multa.
     */
    public double getMultas() {
        multaProblema = 0;
        multaAtraso = 0;
        multaTanque = 0;
        if (nivelDoTanqueFinal != nivelDoTanqueInicial) {
            int dif = nivelDoTanqueFinal - nivelDoTanqueInicial;
            double multa = (dif / 100) * 50 * 2.6;
            multaTanque = multa;
        }
        if (diferencaData(dataEntrega, dataDevolucao) != 0) {
            double atraso = diferencaData(dataEntrega, dataDevolucao) * 0.05 * locacao.getPlano().getPreco();
            multaAtraso = atraso;
        }
        for(Problema p: problemas)
            if (p.getPreco() != 0)
                multaProblema+= p.getPreco();
        return multaAtraso + multaProblema + multaTanque;
    }

    /**
     * Metodo que permite mudar o cliente da devolucao
     * @param cliente - Recebe o cliente
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;

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
}
