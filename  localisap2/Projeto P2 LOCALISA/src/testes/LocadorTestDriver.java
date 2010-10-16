/**
 * 
 */
package testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import funcionarios.Locador;


/**
 * @author Filipe de Alencar Ramos
 *
 */
public class LocadorTestDriver {
	Locador locador;
	@Before
	public void inicio(){
		locador = new Locador();
		locador.setAgencia("agencia");
		locador.setCPF("0123456789");
		locador.setEmail("filipe@teste");
		locador.setEndereco("endereco");
		locador.setNascimento("11/10/1980");
		locador.setNaturalidade("Paraiba");
		locador.setNome("Filipe");
		locador.setRG("123456");
		locador.setTelefone("8333311111");
	}
	
	@Test
	public void testaMetodosGet(){
		Assert.assertEquals("0123456789",locador.getCPF());
		Assert.assertEquals("agencia",locador.getAgencia());
		Assert.assertEquals("filipe@teste",locador.getEmail());
		Assert.assertEquals("endereco",locador.getEndereco());
		Assert.assertEquals("11/10/1980",locador.getNascimento());
		Assert.assertEquals("Paraiba",locador.getNaturalidade());
		Assert.assertEquals("Filipe",locador.getNome());
		Assert.assertEquals("123456",locador.getRG());
		Assert.assertEquals("8333311111",locador.getTelefone());
		
	}
	@Test
	public void testaMetodosRemove(){
		locador.removeAgencia();
		locador.removeCPF();
		locador.removeEmail();
		locador.removeEndereco();
		locador.removeNascimento();
		locador.removeNaturalidade();
		locador.removeNome();
		locador.removeRG();
		locador.removeTelefone();
		Assert.assertEquals(null,locador.getCPF());
		Assert.assertEquals(null,locador.getAgencia());
		Assert.assertEquals(null,locador.getEmail());
		Assert.assertEquals(null,locador.getEndereco());
		Assert.assertEquals(null,locador.getNascimento());
		Assert.assertEquals(null,locador.getNaturalidade());
		Assert.assertEquals(null,locador.getNome());
		Assert.assertEquals(null,locador.getRG());
		Assert.assertEquals(null,locador.getTelefone());
	}
	@Test
	public void testaMetodosSet(){
		locador.setAgencia("agencia2");
		locador.setCPF("01234567890");
		locador.setEmail("filipe@teste2");
		locador.setEndereco("endereco2");
		locador.setNascimento("10/10/1980");
		locador.setNaturalidade("Sao Paulo");
		locador.setNome("Filipe A");
		locador.setRG("1234567");
		locador.setTelefone("8333312222");
		Assert.assertEquals("01234567890",locador.getCPF());
		Assert.assertEquals("agencia2",locador.getAgencia());
		Assert.assertEquals("filipe@teste2",locador.getEmail());
		Assert.assertEquals("endereco2",locador.getEndereco());
		Assert.assertEquals("10/10/1980",locador.getNascimento());
		Assert.assertEquals("Sao Paulo",locador.getNaturalidade());
		Assert.assertEquals("Filipe A",locador.getNome());
		Assert.assertEquals("1234567",locador.getRG());
		Assert.assertEquals("8333312222",locador.getTelefone());
	}
}
