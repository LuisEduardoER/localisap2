package agencias;

import funcionarios.Gerente;

/**
 * 
 * @author Felipe José
 *
 */

public class Filial implements Agencia{
	
	private String CNPJ;
	private String endereco;
	private String telefone;
	private String inscEstadual;
	private Gerente gerenteResponsavel;
	
	
	@Override
	public String getCNPJ() {
		return CNPJ;
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

	@Override
	public void setCNPJ(String CNPJ) {
		this.CNPJ = CNPJ;
		
	}

	@Override
	public void setEndereco(String endereco) {
		this.endereco = endereco;
		
	}

	@Override
	public void setInscEstadual(String inscEstadual) {
		this.inscEstadual = inscEstadual;
		
	}

	@Override
	public void setTelefone(String telefone) {
		this.telefone = telefone;
		
	}

	@Override
	public void setGerenteResponsavel(Gerente gerente) {
		this.gerenteResponsavel = gerente;
		
	}

}
