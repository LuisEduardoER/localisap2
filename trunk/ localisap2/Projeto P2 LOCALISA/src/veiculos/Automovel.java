package veiculos;

/**
 * @author Felipe Jos�
 */

import java.util.ArrayList;

import agencias.Agencia;

public class Automovel implements Veiculo{
	private String RENAVAM;
	private String modelo;
	private String marca;
	private TipoDePotencia tipoPotencia;
	private int potencia;
	private int ano;
	private Cor cor;
	private TipoDeCombustivel tipoDeCombustivel;
	private Agencia localizacao;
	private String dataDeAquisicao;
	private int nivelDoTanque;
	private ArrayList<Acessorios> acessoriosOpcionais = new ArrayList<Acessorios>();
	private ArrayList<String> historicoDeLocacoes = new ArrayList<String>();

	public Automovel(String RENAVAM, String modelo, String marca, int potencia, int ano, Cor cor, TipoDeCombustivel tipoDeCombustivel
					 ,Agencia localizacao, String dataDeAquisicao,int nivelDoTanque, ArrayList<Acessorios> acessoriosOpcionais){
		this.setAno(ano);
		this.setCor(cor);
		this.setDataDeAquisicao(dataDeAquisicao);
		this.setLocalizacao(localizacao);
		this.setPotencia(potencia);
		this.setMarca(marca);
		this.setModelo(modelo);
		this.setNivelDoTanque(nivelDoTanque);
		for (Acessorios acessorio : acessoriosOpcionais)
			this.addOpcional(acessorio);
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
	public TipoDeCombustivel getTipoDeCombustivel() {
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
		// TODO
		return null;
	}
	
	@Override
	public TipoDePotencia getTipoDePotencia() {
		return this.tipoPotencia;
	}
	
	public ArrayList<Acessorios> getOpcionais() {
		return acessoriosOpcionais;
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

	@Override
	public void setAno(int ano) {
		this.ano = ano;
		
	}
	@Override
	public void setCor(Cor cor) {
		this.cor = cor;
		
	}
	@Override
	public void setTipoDeCombustivel(TipoDeCombustivel tipoDeCombustivel) {
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
		//TODO
	}
	public void addOpcional(Acessorios acessorio) {
		this.acessoriosOpcionais.add(acessorio);
		
	}	
	@Override
	public void adicionaLocacao() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int getNivelDoTanque() {
		return nivelDoTanque;
	}
	@Override
	public void setNivelDoTanque(int nivel) {
		this.nivelDoTanque = nivel;
		
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
		
	}

	@Override
	public void setTipoDePotencia(TipoDePotencia tipoPotencia) {
		this.tipoPotencia = tipoPotencia;
		
	}
}
