/**
 * 
 */
package testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import agencias.Agencia;
import agencias.Filial;

import clientes.Endereco;
import clientes.PessoaFisica;
import funcionarios.Gerente;


/**
 * @author Pinoquio
 *
 */
public class PessoaFisicaTestDriver {
	PessoaFisica pessoa1;
	Agencia filial1, filial2;
	Gerente gerente;
	Endereco endereco, endereco2;
	
	@Before
	public void inicio() throws Exception{
		filial1 = new Filial("51851873000149", endereco, "8333331234", "01234", gerente);
		filial2 = new Filial("58694458000178", endereco2, "8300004321", "56789", gerente);
		pessoa1 = new PessoaFisica();
		//pessoa1.setAgencia(filial1);
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
		//Assert.assertEquals("agencia",pessoa1.getAgencia());
		Assert.assertEquals("filipe@teste",pessoa1.getEmail());
		Assert.assertEquals(endereco2,pessoa1.getEndereco());
		Assert.assertEquals("11/10/1980",pessoa1.getNascimento());
		Assert.assertEquals("Paraiba",pessoa1.getNaturalidade());
		Assert.assertEquals("Filipe",pessoa1.getNome());
		Assert.assertEquals("123456",pessoa1.getRg());
		Assert.assertEquals("8333311111",pessoa1.getTelefone());
		
	}
	/*
	@Test
	public void testaMetodosRemove(){
		pessoa1.removeAgencia();
		pessoa1.removeCPF();
		pessoa1.removeEmail();
		pessoa1.removeEndereco();
		pessoa1.removeNascimento();
		pessoa1.removeNaturalidade();
		pessoa1.removeNome();
		pessoa1.removeRG();
		pessoa1.removeTelefone();
		Assert.assertEquals(null,pessoa1.getCPF());
		Assert.assertEquals(null,pessoa1.getAgencia());
		Assert.assertEquals(null,pessoa1.getEmail());
		Assert.assertEquals(null,pessoa1.getEndereco());
		Assert.assertEquals(null,pessoa1.getNascimento());
		Assert.assertEquals(null,pessoa1.getNaturalidade());
		Assert.assertEquals(null,pessoa1.getNome());
		Assert.assertEquals(null,pessoa1.getRG());
		Assert.assertEquals(null,pessoa1.getTelefone());
	}
	*/
	@Test
	public void testaMetodosSet() throws Exception{
		//pessoa1.setAgencia("agencia2");
		pessoa1.setCpf("01234567890");
		pessoa1.setEmail("filipe@teste2");
		pessoa1.setEndereco(endereco);
		pessoa1.setNascimento("10/10/1980");
		pessoa1.setNaturalidade("Sao Paulo");
		pessoa1.setNome("Filipe A");
		pessoa1.setRg("1234567");
		pessoa1.setTelefone("8333312222");
		Assert.assertEquals("01234567890",pessoa1.getCpf());
		//Assert.assertEquals("agencia2",pessoa1.getAgencia());
		Assert.assertEquals("filipe@teste2",pessoa1.getEmail());
		Assert.assertEquals(endereco,pessoa1.getEndereco());
		Assert.assertEquals("10/10/1980",pessoa1.getNascimento());
		Assert.assertEquals("Sao Paulo",pessoa1.getNaturalidade());
		Assert.assertEquals("Filipe A",pessoa1.getNome());
		Assert.assertEquals("1234567",pessoa1.getRg());
		Assert.assertEquals("8333312222",pessoa1.getTelefone());
	}
}
