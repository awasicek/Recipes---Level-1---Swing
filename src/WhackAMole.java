import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class WhackAMole implements ActionListener {

	// 1. Make a drawButtons method that takes a random number as a parameter.
	// It should make a GUI like this, but the “mole!” location is random.
	// [Hint: set the size of the frame rather than packing it.]

	public static void main(String[] args) {
		int ran = new Random().nextInt(24) + 1;
		WhackAMole wm = new WhackAMole();
		wm.drawButtons(ran);
	}

	static int timesWhacked = 0;
	static int timesMissed = 0;
	Date timeAtStart = new Date();
	JFrame frame = new JFrame("Whack a Mole v1.0");
	JPanel panel = new JPanel();

	JButton button1 = new JButton();
	JButton button2 = new JButton();
	JButton button3 = new JButton();
	JButton button4 = new JButton();
	JButton button5 = new JButton();
	JButton button6 = new JButton();
	JButton button7 = new JButton();
	JButton button8 = new JButton();
	JButton button9 = new JButton();
	JButton button10 = new JButton();
	JButton button11 = new JButton();
	JButton button12 = new JButton();
	JButton button13 = new JButton();
	JButton button14 = new JButton();
	JButton button15 = new JButton();
	JButton button16 = new JButton();
	JButton button17 = new JButton();
	JButton button18 = new JButton();
	JButton button19 = new JButton();
	JButton button20 = new JButton();
	JButton button21 = new JButton();
	JButton button22 = new JButton();
	JButton button23 = new JButton();
	JButton button24 = new JButton();

	void drawButtons(int ranNum) {
		frame.setVisible(true);
		frame.setSize(250, 300);
		frame.add(panel);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		panel.add(button6);
		panel.add(button7);
		panel.add(button8);
		panel.add(button9);
		panel.add(button10);
		panel.add(button11);
		panel.add(button12);
		panel.add(button13);
		panel.add(button14);
		panel.add(button15);
		panel.add(button16);
		panel.add(button17);
		panel.add(button18);
		panel.add(button19);
		panel.add(button20);
		panel.add(button21);
		panel.add(button22);
		panel.add(button23);
		panel.add(button24);

		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		button7.addActionListener(this);
		button8.addActionListener(this);
		button9.addActionListener(this);
		button10.addActionListener(this);
		button11.addActionListener(this);
		button12.addActionListener(this);
		button13.addActionListener(this);
		button14.addActionListener(this);
		button15.addActionListener(this);
		button16.addActionListener(this);
		button17.addActionListener(this);
		button18.addActionListener(this);
		button19.addActionListener(this);
		button20.addActionListener(this);
		button21.addActionListener(this);
		button22.addActionListener(this);
		button23.addActionListener(this);
		button24.addActionListener(this);

		switch (ranNum) {
		case 1:
			button1.setText("mole!");
			break;
		case 2:
			button2.setText("mole!");
			break;
		case 3:
			button3.setText("mole!");
			break;
		case 4:
			button4.setText("mole!");
			break;
		case 5:
			button5.setText("mole!");
			break;
		case 6:
			button6.setText("mole!");
			break;
		case 7:
			button7.setText("mole!");
			break;
		case 8:
			button8.setText("mole!");
			break;
		case 9:
			button9.setText("mole!");
			break;
		case 10:
			button10.setText("mole!");
			break;
		case 11:
			button11.setText("mole!");
			break;
		case 12:
			button12.setText("mole!");
			break;
		case 13:
			button13.setText("mole!");
			break;
		case 14:
			button14.setText("mole!");
			break;
		case 15:
			button15.setText("mole!");
			break;
		case 16:
			button16.setText("mole!");
			break;
		case 17:
			button17.setText("mole!");
			break;
		case 18:
			button18.setText("mole!");
			break;
		case 19:
			button19.setText("mole!");
			break;
		case 20:
			button20.setText("mole!");
			break;
		case 21:
			button21.setText("mole!");
			break;
		case 22:
			button22.setText("mole!");
			break;
		case 23:
			button23.setText("mole!");
			break;
		case 24:
			button24.setText("mole!");
			break;
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();
		if (buttonPressed.getText().equals("mole!")) {
			System.out.println("Hit the mole");
			WhackAMole wm = new WhackAMole();
			wm.playSound("drum-sound-1.wav");
			timesWhacked++;
			System.out.println("Whacked: " + timesWhacked);
			// 3. Dispose of the frame and draw the buttons anew.
			frame.dispose();
			int ran = new Random().nextInt(24) + 1;
			wm.drawButtons(ran);
		} else {
			System.out.println("Missed the mole");
			// 2. If they click on a button other than “mole!”, use this speak()
			// method
			// to call them a dork.
			timesMissed++;
			System.out.println("Missed: " + timesMissed);
			// 5. Progressively insult them if they hit something other than the
			// mole!
			// button. If they get click an empty button twice, call them an
			// idiot.
			// If they click an empty button three times, call them a moron.
			// If they click an empty button four times, call them a complete
			// waste of
			// atoms.
			// [Use a switch statement for extra amazingness.]
			switch (timesMissed) {
			case 1:
				speak("dork");
				break;
			case 2:
				speak("idiot");
				break;
			case 3:
				speak("moron");
				break;
			case 4:
				speak("complete waste of atoms");
				timesMissed = 0;
				break;
			}

			// 3. Dispose of the frame and draw the buttons anew.
			frame.dispose();
			int ran = new Random().nextInt(24) + 1;
			WhackAMole wm = new WhackAMole();
			wm.drawButtons(ran);
		}
		if (timesWhacked == 10) {
			// 4. After they’ve whacked 10 moles, call this endGame() method.
			WhackAMole wm = new WhackAMole();
			wm.endGame(timeAtStart, timesWhacked);
		}
	}

	void speak(String words) {
		try {
			Runtime.getRuntime().exec("say " + words).waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void endGame(Date timeAtStart, int molesWhacked) {

		Date timeAtEnd = new Date();
		JOptionPane.showMessageDialog(null, "Your whack rate is "
				+ ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / molesWhacked) + " moles per second.");
	}

	// 6. Call this playSound() method when they hit a mole.
	private void playSound(String fileName) {
		AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName));
		sound.play();
	}

}
