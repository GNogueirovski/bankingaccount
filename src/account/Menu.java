package account;

import account.util.Colors;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		int option;
		Scanner sc = new Scanner(System.in);

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

			option = sc.nextInt();

			if (option == 9) {
				System.out.println(Colors.TEXT_BLUE_BOLD + Colors.ANSI_YELLOW_BACKGROUND
						+ "\nThank you for choosing Brazilian Trust Bank. Have a great day!");
				sobre();
				sc.close();
				System.exit(0);
			}

			switch (option) {
			case 1:
				System.out.println(Colors.TEXT_BLUE_BOLD + Colors.ANSI_YELLOW_BACKGROUND + "Create an account\n");
				break;
			case 2:
				System.out.println(Colors.TEXT_BLUE_BOLD + Colors.ANSI_YELLOW_BACKGROUND + "List all accounts\n");
				break;
			case 3:
				System.out.println(
						Colors.TEXT_BLUE_BOLD + Colors.ANSI_YELLOW_BACKGROUND + "Consult account data – by number\n");
				break;
			case 4:
				System.out.println(Colors.TEXT_BLUE_BOLD + Colors.ANSI_YELLOW_BACKGROUND + "Update account details\n");
				break;
			case 5:
				System.out.println(Colors.TEXT_BLUE_BOLD + Colors.ANSI_YELLOW_BACKGROUND + "Delete account\n");
				break;
			case 6:
				System.out.println(Colors.TEXT_BLUE_BOLD + Colors.ANSI_YELLOW_BACKGROUND + "Withdraw\n");
				break;
			case 7:
				System.out.println(Colors.TEXT_BLUE_BOLD + Colors.ANSI_YELLOW_BACKGROUND + "Deposit\n");
				break;
			case 8:
				System.out.println(Colors.TEXT_BLUE_BOLD + Colors.ANSI_YELLOW_BACKGROUND + "Transfer between accounts\n");
				break;

			default:
				System.out.println(Colors.TEXT_BLUE_BOLD + Colors.ANSI_YELLOW_BACKGROUND + "\nInvalid Option!\n");
				break;

			}
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
