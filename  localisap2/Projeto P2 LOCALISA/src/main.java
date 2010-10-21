import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import clientes.Endereco;
import clientes.PessoaFisica;
import clientes.PessoaJuridica;
import clientes.Endereco.UnidadeFederativa;

import agencias.Agencia;
import agencias.Filial;

import funcionarios.Gerente;
import funcionarios.Locador;
import funcionarios.Pessoas;

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
	private static List<Locador> listaDeLocadores = new ArrayList<Locador>();
	private static List<Gerente> listaDeGerentes = new ArrayList<Gerente>();
	private static List<Agencia> listaDeAgencias = new ArrayList<Agencia>();
	private static List<Pessoas> listaDeClientesPessoaFisica = new ArrayList<Pessoas>();
	private static List<PessoaJuridica> listaDeClientesPessoaJuridica = new ArrayList<PessoaJuridica>();

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
		sb.append("2 - Excluir Agencia\n");
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
		if (listaDeGerentes.isEmpty()){
			System.out.println("Voce deve ter gerentes cadastrados para criar uma agencia.");
			menuPrincipal();
		}
		System.out.println("Informe o CNPJ da filial (formato: xx.xxx.xxx/xxxx-xx):");
		String cnpj = readStringOption(">");
		System.out.println("Em que estado esta situada a agencia:");
		for (int i = 0 ; i < UnidadeFederativa.values().length ; i++)
			System.out.println(i+1+" - "+UnidadeFederativa.values()[i].getNomePorExtenso());
		int numEstado = readIntegerOption(">", OPCAO_MINIMA_MENUD, UnidadeFederativa.values().length)-1;
		UnidadeFederativa estado = UnidadeFederativa.values()[numEstado];
		String cidade = readStringOption("Cidade: ");
		String bairro = readStringOption("Bairro: ");
		String rua = readStringOption("Rua: ");
		int numero = readIntegerOptionNoLimit("Numero: ",OPCAO_MINIMA_MENUD);
		String cep = readStringOption("CEP: ");
		String pontoDeReferencia = readStringOption("Ponto de referencia (opcional) : ");
		Endereco endereco;
		if (!pontoDeReferencia.isEmpty())
			endereco = new Endereco(estado, cidade, bairro, rua, numero, cep, pontoDeReferencia);
		else
			endereco = new Endereco(estado, cidade, bairro, rua, numero, cep);
		System.out.println("Informe o numero de telefone da nova filial:");
		String telefone = readStringOption(">");
		System.out.println("Informe a inscricao estadual da agencia:");
		String inscEstadual = readStringOption(">");
		System.out.println("Lista de gerentes disponiveis:");
		for (int i = 0 ; i<listaDeGerentes.size(); i++){
			System.out.println(i+1+" - "+listaDeGerentes.get(i).getNome());
		}
		System.out.println("Qual gerente sera responsavel pela agencia?");
		int gerente = readIntegerOption(">", OPCAO_MINIMA_MENUD, listaDeGerentes.size())-1;
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
	
	private static void menuClientes() throws Exception{
		sb = new StringBuilder();
		sb.append("1 - Registrar Cliente\n");
		sb.append("2 - Excluir Cliente\n");
		sb.append("3 - Voltar\n");
		System.out.println(sb.toString());
		int opcao = readIntegerOption(">", OPCAO_MINIMA_MENUD, OPCAO_MAXIMA_MENUD);
		switch(opcao){
		case(1):
			menuClientesTipo(1);
			break;
		case(2):
			menuClientesTipo(0);
			break;
		case(3):
			break;
		}
		menuPrincipal();
	}
	
	private static void excluirClienteFisico() throws Exception {
		if (listaDeClientesPessoaFisica.isEmpty()){
			System.out.println("Nao ha cliente registrados.");
			menuPrincipal();
		}
		for (int i = 0 ; i < listaDeClientesPessoaFisica.size() ; i++){
			System.out.println(i+1+" - "+listaDeClientesPessoaFisica.get(i).getNome());
		}
		System.out.println("Qual cliente voce deseja excluir do registro?");
		int cliente = readIntegerOption(">", OPCAO_MINIMA_MENUD, listaDeClientesPessoaFisica.size())-1;
		listaDeClientesPessoaFisica.remove(cliente);
		System.out.println("O cliente foi removido com sucesso!");
	}
	
	private static void excluirClienteJuridico() throws Exception {
		if (listaDeClientesPessoaJuridica.isEmpty()){
			System.out.println("Nao ha cliente registrados.");
			menuPrincipal();
		}
		for (int i = 0 ; i < listaDeClientesPessoaJuridica.size() ; i++){
			System.out.println(i+1+" - "+listaDeClientesPessoaJuridica.get(i).getNomeFantasia());
		}
		System.out.println("Qual cliente voce deseja excluir do registro?");
		int cliente = readIntegerOption(">", OPCAO_MINIMA_MENUD, listaDeClientesPessoaJuridica.size())-1;
		listaDeClientesPessoaJuridica.remove(cliente);
		System.out.println("O cliente foi removido com sucesso!");
	}


	private static void menuClientesTipo(int propriedade) throws Exception{
		sb = new StringBuilder();
		sb.append("1 - Pessoa Fisica\n");
		sb.append("2 - Pessoa Juridica\n");
		System.out.println(sb.toString());
		int opcao = readIntegerOption(">", OPCAO_MINIMA_MENUD, OPCAO_MAXIMA_MENUD);
		switch(opcao){
		case(1):
			if(propriedade ==1){
				registrarClienteFisica();
				break;
			}else{
				excluirClienteFisico();
				break;
			}
		case(2):
			if(propriedade ==1){
				registrarClienteJuridico();
				break;
			}else{
				excluirClienteJuridico();
				break;
			}
		case(3):
			break;
		}
		menuPrincipal();
	}



	private static void registrarClienteJuridico() throws Exception {
		System.out.println("Informe o CNPJ do cliente (formato: xx.xxx.xxx/xxxx-xx):");
		String cnpj = readStringOption(">");
		System.out.println("Informe a razao social Cliente:");
		String razaoSocial = readStringOption(">");
		System.out.println("Informe o nome fantasia do Cliente:");
		String nomeFantasia = readStringOption(">");
		System.out.println("Informe a inscricao estadual do Cliente:");
		String inscricaoEstadual = readStringOption(">");
		System.out.println("Informe o endereco do cliente:");
		System.out.println("Em que estado esta situado o cliente:");
		for (int i = 0 ; i < UnidadeFederativa.values().length ; i++)
			System.out.println(i+1+" - "+UnidadeFederativa.values()[i].getNomePorExtenso());
		int numEstado = readIntegerOption(">", OPCAO_MINIMA_MENUD, UnidadeFederativa.values().length)-1;
		UnidadeFederativa estado = UnidadeFederativa.values()[numEstado];
		String cidade = readStringOption("Cidade: ");
		String bairro = readStringOption("Bairro: ");
		String rua = readStringOption("Rua: ");
		int numero = readIntegerOptionNoLimit("Numero: ",OPCAO_MINIMA_MENUD);
		String cep = readStringOption("CEP: ");
		String pontoDeReferencia = readStringOption("Ponto de referencia (opcional) : ");
		Endereco endereco;
		if (!pontoDeReferencia.isEmpty())
			endereco = new Endereco(estado, cidade, bairro, rua, numero, cep, pontoDeReferencia);
		else
			endereco = new Endereco(estado, cidade, bairro, rua, numero, cep);
		System.out.println("Informe o numero de telefone do cliente:");
		String telefone = readStringOption(">");
		System.out.println("Informe o email do cliente:");
		String email = readStringOption(">");
		try {
			PessoaJuridica pessoa = new PessoaJuridica(cnpj,razaoSocial,nomeFantasia,inscricaoEstadual,endereco,telefone,email);
			listaDeClientesPessoaJuridica.add(pessoa);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			menuPrincipal();
		}
		System.out.println("O cliente foi registrado com sucesso!");
		menuPrincipal();
	}

	private static void registrarClienteFisica() throws Exception {
		System.out.println("Informe o nome do Cliente:");
		String nome = readStringOption(">");
		System.out.println("Informe o cpf do Cliente:");
		String cpf = readStringOption(">");
		System.out.println("Informe o rg do Cliente:");
		String rg = readStringOption(">");
		System.out.println("Informe a data de nascimento do Cliente:");
		String nascimento = readStringOption(">");
		System.out.println("Informe a naturalidade do Cliente:");
		String naturalidade = readStringOption(">");
		System.out.println("Em que estado esta situado o cliente:");
		for (int i = 0 ; i < UnidadeFederativa.values().length ; i++)
			System.out.println(i+1+" - "+UnidadeFederativa.values()[i].getNomePorExtenso());
		int numEstado = readIntegerOption(">", OPCAO_MINIMA_MENUD, UnidadeFederativa.values().length)-1;
		UnidadeFederativa estado = UnidadeFederativa.values()[numEstado];
		String cidade = readStringOption("Cidade: ");
		String bairro = readStringOption("Bairro: ");
		String rua = readStringOption("Rua: ");
		int numero = readIntegerOptionNoLimit("Numero: ",OPCAO_MINIMA_MENUD);
		String cep = readStringOption("CEP: ");
		String pontoDeReferencia = readStringOption("Ponto de referencia (opcional) : ");
		Endereco endereco;
		if (!pontoDeReferencia.isEmpty())
			endereco = new Endereco(estado, cidade, bairro, rua, numero, cep, pontoDeReferencia);
		else
			endereco = new Endereco(estado, cidade, bairro, rua, numero, cep);
		System.out.println("Informe o numero de telefone do cliente:");
		String telefone = readStringOption(">");
		System.out.println("Informe o email do cliente:");
		String email = readStringOption(">");
		try{
			Pessoas pessoa = new PessoaFisica(cpf,nome,rg,nascimento,naturalidade,endereco,telefone,email);
			listaDeClientesPessoaFisica.add(pessoa);
		}catch (Exception e) {
			System.out.println(e.getMessage());
			menuPrincipal();
		}
		System.out.println("O cliente foi registrado com sucesso!");
		menuPrincipal();
	}

	private static void menuFuncionarios() throws Exception{
		sb = new StringBuilder();
		sb.append("1 - Registrar Funcionario\n");
		sb.append("2 - Excluir Funcionario\n");
		sb.append("3 - Voltar\n");
		System.out.println(sb.toString());
		int opcao = readIntegerOption(">", OPCAO_MINIMA_MENUD, OPCAO_MAXIMA_MENUD);
		switch(opcao){
		case(1):
			registrarFuncionario();
			break;
		case(2):
			excluirFuncionario();
			break;
		case(3):
			break;
		}
		menuPrincipal();
	}
	
	private static void excluirFuncionario() throws Exception{
		sb = new StringBuilder();
		sb.append("Que tipo de funcionario voce deseja apagar?\n");
		sb.append("1 - Gerente\n");
		sb.append("2 - Lodador\n");
		sb.append("3 - Voltar\n");
		System.out.println(sb.toString());
		int opcao = readIntegerOption(">", OPCAO_MINIMA_MENUD, OPCAO_MAXIMA_MENUD);
		if (opcao == 3)
			menuPrincipal();
		
		if (opcao == 1){
			if(listaDeGerentes.size()<=0){
				System.out.println("Nao ha gerentes cadastrados.");
				menuPrincipal();
			}
			System.out.println("Lista de gerentes:");
			for (int i = 0 ; i<listaDeGerentes.size() ; i++)
				System.out.println(i+1+" - "+listaDeGerentes.get(i).getNome());
			int del = readIntegerOption("Qual gerente voce deseja deletar? ",OPCAO_MINIMA_MENUD, listaDeGerentes.size())-1;
			listaDeGerentes.remove(del);
		}
		
		if (opcao == 2){
			if(listaDeLocadores.size()<=0){
				System.out.println("Nao ha locadores cadastrados.");
				menuPrincipal();
			}
			System.out.println("Lista de locadores:");
			for (int i = 0 ; i<listaDeLocadores.size() ; i++)
				System.out.println(i+1+" - "+listaDeLocadores.get(i).getNome());
			int del = readIntegerOption("Qual locador voce deseja deletar? ",OPCAO_MINIMA_MENUD, listaDeLocadores.size())-1;
			listaDeLocadores.remove(del);
		}
		System.out.println("O funcionario foi deletado com sucesso!");
		menuPrincipal();
	}
	
	private static void registrarFuncionario() throws Exception{
		Agencia ag;
		sb = new StringBuilder();
		sb.append("Tipo de funcionario a ser criado:\n");
		sb.append("1 - Gerente\n");
		sb.append("2 - Locador\n");
		sb.append("3 - Voltar\n");
		System.out.println(sb.toString());
		int tipo = readIntegerOption(">", OPCAO_MINIMA_MENUD, OPCAO_MAXIMA_MENUD);
		if (tipo == 3)
			menuPrincipal();
		String nome = readStringOption("Nome: ");
		String cpf = readStringOption("CPF: ");
		String rg = readStringOption("RG: ");
		String naturalidade = readStringOption("Naturalidade: ");
		System.out.println("Em que estado esta situada o cliente:");
		for (int i = 0 ; i < UnidadeFederativa.values().length ; i++)
			System.out.println(i+1+" - "+UnidadeFederativa.values()[i].getNomePorExtenso());
		int numEstado = readIntegerOption(">", OPCAO_MINIMA_MENUD, UnidadeFederativa.values().length)-1;
		UnidadeFederativa estado = UnidadeFederativa.values()[numEstado];
		String cidade = readStringOption("Cidade: ");
		String bairro = readStringOption("Bairro: ");
		String rua = readStringOption("Rua: ");
		int numero = readIntegerOptionNoLimit("Numero: ",OPCAO_MINIMA_MENUD);
		String cep = readStringOption("CEP: ");
		String pontoDeReferencia = readStringOption("Ponto de referencia (opcional) : ");
		Endereco endereco;
		if (!pontoDeReferencia.isEmpty())
			endereco = new Endereco(estado, cidade, bairro, rua, numero, cep, pontoDeReferencia);
		else
			endereco = new Endereco(estado, cidade, bairro, rua, numero, cep);
		String email = readStringOption("E-Mail: ");
		String nascimento = readStringOption("Data de nascimento: ");
		String telefone = readStringOption("Telefone: ");
		if (listaDeAgencias.size()>0){
			System.out.println("Lista de agencias disponiveis para seu funcionario trabalhar:");
			for (int i=0 ; i < listaDeAgencias.size() ; i++){
				System.out.println(i+1+" - "+listaDeAgencias.get(i).getEndereco());
			}
			int agencia = readIntegerOption(">", OPCAO_MINIMA_MENUD, listaDeAgencias.size())-1;
			ag = listaDeAgencias.get(agencia);
		}else{
			System.out.println("Nao ha agencias disponiveis para seu funcionario trabalhar no momento.");
			ag = null;
		}
		if (tipo == 1)
			listaDeGerentes.add(new Gerente(cpf, nome, rg, nascimento, naturalidade, endereco, ag, telefone, email));
		else
			listaDeLocadores.add(new Locador(cpf, nome, rg, nascimento, naturalidade, endereco, ag, telefone, email));
		System.out.println("Seu novo funcionario foi criado com sucesso!");
	}
	
	private static void menuPlanos(){
		sb = new StringBuilder();
		sb.append("1 - Registrar Plano\n");
		sb.append("2 - Excluir Plano\n");
		sb.append("3 - Voltar\n");
		System.out.println(sb.toString());
		int opcao = readIntegerOption(">", OPCAO_MINIMA_MENUD, OPCAO_MAXIMA_MENUD);
	}
	
	private static void menuVeiculos(){
		sb = new StringBuilder();
		sb.append("1 - Registrar Veiculo\n");
		sb.append("2 - Excluir Veiculo\n");
		sb.append("3 - Voltar\n");
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
	
	private static int readIntegerOptionNoLimit(String message, int lowerLimit) {
		while(true){
			try{
				System.out.print(message);
				Integer number = 0;
				do {
					number = Integer.valueOf(input.nextLine());
				}while(number < lowerLimit);
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
