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
public class Gerente extends PessoaAbstrata implements Serializable{

	private Filial agencia;
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
	public Gerente(String cpf,String nome,String rg,String nascimento,String naturalidade,Endereco endereco,String telefone,String email) throws Exception{
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
	public Filial getAgencia() {
		return agencia;
	}

	/**
	 * Permite mudar a agencia.
	 * @param agencia - Recebe como Filial a agencia
	 */
	public void setAgencia(Filial agencia) {
		this.agencia = agencia;

	}
}
