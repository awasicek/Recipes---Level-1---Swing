import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

//**NOTE: This program does not have a step-by-step recipe. It is intended to teach students how to write a program using Swing from scratch.**

public class FortuneCookie implements ActionListener {
	public static void main(String[] args) {
		FortuneCookie myCookie = new FortuneCookie();
		myCookie.showButton();
	}
	
	public void showButton() {
		System.out.println("The showButton method is working!");
		JFrame myFrame = new JFrame();
		myFrame.setVisible(true);
		JButton myButton = new JButton("Click me to open your fortune cookie!!!");
		myFrame.add(myButton);
		myButton.addActionListener(this);
		myFrame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "Wooohooo!");
		int ran = new Random().nextInt(4);
		if(ran==0){
			JOptionPane.showMessageDialog(null, "Your fortune cookie says: Eat more vegetables!");
		}
		else if(ran==1){
			JOptionPane.showMessageDialog(null, "Your fortune cookie says: You will be very wealthy!");
		}
		else if(ran==2){
			JOptionPane.showMessageDialog(null, "Your fortune cookie says: Your persuasiveness will save the day!");
		}
		else if(ran==3){
			JOptionPane.showMessageDialog(null, "Your fortune cookie says: You will reap the benefits of your kindness!");
		}
		else {
			JOptionPane.showMessageDialog(null, "Your fortune cookie says: Eat less candy!");
		}
	}
}
