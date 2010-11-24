/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package locacao;

import clientes.Endereco;
import clientes.PessoaFisica;
import java.util.ArrayList;
import org.junit.Assert;
import veiculos.Acessorio;
import veiculos.Automovel;
import veiculos.Cor;
import veiculos.TipoDeCombustivel;
import veiculos.TipoDeFreio;
import veiculos.TipoDePotencia;
import veiculos.Veiculo;
import org.junit.Before;
import org.junit.Test;
import planos.PlanoAutomovel;


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

public class LocacaoTest {

    Locacao loc;
    Veiculo veicu;
    PessoaFisica pessoa1;
    Endereco endereco;
    PlanoAutomovel planoCarroA;

    @Before
    public void inicio() throws Exception {
        ArrayList<Acessorio> acessoriosOpcionais = new ArrayList<Acessorio>();
        pessoa1 = new PessoaFisica();
        pessoa1.setCpf("03468137435");
        pessoa1.setEmail("filipe@teste");
        pessoa1.setEndereco(endereco);
        pessoa1.setNascimento("11/10/1980");
        pessoa1.setNaturalidade("Paraiba");
        pessoa1.setNome("Filipe");
        pessoa1.setRg("123456");
        pessoa1.setTelefone("8333311111");
        planoCarroA = new PlanoAutomovel("PlanoA", 55);
        veicu = new Automovel("123", "Corsa", "Chevrolet", 90, 2009, Cor.PRETO, TipoDeFreio.TAMBOR, TipoDeCombustivel.FLEX, "23/10/2009", 80, acessoriosOpcionais, TipoDePotencia.HP);
        loc = new Locacao(veicu, pessoa1, planoCarroA, "22/09/2010", "30/09/2010", 10);
    }



    @Test
    public void testMetodosGet() {
        Assert.assertEquals(pessoa1, loc.getCliente());
        Assert.assertEquals(planoCarroA, loc.getPlano());
        Assert.assertEquals("30/09/2010", loc.getDataDevolucao());
        Assert.assertEquals("22/09/2010", loc.getDataEntrega());

        Double res = loc.diferencaData(loc.getDataEntrega(), loc.getDataDevolucao()) * planoCarroA.getPreco();
        Assert.assertEquals(440.0, res, 0.001);
        Assert.assertEquals(res, loc.getPrecoLocacao(), 0.001);

        Assert.assertEquals(80, loc.getNivelInicialTanque());
    }


   @Test
    public void testMetodosSet() throws Exception {
       try {
            loc.setDataEntrega("11/13/2010");
            Assert.fail("Esperava excecao de testaData");
       } catch(Exception ex) {
            Assert.assertEquals("erro", "Data invalida", ex.getMessage());
       }
       loc.setDataEntrega("12/12/2010");

       try {
            loc.setDataDevolucao("11/13/2010");
            Assert.fail("Esperava excecao de testaData");
       } catch(Exception ex) {
            Assert.assertEquals("erro", "Data invalida", ex.getMessage());
       }
       loc.setDataDevolucao("22/12/2010");

       Assert.assertEquals("22/12/2010", loc.getDataDevolucao());
       Assert.assertEquals("12/12/2010", loc.getDataEntrega());
    }

}