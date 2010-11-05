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

public class EnderecoTest{

    	@Test
	public void testaConstrutor() throws Exception{
            try {
                Endereco endereco = new Endereco(Endereco.UnidadeFederativa.PB, "", "Nacoes", "Essa rua", 100, "58100000", "Aqui perto");
                Assert.fail("Excecao do construtor esperada.");
            } catch (Exception ex){
                Assert.assertEquals("erro", "Voce deve informar um nome de cidade valido.", ex.getMessage());
            }

            try {
                Endereco endereco = new Endereco(Endereco.UnidadeFederativa.PB, "Campina Grande", "", "Essa rua", 100, "58100000", "Aqui perto");
                Assert.fail("Excecao do construtor esperada.");
            } catch (Exception ex){
                Assert.assertEquals("erro", "Voce deve informar um bairro valido.", ex.getMessage());
            }

            try {
                Endereco endereco = new Endereco(Endereco.UnidadeFederativa.PB, "Campina Grande", "Nacoes", "", 100, "58100000", "Aqui perto");
                Assert.fail("Excecao do construtor esperada.");
            } catch (Exception ex){
                Assert.assertEquals("erro", "Voce deve informar uma rua valida.", ex.getMessage());
            }

            try {
                Endereco endereco = new Endereco(Endereco.UnidadeFederativa.PB, "Campina Grande", "Nacoes", "Essa daqui", 0, "58100000", "Aqui perto");
                Assert.fail("Excecao do construtor esperada.");
            } catch (Exception ex){
                Assert.assertEquals("erro", "Voce deve informar um numero valido.", ex.getMessage());
            }

            try {
                Endereco endereco = new Endereco(Endereco.UnidadeFederativa.PB, "Campina Grande", "Nacoes", "Essa daqui", 100, "58100", "Aqui perto");
                Assert.fail("Excecao do construtor esperada.");
            } catch (Exception ex){
                Assert.assertEquals("erro", "Voce deve informar um cep valido.", ex.getMessage());
            }
        }

        @Test
	public void testaMetodosGet() throws Exception{
            Endereco endereco = new Endereco(Endereco.UnidadeFederativa.PB, "Campina Grande", "Nacoes", "Essa daqui", 100, "58100000", "Aqui perto");

            Assert.assertEquals(Endereco.UnidadeFederativa.PB, endereco.getEstado());
            Assert.assertEquals("Campina Grande", endereco.getCidade());
            Assert.assertEquals("Nacoes", endereco.getBairro());
            Assert.assertEquals("Essa daqui", endereco.getRua());
            Assert.assertEquals(100, endereco.getNumero());
            Assert.assertEquals("58100000", endereco.getCep());
            Assert.assertEquals("Aqui perto", endereco.getPontoDeReferencia());
        }

        @Test
	public void testaMetodosSet() throws Exception{
            Endereco endereco = new Endereco(Endereco.UnidadeFederativa.PB, "Campina Grande", "Nacoes", "Essa daqui", 100, "58100000", "Aqui perto");

            endereco.setEstado(Endereco.UnidadeFederativa.PE);
            Assert.assertEquals(Endereco.UnidadeFederativa.PE, endereco.getEstado());

           try {
                endereco.setCidade("");
                Assert.fail("Excecao do metodo esperada.");
            } catch (Exception ex){
                Assert.assertEquals("erro", "Voce deve informar um nome de cidade valido.", ex.getMessage());
            }
            endereco.setCidade("Recife");
            Assert.assertEquals("Recife", endereco.getCidade());

            try {
                endereco.setBairro("");
                Assert.fail("Excecao do metodo esperada.");
            } catch (Exception ex){
                Assert.assertEquals("erro", "Voce deve informar um bairro valido.", ex.getMessage());
            }
            endereco.setBairro("Boa Viagem");
            Assert.assertEquals("Boa Viagem", endereco.getBairro());
 
            try {
                endereco.setRua("");
                Assert.fail("Excecao do metodo esperada.");
            } catch (Exception ex){
                Assert.assertEquals("erro", "Voce deve informar uma rua valida.", ex.getMessage());
            }
            endereco.setBairro("Rua das Flores");
            Assert.assertEquals("Rua das Flores", endereco.getBairro());

            try {
                endereco.setNumero(-1);
                Assert.fail("Excecao do metodo esperada.");
            } catch (Exception ex){
                Assert.assertEquals("erro", "Voce deve informar um numero valido.", ex.getMessage());
            }
            endereco.setNumero(10);
            Assert.assertEquals(10, endereco.getNumero());

            try {
                endereco.setCep("");
                Assert.fail("Excecao do metodo esperada.");
            } catch (Exception ex){
                Assert.assertEquals("erro", "Voce deve informar um cep valido.", ex.getMessage());
            }
            endereco.setCep("12345678");
            Assert.assertEquals("12345678", endereco.getCep());

            try {
                endereco.setPontoDeReferencia("");
                Assert.fail("Excecao do metodo esperada.");
            } catch (Exception ex){
                Assert.assertEquals("erro", "Voce deve informar algo!", ex.getMessage());
            }
            endereco.setPontoDeReferencia("Por ai");
            Assert.assertEquals("Por ai", endereco.getPontoDeReferencia());
        }

}