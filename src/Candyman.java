import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Candyman implements ActionListener {
	
	// 1. Create a user interface that has a single button labeled “Candyman”. 

	// 2. When the user presses it 5 times, show them a scary picture from the internet using the method below.
	
	
	public static void main(String[] args) {
		Candyman cm = new Candyman();
		cm.run();
	}

	JFrame myFrame = new JFrame("Candyman App v1.0");
	JPanel myPanel = new JPanel();
	JButton myButton = new JButton("Candyman");
	
	static final int CREEPY = 0;
	static final int SCREAM = 1;
	
	int candyCounter = 0;
	
	public void run() {
		myFrame.setVisible(true);
		myFrame.add(myPanel);
		myPanel.add(myButton);
		myButton.addActionListener(this);
		myFrame.pack();
	}
	
	private void showPictureFromTheInternet(String imageUrl) {
		try {
			URL url = new URL(imageUrl);
			Icon icon = new ImageIcon(url);
			JLabel imageLabel = new JLabel(icon);
			JFrame frame = new JFrame();
			frame.add(imageLabel);
			frame.setVisible(true);
			frame.pack();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public static void playSound(int whichSound) {
		File soundFile = null;
		if (whichSound == CREEPY)
			//soundFile = new File("/Users/Guest/Google Drive/league-sounds/creepy-noise.wav");
			soundFile = new File("/Users/awasicek/Desktop/League/Workspace/Recipes - Level 1 - Swing/src/spooky-sound.wav");

		else if (whichSound == SCREAM)
			//soundFile = new File("/Users/League/Google Drive/league-sounds/scream.wav");
			soundFile = new File("/Users/awasicek/Desktop/League/Workspace/Recipes - Level 1 - Swing/src/scream.wav");
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
			Thread.sleep(3400);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		candyCounter++;
		if(candyCounter < 5) {
			playSound(CREEPY);
		} else if (candyCounter == 5) {
			showPictureFromTheInternet("https://i.ytimg.com/vi/KDRPnpVb5T8/maxresdefault.jpg");
			playSound(SCREAM);
			candyCounter = 0;
		}
		
	}
}
