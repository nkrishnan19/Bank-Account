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

import javax.swing.JPanel;

public class AccountNum extends JPanel
{
	public AccountNum(ArrayList<BankAccount> acc)
	{
		ArrayList<BankAccount> accounts = acc;
		setSize(400, 300);
		setLayout( new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();	
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel name = new JLabel("Enter your Account Name: ");
		name.setForeground(Color.blue);
		add(name, gbc);
		gbc.gridy++;
		JTextField txt = new JTextField();
		txt.setPreferredSize(new Dimension(180, 30)); 
		add(txt, gbc);
		
		JButton submit = new JButton("Submit");
		

		submit.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				int num = 0;
				for(int i = 0; i < accounts.size(); i++)
				{
					if(accounts.get(i).getName().equals(txt.getText()))
					{
						num = accounts.get(i).getAccNum();
					}
				}	
				if(num > 0)
				{
					JOptionPane.showMessageDialog(txt, "Your Account Number is: " + num);
				}
				else
				{
					JOptionPane.showMessageDialog(txt, "Sorry, your input was invalid, please enter the name of your account.");
				}
				txt.setText("");
				
				}		
		});	
	}
}