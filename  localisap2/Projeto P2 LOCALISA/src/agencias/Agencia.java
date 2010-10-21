package agencias;

import funcionarios.Gerente;

/**
 * 
 * @author Felipe Jose
 *
 */

public interface Agencia {
	/**
	 * Metodo para capturar o CPNJ de uma agencia
	 * @return - Em String o CPNJ
	 */
	String getCnpj();
	String getEndereco();
	/**
	 * Metodo para capturar o telefone de uma agencia
	 * @return - Em String o telefone
	 */
	String getTelefone();
	/**
	 * Metodo para capturar a inscricao estadual de uma agencia
	 * @return - Em String a inscricao estadual
	 */
	String getInscEstadual();
	/**
	 * Metodo para capturar o gerente de uma agencia
	 * @return - Em Gerente o gerente de uma agencia
	 */
	Gerente getGerenteResponsavel();

	/**
	 * Permite mudar o CPNJ
	 * @param CPNJ - Recebe como String o CPNJ
	 * @throws Exception - Erro de cpf invalido
	 */	
	void setCnpj(String cnpj) throws Exception;
	
	void setEndereco(String endereco)throws Exception;
	/**
	 * Permite mudar a inscricao estadual
	 * @param inscricaoEstadual - Recebe como String a inscricao estadual
	 */
	void setInscEstadual(String inscEstadual)throws Exception;
	/**
	 * Permite mudar o telefone
	 * @param telefone - Recebe como String o telefone
	 */
	void setTelefone(String telefone)throws Exception;
	/**
	 * Permite mudar o gerente responsavel
	 * @param gerente - Recebe como Gerente o gerente responsavel
	 */
	void setGerenteResponsavel(Gerente gerente);	
}
