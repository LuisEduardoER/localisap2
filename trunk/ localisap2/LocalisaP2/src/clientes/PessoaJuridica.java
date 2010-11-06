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
public class PessoaJuridica implements Serializable {

    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    private String inscricaoEstadual;
    private Endereco endereco;
    private String telefone;
    private String email;
    private String codigoDaPessoaJuridica;
    private int quantidadeLocacao;
    private Boolean emDebito = false;
    private double divida=0;

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
        setNomeFantasia(nomeFantasia);
        setRazaoSocial(razaoSocial);
        setTelefone(telefone);
        setCnpj(cnpj);
    }

    public PessoaJuridica() {
    }

    public Boolean getEmDebito(){
        return emDebito;
    }
    /**
     * Metodo que captura o codigo exclusivo.
     * @return - O codigo exclusivo
     */
    public String getCodigoExclusivo() {
        return codigoDaPessoaJuridica;
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
     * Metodo para capturar o nome fantasia de uma pessoa juridica
     * @return - Em String o nome fantasia
     */
    public String getNomeFantasia() {
        return nomeFantasia;
    }

    /**
     * Metodo para capturar a inscricao estadual de uma pessoa juridica
     * @return - Em String a inscricao estadual
     */
    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    /**
     * Metodo para capturar o endereco de uma pessoa juridica
     * @return - Em String o endereco
     */
    public Endereco getEndereco() {
        return endereco;
    }

    /**
     * Metodo para capturar o telefone de uma pessoa juridica
     * @return - Em String o telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Metodo para capturar o email de uma pessoa juridica
     * @return - Em String o email
     */
    public String getEmail() {
        return email;
    }

    public void setEmDebito(Boolean flag) {
        emDebito = flag;
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
     * Permite mudar o nome fantasia
     * @param nomeFantasia - Recebe como String o nome fantasia
     */
    public void setNomeFantasia(String nomeFantasia) throws Exception {
        if (nomeFantasia.length() == 0) {
            throw new Exception("O nome Fantasia nao deve ser vazio");
        }
        this.nomeFantasia = nomeFantasia;

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

    /**
     * Permite mudar o endereco
     * @param endereco - Recebe como String o endereco
     */
    public void setEndereco(Endereco endereco) throws Exception {
        this.endereco = endereco;

    }

    /**
     * Permite mudar o telefone
     * @param telefone - Recebe como String o telefone
     */
    public void setTelefone(String telefone) throws Exception {
        if (telefone.length() != 10) {
            throw new Exception("Um telefone valido deve ter o DD + o numero");
        }
        this.telefone = telefone;

    }

    /**
     * Permite mudar o email
     * @param nome - Recebe como String o email
     */
    public void setEmail(String email) throws Exception {
        if (!email.contains("@") || email.length() == 0) {
            throw new Exception("O email deve conter @ e ser maior que 3");
        }

        this.email = email;
    }

    public void locacao(int numero) {
        if (numero == -1) {
            quantidadeLocacao--;
        }
        if (numero == 1) {
            quantidadeLocacao++;
        }
    }
    public int getQuantidadeDeLocacao(){
        return quantidadeLocacao;
    }
    public double getDivida(){
        return divida;
    }
    public void setDivida(double divida){
        this.divida=divida;
    }
}
