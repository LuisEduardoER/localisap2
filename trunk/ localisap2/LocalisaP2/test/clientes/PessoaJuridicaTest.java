package clientes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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

public class PessoaJuridicaTest {
	PessoaJuridica empresa;
	Endereco endereco, endereco2;

	@Before
	public void inicio() throws Exception{
		empresa = new PessoaJuridica();
		empresa.setRazaoSocial("LocaLisa");
		empresa.setCnpj("30851837000105");
		empresa.setEmail("filipe@teste");
		empresa.setEndereco(endereco);
		empresa.setInscricaoEstadual("123456");
		empresa.setTelefone("8333311111");
                empresa.setQuantidadeLocacao(1);
	}

	@Test
	public void testaMetodosGet(){
		Assert.assertEquals("30851837000105",empresa.getCnpj());
		Assert.assertEquals("LocaLisa",empresa.getRazaoSocial());
		Assert.assertEquals("filipe@teste",empresa.getEmail());
		Assert.assertEquals(endereco,empresa.getEndereco());
		Assert.assertEquals("123456",empresa.getInscricaoEstadual());
		Assert.assertEquals("8333311111",empresa.getTelefone());
                Assert.assertEquals(false, empresa.getEmDebito());
                Assert.assertEquals(1, empresa.getQuantidadeDeLocacao());

	}
	@Test
	public void testaMetodosSet() throws Exception{

            try{
                empresa.setRazaoSocial("");
                Assert.fail("Esperava excecao de setRazaoSocial");
            } catch (Exception ex){
                    Assert.assertEquals("erro", "A razao social nao deve ser vazio", ex.getMessage());
            }
            empresa.setRazaoSocial("agencia2");

            try{
                empresa.setCnpj("75416229000");
                Assert.fail("Esperava excecao de setCnpj");
            } catch (Exception ex){
                    Assert.assertEquals("erro", "Um cnpj valido deve ter 14 numeros", ex.getMessage());
            }

            empresa.setCnpj("75416229000100");

            try{
                empresa.setEmail("milito.teste");
                Assert.fail("Esperava excecao de setEmail");
            } catch (Exception ex){
                    Assert.assertEquals("erro", "O email deve conter @ e ser maior que 3", ex.getMessage());
            }
            empresa.setEmail("filipe@teste2");
            empresa.setEndereco(endereco2);

           try{
                empresa.setInscricaoEstadual("");
                Assert.fail("Esperava excecao de setInscricaoEstadual");
            } catch (Exception ex){
                    Assert.assertEquals("erro", "A inscricao estadual nao deve ser vazio", ex.getMessage());
            }
            empresa.setInscricaoEstadual("1234567");

            try {
                    empresa.setTelefone("123");
                    Assert.fail("Excecao de setTelefone esperada.");
                } catch (Exception ex){
                    Assert.assertEquals("erro", "Um telefone valido deve ter o DDD + o numero", ex.getMessage());
                }
            empresa.setTelefone("8333312222");            
            empresa.setEmDebito(true);
            empresa.setQuantidadeLocacao(1);
            empresa.setQuantidadeLocacao(1);
            empresa.setDivida(50);
            
            Assert.assertEquals("75416229000100",empresa.getCnpj());
            Assert.assertEquals("agencia2",empresa.getRazaoSocial());
            Assert.assertEquals("filipe@teste2",empresa.getEmail());
            Assert.assertEquals(endereco2,empresa.getEndereco());
            Assert.assertEquals("1234567",empresa.getInscricaoEstadual());
            Assert.assertEquals("8333312222",empresa.getTelefone());
            Assert.assertEquals(true, empresa.getEmDebito());
	}
}
