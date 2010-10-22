import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import veiculos.Automovel;
import veiculos.Motocicleta;
import veiculos.Veiculo;
import veiculos.Veiculo.Acessorios;
import veiculos.Veiculo.Cor;
import veiculos.Veiculo.TipoDeCombustivel;
import veiculos.Veiculo.TipoDeFreio;
import veiculos.Veiculo.TipoDePotencia;

import planos.PlanosAutomovel;
import planos.PlanosMoto;

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
 * @author Felipe Jose && Filipe Alencar
 *
 */

public class Start {
	
	private static StringBuilder sb;
	private static Scanner input;
	private final static int OPCAO_MINIMA_MENUP = 1;
	private final static int OPCAO_MAXIMA_MENUP = 6;
	private final static int OPCAO_MINIMA_MENUD = 1;
	private final static int OPCAO_MAXIMA_MENUD = 3;
	private final static int MINIMO_NIVEL_TANQUE = 1;
	private final static int MAXIMO_NIVEL_TANQUE = 100;
	private final static int STATUS_SUCCESS = 0;
	private final static String QUEBRA_DE_LINHA = System.getProperty("line.separator");

	private static List<Veiculo> listaDeVeiculos = new ArrayList<Veiculo>();

	private static List<PlanosAutomovel> listaDePlanosCarros = new ArrayList<PlanosAutomovel>();
	private static List<PlanosMoto> listaDePlanosMoto = new ArrayList<PlanosMoto>();

	private static List<Locador> listaDeLocadores = new ArrayList<Locador>();
	private static List<Gerente> listaDeGerentes = new ArrayList<Gerente>();
	private static List<Agencia> listaDeAgencias = new ArrayList<Agencia>();
	private static List<Pessoas> listaDeClientesPessoaFisica = new ArrayList<Pessoas>();
	private static List<PessoaJuridica> listaDeClientesPessoaJuridica = new ArrayList<PessoaJuridica>();

	public static void main(String[] args){
		input = new Scanner(System.in);
		menuPrincipal();
	}
	
	private static void menuPrincipal(){
		sb = new StringBuilder();
		sb.append("-== Main - Milestone 1 ==-"+QUEBRA_DE_LINHA);
		sb.append("--------------------------"+QUEBRA_DE_LINHA);
		sb.append("1 - Gerenciar Agencias"+QUEBRA_DE_LINHA);
		sb.append("2 - Gerenciar Clientes"+QUEBRA_DE_LINHA);
		sb.append("3 - Gerenciar Funcionarios"+QUEBRA_DE_LINHA);
		sb.append("4 - Gerenciar Planos"+QUEBRA_DE_LINHA);
		sb.append("5 - Gerenciar Veiculos"+QUEBRA_DE_LINHA);
		sb.append("6 - Sair"+QUEBRA_DE_LINHA);
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
	
	private static void menuAgencias(){
		sb = new StringBuilder();
		sb.append("1 - Registrar Agencia"+QUEBRA_DE_LINHA);
		sb.append("2 - Excluir Agencia"+QUEBRA_DE_LINHA);
		sb.append("3 - Voltar"+QUEBRA_DE_LINHA);
		System.out.println(sb.toString());
		int opcao = readIntegerOption(">", OPCAO_MINIMA_MENUD, OPCAO_MAXIMA_MENUD);
		switch(opcao){
		case(1):
			registrarAgencia();
			break;
		case(2):
			excluirAgencia();
			break;
		case(3):
			break;
		}
		menuPrincipal();
	}
	
	private static void registrarAgencia(){
		int aux = 0;
		String format = "%1$-2s - %2$-21s| ";
		if (listaDeGerentes.isEmpty()){
			System.out.println("Voce deve ter gerentes cadastrados para criar uma agencia.");
			menuPrincipal();
		}
		System.out.println("Informe o CNPJ da filial (formato: xx.xxx.xxx/xxxx-xx):");
		String cnpj = readStringOption(">");
		System.out.println("Em que estado esta situada a agencia:");
		for (int i = 0 ; i < UnidadeFederativa.values().length ; i++){
			if (aux<=4){
				System.out.format(format, i+1,UnidadeFederativa.values()[i].getNomePorExtenso());
				aux++;
			}
			if (aux==4){ 
				System.out.println();
				aux=0;
			}
		}
		System.out.println("");
		int numEstado = readIntegerOption(">", OPCAO_MINIMA_MENUD, UnidadeFederativa.values().length)-1;
		UnidadeFederativa estado = UnidadeFederativa.values()[numEstado];
		String cidade = readStringOption("Cidade: ");
		String bairro = readStringOption("Bairro: ");
		String rua = readStringOption("Rua: ");
		int numero = readIntegerOptionNoLimit("Numero: ",OPCAO_MINIMA_MENUD);
		String cep = readStringOption("CEP: ");
		String pontoDeReferencia = readStringOption("Ponto de referencia (opcional) : ");
		Endereco endereco = null;
		if (!pontoDeReferencia.isEmpty())
			try {
				endereco = new Endereco(estado, cidade, bairro, rua, numero, cep, pontoDeReferencia);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				menuPrincipal();
			}
		else
			try {
				endereco = new Endereco(estado, cidade, bairro, rua, numero, cep);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				menuPrincipal();
			}
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
		try {
			listaDeAgencias.add(new Filial(cnpj, endereco, telefone, inscEstadual, g));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			menuPrincipal();
		}
		System.out.println("A sua agencia foi registrada com sucesso!");
	}
	
	private static void excluirAgencia(){
		if (listaDeAgencias.isEmpty()){
			System.out.println("Nao ha agencias criadas.");
			menuPrincipal();
		}
		for (int i = 0 ; i < listaDeAgencias.size() ; i++){
			Endereco endereco = listaDeAgencias.get(i).getEndereco();
			System.out.println(i+1+" - Filial situada em: "+endereco.getCidade() + " - " + endereco.getEstado().toString() + 
					" / "+endereco.getRua()+","+endereco.getNumero()+","+endereco.getBairro());
		}
		System.out.println("Qual agencia voce deseja excluir do registro?");
		int agencia = readIntegerOption(">", OPCAO_MINIMA_MENUD, listaDeAgencias.size())-1;
		listaDeAgencias.remove(agencia);
		System.out.println("A agencia foi removida com sucesso!");
	}
	
	private static void menuClientes(){
		sb = new StringBuilder();
		sb.append("1 - Registrar Cliente"+QUEBRA_DE_LINHA);
		sb.append("2 - Excluir Cliente"+QUEBRA_DE_LINHA);
		sb.append("3 - Voltar"+QUEBRA_DE_LINHA);
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
	
	private static void excluirClienteFisico(){
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
	
	private static void excluirClienteJuridico(){
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


	private static void menuClientesTipo(int propriedade){
		sb = new StringBuilder();
		sb.append("1 - Pessoa Fisica"+QUEBRA_DE_LINHA);
		sb.append("2 - Pessoa Juridica"+QUEBRA_DE_LINHA);
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



	private static void registrarClienteJuridico(){
		int aux = 0;
		String format = "%1$-2s - %2$-21s| ";
		System.out.println("Informe o CNPJ do cliente (formato: xx.xxx.xxx/xxxx-xx):");
		String cnpj = readStringOption(">");
		System.out.println("Informe a razao social Cliente:");
		String razaoSocial = readStringOption(">");
		System.out.println("Informe o nome fantasia do Cliente:");
		String nomeFantasia = readStringOption(">");
		System.out.println("Informe a inscricao estadual do Cliente:");
		String inscricaoEstadual = readStringOption(">");
		System.out.println("Informe o endereco do cliente:");
		System.out.println("Em que estado mora o cliente:");
		for (int i = 0 ; i < UnidadeFederativa.values().length ; i++){
			if (aux<=4){
				System.out.format(format, i+1,UnidadeFederativa.values()[i].getNomePorExtenso());
				aux++;
			}
			if (aux==4){ 
				System.out.println();
				aux=0;
			}
		}
		System.out.println("");
		int numEstado = readIntegerOption(">", OPCAO_MINIMA_MENUD, UnidadeFederativa.values().length)-1;
		UnidadeFederativa estado = UnidadeFederativa.values()[numEstado];
		String cidade = readStringOption("Cidade: ");
		String bairro = readStringOption("Bairro: ");
		String rua = readStringOption("Rua: ");
		int numero = readIntegerOptionNoLimit("Numero: ",OPCAO_MINIMA_MENUD);
		String cep = readStringOption("CEP: ");
		String pontoDeReferencia = readStringOption("Ponto de referencia (opcional) : ");
		Endereco endereco = null;
		if (!pontoDeReferencia.isEmpty())
			try {
				endereco = new Endereco(estado, cidade, bairro, rua, numero, cep, pontoDeReferencia);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				menuPrincipal();
			}
		else
			try {
				endereco = new Endereco(estado, cidade, bairro, rua, numero, cep);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				menuPrincipal();
			}
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

	private static void registrarClienteFisica(){
		int aux = 0;
		String format = "%1$-2s - %2$-21s| ";
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
		System.out.println("Em que estado mora o cliente:");
		for (int i = 0 ; i < UnidadeFederativa.values().length ; i++){
			if (aux<=4){
				System.out.format(format, i+1,UnidadeFederativa.values()[i].getNomePorExtenso());
				aux++;
			}
			if (aux==4){ 
				System.out.println();
				aux=0;
			}
		}
		System.out.println("");
		int numEstado = readIntegerOption(">", OPCAO_MINIMA_MENUD, UnidadeFederativa.values().length)-1;
		UnidadeFederativa estado = UnidadeFederativa.values()[numEstado];
		String cidade = readStringOption("Cidade: ");
		String bairro = readStringOption("Bairro: ");
		String rua = readStringOption("Rua: ");
		int numero = readIntegerOptionNoLimit("Numero: ",OPCAO_MINIMA_MENUD);
		String cep = readStringOption("CEP: ");
		String pontoDeReferencia = readStringOption("Ponto de referencia (opcional) : ");
		Endereco endereco = null;
		if (!pontoDeReferencia.isEmpty())
			try {
				endereco = new Endereco(estado, cidade, bairro, rua, numero, cep, pontoDeReferencia);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				menuPrincipal();
			}
		else
			try {
				endereco = new Endereco(estado, cidade, bairro, rua, numero, cep);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				menuPrincipal();
			}
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

	private static void menuFuncionarios(){
		sb = new StringBuilder();
		sb.append("1 - Registrar Funcionario"+QUEBRA_DE_LINHA);
		sb.append("2 - Excluir Funcionario"+QUEBRA_DE_LINHA);
		sb.append("3 - Voltar"+QUEBRA_DE_LINHA);
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
	
	private static void excluirFuncionario(){
		sb = new StringBuilder();
		sb.append("Que tipo de funcionario voce deseja apagar?"+QUEBRA_DE_LINHA);
		sb.append("1 - Gerente"+QUEBRA_DE_LINHA);
		sb.append("2 - Locador"+QUEBRA_DE_LINHA);
		sb.append("3 - Voltar"+QUEBRA_DE_LINHA);
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
	
	private static void registrarFuncionario(){
		Agencia ag;
		sb = new StringBuilder();
		String format = "%1$-2s - %2$-21s| ";
		int aux = 0;
		sb.append("Tipo de funcionario a ser criado:"+QUEBRA_DE_LINHA);
		sb.append("1 - Gerente"+QUEBRA_DE_LINHA);
		sb.append("2 - Locador"+QUEBRA_DE_LINHA);
		sb.append("3 - Voltar"+QUEBRA_DE_LINHA);
		System.out.println(sb.toString());
		int tipo = readIntegerOption(">", OPCAO_MINIMA_MENUD, OPCAO_MAXIMA_MENUD);
		if (tipo == 3)
			menuPrincipal();
		String nome = readStringOption("Nome: ");
		String cpf = readStringOption("CPF: ");
		String rg = readStringOption("RG: ");
		String naturalidade = readStringOption("Naturalidade: ");
		System.out.println("Em que estado mora o funcionario:");
		for (int i = 0 ; i < UnidadeFederativa.values().length ; i++){
			if (aux<=4){
				System.out.format(format, i+1,UnidadeFederativa.values()[i].getNomePorExtenso());
				aux++;
			}
			if (aux==4){ 
				System.out.println();
				aux=0;
			}
		}
		System.out.println("");
		int numEstado = readIntegerOption(">", OPCAO_MINIMA_MENUD, UnidadeFederativa.values().length)-1;
		UnidadeFederativa estado = UnidadeFederativa.values()[numEstado];
		String cidade = readStringOption("Cidade: ");
		String bairro = readStringOption("Bairro: ");
		String rua = readStringOption("Rua: ");
		int numero = readIntegerOptionNoLimit("Numero: ",OPCAO_MINIMA_MENUD);
		String cep = readStringOption("CEP: ");
		String pontoDeReferencia = readStringOption("Ponto de referencia (opcional) : ");
		Endereco endereco = null;
		if (!pontoDeReferencia.isEmpty())
			try{
				endereco = new Endereco(estado, cidade, bairro, rua, numero, cep, pontoDeReferencia);
			}catch(Exception e){
				System.out.println(e.getMessage());
				menuPrincipal();
			}
		else
			try {
				endereco = new Endereco(estado, cidade, bairro, rua, numero, cep);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				menuPrincipal();
			}
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
			try {
				listaDeGerentes.add(new Gerente(cpf, nome, rg, nascimento, naturalidade, endereco, ag, telefone, email));
			} catch (Exception e) {
				System.out.println(e.getMessage());
				menuPrincipal();
			}
		else
			try {
				listaDeLocadores.add(new Locador(cpf, nome, rg, nascimento, naturalidade, endereco, ag, telefone, email));
			} catch (Exception e) {
				System.out.println(e.getMessage());
				menuPrincipal();
			}
		System.out.println("Seu novo funcionario foi criado com sucesso!");
	}
	
	private static void menuPlanos(){
		sb = new StringBuilder();
		sb.append("1 - Registrar Plano"+QUEBRA_DE_LINHA);
		sb.append("2 - Excluir Plano"+QUEBRA_DE_LINHA);
		sb.append("3 - Voltar"+QUEBRA_DE_LINHA);
		System.out.println(sb.toString());
		int opcao = readIntegerOption(">", OPCAO_MINIMA_MENUD, OPCAO_MAXIMA_MENUD);
		switch(opcao){
		case(1):
			menuRegistraPlanos();
			break;
		case(2):
			menuExcluiPlanos();
			break;
		case(3):
			break;
		}
		menuPrincipal();	
	}
	
	private static void menuExcluiPlanos() {
		sb = new StringBuilder();
		sb.append("1 - Excluir Plano de Carro"+QUEBRA_DE_LINHA);
		sb.append("2 - Excluir Plano de Moto"+QUEBRA_DE_LINHA);
		sb.append("3 - Voltar"+QUEBRA_DE_LINHA);
		System.out.println(sb.toString());
		int opcao = readIntegerOption(">", OPCAO_MINIMA_MENUD, OPCAO_MAXIMA_MENUD);
		switch(opcao){
		case(1):
			excluirPlanoDeCarro();
			break;
		case(2):
			excluirPlanoDeMoto();
			break;
		case(3):
			break;
		}
		menuPrincipal();	
	}

	private static void excluirPlanoDeMoto(){
		if (listaDePlanosMoto.isEmpty()){
			System.out.println("Nao ha planos criados.");
			menuPrincipal();
		}
		for (int i = 0 ; i < listaDePlanosMoto.size() ; i++){
			System.out.println(i+1+" - "+listaDePlanosMoto.get(i).getNome());
		}
		System.out.println("Qual plano voce deseja excluir do registro?");
		int plano = readIntegerOption(">", OPCAO_MINIMA_MENUD, listaDePlanosMoto.size())-1;
		listaDePlanosMoto.remove(plano);	
		System.out.println("O plano foi excluido com sucesso!");
		
	}

	private static void excluirPlanoDeCarro(){
		if (listaDePlanosCarros.isEmpty()){
			System.out.println("Nao ha planos criados.");
			menuPrincipal();
		}
		for (int i = 0 ; i < listaDePlanosCarros.size() ; i++){
			System.out.println(i+1+" - "+listaDePlanosCarros.get(i).getNome());
		}
		System.out.println("Qual plano voce deseja excluir do registro?");
		int plano = readIntegerOption(">", OPCAO_MINIMA_MENUD, listaDePlanosCarros.size())-1;
		listaDePlanosCarros.remove(plano);		
		System.out.println("O plano foi excluido com sucesso!");
	}

	private static void menuRegistraPlanos() {
		sb = new StringBuilder();
		sb.append("1 - Registrar Plano de Carro"+QUEBRA_DE_LINHA);
		sb.append("2 - Registrar Plano de Moto"+QUEBRA_DE_LINHA);
		sb.append("3 - Voltar"+QUEBRA_DE_LINHA);
		System.out.println(sb.toString());
		int opcao = readIntegerOption(">", OPCAO_MINIMA_MENUD, OPCAO_MAXIMA_MENUD);
		switch(opcao){
		case(1):
			registrarPlanoCarro();
			break;
		case(2):
			registrarPlanoMoto();
			break;
		case(3):
			break;
		}
		menuPrincipal();			
	}

	private static void registrarPlanoMoto() {
		String nomeDoPlano = readStringOption("Nome do plano:");
		double preco = readDoubleOptionNoLimit("Preco: ", 0);
		int cilindradas = readIntegerOptionNoLimit("Cilindradas maxima:", 0);
		PlanosMoto plano = new PlanosMoto(nomeDoPlano,preco);
		plano.adicionaCilindradas(cilindradas);
		listaDePlanosMoto.add(plano);
		System.out.println("O plano foi criado com sucesso!");
	}

	private static void registrarPlanoCarro() {
		String nomeDoPlano = readStringOption("Nome do plano:");
		double preco = readDoubleOptionNoLimit("Preco: ", 0);
		List<Acessorios> acessoriosDoPlano = pegarAcessorios();
		PlanosAutomovel plano = new PlanosAutomovel(nomeDoPlano,preco);
		plano.adicionaListaAcessorios(acessoriosDoPlano);
		listaDePlanosCarros.add(plano);
		System.out.println("O plano foi criado com sucesso!");
	}

	private static void menuVeiculos(){
		sb = new StringBuilder();
		sb.append("1 - Registrar Veiculo"+QUEBRA_DE_LINHA);
		sb.append("2 - Excluir Veiculo"+QUEBRA_DE_LINHA);
		sb.append("3 - Voltar"+QUEBRA_DE_LINHA);
		System.out.println(sb.toString());
		int opcao = readIntegerOption(">", OPCAO_MINIMA_MENUD, OPCAO_MAXIMA_MENUD);
		switch(opcao){
		case(1):
			registrarVeiculo();
			break;
		case(2):
			excluirVeiculo();
			break;
		case(3):
			break;
		}
		menuPrincipal();
	}
	
	private static boolean temCarro(List<Veiculo> lista){
		int qntCarros = 0;
		for (Veiculo veiculo : listaDeVeiculos){
			if (veiculo instanceof Automovel)
				qntCarros++;			
		}
		if (qntCarros <= 0)
			return false;
		return true;
	}

	private static boolean temMoto(List<Veiculo> lista){
		int qntMotos = 0;
		for (Veiculo veiculo : listaDeVeiculos){
			if (veiculo instanceof Motocicleta)
				qntMotos++;			
		}
		if (qntMotos <= 0)
			return false;
		return true;
	}
	
	private static ArrayList<Acessorios> pegarAcessorios(){
		int opcao = 0;
		ArrayList<Acessorios> lista = new ArrayList<Veiculo.Acessorios>();
		System.out.println("Adicionar Acessorios: ");
		for (int i = 0 ; i< Acessorios.values().length ; i++)
			System.out.println(i+1 + " - "+Acessorios.values()[i].getNomeCompleto());
		System.out.println(Acessorios.values().length+1+" - Nao desejo mais adicionar acessorios");
		while(!(opcao == Acessorios.values().length)){
			opcao = readIntegerOption("Acessorio a ser adicionado: ", OPCAO_MINIMA_MENUD, Acessorios.values().length+1)-1;
			if(opcao <= 8){
				lista.add(Acessorios.values()[opcao]);
				System.out.println(Acessorios.values()[opcao].getNomeCompleto()+ " adicionado(a) com sucesso!");
			}
		}
		return lista;
	}
	
	private static void registrarVeiculo(){
		String renavam;
		String modelo;
		String marca;
		int potencia;
		int ano;
		int corn;
		Cor cor;
		int tipoDeCombustiveln;
		TipoDeCombustivel tipoDeCombustivel;
		int tipoDeFreion;
		TipoDeFreio tipoDeFreio;
		Endereco endereco;
		int agencia;
		Agencia localizacao;
		String dataDeAquisicao;
		int nivelDoTanque;
		Veiculo v;
		int tipoDePotencian;
		TipoDePotencia tipoDePotencia;
		
		if (listaDeAgencias.size() <= 0){
			System.out.println("Voce nao tem agencias registradas, sendo assim, nao pode registrar veiculos.");
			menuPrincipal();
		}
		sb = new StringBuilder();
		sb.append("Que tipo de veiculo voce deseja registrar?"+QUEBRA_DE_LINHA);
		sb.append("1 - Carro"+QUEBRA_DE_LINHA);
		sb.append("2 - Moto"+QUEBRA_DE_LINHA);
		sb.append("3 - Voltar"+QUEBRA_DE_LINHA);
		System.out.println(sb.toString());
		int opcao = readIntegerOption(">", OPCAO_MINIMA_MENUD, OPCAO_MAXIMA_MENUD);

		switch(opcao){
		case(1):
			System.out.println("Informacoes do veiculo: ");
			renavam = readStringOption("RENAVAM: ");
			modelo = readStringOption("Modelo: ");
			marca = readStringOption("Marca: ");
			System.out.println("Tipo de potencia:");
			for (int i = 0 ; i<TipoDePotencia.values().length ; i++)
				System.out.println(i+1+" - " + TipoDePotencia.values()[i].toString());
			tipoDePotencian = readIntegerOption(">", OPCAO_MINIMA_MENUD, TipoDePotencia.values().length)-1;
			tipoDePotencia = TipoDePotencia.values()[tipoDePotencian];
			potencia =  readIntegerOptionNoLimit("Potencia do carro (em "+tipoDePotencia.toString()+"): ", OPCAO_MINIMA_MENUD);
			ano =  readIntegerOptionNoLimit("Ano do carro: ", OPCAO_MINIMA_MENUD);
			System.out.println("Cor do carro: ");
			for (int i = 0 ; i< Cor.values().length ; i++)
				System.out.println(i+1+" - " + Cor.values()[i].toString());
			corn = readIntegerOption(">", OPCAO_MINIMA_MENUD, Cor.values().length)-1;
			cor = Cor.values()[corn];
			System.out.println("Tipo de combustivel:");
			for (int i = 0 ; i<TipoDeCombustivel.values().length ; i++)
				System.out.println(i+1+" - " + TipoDeCombustivel.values()[i].toString());
			tipoDeCombustiveln = readIntegerOption(">", OPCAO_MINIMA_MENUD, TipoDeCombustivel.values().length)-1;
			tipoDeCombustivel = TipoDeCombustivel.values()[tipoDeCombustiveln];
			System.out.println("Tipo de freio:");
			for (int i = 0 ; i<TipoDeFreio.values().length ; i++)
				System.out.println(i+1+" - " + TipoDeFreio.values()[i].toString());
			tipoDeFreion = readIntegerOption(">", OPCAO_MINIMA_MENUD, TipoDeFreio.values().length)-1;
			tipoDeFreio = TipoDeFreio.values()[tipoDeFreion];
			System.out.println("Localizacao:");
			for (int i = 0 ; i < listaDeAgencias.size() ; i++){
				endereco = listaDeAgencias.get(i).getEndereco();
				System.out.println(i+1+" - Filial situada em: "+endereco.getCidade() + " - " + endereco.getEstado().toString() + 
						" / "+endereco.getRua()+","+endereco.getNumero()+","+endereco.getBairro());
			}
			agencia = readIntegerOption(">", OPCAO_MINIMA_MENUD, listaDeAgencias.size())-1;
			localizacao = listaDeAgencias.get(agencia);
			dataDeAquisicao = readStringOption("Data de aquisicao do veiculo (Formato XX/XX/XXXX): ");
			ArrayList<Acessorios> listaDeAcessorios = pegarAcessorios();
			nivelDoTanque = readIntegerOption("Nivel do tanque(0-100): ", MINIMO_NIVEL_TANQUE , MAXIMO_NIVEL_TANQUE);
			v = null;
			try {
				v = new Automovel(renavam, modelo, marca, potencia, ano, cor, tipoDeFreio, tipoDeCombustivel, localizacao, dataDeAquisicao, nivelDoTanque, listaDeAcessorios, tipoDePotencia);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				menuPrincipal();
			}
			listaDeVeiculos.add(v);
			System.out.println("O carro foi adicionado com sucesso!");
			break;
		case(2):
			
			System.out.println("Informacoes do veiculo: ");
			renavam = readStringOption("RENAVAM: ");
			modelo = readStringOption("Modelo: ");
			marca = readStringOption("Marca: ");
			int cilindradas = readIntegerOptionNoLimit("Cilindradas: ", OPCAO_MINIMA_MENUD);
			System.out.println("Tipo de potencia:");
			for (int i = 0 ; i<TipoDePotencia.values().length ; i++)
				System.out.println(i+1+" - " + TipoDePotencia.values()[i].toString());
			tipoDePotencian = readIntegerOption(">", OPCAO_MINIMA_MENUD, TipoDePotencia.values().length)-1;
			tipoDePotencia = TipoDePotencia.values()[tipoDePotencian];
			potencia =  readIntegerOptionNoLimit("Potencia da moto (em "+tipoDePotencia.toString()+"): ", OPCAO_MINIMA_MENUD);
			ano =  readIntegerOptionNoLimit("Ano da moto: ", OPCAO_MINIMA_MENUD);
			System.out.println("Cor da moto: ");
			for (int i = 0 ; i< Cor.values().length ; i++)
				System.out.println(i+1+" - " + Cor.values()[i].toString());
			corn = readIntegerOption(">", OPCAO_MINIMA_MENUD, Cor.values().length)-1;
			cor = Cor.values()[corn];
			System.out.println("Tipo de combustivel:");
			for (int i = 0 ; i<TipoDeCombustivel.values().length ; i++)
				System.out.println(i+1+" - " + TipoDeCombustivel.values()[i].toString());
			tipoDeCombustiveln = readIntegerOption(">", OPCAO_MINIMA_MENUD, TipoDeCombustivel.values().length)-1;
			tipoDeCombustivel = TipoDeCombustivel.values()[tipoDeCombustiveln];
			System.out.println("Tipo de freio:");
			for (int i = 0 ; i<TipoDeFreio.values().length ; i++)
				System.out.println(i+1+" - " + TipoDeFreio.values()[i].toString());
			tipoDeFreion = readIntegerOption(">", OPCAO_MINIMA_MENUD, TipoDeFreio.values().length)-1;
			tipoDeFreio = TipoDeFreio.values()[tipoDeFreion];
			System.out.println("Localizacao:");
			for (int i = 0 ; i < listaDeAgencias.size() ; i++){
				endereco = listaDeAgencias.get(i).getEndereco();
				System.out.println(i+1+" - Filial situada em: "+endereco.getCidade() + " - " + endereco.getEstado().toString() + 
						" / "+endereco.getRua()+","+endereco.getNumero()+","+endereco.getBairro());
			}
			agencia = readIntegerOption(">", OPCAO_MINIMA_MENUD, listaDeAgencias.size())-1;
			localizacao = listaDeAgencias.get(agencia);
			dataDeAquisicao = readStringOption("Data de aquisicao do veiculo (Formato XX/XX/XXXX): ");
			nivelDoTanque = readIntegerOption("Nivel do tanque(0-100): ", MINIMO_NIVEL_TANQUE , MAXIMO_NIVEL_TANQUE);
			v = null;
			try {
				v = new Motocicleta(renavam, modelo, marca, tipoDePotencia, potencia, cilindradas, ano, cor, tipoDeCombustivel, localizacao, dataDeAquisicao, nivelDoTanque);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				menuPrincipal();
			}
			listaDeVeiculos.add(v);
			System.out.println("A moto foi adicionada com sucesso!");
			break;
			case(3):
				break;
			}
		menuPrincipal();
	}
				
	private static void excluirVeiculo(){
		sb = new StringBuilder();
		int numeroContador = 0;
		int indexApagar;
		sb.append("Que tipo de veiculo voce deseja excluir?"+QUEBRA_DE_LINHA);
		sb.append("1 - Carro"+QUEBRA_DE_LINHA);
		sb.append("2 - Moto"+QUEBRA_DE_LINHA);
		sb.append("3 - Voltar"+QUEBRA_DE_LINHA);
		System.out.println(sb.toString());
		int opcao = readIntegerOption(">", OPCAO_MINIMA_MENUD, OPCAO_MAXIMA_MENUD);
		switch(opcao){
		case(1):
			if (!temCarro(listaDeVeiculos)){
				System.out.println("Nao ha nenhum carro cadastrado!");
				menuPrincipal();
			}
			System.out.println("Lista de carros disponiveis:");
			for (Veiculo v : listaDeVeiculos){
				if (v instanceof Automovel) {
					numeroContador++;
					System.out.println(numeroContador + " - " + v.getMarca() + " " + v.getModelo() + "/ RENAVAM: " +v.getRenavam());
				}
			}
			indexApagar = readIntegerOption("Qual carro sera apagado? ", OPCAO_MINIMA_MENUD, numeroContador)-1;
			listaDeVeiculos.remove(indexApagar);
			System.out.println("O carro foi removido com sucesso.");
			break;
		case(2):
			if (!temMoto(listaDeVeiculos)){
				System.out.println("Nao ha nenhuma moto cadastrada!");
				menuPrincipal();
			}
			System.out.println("Lista de motos disponiveis:");
			for (Veiculo v : listaDeVeiculos){
				if (v instanceof Motocicleta) {
					numeroContador++;
					System.out.println(numeroContador + " - " + v.getMarca() + " " + v.getModelo() + "/ RENAVAM: " +v.getRenavam());
				}
			}
			indexApagar = readIntegerOption("Qual moto sera apagada? ", OPCAO_MINIMA_MENUD, numeroContador)-1;
			listaDeVeiculos.remove(indexApagar);
			System.out.println("A moto foi removida com sucesso.");
			break;
		case(3):
			break;
		}
		menuPrincipal();
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
	private static double readDoubleOptionNoLimit(String message, int lowerLimit) {
		while(true){
			try{
				System.out.print(message);
				double number = 0;
				do {
					number = Double.valueOf(input.nextLine());
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
