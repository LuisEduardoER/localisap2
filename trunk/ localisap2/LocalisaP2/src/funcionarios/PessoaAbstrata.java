/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package funcionarios;
import verificacoes.Validacao;
import clientes.Endereco;
import java.io.Serializable;


/**
 *Classe abstrata PessoaAbstrata
 * Comportamentos de pessoas
 *
 * @author Filipe Alencar   -twitter.com/filipealencar_
 * @author Felipe Jose      -twitter.com/felipejosefc
 * @author Emilio Farias    -twitter.com/militofarias
 *
 * http://code.google.com/p/localisap2/
 * Universidade Federal de Campina Grande - Computacao
 *
 */
public abstract class PessoaAbstrata implements Pessoa,Serializable{
        private String cpf;
	private String nome;
	private String rg;
	private String nascimento;
	private String naturalidade;
	private Endereco endereco;
	private String telefone;
	private String email;


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

	@Override
	public void setTelefone(String telefone)throws Exception {
		if(telefone.length()< 10)
			throw new Exception("Um telefone valido deve ter o DDD + o numero");
		this.telefone = telefone;

	}

	@Override
	public void setEmail(String email) throws Exception{
		if (!email.contains("@") || email.length()==0)
			throw new Exception("O email deve conter @ e ser maior que 3");

		this.email = email;
	}


}
