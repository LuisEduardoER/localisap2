package planos;


import agencias.Filial;
import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import veiculos.Acessorio;

import veiculos.Automovel;
import veiculos.Cor;
import veiculos.Motocicleta;
import veiculos.TipoDeCombustivel;
import veiculos.TipoDeFreio;
import veiculos.TipoDePotencia;

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

public class PlanoTest {

	PlanoAutomovel planoCarroA, planoCarroB;
	PlanoMoto planoMotoA, planoMotoB;
	Automovel carro;
	Motocicleta moto;
	ArrayList<Acessorio> acessoriosOpcionais = new ArrayList<Acessorio>();
	Filial centro, agencia;


	@Before
	public void inicio() throws Exception {
		carro = new Automovel("123","Corsa","Chevrolet",90,2009, Cor.PRETO,TipoDeFreio.TAMBOR,TipoDeCombustivel.FLEX,"23/10/2009",80,acessoriosOpcionais, TipoDePotencia.HP);
		moto = new Motocicleta("renavam", "modelo", "marca", TipoDePotencia.HP, 1000, 500, 2000, Cor.PRETO, TipoDeCombustivel.GASOLINA,  "27/11/2000",100);
		planoCarroA = new PlanoAutomovel("PlanoA", 55);
		planoCarroB = new PlanoAutomovel("PlanoB", 60);
		planoMotoA = new PlanoMoto("PlanoA", 25);
		planoMotoB = new PlanoMoto("PlanoB", 30);
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
