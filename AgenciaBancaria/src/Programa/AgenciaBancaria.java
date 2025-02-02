package Programa;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {

	static Scanner input = new Scanner(System.in);
	static ArrayList<Conta> contasBancarias; 
	
	public static void main(String[] args) {
		contasBancarias = new ArrayList<Conta>();
		operacoes();
	}
	
	public static void operacoes() {
		
		System.out.println("------------------------------------------------------");
		System.out.println("-------------Bem vindos a nossa Agência---------------");
		System.out.println("------------------------------------------------------");
		System.out.println("***** Selecione uma operação que deseja realizar *****");
		System.out.println("------------------------------------------------------");
		System.out.println("|   Opção 1 - Criar conta   |");
		System.out.println("|   Opção 2 - Depositar     |");
		System.out.println("|   Opção 3 - Sacar         |");
		System.out.println("|   Opção 4 - Transferir    |");
		System.out.println("|   Opção 5 - Listar        |");
		System.out.println("|   Opção 6 - Sair          |");
		
		int operacao = input.nextInt();
		
		switch(operacao) {
		case 1:
			criarConta();
			break;
		case 2:
			depositar();
			break;
		case 3:
			sacar();
			break;
		case 4:
			transferir();
			break;
		case 5:
			listarContas();
			break;
		case 6:
			System.out.println("Você está saindo, obrigado por usar nossa agência");
			System.exit(0);
			
		default:
			System.out.println("Opção inválida!");
			operacoes();
			break;
			
			
		}
		
		
	}
	
	public static void criarConta() {
		 
		System.out.println("\nNome: ");
		String nome = input.next(); // armazena o nome que o usuário digitar
		
		System.out.println("\nCPF: ");
		String cpf = input.next();
		
		System.out.println("\nEmail: ");
		String email = input.next();
		
		Pessoa pessoa = new Pessoa(nome, cpf, email);
		
		Conta conta = new Conta(pessoa);
		
		contasBancarias.add(conta);
		System.out.println("Sua conta foi criada com sucesso!");
		
		operacoes();
		
	}
	private static Conta encontrarConta(int numeroConta) { // vai verificar se a conta com número que o usuário digitou existe
		Conta conta = null;
		if(contasBancarias.size() > 0) { // verifica se tem contas bancarias dentro da agência
			for(Conta c: contasBancarias) {
				if(c.getNumeroConta() == numeroConta) {
				conta = c;
				}
			}
		}
		return conta;
	}
	
	public static void depositar() {
		System.out.println("Número da conta: "); // pede o número da conta pro usuario
		int numeroConta = input.nextInt(); // armazenou o número
		
		Conta conta = encontrarConta(numeroConta); // passou o número para o metódo encontrar a conta
		
		if(conta != null) { // se existir a conta vai perguntar quanto o usuário quer depositar
			System.out.println("Qual valor deseja depositar? ");
			Double valorDeposito = input.nextDouble(); // armazena o valor depositado
			conta.depositar(valorDeposito); // passa o valor depositado para o método depositar
			System.out.println("Valor depositado com sucesso! ");
		}else {
			System.out.println("Conta não encontrada! ");
		}
		operacoes();
	}
	
	public static void sacar() {
		System.out.println("Número da conta: ");
		int numeroConta = input.nextInt();
		
		Conta conta = encontrarConta(numeroConta);
		
		if(conta != null) {
			System.out.println("Qual valor deseja sacar? ");
			Double valorSaque = input.nextDouble();
			conta.sacar(valorSaque);
			// System.out.println("Valor sacado com sucesso! ");
		}else {
			System.out.println("Conta não encontrada! ");
		}
		operacoes();
	}
	
	public static void transferir() {
		System.out.println("Número conta do remetente: ");
		int numeroContaRemetente = input.nextInt();
		
		Conta contaRemetente = encontrarConta(numeroContaRemetente);
		
		if(contaRemetente != null) { // se a conta existir
			System.out.println("Número da conta do destinatário: ");
			int numeroContaDestinatario = input.nextInt();
			
			Conta contaDestinatario = encontrarConta(numeroContaDestinatario);
			
			if(contaDestinatario != null) { // verifica se a conta existe
				System.out.println("Valor da transferência: ");
				Double valor = input.nextDouble();
				
				contaRemetente.tranferir(contaDestinatario, valor);
			}else {
				System.out.println("A conta para depósito não foi encontrada");
			}
		}else {
			System.out.println("Conta para transferência não encontrada");
		}
		operacoes();
	}
	
	public static void listarContas() {
		if (contasBancarias.size() > 0) {
			for (Conta conta : contasBancarias) {
				System.out.println(conta);
			}
		} else {
			System.out.println("Não há contas cadastradas! ");
		}
		operacoes();
	}

}


