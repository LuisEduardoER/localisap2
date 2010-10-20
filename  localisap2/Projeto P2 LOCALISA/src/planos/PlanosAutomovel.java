package planos;

import java.util.ArrayList;
import java.util.List;

import veiculos.Automovel;

public class PlanosAutomovel {
	
	List<Automovel> listaAuto = new ArrayList<Automovel>();
	private double preco;
	
	public PlanosAutomovel(double Preco){
		this.preco = preco;
	//terminar ainda..
	}
	
	public void adicionaCarro(Automovel carro){
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
	
	public double getPreco(double preco){
		return this.preco;
	}	
	
}