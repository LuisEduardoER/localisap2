package clientes;

/**
 * 
 * @author Felipe Jose
 *
 */

public class Endereco {
	
	public enum UnidadeFederativa{
		PB("Paraiba"),PR("Parana"),SP("Sao Paulo"),
		RJ("Rio de Janeiro"),AC("Acre"),AL("Alagoas"),
		AP("Amapa"),AM("Amazonas"),BA("Bahia"),
		CE("Ceara"),DF("Distrito Federal"),ES("Espirito Santo"),
		GO("Goias"),MA("Maranhao"),MT("Mato Grosso"),
		MS("Mato Grosso do Sul"),MG("Minas Gerais"),
		PA("Para"),PE("Pernambuco"),PI("Piaui"),
		RN("Rio Grande do Norte"),RS("Rio Grande do Sul"),
		RO("Rondonia"),RR("Roraima"),SC("Santa Catarina"),
		SE("Sergipe"),TO("Tocantins");
		
		private String nomePorExtenso;
		
	    UnidadeFederativa(String nomePorExtenso) {
			this.nomePorExtenso = nomePorExtenso;
		}
	}
	
	private UnidadeFederativa estado;
	private String cidade;
	private String bairro;
	private String rua;
	private int numero;
	private String cep;
	private String pontoDeReferencia;
	
	public Endereco(UnidadeFederativa estado, String cidade, String bairro, String rua, int numero, String cep, String pontoDeReferencia) throws Exception{
		if(cidade.isEmpty() || cidade == null)
			throw new Exception("Voce deve informar um nome de cidade valido.");
		if(bairro.isEmpty() || bairro == null)
			throw new Exception("Voce deve informar um bairro valido.");
		if(rua.isEmpty() || rua == null)
			throw new Exception("Voce deve informar uma rua valida.");
		if(bairro.isEmpty() || bairro == null)
			throw new Exception("Voce deve informar um bairro valido.");
		if(numero<=0)
			throw new Exception("Voce deve informar um numero valido.");
		if(cep.isEmpty() || cep == null || !validarCep(cep))
			throw new Exception("Voce deve informar um cep valido.");
		
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
		this.pontoDeReferencia = pontoDeReferencia;
	}
	
	private UnidadeFederativa getEstado(){
		return this.estado;
	}
	
	private void setEstado(UnidadeFederativa estado){
		this.estado = estado;
	}
	
	private String getCidade(){
		return this.cidade;
	}
	
	private void setCidade(String cidade){
		this.cidade = cidade;
	}
	
	private String getBairro(){
		return this.bairro;
	}
	
	private void setBairro(String bairro){
		this.bairro = bairro;
	}
	
	private String getRua(){
		return this.rua;
	}
	
	private void setRua(String rua){
		this.rua = rua;
	}
	
	private int getNumero(){
		return this.numero;
	}
	
	private void setNumero(int numero){
		this.numero = numero;
	}
	
	private String getCep(){
		return this.cep;
	}
	
	private void setCep(String cep){
		this.cep = cep;
	}
	
	private String getPontoDeReferencia(){
		return this.pontoDeReferencia;
	}
	
	private void setPontoDeReferencia(String pontoDeReferencia){
		this.pontoDeReferencia = pontoDeReferencia;
	}
	
	public boolean validarCep(String cep){
		cep = cep.replace(".", " ");
		cep = cep.replace("-", " ");
		cep = cep.replace(" ", "");
		if (cep.length()!=8)
			return false;
		for(int i = 0 ; i < cep.length() ;i++)
			if (!Character.isDigit(cep.charAt(i)))
					return false;
		return true;
	}
}
