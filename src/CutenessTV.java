import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CutenessTV implements ActionListener {
	public static void main(String[] args) {
		new CutenessTV().start();
	}
	
	JFrame frame = new JFrame("Cuteness TV");
	JPanel panel = new JPanel();
	JButton button1 = new JButton("Ducks");
	JButton button2 = new JButton("Frog");
	JButton button3 = new JButton("Fluffy Unicorns");

	public void start() {
		frame.add(panel);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		frame.setVisible(true);
		frame.pack();
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);

	}

	void showDucks() {
		playVideo("Drirjl5K9Yk");
	}

	void showFrog() {
		playVideo("aSjCb-FfxhI");
	}

	void showFluffyUnicorns() {
		playVideo("qRC4Vk6kisY");
	}

	void playVideo(String videoID) {
		try {
			//Note: the URI format for the youtube videos needed to be changed, per below
//			URI uri = new URI("https://www.youtube.com/v/" + videoID + "?autoplay=1");
			URI uri = new URI("https://www.youtube.com/watch?v=" + videoID);
			java.awt.Desktop.getDesktop().browse(uri);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton)e.getSource();
		if (buttonPressed == button1) {
			showDucks();
		} else if (buttonPressed == button2) {
			showFrog();
		} else if (buttonPressed == button3) {
			showFluffyUnicorns();
		}
	}
}
