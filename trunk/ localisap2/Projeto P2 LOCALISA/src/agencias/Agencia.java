package agencias;

import funcionarios.Gerente;

/**
 * 
 * @author Felipe Jos�
 *
 */

public interface Agencia {
	String getCnpj();
	String getEndereco();
	String getTelefone();
	String getInscEstadual();
	Gerente getGerenteResponsavel();
	/*
	void removeCNPJ();
	void removeEndereco();
	void removeInscEstadual();
	void removeTelefone();
	void removeGerenteResponsavel();
	*/
	
	void setCnpj(String cnpj);
	void setEndereco(String endereco);
	void setInscEstadual(String inscEstadual);
	void setTelefone(String telefone);
	void setGerenteResponsavel(Gerente gerente);	
}
