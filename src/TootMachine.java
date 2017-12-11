import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TootMachine implements ActionListener {
	public static void main(String[] args) {
		new TootMachine().run();
	}

	JFrame frame = new JFrame("Toot Machine v1.0");
	JPanel panel = new JPanel();
	JButton button1 = new JButton("Wasn't me.");
	JButton button2 = new JButton("He did it.");
	JButton button3 = new JButton("No, she did it!");
	String fart1 = "fart1.wav";
	String fart2 = "fart2.wav";
	String fart3 = "fart3.wav";

	void run() {
		frame.add(panel);
		frame.setVisible(true);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		frame.pack();
	}

	
	// NOTE: make sure the wav file is placed in the default package
	private void playSound(String fileName) {
		AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName));
		sound.play();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();
		if (buttonPressed == button1) {
			playSound(fart1);
		} else if (buttonPressed == button2) {
			playSound(fart2);
		} else {
			playSound(fart3);
		}
	}
}
