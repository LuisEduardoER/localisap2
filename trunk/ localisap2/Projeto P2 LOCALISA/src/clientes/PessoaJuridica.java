package clientes;

public class PessoaJuridica {
	private String CPNJ;
	private String razaoSocial;
	private String nomeFantasia;
	private String inscricaoEstadual;
	private String endereco;
	private String telefone;
	private String email;
	
	 
	public String getCPNJ() {
		return CPNJ;
	}

	 
	public String getRazaoSocial() {
		return razaoSocial;
	}

	 
	public String getNomeFantasia() {
		return nomeFantasia;
	}

	 
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}
 
	public String getEndereco() {
		return endereco;
	}
	 
	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}

	 
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

	 
	public void setCPNJ(String CPNJ) {
		this.CPNJ = CPNJ;
		
	}

	 
	public void setaRazaoSocial(String razaoSocial) {
		this.razaoSocial= razaoSocial;
		
	}

	 
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
		
	}

	 
	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
		
	}
 
	public void setEndereco(String endereco) {
		this.endereco = endereco;
		
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
		
	}

	 
	public void setEmail(String email) {
		this.email = email;
	}
}
