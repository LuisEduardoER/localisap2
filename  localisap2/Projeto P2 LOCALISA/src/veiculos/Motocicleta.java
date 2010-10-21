package veiculos;

/**
 * @author Felipe Jos�
 */

import java.util.ArrayList;

import agencias.Agencia;

public class Motocicleta implements Veiculo{
	private String RENAVAM;
	private String modelo;
	private String marca;
	private int potencia;
	private int clilindradas;
	private int ano;
	private Cor cor;
	private String tipoDeCombustivel;
	private Agencia localizacao;
	private String dataDeAquisicao;
	private int nivelDoTanque;
	private String tipoDeFreio;
	private ArrayList<String> historicoDeLocacoes = new ArrayList<String>();
	
	public Motocicleta(String RENAVAM, String modelo, String marca, int potencia, int cilindradas, int ano, Cor cor, String tipoDeCombustivel
			 ,Agencia localizacao, String dataDeAquisicao,int nivelDoTanque){
		this.setAno(ano);
		this.setCor(cor);
		this.setDataDeAquisicao(dataDeAquisicao);
		this.setLocalizacao(localizacao);
		this.setMarca(marca);
		this.setModelo(modelo);
		this.setNivelDoTanque(nivelDoTanque);
		this.setPotencia(potencia);
		this.setCilindradas(cilindradas);
		this.setRENAVAM(RENAVAM);
		this.setTipoDeCombustivel(tipoDeCombustivel);
}
	
	@Override
	public String getRENAVAM() {
		return RENAVAM;
	}
	@Override
	public String getModelo() {
		return modelo;
	}
	@Override
	public String getMarca() {
		return marca;
	}
	@Override
	public int getPotencia() {
		return potencia;
	}
	@Override
	public int getAno() {
		return ano;
	}
	@Override
	public Cor getCor() {
		return cor;
	}
	@Override
	public String getTipoDeCombustivel() {
		return tipoDeCombustivel;
	}
	@Override
	public String getDataDeAquisicao() {
		return dataDeAquisicao;
	}
	@Override
	public Agencia getLocalizacao() {
		return localizacao;
	}
	@Override
	public String getTipoDeFreios() {
		return tipoDeFreio;
	}
	@Override
	public void setRENAVAM(String RENAVAM) {
		this.RENAVAM = RENAVAM;
		
	}
	@Override
	public void setModelo(String modelo) {
		this.modelo = modelo;
		
	}
	@Override
	public void setMarca(String marca) {
		this.marca = marca;
		
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
		
	}
	@Override
	public void setAno(int ano) {
		this.ano = ano;
		
	}
	@Override
	public void setCor(Cor cor) {
		this.cor = cor;
		
	}
	@Override
	public void setTipoDeCombustivel(String tipoDeCombustivel) {
		this.tipoDeCombustivel = tipoDeCombustivel;
		
	}
	@Override
	public void setDataDeAquisicao(String dataDeAquisicao) {
		this.dataDeAquisicao = dataDeAquisicao;
		
	}
	@Override
	public void setLocalizacao(Agencia localizacao) {
		this.localizacao = localizacao;
		
	}
	@Override
	public void setTipoDeFreios(String tipoDeFreios) {		
		this.tipoDeFreio = tipoDeFreios;
	}
	@Override
	public void adicionaLocacao() {
		// TODO Auto-generated method stub
		
	}
	/*
	@Override
	public void removeLocacao() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removeRENAVAM() {
		this.RENAVAM = null;
		
	}
	@Override
	public void removeModelo() {
		this.modelo = null;
		
	}
	@Override
	public void removeMarca() {
		this.marca = null;
		
	}
	@Override
	public void removePotencia() {
		this.potencia = null;
		
	}
	@Override
	public void removeAno() {
		this.ano = 0;
		
	}
	@Override
	public void removeCor() {
		this.cor = null;
		
	}
	@Override
	public void removeTipoDeCombustivel() {
		this.tipoDeCombustivel = null;
		
	}
	@Override
	public void removeDataDeAquisicao() {
		this.dataDeAquisicao = null;
		
	}
	@Override
	public void removeLocalizacao() {
		this.localizacao = null;
		
	}
	@Override
	public void removeTipoDeFreios() {
		this.tipoDeFreio = null;
		
	}
	@Override
	public void removeOpcionais() {
		//TODO
		
	}
	@Override
	public void removeNivelDoTanque() {
		this.nivelDoTanque = 0;
		
	}
	*/
	@Override
	public int getNivelDoTanque() {
		return nivelDoTanque;
	}
	@Override
	public void setNivelDoTanque(int nivel) {
		this.nivelDoTanque = nivel;
		
	}

	@Override
	public int getCilindradas() {
		return this.clilindradas;
	}

	public void setCilindradas(int cilindradas) {
		this.clilindradas = cilindradas;
		
	}
}
