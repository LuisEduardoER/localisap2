/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package locacao;

import clientes.Endereco;
import clientes.PessoaFisica;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import planos.PlanoAutomovel;
import veiculos.*;


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

public class PagarDebitoTest {

    Veiculo veicu;
    PessoaFisica pessoa1;
    Endereco endereco;
    PlanoAutomovel planoCarroA;
    Devolucao devolucao;
    Locacao loc;
    PagarDebito pd;

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
        devolucao = new Devolucao(loc,100,"01/10/2010",Problema.AMASSADOS_GRAVES);

    }

     @Test
    public void testGeral() {
        Assert.assertEquals(355.5, devolucao.getMultas(),0.001);
        devolucao.efetuaDevolucao();
        Assert.assertEquals(355.5, pessoa1.getDivida(), 0.001);
        pd = new PagarDebito(pessoa1);
        Assert.assertEquals(355.5, pd.getQuantoEstaDevendo(), 0.001);
        pd.saldarDividas();
        Assert.assertEquals(0, pd.getQuantoEstaDevendo(), 0.001);
    }

}