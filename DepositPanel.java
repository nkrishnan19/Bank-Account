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

public class DepositPanel extends JPanel
{
	
	DepositPanel(ArrayList<BankAccount> acc)
	{
		ArrayList<BankAccount> accounts = acc;
		setSize(400, 300);
  		setLayout( new GridBagLayout());
  		GridBagConstraints gbc = new GridBagConstraints();
  		
  		
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel depositName = new JLabel("Account Number: ");
		depositName.setForeground(Color.blue);
		add(depositName, gbc);
		gbc.gridx++;
		JTextField depositTxt = new JTextField();
		depositTxt.setPreferredSize(new Dimension(180, 30)); 
		add(depositTxt, gbc);
		gbc.gridx = 0;
		gbc.gridy++;
		
		JLabel depositlbl = new JLabel("Amount to Deposit: ");
		depositlbl.setForeground(Color.red);
		add(depositlbl, gbc);
		gbc.gridx++;
		JTextField txtAmt = new JTextField();
		txtAmt.setPreferredSize(new Dimension (180, 30));
		add(txtAmt, gbc);
		
		gbc.gridy++;
		gbc.gridx=0;
		JButton depositSubmit = new JButton("Deposit");
		
		add(depositSubmit,gbc);
		
		depositSubmit.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					for(int i = 0; i < accounts.size(); i++)
					{
						if(depositTxt.getText().equals(""+accounts.get(i).getAccNum()))
						{
							accounts.get(i).deposit(Double.parseDouble(txtAmt.getText()));
						}
					}
				}
				catch(IllegalArgumentException e)
				{
					JOptionPane.showMessageDialog(depositTxt, "Sorry, your input was invalid.");	
				}		
				depositTxt.setText("");
				txtAmt.setText("");
				}		
		});	
	}
}
