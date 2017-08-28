
// Copyright Wintriss Technical Schools 2013

import java.applet.AudioClip;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DrumKit extends MouseAdapter {

	JLabel drumLabelWithImage1;
	JLabel drumLabelWithImage2;
	JLabel drumLabelWithImage3;


	public static void main(String[] args) throws Exception {
		new DrumKit().getGoing();
	}

	private void getGoing() throws MalformedURLException {
		// 1. Make a JFrame variable and initialize it using "new JFrame()"

		JFrame myFrame = new JFrame();

		// 2. Make the frame visible

		myFrame.setVisible(true);

		// 3. Set the size of the frame
		myFrame.setSize(800, 800);

		// 4. Set the title of the frame
		myFrame.setTitle("Drum Kit!!!");

		// 5. Make a JPanel and initialize it.
		JPanel myJPanel = new JPanel();

		// 6. Add the panel to the frame. (The panel is invisible.)
		myFrame.add(myJPanel);

		// 7. Download an image of a drum from the Internet. Drop it into your
		// Eclipse project under "default package".

		// 8. Put the name of your image in a String variable.
		String drumImage1 = "drum-image-1.jpg";
		String drumImage2 = "drum-image-2.jpg";
		String drumImage3 = "drum-image-3.jpg";

		// 9. Edit the next line to use your String variable
		// drumLabelWithImage = createLabelImage(drumImageString);
		drumLabelWithImage1 = createLabelImage(drumImage1);
		drumLabelWithImage2 = createLabelImage(drumImage2);
		drumLabelWithImage3 = createLabelImage(drumImage3);

		// 10. Add the image to the panel
		myJPanel.add(drumLabelWithImage1);
		myJPanel.add(drumLabelWithImage2);
		myJPanel.add(drumLabelWithImage3);


		// 11. Set the layout of the panel to "new GridLayout()"
		myJPanel.setLayout(new GridLayout());
		
		// 12. call the pack() method on the frame
		myFrame.pack();
		
		// 13. add a mouse listener to drumLabelWithImage.
		drumLabelWithImage1.addMouseListener(this);
		drumLabelWithImage2.addMouseListener(this);
		drumLabelWithImage3.addMouseListener(this);

	}

	public void mouseClicked(MouseEvent e) {
		// 14. When the mouse is clicked, print "mouse clicked"
		System.out.println("Mouse clicked!");
		
		JLabel drumClicked = (JLabel) e.getSource();
		// 15. Download a drum sound and drop it into your "default package".
		// You can find it on freesound.org. To download it, log in as
		// leagueofamazing/code4life.
		String drumSoundFileName1 = "drum-sound-1.wav";
		String drumSoundFileName2 = "drum-sound-2.wav";
		String drumSoundFileName3 = "drum-sound-3.wav";

		
		// 16. If they clicked on the drumImage...
		// 17. ...use the playSound method to play a drum sound.
		if(drumClicked == drumLabelWithImage1) {
			System.out.println("Mouse clicked on drum ONE!");
			playSound(drumSoundFileName1);
		} else if (drumClicked == drumLabelWithImage2) {
			System.out.println("Mouse clicked on drum TWO!");
			playSound(drumSoundFileName2);
		} else if (drumClicked == drumLabelWithImage3) {
			System.out.println("Mouse clicked on drum THREE!");
			playSound(drumSoundFileName3);
		}
		
		// 18. Add more images to make a drumkit. Remember to add a mouse
		// listener to each one.
	}

	private JLabel createLabelImage(String fileName) throws MalformedURLException {
		URL imageURL = getClass().getResource(fileName);
		if (imageURL == null) {
			System.err.println("Could not find image " + fileName);
			return new JLabel();
		}
		Icon icon = new ImageIcon(imageURL);
		JLabel imageLabel = new JLabel(icon);
		return imageLabel;
	}

	private void playSound(String fileName) {
		AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName));
		sound.play();
	}

}
