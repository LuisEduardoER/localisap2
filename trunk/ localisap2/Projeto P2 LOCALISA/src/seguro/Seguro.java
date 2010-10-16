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
	private int precoDoPlano;
	
	public Seguro(boolean seguroTotal, PlanoDeLocacoes plano){
		this.seguroTotal = seguroTotal;
		precoDoPlano = plano.getPreco();
	}
	public double getPrecoDoSeguro(){
		if (seguroTotal)
			return (precoDoPlano*1.5);
		return (precoDoPlano*1.25);
	}
}
