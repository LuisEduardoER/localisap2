/**
 * 
 */
package testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import agencias.Agencia;
import agencias.Filial;

import funcionarios.Gerente;
import funcionarios.Locador;


/**
 * @author Filipe de Alencar Ramos
 *
 */
public class LocadorTestDriver {
	Locador locador;
	Agencia filial1, filial2;
	Gerente gerente;
	@Before
	public void inicio() throws Exception{
		filial1 = new Filial("51851873000149", "Aqui em casa", "8333331234", "01234", gerente);
		filial2 = new Filial("58694458000178", "Lah no japao", "8300004321", "56789", gerente);
		locador = new Locador();
		locador.setAgencia(filial1);
		locador.setCpf("32456373570");
		locador.setEmail("filipe@teste");
		locador.setEndereco("endereco");
		locador.setNascimento("11/10/1980");
		locador.setNaturalidade("Paraiba");
		locador.setNome("Filipe");
		locador.setRg("123456");
		locador.setTelefone("8333311111");
	}
	
	@Test
	public void testaMetodosGet(){
		Assert.assertEquals("32456373570",locador.getCpf());
		Assert.assertEquals(filial1,locador.getAgencia());
		Assert.assertEquals("filipe@teste",locador.getEmail());
		Assert.assertEquals("endereco",locador.getEndereco());
		Assert.assertEquals("11/10/1980",locador.getNascimento());
		Assert.assertEquals("Paraiba",locador.getNaturalidade());
		Assert.assertEquals("Filipe",locador.getNome());
		Assert.assertEquals("123456",locador.getRg());
		Assert.assertEquals("8333311111",locador.getTelefone());
		
	}
/*
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
	*/
	@Test
	public void testaMetodosSet() throws Exception{
		locador.setAgencia(filial2);
		locador.setCpf("58548316780");
		locador.setEmail("filipe@teste2");
		locador.setEndereco("endereco2");
		locador.setNascimento("10/10/1980");
		locador.setNaturalidade("Sao Paulo");
		locador.setNome("Filipe A");
		locador.setRg("1234567");
		locador.setTelefone("8333312222");
		Assert.assertEquals("58548316780",locador.getCpf());
		Assert.assertEquals(filial2,locador.getAgencia());
		Assert.assertEquals("filipe@teste2",locador.getEmail());
		Assert.assertEquals("endereco2",locador.getEndereco());
		Assert.assertEquals("10/10/1980",locador.getNascimento());
		Assert.assertEquals("Sao Paulo",locador.getNaturalidade());
		Assert.assertEquals("Filipe A",locador.getNome());
		Assert.assertEquals("1234567",locador.getRg());
		Assert.assertEquals("8333312222",locador.getTelefone());
	}
}