package account.model;

import account.util.Colors;

public class Account {
	// Atributos - Variáveis
	private int number;
	private int agency;
	private int type;
	private String holder;
	private float balance;

	// Método Especial - Método Construtor
	public Account(int number, int agency, int type, String holder, float balance) {

		this.number = number;
		this.agency = agency;
		this.type = type;
		this.holder = holder;
		this.balance = balance;

	}

	// Métodos de Acesso - Getters e Setters

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getAgency() {
		return agency;
	}

	public void setAgency(int agency) {
		this.agency = agency;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	// Comportamentos - Métodos
	public boolean withdraw(float value) {
		// If pra se o saldo for menor que o valor retornar saldo insuficiente
		if (this.getBalance() < value) {
			System.out.println("| Insufficient balance!                   ");
			return false;
		}
		// Saque pegando saldo atual e tirando valor do usuário
		this.setBalance(this.getBalance() - value);
		return true;

	}

	public void deposit(float value) {
		// Setando o novo saldo pegando o saldo atual e adicionando o valor do usuário
		this.setBalance(this.getBalance() + value);
		System.out.printf("| %.2f was added to your account!       ", value);

	}

	public void visualize() {
		String type = "";
		// switch para trocar a conta corrente de acordo com o 1 ou 2 do type
		switch (this.type) {
		case 1:
			type = "Conta corrente";
			break;

		case 2:
			type = "Conta poupança";
			break;
		}
		// print dos detalhes da conta
		
		System.out.println(Colors.TEXT_BLUE_BOLD + Colors.ANSI_YELLOW_BACKGROUND);
		System.out.println("------------------------------------------");
		System.out.println("|        ------------------------        |");
		System.out.println("|        |     Account Data     |        |");
		System.out.println("|        ------------------------        |");
		System.out.println("|----------------------------------------|");
		System.out.println("|----------------------------------------|");
		System.out.printf("|   Account Number: %d                    |\n", this.number);
		System.out.printf("|   Agency Number: %d                     |\n", this.agency);
		System.out.printf("|   Account Type: %s         |\n", type);
		System.out.printf("|   Account Holder: %s            |\n", this.holder);
		System.out.printf("|   Balance: %.2f                     |\n", this.balance);
		System.out.println("|----------------------------------------|");

	}

}
