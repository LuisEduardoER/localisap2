package agencias;

import clientes.Cliente;
import clientes.Endereco;
import funcionarios.Gerente;
import funcionarios.Pessoa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import locacao.Locacao;
import planos.PlanoAutomovel;
import planos.PlanoMoto;
import veiculos.Veiculo;
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
public class Filial implements Serializable{
    private Gerente gerente;
    private String cnpj;
    Endereco endereco;
    private String telefone;
    private String inscEstadual;
    private int numeroDeLocacoes = 0;
    private int numeroDeClientes;
    private Collection<Veiculo> listaDeVeiculos = new ArrayList<Veiculo>();
    private Collection<PlanoAutomovel> listaDePlanosCarros = new ArrayList<PlanoAutomovel>();
    private Collection<PlanoMoto> listaDePlanosMoto = new ArrayList<PlanoMoto>();
    private Collection<Pessoa> listaDeFuncionarios = new ArrayList<Pessoa>();
    private Collection<Cliente> listaDeClientes = new ArrayList<Cliente>();
    private Collection<Locacao> listaDeLocacoes = new ArrayList<Locacao>();

    /**
     * Construtor que cria uma Agencia
     * @param cnpj - Recebe como String o cnpj
     * @param endereco
     * @param telefone - Recebe como String o telefone
     * @param inscEstadual - Recebe como String a inscricao estadual
     * @param gerenteResponsavel - Recebe como Gerente  o gerente responsavel pela adm da agencia
     */
    public Filial() {
        try {
            endereco = new Endereco(Endereco.UnidadeFederativa.PB, "Campina Grande", "Nacoes", "Essa daqui", 100, "58100000", "Aqui perto");
            String cnpj = "25.216.024/0001-03";
            String telefone = "0123456789";
            String inscEstadual = "0000";
            this.setCnpj(cnpj);
            this.setEndereco(endereco);
            this.setInscEstadual(inscEstadual);
            this.setTelefone(telefone);
            this.gerente = new Gerente();
        } catch (Exception e) {
        }
    }
    public Gerente getGerente(){
        return gerente;
    }
    /**
     * Metodo para capturar o CPNJ de uma agencia
     * @return - Em String o CPNJ
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * Metodo para capturar o Endereco de uma agencia
     * @return - Em endereco o Endereco
     */
    public Endereco getEndereco() {
        return endereco;
    }

    /**
     * Metodo para capturar o telefone de uma agencia
     * @return - Em String o telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Metodo para capturar a inscricao estadual de uma agencia
     * @return - Em String a inscricao estadual
     */
    public String getInscEstadual() {
        return inscEstadual;
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
     * Permite mudar o Endereco
     * @param endereco - Recebe como Endereco o endereco
     * @throws Exception
     */
    public void setEndereco(Endereco endereco) throws Exception {
        this.endereco = endereco;

    }

    /**
     * Permite mudar a inscricao estadual
     * @param inscricaoEstadual - Recebe como String a inscricao estadual
     */
    public void setInscEstadual(String inscricaoEstadual) throws Exception {
        if (inscricaoEstadual.length() == 0) {
            throw new Exception("A inscricao estadual nao deve ser vazio");
        }
        this.inscEstadual = inscricaoEstadual;

    }

    /**
     * Permite mudar o telefone
     * @param telefone - Recebe como String o telefone
     */
    public void setTelefone(String telefone) throws Exception {
        if (telefone.length() != 10) {
            throw new Exception("Um telefone valido deve ter o DDD + o numero");
        }
        this.telefone = telefone;

    }

    /**
     * Metodo que adiciona uma locacao
     * @param loc - Locacao
     */
    public void adicionaLocacao(Locacao loc) {
        listaDeLocacoes.add(loc);
    }

    /**
     * Metodo que adiciona veiculos
     * @param v - O veiculo
     */
    public void adicionaVeiculo(Veiculo v) {
        listaDeVeiculos.add(v);
    }

    /**
     * Metodo que adiciona um plano de automovel
     * @param p - O plano do automovel
     */
    public void adicionaPlanoAutomovel(PlanoAutomovel p) {
        listaDePlanosCarros.add(p);
    }

    /**
     * Metodo que adiciona um plano de moto
     * @param p - O plano da moto
     */
    public void adicionaPlanoMoto(PlanoMoto p) {
        listaDePlanosMoto.add(p);
    }

    /**
     * Metodo que adiciona um Funcionario
     * @param l - O  Funcionario
     */
    public void adicionaFuncionario(Pessoa l) {
        listaDeFuncionarios.add(l);
    }

    /**
     * Metodo que adiciona um cliente
     * @param c - O cliente
     */
    public void adicionaCliente(Cliente c) {
        listaDeClientes.add(c);
    }

    /**
     * Metodo que retorna o veiculo
     * @return - que retorna o veiculo
     */
    public Collection<Veiculo> getVeiculos() {
        return listaDeVeiculos;
    }

    /**
     * Metodo que retorna o plano do automovel
     *
     */
    public Collection<PlanoAutomovel> getPlanoAutomovel() {
        return listaDePlanosCarros;
    }

    /**
     * Metodo que retorna o plano de motos
     * @return - O plano de moto
     */
    public Collection<PlanoMoto> getPlanoMoto() {
        return listaDePlanosMoto;
    }

    /**
     * Metodo que retorna uma collection com os Funcionarioes
     * @return - Collection com os Funcionarioes
     */
    public Collection<Pessoa> getFuncionario() {
        return listaDeFuncionarios;
    }

    /**
     * Metodo que retorna uma collection com as locacoes
     * @return - Collection com as locacoes
     */
    public Collection<Locacao> getLocacao() {
        return listaDeLocacoes;
    }

    /**
     * Metodo que retorna uma collection com os clientes
     * @return - Collection com as pessoas fisicas
     */
    public Collection<Cliente> getClientes() {
        return listaDeClientes;
    }

    /**
     * Metodo que remove uma locacao
     * @param loc - a locacao a ser removida
     */
    public void removeLocacao(Locacao loc) {
        listaDeLocacoes.remove(loc);
    }

    /**
     * Metodo que remove um veiculo
     * @param v - o veiculo a ser removido
     */
    public void removeVeiculos(Veiculo v) {
        listaDeVeiculos.remove(v);
    }
    public void removeVeiculos(int index) {
        listaDeVeiculos.remove(listaDeVeiculos.toArray()[index]);
    }
    /**
     * Metodo que remove um plano de automovel
     * @param p - o plano a ser removido
     */
    public void removePlanoAutomovel(PlanoAutomovel p) {
        listaDePlanosCarros.remove(p);
    }

    /**
     * Metodo que remove um plano de moto
     * @param p - o plano a ser removido
     */
    public void removePlanoMoto(PlanoMoto p) {
        listaDePlanosMoto.remove(p);
    }

    /**
     * Metodo que remove um Funcionario
     * @param l - O Funcionario a ser removida
     */
    public void removeFuncionario(Pessoa l) {
        listaDeFuncionarios.remove(l);
    }
    public void removeFuncionario(int index) {
        listaDeFuncionarios.remove(listaDeFuncionarios.toArray()[index]);
    }

    /**
     * Metodo que remove uma pessoa fisica
     * @param pf - a pessoa fisica a ser removida
     */
    public void removeCliente(Cliente c) {
        listaDeClientes.remove(c);
    }

    /**
     * Metodo que remove uma pessoa fisica
     * @param pf - a pessoa fisica a ser removida
     */
    public void removeCliente(int index) {
        listaDeClientes.remove(listaDeClientes.toArray()[index]);
    }

}
