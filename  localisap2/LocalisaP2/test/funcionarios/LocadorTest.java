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
public class LocadorTest {
	Locador locador;
	Gerente gerente;
	Endereco endereco, endereco2;
	@Before
	public void inicio() throws Exception{

		locador = new Locador();

		locador.setCpf("32456373570");
		locador.setEmail("filipe@teste");
		locador.setEndereco(endereco2);
		locador.setNascimento("11/10/1980");
		locador.setNaturalidade("Paraiba");
		locador.setNome("Filipe");
		locador.setRg("123456");
		locador.setTelefone("8333311111");
	}

	@Test
	public void testaMetodosGet(){
		Assert.assertEquals("32456373570",locador.getCpf());

		Assert.assertEquals("filipe@teste",locador.getEmail());
		Assert.assertEquals(endereco2,locador.getEndereco());
		Assert.assertEquals("11/10/1980",locador.getNascimento());
		Assert.assertEquals("Paraiba",locador.getNaturalidade());
		Assert.assertEquals("Filipe",locador.getNome());
		Assert.assertEquals("123456",locador.getRg());
		Assert.assertEquals("8333311111",locador.getTelefone());

	}

	@Test
	public void testaMetodosSet() throws Exception{

		locador.setCpf("58548316780");
		locador.setEmail("filipe@teste2");
		locador.setEndereco(endereco);
		locador.setNascimento("10/10/1980");
		locador.setNaturalidade("Sao Paulo");
		locador.setNome("Filipe A");
		locador.setRg("1234567");
		locador.setTelefone("8333312222");
		Assert.assertEquals("58548316780",locador.getCpf());

		Assert.assertEquals("filipe@teste2",locador.getEmail());
		Assert.assertEquals(endereco,locador.getEndereco());
		Assert.assertEquals("10/10/1980",locador.getNascimento());
		Assert.assertEquals("Sao Paulo",locador.getNaturalidade());
		Assert.assertEquals("Filipe A",locador.getNome());
		Assert.assertEquals("1234567",locador.getRg());
		Assert.assertEquals("8333312222",locador.getTelefone());
	}
}