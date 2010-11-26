package planos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import veiculos.Acessorio;


/**
 * Classe PlanoAutomovel
 * implementa Interface Plano
 * gerencia dados referentes a planos de automoveis
 * 
 * @author Filipe Alencar   -twitter.com/filipealencar_
 * @author Felipe Jose      -twitter.com/felipejosefc
 * @author Emilio Farias    -twitter.com/militofarias
 *
 * http://code.google.com/p/localisap2/
 * Universidade Federal de Campina Grande - Computacao
 *
 */
public class PlanoAutomovel implements Plano, Serializable{
    private ArrayList<Acessorio> listaAcessorios = new ArrayList<Acessorio>();
    private double preco;
    private String nome;
    private static final long serialVersionUID = 1L;

    /**
     * Construtor de um plano de automovel.
     * @param preco - Recebe o preco em double diario da locacao
     * @param nome - Recebe o nome em String do plano
     */
    public PlanoAutomovel(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;

    }

    /**
     * Adiciona os acessorios que o plano contempla.
     * @param item - Recebe o acessorio a ser adicionado no tipo Acessorios.
     */
    public void adicionaAcessorios(Acessorio item) {
        listaAcessorios.add(item);
    }

    /**
     * Adiciona uma lista de acessorios que o plano contempla.
     * @param acessorios - Recebe uma lista de acessorios a serem adicionados
     */
    public void adicionaListaAcessorios(ArrayList<Acessorio> acessorios) {
        this.listaAcessorios = acessorios;
    }

    /**
     * Permite mudar o preco do plano
     * @param preco - O preço em double do plano
     */
    @Override
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * Permite mudar o nome do plano
     * @param nome - O nome em String do plano
     */
    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Captura o preco do plano
     * @return - Em double o preco
     */
    @Override
    public double getPreco() {
        return this.preco;
    }

    /**
     * Captura o nome do plano
     * @return - Em String o nome
     */
    @Override
    public String getNome() {
        return this.nome;
    }

    /**
     * captura acessorios do plano
     * @return listaAcessorios
     */
    public ArrayList<Acessorio> getAcessorios(){
        return listaAcessorios;
    }
}
