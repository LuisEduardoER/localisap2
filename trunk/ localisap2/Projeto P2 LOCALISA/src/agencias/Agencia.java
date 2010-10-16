package agencias;

import funcionarios.Gerente;

/**
 * 
 * @author Felipe José
 *
 */

public interface Agencia {
	String getCNPJ();
	String getEndereco();
	String getTelefone();
	String getInscEstadual();
	Gerente getGerenteResponsavel();
	void removeCNPJ();
	void removeEndereco();
	void removeInscEstadual();
	void removeTelefone();
	void removeGerenteResponsavel();
	void setCNPJ(String CNPJ);
	void setEndereco(String endereco);
	void setInscEstadual(String inscEstadual);
	void setTelefone(String telefone);
	void setGerenteResponsavel(Gerente gerente);	
}
