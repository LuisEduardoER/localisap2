/**
 * 
 */
package seguro;

import planos.*;

/**
 * @author Filipe de Alencar Ramos
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
	public Seguro(boolean seguroTotal, PlanosAutomovel plano){
		this.seguroTotal = seguroTotal;
		precoDoPlano = plano.getPreco();
	}

	/**
	 * Construtor que recebe se o seguro eh total e o Plano da moto
	 * @param seguroTotal - Recebe true se for seguro total e false se for seguro parcial
	 * @param plano - Recebe o plano da moto
	 */
	public Seguro(boolean seguroTotal, PlanosMoto plano){
		this.seguroTotal = seguroTotal;
		precoDoPlano = plano.getPreco();
	}

	/**
	 * Metodo que verifica se o seguro eh total , e retorna o preco que seguro custara.
	 * @return - O preco da locacao com o seguro incluso.
	 */
	public double getPrecoDoSeguro(){
		if (seguroTotal) {
			return (precoDoPlano*1.5);
		}
		return (precoDoPlano*1.25);
		 
	}
}
