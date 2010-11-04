package agencias;

import clientes.Endereco;
import funcionarios.Gerente;
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

public class Filial{

	private String cnpj;
	private Endereco endereco;
	private String telefone;
	private String inscEstadual;
	private Gerente gerenteResponsavel;
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
		}

	public String getCnpj() {
		return cnpj;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getInscEstadual() {
		return inscEstadual;
	}

	public Gerente getGerenteResponsavel() {
		return gerenteResponsavel;
	}

	public void setCnpj(String cnpj) throws Exception {
		Validacao testeCpnj = new Validacao();
		if(!(testeCpnj.validaCnpj(cnpj)))
			throw new Exception("Um cnpj valido deve ter 14 numeros");
		this.cnpj = cnpj;

	}

	public void setEndereco(Endereco endereco) throws Exception{
		this.endereco = endereco;

	}

	public void setInscEstadual(String inscricaoEstadual)throws Exception {
		if(inscricaoEstadual.length()==0){
			throw new Exception("A inscricao estadual nao deve ser vazio");
		}
		this.inscEstadual = inscricaoEstadual;

	}

	public void setTelefone(String telefone)throws Exception {
		if(telefone.length()!= 10)
			throw new Exception("Um telefone valido deve ter o DD + o numero");
		this.telefone = telefone;

	}

	public void setGerenteResponsavel(Gerente gerente){
		this.gerenteResponsavel = gerente;

	}

}