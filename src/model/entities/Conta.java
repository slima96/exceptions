package model.entities;

import model.exceptions.ExcecaoDominio;

public class Conta {

	private Integer numConta;
	private String titular;
	private Double saldo;
	private Double limiteSaque;

	public Conta(Integer numConta, String titular, Double saldo, Double limiteSaque) {
		this.numConta = numConta;
		this.titular = titular;
		this.saldo = saldo;
		this.limiteSaque = limiteSaque;
	}

	public Integer getNumConta() {
		return numConta;
	}

	public void setNumConta(Integer numConta) {
		this.numConta = numConta;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Double getSaldo() {
		return saldo;
	}

	public Double getLimiteSaque() {
		return limiteSaque;
	}

	public void setLimiteSaque(Double limiteSaque) {
		this.limiteSaque = limiteSaque;
	}

	public void deposito(double valor) {
		saldo += valor;
	}

	public void saque(double valor) throws ExcecaoDominio {
		if (valor > getLimiteSaque()) {
			throw new ExcecaoDominio("O valor excede o limite de Saque");
		} 
		else if (valor > getSaldo()) {
			throw new ExcecaoDominio("Não tem saldo suficiente");
		} 
		
		saldo -= valor;
		
		
	}

	@Override
	public String toString() {
		return "Saldo atual R$ " + getSaldo();
	}

}
