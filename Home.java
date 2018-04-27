import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Home extends JPanel
{
	public JFrame frame;
	public Home(ArrayList<BankAccount> acc)
	{
		setSize(400, 300);
  		setLayout( new GridBagLayout());
  		GridBagConstraints gbc = new GridBagConstraints();
		setSize(400, 300);
		
		gbc.gridx=0;
		gbc.gridy=0;
		JLabel welcomelbl = new JLabel("Welcome to the Bank");
		add(welcomelbl, gbc);
		gbc.gridy++;
		JLabel welcomelbl2 = new JLabel("Click the Menu Bar to Begin Using the Bank!");
		add(welcomelbl2, gbc);
		BufferedImage bankjpg = null;
		try
		{
			bankjpg = ImageIO.read(new File("Bank Image.jpg"));
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}
		JLabel lblHome = new JLabel(new ImageIcon(bankjpg));
		gbc.gridy++;
		add(lblHome, gbc);
	}
}
