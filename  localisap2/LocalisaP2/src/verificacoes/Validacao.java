/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package verificacoes;

import java.io.Serializable;
import java.util.GregorianCalendar;

/**
 * Classe criada para verificar a validade de datas.
 *
 * @author Felipe Jose      -twitter.com/felipejosefc
 * @author Filipe Alencar   -twitter.com/filipealencar_
 * @author Emilio Farias    -twitter.com/militofarias
 *
 * http://code.google.com/p/localisap2/
 * Universidade Federal de Campina Grande - Computacao
 *
 */
public class Validacao implements Serializable {

    private static int DIA_INICIAL = 1;
    private static int MES_INICIAL = 0;
    private static int DIFERENCA_MES = 1;
    /**
     * Metodo que valida o cnpj.
     * @param cnpj - Recebe como string o cnpj a ser verificado.
     * @return - True se o cnpj for valido e false caso contrario
     */
    public  boolean validaCnpj( String cnpj ) {
        if (! cnpj.substring(0,1).equals("")){
            try{
            	cnpj=cnpj.replace('.',' ');
            	cnpj=cnpj.replace('/',' ');
            	cnpj=cnpj.replace('-',' ');
            	cnpj=cnpj.replaceAll(" ","");
                int soma = 0, aux, dig;
                String cnpj_calc = cnpj.substring(0,12);

                if ( cnpj.length() != 14 )
                    return false;
                char[] chr_cnpj = cnpj.toCharArray();
                for( int i = 0; i < 4; i++ )
                    if ( chr_cnpj[i]-48 >=0 && chr_cnpj[i]-48 <=9 )
                        soma += (chr_cnpj[i] - 48 ) * (6 - (i + 1)) ;
                for( int i = 0; i < 8; i++ )
                    if ( chr_cnpj[i+4]-48 >=0 && chr_cnpj[i+4]-48 <=9 )
                        soma += (chr_cnpj[i+4] - 48 ) * (10 - (i + 1)) ;
                dig = 11 - (soma % 11);
                cnpj_calc += ( dig == 10 || dig == 11 ) ?
                    "0" : Integer.toString(dig);
                soma = 0;
                for ( int i = 0; i < 5; i++ )
                    if ( chr_cnpj[i]-48 >=0 && chr_cnpj[i]-48 <=9 )
                        soma += (chr_cnpj[i] - 48 ) * (7 - (i + 1)) ;
                for ( int i = 0; i < 8; i++ )
                    if ( chr_cnpj[i+5]-48 >=0 && chr_cnpj[i+5]-48 <=9 )
                        soma += (chr_cnpj[i+5] - 48 ) * (10 - (i + 1)) ;
                dig = 11 - (soma % 11);
                cnpj_calc += ( dig == 10 || dig == 11 ) ?
                    "0" : Integer.toString(dig);
                return cnpj.equals(cnpj_calc);
            }catch (Exception e){
                System.err.println("Ocorreu algum erro na validacao do CNPJ!");
                return false;
            }
        }else return false;

    }
    /**
     * Metodo que valida o cpf.
     * @param strCpf - Recebe como string o cpf a ser verificado.
     * @return - True se for valido e false caso contrario.
     */
    public boolean validaCpf(String strCpf)    {
        int     d1, d2;
        int     digito1, digito2, resto;
        int     digitoCPF;
        String  nDigResult;
        strCpf = strCpf.replace(".", " ");
        strCpf = strCpf.replace("-", " ");
        strCpf = strCpf.replace(" ", "");
        d1 = d2 = 0;
        digito1 = digito2 = resto = 0;
        for (int nCount = 1; nCount < strCpf.length() -1; nCount++)
        {
           digitoCPF = Integer.valueOf (strCpf.substring(nCount -1,nCount)).intValue();
           d1 = d1 + ( 11 - nCount ) * digitoCPF;
           d2 = d2 + ( 12 - nCount ) * digitoCPF;
        };
        resto = (d1 % 11);
        if (resto < 2)
           digito1 = 0;
        else
           digito1 = 11 - resto;
        d2 += 2 * digito1;
        resto = (d2 % 11);
        if (resto < 2)
           digito2 = 0;
        else
           digito2 = 11 - resto;
        String nDigVerific = strCpf.substring(strCpf.length()-2, strCpf.length());
        nDigResult = String.valueOf(digito1) + String.valueOf(digito2);
        return nDigVerific.equals(nDigResult);
     }
	/**
	 * Verifica a validade de uma data no formato String.
	 * @param data - String no formato de data.
	 * @return Retorna verdadeiro se a String passada como argumento caracteriza uma data valida ou falso caso contrario.
	 */

	public boolean validaData(String data){
		data = data.replace("/", " ");
		data = data.replace(".", " ");
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
	public boolean validaData(int ano, int mes, int dia){
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
