package veiculos;

import java.io.Serializable;

/**
 *
 * @author Felipe Jose      -twitter.com/felipejosefc
 * @author Filipe Alencar   -twitter.com/filipealencar_
 * @author Emilio Farias    -twitter.com/militofarias
 *
 * http://code.google.com/p/localisap2/
 * Universidade Federal de Campina Grande - Computacao
 *
 */

public interface Veiculo extends Serializable{

	/**
	 * Metodo para capturar o RENAVAM
	 * @return - Retorna o RENAVAM do veiculo do tipo String
	 */
	String getRenavam();
	/**
	 * Metodo para capturar o modelo do veiculo
	 * @return - Retorna o modelo do veiculo do tipo String
	 */
	String getModelo();
	/**
	 * Metodo para capturar a marca do veiculo
	 * @return - Retorna a marca do veiculo do tipo String
	 */
	String getMarca();
	/**
	 * Metodo para capturar a potencia do veiculo
	 * @return - Retorna a potencia do veiculo do tipo int
	 */
	int getPotencia();
	/**
	 * Metodo para capturar qual o sistema de potencia do veiculo
	 * @return - Retorna o sistema de potencia do veiculo do tipo enum TipoDePotencia
	 */
	TipoDePotencia getTipoDePotencia();
	/**
	 * Metodo para capturar o ano de fabricacao do veiculo
	 * @return - Retorna o ano do veiculo do tipo int
	 */
	int getAno();
	/**
	 * Metodo para capturar a cor do veiculo
	 * @return - Retorna a cor do veiculo do tipo enum Cor
	 */
	Cor getCor();
	/**
	 * Metodo para capturar o tipo de combustivel do veiculo
	 * @return - Retorna o tipo de combustivel do veiculo do tipo enum TipoDeCombustivel
	 */
	TipoDeCombustivel getTipoDeCombustivel();
	/**
	 * Metodo para capturar a data de aquisicao do veiculo
	 * @return - Retorna a data de aquisicao do veiculo do tipo String
	 */
	String getDataDeAquisicao();
	/**
	 * Metodo para capturar o tipo de freio do veiculo
	 * @return - Retorna o tipo de freio do veiculo, do tipo enum TipoDeFreio
	 */
	TipoDeFreio getTipoDeFreios();
	/**
	 * Metodo para capturar o nivel do tanque de combustivel do veiculo
	 * @return - Retorna o nivel do tanque do veiculo do tipo int
	 */
	int getNivelDoTanque();

	/**
	 * Metodo para manter registro das locacoes do veiculo numa lista
	 */
	void adicionaLocacao();

	/**
	 * Permite mudar o tipo de potencia do veiculo
	 * @param tipo - Recebe o tipo de potencia do tipo enum TipoDePotencia
	 *
	 */
	void setTipoDePotencia(TipoDePotencia tipo);
	/**
	 * Permite mudar o RENAVAM do veiculo
	 * @param renavam - Recebe o novo RENAVAM do tipo String
	 *
	 * @throw Exception - Erro se o tamanho do renavam for zero
	 */
	void setRenavam(String renavam) throws Exception;
	/**
	 * Permite mudar o modelo do veiculo
	 * @param modelo - Recebe o novo modelo do tipo String
	 *
	 * @throw Exception - Erro se o tamanho do modelo for zero
	 */
	void setModelo(String modelo) throws Exception;
	/**
	 * Permite mudar a marca do veiculo
	 * @param marca - Recebe a nova marca do tipo String
	 *
	 * @throw Exception - Erro se o tamanho da marca for zero.
	 */
	void setMarca(String marca) throws Exception;
	/**
	 * Permite mudar o ano do veiculo
	 * @param ano - Recebe o novo ano do tipo int
	 *
	 * @throw Exception - Erro se o ano for menor que 1950.
	 */
	void setAno(int ano) throws Exception;
	/**
	 * Permite mudar a cor do veiculo
	 * @param cor - Recebe a nova cor do tipo enum Cor
	 *
	 */
	void setCor(Cor cor);
	/**
	 * Permite mudar o tipo de combustivel do veiculo
	 * @param tipoDeCombustivel - Recebe o novo tipo de combustivel do tipo enum TipoDeCombustivel
	 *
	 */
	void setTipoDeCombustivel(TipoDeCombustivel tipoDeCombustivel);
	/**
	 * Permite mudar a data de aquisicao do veiculo
	 * @param dataDeAquisicao - Recebe a nova data de aquisicao do tipo String
	 *
	 * @throw Exception - Erro de data invalida
	 */
	void setDataDeAquisicao(String dataDeAquisicao) throws Exception;
	/**
	 * Permite mudar o tipo de freio do veiculo
	 * @param tipoDeFreios - Recebe o novo tipo de freio do tipo enum TipoDeFreio
	 *
	 */
	void setTipoDeFreios(TipoDeFreio tipoDeFreios);
	/**
	 * Permite mudar o nivel do tanque do veiculo
	 * @param nivel - Recebe o novo nivel do tanque do tipo int
	 *
	 * @throw Exception - Erro se o nivel do tanque for menor que zero ou maior que 100.
	 */
	void setNivelDoTanque(int nivel) throws Exception;
}
