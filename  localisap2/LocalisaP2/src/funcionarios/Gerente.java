/**
 *
 */
package funcionarios;

import clientes.Endereco;

/**
 *Classe Gerente
 * Herda da classe abstrata PessoaAbstrata
 * Gerencia dados referentes ao funcionario gerente
 *
 * @author Filipe Alencar   -twitter.com/filipealencar_
 * @author Felipe Jose      -twitter.com/felipejosefc
 * @author Emilio Farias    -twitter.com/militofarias
 *
 * http://code.google.com/p/localisap2/
 * Universidade Federal de Campina Grande - Computacao
 *
 */
public class Gerente extends PessoaAbstrata {

    /**
     * Construtor que cria um gerente.
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
    public Gerente(String cpf, String nome, String rg, String nascimento, String naturalidade, Endereco endereco, String telefone, String email) throws Exception {
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
     * Construtor que cria um gerente com dados default
     *
     * @throws Exception - Erro proveniente dos Sets
     */
    public Gerente() throws Exception {
        Endereco endereco = new Endereco(Endereco.UnidadeFederativa.PB, "Campina Grande", "Nacoes", "Essa daqui", 100, "58100-000", "Aqui perto");
        setCpf("587.672.837-30");
        setEmail("gerente@localisa.com");
        setEndereco(endereco);
        setNascimento("27/12/1980");
        setNaturalidade("Paraiba");
        setNome("Gerente Padrao");
        setRg("123456");
        setTelefone("(83)3333-3333");
    }
}
