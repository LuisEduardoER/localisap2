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
	
	public enum TipoDeFreio{
		TAMBOR, DISCO, ABS;
	}
	
	public enum Acessorios {
	    P2 ("Duas Portas"), 
	    P4 ("Quatro Portas"),
	    AC ("Ar Condicionado"), 
	    GPS ("GPS - Global Positioning System"),
	    DH ("Direcao Hidraulica"), 
	    VE ("Vidro Eletrico"),
	    TE ("Trava Eletrica"),
	    AB ("Air Bag"),
	    BC ("Bancos de Couro");

	    
	    private String nomeCompleto;
	    
	    private Acessorios(String nomeCompleto){
	    	this.nomeCompleto = nomeCompleto;
	    }
	    
	    public String getNomeCompleto(){
	            return nomeCompleto;
	    }
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
	TipoDeFreio getTipoDeFreios();
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
	void setTipoDeFreios(TipoDeFreio tipoDeFreios);
	void setNivelDoTanque(int nivel);
}
