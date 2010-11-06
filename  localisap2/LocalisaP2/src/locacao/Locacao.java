/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package locacao;

import agencias.Filial;
import clientes.PessoaFisica;
import clientes.PessoaJuridica;
import java.util.Calendar;
import java.util.GregorianCalendar;
import planos.Plano;
import seguro.Seguro;
import veiculos.Veiculo;
import verificacoes.Validacao;

/**
 *
 * @author Filipe
 */
public class Locacao {

    static Filial agencia2;
    Object cliente;
    private Veiculo veiculo;
    private int nivelDoTanqueInicial;
    private Plano planoDaLocacao;
    private String dataEntrega, dataDevolucao;
    private Seguro tipoDoSeguro;
    private int tipoSeguro;

    public Locacao(Veiculo veiculo, Object cliente, Plano planoDaLocacao, String dataEntrega, String dataDevolucao, int tipoSeguro) throws Exception {
        setVeiculo(veiculo);
        if (!(cliente instanceof PessoaFisica) && (!(cliente instanceof PessoaJuridica))) {
            throw new Exception("Eh preciso receber um objeto que seja cliente");
        }
        setCliente(cliente);
        setPlano(planoDaLocacao);
        setDataEntrega(dataEntrega);
        setDataDevolucao(dataDevolucao);
        this.tipoSeguro = tipoSeguro;
        if (tipoSeguro == 1) {
            Seguro seguro = new Seguro(true, planoDaLocacao);
            tipoDoSeguro = seguro;
        }
        if (tipoSeguro == 0) {
            Seguro seguro = new Seguro(false, planoDaLocacao);
            tipoDoSeguro = seguro;
        }
    }
    public Object getCliente(){
        return cliente;
    }

    public void efetuaLocacao() throws Exception {
        if (cliente instanceof PessoaFisica) {
            PessoaFisica cliente1 = (PessoaFisica) cliente;
            if (cliente1.getQuantidadeDeLocacao() > 3) {
                throw new Exception("O cliente ja locou mais que tres veiculos");
            }
            if (cliente1.getEmDebito()) {
                throw new Exception("O cliente está devendo , favor pagar as contas primeiro");
            }
            cliente1.locacao(1);
        }
        if (cliente instanceof PessoaJuridica) {
            PessoaJuridica cliente1 = (PessoaJuridica) cliente;
            if (cliente1.getQuantidadeDeLocacao() > 10) {
                throw new Exception("O cliente ja locou mais que tres veiculos");
            }
            if (cliente1.getEmDebito()) {
                throw new Exception("O cliente está devendo , favor pagar as contas primeiro");
            }
            cliente1.locacao(1);
        }
        agencia2.aumentaLocacoes();
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

    private void setCliente(Object cliente) {
        if (cliente instanceof PessoaFisica) {
            PessoaFisica cliente1 = (PessoaFisica) cliente;
            this.cliente = cliente1;
        }
        if (cliente instanceof PessoaJuridica) {
            PessoaJuridica cliente1 = (PessoaJuridica) cliente;
            this.cliente = cliente1;
        }
    }

    private void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
        nivelDoTanqueInicial = veiculo.getNivelDoTanque();
    }

    private void setPlano(Plano planoDaLocacao) {
        this.planoDaLocacao = planoDaLocacao;
    }
    public Plano getPlano() {
       return planoDaLocacao;
    }
    public String getDataEntrega() {
        return this.dataEntrega;
    }

    public String getDataDevolucao() {
        return this.dataDevolucao;
    }

    public Double getPrecoLocacao() {
        if(tipoSeguro==0 || tipoSeguro ==1){
            Double preco = diferencaData(dataEntrega,dataDevolucao)*tipoDoSeguro.getPrecoDoSeguro();
            return preco;
        }
        return diferencaData(dataEntrega,dataDevolucao)*planoDaLocacao.getPreco();
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
        Calendar calendario2 = new GregorianCalendar(ano2,mes2,dia2);
        long diferencaMilisegundos = calendario2.getTimeInMillis() - calendario.getTimeInMillis();
        long resultadoDias = diferencaMilisegundos / 86400000;
        return resultadoDias;
    }
    public int getNivelInicialTanque(){
        return nivelDoTanqueInicial;
    }
}
