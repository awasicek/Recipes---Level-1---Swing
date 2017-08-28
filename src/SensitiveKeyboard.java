import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class SensitiveKeyboard implements KeyListener {
	JFrame frame = new JFrame();
	
	public void start() {
		frame.setVisible(true);
		frame.addKeyListener(this);
	}

	public static void main(String[] args) {
		new SensitiveKeyboard().start();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		speak("Ouch");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	// Students can get the speak method from bit.ly/StephenHawkingRecipe
	static void speak(String words) {
	   	 try {
	   		 Runtime.getRuntime().exec("say " + words).waitFor();
	   	 } catch (Exception e) {
	   		 e.printStackTrace();
	   	 }
	    }

}
