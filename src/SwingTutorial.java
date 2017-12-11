import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SwingTutorial {
	public static void main(String[] args) {
		// 1. Make (Initialize) your GUI components
		JFrame frame = new JFrame("Swing Tutorial");  // JFrame is a "heavy weight" container used to hold other components (think the window that holds everything else)
		JPanel panel = new JPanel(); // JPanel is a "light weight" container used to hold other components (think of a container that is used to organize other GUI components)
		JLabel label = new JLabel(); // Component which is a display area for text or image (or both)
		JButton button = new JButton("Out of Service Button"); // a push-able "button"
		// 2. Add your components together
		frame.add(panel);
		panel.add(label);
		label.setText("Hey! I am text inside your label!");
		panel.add(button);
		// 3. Pack the frame
		frame.pack();
		// 4. Set the frame visible
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
//**NOTE: we can add components besides the panel directly to the frame
// but this can complicate the code significantly, so students should just add panels to the frame and then add other components to the panel(s)**