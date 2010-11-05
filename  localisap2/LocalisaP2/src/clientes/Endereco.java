package clientes;

import java.io.Serializable;

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

public class Endereco implements Serializable{

	public enum UnidadeFederativa{
		PB("Paraiba"),PR("Parana"),SP("Sao Paulo"),
		RJ("Rio de Janeiro"),AC("Acre"),AL("Alagoas"),
		AP("Amapa"),AM("Amazonas"),BA("Bahia"),
		CE("Ceara"),DF("Distrito Federal"),ES("Espirito Santo"),
		GO("Goias"),MA("Maranhao"),MT("Mato Grosso"),
		MS("Mato Grosso do Sul"),MG("Minas Gerais"),
		PA("Para"),PE("Pernambuco"),PI("Piaui"),
		RN("Rio Grande do Norte"),RS("Rio Grande do Sul"),
		RO("Rondonia"),RR("Roraima"),SC("Santa Catarina"),
		SE("Sergipe"),TO("Tocantins");

		private String nomePorExtenso;

	    UnidadeFederativa(String nomePorExtenso) {
			this.nomePorExtenso = nomePorExtenso;
		}

	    public String getNomePorExtenso(){
	    	return this.nomePorExtenso;
	    }
	}

	private UnidadeFederativa estado;
	private String cidade;
	private String bairro;
	private String rua;
	private int numero;
	private String cep;
	private String pontoDeReferencia;

	/**
	 * Construtor do tipo Endereco
	 *
	 * @param estado - recebe o estado do tipo UnidadeFederativa
	 * @param cidade - recebe a cidade do tipo String
	 * @param bairro - recebe o bairro do tipo String
	 * @param rua - recebe o logradouro do tipo String
	 * @param numero - recebe o numero da residencia do tipo int
	 * @param cep - recebe o CEP do tipo String
	 * @param pontoDeReferencia - recebe a informacao do tipo String
	 *
	 * @throws Exception - Informacoes NULL ou vazias / Cep invalido
	 */
	public Endereco(UnidadeFederativa estado, String cidade, String bairro, String rua, int numero, String cep, String pontoDeReferencia) throws Exception{
		if(cidade.isEmpty() || cidade == null)
			throw new Exception("Voce deve informar um nome de cidade valido.");
		if(bairro.isEmpty() || bairro == null)
			throw new Exception("Voce deve informar um bairro valido.");
		if(rua.isEmpty() || rua == null)
			throw new Exception("Voce deve informar uma rua valida.");
		if(numero<=0)
			throw new Exception("Voce deve informar um numero valido.");
		if(cep.isEmpty() || cep == null || !validarCep(cep))
			throw new Exception("Voce deve informar um cep valido.");

		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
		this.pontoDeReferencia = pontoDeReferencia;
	}

	/**
	 * Construtor do tipo Endereco
	 *
	 * @param estado - recebe o estado do tipo UnidadeFederativa
	 * @param cidade - recebe a cidade do tipo String
	 * @param bairro - recebe o bairro do tipo String
	 * @param rua - recebe o logradouro do tipo String
	 * @param numero - recebe o numero da residencia do tipo int
	 * @param cep - recebe o CEP do tipo String
	 *
	 * @throws Exception - Informacoes NULL ou String de tamanho 0. / Cep invalido
	 */
	public Endereco(UnidadeFederativa estado, String cidade, String bairro, String rua, int numero, String cep) throws Exception{
		if(cidade.isEmpty() || cidade == null)
			throw new Exception("Voce deve informar um nome de cidade valido.");
		if(bairro.isEmpty() || bairro == null)
			throw new Exception("Voce deve informar um bairro valido.");
		if(rua.isEmpty() || rua == null)
			throw new Exception("Voce deve informar uma rua valida.");
		if(numero<=0)
			throw new Exception("Voce deve informar um numero valido.");
		if(cep.isEmpty() || cep == null || !validarCep(cep))
			throw new Exception("Voce deve informar um cep valido.");

		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
	}

	/**
	 * Metodo para capturar o Estado
	 * @return - Retorna o estado do tipo UnidadeFederativa
	 */
	public UnidadeFederativa getEstado(){
		return this.estado;
	}
	/**
	 * Metodo para capturar a cidade
	 * @return - Retorna a cidade do tipo String
	 */
	public String getCidade(){
		return this.cidade;
	}
	/**
	 * Metodo para capturar o Bairro
	 * @return - Retorna o bairro do tipo String
	 */
	public String getBairro(){
		return this.bairro;
	}
	/**
	 * Metodo para capturar o logradouro
	 * @return - Retorna o logradouro do tipo String
	 */
	public String getRua(){
		return this.rua;
	}
	/**
	 * Metodo para capturar o Numero da rsidencia
	 * @return - Retorna o numero do tipo int
	 */
	public int getNumero(){
		return this.numero;
	}
	/**
	 * Metodo para capturar o CEP
	 * @return - Retorna o CEP do tipo String
	 */
	public String getCep(){
		return this.cep;
	}
	/**
	 * Metodo para capturar o Ponto de Referencia
	 * @return - Retorna o Ponto de referencia do tipo String
	 */
	public String getPontoDeReferencia(){
		return this.pontoDeReferencia;
	}


	/**
	 * Permite mudar o estado
	 * @param estado - Recebe o estado do tipo UnidadeFederativa
	 *
	 */
	public void setEstado(UnidadeFederativa estado){
		this.estado = estado;
	}
	/**
	 * Permite mudar a cidade
	 * @param cidade - Recebe a cidade do tipo String
	 *
	 * @throw Exception - Informacao NULL ou String de tamanho 0.
	 */
	public void setCidade(String cidade) throws Exception{
		if(cidade.isEmpty() || cidade == null)
			throw new Exception("Voce deve informar um nome de cidade valido.");
		this.cidade = cidade;
	}
	/**
	 * Permite mudar o bairro
	 * @param bairro - Recebe o bairro do tipo String
	 *
	 * @throw Exception - Informacao NULL ou String de tamanho 0.
	 */
	public void setBairro(String bairro) throws Exception{
		if(bairro.isEmpty() || bairro == null)
			throw new Exception("Voce deve informar um bairro valido.");
		this.bairro = bairro;
	}
	/**
	 * Permite mudar o logradouro
	 * @param rua - Recebe o logradouro do tipo String
	 *
	 * @throw Exception - Informacao NULL ou String de tamanho 0.
	 */
	public void setRua(String rua) throws Exception{
		if(rua.isEmpty() || rua == null)
			throw new Exception("Voce deve informar uma rua valida.");
		this.rua = rua;
	}
	/**
	 * Permite mudar o numero da residencia
	 * @param numero - Recebe o numero do tipo int
	 *
	 * @throw Exception - Informacao NULL ou String de tamanho 0.
	 */
	public void setNumero(int numero) throws Exception{
		if(numero<=0)
			throw new Exception("Voce deve informar um numero valido.");
		this.numero = numero;
	}
	/**
	 * Permite mudar o CEP da residencia
	 * @param cep - Recebe o cep do tipo String
	 *
	 * @throw Exception - Informacao NULL ou String de tamanho 0.
	 */
	public void setCep(String cep) throws Exception{
		if(cep.isEmpty() || cep == null || !validarCep(cep))
			throw new Exception("Voce deve informar um cep valido.");
		this.cep = cep;
	}
	/**
	 * Permite mudar o ponto de referencia
	 * @param pontoDeReferencia - Recebe a informacao do tipo String
	 *
	 * @throw Exception - Informacao NULL ou String de tamanho 0.
	 */
	public void setPontoDeReferencia(String pontoDeReferencia) throws Exception{
		if(pontoDeReferencia.isEmpty() || pontoDeReferencia == null)
			throw new Exception("Voce deve informar algo!");
		this.pontoDeReferencia = pontoDeReferencia;
	}

	/**
	 * Testa se o CEP eh valido
	 * @param cep - Recebe o cep do tipo String
	 * @return true - se o cep eh valido
	 */
	public boolean validarCep(String cep){
		cep = cep.replace(".", " ");
		cep = cep.replace("-", " ");
		cep = cep.replace(" ", "");
		if (cep.length()!=8)
			return false;
		for(int i = 0 ; i < cep.length() ;i++)
			if (!Character.isDigit(cep.charAt(i)))
					return false;
		return true;
	}
}
