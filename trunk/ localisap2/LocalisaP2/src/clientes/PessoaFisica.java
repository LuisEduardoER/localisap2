package clientes;

import java.io.Serializable;
import verificacoes.Validacao;

/**
 *Classe PessoaFisica
 * herda da Classe abstrata Cliente
 * Gerencia dados inerentes ao cliente pessoa física
 *
 *
 * @author Filipe Alencar   -twitter.com/filipealencar_
 * @author Felipe Jose      -twitter.com/felipejosefc
 * @author Emilio Farias    -twitter.com/militofarias
 *
 * http://code.google.com/p/localisap2/
 * Universidade Federal de Campina Grande - Computacao
 *
 */
public class PessoaFisica extends Cliente{

    private String cpf;
    private String rg;
    private String nascimento;
    private String naturalidade;

    /**
     * Construtor que cria uma Pessoa Fisica.
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
    public PessoaFisica(String cpf, String nome, String rg, String nascimento, String naturalidade, Endereco endereco, String telefone, String email) throws Exception {
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
     * Construtor que cria uma Pessoa Fisica sem dados
     */
    public PessoaFisica() {
    }

    /**
     * Captura o Cpf
     * @return cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Captura o RG
     * @return rg
     */
    public String getRg() {
        return rg;
    }

    /**
     * Captura a data de Nascimento
     * @return nascimento
     */
    public String getNascimento() {
        return nascimento;
    }

    /**
     * Captura a cidade de origem
     * @return naturalidade
     */
    public String getNaturalidade() {
        return naturalidade;
    }

    /**
     * Edita o cpf
     * @param cpf
     * @throws Exception
     */
    public void setCpf(String cpf) throws Exception {
        Validacao testeCpf = new Validacao();
        if (!(testeCpf.validaCpf(cpf))) {
            throw new Exception("CPF invalido.");
        }
        this.cpf = cpf;

    }

    /**
     * Edita o rg
     * @param rg
     * @throws Exception
     */
    public void setRg(String rg) throws Exception {
        if (rg.length() == 0) {
            throw new Exception("O RG nao deve ser vazio");
        }
        this.rg = rg;
    }

    /**
     * Edita a data de nascimento
     * @param nascimento
     * @throws Exception
     */
    public void setNascimento(String nascimento) throws Exception {
        Validacao testaData = new Validacao();
        if (!(testaData.validaData(nascimento))) {
            throw new Exception("Data invalida");
        }
        this.nascimento = nascimento;

    }

    /**
     * Edita a cidade de origem
     * @param naturalidade
     * @throws Exception
     */
    public void setNaturalidade(String naturalidade) throws Exception {
        if (naturalidade.length() == 0) {
            throw new Exception("A naturalidade nao deve ser vazia");
        }
        this.naturalidade = naturalidade;

    }
}
