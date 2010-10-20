package veiculos;

/**
 * @author Felipe Jos�
 */

import agencias.Agencia;

public interface Veiculo {
	
	String getRENAVAM();
	String getModelo();
	String getMarca();
	int getPotencia();
	int getCilindradas();
	int getAno();
	String getCor();
	String getTipoDeCombustivel();
	String getDataDeAquisicao();
	Agencia getLocalizacao();
	String getTipoDeFreios();
	String getOpcionais();
	int getNivelDoTanque();
	
	void adicionaLocacao();
	
	void setRENAVAM(String RENAVAM);
	void setModelo(String modelo);
	void setMarca(String marca);
	void setPotencia(int potencia);
	void setCilindradas(int cilindradas);
	void setAno(int ano);
	void setCor(String cor);
	void setTipoDeCombustivel(String tipoDeCombustivel);
	void setDataDeAquisicao(String dataDeAquisicao);
	void setLocalizacao(Agencia localizacao);
	void setTipoDeFreios(String tipoDeFreios);
	void setOpcionais(String opcionais);
	void setNivelDoTanque(int nivel);
	/*
	void removeRENAVAM();
	void removeModelo();
	void removeMarca();
	void removePotencia();
	void removeAno();
	void removeCor();
	void removeLocacao();
	void removeTipoDeCombustivel();
	void removeDataDeAquisicao();
	void removeLocalizacao();
	void removeTipoDeFreios();
	void removeOpcionais();
	void removeNivelDoTanque();
	*/
}