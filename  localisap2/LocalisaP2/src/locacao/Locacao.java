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

    public Locacao(Veiculo veiculo, Object cliente, Plano planoDaLocacao) throws Exception {
        setVeiculo(veiculo);
        if (!(cliente instanceof PessoaFisica) && (!(cliente instanceof PessoaJuridica))) {
            throw new Exception("Eh preciso receber um objeto que seja cliente");
        }
        setCliente(cliente);
        setPlano(planoDaLocacao);
    }

    private void efetuaLocacao() {
        veiculo.getLocalizacao().aumentaLocacoes();
    }

    private void setCliente(Object cliente) throws Exception {
        if (cliente instanceof PessoaFisica) {
           PessoaFisica cliente1 = (PessoaFisica) cliente;
            if (cliente1.emDebito()) {
                throw new Exception("O cliente está devendo , favor pagar as contas primeiro");
            }
            this.cliente = cliente1;
        }
        if (cliente instanceof PessoaJuridica) {
            PessoaJuridica cliente1 = (PessoaJuridica) cliente;
        
        if (cliente1.emDebito()) {
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

    public static void main(String[] args) throws Exception {
        Plano pl = new PlanoAutomovel("plano", 150);

        Motocicleta vec = new Motocicleta("renavam", "modelo", "marca", TipoDePotencia.HP, 1000, 500, 2000, Cor.PRETO, TipoDeCombustivel.GASOLINA, agencia2, "27/11/2000", 100);
        PessoaJuridica pessoa = new PessoaJuridica();
        Locacao loc = new Locacao(vec, pessoa, pl);
        System.out.println(loc.cliente.getClass());
    }
}
