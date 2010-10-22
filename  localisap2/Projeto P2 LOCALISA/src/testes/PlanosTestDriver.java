package testes;


import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import agencias.Agencia;

import planos.PlanosAutomovel;
import planos.PlanosMoto;
import veiculos.Automovel;
import veiculos.Motocicleta;
import veiculos.Veiculo.Acessorios;
import veiculos.Veiculo.Cor;
import veiculos.Veiculo.TipoDeCombustivel;
import veiculos.Veiculo.TipoDeFreio;
import veiculos.Veiculo.TipoDePotencia;

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

public class PlanosTestDriver {

	PlanosAutomovel planoCarroA, planoCarroB;
	PlanosMoto planoMotoA, planoMotoB;
	Automovel carro;
	Motocicleta moto;
	ArrayList<Acessorios> acessoriosOpcionais = new ArrayList<Acessorios>();
	Agencia centro, agencia;
	
	
	@Before
	public void inicio() throws Exception {
		carro = new Automovel("123","Corsa","Chevrolet",90,2009, Cor.PRETO,TipoDeFreio.TAMBOR,TipoDeCombustivel.FLEX,centro,"23/10/2009",80,acessoriosOpcionais, TipoDePotencia.HP);
		moto = new Motocicleta("renavam", "modelo", "marca", TipoDePotencia.HP, 1000, 500, 2000, Cor.PRETO, TipoDeCombustivel.GASOLINA, agencia, "27/11/2000",100);
		planoCarroA = new PlanosAutomovel("PlanoA", 55);
		planoCarroB = new PlanosAutomovel("PlanoB", 60);
		planoMotoA = new PlanosMoto("PlanoA", 25);
		planoMotoB = new PlanosMoto("PlanoB", 30);
		planoMotoA.adicionaCilindradas(550);
		planoMotoB.adicionaCilindradas(500);
	}
	
	@Test
	public void testaAdicionaRemove() throws Exception{
		planoCarroA.adicionaCarro(carro);
		planoCarroB.adicionaCarro(carro);
		planoMotoA.adicionaMoto(moto);
		planoMotoB.adicionaMoto(moto);
		Assert.assertTrue(planoCarroA.getListaAutomovel().contains(carro));
		Assert.assertTrue(planoCarroB.getListaAutomovel().contains(carro));
		Assert.assertTrue(planoMotoA.getListaMoto().contains(moto));
		Assert.assertTrue(planoMotoB.getListaMoto().contains(moto));
		planoCarroA.removeCarro(carro);
		planoMotoA.removeMoto(moto);
		Assert.assertTrue(planoCarroA.getListaAutomovel().isEmpty());
		Assert.assertTrue(planoMotoA.getListaMoto().isEmpty());
	}
	
	@Test
	public void testaMetodos() {
		Assert.assertEquals("PlanoA", planoCarroA.getNome() );
		Assert.assertEquals("PlanoB", planoMotoB.getNome() );
		Assert.assertEquals(55.0, planoCarroA.getPreco() );
		Assert.assertEquals(30.0, planoMotoB.getPreco() );
	}
}
