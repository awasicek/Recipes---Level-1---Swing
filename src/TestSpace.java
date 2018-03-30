import javax.swing.JButton;
import javax.swing.JFrame;

public class TestSpace {
	JFrame frame = new JFrame();
	JButton button1 = new JButton("1");
	JButton button2 = new JButton("2");
	
	public void run()
	{
		frame.add(button1);
		frame.add(button2);
		frame.setVisible(true);
		frame.pack();
	}
	
	public static void main(String[] args) {
		TestSpace ts = new TestSpace();
		ts.run();
	}
}
