package planos;

/**
 * Interface Plano
 * dados inerentes a todos os planos
 *
 *
 * @author Filipe Alencar   -twitter.com/filipealencar_
 * @author Felipe Jose      -twitter.com/felipejosefc
 * @author Emilio Farias    -twitter.com/militofarias
 *
 * http://code.google.com/p/localisap2/
 * Universidade Federal de Campina Grande - Computacao
 *
 */
public interface Plano {

    /**
     * Edita preco do plano
     * @param preco - preco do plano
     */
    void setPreco(double preco);

    /**
     * Edita nome
     * @param nome - nome
     */
    void setNome(String nome);

    /**
     * Captura preco
     * @return - preco
     */
    double getPreco();

    /**
     * Captura nome
     * @return - nome
     */
    String getNome();
}
