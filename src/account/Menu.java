package account;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import account.controller.AccountController;
import account.model.CurrentAccount;
import account.model.SavingsAccount;
import account.util.Colors;

public class Menu {

	public static void main(String[] args) {
		AccountController account = new AccountController();
		Scanner sc = new Scanner(System.in);

		int option, number, agency, type, birthday, destinyNumber;
		String holder;
		float balance, limit, value;

		// TESTING ACCOUNTS
		CurrentAccount ca1 = new CurrentAccount(account.genNumber(), 1, 1, "João Adams", 1000f, 100.0f);
		account.signup(ca1);

		CurrentAccount ca2 = new CurrentAccount(account.genNumber(), 2, 1, "Paulo Timão ", 2000f, 100.0f);
		account.signup(ca2);

		SavingsAccount sa1 = new SavingsAccount(account.genNumber(), 3, 2, "Marcelo Porco", 3000f, 12);
		account.signup(sa1);

		SavingsAccount sa2 = new SavingsAccount(account.genNumber(), 4, 2, "Lucas Mateus", 5000f, 20);
		account.signup(sa2);

		account.listAll();

		while (true) {
			System.out.println(Colors.TEXT_BLUE_BOLD + Colors.ANSI_GREEN_BACKGROUND);
			System.out.println("------------------------------------------");
			System.out.println("|        ------------------------        |");
			System.out.println("|        | Brazilian Trust Bank |        |");
			System.out.println("|        ------------------------        |");
			System.out.println("|----------------------------------------|");
			System.out.println("|----------------------------------------|");
			System.out.println("|                 |MENU|                 |");
			System.out.println("|                                        |");
			System.out.println("|        1 - Create an account           |");
			System.out.println("|        2 - List all accounts           |");
			System.out.println("|        3 - Search account by number    |");
			System.out.println("|        4 - Update account details      |");
			System.out.println("|        5 - Delete account              |");
			System.out.println("|        6 - Withdraw                    |");
			System.out.println("|        7 - Deposit                     |");
			System.out.println("|        8 - Transfer value between      |");
			System.out.println("|            accounts                    |");
			System.out.println("|        9 - Exit                        |");
			System.out.println("|                                        |");
			System.out.println("|----------------------------------------|");
			System.out.println("|Enter the desired option:               |");
			System.out.println("                                          ");

			// TRYCATCH para pegar valores fora do esperado
			try {
				option = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Digite um valor inteiro!");
				sc.nextLine();
				option = 0;
			}
			// saída do programa caso 9 for digitado
			if (option == 9) {	
				System.out.println("\nThank you for choosing Brazilian Trust Bank. Have a great day!");
				sobre();
				sc.close();
				System.exit(0);
			}

			switch (option) {
			// CADASTRO CONTA
			case 1:
				System.out.println(Colors.TEXT_BLUE_BOLD + Colors.ANSI_YELLOW_BACKGROUND + "Create an account\n");

				// Informações básicas (fora do do/while)
				System.out.println("Enter the agency number");
				agency = sc.nextInt();
				System.out.println("Enter the holder name:");
				sc.skip("\\R?");
				holder = sc.nextLine();

				// do-while para que o número sera 1 ou 2, se nao for repetir
				do {
					System.out.println("Enter the account type (1-CA or 2-SA");
					type = sc.nextInt();

				} while (type < 1 && type > 2);

				System.out.println("Enter the account balance (R$):");
				balance = sc.nextFloat();

				// SWITCH EXPRESSION para trocar os dados inseridos no cadastro da conta de
				// acordo com type.

				switch (type) {
				case 1 -> {
					System.out.println("Enter the credit limit (R$):");
					limit = sc.nextFloat();
					account.signup(new CurrentAccount(account.genNumber(), agency, type, holder, balance, limit));
				}

				case 2 -> {
					System.out.println("Enter the account birthday:");
					birthday = sc.nextInt();
					account.signup(new SavingsAccount(account.genNumber(), agency, type, holder, balance, birthday));
				}

				}
				keyPress();

				// LISTAR TODAS AS CONTAS
			case 2:
				System.out.println(Colors.TEXT_BLUE_BOLD + Colors.ANSI_YELLOW_BACKGROUND + "List all accounts\n");
				account.listAll();
				keyPress();
				break;

			// Consultar dados da conta pelo número
			case 3:
				System.out.println(Colors.TEXT_BLUE_BOLD + Colors.ANSI_YELLOW_BACKGROUND + "Consult account data – by number\n");
				// Atribui número da conta
				System.out.println("Enter the account number:");
				number = sc.nextInt();
				// chama método que busca todos os dados a partir do número
				account.lookingForNumber(number);

				keyPress();
				break;

			// Atualiza dados da conta
			case 4:
				System.out.println(Colors.TEXT_BLUE_BOLD + Colors.ANSI_YELLOW_BACKGROUND + "Update account details\n");

				System.out.println("Enter the account number:");
				number = sc.nextInt();

				// Cria variavel local que irá ser atribuida pela função de encontrar o número
				// da conta na collection
				var searchAccount = account.searchInCollection(number);

				if (searchAccount != null) {
					// Encontra o tipo da conta na conta procurada na collection pelo numero
					type = searchAccount.getType();

					// Atualização dados
					System.out.println("Enter the agency number:");
					agency = sc.nextInt();

					System.out.println("Enter the holder name:");
					sc.skip("\\R?");
					holder = sc.nextLine();

					System.out.println("Enter the account balance (R$) :");
					balance = sc.nextFloat();

					// Switch Expression para de acordo com o tipo atual da conta acrescentar
					// limite ou a data de aniversário da conta. Depois faz update.
					switch (type) {
					case 1 -> {
						System.out.println("Enter the credit limit (R$):");
						limit = sc.nextFloat();

						account.update(new CurrentAccount(number, agency, type, holder, balance, limit));
					}

					case 2 -> {
						System.out.println("Enter the account birthday:");
						birthday = sc.nextInt();

						account.update(new SavingsAccount(number, agency, type, holder, balance, birthday));
					}
					default -> {
						System.out.println("Invalid account type");
					}

					}
					// else conta não encontrada
				} else {
					System.out.println("Account was not found!");
				}

				keyPress();
				break;

			// Deletar a conta a partir do número da conta
			case 5:
				System.out.println(Colors.TEXT_BLUE_BOLD + Colors.ANSI_YELLOW_BACKGROUND + "Delete account\n");
				System.out.println("Enter the account number:");
				number = sc.nextInt();

				// Deleta conta a partir do número de conta informado
				account.delete(number);

				keyPress();
				break;

			// Saque a partir do número da conta
			case 6:
				System.out.println(Colors.TEXT_BLUE_BOLD + Colors.ANSI_YELLOW_BACKGROUND + "Withdraw\n");

				System.out.println("Enter the account number:");
				number = sc.nextInt();
				// do-while para saque ser sempre superior a 0
				do {
					System.out.println("Enter the withdrawal amount (R$):");
					value = sc.nextFloat();

				} while (value <= 0);

				// saca valor da conta
				account.withdraw(number, value);

				keyPress();
				break;

			// Deposito na conta a partir de seu número
			case 7:
				System.out.println(Colors.TEXT_BLUE_BOLD + Colors.ANSI_YELLOW_BACKGROUND + "Deposit\n");
				System.out.println("Enter the account number:");
				number = sc.nextInt();

				// do-while para deposito ser sempre superior a 0
				do {
					System.out.println("Enter the deposit amount (R$):");
					value = sc.nextFloat();

				} while (value <= 0);

				// Deposita valor à conta
				account.deposit(number, value);

				keyPress();
				break;

			// Transferencia de valor entre as contas origem e destino.
			case 8:
				System.out.println(Colors.TEXT_BLUE_BOLD + Colors.ANSI_YELLOW_BACKGROUND + "Transfer between accounts\n");

				// conta origem
				System.out.println("Enter the origin account number:");
				number = sc.nextInt();
				// conta destino
				System.out.println("Enter the destiny account number:");
				destinyNumber = sc.nextInt();

				// do-while para transferencia ser sempre superior a 0
				do {
					System.out.println("Enter the transfer amount (R$):");
					value = sc.nextFloat();
				} while (value <= 0);

				account.transfer(number, destinyNumber, value);
				keyPress();
				break;

			default:
				System.out.println(Colors.TEXT_BLUE_BOLD + Colors.ANSI_YELLOW_BACKGROUND + "\nInvalid Option!\n");
				break;

			}
		}

	}

	// Método para acrescentar a espera da resposta do usuario
	public static void keyPress() {
		try {
			System.out.println(Colors.TEXT_RESET + "\n\n Pressione Enter para continuar...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferenter de Enter!");

		}
	}

	public static void sobre() {
		System.out.println(Colors.TEXT_PURPLE_BOLD + Colors.ANSI_BLACK_BACKGROUND);
		System.out.println("------------------------------------------------");
		System.out.println("| Project developed by:                        |");
		System.out.println("|----------------------------------------------|");
		System.out.println("| Gabriel Nogueira                             |");
		System.out.println("| nogueiragabriel.peixoto@gmail.com            |");
		System.out.println("|----------------------------------------------|");
		System.out.println("| github.com/GNogueirovski                     |");
		System.out.println("|----------------------------------------------|");

	}
}
