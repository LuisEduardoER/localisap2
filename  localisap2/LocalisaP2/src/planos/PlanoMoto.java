package planos;

import java.io.Serializable;

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
public class PlanoMoto implements Plano, Serializable {

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
     * Metodo que adiciona as cilindradas maxima do plano
     * @param cilindradas
     */
    public void adicionaCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
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
     * Captura as cilindradas do plano
     * @return - As cilindradas do plano
     */
    public double getCilindradas() {
        return cilindradas;
    }
}
