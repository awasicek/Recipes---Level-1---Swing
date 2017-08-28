import java.awt.Frame;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class BodyPartQuiz {

	// Get 3 celebrity photos from the internet, save them to your computer, and
	// fill
	// in their paths here. To get the path, right click on the image, and copy
	// its Location.
	String firstImage = "/Users/awasicek/Desktop/League/Workspace/Recipes - Level 1 - Swing/src/celebrity-1.jpg";
	String secondImage = "/Users/awasicek/Desktop/League/Workspace/Recipes - Level 1 - Swing/src/celebrity-2.png";
	String thirdImage = "/Users/awasicek/Desktop/League/Workspace/Recipes - Level 1 - Swing/src/celebrity-3.jpg";

	Frame window = new Frame();

	private void startQuiz() {
		// Set the size of the window so that you can only see part of the
		// image.
		window.setSize(200, 200);
		// Make an int variable to hold the score.
		int score = 0;
		// Ask the user who this person is and store their answer
		String userAnswer = JOptionPane.showInputDialog("Who is this celebrity?");
		// If they got the answer right:
		// -- Tell them they are correct.
		// -- Increase the score by 1
		if (userAnswer.equals("Alison Brie")) {
			JOptionPane.showMessageDialog(null, "That's right!");
			score++;
		}
		// Otherwise:
		// -- Tell them they are wrong
		else {
			JOptionPane.showMessageDialog(null, "Sorry! That is incorrect. It is Alison Brie!");
		}

		// Show the score
		JOptionPane.showMessageDialog(null, "Your score is: " + score + ".");
		
		// Use the method below to show the next image
		showNextImage();
		window.setSize(200, 200);
		
		// .... repeat for all your images.....
		userAnswer = JOptionPane.showInputDialog("Who is this celebrity?");
		if (userAnswer.equals("David Hyde Pierce")) {
			JOptionPane.showMessageDialog(null, "That's right!");
			score++;
		}
		else {
			JOptionPane.showMessageDialog(null, "Sorry! That is incorrect. It is David Hyde Pierce!");
		}
		JOptionPane.showMessageDialog(null, "Your score is: " + score + ".");
		
		showNextImage();
		window.setSize(200, 200);

		userAnswer = JOptionPane.showInputDialog("Who is this celebrity?");
		if (userAnswer.equals("Jordan Peele")) {
			JOptionPane.showMessageDialog(null, "That's right!");
			score++;
		}
		else {
			JOptionPane.showMessageDialog(null, "Sorry! That is incorrect. It is Jordan Peele!");
		}
		JOptionPane.showMessageDialog(null, "Your score is: " + score + ". Thanks for playing.");
		showNextImage();
		System.exit(0);
		
	}

	public void showNextImage() {
		window.removeAll();
		window.add(getNextImage());
		window.pack();
	}

	public static void main(String[] args) {
		BodyPartQuiz quiz = new BodyPartQuiz();
		quiz.initializeGui();
		quiz.startQuiz();
	}

	private void initializeGui() {
		initializeImageList();
		imageIterator = imageList.iterator();
		window.setVisible(true);
		showNextImage();
	}

	private JLabel loadImage(String fileName) {
		Icon icon = new ImageIcon(fileName);
		JLabel image = new JLabel(icon);
		return image;
	}

	ArrayList<JLabel> imageList = new ArrayList<JLabel>();
	Iterator<JLabel> imageIterator;

	private void initializeImageList() {
		JLabel imageLabel = loadImage(firstImage);
		imageList.add(imageLabel);
		imageLabel = loadImage(secondImage);
		imageList.add(imageLabel);
		imageLabel = loadImage(thirdImage);
		imageList.add(imageLabel);
	}

	private JLabel getNextImage() {
		if (imageIterator.hasNext()) {
			System.out.println("found an image");
			return imageIterator.next();
		}
		System.out.println("about to dispose"); // test line
		window.dispose();
		return new JLabel();
	}
}
