package veiculos;

/**
 * @author Felipe Jose
 */

import java.util.ArrayList;
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
	public void addOpcional(Acessorios acessorio) throws Exception{
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
