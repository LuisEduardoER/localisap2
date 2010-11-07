/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package locacao;

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
public enum Problemas {
    NENHUM(0),
    ARRANHÕES(80),
    AMASSADOS_LEVES(180),
    AMASSADOS_GRAVES(350),
    ROUBADO(5000),
    PERDA_TOTAL(5000);
    private double preco;

    private Problemas(double preco) {
        this.preco = preco;
    }
    /**
     * Metodo que retorna o preco de uma constante do enum
     * @return -  O preco da cosntante .
     */
    public double getPreco() {
        return preco;
    }
}
