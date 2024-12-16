package account.controller;

import java.util.ArrayList;

import account.model.Account;
import account.repository.AccountRepository;

public class AccountController implements AccountRepository  {
	
	private ArrayList<Account> listAccounts = new ArrayList <Account>();
	int number = 0;

	// CRUD
	@Override
	public void lookingForNumber(int number) {
	
	}

	@Override
	public void listAll() {
		for (var account:listAccounts)
			account.visualize();
	}

	@Override
	public void signup(Account account) {
		listAccounts.add(account);
		System.out.printf("Account number %d has been successufully created!",account.getNumber());
		
	}

	@Override
	public void update(Account account) {
		
	}

	@Override
	public void delete(int number) {
		
	}
	
	// Métodos bancários

	@Override
	public void withdraw(int number, float value) {
		
	}

	@Override
	public void deposit(int number, float value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transfer(int originNumber, int destinyNumber, float value) {
		
	}
	
	public int genNumber() {
		return ++number;
		
	}

}
