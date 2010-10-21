package agencias;

import clientes.Endereco;
import verificacoes.ValidaCnpj;
import funcionarios.Gerente;

/**
 * 
 * @author Felipe Jose
 *
 */

public class Filial implements Agencia{
	
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

	
	@Override
	public String getCnpj() {
		return cnpj;
	}

	@Override
	public Endereco getEndereco() {
		return endereco;
	}

	@Override
	public String getTelefone() {
		return telefone;
	}

	@Override
	public String getInscEstadual() {
		return inscEstadual;
	}

	@Override
	public Gerente getGerenteResponsavel() {
		return gerenteResponsavel;
	}
	@Override
	public void setCnpj(String Cnpj) throws Exception {
		ValidaCnpj testeCnpj = new ValidaCnpj();
		if(!(testeCnpj.validaCnpj(Cnpj)))
			throw new Exception("Um CPNJ valido deve ter 14 numeros");
		this.cnpj = Cnpj;
		
	}

	@Override
	public void setEndereco(Endereco endereco) throws Exception{
		this.endereco = endereco;
		
	}

	@Override
	public void setInscEstadual(String inscricaoEstadual)throws Exception {
		if(inscricaoEstadual.length()==0){
			throw new Exception("A inscricao estadual nao deve ser vazio");
		}
		this.inscEstadual = inscricaoEstadual;
		
	}

	@Override
	public void setTelefone(String telefone)throws Exception {
		if(telefone.length()!= 10)
			throw new Exception("Um telefone valido deve ter o DD + o numero");
		this.telefone = telefone;
		
	}

	@Override
	public void setGerenteResponsavel(Gerente gerente){
		this.gerenteResponsavel = gerente;
		
	}

}
