package clientes;

public class PessoaJuridica {
	private String CPNJ;
	private String razaoSocial;
	private String nomeFantasia;
	private String inscricaoEstadual;
	private String endereco;
	private String telefone;
	private String email;
	
	public PessoaJuridica(String CPNJ,String razaoSocial,String nomeFantasia,String inscricaoEstadual,String endereco,String telefone,String email)throws Exception{
		setEmail(email);
		setEndereco(endereco);
		setInscricaoEstadual(inscricaoEstadual);
		setNomeFantasia(nomeFantasia);
		setRazaoSocial(razaoSocial);
		setTelefone(telefone);
	}
	public PessoaJuridica(){
		
	}
	/**
	 * Metodo para capturar o CPNJ de uma pessoa juridica
	 * @return - Em String o CPNJ
	 */
	public String getCPNJ() {
		return CPNJ;
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
	public void removeCPNJ() {
		CPNJ = null;
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
	 * @throws Exception 
	 */	 
	public void CPNJ(String CPNJ) throws Exception {
		if(CPNJ.length()!= 14)
			throw new Exception("Um CPNJ valido deve ter 14 numeros");
		this.CPNJ = CPNJ;
		
	}

	/**
	 * Permite mudar a razao social
	 * @param razaoSocial - Recebe como String a razao social
	 */
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial= razaoSocial;
		
	}

	/**
	 * Permite mudar o nome fantasia
	 * @param nomeFantasia - Recebe como String o nome fantasia
	 */
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
		
	}

	/**
	 * Permite mudar a inscricao estadual
	 * @param inscricaoEstadual - Recebe como String a inscricao estadual
	 */
	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
		
	}
	/**
	 * Permite mudar o endereco
	 * @param endereco - Recebe como String o endereco
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
		
	}
	/**
	 * Permite mudar o telefone
	 * @param telefone - Recebe como String o telefone
	 */
	public void setTelefone(String telefone)throws Exception {
		if(telefone.length()!= 10)
			throw new Exception("Um telefone valido deve ter o DD + o numero");
		this.telefone = telefone;
		
	}
	/**
	 * Permite mudar o email
	 * @param nome - Recebe como String o email
	 */	 
	public void setEmail(String email) {
		this.email = email;
	}
}
