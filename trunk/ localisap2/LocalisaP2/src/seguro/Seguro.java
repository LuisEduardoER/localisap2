/**
 *
 */
package seguro;

import planos.*;

/**
 * Classe Seguro
 * Gerencia informacoes referentes ao seguro do veiculo
 *
 * @author Filipe Alencar   -twitter.com/filipealencar_
 * @author Felipe Jose      -twitter.com/felipejosefc
 * @author Emilio Farias    -twitter.com/militofarias
 *
 * http://code.google.com/p/localisap2/
 * Universidade Federal de Campina Grande - Computacao
 *
 */
public class Seguro {

    private boolean seguroTotal;
    private double precoDoPlano;

    /**
     * Construtor que recebe se o seguro eh total e o Plano do automovel
     * @param seguroTotal - Recebe true se for seguro total e false se for seguro parcial
     * @param plano - Recebe o plano do automovel
     */
    public Seguro(boolean seguroTotal, Plano plano) {
        this.seguroTotal = seguroTotal;
        precoDoPlano = plano.getPreco();
    }

    /**
     * Construtor que recebe se o seguro eh total e o Plano da moto
     * @param seguroTotal - Recebe true se for seguro total e false se for seguro parcial
     * @param plano - Recebe o plano da moto
     */


    /**
     * Metodo que verifica se o seguro eh total , e retorna o preco que seguro custara.
     * @return - O preco da locacao com o seguro incluso.
     */
    public double getPrecoDoSeguro() {
        if (seguroTotal) {
            return (precoDoPlano * 1.5);
        }
        return (precoDoPlano * 1.25);

    }
}
