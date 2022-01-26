import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.*;


public class Window extends JFrame{
	
	JFrame tela;
	JPanel painel;
	JLabel lblMenu;
	JButton jbnSaque;
	JButton jbnDeposito;
	JButton jbnTransferir;
	JButton jbnExtrato;
	
	Cliente i = new Cliente();
	ContaCorrente cc = new ContaCorrente(1551548d);
	ContaPoupanca cp = new ContaPoupanca(50);
	
	void run() {
		
		// Cria a janela principal
		tela = new JFrame();
		tela.setSize(300, 500);
		tela.setResizable(false);
		tela.setLocationRelativeTo(null);
		tela.setTitle("Banco24Horas");
		tela.setBackground(Color.BLUE);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Cria o painel
		painel = new JPanel();
		painel.setBackground(Color.WHITE);
		painel.setLayout(null);
		painel.setVisible(true);
		
	
		// Adiciona o painel dentro da janela principal
		tela.add(painel);
	
		// Adiciona o favicon
		java.net.URL url = this.getClass().getResource("Images\\Banco.png");
		Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
		tela.setIconImage(iconeTitulo);
		
		// JLabel
		lblMenu = new JLabel();
		Font f = new Font("SansSerif", Font.BOLD, 20);
		lblMenu.setFont(f);
		lblMenu.setText("<html><center>Bem-vindo <br> Selecione a opção desejada</center></html>"); 
		lblMenu.setForeground(Color.BLACK);
		lblMenu.setBounds(10, 10, 300, 80);
		painel.add(lblMenu);
		
		// Adiciona o botão de saque. 
		jbnSaque = new JButton();
		jbnSaque.setText("Saque");
		jbnSaque.setBounds(55, 115, 175, 50);
		jbnSaque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                double valorSaque = Double.parseDouble(JOptionPane.showInputDialog("Insira o valor do Saque"));
                cc.sacar(valorSaque);
            }
        });
		painel.add(jbnSaque);
		
		// Adiciona o botão Depositar 
		jbnDeposito = new JButton();
		jbnDeposito.setText("Depositar");
		jbnDeposito.setBounds(55, 175, 175, 50);
		jbnDeposito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog("Insira o valor do Deposito"));
                cc.depositar(valorDeposito);
            }
        });
		painel.add(jbnDeposito);
		
		
		// Adiciona o botão Depositar 
		jbnTransferir = new JButton();
		jbnTransferir.setText("Transferir");
		jbnTransferir.setBounds(55, 235, 175, 50);
		jbnTransferir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog("Insira o valor do Transferencia entre contas"));
                cc.transferir(cp, valorDeposito);
            }
        });
		painel.add(jbnTransferir);
		
		// Adiciona o botão extrato 
		jbnExtrato = new JButton();
		jbnExtrato.setText("Extrato");
		jbnExtrato.setBounds(55, 295, 175, 50);
		jbnExtrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cc.extrato();
              
            }
        });
		painel.add(jbnExtrato);
		
		
		tela.setVisible(true);
		
	}
	
}
