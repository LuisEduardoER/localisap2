/**
 * 
 */
package seguro;

/**
 * @author Filipe de Alencar Ramos
 *
 */
public class Seguro {
	private boolean seguroTotal;
	private double precoDoPlano;

//	public Seguro(boolean seguroTotal, PlanoDeLocacoes plano){
//		this.seguroTotal = seguroTotal;
//		precoDoPlano = plano.getPreco();
//	}
	/**
	 *  Metodo que verifica se o seguro eh total , e retorna o preco que seguro custara.
	 * @return - O preco da locacao com o seguro incluso.
	 */
	public double getPrecoDoSeguro(){
		if (seguroTotal)
			return (precoDoPlano*1.5);
		return (precoDoPlano*1.25);
	}
}
