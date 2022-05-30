package tdd;

import java.util.List;

public class ContaCorrente {
	private int saldo;
	private String donoDaConta;
	private List<Object> transacoes;

	public ContaCorrente() {
		
	}
	
	public ContaCorrente(int saldo) {
		this.saldo = saldo;
	}

	public ContaCorrente(String nome) {
		this.donoDaConta = nome;
	}

	public ContaCorrente(String nome, int saldo) {
		this.donoDaConta = nome;
		this.saldo = saldo;
	}
	
	public int saldo() {
		return this.saldo;
	}
	
	public int creditar(Deposito deposito) {
		this.saldo += deposito.valor;
		return deposito.valor;
	}
	
	public String extrato() {
		// pensar melhor
		String historico = "Conta de " + this.donoDaConta + "\n" +
				"Saldo Inicial $" + this.saldo + "\n" +
				"Saldo Final $" + this.saldo + "\n";
		
		if(transacoes.size() != 0) {
			historico = historico + "Nenhuma trasacao realizada\n";
		}
		
		return historico;
	}

}
