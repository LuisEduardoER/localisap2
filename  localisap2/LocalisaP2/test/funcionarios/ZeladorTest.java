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
public class ZeladorTest {
	Zelador zelador;
	Gerente gerente;
	Endereco endereco, endereco2;
	@Before
	public void inicio() throws Exception{

		zelador = new Zelador();
		zelador.setCpf("32456373570");
		zelador.setEmail("filipe@teste");
		zelador.setEndereco(endereco2);
		zelador.setNascimento("11/10/1980");
		zelador.setNaturalidade("Paraiba");
		zelador.setNome("Filipe");
		zelador.setRg("123456");
		zelador.setTelefone("8333311111");
	}

	@Test
	public void testaMetodosGet(){
		Assert.assertEquals("32456373570",zelador.getCpf());
		Assert.assertEquals("filipe@teste",zelador.getEmail());
		Assert.assertEquals(endereco2,zelador.getEndereco());
		Assert.assertEquals("11/10/1980",zelador.getNascimento());
		Assert.assertEquals("Paraiba",zelador.getNaturalidade());
		Assert.assertEquals("Filipe",zelador.getNome());
		Assert.assertEquals("123456",zelador.getRg());
		Assert.assertEquals("8333311111",zelador.getTelefone());

	}

	@Test
	public void testaMetodosSet() throws Exception{
		zelador.setCpf("58548316780");
		zelador.setEmail("filipe@teste2");
		zelador.setEndereco(endereco);
		zelador.setNascimento("10/10/1980");
		zelador.setNaturalidade("Sao Paulo");
		zelador.setNome("Filipe A");
		zelador.setRg("1234567");
		zelador.setTelefone("8333312222");
		Assert.assertEquals("58548316780",zelador.getCpf());
		Assert.assertEquals("filipe@teste2",zelador.getEmail());
		Assert.assertEquals(endereco,zelador.getEndereco());
		Assert.assertEquals("10/10/1980",zelador.getNascimento());
		Assert.assertEquals("Sao Paulo",zelador.getNaturalidade());
		Assert.assertEquals("Filipe A",zelador.getNome());
		Assert.assertEquals("1234567",zelador.getRg());
		Assert.assertEquals("8333312222",zelador.getTelefone());
	}
}
