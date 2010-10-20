import java.util.ArrayList;
import java.util.Scanner;

import agencias.Agencia;
import agencias.Filial;

import funcionarios.Gerente;

/**
 * 
 * @author Felipe José
 *
 */

public class main {
	
	private static StringBuilder sb;
	private static Scanner input;
	private static int OPCAO_MINIMA_MENUP = 1;
	private static int OPCAO_MAXIMA_MENUP = 6;
	private static int OPCAO_MINIMA_MENUD = 1;
	private static int OPCAO_MAXIMA_MENUD = 3;
	private static int STATUS_SUCCESS = 0;
	private static ArrayList<Gerente> listaDeGerentes = new ArrayList<Gerente>();
	private static ArrayList<Agencia> listaDeAgencias = new ArrayList<Agencia>();
	
	public static void main(String[] args) throws Exception{
		input = new Scanner(System.in);
		menuPrincipal();
	}
	
	private static void menuPrincipal() throws Exception{
		sb = new StringBuilder();
		sb.append("-== Main - Milestone 1 ==-\n");
		sb.append("--------------------------\n");
		sb.append("1 - Gerenciar Agencias\n");
		sb.append("2 - Gerenciar Clientes\n");
		sb.append("3 - Gerenciar Funcionarios\n");
		sb.append("4 - Gerenciar Planos\n");
		sb.append("5 - Gerenciar Veiculos\n");
		sb.append("6 - Sair\n");
		System.out.println(sb.toString());
		int opcao = readIntegerOption(">", OPCAO_MINIMA_MENUP, OPCAO_MAXIMA_MENUP);
		switch(opcao){
		case(1):
			menuAgencias();
			break;			
		case(2):
			menuClientes();
		    break;
		case(3):
			menuFuncionarios();
		    break;
		case(4):
			menuPlanos();
		    break;
		case(5):
			menuVeiculos();
		    break;
		case(6):
			System.exit(STATUS_SUCCESS);
		}
	}
	
	private static void menuAgencias() throws Exception{
		sb = new StringBuilder();
		sb.append("1 - Registrar Agencia\n");
		sb.append("2 - Exluir Agencia\n");
		sb.append("3 - Voltar\n");
		System.out.println(sb.toString());
		int opcao = readIntegerOption(">", OPCAO_MINIMA_MENUD, OPCAO_MAXIMA_MENUD);
		switch(opcao){
		case(1):
			registrarAgencia();
			break;
		case(2):
			break;
		case(3):
			break;
		}
		menuPrincipal();
	}
	
	private static void registrarAgencia() throws Exception{
		System.out.println("Informe o CNPJ da filial (formato: xx.xxx.xxx/xxxx-xx):");
		String cnpj = readStringOption(">");
		System.out.println("Informe o endereco da nova filial:");
		String endereco = readStringOption(">");
		System.out.println("Informe o numero de telefone da nova filial:");
		String telefone = readStringOption(">");
		System.out.println("Informe a inscricao estadual da agencia:");
		String inscEstadual = readStringOption(">");
		System.out.println("Lista de gerentes disponiveis:");
		for (int i = 0 ; i<listaDeGerentes.size(); i++){
			System.out.println(i+1+" - "+listaDeGerentes.get(i).getNome());
		}
		System.out.println(listaDeGerentes.size()+1+ " - Nenhum gerente inicialmente");
		System.out.println("Qual gerente sera responsavel pela agencia?");
		int gerente = readIntegerOption(">", OPCAO_MINIMA_MENUD, listaDeGerentes.size()+1)-1;
		Gerente g = listaDeGerentes.get(gerente);
		listaDeAgencias.add(new Filial(cnpj, endereco, telefone, inscEstadual, g));
		System.out.println("A sua agencia foi registrada com sucesso!");
	}
	
	private static void excluirAgencia() throws Exception{
		if (listaDeAgencias.isEmpty()){
			System.out.println("Nao ha agencias criadas.");
			menuPrincipal();
		}
		for (int i = 0 ; i < listaDeAgencias.size() ; i++){
			System.out.println(i+1+" - "+listaDeAgencias.get(i).getEndereco());
		}
		System.out.println("Qual agencia voce deseja excluir do registro?");
		int agencia = readIntegerOption(">", OPCAO_MINIMA_MENUD, listaDeAgencias.size())-1;
		listaDeAgencias.remove(agencia);
		System.out.println("A agencia foi removida com sucesso!");
	}
	
	private static void menuClientes(){
		sb = new StringBuilder();
		sb.append("1 - Registrar Cliente\n");
		sb.append("2 - Exluir Cliente\n");
		System.out.println(sb.toString());
		int opcao = readIntegerOption(">", OPCAO_MINIMA_MENUD, OPCAO_MAXIMA_MENUD);
	}
	
	private static void menuFuncionarios(){
		sb = new StringBuilder();
		sb.append("1 - Registrar Funcionario\n");
		sb.append("2 - Exluir Funcionario\n");
		System.out.println(sb.toString());
		int opcao = readIntegerOption(">", OPCAO_MINIMA_MENUD, OPCAO_MAXIMA_MENUD);
	}
	
	private static void menuPlanos(){
		sb = new StringBuilder();
		sb.append("1 - Registrar Plano\n");
		sb.append("2 - Exluir Plano\n");
		System.out.println(sb.toString());
		int opcao = readIntegerOption(">", OPCAO_MINIMA_MENUD, OPCAO_MAXIMA_MENUD);
	}
	
	private static void menuVeiculos(){
		sb = new StringBuilder();
		sb.append("1 - Registrar Veiculo\n");
		sb.append("2 - Exluir Veiculo\n");
		System.out.println(sb.toString());
		int opcao = readIntegerOption(">", OPCAO_MINIMA_MENUD, OPCAO_MAXIMA_MENUD);
	}
	
	private static int readIntegerOption(String message, int lowerLimit, int upperLimit) {
		while(true){
			try{
				System.out.print(message);
				Integer number = 0;
				do {
					number = Integer.valueOf(input.nextLine());
				}while(number < lowerLimit || number > upperLimit);
				return number;
			}catch (NumberFormatException nfe) {
				// Just to avoid crashing in the user's face.
			}
		}
	}
	
	private static String readStringOption(String message){
		while(true){
			System.out.print(message);
			String opt = "";
			do {
				opt = input.nextLine();
			}while(opt == "" || opt == null);
			return opt;		
		}		
	}
}
