package agencias;

import clientes.Endereco;
import funcionarios.Gerente;

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

public interface Agencia {
	/**
	 * Metodo para capturar o CPNJ de uma agencia
	 * @return - Em String o CPNJ
	 */
	String getCnpj();
	/**
	 * Metodo para capturar o Endereco de uma agencia
	 * @return - Em endereco o Endereco
	 */
	Endereco getEndereco();
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
	/**
	 * Permite mudar o Endereco 
	 * @param endereco - Recebe como Endereco o endereco
	 * @throws Exception
	 */
	void setEndereco(Endereco endereco)throws Exception;
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
