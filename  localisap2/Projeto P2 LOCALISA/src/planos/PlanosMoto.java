package planos;

import java.util.ArrayList;
import java.util.List;

import veiculos.Motocicleta;

public class PlanosMoto {
	
	private List<Motocicleta> listaMoto = new ArrayList<Motocicleta>();
	private double preco;
	
	public PlanosMoto(double Preco){
		this.preco = preco;
	//terminar ainda...
	}
	
	public void adicionaMoto(Motocicleta moto){
		this.listaMoto.add(moto);
	}
	
	public void removeMoto(Motocicleta moto) throws Exception{
		if(!this.listaMoto.contains(moto)) {
			throw new Exception("Esse modelo nao se encontra na lista do plano.");
		} else {
			listaMoto.remove(moto);
		}
	}
	
	public void setPreco(double preco){
		this.preco = preco;
	}
	
	public double getPreco(double preco){
		return this.preco;
	}
	
	
}