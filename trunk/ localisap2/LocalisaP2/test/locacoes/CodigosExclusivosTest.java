/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package locacoes;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Filipe
 */
public class CodigosExclusivosTest {
    CodigosExclusivos codigo;
    String codigo1;
    String codigo2;
    @Before
    public void setUp() {
        codigo = new CodigosExclusivos();
    }


    /**|
     * Teste do geraCodigoInternoDeArmazenamento metodo, da classe CodigosExclusivos.
     */
    @Test
    public void testGeraCodigoInternoDeArmazenamento() {
        System.out.println("geraCodigoInternoDeArmazenamento");
        int tamanho = 0;
        String expResult = "";
        String result = codigo.geraCodigoInternoDeArmazenamento(tamanho);
        System.out.println(result);
        assertEquals(expResult, result);
        codigo1 = codigo.geraCodigoInternoDeArmazenamento(5);
        codigo2 = codigo.geraCodigoInternoDeArmazenamento(5);
        System.out.println(codigo1);
        System.out.println(codigo2);
        assertNotSame(codigo1, codigo2);

    }

    /**
     * Teset do GeraCodigoBarras metodo, da classe CodigosExclusivos.
     */
    @Test
    public void testGeraCodigoBarras() {
        System.out.println("GeraCodigoBarras");
        String codigoUnico = codigo.geraCodigoInternoDeArmazenamento(10);
        codigo.GeraCodigoBarras(codigoUnico);
    }

}