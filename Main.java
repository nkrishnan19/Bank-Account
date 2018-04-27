import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Main extends JFrame 
{
	String accts [] = {"Checking" , "Saving"};

	ArrayList<BankAccount> BankAccounts = new ArrayList<BankAccount> ();
	JList <String> acc  = new JList<String> (accts);
	
	public JFrame frame = this;
	public Main(ArrayList <BankAccount> bacc)
	{
		 JFrame myFrame = new JFrame();
		ArrayList <BankAccount> acct = bacc;
		frame.getContentPane().setBackground(Color.cyan);
		CardLayout cl = new CardLayout();
		
		JPanel overall = new JPanel();
		overall.setLayout(cl);
		
		JMenuBar mainMenu = new JMenuBar();
		JMenu accounts = new JMenu("Manage Accounts");
		JMenuItem create = new JMenuItem("Create an Account");
		JMenuItem remove = new JMenuItem("Remove an Account");

		JMenu accInfo = new JMenu("Get Account Information");
		JMenuItem accNum = new JMenuItem("Get Account Number");
		JMenuItem balance = new JMenuItem("Get Account Balance");
		
		accounts.add(create);
		accounts.add(remove);
		accounts.add(accInfo);
		accInfo.add(accNum);
		accInfo.add(balance);
		mainMenu.add(accounts);

		
		JMenu transaction = new JMenu("Make a Transaction");
		JMenuItem deposit = new JMenuItem("Deposit");
		JMenuItem withdraw = new JMenuItem("Withdraw");
		JMenuItem transfer = new JMenuItem("Transfer");
		
		transaction.add(deposit);
		transaction.add(withdraw);
		transaction.add(transfer);
		mainMenu.add(transaction);
		
		overall.add(new DepositPanel(acct), "Deposit");
		overall.add(new TransferPanel(acct), "Transfer");
		overall.add(new WithdrawPanel(acct), "Withdraw");
  		overall.add(new BPanel(acct), "Make Account");
  		overall.add(new AccountNum(acct), "Get Num");
  		overall.add(new RemoveAcc(acct), "Remove");
  		overall.add(new Home(acct), "Home");
  		
  		overall.add(new Balance(acct), "Balance");
  		cl.show(overall, "Home");
  		frame.add(overall);
		frame.setJMenuBar(mainMenu);
		
		 create.addActionListener(new ActionListener() 
		 {
		      public void actionPerformed(ActionEvent e) 
		      {
		    	  	cl.show(overall,  "Make Account");
		    	  	getContentPane().setBackground(Color.pink);
		      }
		      
		  });
		 remove.addActionListener(new ActionListener()
		 {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				cl.show(overall, "Remove");
				getContentPane().setBackground(Color.pink);
			} 
		 });
		accNum.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				cl.show(overall, "Get Num");
				getContentPane().setBackground(Color.pink);
			}
			
		});
		deposit.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				cl.show(overall, "Deposit");
				getContentPane().setBackground(Color.pink);
			}
		});
		
		withdraw.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				cl.show(overall, "Withdraw");
				getContentPane().setBackground(Color.pink);
			}
		});
		transfer.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				cl.show(overall, "Transfer");
				myFrame.getContentPane().setBackground(Color.pink);
			}
		});
		
		balance.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				cl.show(overall, "Balance");
				getContentPane().setBackground(Color.pink);
			}
		});
		setBounds(300,300,700,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) 
	{
		ArrayList<BankAccount> a = new ArrayList<BankAccount>();
		new Main(a); 
	}
}