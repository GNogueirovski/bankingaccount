package account.model;

public class CurrentAccount extends Account {
	// Atributos - Variáveis
	private float limit;

	// Método Especial - Método Construtor
	public CurrentAccount(int number, int agency, int type, String holder, float balance, float limit) {
		// invocando método Construtor de Account
		super(number, agency, type, holder, balance);
		this.limit = limit;

	}
	// Polimorfismo de SOBRECARGA => Adiciona/remove parametros a um método já existente.
	public CurrentAccount(int number, int agency, int type, String holder, float balance){
		super(number, agency, type, holder, balance);
		this.limit = 5000.0f;
	}
		

	// Métodos de Acesso GET e SET
	public float getLimit() {
		return limit;
	}

	public void setLimit(float limit) {
		this.limit = limit;
	}

	// Polimorfismo de Sobrescrita => add mais ou muda a lógica a um método já existente
	public void visualize () {
		super.visualize(); //Metodo da classe account
		System.out.printf("Credit limit: %.2f", this.limit);
	}
	
}
