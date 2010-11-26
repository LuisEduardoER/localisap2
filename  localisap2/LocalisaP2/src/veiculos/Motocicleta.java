package veiculos;



import java.util.ArrayList;
import agencias.Filial;
import java.io.Serializable;
import verificacoes.Validacao;

/**
 * Classe Motocicleta
 * Implementa Interface Veiculo
 * Gerencia dados relativos a motocicletas
 *
 * @author Felipe Jose      -twitter.com/felipejosefc
 * @author Filipe Alencar   -twitter.com/filipealencar_
 * @author Emilio Farias    -twitter.com/militofarias
 *
 * http://code.google.com/p/localisap2/
 * Universidade Federal de Campina Grande - Computacao
 *
 */

public class Motocicleta implements Veiculo,Serializable{
	private String renavam;
	private String modelo;
	private String marca;
	private int potencia;
	private TipoDePotencia tipoPotencia;
	private int clilindradas;
	private int ano;
	private Cor cor;
	private TipoDeCombustivel tipoDeCombustivel;
	private Filial localizacao;
	private String dataDeAquisicao;
	private int nivelDoTanque;
	private TipoDeFreio tipoDeFreio;
	private ArrayList<String> historicoDeLocacoes = new ArrayList<String>();
        private String codigoDaMoto;
        private static final long serialVersionUID = 1L;
        private boolean locado = false;


	/**
	 * Construtor de Motocicleta
         *
	 * @param renavam - O renavam do veiculo
	 * @param modelo - O modelo do veiculo
	 * @param marca - A marca do veiculo
	 * @param tipoPotencia - O tipo de pontencia (hp ou cc)
	 * @param potencia - A potencia do veiculo
	 * @param cilindradas - As cilindradas da motocicleta
	 * @param ano - O ano do veiculo
	 * @param cor - A cor do veiculo
	 * @param tipoDeCombustivel
	 * @param dataDeAquisicao - A data que o veiculo foi adquirido
	 * @param nivelDoTanque  - O nivel do tanque que o veiculo estah.
	 * @throws Exception - Erro de algum parametro errado.
	 */
	public Motocicleta(String renavam, String modelo, String marca,TipoDePotencia tipoPotencia, int potencia, int cilindradas, int ano, Cor cor, TipoDeCombustivel tipoDeCombustivel
			 , String dataDeAquisicao,int nivelDoTanque) throws Exception{
		this.setAno(ano);
		this.setCor(cor);
		this.setDataDeAquisicao(dataDeAquisicao);
		this.setMarca(marca);
		this.setModelo(modelo);
		this.setNivelDoTanque(nivelDoTanque);
		this.setPotencia(potencia);
		this.setCilindradas(cilindradas);
		this.setRenavam(renavam);
		this.setTipoDeCombustivel(tipoDeCombustivel);
		this.setTipoDePotencia(tipoPotencia);
}



       /**
         * Metodo que captura o codigo exclusivo.
         * @return - O codigo exclusivo
         */
        public String getCodigoExclusivo(){
            return codigoDaMoto;
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
	public TipoDeFreio getTipoDeFreios() {
		return tipoDeFreio;
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
	/**
	 * Permite mudar a potencia da motocicleta
	 * @param potencia - Recebe como inteiro a potencia da motocicleta
	 * @throws Exception - Erro de potencia menor ou igual a zero.
	 */
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
	public void setDataDeAquisicao(String dataDeAquisicao) throws Exception{
		Validacao testaData = new Validacao();
		if(!(testaData.validaData(dataDeAquisicao)))
			throw new Exception("Data invalida");
		this.dataDeAquisicao = dataDeAquisicao;

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
	/**
	 * Metodo que captura as cilindradas da motocicleta
	 * @return - Retorna como int as cilindradas
	 */
	public int getCilindradas() {
		return this.clilindradas;
	}

	@Override
	public void setNivelDoTanque(int nivel) throws Exception{
		if(nivel<0 || nivel >100)
			throw new Exception("O nivel do tanque deve  ser maior  ou igual a zero e menor ou igual a 100");
		this.nivelDoTanque = nivel;

	}

	/**
	 * Permite mudar as cilindradas da motocicleta
	 * @param cilindradas - Recebe como int as cilindradas
	 * @throws Exception - Erro de cilindradas menor ou igual a zero
	 */
	public void setCilindradas(int cilindradas) throws Exception {
		if(cilindradas <= 0)
			throw new Exception("As cilindradas devem ser maiores que zero");
		this.clilindradas = cilindradas;
	}

	@Override
	public void setTipoDePotencia(TipoDePotencia tipoPotencia) {
		this.tipoPotencia = tipoPotencia;
	}

    public boolean getLocado() {
        return locado;
    }

    public void setLocado(boolean locado) {
        this.locado = locado;
    }

}
