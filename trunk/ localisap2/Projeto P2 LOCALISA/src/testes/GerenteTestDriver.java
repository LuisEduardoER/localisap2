/**
 * 
 */
package testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import funcionarios.Gerente;


/**
 * @author Filipe de Alencar Ramos
 *
 */
public class GerenteTestDriver {
	Gerente gerente;
	@Before
	public void inicio() throws Exception{
		gerente = new Gerente();
		gerente.setAgencia("agencia");
		gerente.setCPF("01234567891");
		gerente.setEmail("filipe@teste");
		gerente.setEndereco("endereco");
		gerente.setNascimento("11/10/1980");
		gerente.setNaturalidade("Paraiba");
		gerente.setNome("Filipe");
		gerente.setRG("123456");
		gerente.setTelefone("8333311111");
	}
	
	@Test
	public void testaMetodosGet(){
		Assert.assertEquals("01234567891",gerente.getCPF());
		Assert.assertEquals("agencia",gerente.getAgencia());
		Assert.assertEquals("filipe@teste",gerente.getEmail());
		Assert.assertEquals("endereco",gerente.getEndereco());
		Assert.assertEquals("11/10/1980",gerente.getNascimento());
		Assert.assertEquals("Paraiba",gerente.getNaturalidade());
		Assert.assertEquals("Filipe",gerente.getNome());
		Assert.assertEquals("123456",gerente.getRG());
		Assert.assertEquals("8333311111",gerente.getTelefone());
		
	}
/*
	@Test
	public void testaMetodosRemove(){
	gerente.removeAgencia();
		gerente.removeCPF();
		gerente.removeEmail();
		gerente.removeEndereco();
		gerente.removeNascimento();
		gerente.removeNaturalidade();
		gerente.removeNome();
		gerente.removeRG();
		gerente.removeTelefone();
		Assert.assertEquals(null,gerente.getCPF());
		Assert.assertEquals(null,gerente.getAgencia());
		Assert.assertEquals(null,gerente.getEmail());
		Assert.assertEquals(null,gerente.getEndereco());
		Assert.assertEquals(null,gerente.getNascimento());
		Assert.assertEquals(null,gerente.getNaturalidade());
		Assert.assertEquals(null,gerente.getNome());
		Assert.assertEquals(null,gerente.getRG());
		Assert.assertEquals(null,gerente.getTelefone());
	}
	*/
	@Test
	public void testaMetodosSet() throws Exception{
		gerente.setAgencia("agencia2");
		gerente.setCPF("01234567890");
		gerente.setEmail("filipe@teste2");
		gerente.setEndereco("endereco2");
		gerente.setNascimento("10/10/1980");
		gerente.setNaturalidade("Sao Paulo");
		gerente.setNome("Filipe A");
		gerente.setRG("1234567");
		gerente.setTelefone("8333312222");
		Assert.assertEquals("01234567890",gerente.getCPF());
		Assert.assertEquals("agencia2",gerente.getAgencia());
		Assert.assertEquals("filipe@teste2",gerente.getEmail());
		Assert.assertEquals("endereco2",gerente.getEndereco());
		Assert.assertEquals("10/10/1980",gerente.getNascimento());
		Assert.assertEquals("Sao Paulo",gerente.getNaturalidade());
		Assert.assertEquals("Filipe A",gerente.getNome());
		Assert.assertEquals("1234567",gerente.getRG());
		Assert.assertEquals("8333312222",gerente.getTelefone());
	}
}