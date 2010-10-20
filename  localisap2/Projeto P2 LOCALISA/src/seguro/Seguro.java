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

	//Construtor para plano de automovel
	public Seguro(boolean seguroTotal, PlanosAutomovel plano){
		this.seguroTotal = seguroTotal;
		precoDoPlano = plano.getPreco();
	}

	//Construtor para plano de motocicleta
	public Seguro(boolean seguroTotal, PlanosMoto plano){
		this.seguroTotal = seguroTotal;
		precoDoPlano = plano.getPreco();
	}

	/**
	 *  Metodo que verifica se o seguro eh total , e retorna o preco que seguro custara.
	 * @return - O preco da locacao com o seguro incluso.
	 */
	public double getPrecoDoSeguro(){
		if (seguroTotal) {
			return (precoDoPlano*1.5);
		}
		return (precoDoPlano*1.25);
		 
	}
}
