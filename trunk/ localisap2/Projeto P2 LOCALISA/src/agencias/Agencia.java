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
	
	void setCnpj(String cnpj) throws Exception;
	void setEndereco(String endereco)throws Exception;
	void setInscEstadual(String inscEstadual)throws Exception;
	void setTelefone(String telefone)throws Exception;
	void setGerenteResponsavel(Gerente gerente)throws Exception;	
}
