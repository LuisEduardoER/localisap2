package veiculos;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import agencias.Filial;




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
public class MotocicletaTest {
	Motocicleta moto;
	Filial agencia, agencia2;

	@Before
	public void inicio() throws Exception{
		moto = new Motocicleta("renavam", "modelo", "marca", TipoDePotencia.HP, TipoDeFreio.DISCO, 1000, 500, 2000, Cor.PRETO, TipoDeCombustivel.GASOLINA,  "27/11/2000",100);
	}

	@Test
	public void testaMetodosGet(){
		Assert.assertEquals("renavam", moto.getRenavam());
		Assert.assertEquals("modelo", moto.getModelo());
		Assert.assertEquals("marca", moto.getMarca());
		Assert.assertEquals(TipoDePotencia.HP, moto.getTipoDePotencia());
		Assert.assertEquals(1000, moto.getPotencia());
		Assert.assertEquals(500, moto.getCilindradas());
		Assert.assertEquals(2000, moto.getAno());
		Assert.assertEquals(Cor.PRETO, moto.getCor());
		Assert.assertEquals(TipoDeCombustivel.GASOLINA, moto.getTipoDeCombustivel());
		Assert.assertEquals("27/11/2000", moto.getDataDeAquisicao());
		Assert.assertEquals(100, moto.getNivelDoTanque());
	}

	@Test
	public void testaMetodosSet() throws Exception{
		moto.setRenavam("NovoRenavam");
		moto.setModelo("NovoModelo");
		moto.setMarca("NovaMarca");
		moto.setTipoDePotencia(TipoDePotencia.CV);
		moto.setPotencia(1500);
		moto.setCilindradas(1000);
		moto.setAno(2005);
		moto.setCor(Cor.BRANCO);
		moto.setTipoDeCombustivel(TipoDeCombustivel.FLEX);
		moto.setDataDeAquisicao("10/10/2005");
		moto.setNivelDoTanque(0);

		Assert.assertEquals("NovoRenavam", moto.getRenavam());
		Assert.assertEquals("NovoModelo", moto.getModelo());
		Assert.assertEquals("NovaMarca", moto.getMarca());
		Assert.assertEquals(TipoDePotencia.CV, moto.getTipoDePotencia());
		Assert.assertEquals(1500, moto.getPotencia());
		Assert.assertEquals(1000, moto.getCilindradas());
		Assert.assertEquals(2005, moto.getAno());
		Assert.assertEquals(Cor.BRANCO, moto.getCor());
		Assert.assertEquals(TipoDeCombustivel.FLEX, moto.getTipoDeCombustivel());
		Assert.assertEquals("10/10/2005", moto.getDataDeAquisicao());
		Assert.assertEquals(0, moto.getNivelDoTanque());
	}
}
