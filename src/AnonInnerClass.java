import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AnonInnerClass {
	public static void main(String[] args) {
		AnonInnerClass ac = new AnonInnerClass();
		ac.run();
	}
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button = new JButton();
	
	void run() {
		frame.add(panel);
		panel.add(button);
		
		// Using Anonymous Inner class for event handling
		
		button.addActionListener(
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						System.out.println("Button pressed!");
					}
				}
		);
		
		//
		
		frame.pack();
		frame.setVisible(true);
	}
}
