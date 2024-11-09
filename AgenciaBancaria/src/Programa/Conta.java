package Programa;

import utilitarios.utils;

public class Conta {

	private static int contadorDeContas = 1;
	
	private int numeroConta;
	private Pessoa pessoa;
	private Double saldo = 0.0;
	
	public Conta( Pessoa pessoa) {
		this.numeroConta = contadorDeContas;
		this.pessoa = pessoa;
		contadorDeContas +=1; 
		
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	public String toString() {
		return "\nNúmero da conta: " + this.getNumeroConta() +
				"\nNome: " + this.pessoa.getNome() +
				"\nCPF: " + this.pessoa.getCpf() + 
				"\nEmail: " + this.pessoa.getEmail() +
				"\nSaldo: " + utils.doubleToString(this.getSaldo()) +
				"\n";
		
	}
	public void depositar(Double valor) {
		if(valor > 0) { // para depositar o valor tem que ser positivo
			setSaldo(getSaldo() + valor);  // pego o saldo que já tenho e somo com o valor que vou receber
			System.out.println("Seu depósito foi realizado com sucesso!");
		} else {
			System.out.println("Não foi possível realizar o depósito!");
		}
	}
	
	public void sacar(Double valor) {
		if(valor > 0 && this.getSaldo() >= valor) { // saber se tem saldo suficiente para realizar o saque
			setSaldo(getSaldo() - valor); // pega o saldo que tem na conta e subtrai o valor
			System.out.println("Saque realizado com sucesso!");
	} else {
			System.out.println("Não foi possível realizar o saque!");
		}
	}
	
	public void tranferir(Conta contaParaDeposito, Double valor) {
		if(valor > 0 && this.getSaldo() >= valor) { // saber se tem saldo na conta para transferir
			setSaldo(getSaldo() - valor); // subtrai o valor da conta e adiciona na conta para deposito
			
			// vai pegar o saldo que tem na conta dela e somar com o valor que vou tranferir
			contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
			System.out.println("Transfetrência realizada para sucesso!");
		}else {
			System.out.println("Não foi possível realizar a tranferência!");
		}
	}
	
	
}
