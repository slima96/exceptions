package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Conta;
import model.exceptions.ExcecaoDominio;

public class Programa {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
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

			System.out.print("Digite o valor para saque: ");
			double valor = sc.nextDouble();
			
			ct.saque(valor);
			System.out.println(ct);

		}
		
		catch (ExcecaoDominio e) {
			System.out.println("Erro no saque: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Erro inesperado!");
		}
						
		
		sc.close();
	}

}