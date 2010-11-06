/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package locacao;

import agencias.Filial;
import clientes.PessoaFisica;
import clientes.PessoaJuridica;
import planos.Plano;
import planos.PlanoAutomovel;
import veiculos.Cor;
import veiculos.Motocicleta;
import veiculos.TipoDeCombustivel;
import veiculos.TipoDePotencia;
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
    private int nivelDoTanqueFinal;
    private Plano planoDaLocacao;
    private String dataEntrega, dataDevolucao;

    public Locacao(Veiculo veiculo, Object cliente, Plano planoDaLocacao, String dataEntrega, String dataDevolucao) throws Exception {
        setVeiculo(veiculo);
        if (!(cliente instanceof PessoaFisica) && (!(cliente instanceof PessoaJuridica))) {
            throw new Exception("Eh preciso receber um objeto que seja cliente");
        }
        setCliente(cliente);
        setPlano(planoDaLocacao);
        setDataEntrega(dataEntrega);
        setDataDevolucao(dataDevolucao);
    }

    private void efetuaLocacao() {
        agencia2.aumentaLocacoes();
    }

    public void setDataEntrega(String dataEntrega) throws Exception{
		Validacao testaData = new Validacao();
		if(!(testaData.validaData(dataEntrega)))
			throw new Exception("Data invalida");
		this.dataEntrega = dataEntrega;
    }

    public void setDataDevolucao(String dataDevolucao) throws Exception{
		Validacao testaData = new Validacao();
		if(!(testaData.validaData(dataDevolucao)))
			throw new Exception("Data invalida");
		this.dataDevolucao = dataDevolucao;
                
    }
    private void setCliente(Object cliente) throws Exception {
        if (cliente instanceof PessoaFisica) {
           PessoaFisica cliente1 = (PessoaFisica) cliente;
            if (cliente1.getEmDebito()) {
                throw new Exception("O cliente está devendo , favor pagar as contas primeiro");
            }
            this.cliente = cliente1;
        }
        if (cliente instanceof PessoaJuridica) {
            PessoaJuridica cliente1 = (PessoaJuridica) cliente;
        
        if (cliente1.getEmDebito()) {
            throw new Exception("O cliente está devendo , favor pagar as contas primeiro");
        }
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

    public String getDataEntrega(){
        return this.dataEntrega;
    }

    public String getDataDevolucao(){
        return this.dataDevolucao;
    }

    /*public static void main(String[] args) throws Exception {
        Plano pl = new PlanoAutomovel("plano", 150);

        Motocicleta vec = new Motocicleta("renavam", "modelo", "marca", TipoDePotencia.HP, 1000, 500, 2000, Cor.PRETO, TipoDeCombustivel.GASOLINA, "27/11/2000", 100);
        PessoaJuridica pessoa = new PessoaJuridica();
        Locacao loc = new Locacao(vec, pessoa, pl);
        System.out.println(loc.cliente.getClass());
    }*/
}
