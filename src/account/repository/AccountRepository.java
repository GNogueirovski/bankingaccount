package account.repository;

import account.model.Account;

public interface AccountRepository {
	
	// CRUD da conta
	public void lookingForNumber(int number);
	public void listAll();
	public void signup(Account account);
	public void update(Account account);
	public void delete(int number);
	
	// Métodos Bancários
	public void withdraw (int number, float value);
	public void deposit (int number, float value);
	public void transfer (int originNumber, int destinyNumber, float value);
	

}
