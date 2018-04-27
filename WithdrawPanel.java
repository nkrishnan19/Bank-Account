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

public class WithdrawPanel extends JPanel 
{
	public WithdrawPanel(ArrayList<BankAccount> acc)
	{
		ArrayList<BankAccount> accounts = acc;
		setSize(400, 300);
  		setLayout( new GridBagLayout());
  		GridBagConstraints gbc = new GridBagConstraints();
		setSize(400, 300);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel accNum = new JLabel("Account Number: ");
		accNum.setForeground(Color.blue);
		add(accNum, gbc);
		gbc.gridx++;
		JTextField num = new JTextField();
		num.setPreferredSize(new Dimension(180, 30)); 
		add(num, gbc);
		gbc.gridx = 0;
		gbc.gridy++;
		
		JLabel withdrawlbl = new JLabel("Amount to Withdraw: ");
		withdrawlbl.setForeground(Color.red);
		add(withdrawlbl, gbc);
		gbc.gridx++;

		JTextField amt = new JTextField();
		amt.setPreferredSize(new Dimension (180, 30));
		add(amt, gbc);
		
		gbc.gridy++;
		gbc.gridx=0;
		JButton submit = new JButton("Withdraw");
		add(submit,gbc);
		
		submit.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					for(int i = 0; i < accounts.size(); i++)
						{
							if(num.getText().equals("" + accounts.get(i).getAccNum()))
							{
								accounts.get(i).withdraw(Double.parseDouble(amt.getText()));
							}
						}
				}
				catch(IllegalArgumentException e)
				{
					JOptionPane.showMessageDialog(amt, "Sorry, your input was invalid.");			
				}
				amt.setText("");
				num.setText("");
			}
			
		});
	}
}
