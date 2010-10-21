package clientes;

import verificacoes.ValidaCnpj;

public class PessoaJuridica {
	private String cnpj;
	private String razaoSocial;
	private String nomeFantasia;
	private String inscricaoEstadual;
	private String endereco;
	private String telefone;
	private String email;
	/**
	 * Construtor que cria uma Pessoa Juridca.
	 * @param cnpj - Recebe como String o cnpj
	 * @param razaoSocial - Recebe como String a razao social
	 * @param nomeFantasia - Recebe como String o nome Fantasia
	 * @param inscricaoEstadual -  Recebe como String a inscricao estadual
	 * @param endereco - 
	 * @param telefone -  Recebe como String o telefone
	 * @param email - Recebe como String o email
	 * @throws Exception - Erros de parametros invalidos
	 */	
	public PessoaJuridica(String cnpj,String razaoSocial,String nomeFantasia,String inscricaoEstadual,String endereco,String telefone,String email)throws Exception{
		setEmail(email);
		setEndereco(endereco);
		setInscricaoEstadual(inscricaoEstadual);
		setNomeFantasia(nomeFantasia);
		setRazaoSocial(razaoSocial);
		setTelefone(telefone);
		setCnpj(cnpj);
	}
	public PessoaJuridica(){
		
	}
	/**
	 * Metodo para capturar o CPNJ de uma pessoa juridica
	 * @return - Em String o CPNJ
	 */
	public String getCnpj() {
		return cnpj;
	}
	/**
	 * Metodo para capturar a razao social de uma pessoa juridica
	 * @return - Em String a razao social
	 */
	public String getRazaoSocial() {
		return razaoSocial;
	}

	/**
	 * Metodo para capturar o nome fantasia de uma pessoa juridica
	 * @return - Em String o nome fantasia
	 */ 
	public String getNomeFantasia() {
		return nomeFantasia;
	}

	/**
	 * Metodo para capturar a inscricao estadual de uma pessoa juridica
	 * @return - Em String a inscricao estadual
	 */
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}
	/**
	 * Metodo para capturar o endereco de uma pessoa juridica
	 * @return - Em String o endereco
	 */
	public String getEndereco() {
		return endereco;
	}
	/**
	 * Metodo para capturar o telefone de uma pessoa juridica
	 * @return - Em String o telefone
	 */
	public String getTelefone() {
		return telefone;
	}
	/**
	 * Metodo para capturar o email de uma pessoa juridica
	 * @return - Em String o email
	 */
	public String getEmail() {
		return email;
	}
	/*
	public void removeCnpj() {
		Cnpj = null;
	}

	public void removeRazaoSocial() {
		razaoSocial = null;
	}

	public void removeNomeFantasia() {
		nomeFantasia = null;
	}

	public void removeInscricaoEstadual() {
		inscricaoEstadual = null;
	}
	public void removeEndereco() {
		endereco = null;
	} 
	public void removeTelefone() {
		telefone = null;
	}
	public void removeEmail() {
		email = null;
	}
	*/
	
	/**
	 * Permite mudar o CPNJ
	 * @param CPNJ - Recebe como String o CPNJ
	 * @throws Exception - Erro de cnpj invalido
	 */	 
	public void setCnpj(String cnpj) throws Exception {
		ValidaCnpj testeCpnj = new ValidaCnpj();
		if(!(testeCpnj.validaCnpj(cnpj)))
			throw new Exception("Um cnpj valido deve ter 14 numeros");
		this.cnpj = cnpj;
		
	}

	/**
	 * Permite mudar a razao social
	 * @param razaoSocial - Recebe como String a razao social
	 * @throws Exception - Erro de razao social com tamanho 0
	 */
	public void setRazaoSocial(String razaoSocial)throws Exception {
		if(razaoSocial.length()==0){
			throw new Exception("A razao social nao deve ser vazio");
		}
		this.razaoSocial= razaoSocial;
		
	}

	/**
	 * Permite mudar o nome fantasia
	 * @param nomeFantasia - Recebe como String o nome fantasia
	 * @throws Exception - Erro de nome fantasia com tamanho 0
	 */
	public void setNomeFantasia(String nomeFantasia) throws Exception{
		if(nomeFantasia.length()==0){
			throw new Exception("O nome Fantasia nao deve ser vazio");
		}
		this.nomeFantasia = nomeFantasia;
		
	}

	/**
	 * Permite mudar a inscricao estadual
	 * @param inscricaoEstadual - Recebe como String a inscricao estadual
	 * @throws Exception - Erro de inscricao estadual com tamanho 0.
	 */
	public void setInscricaoEstadual(String inscricaoEstadual)throws Exception {
		if(inscricaoEstadual.length()==0){
			throw new Exception("A inscricao estadual nao deve ser vazio");
		}
		this.inscricaoEstadual = inscricaoEstadual;
		
	}
	/**
	 * Permite mudar o endereco
	 * @param endereco - Recebe como String o endereco
	 * @throws Exception -
	 */

	public void setEndereco(String endereco) throws Exception{
		if(endereco.length()==0)
			throw new Exception("O endereco nao deve ser vazio");
		this.endereco = endereco;
		
	}
	/**
	 * Permite mudar o telefone
	 * @param telefone - Recebe como String o telefone
	 * @throws Exception - Erro de telefone com formato diferente de DD+Numero. 
	 */
	public void setTelefone(String telefone)throws Exception {
		if(telefone.length()!= 10)
			throw new Exception("Um telefone valido deve ter o DD + o numero");
		this.telefone = telefone;
		
	}
	/**
	 * Permite mudar o email
	 * @param nome - Recebe como String o email
	 * @throws Exception - Erro de email invalido , ou seja com tamanho menor que 3 e sem a presenca de @.
	 */	 
	public void setEmail(String email) throws Exception{
		if (!email.contains("@")||email.length()==0)
			throw new Exception("O email deve conter @ e ser maior que 3");

		this.email = email;
	}
}
