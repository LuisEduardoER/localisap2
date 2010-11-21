package planos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import veiculos.Acessorio;

import veiculos.Automovel;

/**
 *
 * @author Filipe Alencar   -twitter.com/filipealencar_
 * @author Felipe Jose      -twitter.com/felipejosefc
 * @author Emilio Farias    -twitter.com/militofarias
 *
 * http://code.google.com/p/localisap2/
 * Universidade Federal de Campina Grande - Computacao
 *
 */
public class PlanoAutomovel implements Plano{
    private Collection<String> listaMarca = new ArrayList<String>();
    private Collection<Automovel> listaAuto = new ArrayList<Automovel>();
    private List<Acessorio> listaAcessorios = new ArrayList<Acessorio>();
    private double preco;
    private String nome;

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
    public void adicionaListaAcessorios(List<Acessorio> acessorios) {
        this.listaAcessorios = acessorios;
    }

    /**
     * Adiciona um carro ao plano de locacao
     * @param carro - Recebe um carro
     * @throws Exception - Erro se o carro nao tiver os acessorios do plano
     */
    public void adicionaCarro(Automovel carro) throws Exception {
        int tamanho = listaAcessorios.size();
        int acertos = 0;
        for (Acessorio item : carro.getOpcionais()) {
            if (listaAcessorios.contains(item)) {
                acertos++;
            }
        }
        if (tamanho != acertos) {
            throw new Exception("O carro nao atende as especicacoes do plano");
        }
        this.listaAuto.add(carro);

    }

    /**
     * Remove o carro do plano
     * @param carro - O carro a ser removido.
     * @throws Exception - Erro se o carro nao existe no cadastro do plano.
     */
    public void removeCarro(Automovel carro) throws Exception {
        if (!this.listaAuto.contains(carro)) {
            throw new Exception("Esse modelo nao se encontra na lista do plano.");
        } else {
            listaAuto.remove(carro);
        }
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
     * Captura a lista de automoveis do plano
     * @return - Em List a lista
     */
    public Collection<Automovel> getListaAutomovel() {
        return this.listaAuto;
    }
    public void adicionaModelo(String modelo){

    }
}
