package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Conta;

public class Programa {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite os dados da conta:");
		System.out.print("Numero da conta: ");
		int numConta = sc.nextInt();
		System.out.print("Titular: ");
		sc.nextLine();
		String titular = sc.nextLine();
		System.out.print("Saldo inicial: ");
		double saldo = sc.nextDouble();
		System.out.print("Limite de saque: ");
		double limiteSaque = sc.nextDouble();
		
		Conta ct = new Conta(numConta, titular, saldo, limiteSaque);
		
		System.out.println("Digite o valor para saque: ");
		double valor = sc.nextDouble();
		
		if (valor > ct.getLimiteSaque()) {
			System.out.println("O valor excede o limite de Saque");
		}
		else if (valor > ct.getSaldo()) {
			System.out.println("Não tem saldo suficiente");
		}
		else {
			ct.saque(valor);
			System.out.println("Saldo atual R$ " + ct.getSaldo());
			
		}
		

	}

}
