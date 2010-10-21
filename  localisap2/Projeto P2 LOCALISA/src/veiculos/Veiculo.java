package veiculos;

/**
 * @author Felipe Jos�
 */

import java.util.ArrayList;

import agencias.Agencia;

public interface Veiculo {
	
	String getRENAVAM();
	String getModelo();
	String getMarca();
	int getPotencia();
	int getCilindradas();
	int getAno();
	Cor getCor();
	String getTipoDeCombustivel();
	String getDataDeAquisicao();
	Agencia getLocalizacao();
	String getTipoDeFreios();
	int getNivelDoTanque();
	
	void adicionaLocacao();
	
	void setRENAVAM(String RENAVAM);
	void setModelo(String modelo);
	void setMarca(String marca);
	void setAno(int ano);
	void setCor(Cor cor);
	void setTipoDeCombustivel(String tipoDeCombustivel);
	void setDataDeAquisicao(String dataDeAquisicao);
	void setLocalizacao(Agencia localizacao);
	void setTipoDeFreios(String tipoDeFreios);
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
