package planos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import veiculos.Motocicleta;
import veiculos.Veiculo;

/**
 * Classe PlanoMoto
 * implementa Interface Plano
 * gerencia dados referentes a planos de motocicletas
 *
 * @author Filipe Alencar   -twitter.com/filipealencar_
 * @author Felipe Jose      -twitter.com/felipejosefc
 * @author Emilio Farias    -twitter.com/militofarias
 *
 * http://code.google.com/p/localisap2/
 * Universidade Federal de Campina Grande - Computacao
 *
 */
public class PlanoMoto implements Plano,Serializable {

    private Collection<String> listaMarca = new ArrayList<String>();
    private Collection<Veiculo> listaMoto = new ArrayList<Veiculo>();
    private int cilindradas;
    private double preco;
    private String nome;
    private static final long serialVersionUID = 1L;

    /**
     * Construtor de um plano de moto.
     *  @param nome - Recebe o nome em String do plano
     *  @param preco - Recebe o preco em double diario da locacao
     *  
     */
    public PlanoMoto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }
    /**
     * Adiciona motos ao plano
     * @param moto
     */
    public void adicionaMotos(Collection<Veiculo> moto){
        listaMoto = moto;
    }
    /**
     * Metodo que adiciona as cilindradas maxima do plano
     * @param cilindradas
     */
    public void adicionaCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }

    /**
     * Adiciona uma moto ao plano de locacao
     * @param moto - Recebe uma moto
     * @throws Exception - Erro se a moto nao tiver as cilindradas do plano
     */
    public void adicionaMoto(Motocicleta moto) throws Exception {
        if (moto.getCilindradas() > cilindradas) {
            throw new Exception("A moto nao atende as especicacoes do plano");
        }
        this.listaMoto.add(moto);
    }

    /**
     * Remove a moto do plano
     * @param moto
     * @throws Exception - Erro se o carro nao existe no cadastro do plano.
     */
    public void removeMoto(Motocicleta moto) throws Exception {
        if (!this.listaMoto.contains(moto)) {
            throw new Exception("Esse modelo nao se encontra na lista do plano.");
        } else {
            listaMoto.remove(moto);
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
     * @return - Em String o nome do plano
     */
    @Override
    public String getNome() {
        return this.nome;
    }

    /**
     * Captura a lista de Motos do plano
     * @return - Em List a lista de motos
     */
    public Collection<Veiculo> getListaMoto() {
        return this.listaMoto;
    }

    /**
     * Adiciona um modelo ao plano
     * @param modelo
     * @throws Exception
     */
    public void adicionaModelo(String modelo) throws Exception {
        if (modelo == null || modelo.length() <= 0) {
            throw new Exception("Voce deve digitar algo no modelo");
        }
        if (listaMarca.contains(modelo)) {
            throw new Exception("O plano ja contem esse modelo");
        }
        listaMarca.add(modelo);
    }

    /**
     * Captura lista de modelos
     * @return
     */
    public Collection<String> getListaModelos() {
        return listaMarca;
    }
    public  double getCilindradas(){
        return cilindradas;
    }
}
