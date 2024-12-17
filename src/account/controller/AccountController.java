package account.controller;

import java.util.ArrayList;

import account.model.Account;
import account.repository.AccountRepository;

public class AccountController implements AccountRepository {

	private ArrayList<Account> listAccounts = new ArrayList<Account>();
	int number = 0;

	// CRUD
	@Override
	public void lookingForNumber(int number) {
		var account = searchInCollection(number);

		if (account != null)
			account.visualize();
		else {
			System.out.println("\n Account number: " + number + " was not found!");
		}
	}

	@Override
	public void listAll() {
		for (var account : listAccounts)
			account.visualize();
	}

	@Override
	public void signup(Account account) {
		listAccounts.add(account);
		System.out.printf("Account number %d has been successufully created!", account.getNumber());

	}

	@Override
	public void update(Account account) {
		var searchAccount = searchInCollection(account.getNumber());

		if (searchAccount != null) {
			listAccounts.set(listAccounts.indexOf(searchAccount), account);
			System.out.println("Account number " + account.getNumber() + " was successfully updated!");
		} else {
			System.out.println("Account number " + account.getNumber() + " was not found!");
		}

	}

	@Override
	public void delete(int number) {
		var account = searchInCollection(number);

		if (account != null) {
			if (listAccounts.remove(account) == true) {
				System.out.println("Account number " + number + " was deleted");
			} else
				System.out.println("Account number " + number + " was not found!");
		}

	}

	// Métodos bancários

	@Override
	public void withdraw(int number, float value) {
		var account = searchInCollection(number);

		if (account != null) {
			if (account.withdraw(value) == true) {
				System.out.println("\n Withdrawal from the account number " + number + " was successfully done!");
			} else
				System.out.println("\n Account number " + number + " was not found!");
		}

	}

	@Override
	public void deposit(int number, float value) {
		var account = searchInCollection(number);

		if (account != null) {
			account.deposit(value);
			System.out.println("\n Deposit on the account number " + number + " was successfully done!");
		} else {
			System.out.println("Account number " + number + " was not found or Destiny Account is not an a Current Account!");
		}

	}

	@Override
	public void transfer(int originNumber, int destinyNumber, float value) {
		var originAccount = searchInCollection(originNumber);
		var destinyAccount = searchInCollection(destinyNumber);

		if (originAccount != null && destinyAccount != null) {

			if (originAccount.withdraw(value) == true)
				destinyAccount.deposit(value);
			System.out.println("\n Transference between accounts was successfully done!");
		} else {
			System.out.println("\n The origin Account or the destiny Account was not found");
		}

	}

	public int genNumber() {
		return ++number;

	}

	public Account searchInCollection(int number) {
		for (var account : listAccounts) {
			if (account.getNumber() == number) {
				return account;
			}
		}
		return null;
	}

}
