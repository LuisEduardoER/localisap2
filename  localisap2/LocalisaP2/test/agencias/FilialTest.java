///**
// *
// */
//package agencias;
//
//import junit.framework.Assert;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import clientes.Endereco;
//import funcionarios.Gerente;
//
//
///**
//*
//* @author Filipe Alencar   -twitter.com/filipealencar_
//* @author Felipe Jose      -twitter.com/felipejosefc
//* @author Emilio Farias    -twitter.com/militofarias
//*
//* http://code.google.com/p/localisap2/
//* Universidade Federal de Campina Grande - Computacao
//*
//*/
//public class FilialTest {
//
//	Filial filial1, filial2;
//	Gerente gerente;
//	Endereco endereco, endereco2;
//
//	@Before
//	public void inicio() throws Exception{
//		filial1 = new Filial("51851873000149", endereco, "8333331234", "01234", gerente);
//	}
//
//	@Test
//	public void testaMetodosGet(){
//		Assert.assertEquals("51851873000149", filial1.getCnpj());
//		Assert.assertEquals(endereco, filial1.getEndereco());
//		Assert.assertEquals("8333331234", filial1.getTelefone());
//		Assert.assertEquals("01234", filial1.getInscEstadual());
//		Assert.assertEquals(gerente, filial1.getGerenteResponsavel());
//	}
//
//	@Test
//	public void testaMetodosSet() throws Exception{
//		try {
//			filial1.setCnpj("1234");
//                        Assert.fail("Esperava excecao de setCnpj");
//		} catch (Exception ex){
//			Assert.assertEquals("erro", "Um cnpj valido deve ter 14 numeros", ex.getMessage());
//		}
//
//		filial1.setCnpj("58694458000178");
//		filial1.setEndereco(endereco2);
//
//                try {
//                    filial1.setTelefone("123");
//                    Assert.fail("Excecao de setTelefone esperada.");
//                } catch (Exception ex){
//                    Assert.assertEquals("erro", "Um telefone valido deve ter o DD + o numero", ex.getMessage());
//                }
//
//		filial1.setTelefone("8300004321");
//
//                try {
//                    filial1.setInscEstadual("");
//                    Assert.fail("Excecao de setInscEstadual esperada");
//                } catch (Exception ex) {
//                    Assert.assertEquals("erro", "A inscricao estadual nao deve ser vazio", ex.getMessage());
//                }
//
//		filial1.setInscEstadual("56789");
//
//		Assert.assertEquals("58694458000178", filial1.getCnpj());
//		Assert.assertEquals(endereco2, filial1.getEndereco());
//		Assert.assertEquals("8300004321", filial1.getTelefone());
//		Assert.assertEquals("56789", filial1.getInscEstadual());
//	}
//
//
//}
