/**
 *
 */
package clientes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import agencias.Filial;

import funcionarios.Gerente;


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

public class PessoaFisicaTest{
	PessoaFisica pessoa1;
	Filial filial1, filial2;
	Gerente gerente;
	Endereco endereco, endereco2;

	@Before
	public void inicio() throws Exception{
		filial1 = new Filial();
		filial2 = new Filial();
		pessoa1 = new PessoaFisica();
		pessoa1.setCpf("03468137435");
		pessoa1.setEmail("filipe@teste");
		pessoa1.setEndereco(endereco2);
		pessoa1.setNascimento("11/10/1980");
		pessoa1.setNaturalidade("Paraiba");
		pessoa1.setNome("Filipe");
		pessoa1.setRg("123456");
		pessoa1.setTelefone("8333311111");
	}

	@Test
	public void testaMetodosGet(){
		Assert.assertEquals("03468137435",pessoa1.getCpf());
		Assert.assertEquals("filipe@teste",pessoa1.getEmail());
		Assert.assertEquals(endereco2,pessoa1.getEndereco());
		Assert.assertEquals("11/10/1980",pessoa1.getNascimento());
		Assert.assertEquals("Paraiba",pessoa1.getNaturalidade());
		Assert.assertEquals("Filipe",pessoa1.getNome());
		Assert.assertEquals("123456",pessoa1.getRg());
		Assert.assertEquals("8333311111",pessoa1.getTelefone());
                Assert.assertEquals(false, pessoa1.getEmDebito());

	}

	@Test
	public void testaMetodosSet() throws Exception{
		
		pessoa1.setCpf("01234567890");
		pessoa1.setEmail("filipe@teste2");
		pessoa1.setEndereco(endereco);
		pessoa1.setNascimento("10/10/1980");
		pessoa1.setNaturalidade("Sao Paulo");
		pessoa1.setNome("Filipe A");
		pessoa1.setRg("1234567");
		pessoa1.setTelefone("8333312222");
                pessoa1.setEmDebito(true);
		Assert.assertEquals("01234567890",pessoa1.getCpf());
		Assert.assertEquals("filipe@teste2",pessoa1.getEmail());
		Assert.assertEquals(endereco,pessoa1.getEndereco());
		Assert.assertEquals("10/10/1980",pessoa1.getNascimento());
		Assert.assertEquals("Sao Paulo",pessoa1.getNaturalidade());
		Assert.assertEquals("Filipe A",pessoa1.getNome());
		Assert.assertEquals("1234567",pessoa1.getRg());
		Assert.assertEquals("8333312222",pessoa1.getTelefone());
                Assert.assertEquals(true, pessoa1.getEmDebito());
	}
}
