/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package locacao;

import clientes.PessoaFisica;
import clientes.PessoaJuridica;
import java.util.Calendar;
import java.util.GregorianCalendar;
import verificacoes.Validacao;

/**
 *
 * @author Filipe
 */
public class Devolucao {

    private double multaTanque = 0;
    private double multaAtraso = 0;
    private double multaProblema = 0;
    private int nivelDoTanqueInicial;
    private int nivelDoTanqueFinal;
    private int precoMulta;
    private String dataEntrega, dataDevolucao;
    private Locacao locacao;
    private Problemas problema;
    private Object cliente;

    public Devolucao(Locacao loc, int nivelDoTanqueFinal, String dataEntrega, String dataDevolucao, Problemas problema) throws Exception {
        nivelDoTanqueInicial = loc.getNivelInicialTanque();
        this.nivelDoTanqueFinal = nivelDoTanqueFinal;
        setDataDevolucao(dataDevolucao);
        setDataEntrega(dataEntrega);
        locacao = loc;
        this.problema = problema;
        cliente = locacao.getCliente();
        setCliente(cliente);
    }

    public void efetuaDevolucao() {
        if (getMultas() != 0) {
            if (cliente instanceof PessoaFisica) {
                PessoaFisica cliente1 = (PessoaFisica) cliente;
                cliente1.setEmDebito(Boolean.TRUE);
                cliente1.setDivida(getMultas());
                cliente1.locacao(-1);
                this.cliente = cliente1;

            }
            if (cliente instanceof PessoaJuridica) {
                PessoaJuridica cliente1 = (PessoaJuridica) cliente;
                cliente1.setEmDebito(Boolean.TRUE);
                cliente1.setDivida(getMultas());
                cliente1.locacao(-1);
                this.cliente = cliente1;
            }
        }
    }
     public double getMultas() {
        if (nivelDoTanqueFinal != nivelDoTanqueInicial) {
            int dif = nivelDoTanqueFinal - nivelDoTanqueInicial;
            double multa = (dif / 100) * 50 * 2.6;
            multaTanque = multa;
        }
        if (diferencaData(dataEntrega, dataDevolucao) != 0) {
            double atraso = diferencaData(dataEntrega, dataDevolucao) * 0.05 * locacao.getPlano().getPreco();
            multaAtraso = atraso;
        }
        if (problema.getPreco() != 0) {
            multaProblema = problema.getPreco();
        }
        return multaAtraso + multaProblema + multaTanque;
    }

    public void setCliente(Object cliente) {
        if (cliente instanceof PessoaFisica) {
            PessoaFisica cliente1 = (PessoaFisica) cliente;
            this.cliente = cliente1;

        }
        if (cliente instanceof PessoaJuridica) {
            PessoaJuridica cliente1 = (PessoaJuridica) cliente;
            this.cliente = cliente1;
        }
    }

    public void setDataEntrega(String dataEntrega) throws Exception {
        Validacao testaData = new Validacao();
        if (!(testaData.validaData(dataEntrega))) {
            throw new Exception("Data invalida");
        }
        this.dataEntrega = dataEntrega;
    }

    public void setDataDevolucao(String dataDevolucao) throws Exception {
        Validacao testaData = new Validacao();
        if (!(testaData.validaData(dataDevolucao))) {
            throw new Exception("Data invalida");
        }
        this.dataDevolucao = dataDevolucao;

    }

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
