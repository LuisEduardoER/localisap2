package veiculos;

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

import java.util.ArrayList;

import verificacoes.ValidaData;
import agencias.Agencia;

public class Automovel implements Veiculo{
	private String renavam;
	private String modelo;
	private String marca;
	private TipoDePotencia tipoPotencia;
	private TipoDeFreio tipoDeFreio;
	private int potencia;
	private int ano;
	private Cor cor;
	private TipoDeCombustivel tipoDeCombustivel;
	private Agencia localizacao;
	private String dataDeAquisicao;
	private int nivelDoTanque;
	private ArrayList<Acessorios> acessoriosOpcionais = new ArrayList<Acessorios>();
	private ArrayList<String> historicoDeLocacoes = new ArrayList<String>();
	/**
	 * Construtor de um automovel 
	 * @param renavam - O renavam do veiculo
	 * @param modelo - O modelo do veiculo
	 * @param marca - A marca do veiculo
	 * @param potencia - A potencia do veiculo
	 * @param ano - O ano do veiculo
	 * @param cor - A cor do veiculo
	 * @param tipoDeFreio - O tipo de freio do veiculo
	 * @param tipoDeCombustivel - O tipo de combustivel do veiculo
	 * @param localizacao - A agencia que o veiculo estah.
	 * @param dataDeAquisicao - A data que o veiculo foi adquirido
	 * @param nivelDoTanque - O nivel do tanque que o veiculo estah.
	 * @param acessoriosOpcionais - O acessorios opcionais que o veiculo tem
	 * @param tipoDePotencia - O tipo de pontencia (hp ou cc)
	 * @throws Exception - Erro de algum parametro errado.
	 */
	public Automovel(String renavam, String modelo, String marca, int potencia, int ano, Cor cor,TipoDeFreio tipoDeFreio, TipoDeCombustivel tipoDeCombustivel
					 ,Agencia localizacao, String dataDeAquisicao,int nivelDoTanque, ArrayList<Acessorios> acessoriosOpcionais,TipoDePotencia tipoDePotencia) throws Exception{
		this.setAno(ano);
		this.setCor(cor);
		this.setDataDeAquisicao(dataDeAquisicao);
		this.setLocalizacao(localizacao);
		this.setPotencia(potencia);
		this.setTipoDeFreios(tipoDeFreio);
		this.setMarca(marca);
		this.setModelo(modelo);
		this.setNivelDoTanque(nivelDoTanque);
		for (Acessorios acessorio : acessoriosOpcionais)
			this.addOpcional(acessorio);
		this.setRenavam(renavam);
		this.setTipoDeCombustivel(tipoDeCombustivel);
		this.setTipoDePotencia(tipoDePotencia);
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
	public TipoDePotencia getTipoDePotencia() {
		return this.tipoPotencia;
	}
	/**
	 * Capturar em forma de ArrayList os opcionais do automovel
	 * @return - Em ArrayList os opcionais do automovel
	 */
	public ArrayList<Acessorios> getOpcionais() {
		return acessoriosOpcionais;
	}
	@Override
	public void setRenavam(String renavam) throws Exception{
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
	public void setTipoDeCombustivel(TipoDeCombustivel tipoDeCombustivel){
		this.tipoDeCombustivel = tipoDeCombustivel;
		
	}
	@Override
	public void setDataDeAquisicao(String dataDeAquisicao) throws Exception{
		ValidaData testaData = new ValidaData();
		if(!(testaData.validar(dataDeAquisicao)))
			throw new Exception("Data invalida");
		this.dataDeAquisicao = dataDeAquisicao;
		
	}

	@Override
	public void setLocalizacao(Agencia localizacao){
		this.localizacao = localizacao;
		
	}
	@Override
	public void setTipoDeFreios(TipoDeFreio tipoDeFreios){		
		this.tipoDeFreio = tipoDeFreios;
	}
	/**
	 * Adiciona uma acessorio opcional ao automovel.
	 * @param acessorio - Uma constante do enum que representa um acessorio ao automovel.
	 */
	public void addOpcional(Acessorios acessorio){
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
	public void setNivelDoTanque(int nivel) throws Exception{
		if(nivel<0 || nivel >100)
			throw new Exception("O nivel do tanque deve  ser maior  ou igual a zero e menor ou igual a 100");
		this.nivelDoTanque = nivel;
		
	}
	/**
	 * Permite mudar a potencia do automovel
	 * @param potencia - Recebe como inteiro a potencia do automovel
	 * @throws Exception - Erro de potencia menor ou igual a zero.
	 */
	public void setPotencia(int potencia)throws Exception {
		if (potencia<=0)
			throw new Exception("A potencia deve ser maior que zero");
		this.potencia = potencia;
		
	}

	@Override
	public void setTipoDePotencia(TipoDePotencia tipoPotencia) {
		this.tipoPotencia = tipoPotencia;
		
	}
}
