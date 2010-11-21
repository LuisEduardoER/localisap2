package funcionarios;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
public class SegurancaTest {
	Seguranca seguranca;
	Gerente gerente;
	Endereco endereco, endereco2;

	@Before
	public void inicio() throws Exception{

		seguranca = new Seguranca();
		seguranca.setCpf("32456373570");
		seguranca.setEmail("filipe@teste");
		seguranca.setEndereco(endereco2);
		seguranca.setNascimento("11/10/1980");
		seguranca.setNaturalidade("Paraiba");
		seguranca.setNome("Filipe");
		seguranca.setRg("123456");
		seguranca.setTelefone("8333311111");
	}

	@Test
	public void testaMetodosGet(){
		Assert.assertEquals("32456373570",seguranca.getCpf());
		Assert.assertEquals("filipe@teste",seguranca.getEmail());
		Assert.assertEquals(endereco2,seguranca.getEndereco());
		Assert.assertEquals("11/10/1980",seguranca.getNascimento());
		Assert.assertEquals("Paraiba",seguranca.getNaturalidade());
		Assert.assertEquals("Filipe",seguranca.getNome());
		Assert.assertEquals("123456",seguranca.getRg());
		Assert.assertEquals("8333311111",seguranca.getTelefone());

	}

	@Test
	public void testaMetodosSet() throws Exception{
		seguranca.setCpf("58548316780");
		seguranca.setEmail("filipe@teste2");
		seguranca.setEndereco(endereco);
		seguranca.setNascimento("10/10/1980");
		seguranca.setNaturalidade("Sao Paulo");
		seguranca.setNome("Filipe A");
		seguranca.setRg("1234567");
		seguranca.setTelefone("8333312222");
		Assert.assertEquals("58548316780",seguranca.getCpf());
		Assert.assertEquals("filipe@teste2",seguranca.getEmail());
		Assert.assertEquals(endereco,seguranca.getEndereco());
		Assert.assertEquals("10/10/1980",seguranca.getNascimento());
		Assert.assertEquals("Sao Paulo",seguranca.getNaturalidade());
		Assert.assertEquals("Filipe A",seguranca.getNome());
		Assert.assertEquals("1234567",seguranca.getRg());
		Assert.assertEquals("8333312222",seguranca.getTelefone());
	}
}
