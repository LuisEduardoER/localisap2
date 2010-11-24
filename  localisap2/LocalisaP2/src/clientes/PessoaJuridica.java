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
public class PessoaJuridica extends Cliente{

    private String cnpj;
    private String razaoSocial;
    private String inscricaoEstadual;


    /**
     * Construtor que cria uma Pessoa Juridca.
     * @param cnpj - Recebe como String o cnpj
     * @param razaoSocial - Recebe como String a razao social
     * @param nomeFantasia - Recebe como String o nome Fantasia
     * @param inscricaoEstadual -  Recebe como String a inscricao estadual
     * @param endereco - Recebe como Endereco o endereco
     * @param telefone -  Recebe como String o telefone
     * @param email - Recebe como String o email
     * @throws Exception - Erros de parametros invalidos
     */
    public PessoaJuridica(String cnpj, String razaoSocial, String nomeFantasia, String inscricaoEstadual, Endereco endereco, String telefone, String email) throws Exception {
        setEmail(email);
        setEndereco(endereco);
        setInscricaoEstadual(inscricaoEstadual);
        setNome(nomeFantasia);
        setRazaoSocial(razaoSocial);
        setTelefone(telefone);
        setCnpj(cnpj);
    }

    public PessoaJuridica() {
    }
 
    /**
     * Metodo para capturar o CPNJ de uma pessoa juridica
     * @return - Em String o CPNJ
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * Metodo para capturar a razao social de uma pessoa juridica
     * @return - Em String a razao social
     */
    public String getRazaoSocial() {
        return razaoSocial;
    }


    /**
     * Metodo para capturar a inscricao estadual de uma pessoa juridica
     * @return - Em String a inscricao estadual
     */
    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }


    /**
     * Permite mudar o CPNJ
     * @param CPNJ - Recebe como String o CPNJ
     * @throws Exception - Erro de cpf invalido
     */
    public void setCnpj(String cnpj) throws Exception {
        Validacao testeCpnj = new Validacao();
        if (!(testeCpnj.validaCnpj(cnpj))) {
            throw new Exception("Um cnpj valido deve ter 14 numeros");
        }
        this.cnpj = cnpj;

    }

    /**
     * Permite mudar a razao social
     * @param razaoSocial - Recebe como String a razao social
     */
    public void setRazaoSocial(String razaoSocial) throws Exception {
        if (razaoSocial.length() == 0) {
            throw new Exception("A razao social nao deve ser vazio");
        }
        this.razaoSocial = razaoSocial;

    }

    /**
     * Permite mudar a inscricao estadual
     * @param inscricaoEstadual - Recebe como String a inscricao estadual
     */
    public void setInscricaoEstadual(String inscricaoEstadual) throws Exception {
        if (inscricaoEstadual.length() == 0) {
            throw new Exception("A inscricao estadual nao deve ser vazio");
        }
        this.inscricaoEstadual = inscricaoEstadual;

    }
}
