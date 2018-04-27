import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class BPanel extends JPanel
{
	String accts [] = {"Checking" , "Saving"};

	ArrayList<BankAccount> accounts = new ArrayList<BankAccount> ();
	JList <String> acc  = new JList<String> (accts);

	public BPanel(ArrayList<BankAccount> a)
	{
		setSize(400, 300);
		setLayout( new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		ArrayList<BankAccount> accounts = a;
  	
  		
  		gbc.gridx = 1;
  		gbc.gridy = 0;
  		JLabel createTitle = new JLabel("Create an Account");
  		createTitle.setForeground(Color.blue);
  		add(createTitle, gbc);
  		gbc.gridy=1;
  		gbc.gridx=0;
  		
  		JLabel lblName = new JLabel("Account Name: ");
  		add(lblName, gbc);

  		gbc.gridy=1;
  		gbc.gridx++;
  		JTextField txtName = new JTextField();
  		txtName.setPreferredSize(new Dimension(180, 30)); 
  		add(txtName, gbc);
  		gbc.gridx = 0;
  		gbc.gridy++;
  		
  		
  		JLabel lblDeposit = new JLabel("Amount to Deposit: ");
  		add(lblDeposit, gbc);
  		gbc.gridx++;
  		JTextField txtDeposit = new JTextField();
  		txtDeposit.setPreferredSize(new Dimension (180, 30));
  		add(txtDeposit, gbc);
  		
  		gbc.gridy++;
  		gbc.gridx=0;
  		JButton bPanelSubmit = new JButton("Deposit");
  		add(bPanelSubmit,gbc);
  		
  		gbc.gridx++;
		JScrollPane list = new JScrollPane();
		list.setViewportView(acc);
		list.setPreferredSize(new Dimension(80, 40));
		add(list, gbc);

  		
  		
  		
  		bPanelSubmit.addActionListener(new ActionListener()
  			{
  				@Override
  				public void actionPerformed(ActionEvent arg0) 
  				{
  					try
  					{
  						double OVER_DRAFT_FEE = 15; 
 						double rate = 0.0025; 
  						double TRANSACTION_FEE = 1.5; 
  						double MIN_BAL = 300;
  						double MIN_BAL_FEE = 10;
  						int FREE_TRANSACTION = 10;
  						if(acc.getSelectedValue() == "Checking")
  						{								
  							CheckingAccount check = new CheckingAccount(txtName.getText(), Double.parseDouble(txtDeposit.getText()), OVER_DRAFT_FEE, TRANSACTION_FEE, FREE_TRANSACTION);
  							accounts.add(check);
  						}
  						else
  						{
  							SavingsAccount save = new SavingsAccount(txtName.getText(), Double.parseDouble(txtDeposit.getText()),rate, MIN_BAL, MIN_BAL_FEE);
 							accounts.add(save);
 						}
  					}
  					catch(IllegalArgumentException e)
  					{
  						JOptionPane.showMessageDialog(txtDeposit, "Sorry, your input was invalid.");
  					}	
  					txtName.setText("");
					txtDeposit.setText("");
  				}
  					
  			});
	}
	public ArrayList<BankAccount> getAcc()
	{
		return accounts;
	}
}
