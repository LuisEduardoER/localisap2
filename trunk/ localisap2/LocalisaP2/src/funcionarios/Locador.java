/**
 *
 */
package funcionarios;

import clientes.Endereco;

/**
 *Classe Locador
 * Herda da classe abstrata PessoaAbstrata
 * Gerencia dados referentes ao funcionario locador
 *
 * @author Filipe Alencar   -twitter.com/filipealencar_
 * @author Felipe Jose      -twitter.com/felipejosefc
 * @author Emilio Farias    -twitter.com/militofarias
 *
 * http://code.google.com/p/localisap2/
 * Universidade Federal de Campina Grande - Computacao
 *
 */
public class Locador extends PessoaAbstrata {

    private String cpf;
    private String nome;
    private String rg;
    private String nascimento;
    private String naturalidade;
    private Endereco endereco;
    private String telefone;
    private String email;

    /**
     * Construtor que cria um locador.
     * @param cpf - Recebe como String o CPF
     * @param nome - Recebe como String o nome
     * @param rg - Recebe como String o rg
     * @param nascimento -  Recebe como String a data de nascimento
     * @param naturalidade - Recebe como String a naturalidade
     * @param endereco - Recebe como Endereco o endereco
     * @param telefone -  Recebe como String o telefone
     * @param email - Recebe como String o email
     * @throws Exception - Erros de parametros invalidos
     */
    public Locador(String cpf, String nome, String rg, String nascimento, String naturalidade, Endereco endereco, String telefone, String email) throws Exception {
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
     * Construtor que cria um locador sem dados
     */
    public Locador() {
    }
}
