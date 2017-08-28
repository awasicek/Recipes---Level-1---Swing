import java.applet.AudioClip;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class FortuneTeller extends JPanel implements Runnable, MouseListener {

	JFrame frame = new JFrame();

	int frameWidth = 500;
	int frameHeight = 400;

	FortuneTeller() throws Exception {
		// 1. Choose an image for your fortune teller and put it in your default
		// package
		fortuneTellerImage = ImageIO.read(getClass().getResource("fortune-teller.jpg"));
		// 2. Adjust the frameWidth and frameHeight variables to fit your image
		// nicely (doesn’t need a new line of code)
		frameHeight = fortuneTellerImage.getHeight();
		frameWidth = fortuneTellerImage.getWidth();
		// 4. add a mouse listener to the frame
		frame.addMouseListener(this);
	}

	static void begin() {
		// 3. Welcome the user. Give them a hint for the secret location.
		JOptionPane.showMessageDialog(null,
				"Greetings! Click on the secret location to ask the fortune teller a question.  The secret area might be near from whence her words of wisdom emanate?");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int mouseX = e.getX();
		int mouseY = e.getY();
		// 5. Print the mouseX variable
		System.out.println("mouseX variable = " + mouseX + " and the mouseY variable = " + mouseY);
		// 6. Add the mouseY variable to the previous line so that it prints out
		// too (no new line)

		// 7. Adjust your secret location coordinates here:
		int secretLocationX = 322;
		int secretLocationY = 321;
		/**
		 * If the mouse coordinates and secret location are close, we'll let
		 * them ask a question.
		 */
		if (areClose(mouseX, secretLocationX) && areClose(mouseY, secretLocationY)) {
			// 8. Get the user to enter a question for the fortune teller
			JOptionPane.showInputDialog("What would you like to ask the fortune teller?");
			// 9. Find a spooky sound and put it in your default package
			// (freesound.org) **NOTE: you need a different library to play .mp3
			// files, so students should use .wav files for their sounds**
			// AudioClip sound =
			// JApplet.newAudioClip(getClass().getResource("spooky.aif"));
			// 10. Play the sound
			AudioClip sound = JApplet.newAudioClip(getClass().getResource("spooky-sound.wav"));
			sound.play();
			// 11. Use the pause() method below to wait until your music has
			// finished
			pause(6);
			// 12. Insert your completed Magic 8 ball recipe
			// (http://bit.ly/Zdrf6d) here
			int randomNumber = new Random().nextInt(4);
			System.out.println(randomNumber);
			// JOptionPane.showInputDialog("What would you like to ask the Magic
			// 8 Ball?");
			if (randomNumber == 0) {
				JOptionPane.showMessageDialog(null, "Yes");
			} else if (randomNumber == 1) {
				JOptionPane.showMessageDialog(null, "No");
			} else if (randomNumber == 2) {
				JOptionPane.showMessageDialog(null, "Maybe you should ask Google?");
			} else if (randomNumber == 3) {
				JOptionPane.showMessageDialog(null, "It is virtually certain.");
			}
		}

	}

	private boolean areClose(int mouseX, int secretLocationX) {
		return mouseX < secretLocationX + 15 && mouseX > secretLocationX - 15;
	}

	private void pause(int seconds) {
		try {
			Thread.sleep(1000 * seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/****************
	 * don't worry about the stuff under here
	 *******************/

	BufferedImage fortuneTellerImage;

	public static void main(String[] args) throws Exception {
		SwingUtilities.invokeLater(new FortuneTeller());
		begin();
	}

	@Override
	public void run() {
		frame.add(this);
		setPreferredSize(new Dimension(frameWidth, frameHeight));
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	private void showAnotherImage(String imageName) {
		try {
			fortuneTellerImage = ImageIO.read(getClass().getResource(imageName));
		} catch (Exception e) {
			System.err.println("Couldn't find this image: " + imageName);
		}
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(fortuneTellerImage, 0, 0, null);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}

// Copyright The League, 2016
