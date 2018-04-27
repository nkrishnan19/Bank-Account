import java.awt.Button;
import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class MainGUI extends JFrame {
	
	public JPanel card1; 
	public JPanel card2;
	public JPanel card3; 
	public JPanel card4;
	public JFrame frame = this;
	
	public MainGUI(){	
		ArrayList<BankAccount> ba1 = new ArrayList<BankAccount>();
		double OVER_DRAFT_FEE = 15; 
		double rate = 0.0025; 
		double TRANSACTION_FEE = 1.5; 
		double MIN_BAL = 300;
		double MIN_BAL_FEE = 10;
		int FREE_TRANSACTION = 10;
		
		GridBagConstraints gbc = new GridBagConstraints();
		GridBagLayout gbl = new GridBagLayout();
		
		card1 = new JPanel();
		JLabel titleL1 = new JLabel("Welcome to this Bank REAL");
		JButton accountB1 = new JButton("Create an Account");
		JButton transactionB1 = new JButton("Make a Transaction");
		JButton aNB1 = new JButton("Get your Account Number");
		JButton exitB1 = new JButton("Exit");
	
		card1.setLayout(gbl);
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 0; 
		gbc.gridwidth = 4; 
		card1.add(titleL1, gbc);
		gbc.gridx = 0; 
		gbc.gridy = 1; 
		gbc.gridwidth = 1; 
		card1.add(accountB1, gbc);
		gbc.gridx = 1; 
		gbc.gridy = 1; 
		gbc.gridwidth = 1; 
		card1.add(transactionB1, gbc);
		gbc.gridx = 2;
		gbc.gridy = 1; 
		gbc.gridwidth = 1;
		card1.add(aNB1, gbc);
		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		card1.add(exitB1, gbc);
		
		card2 = new JPanel();
		JLabel titleL2 = new JLabel("Creating an Account");
		JButton checkingB2 = new JButton("Create Checking Account");
		JButton savingB2 = new JButton("Create Saving Account");
		JButton backB2 = new JButton("Back");
		JTextField nameTF2 = new JTextField(40);
		JTextField moneyTF2 = new JTextField(40);
		JLabel nameL2 = new JLabel("Name:");
		JLabel moneyL2 = new JLabel("Money:");
		
		card2.setLayout(gbl);
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 0; 
		gbc.gridwidth = 4; 
		card2.add(titleL2, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		card2.add(nameL2, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2; 
		gbc.gridwidth = 1;
		card2.add(moneyL2, gbc);
		gbc.gridx = 1; 
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		gbc.anchor = GridBagConstraints.WEST;
		card2.add(nameTF2, gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 3;
		card2.add(moneyTF2, gbc);
		gbc.gridx = 1;
		gbc.gridy = 3; 
		gbc.gridwidth = 1; 
		gbc.anchor  = GridBagConstraints.CENTER;
		card2.add(checkingB2, gbc);
		gbc.gridx = 2; 
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		card2.add(savingB2, gbc);
		gbc.gridx = 3;
		gbc.gridy = 3; 
		gbc.gridwidth = 1;
		card2.add(backB2, gbc);
		
		card3 = new JPanel();
		JLabel titleL3 = new JLabel("Make a Transaction");
		JLabel aNL3 = new JLabel("Account Number:");
		JLabel moneyL3 = new JLabel("Money:");
		JLabel aN2L3 = new JLabel ("Account Number receiving:");
		JTextField moneyTF3 = new JTextField(20);
		JTextField aNTF3 =  new JTextField(20);
		JTextField aN2TF3 = new JTextField(20);
		JButton depsoitB3 = new JButton("Deposit");
		JButton withdrawB3 = new JButton("Withdraw");
		JButton transferB3 = new JButton("Transfer");
		JButton backB3 = new JButton("Back");
		JCheckBox transferCB3 = new JCheckBox("Check for transfer");
		
		card3.setLayout(gbl);
		gbc.insets = new Insets(10,10,10,10);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 5; 
		card3.add(titleL3, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1; 
		gbc.anchor = GridBagConstraints.EAST;
		card3.add(aNL3, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		card3.add(moneyL3, gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		card3.add(aN2L3, gbc);
		gbc.gridx = 1;
		gbc.gridy = 1; 
		gbc.gridwidth = 3;
		gbc.anchor = GridBagConstraints.WEST;
		card3.add(aNTF3, gbc);
		gbc.gridx = 1; 
		gbc.gridy = 2;
		gbc.gridwidth = 3;
		card3.add(moneyTF3, gbc);
		gbc.gridx = 1; 
		gbc.gridy = 3;
		gbc.gridwidth = 2; 
		card3.add(aN2TF3, gbc);
		gbc.gridx = 3;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		card3.add(transferCB3, gbc);
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		card3.add(depsoitB3, gbc);
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridwidth = 1; 
		card3.add(withdrawB3, gbc);
		gbc.gridx = 2;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		card3.add(transferB3, gbc);
		gbc.gridx = 3;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		card3.add(backB3, gbc);
		
		card4 = new JPanel();
		card4.setLayout(gbl);
		DefaultListModel<String> baDLM4 = new DefaultListModel<String>();
		JLabel nameL4 = new JLabel("Name");
		JTextField nameTB4 = new JTextField(10);
		JList<String> bankLt4 = new JList<String>(baDLM4);
		JButton backB4 = new JButton("Back");
		bankLt4.setVisibleRowCount(3);
		JScrollPane bankSP4 = new JScrollPane(bankLt4);
		JLabel titleL4 = new JLabel("Get your Account Number");
		JButton enterB4 = new JButton("Find");
		
		gbc.insets = new Insets(10,10,10,10);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 3;
		card4.add(titleL4, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		card4.add(nameL4, gbc);
		gbc.gridx = 1; 
		gbc.gridy = 1; 
		gbc.gridwidth = 1;
		card4.add(nameTB4, gbc);
		gbc.gridx = 2; 
		gbc.gridy = 1; 
		gbc.gridwidth = 1;
		card4.add(enterB4, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 3;
		card4.add(bankSP4, gbc);
		gbc.gridx = 2; 
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		card4.add(backB4, gbc);
		
		//card1
		exitB1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});



		accountB1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(card2);
				frame.repaint();
				frame.revalidate(); 
			}
		});

		transactionB1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(card3);
				frame.repaint();
				frame.revalidate();  
			}
		});
		
		aNB1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(card4);
				frame.repaint();
				frame.revalidate(); 
			}
		});
		
		//card2
		backB2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(card1);
				frame.repaint();
				frame.revalidate(); 
			}
		});
		
		checkingB2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!nameTF2.getText().equals("") && isNumeric(moneyTF2.getText())) {
					double money = Double.parseDouble(moneyTF2.getText());
					CheckingAccount ca = new CheckingAccount(nameTF2.getText(), money, OVER_DRAFT_FEE, TRANSACTION_FEE, FREE_TRANSACTION);
					ba1.add(ca); 
					JOptionPane.showMessageDialog(null, "Your account number is " + ca.getAccNum());
					nameTF2.setText("");
					moneyTF2.setText("");
				}
				else {
					JOptionPane.showMessageDialog(null, "Please enter a valid string for the name textbox and/or a valid number for money textbox");
				}
			}
		});
		
		savingB2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(!nameTF2.getText().equals("") && isNumeric(moneyTF2.getText())) {
					double money = Double.parseDouble(moneyTF2.getText());
					SavingsAccount sa = new SavingsAccount(nameTF2.getText(), money, rate, MIN_BAL, MIN_BAL_FEE);
					ba1.add(sa); 
					JOptionPane.showMessageDialog(null, "Your account number is " + sa.getAccNum());
					nameTF2.setText("");
					moneyTF2.setText("");
				}
				else {
					JOptionPane.showMessageDialog(null, "Please enter a valid string for the name textbox and/or a valid number for money textbox");
				}
			}
		});
		
		//card3
		backB3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(card1);
				frame.repaint();
				frame.revalidate(); 
			}
		});
		
		depsoitB3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isNumeric(moneyTF3.getText()) && checkBankAccNum(ba1,aNTF3.getText())) {
					double money = Double.parseDouble(moneyTF3.getText());
					int an = Integer.parseInt(aNTF3.getText());
					for (int i = 0; i < ba1.size(); i++) {
						if (an == ba1.get(i).getAccNum()) {
								ba1.get(i).deposit(money);
								JOptionPane.showMessageDialog(null, "Deposit");
						}
					}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Please enter a valid number for the money textbox and/or a valid number for the account number textbox");
				}
					
			}
				
		});
		
		//card4
		backB4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(card1);
				frame.repaint();
				frame.revalidate(); 
			}
		});
		
		
		this.getContentPane().add(card1);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("Bank Account Project");
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		MainGUI app = new MainGUI();
	}
	
	private static boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (IllegalArgumentException ex) {
			return false;
		}
	}

	private static boolean isNumericInt(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (IllegalArgumentException ex) {
			return false;
		}
	}
	
	private static boolean checkBankAccNum(ArrayList<BankAccount> ba, String an) {
		try {
			int an1 = Integer.parseInt(an);
			for (int i = 0; i < ba.size(); i++) {
				if (an1 == ba.get(i).getAccNum()) {
					return true;
				}
			}
			return false;
		} catch (IllegalArgumentException ex) {
			return false;
		}
		
	}
	


}