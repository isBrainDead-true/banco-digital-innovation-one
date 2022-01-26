import lombok.Data;

public @Data class ContaPoupanca extends Conta{

	public ContaPoupanca(double s) {
		super.saldo = s;
	}
	
}
