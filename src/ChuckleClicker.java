import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ChuckleClicker implements ActionListener {
	public static void main(String[] args) {
		ChuckleClicker ck = new ChuckleClicker();
		ck.makeButtons();
		
	}
	
	JFrame frame = new JFrame("Chuckle Clicker");
	JButton joke = new JButton("Joke");
	JButton punchline = new JButton("Punchline");
	JPanel panel = new JPanel();
	
	void makeButtons() {
		frame.add(panel);
		joke.setBackground(Color.MAGENTA);
		joke.setOpaque(true);
		punchline.setBackground(Color.orange);
		punchline.setOpaque(true);
		panel.add(joke);
		panel.add(punchline);
		frame.setVisible(true);
		frame.pack();
		joke.addActionListener(this);
		punchline.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == joke) {
			JOptionPane.showMessageDialog(null, "What did the mommy volcano say to the baby volcano?");
		}
		else if (e.getSource() == punchline) {
			JOptionPane.showMessageDialog(null, "I lava you!");
		}
		else {
			System.out.println("Error!");
		}
	}
}
