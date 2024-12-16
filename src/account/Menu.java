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

		int option, agency, type, birthday;
		String holder;
		float balance, limit;

		// TESTING ACCOUNTS
		CurrentAccount ca1 = new CurrentAccount(account.genNumber(), 01, 1, "João Adams", 1000f, 100.0f);
		account.signup(ca1);

		CurrentAccount ca2 = new CurrentAccount(account.genNumber(), 02, 1, "Paulo Timão ", 2000f, 100.0f);
		account.signup(ca2);

		SavingsAccount sa1 = new SavingsAccount(account.genNumber(), 03, 2, "Marcelo Porco", 3000f, 12);
		account.signup(sa1);

		SavingsAccount sa2 = new SavingsAccount(account.genNumber(), 04, 2, "Lucas Mateus", 5000f, 20);
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

			if (option == 9) {
				System.out.println(Colors.TEXT_BLUE_BOLD + Colors.ANSI_YELLOW_BACKGROUND
						+ "\nThank you for choosing Brazilian Trust Bank. Have a great day!");
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
				// --
			case 3:
				System.out.println(Colors.TEXT_BLUE_BOLD + Colors.ANSI_YELLOW_BACKGROUND + "Consult account data – by number\n");

				keyPress();
				break;
				// --
			case 4:
				System.out.println(Colors.TEXT_BLUE_BOLD + Colors.ANSI_YELLOW_BACKGROUND + "Update account details\n");
				keyPress();
				break;
				// --
			case 5:
				System.out.println(Colors.TEXT_BLUE_BOLD + Colors.ANSI_YELLOW_BACKGROUND + "Delete account\n");
				keyPress();
				break;
				// --
			case 6:
				System.out.println(Colors.TEXT_BLUE_BOLD + Colors.ANSI_YELLOW_BACKGROUND + "Withdraw\n");
				keyPress();
				break;
				// --
			case 7:
				System.out.println(Colors.TEXT_BLUE_BOLD + Colors.ANSI_YELLOW_BACKGROUND + "Deposit\n");
				keyPress();
				break;
				// --
			case 8:
				System.out
						.println(Colors.TEXT_BLUE_BOLD + Colors.ANSI_YELLOW_BACKGROUND + "Transfer between accounts\n");
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
