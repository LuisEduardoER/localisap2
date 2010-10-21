package veiculos;

import agencias.Agencia;

/**
 * @author Felipe Jose
 */

public interface Veiculo {
	
	public enum TipoDePotencia{
		HP,CC;
	}
	
	public enum TipoDeCombustivel{
		ALCOOL,GASOLINA,GAS,DIESEL,FLEX;
	}
	
	String getRENAVAM();
	String getModelo();
	String getMarca();
	int getPotencia();
	TipoDePotencia getTipoDePotencia();
	int getAno();
	Cor getCor();
	TipoDeCombustivel getTipoDeCombustivel();
	String getDataDeAquisicao();
	Agencia getLocalizacao();
	String getTipoDeFreios();
	int getNivelDoTanque();
	void adicionaLocacao();
	void setTipoDePotencia(TipoDePotencia tipo);
	void setRENAVAM(String RENAVAM);
	void setModelo(String modelo);
	void setMarca(String marca);
	void setAno(int ano);
	void setCor(Cor cor);
	void setTipoDeCombustivel(TipoDeCombustivel tipoDeCombustivel);
	void setDataDeAquisicao(String dataDeAquisicao);
	void setLocalizacao(Agencia localizacao);
	void setTipoDeFreios(String tipoDeFreios);
	void setNivelDoTanque(int nivel);
}
