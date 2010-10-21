/**
 * 
 */
package testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import clientes.Endereco;

import agencias.Agencia;
import agencias.Filial;

import funcionarios.Gerente;


/**
 * @author Saci Perere
 *
 */
public class GerenteTestDriver {
	Gerente gerente;
	Agencia filial1, filial2;
	Endereco endereco, endereco2;
	@Before
	public void inicio() throws Exception{
		filial1 = new Filial("51851873000149", endereco, "8333331234", "01234", gerente);
		filial2 = new Filial("58694458000178", endereco, "8300004321", "56789", gerente);
		gerente = new Gerente();
		gerente.setAgencia(filial1);
		gerente.setCpf("03468137435");
		gerente.setEmail("filipe@teste");
		gerente.setEndereco(endereco2);
		gerente.setNascimento("11/10/1980");
		gerente.setNaturalidade("Paraiba");
		gerente.setNome("Filipe");
		gerente.setRg("123456");
		gerente.setTelefone("8333311111");
	}
	
	@Test
	public void testaMetodosGet(){
		Assert.assertEquals("03468137435",gerente.getCpf());
		Assert.assertEquals(filial1,gerente.getAgencia());
		Assert.assertEquals("filipe@teste",gerente.getEmail());
		Assert.assertEquals(endereco,gerente.getEndereco());
		Assert.assertEquals("11/10/1980",gerente.getNascimento());
		Assert.assertEquals("Paraiba",gerente.getNaturalidade());
		Assert.assertEquals("Filipe",gerente.getNome());
		Assert.assertEquals("123456",gerente.getRg());
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
		gerente.setAgencia(filial2);
		gerente.setCpf("58548316780");
		gerente.setEmail("filipe@teste2");
		gerente.setEndereco(endereco2);
		gerente.setNascimento("10/10/1980");
		gerente.setNaturalidade("Sao Paulo");
		gerente.setNome("Filipe A");
		gerente.setRg("1234567");
		gerente.setTelefone("8333312222");
		Assert.assertEquals("58548316780",gerente.getCpf());
		Assert.assertEquals(filial2,gerente.getAgencia());
		Assert.assertEquals("filipe@teste2",gerente.getEmail());
		Assert.assertEquals(endereco2,gerente.getEndereco());
		Assert.assertEquals("10/10/1980",gerente.getNascimento());
		Assert.assertEquals("Sao Paulo",gerente.getNaturalidade());
		Assert.assertEquals("Filipe A",gerente.getNome());
		Assert.assertEquals("1234567",gerente.getRg());
		Assert.assertEquals("8333312222",gerente.getTelefone());
	}
}