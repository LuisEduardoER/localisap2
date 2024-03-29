/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clientes;

import java.io.Serializable;

/**
 *Classe abstrata Cliente
 * Gerencia dados comuns a PessoaFisica e PessoaJuridica
 *
 * @author Filipe Alencar   -twitter.com/filipealencar_
 * @author Felipe Jose      -twitter.com/felipejosefc
 * @author Emilio Farias    -twitter.com/militofarias
 *
 * http://code.google.com/p/localisap2/
 * Universidade Federal de Campina Grande - Computacao
 *
 */
public abstract class Cliente implements Serializable {

    private int quantidadeLocacao;
    private double divida = 0;
    private boolean emDebito = false;
    private Endereco endereco;
    private String telefone;
    private String email;
    private String nome;

    /**
     * Captura o Endereco
     * @return endereco
     */
    public Endereco getEndereco() {
        return endereco;
    }

    /**
     * Captura o Telefone
     * @return telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Captura o E-mail
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Captura o Nome do cliente
     * @return o nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Permite mudar o nome
     * @param nome - nome do Cliente
     * @throws Exception - erro de nome vazio
     */
    public void setNome(String nome) throws Exception {
        if (nome.length() == 0) {
            throw new Exception("O nome nao deve ser vazio");
        }
        this.nome = nome;

    }

    /**
     *  Permite mudar o Endereco
     * @param endereco
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;

    }

    /**
     * Permite mudar o Telefone
     * @param telefone
     * @throws Exception - Telefone invalido
     */
    public void setTelefone(String telefone) throws Exception {
        telefone = telefone.replace(".", "");
        if (telefone.length() < 10) {
            throw new Exception("Um telefone valido deve ter o DDD + o numero");
        }
        this.telefone = telefone;

    }

    /**
     * Permite mudar o Telefone
     * @param email
     * @throws Exception - Email digitado errado
     */
    public void setEmail(String email) throws Exception {
        if (!email.contains("@") || email.length() == 0) {
            throw new Exception("O email deve conter @ e ser maior que 3");
        }

        this.email = email;
    }

    /**
     * Metodo que permite alterar o status de debito do cliente
     * @param flag - True se o cliente estiver em debito , false caso contrario.
     */
    public void setEmDebito(boolean flag) {
        emDebito = flag;
    }

    /**
     * Metodo que retorna um boolean indiciando se o cliente tem algum debito .
     * @return - True se o cliente tem algum debito e false caso nao.
     */
    public Boolean getEmDebito() {
        return emDebito;
    }

    /**
     * Metodo que permite alterar o numero de locacoes que o cliente fez.
     * @param numero - Se o numero for 1 aumenta a locacao se for -1 diminui.
     */
    public void setQuantidadeLocacao(int numero) {
        if (numero == -1) {
            quantidadeLocacao--;
        }
        if (numero == 1) {
            quantidadeLocacao++;
        }
    }

    /**
     * Metodo que mostra a quantidade de locacoes que o cliente fez
     * @return - A quantidade de locacao.
     */
    public int getQuantidadeDeLocacao() {
        return quantidadeLocacao;
    }

    /**
     * Metodo que retorna o valor da divida do cliente.
     * @return - O valor da divida
     */
    public double getDivida() {
        return divida;
    }

    /**
     * Metodo que permite alterar o valor da divida
     * @param divida - Valor da divida.
     */
    public void setDivida(double divida) {
        this.divida = divida;
    }
}
