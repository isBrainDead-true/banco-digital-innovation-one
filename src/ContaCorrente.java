import lombok.Data;

public @Data class ContaCorrente extends Conta{

	public ContaCorrente(double s) {
		super.saldo = s;
	}

}
