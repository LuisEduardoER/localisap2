package planos;

import java.util.ArrayList;
import java.util.List;

import veiculos.Automovel;
import veiculos.Veiculo.Acessorios;

public class PlanosAutomovel {
	
	private List<Automovel> listaAuto = new ArrayList<Automovel>();
	private List<Acessorios> listaAcessorios = new ArrayList<Acessorios>();

	private double preco;
	
	public PlanosAutomovel(double preco){
		this.preco = preco;
	}
	public void adicionaAcessorios(Acessorios item){
		listaAcessorios.add(item);
	}
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
	
	public void removeCarro(Automovel carro) throws Exception{
		if(!this.listaAuto.contains(carro)) {
			throw new Exception("Esse modelo nao se encontra na lista do plano.");
		} else {
			listaAuto.remove(carro);
		}
	}
	
	public void setPreco(double preco){
		this.preco = preco;
	}
	
	public double getPreco(){
		return this.preco;
	}	
	
}