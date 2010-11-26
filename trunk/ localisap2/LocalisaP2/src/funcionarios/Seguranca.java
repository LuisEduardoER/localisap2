/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionarios;

import clientes.Endereco;

/**
 * Classe Seguranca
 * Herda da classe abstrata PessoaAbstrata
 * Gerencia dados referentes ao funcionario seguranca
 *
 * @author Filipe Alencar   -twitter.com/filipealencar_
 * @author Felipe Jose      -twitter.com/felipejosefc
 * @author Emilio Farias    -twitter.com/militofarias
 *
 * http://code.google.com/p/localisap2/
 * Universidade Federal de Campina Grande - Computacao
 *
 */
public class Seguranca extends PessoaAbstrata {

    /**
     * Construtor que cria um Seguranca
     * 
     * @param cpf
     * @param nome
     * @param rg
     * @param nascimento
     * @param naturalidade
     * @param endereco
     * @param telefone
     * @param email
     * @throws Exception
     */
    public Seguranca(String cpf, String nome, String rg, String nascimento, String naturalidade, Endereco endereco, String telefone, String email) throws Exception {
        setCpf(cpf);
        setEmail(email);
        setEndereco(endereco);
        setNascimento(nascimento);
        setNaturalidade(naturalidade);
        setNome(nome);
        setRg(rg);
        setTelefone(telefone);
    }

    /**
     * Construtor que cria um Seguranca sem dados
     */
    public Seguranca() {
    }
}
