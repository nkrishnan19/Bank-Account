import java.awt.Color;
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

public class TransferPanel extends JPanel
{
	public TransferPanel(ArrayList<BankAccount> acc)
	{
		ArrayList<BankAccount> accounts = acc;
		setSize(400, 300);
		setLayout( new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel transferName1 = new JLabel("Account Number to Transfer From: ");
		transferName1.setForeground(Color.blue);
		add(transferName1, gbc);
		gbc.gridx++;
		JTextField transferTxt1 = new JTextField();
		transferTxt1.setPreferredSize(new Dimension(180, 30)); 
		add(transferTxt1, gbc);
		gbc.gridx = 0;
		gbc.gridy++;
		JLabel transferName2 = new JLabel("Account Number to Transfer To: ");
		transferName2.setForeground(Color.blue);
		add(transferName2, gbc);
		gbc.gridx++;
		JTextField transferTxt2 = new JTextField();
		transferTxt2.setPreferredSize(new Dimension (180, 30));
		add(transferTxt2, gbc);
		
		gbc.gridy++;
		gbc.gridx=0;
		JLabel amountTransfer = new JLabel("Amount to Transfer: ");
		amountTransfer.setForeground(Color.red);
		add(amountTransfer, gbc);
		gbc.gridx++;

		JTextField amountTransferTxt = new JTextField();
		amountTransferTxt.setPreferredSize(new Dimension (180, 30));
		add(amountTransferTxt, gbc);
		
		gbc.gridy++;
		gbc.gridx=0;
		JButton transferSubmit = new JButton("Transfer");
		add(transferSubmit,gbc);
		
		transferSubmit.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					for(int i = 0; i < accounts.size(); i++)
					{
						if(transferTxt1.getText().equals(""+ accounts.get(i).getAccNum()))
						{
							for(int j = 0; j < accounts.size(); j++)
							{
								if(transferTxt2.getText().equals(""+ accounts.get(j).getAccNum()))
								{
									accounts.get(i).transfer(accounts.get(j),Double.parseDouble(amountTransferTxt.getText()));
									transferTxt1.setText("");
									transferTxt2.setText("");
									amountTransferTxt.setText("");
								}
							}
						}
					}
				}
				catch(IllegalArgumentException e)
				{
					JOptionPane.showMessageDialog(amountTransferTxt, "Sorry, your input was invalid.");				
				}	
			}
		});
	}
}