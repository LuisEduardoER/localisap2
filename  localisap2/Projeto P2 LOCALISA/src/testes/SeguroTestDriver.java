package testes;


import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import planos.*;
import seguro.Seguro;

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


public class SeguroTestDriver {

	PlanosAutomovel planoA;
	PlanosMoto planoB;	
	Seguro seguroA1;
	Seguro seguroA2;
	Seguro seguroB1;
	Seguro seguroB2;
	
	@Before
	public void inicio() throws Exception {
		planoA = new PlanosAutomovel("Plano A", 55.00);
		planoB = new PlanosMoto("Plano B", 35.00);
		
		seguroA1 = new Seguro(true, planoA);
		seguroA2 = new Seguro(false, planoA);
		seguroB1 = new Seguro(true, planoB);
		seguroB2 = new Seguro(false, planoB);
	}
	
	@Test
	public void testaSeguro() {
		Assert.assertEquals(82.5, seguroA1.getPrecoDoSeguro(),0.001);
		Assert.assertEquals(68.75, seguroA2.getPrecoDoSeguro(),0.001);
		Assert.assertEquals(52.5, seguroB1.getPrecoDoSeguro(),0.001);
		Assert.assertEquals(43.75, seguroB2.getPrecoDoSeguro(),0.001);
		
	}

}
