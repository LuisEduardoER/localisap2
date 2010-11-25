/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionarios;

/**
* Classe Usuario
* Responsavel pelo login no sistema
 *
* @author Filipe Alencar   -twitter.com/filipealencar_
* @author Felipe Jose      -twitter.com/felipejosefc
* @author Emilio Farias    -twitter.com/militofarias
*
* http://code.google.com/p/localisap2/
* Universidade Federal de Campina Grande - Computacao
*
*/
public class Usuario {

    private String login;
    private String senha;
    private String email;

    /**
     * Controi um usuario do sistema
     *
     * @param email - Recebe o email do usuario
     * @param login - Recebe o login do usuario
     * @param senha - Recebe a senha do usuario
     * @throws Exception 
     *
     */
    public Usuario(String email, String login, String senha) throws Exception {
        setLogin(login);
        setSenha(senha);
        setEmail(email);
    }

    /**
     * Consulta login do usuario
     * @return login - Retorna o login do usuario.
     */
    public String getLogin() {
        return login;
    }

    /**
     * Metodo que permite mudar o login
     * @param login - O login do usuario.
     * @throws Exception - O login deve ter mais de 4 digitos
     */
    public void setLogin(String login) throws Exception {
        if (login == null || login.length() < 5) {
            throw new Exception("O login deve ter mais que 4 caracteres.");
        }


        this.login = login;
    }

    /**
     * Captura a senha
     * @return senha - Retorna a Senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Metodo que permite mudar a senha
     * @param senha - A senha do usuario
     * @throws Exception -A senha deve ter mais de 4 digitos.
     */
    public void setSenha(String senha) throws Exception {
        if (senha.length() < 5 || senha == null) {
            throw new Exception("A senha deve ter mais de 4 caracteres.");
        }
        this.senha = senha;
    }

    /**
     * Permite mudar o email
     * @param email - Recebe como String o email
     * @throws Exception - Erro de email invalido , ou seja com tamanho menor que 3 e sem a presenca de @.
     */
    public void setEmail(String email) throws Exception {
        if (!email.contains("@") || email.length() == 0) {
            throw new Exception("O email deve conter @ e ter mais que 3 caracteres.");
        }

        this.email = email;
    }

    /**
     * Metodo para capturar o email de uma pessoa
     * @return - Em String o email
     */
    public String getEmail() {
        return email;
    }
}
