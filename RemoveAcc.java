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

public class RemoveAcc extends JPanel
{
	public RemoveAcc(ArrayList<BankAccount> acc)
	{
		ArrayList<BankAccount> accounts = acc;
		setSize(400, 300);
  		setLayout( new GridBagLayout());
  		GridBagConstraints gbc = new GridBagConstraints();
  		
  		gbc.gridx = 0;
  		gbc.gridy = 0;
  		
  		JLabel numlbl = new JLabel("Enter the Number of the Account You Wish To Remove: ");
  		add(numlbl, gbc);
  		
  		gbc.gridy++;
  		JTextField txt = new JTextField();
  		txt.setPreferredSize(new Dimension(180, 30));
  		add(txt, gbc);
  		
  		JButton submit = new JButton("Remove Account");
  		
  		submit.addActionListener(new ActionListener()
  				{

					@Override
					public void actionPerformed(ActionEvent e) 
					{
						for(int i = 0; i < accounts.size(); i++)
				  		{
				  			if(txt.getText().equals((""+accounts.get(i).getAccNum())))
				  					{
				  						accounts.remove(i);
				  					}
				  		}
					}
  			
  				});
	}
}
