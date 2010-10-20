/**
 * 
 */
package clientes;

import funcionarios.Pessoas;

/**
 * @author Filipe de Alencar Ramos
 *
 */
public class PessoaFisica implements Pessoas{
	private String cpf;
	private String nome;
	private String rg;
	private String nascimento;	
	private String naturalidade;
	private String endereco;	
	private String agencia;
	private String telefone;
	private String email;

	public PessoaFisica(String cpf,String nome,String rg,String nascimento,String naturalidade,String endereco,String agencia,String telefone,String email) throws Exception{
		setAgencia(agencia);
		setCPF(cpf);
		setEmail(email);
		setEndereco(endereco);
		setNascimento(nascimento);
		setNaturalidade(naturalidade);
		setNome(nome);
		setRG(rg);
		setTelefone(telefone);
	}
	public PessoaFisica(){
		
	}
	@Override
	public String getCPF() {
		return cpf;
	}

	@Override
	public String getNome() {
		return nome;
	}

	@Override
	public String getRG() {
		return rg;
	}

	@Override
	public String getNascimento() {
		return nascimento;
	}

	@Override
	public String getNaturalidade() {
		return naturalidade;
	}

	@Override
	public String getEndereco() {
		return endereco;
	}

	@Override
	public String getAgencia() {
		return agencia;
	}

	@Override
	public String getTelefone() {
		return telefone;
	}

	@Override
	public String getEmail() {
		return email;
	}
/*
	@Override
	public void removeCPF() {
		cpf = null;
	}

	@Override
	public void removeNome() {
		nome = null;
	}

	@Override
	public void removeRG() {
		rg = null;
	}

	@Override
	public void removeNascimento() {
		nascimento = null;
	}

	@Override
	public void removeNaturalidade() {
		naturalidade = null;
	}

	@Override
	public void removeEndereco() {
		endereco = null;
	}

	@Override
	public void removeAgencia() {
		agencia = null;
	}

	@Override
	public void removeTelefone() {
		telefone = null;
	}

	@Override
	public void removeEmail() {
		email = null;
	}
*/
	@Override
	public void setCPF(String cpf) throws Exception{
		if(cpf.length()!= 11)
			throw new Exception("Um cpf valido deve ter onze numeros");
		this.cpf = cpf;
		
	}

	@Override
	public void setNome(String nome) throws Exception{
		this.nome = nome;
		
	}

	@Override
	public void setRG(String rg) {
		this.rg = rg;
		
	}

	@Override
	public void setNascimento(String nascimento) throws Exception{
		this.nascimento = nascimento;
		
	}

	@Override
	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
		
	}

	@Override
	public void setEndereco(String endereco) {
		this.endereco = endereco;
		
	}

	@Override
	public void setAgencia(String agencia) {
		this.agencia = agencia;
		
	}

	@Override
	public void setTelefone(String telefone)throws Exception {
		if(telefone.length()!= 10)
			throw new Exception("Um telefone valido deve ter o DD + o numero");
		this.telefone = telefone;
		
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}

}
