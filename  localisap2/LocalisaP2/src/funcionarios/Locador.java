/**
 *
 */
package funcionarios;

import clientes.Endereco;
import agencias.Agencia;
import verificacoes.ValidaCpf;
import verificacoes.ValidaData;

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
public class Locador implements Pessoas{
	private String cpf;
	private String nome;
	private String rg;
	private String nascimento;
	private String naturalidade;
	private Endereco endereco;
	private Agencia agencia;
	private String telefone;
	private String email;
	/**
	 * Construtor que cria um locador.
	 * @param cpf - Recebe como String o CPF
	 * @param nome - Recebe como String o nome
	 * @param rg - Recebe como String o rg
	 * @param nascimento -  Recebe como String a data de nascimento
	 * @param naturalidade - Recebe como String a naturalidade
	 * @param endereco - Recebe como Endereco o endereco
	 * @param agencia - Recebe como Agencia a agencia
	 * @param telefone -  Recebe como String o telefone
	 * @param email - Recebe como String o email
	 * @throws Exception - Erros de parametros invalidos
	 */
	public Locador(String cpf,String nome,String rg,String nascimento,String naturalidade,Endereco endereco,Agencia agencia,String telefone,String email) throws Exception{
		setAgencia(agencia);
		setCpf(cpf);
		setEmail(email);
		setEndereco(endereco);
		setNascimento(nascimento);
		setNaturalidade(naturalidade);
		setNome(nome);
		setRg(rg);
		setTelefone(telefone);
	}

	public Locador(){

	}

	@Override
	public String getCpf() {
		return cpf;
	}

	@Override
	public String getNome() {
		return nome;
	}

	@Override
	public String getRg() {
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
	public Endereco getEndereco() {
		return endereco;
	}

	/**
	 * Captura a agencia
	 * @return - Como Agencia a agencia
	 */
	public Agencia getAgencia() {
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

	@Override
	public void setCpf(String cpf) throws Exception{
		ValidaCpf testeCpf = new ValidaCpf();
		if(!(testeCpf.valida(cpf)))
			throw new Exception("CPF invalido.");
		this.cpf = cpf;

	}

	@Override
	public void setNome(String nome) throws Exception{
		if(nome.length()==0 )
			throw new Exception("O nome nao deve ser vazio");
		this.nome = nome;

	}

	@Override
	public void setRg(String rg) throws Exception {
		if(rg.length()==0)
			throw new Exception("O RG nao deve ser vazio");
		this.rg = rg;
	}

	@Override
	public void setNascimento(String nascimento) throws Exception{
		ValidaData testaData = new ValidaData();
		if(!(testaData.validar(nascimento)))
			throw new Exception("Data invalida");
		this.nascimento = nascimento;

	}

	@Override
	public void setNaturalidade(String naturalidade) throws Exception{
		if(naturalidade.length()==0)
			throw new Exception("A naturalidade nao deve ser vazia");
		this.naturalidade = naturalidade;

	}

	@Override
	public void setEndereco(Endereco endereco) throws Exception{
		this.endereco = endereco;

	}

	/**
	 * Permite mudar a agencia.
	 * @param agencia - Recebe como Agencia a agencia
	 */
	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;

	}

	@Override
	public void setTelefone(String telefone)throws Exception {
		if(telefone.length()!= 10)
			throw new Exception("Um telefone valido deve ter o DD + o numero");
		this.telefone = telefone;

	}

	@Override
	public void setEmail(String email) throws Exception{
		if (!email.contains("@")||email.length()==0)
			throw new Exception("O email deve conter @ e ser maior que 3");

		this.email = email;
	}
}
