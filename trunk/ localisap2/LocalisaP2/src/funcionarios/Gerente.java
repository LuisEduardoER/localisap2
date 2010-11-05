/**
 *
 */
package funcionarios;

import clientes.Endereco;
import agencias.Filial;
import java.io.Serializable;
import verificacoes.Validacao;

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
public class Gerente implements Pessoa, Serializable{
	private String cpf;
	private String nome;
	private String rg;
	private String nascimento;
	private String naturalidade;
	private Endereco endereco;
	private Filial agencia;
	private String telefone;
	private String email;
        private String codigoDoGerente;
	/**
	 * Construtor que cria um gerente.
	 * @param cpf - Recebe como String o CPF
	 * @param nome - Recebe como String o nome
	 * @param rg - Recebe como String o rg
	 * @param nascimento -  Recebe como String a data de nascimento
	 * @param naturalidade - Recebe como String a naturalidade
	 * @param endereco - Recebe como Endereco o endereco
	 * @param agencia - Recebe como Filial a agencia
	 * @param telefone -  Recebe como String o telefone
	 * @param email - Recebe como String o email
	 * @throws Exception - Erros de parametros invalidos
	 */
	public Gerente(String cpf,String nome,String rg,String nascimento,String naturalidade,Endereco endereco,Filial agencia,String telefone,String email) throws Exception{
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
	public Gerente(){
	}
       /**
         * Metodo que captura o codigo exclusivo.
         * @return - O codigo exclusivo
         */
        public String getCodigoExclusivo(){
            return codigoDoGerente;
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
	 * @return - Como Filial a agencia
	 */
	public Filial getAgencia() {
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
		Validacao testeCpf = new Validacao();
		if(!(testeCpf.validaCpf(cpf)))
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
		Validacao testaData = new Validacao();
		if(!(testaData.validaData(nascimento)))
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
	 * @param agencia - Recebe como Filial a agencia
	 */
	public void setAgencia(Filial agencia) {
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
		if (!email.contains("@") || email.length()==0)
			throw new Exception("O email deve conter @ e ser maior que 3");

		this.email = email;
	}

}
