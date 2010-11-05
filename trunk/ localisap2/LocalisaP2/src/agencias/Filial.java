package agencias;

import clientes.Endereco;
import funcionarios.Gerente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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

	private String cnpj;
	private Endereco endereco;
	private String telefone;
	private String inscEstadual;
	private Gerente gerenteResponsavel;
        private List<Veiculo> listaDeVeiculos;
	/**
	 * Construtor que cria uma Agencia
	 * @param cnpj - Recebe como String o cnpj
	 * @param endereco
	 * @param telefone - Recebe como String o telefone
	 * @param inscEstadual - Recebe como String a inscricao estadual
	 * @param gerenteResponsavel - Recebe como Gerente  o gerente responsavel pela adm da agencia
	 * @throws Exception - Erros de parametros errados vide sets.
	 */
	public Filial(String cnpj, Endereco endereco, String telefone, String inscEstadual, Gerente gerenteResponsavel) throws Exception{
		this.setCnpj(cnpj);
		this.setEndereco(endereco);
		this.setGerenteResponsavel(gerenteResponsavel);
		this.setInscEstadual(inscEstadual);
		this.setTelefone(telefone);
                listaDeVeiculos = new ArrayList<Veiculo>();
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
	 * Metodo para capturar o gerente de uma agencia
	 * @return - Em Gerente o gerente de uma agencia
	 */
	public Gerente getGerenteResponsavel() {
		return gerenteResponsavel;
	}
	/**
	 * Permite mudar o CPNJ
	 * @param CPNJ - Recebe como String o CPNJ
	 * @throws Exception - Erro de cpf invalido
	 */
	public void setCnpj(String cnpj) throws Exception {
		Validacao testeCpnj = new Validacao();
		if(!(testeCpnj.validaCnpj(cnpj)))
			throw new Exception("Um cnpj valido deve ter 14 numeros");
		this.cnpj = cnpj;

	}
	/**
	 * Permite mudar o Endereco
	 * @param endereco - Recebe como Endereco o endereco
	 * @throws Exception
	 */
	public void setEndereco(Endereco endereco) throws Exception{
		this.endereco = endereco;

	}
	/**
	 * Permite mudar a inscricao estadual
	 * @param inscricaoEstadual - Recebe como String a inscricao estadual
	 */
	public void setInscEstadual(String inscricaoEstadual)throws Exception {
		if(inscricaoEstadual.length()==0){
			throw new Exception("A inscricao estadual nao deve ser vazio");
		}
		this.inscEstadual = inscricaoEstadual;

	}
	/**
	 * Permite mudar o telefone
	 * @param telefone - Recebe como String o telefone
	 */
	public void setTelefone(String telefone)throws Exception {
		if(telefone.length()!= 10)
			throw new Exception("Um telefone valido deve ter o DD + o numero");
		this.telefone = telefone;

	}
	/**
	 * Permite mudar o gerente responsavel
	 * @param gerente - Recebe como Gerente o gerente responsavel
	 */
	public void setGerenteResponsavel(Gerente gerente){
		this.gerenteResponsavel = gerente;

	}

        /**
         * Adiciona um automovel a lista de automoveis da filial.
         * @param Automovel a
         */
        public void adicionarAutomovel(Veiculo a){
            listaDeVeiculos.add(a);
        }

        /**
         * Retorna a lista de automoveis da filial.
         * @return List<Automovel>
         */
        public List<Veiculo> getListaDeAutomoveis(){
            return listaDeVeiculos;
        }

        /**
         * Remove um automovel da lista de automoveis da filial.
         * @param Automovel a
         * @return Verdadeiro, caso o automovel exista e seja apagado com sucesso ou false, caso contrario.
         */
        public boolean removerAutomovel(Veiculo a){
            if (!(listaDeVeiculos.contains(a)))
                return false;
            else{
                listaDeVeiculos.remove(a);
                return true;
            }
        }

}