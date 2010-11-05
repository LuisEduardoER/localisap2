package clientes;

import funcionarios.Pessoa;
import funcionarios.PessoaAbstrata;
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
public class PessoaFisica extends PessoaAbstrata implements Serializable {

    private String cpf;
    private String nome;
    private String rg;
    private String nascimento;
    private String naturalidade;
    private Endereco endereco;
    private String telefone;
    private String email;
    private String codigoDaPessoaFisica;
    private int quantidadeLocacao;
    private Boolean emDebito = false;

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

    public PessoaFisica() {
    }

    public Boolean emDebito() {
        return emDebito;
    }

    /**
     * Metodo que captura o codigo exclusivo.
     * @return - O codigo exclusivo
     */
    public String getCodigoExclusivo() {
        return codigoDaPessoaFisica;
    }

    public void locacao(int numero) {
        if (numero == -1) {
            quantidadeLocacao--;
        }
        if (numero == 1) {
            quantidadeLocacao++;
        }
    }
}
