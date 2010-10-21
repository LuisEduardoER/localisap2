package planos;
import java.util.ArrayList;
import java.util.List;

import veiculos.Motocicleta;
import veiculos.Veiculo.Acessorios;

public class PlanosMoto {
	
	private List<Motocicleta> listaMoto = new ArrayList<Motocicleta>();
	private int cilindradas;
	private double preco;
	/**
	 * Construtor de um plano de moto.
	 * @param preco - Recebe o preco em double diario da locacao
	 */	
	public PlanosMoto(double preco){
		this.preco = preco;
	}
	/**
	 * Metodo que adiciona as cilindradas maxima do plano
	 * @param cilindradas- Recebe como inteiro as cilindradas.
	 */
	public void adicionaCilindradas(int cilindradas){
		this.cilindradas = cilindradas;
	}
	/**
	 * Adiciona uma moto ao plano de locacao
	 * @param moto - Recebe uma moto
	 * @throws Exception - Erro se a moto nao tiver as cilindradas do plano
	 */
	public void adicionaMoto(Motocicleta moto)throws Exception{
		if (moto.getCilindradas()>cilindradas)
			throw new Exception("A moto não atende as especicaçoes do plano");
		this.listaMoto.add(moto);
	}
	/**
	 * Remove a moto do plano
	 * @param carro - A motoo a ser removida.
	 * @throws Exception - Erro se o carro nao existe no cadastro do plano.
	 */
	public void removeMoto(Motocicleta moto) throws Exception{
		if(!this.listaMoto.contains(moto)) {
			throw new Exception("Esse modelo nao se encontra na lista do plano.");
		} else {
			listaMoto.remove(moto);
		}
	}
	/**
	 * Permite mudar o preco do plano
	 * @param preco - O preço em double do plano
	 */
	public void setPreco(double preco){
		this.preco = preco;
	}
	/**
	 * Captura o preco do plano
	 * @return - Em double o preco
	 */
	public double getPreco(){
		return this.preco;
	}
	
	
}