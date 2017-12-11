import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TypingTutor implements KeyListener {

	// 1. Create a frame for your typing game.

	JFrame myFrame = new JFrame("Typing Tutor v1.0");
	char currentLetter;
	JLabel letterLabel = new JLabel();
	int numCorrect = 0;

	public static void main(String[] args) {
		new TypingTutor().run();
	}

	void run() {

		// 3. Use a JLabel to show currentLetter on the screen. Make sure it
		// changes every time you start the game.
		currentLetter = generateRandomLetter();
		myFrame.add(letterLabel);
		String letterString = Character.toString(currentLetter);
		letterLabel.setText(letterString);

		// 4. Format the letter so that it is nice and big. Here are some
		// hints....
		// jLabel.setFont(jLabel.getFont().deriveFont(28.0f));
		// jLabel.setHorizontalAlignment(JLabel.CENTER);
		letterLabel.setFont(letterLabel.getFont().deriveFont(28.0f));
		letterLabel.setHorizontalAlignment(letterLabel.CENTER);

		myFrame.setVisible(true);
		myFrame.pack();

		// 5. Add a key listener to the frame.
		myFrame.addKeyListener(this);

	}

	// 2. Create a member variable char currentLetter and initialize it with
	// this method. char generateRandomLetter() {
	// Random r = new Random();
	// return (char) (r.nextInt(26) + 'a');
	// }

	char generateRandomLetter() {
		Random r = new Random();
		return (char) (r.nextInt(26) + 'a');
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		// 8. If they typed the currentLetter, print “correct”.

		if (e.getKeyChar() == currentLetter) {
			System.out.println("Correct.");
			// 9. If they typed the correct letter, set the frame background to
			// green. Otherwise set it to red.
			Container c = myFrame.getContentPane();
			c.setBackground(Color.green);
			numCorrect++;
		} else {
			Container c = myFrame.getContentPane();
			c.setBackground(Color.red);
		}

		// 6. Make the letter change every time a key is pressed. To do that, in
		// the keyReleased method:
		// i) Reset currentLetter. ii) Update your JLabel.
		currentLetter = generateRandomLetter();
		String letterString = Character.toString(currentLetter);
		letterLabel.setText(letterString);

		// 7. In the keyPressed method, print out the character that the user
		// typed.
		System.out.println("User typed: " + e.getKeyChar());
		
		if (numCorrect % 20 == 0) {
			showTypingSpeed(numCorrect);
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	// 10. [optional] After a certain number of characters, show the users’
	// typing speed.
	private void showTypingSpeed(int numberOfCorrectCharactersTyped) {
		Date timeAtEnd = new Date();
		long gameDuration = timeAtEnd.getTime() - timeAtStart.getTime();
		long gameInSeconds = (gameDuration / 1000) % 60;
		double charactersPerSecond = ((double) numberOfCorrectCharactersTyped / (double) gameInSeconds);
		int charactersPerMinute = (int) (charactersPerSecond * 60); JOptionPane.showMessageDialog(null, "Your typing speed is " + charactersPerMinute
		+ " characters per minute."); 
		}

	Date timeAtStart = new Date();

}
