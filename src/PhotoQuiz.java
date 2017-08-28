
// Copyright Wintriss Technical Schools 2013
import java.awt.Component;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PhotoQuiz {

	public static void main(String[] args) throws Exception {
		int score = 0;
		
		Frame quizWindow = new Frame();
		quizWindow.setVisible(true);

		// 1. find an image on the internet, and put its URL in a String
		// variable (from your browser, right click on the image, and select
		// “Copy Image URL”)
		String imgOneUrl = "https://uproxx.files.wordpress.com/2016/04/calvin-and-hobbes.jpg";

		// 2. create a variable of type "Component" that will hold your image
		Component imgOneHolder;

		// 3. use the "createImage()" method below to initialize your Component
		imgOneHolder = createImage(imgOneUrl);

		
		// 4. add the image to the quiz window
		quizWindow.add(imgOneHolder);

		// 5. call the pack() method on the quiz window
		quizWindow.pack();
		

		// 6. ask a question that relates to the image
		String answer1 = JOptionPane.showInputDialog("Is there a tiger in this picture? (Yes or No)");

		// 7. print "CORRECT" if the user gave the right answer

		if (answer1.equals("Yes")) {
			score++;
			JOptionPane.showMessageDialog(null, "That is correct! Your score is " + score + ".");
		}

		// 8. print "INCORRECT" if the answer is wrong
		else {
			score--;
			JOptionPane.showMessageDialog(null, "Nope, wrong! Your score is " + score + ".");
		}

		// 9. remove the component from the quiz window (you may not see the
		// effect of this until step 12)
		quizWindow.remove(imgOneHolder);

		// 10. find another image and create it (might take more than one line
		// of code)
		String imgTwoUrl = "https://s-media-cache-ak0.pinimg.com/originals/34/94/e6/3494e61865446e40ad043309ac664003.jpg";
		Component imgTwoHolder;
		imgTwoHolder = createImage(imgTwoUrl);

		// 11. add the second image to the quiz window
		quizWindow.add(imgTwoHolder);

		// 12. pack the quiz window
		quizWindow.pack();

		// 13. ask another question
		String answer2 = JOptionPane.showInputDialog("Is there a boy in this picture? (Yes or No)");

		// 14+ check answer, say if correct or incorrect, etc.
		if (answer2.equals("No")) {
			score++;
			JOptionPane.showMessageDialog(null, "That is correct! Your score is " + score + ".");
		} else {
			score--;
			JOptionPane.showMessageDialog(null, "Nope, wrong! Your score is " + score + ".");
		}

	}

	private static Component createImage(String imageUrl) throws MalformedURLException {
		URL url = new URL(imageUrl);
		Icon icon = new ImageIcon(url);
		JLabel imageLabel = new JLabel(icon);
		return imageLabel;
	}
	
//	public void mouseMoved(MouseEvent e){
//		JOptionPane.showMessageDialog(null, "Hey, your mouse just touched the picture!");
//	}

	/* OPTIONAL */
	// *14. add scoring to your quiz
	// *15. make something happen when mouse enters image
	// (imageComponent.addMouseMotionListener())
}
