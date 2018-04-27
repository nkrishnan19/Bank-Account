import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Balance extends JPanel
{
	public Balance(ArrayList<BankAccount> acc)
	{
		ArrayList<BankAccount> account = acc;
		setSize(400, 300);
		setLayout( new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();	
		
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel balancelbl  = new JLabel("Enter Account Number: ");
		add(balancelbl, gbc);
		gbc.gridx++;
		JTextField balancetxt = new JTextField();
		balancetxt.setPreferredSize(new Dimension(180, 30)); 
		add(balancetxt, gbc);
		gbc.gridx = 0;
		gbc.gridy++;
		JButton balanceButton = new JButton("Submit");
		add(balanceButton, gbc);
		balanceButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				double balance = -1.00;
				for(int i = 0; i < account.size(); i++)
				{
					if(balancetxt.getText().equals(""+ account.get(i).getAccNum()))
					{
						balance = account.get(i).getBalance();
					}
				}
				if(balance > -1)
				{
					JOptionPane.showMessageDialog(balancetxt, "Your Balance is: " + balance);
				}
				else
				{
					JOptionPane.showMessageDialog(balancetxt, "Input was invalid, Please enter the account number you wish to get the balance of.");
				}
				balancetxt.setText("");
			}
		});
	}
}