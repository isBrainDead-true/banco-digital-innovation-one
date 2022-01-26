import lombok.Data;

public @Data class Banco {

	private String nome;
	private byte cod;
	private Cliente[] clientes;
	
}
