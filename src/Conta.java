import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

public abstract class Conta implements contaInterface{
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	Cliente i;
	

	private static final int agencia = 9999;
	private static int numeroConta = 184431;
	
	protected double saldo;
	protected Cliente titular;
	
	public Conta() {
		this.numeroConta = this.numeroConta++;
	}
	
	public Conta(double saldo) {
		this.saldo = saldo;
		this.numeroConta = this.numeroConta++;
		i = new Cliente();
		this.titular = i;
	}
	
	public int getAgencia() {
		return this.agencia;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public int getNumeroConta() {
		return this.numeroConta;
	}
	
	public Cliente getTitular() {
		return this.titular;
	}
	
	
	/**
	 * Metodo para sacar o valor da conta, caso o valor do saque seja maior que o saldo em conta, o 
	 * metodo retorna 0 e informa na tela para o usuário. 
	 * 
	 * @param double valor solicitado do saque sendo valor maior que 0
	 * @return o valor do saque ou 0;
	 */
	
	@Override
	public double sacar(double valor) {
		if (valor > 0) {
			if (this.saldo > valor || this.saldo == valor) {
				this.saldo -= valor;
				JOptionPane.showMessageDialog(null, "Saque realizado com sucesso: \nSaldo atual é de: " + this.saldo);
				return valor; 
			}	else {
				JOptionPane.showMessageDialog(null, "Saldo Insuficiente");
				return 0;
			}
		}else {
			return -1;
		}
	}
	
	/**
	 * Metodo para realizar o deposito em conta. 
	 * 
	 * @param double valor para o deposito, sendo valor maior que 0
	 */
	
	@Override
	public void depositar(double valor) {
		if (valor > 0) {
			this.saldo += valor;
			JOptionPane.showMessageDialog(null, "Deposito realizado com sucesso: \nSaldo atual:" + this.saldo);
		}
	}
	
	
	/**
	 * Metodo para transferencia de valores entre contas.
	 * 
	 * @param Conta para qual o valor será transferido. 
	 * @param valor 
	 */
	@Override
	public void transferir(Conta a, double valor) {
		
		if(a != null && valor > 0) {
			this.saldo -= valor;
			a.saldo += valor;
			JOptionPane.showMessageDialog(null, "PIX realizado com sucesso");
			
		}
		
	} 
	
	/**
	 * Metodo para consultar o extrato em conta. 
	 */
	@Override
	public void extrato() {
		JOptionPane.showMessageDialog(null, "==============Extrato em conta==============\n"
				+ dtf.format(LocalDateTime.now())
				+ "\nAgencia: " + this.getAgencia()
				+ "\nConta: " + this.getNumeroConta()
				+ "\nSaldo: " + this.getSaldo());
	}
	
}
