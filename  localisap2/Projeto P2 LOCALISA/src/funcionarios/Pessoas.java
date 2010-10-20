/**
 * 
 */
package funcionarios;

/**
 * @author Filipe de Alencar Ramos
 *
 */
public interface Pessoas {
	/**
	 * Metodo para capturar o CPF de uma pessoa
	 * @return - Em String o CPF
	 */
	String getCPF();
	/**
	 * Metodo para capturar o nome de uma pessoa
	 * @return - Em String o nome
	 */
	String getNome();
	/**
	 * Metodo para capturar o RG de uma pessoa
	 * @return - Em String o rg
	 */
	String getRG();
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
	String getEndereco();
	/**
	 * Metodo para capturar a agencia de uma pessoa
	 * @return - Em String a agencia
	 */
	String getAgencia();
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
	/*
	void removeCPF();
	void removeNome();
	void removeRG();
	void removeNascimento();
	void removeNaturalidade();
	void removeEndereco();
	void removeAgencia();
	void removeTelefone();
	void removeEmail();
	*/
	/**
	 * Permite mudar o numero do cpf
	 * @param cpf - Recebe como String o CPF
	 */
	void setCPF(String cpf);
	/**
	 * Permite mudar o  nome
	 * @param nome - Recebe como String o nome
	 */
	void setNome(String nome);
	/**
	 * Permite mudar o numero do RG
	 * @param rg - Recebe como String o RG
	 */
	void setRG(String rg);
	/**
	 * Permite mudar a data de nascimento
	 * @param nascimento - Recebe como String a data de nascimento
	 */
	void setNascimento(String nascimento);
	/**
	 * Permite mudar a naturalidade
	 * @param naturalidade - Recebe como String a naturalidade
	 */
	void setNaturalidade(String naturalidade);
	/**
	 * Permite mudar o endereco
	 * @param endereco - Recebe como String o endereco
	 */
	void setEndereco(String endereco);
	/**
	 * Permite mudar a agencia
	 * @param agencia - Recebe como String a agencia
	 */
	void setAgencia(String agencia);
	/**
	 * Permite mudar o numero do telefone
	 * @param telefone - Recebe como String o telefone
	 */
	void setTelefone(String telefone);
	/**
	 * Permite mudar o email
	 * @param email - Recebe como String o email
	 */
	void setEmail(String email);
	
}
