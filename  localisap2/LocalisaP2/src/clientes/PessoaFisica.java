package clientes;

import java.io.Serializable;
import verificacoes.Validacao;

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
public class PessoaFisica extends Cliente{

    private String cpf;
    private String nome;
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
    }

    public PessoaFisica() {
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getRg() {
        return rg;
    }

    public String getNascimento() {
        return nascimento;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setCpf(String cpf) throws Exception {
        Validacao testeCpf = new Validacao();
        if (!(testeCpf.validaCpf(cpf))) {
            throw new Exception("CPF invalido.");
        }
        this.cpf = cpf;

    }

    public void setNome(String nome) throws Exception {
        if (nome.length() == 0) {
            throw new Exception("O nome nao deve ser vazio");
        }
        this.nome = nome;

    }

    public void setRg(String rg) throws Exception {
        if (rg.length() == 0) {
            throw new Exception("O RG nao deve ser vazio");
        }
        this.rg = rg;
    }

    public void setNascimento(String nascimento) throws Exception {
        Validacao testaData = new Validacao();
        if (!(testaData.validaData(nascimento))) {
            throw new Exception("Data invalida");
        }
        this.nascimento = nascimento;

    }

    public void setNaturalidade(String naturalidade) throws Exception {
        if (naturalidade.length() == 0) {
            throw new Exception("A naturalidade nao deve ser vazia");
        }
        this.naturalidade = naturalidade;

    }
}
