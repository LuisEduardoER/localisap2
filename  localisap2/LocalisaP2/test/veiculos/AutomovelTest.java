package veiculos;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import agencias.Filial;

import veiculos.Veiculo.Acessorios;
import veiculos.Veiculo.Cor;
import veiculos.Veiculo.TipoDeCombustivel;
import veiculos.Veiculo.TipoDeFreio;
import veiculos.Veiculo.TipoDePotencia;

import clientes.Endereco;



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
public class AutomovelTest {
	Automovel carro;
	Filial centro;
	Filial interior;
	Endereco endereco, endereco2;
	ArrayList<Acessorios> acessoriosOpcionais = new ArrayList<Acessorios>();

	@Before
	public void inicio() throws Exception{
		carro = new Automovel("123","Corsa","Chevrolet",90,2009, Cor.PRETO,TipoDeFreio.TAMBOR,TipoDeCombustivel.FLEX,centro,"23/10/2009",80,acessoriosOpcionais, TipoDePotencia.HP);
	}

	@Test
	public void testaMetodosGet(){
		Assert.assertEquals(2009,carro.getAno());
		Assert.assertEquals(Cor.PRETO,carro.getCor());
		Assert.assertEquals(2009,carro.getAno());
		Assert.assertEquals("123",carro.getRenavam());
		Assert.assertEquals("23/10/2009",carro.getDataDeAquisicao());
		Assert.assertEquals(centro,carro.getLocalizacao());
		Assert.assertEquals("Chevrolet",carro.getMarca());
		Assert.assertEquals("Corsa",carro.getModelo());
		Assert.assertEquals(80,carro.getNivelDoTanque());
		Assert.assertEquals(acessoriosOpcionais,carro.getOpcionais());
		Assert.assertEquals(90,carro.getPotencia());
		Assert.assertEquals(TipoDeCombustivel.FLEX,carro.getTipoDeCombustivel());
		Assert.assertEquals(TipoDeFreio.TAMBOR,carro.getTipoDeFreios());
		Assert.assertEquals(TipoDePotencia.HP,carro.getTipoDePotencia());

	}
	@Test
	public void testaMetodosSet() throws Exception{
		carro.setAno(1950);
		carro.setCor(Cor.AMARELO);
		carro.setDataDeAquisicao("21/10/1980");
		carro.setLocalizacao(interior);
		carro.setMarca("Chevrolet1");
		carro.setModelo("Chevet");
		carro.setNivelDoTanque(0);
		carro.setPotencia(30);
		carro.setRenavam("1111");
		carro.setTipoDeCombustivel(TipoDeCombustivel.ALCOOL);
		carro.setTipoDeFreios(TipoDeFreio.TAMBOR);
		carro.setTipoDePotencia(TipoDePotencia.HP);



		Assert.assertEquals(1950,carro.getAno());
		Assert.assertEquals(Cor.AMARELO,carro.getCor());
		Assert.assertEquals(1950,carro.getAno());
		Assert.assertEquals("1111",carro.getRenavam());
		Assert.assertEquals("21/10/1980",carro.getDataDeAquisicao());
		Assert.assertEquals(interior,carro.getLocalizacao());
		Assert.assertEquals("Chevrolet1",carro.getMarca());
		Assert.assertEquals("Chevet",carro.getModelo());
		Assert.assertEquals(0,carro.getNivelDoTanque());
		Assert.assertEquals(30,carro.getPotencia());
		Assert.assertEquals(TipoDeCombustivel.ALCOOL,carro.getTipoDeCombustivel());
		Assert.assertEquals(TipoDeFreio.TAMBOR,carro.getTipoDeFreios());
		Assert.assertEquals(TipoDePotencia.HP,carro.getTipoDePotencia());
	}
}
