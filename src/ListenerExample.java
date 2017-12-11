import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

// 6. click red underline and choose "add unimplemented methods"
public class ListenerExample implements ActionListener {
	public static void main(String[] args) {
		// 2. start the run method from main
		ListenerExample ex = new ListenerExample();
		ex.run();
	}
	
	// 1. make a run method (this is where we will have most of our code that builds our GUI etc)
	public void run() {
		// 3. make your GUI components like normal
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton button = new JButton("Click me");
		frame.add(panel);
		panel.add(button);
		frame.pack();
		frame.setVisible(true);
		// 4. add action listener 
		button.addActionListener(this);
		// 5. click red underline and choose "implement option"

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// 7. Now add the code in the action performed method that will be run when an event is detected
		System.out.println("event detected!");
	}
}
