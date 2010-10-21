package verificacoes;

import java.util.GregorianCalendar;

/**
 * Classe criada para verificar a validade de datas.
 * @author Felipe Jose
 *
 */

public class ValidaData {
	
	private static int DIA_INICIAL = 1;
	private static int MES_INICIAL = 0;
	private static int DIFERENCA_MES = 1;
	
	/**
	 * Verifica a validade de uma data no formato String.
	 * @param data - String no formato de data.
	 * @return Retorna verdadeiro se a String passada como argumento caracteriza uma data valida ou falso caso contrario.
	 */
	
	public boolean validar(String data){
		data = data.replace("/", " ");
		data = data.replace(" ", "");
		if (data.length()!=8) 
			return false;
		int dia = Integer.parseInt(data.substring(0, 2));
		int mes = Integer.parseInt(data.substring(2, 4));
		int ano = Integer.parseInt(data.substring(4, 8));
		if (dia <= 0 || mes <= 0 || ano<= 0)
			return false;
		GregorianCalendar calendario = new GregorianCalendar(ano, MES_INICIAL, DIA_INICIAL);
		if (calendario.getActualMaximum(GregorianCalendar.MONTH) < mes-1)
			return false;
		calendario.set(GregorianCalendar.MONTH, mes+DIFERENCA_MES);
		if (calendario.getActualMaximum(GregorianCalendar.DAY_OF_MONTH) < dia)
			return false;
		return true;
	}
	
	/**
	 * Verifica a validade de uma data recebida em numeros inteiros.
	 * @param ano - O ano em numero inteiro.
	 * @param mes - O mes em numero inteiro.
	 * @param dia - O dia em numero inteiro.
	 * @return Retorna verdadeiro caso a data passada seja valida ou falso caso contrario.
	 */
	public boolean validar(int ano, int mes, int dia){
		if (dia <= 0 || mes <= 0 || ano<= 0)
			return false;
		GregorianCalendar calendario = new GregorianCalendar(ano, MES_INICIAL, DIA_INICIAL);
		if (calendario.getActualMaximum(GregorianCalendar.MONTH) < mes-1)
			return false;
		calendario.set(GregorianCalendar.MONTH, mes+DIFERENCA_MES);
		if (calendario.getActualMaximum(GregorianCalendar.DAY_OF_MONTH) < dia)
			return false;
		return true;
	}
}
