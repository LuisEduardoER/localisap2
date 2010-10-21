/**
 * 
 */
package testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import clientes.Endereco;
import clientes.PessoaJuridica;


/**
 * @author Coelho da Pascoa
 *
 */
public class PessoaJuridicaTestDriver {
	PessoaJuridica empresa;
	Endereco endereco, endereco2;
	
	@Before
	public void inicio() throws Exception{
		empresa = new PessoaJuridica();
		empresa.setRazaoSocial("LocaLisa");
		empresa.setCnpj("30851837000105");
		empresa.setEmail("filipe@teste");
		empresa.setEndereco(endereco);
		empresa.setNomeFantasia("Fantasia");
		empresa.setInscricaoEstadual("123456");
		empresa.setTelefone("8333311111");
	}
	
	@Test
	public void testaMetodosGet(){
		Assert.assertEquals("30851837000105",empresa.getCnpj());
		Assert.assertEquals("LocaLisa",empresa.getRazaoSocial());
		Assert.assertEquals("filipe@teste",empresa.getEmail());
		Assert.assertEquals("endereco",empresa.getEndereco());
		Assert.assertEquals("Fantasia",empresa.getNomeFantasia());
		Assert.assertEquals("123456",empresa.getInscricaoEstadual());
		Assert.assertEquals("8333311111",empresa.getTelefone());
		
	}
	@Test
	public void testaMetodosSet() throws Exception{
		empresa.setRazaoSocial("agencia2");
		empresa.setCnpj("75416229000100");
		empresa.setEmail("filipe@teste2");
		empresa.setEndereco(endereco2);
		empresa.setNomeFantasia("Filipe A");
		empresa.setInscricaoEstadual("1234567");
		empresa.setTelefone("8333312222");
		Assert.assertEquals("75416229000100",empresa.getCnpj());
		Assert.assertEquals("agencia2",empresa.getRazaoSocial());
		Assert.assertEquals("filipe@teste2",empresa.getEmail());
		Assert.assertEquals(endereco2,empresa.getEndereco());
		Assert.assertEquals("Filipe A",empresa.getNomeFantasia());
		Assert.assertEquals("1234567",empresa.getInscricaoEstadual());
		Assert.assertEquals("8333312222",empresa.getTelefone());
	}
}
