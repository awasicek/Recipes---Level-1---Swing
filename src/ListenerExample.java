import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

// 7. hover red underline and choose "add unimplemented methods"
public class ListenerExample implements ActionListener {
	public static void main(String[] args) {
		// 2. start the run method from main
		ListenerExample ex = new ListenerExample();
		ex.run();
	}
	
	// 3. make your GUI components 
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button1 = new JButton("1");
	JButton button2 = new JButton("2");

	
	// 1. make a run method (this is where we will have most of our code that builds our GUI etc)
	public void run() {
		// 4. add components together, pack, and set visible
		frame.add(panel);
		panel.add(button1);
		panel.add(button2);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 5. add action listener 
		button1.addActionListener(this); // 6. hover red underline and choose "implement option"
		button2.addActionListener(this);
	}

	// the actionPerformed method runs whenever an event is detected
	@Override
	public void actionPerformed(ActionEvent e) {
		// 8. Figure out which button triggered the event
		JButton buttonPressed = (JButton) e.getSource();
		// 9. Now add the code in the action performed method that will be run when an event is detected
		if (buttonPressed == button1)
		{
			System.out.println("button 1 pressed");
		}
		else if (buttonPressed == button2)
		{
			System.out.println("button 2 pressed");
		}
	}
}
