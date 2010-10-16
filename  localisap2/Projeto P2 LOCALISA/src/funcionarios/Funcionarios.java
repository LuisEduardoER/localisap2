/**
 * 
 */
package funcionarios;

/**
 * @author Filipe de Alencar Ramos
 *
 */
public interface Funcionarios {
	String getCPF();
	String getNome();
	String getRG();
	String getNascimento();
	String getNaturalidade();
	String getEndereco();
	String getAgencia();
	String getTelefone();
	String getEmail();
	void removeCPF();
	void removeNome();
	void removeRG();
	void removeNascimento();
	void removeNaturalidade();
	void removeEndereco();
	void removeAgencia();
	void removeTelefone();
	void removeEmail();
	void setCPF(String cpf);
	void setNome(String nome);
	void setRG(String rg);
	void setNascimento(String nascimento);
	void setNaturalidade(String naturalidade);
	void setEndereco(String endereco);
	void setAgencia(String agencia);
	void setTelefone(String telefone);
	void setEmail(String email);
	
}
