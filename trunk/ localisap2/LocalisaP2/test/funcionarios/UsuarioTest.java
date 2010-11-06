/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionarios;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author filipe
 */
public class UsuarioTest {

    Usuario user;

    @Before
    public void inicio() throws Exception {
        user = new Usuario("filipe@msn.com", "filipe","senha");
    }

    @Test
    public void testSetGetLogin() throws Exception {
        user.setLogin("Filipe");
        assertEquals("Filipe", user.getLogin());
    }

    @Test
    public void testSetGetSenha() throws Exception {
        user.setSenha("12345");
        assertEquals("12345", user.getSenha());

    }

    @Test
    public void testSetGetEmail() throws Exception {
        user.setEmail("filipe@msn.com");
        assertEquals("filipe@msn.com", user.getEmail());
    }
}
