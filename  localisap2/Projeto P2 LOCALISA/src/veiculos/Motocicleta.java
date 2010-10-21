package veiculos;

/**
 * @author Felipe Jose
 */

import java.util.ArrayList;
import agencias.Agencia;

public class Motocicleta implements Veiculo{
	private String renavam;
	private String modelo;
	private String marca;
	private int potencia;
	private TipoDePotencia tipoPotencia;
	private int clilindradas;
	private int ano;
	private Cor cor;
	private TipoDeCombustivel tipoDeCombustivel;
	private Agencia localizacao;
	private String dataDeAquisicao;
	private int nivelDoTanque;
	private TipoDeFreio tipoDeFreio;
	private ArrayList<String> historicoDeLocacoes = new ArrayList<String>();
	
	public Motocicleta(String renavam, String modelo, String marca,TipoDePotencia tipoPotencia, int potencia, int cilindradas, int ano, Cor cor, TipoDeCombustivel tipoDeCombustivel
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
		this.setRENAVAM(renavam);
		this.setTipoDeCombustivel(tipoDeCombustivel);
}
	
	@Override
	public String getRenavam() {
		return renavam;
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
	public TipoDePotencia getTipoDePotencia() {
		return this.tipoPotencia;
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
	public TipoDeFreio getTipoDeFreios() {
		return tipoDeFreio;
	}
	@Override
	public void setRENAVAM(String renavam) throws Exception{
		if (renavam.length() == 0)
			throw new Exception("Renavam de tamanho invalido");
		this.renavam = renavam;
		
	}
	@Override
	public void setModelo(String modelo) throws Exception{
		if (modelo.length()== 0)
			throw new Exception("Modelo de tamanho invalido");
		this.modelo = modelo;
		
	}
	@Override
	public void setMarca(String marca) throws Exception{
		if (marca.length()== 0)
			throw new Exception("Marca de tamanho invalido");
		this.marca = marca;
		
	}
	public void setPotencia(int potencia)throws Exception {
		if (potencia<=0)
			throw new Exception("A potencia deve ser maior que zero");
		this.potencia = potencia;
		
	}
	@Override
	public void setAno(int ano)throws Exception{
		if(ano<1950)
			throw new Exception("Ano de tamanho invalido");
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
	public void setTipoDeFreios(TipoDeFreio tipoDeFreios) {		
		this.tipoDeFreio = tipoDeFreios;
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
	public void setNivelDoTanque(int nivel) throws Exception{
		if(nivel<=0 || nivel >100)
			throw new Exception("O nivel do tanque deve variar ser maior que zero e menor ou igual a 100");
		this.nivelDoTanque = nivel;
		
	}

	public int getCilindradas() {
		return this.clilindradas;
	}

	public void setCilindradas(int cilindradas)throws Exception {
		if(cilindradas <= 0)
			throw Exception("As cilindradas devem ser maiores que zero")
		this.clilindradas = cilindradas;
		
	}

	@Override
	public void setTipoDePotencia(TipoDePotencia tipoPotencia) {
		this.tipoPotencia = tipoPotencia;
	}
}
