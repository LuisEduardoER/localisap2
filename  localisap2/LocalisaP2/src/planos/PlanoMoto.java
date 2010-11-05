package planos;
import java.util.ArrayList;
import java.util.List;

import veiculos.Motocicleta;
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
public class PlanoMoto implements Plano {

	private List<Motocicleta> listaMoto = new ArrayList<Motocicleta>();
	private int cilindradas;
	private double preco;
	private String nome;
	/**
	 * Construtor de um plano de moto.
	 * @param preco - Recebe o preco em double diario da locacao
	 *  @param nome - Recebe o nome em String do plano
	 */
	public PlanoMoto(String nome, double preco){
		this.nome = nome;
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
			throw new Exception("A moto nao atende as especicacoes do plano");
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
        @Override
	public void setPreco(double preco){
		this.preco = preco;
	}
	/**
	 * Permite mudar o nome do plano
	 * @param nome - O nome em String do plano
	 */
        @Override
	public void setNome(String nome){
		this.nome = nome;
	}
	/**
	 * Captura o preco do plano
	 * @return - Em double o preco
	 */
        @Override
	public double getPreco(){
		return this.preco;
	}
	/**
	 * Captura o nome do plano
	 * @return - Em String o nome do plano
	 */
        @Override
	public String getNome(){
		return this.nome;
	}
	/**
	 * Captura a lista de Motos do plano
	 * @return - Em List a lista de motos
	 */
	public List<Motocicleta> getListaMoto(){
		return this.listaMoto;
	}


}