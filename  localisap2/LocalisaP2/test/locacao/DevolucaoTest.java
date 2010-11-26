/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package locacao;

import org.junit.Assert;
import clientes.Endereco;
import clientes.PessoaFisica;
import java.util.ArrayList;
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
import static org.junit.Assert.*;

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

public class DevolucaoTest {

    Locacao loc;
    Veiculo veicu;
    PessoaFisica pessoa1;
    Endereco endereco;
    PlanoAutomovel planoCarroA;
    Devolucao devolucao;
    ArrayList<Problema> problemas;
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
        devolucao = new Devolucao(loc,100,"01/10/2010",problemas);
    }



    @Test
    public void testGetMultas() {
        assertEquals(355.5, devolucao.getMultas(),0.001);
    }

    @Test
    public void testDiferencaData() {
        assertEquals(8, devolucao.diferencaData("22/09/2010", "30/09/2010"));
    }

    @Test
    public void testMetodosSet() throws Exception {
        try {
            devolucao.setDataEntrega("11/13/2010");
            Assert.fail("Esperava excecao de testaData");
       } catch(Exception ex) {
            Assert.assertEquals("erro", "Data invalida", ex.getMessage());
       }
       devolucao.setDataEntrega("12/12/2010");

       try {
            devolucao.setDataDevolucao("11/13/2010");
            Assert.fail("Esperava excecao de testaData");
       } catch(Exception ex) {
            Assert.assertEquals("erro", "Data invalida", ex.getMessage());
       }
       devolucao.setDataDevolucao("22/12/2010");

       Assert.assertEquals("22/12/2010", devolucao.getDataDevolucao());
       Assert.assertEquals("12/12/2010", devolucao.getDataEntrega());
    }

}