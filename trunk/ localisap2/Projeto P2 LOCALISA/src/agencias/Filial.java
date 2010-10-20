package agencias;

import verificacoes.ValidaCnpj;
import funcionarios.Gerente;

/**
 * 
 * @author Felipe Jos�
 *
 */

public class Filial implements Agencia{
	
	private String cnpj;
	private String endereco;
	private String telefone;
	private String inscEstadual;
	private Gerente gerenteResponsavel;
	
	public Filial(String cnpj, String endereco, String telefone, String inscEstadual, Gerente gerenteResponsavel) throws Exception{
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
	public String getEndereco() {
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
/*
	@Override
	public void removeCNPJ() {
		CNPJ = null;
		
	}

	@Override
	public void removeEndereco() {
		endereco = null;
		
	}

	@Override
	public void removeInscEstadual() {
		inscEstadual = null;
		
	}

	@Override
	public void removeTelefone() {
		telefone = null;
		
	}

	@Override
	public void removeGerenteResponsavel() {
		gerenteResponsavel = null;
		
	}
*/
	@Override
	public void setCnpj(String Cnpj) throws Exception {
		ValidaCnpj testeCnpj = new ValidaCnpj();
		if(!(testeCnpj.validaCnpj(Cnpj)))
			throw new Exception("Um CPNJ valido deve ter 14 numeros");
		this.cnpj = Cnpj;
		
	}

	@Override
	public void setEndereco(String endereco) throws Exception{
		if(endereco.length()==0)
			throw new Exception("O endereco nao deve ser vazio");
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
