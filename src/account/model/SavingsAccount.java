package account.model;

public class SavingsAccount extends Account {
	private int birthday;

	public SavingsAccount(int number, int agency, int type, String holder, float balance, int birthday) {
		super(number, agency, type, holder, balance);
		this.birthday = birthday;

	}

	public int getBirthday() {
		return birthday;
	}

	public void setBirthday(int birthday) {
		this.birthday = birthday;
	}
	
	public void visualize() {
		super.visualize();
		System.out.printf("Account Aniversary: %d", this.birthday);
	}
	
}
