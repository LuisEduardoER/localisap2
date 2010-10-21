package planos;
import java.util.ArrayList;
import java.util.List;

import veiculos.Automovel;
import veiculos.Veiculo.Acessorios;

public class PlanosAutomovel {
	
	private List<Automovel> listaAuto = new ArrayList<Automovel>();
	private List<Acessorios> listaAcessorios = new ArrayList<Acessorios>();
	private double preco;
	/**
	 * Construtor de um plano de automovel.
	 * @param preco - Recebe o preco em double diario da locacao
	 */
	public PlanosAutomovel(double preco){
		this.preco = preco;
	}
	/**
	 * Adiciona os acessorios que o plano contempla.
	 * @param item - Recebe o acessorio a ser adicionado no tipo Acessorios.
	 */
	public void adicionaAcessorios(Acessorios item){
		listaAcessorios.add(item);
	}
	/**
	 * Adiciona um carro ao plano de locacao
	 * @param carro - Recebe um carro 
	 * @throws Exception - Erro se o carro nao tiver os acessorios do plano
	 */
	public void adicionaCarro(Automovel carro)throws Exception{
		int tamanho = listaAcessorios.size();
		int acertos = 0;
		for (Acessorios item: carro.getOpcionais()){
			if(listaAcessorios.contains(item))
				acertos++;
		}
		if(tamanho != acertos)
			throw new Exception("O carro não atende as especicaçoes do plano");
		this.listaAuto.add(carro);
		
	}
	/**
	 * Remove o carro do plano
	 * @param carro - O carro a ser removido.
	 * @throws Exception - Erro se o carro nao existe no cadastro do plano.
	 */
	public void removeCarro(Automovel carro) throws Exception{
		if(!this.listaAuto.contains(carro)) {
			throw new Exception("Esse modelo nao se encontra na lista do plano.");
		} else {
			listaAuto.remove(carro);
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