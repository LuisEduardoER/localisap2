package verificacoes;

public class ValidaCpf {  
      
    public ValidaCpf() {  
    }  
    public  boolean validacpf(String strCpf){
        if (! strCpf.substring(0,1).equals("")){  
            try{  
                boolean validado=true;  
                int     digit1, digit2;  
                int     digito1, digito2, resto;  
                int     digitoCPF;  
                String  nDigResult;  
                strCpf=strCpf.replace('.',' ');  
                strCpf=strCpf.replace('-',' ');  
                strCpf=strCpf.replaceAll(" ","");  
                digit1 = digit2 = 0;  
                digito1 = digito2 = resto = 0;                   
                for (int nCount = 1; nCount < strCpf.length() -1; nCount++) {  
                    digitoCPF = Integer.valueOf(strCpf.substring(nCount -1, nCount)).intValue();                      
                    digit1 = digit1 + ( 11 - nCount ) * digitoCPF;                      
                    digit2 = digit2 + ( 12 - nCount ) * digitoCPF;  
                };  
                resto = (digit1 % 11);  
                if (resto < 2)  
                	digit1 = 0;  
                else  
                	digit1 = 11 - resto;       
                digit2 += 2 * digito1;  
                resto = (digit2 % 11);               
                if (resto < 2)  
                    digito2 = 0;  
                else  
                    digito2 = 11 - resto;  
                String nDigVerific = strCpf.substring(strCpf.length()-2, strCpf.length());  
                nDigResult = String.valueOf(digito1) + String.valueOf(digito2);  
                return nDigVerific.equals(nDigResult);  
            }catch (Exception e){  
                System.err.println("Erro !"+e);  
                return false;  
            }  
        }else return false;  
    }  
}  