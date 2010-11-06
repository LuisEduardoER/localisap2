/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package locacao;

import clientes.Endereco;
import clientes.PessoaFisica;
import java.util.ArrayList;
import veiculos.Acessorios;
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
 * @author filipe
 */
public class DevolverTest {

    Locacao loc;
    Veiculo veicu;
    PessoaFisica pessoa1;
    Endereco endereco;
    PlanoAutomovel planoCarroA;
    Devolver devolucao;
    @Before
    public void inicio() throws Exception {
        ArrayList<Acessorios> acessoriosOpcionais = new ArrayList<Acessorios>();
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
        devolucao = new Devolver(loc,100,"01/10/2010",Problemas.AMASSADOS_GRAVES);
    }



    @Test
    public void testGetMultas() {
        assertEquals(355.5, devolucao.getMultas(),0.001);
    }

    @Test
    public void testDiferencaData() {
        assertEquals(8, devolucao.diferencaData("22/09/2010", "30/09/2010"));
    }
}
