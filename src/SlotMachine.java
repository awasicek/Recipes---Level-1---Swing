import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//Make a slot machine with 3 “reels” (JLabels) whose content are determined by Random  integers.  
//Each time the “Spin” button is pressed, change the numbers. 
//If the numbers are all the same, display (JLabel) “You won”. If they are different, display  “You lose”. 
//Option: Replace the numbers with images. 

public class SlotMachine implements ActionListener {
	public static void main(String[] args) {
		new SlotMachine().run();
	}

	JFrame frame = new JFrame("Slot Machine v1.0");
	JPanel panel = new JPanel();
	JButton button = new JButton("Spin");
	JLabel label1 = new JLabel();
	JLabel label2 = new JLabel();
	JLabel label3 = new JLabel();
	JLabel winLabel = new JLabel("You Win!");
	JLabel loseLabel = new JLabel("You Lose.");
	int ran1;
	int ran2;
	int ran3;

	void run() {
		ran1 = new Random().nextInt(3) + 1;
		ran2 = new Random().nextInt(3) + 1;
		ran3 = new Random().nextInt(3) + 1;
		frame.add(panel);
		panel.add(button);
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		label1.setText(String.valueOf(ran1));
		label2.setText(String.valueOf(ran2));
		label3.setText(String.valueOf(ran3));
		button.addActionListener(this);
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ran1 = new Random().nextInt(3) + 1;
		ran2 = new Random().nextInt(3) + 1;
		ran3 = new Random().nextInt(3) + 1;		
		label1.setText(String.valueOf(ran1));
		label2.setText(String.valueOf(ran2));
		label3.setText(String.valueOf(ran3));
		try {
			panel.remove(winLabel);
			panel.remove(loseLabel);
		} finally {
			
		}
		if (label1.getText().equals(label2.getText()) && label1.getText().equals(label3.getText())) {
			panel.add(winLabel);
			frame.pack();
		} else {
			panel.add(loseLabel);
			frame.pack();
		}
	}
}
