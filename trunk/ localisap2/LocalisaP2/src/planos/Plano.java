
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
     * @param preco
     */
    void setPreco(double preco);

    /**
     * Edita nome
     * @param nome
     */
    void setNome(String nome);

    /**
     * Captura preco
     * @return
     */
    double getPreco();

    /**
     * Captura nome
     * @return
     */
    String getNome();
}
