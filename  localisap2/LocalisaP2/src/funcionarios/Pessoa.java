/**
 *
 */
package funcionarios;

import clientes.Endereco;

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
public interface Pessoa{
	/**
	 * Metodo para capturar o CPF de uma pessoa
	 * @return - Em String o CPF
	 */
	String getCpf();
	/**
	 * Metodo para capturar o nome de uma pessoa
	 * @return - Em String o nome
	 */
	String getNome();
	/**
	 * Metodo para capturar o RG de uma pessoa
	 * @return - Em String o rg
	 */
	String getRg();
	/**
	 * Metodo para capturar a data de nascimento de uma pessoa
	 * @return - Em String a data de nascimento
	 */
	String getNascimento();
	/**
	 * Metodo para capturar a naturalidade de uma pessoa
	 * @return - Em String a naturalidade
	 */
	String getNaturalidade();
	/**
	 * Metodo para capturar o endereco de uma pessoa
	 * @return - Em String o endereco
	 */
	Endereco getEndereco();

	/**
	 * Metodo para capturar o telefone de uma pessoa
	 * @return - Em String o telefone
	 */
	String getTelefone();
	/**
	 * Metodo para capturar o email de uma pessoa
	 * @return - Em String o email
	 */
	String getEmail();
	/**
	 * Permite mudar o numero do cpf
	 * @param cpf - Recebe como String o CPF
	 * @throws Exception - Erro de cpf invalido
	 */
	void setCpf(String cpf) throws Exception;
	/**
	 * Permite mudar o nome
	 * @param nome - Recebe como String o nome
	 * @throws Exception - Erro de nome de tamanho 0.
	 */
	void setNome(String nome) throws Exception;
	/**
	 * Permite mudar o numero do RG
	 * @param rg - Recebe como String o RG
	 * @throws Exception - Erro de rg com tamanho 0.
	 */
	void setRg(String rg)throws Exception;
	/**
	 * Permite mudar a data de nascimento
	 * @param nascimento - Recebe como String a data de nascimento
	 * @throws Exception - Erro de data invalida.
	 */
	void setNascimento(String nascimento) throws Exception;
	/**
	 * Permite mudar a naturalidade
	 * @param naturalidade - Recebe como String a naturalidade
	 * @throws Exception - Erro de naturalidade com tamanho 0.
	 */
	void setNaturalidade(String naturalidade)throws Exception;
	/**
	 * Permite mudar o endereco
	 * @param endereco - Recebe como String o endereco
	 * @throws Exception - Erro de endereco com tamanho 0.
	 */
	void setEndereco(Endereco endereco)throws Exception;

	/**
	 * Permite mudar o numero do telefone
	 * @param telefone - Recebe como String o telefone
	 * @throws Exception - Erro de telefone com formato diferente de DD+Numero.
	 */
	void setTelefone(String telefone) throws Exception;
	/**
	 * Permite mudar o email
	 * @param email - Recebe como String o email
	 * @throws Exception - Erro de email invalido , ou seja com tamanho menor que 3 e sem a presenca de @.
	 */
	void setEmail(String email)throws Exception;

}
