package agencias;

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
	
	public Filial(String cnpj, String endereco, String telefone, String inscEstadual, Gerente gerenteResponsavel){
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
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
		
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
