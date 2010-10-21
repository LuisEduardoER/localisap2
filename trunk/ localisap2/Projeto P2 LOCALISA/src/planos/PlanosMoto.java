package planos;
import java.util.ArrayList;
import java.util.List;

import veiculos.Motocicleta;
import veiculos.Veiculo.Acessorios;

public class PlanosMoto {
	
	private List<Motocicleta> listaMoto = new ArrayList<Motocicleta>();
	private int cilindradas;
	private double preco;
	
	public PlanosMoto(double preco){
		this.preco = preco;
	}
	public void adicionaCilindradas(int cilindradas){
		this.cilindradas = cilindradas;
	}
	
	public void adicionaMoto(Motocicleta moto)throws Exception{
		if (moto.getCilindradas()>cilindradas)
			throw new Exception("A moto não atende as especicaçoes do plano");
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
	
	public double getPreco(){
		return this.preco;
	}
	
	
}