/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionarios;

/**
 *
 * @author Filipe
 */
public class Usuario {

    private String login;
    private String senha;
    private String email;

    /**
     * Controi um usuario do sistema
     *
     * @param String email - Recebe o email do usuario
     * @param String login - Recebe o login do usuario
     * @param String senha - Recebe a senha do usuario
     * @throws Exception login - O login deve ter mais de 4 digitos
     * @throws Exception senha - A senha deve ter mais de 4 digitos.
     * @throws Exception email - Erro de email invalido , ou seja com tamanho menor que 3 e sem a presenca de @.
     *
     */
    public Usuario(String email, String login, String senha) throws Exception {
        setLogin(login);
        setSenha(senha);
        setEmail(email);
    }

    /**
     * Consulta login do usuario
     * @return String login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Metodo que permite mudar o login
     * @param String login - O login do usuario.
     * @throws Exception - O login deve ter mais de 4 digitos
     */
    public void setLogin(String login) throws Exception {
        if (login == null || login.length() < 5) {
            throw new Exception("O login deve ter mais que 4 caracteres");
        }


        this.login = login;
    }

    /**
     * Captura a senha
     * @return String senha - Retorna a Senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Metodo que permite mudar a senha
     * @param String senha - A senha do usuario
     * @throws Exception -A senha deve ter mais de 4 digitos.
     */
    public void setSenha(String senha) throws Exception {
        if (senha.length() < 5 || senha == null) {
            throw new Exception("A senha deve ter mais de 4 caracteres");
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
            throw new Exception("O email deve conter @ e ser maior que 3");
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
