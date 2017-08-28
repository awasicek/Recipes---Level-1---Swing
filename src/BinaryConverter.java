import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BinaryConverter implements ActionListener {
	JFrame frame = new JFrame("Binary Converter");
	JPanel panel = new JPanel();
	JTextField inputField = new JTextField("Enter binary numbers to convert!");
	JButton convertButton = new JButton("Convert");
	JTextField outputField = new JTextField();
	
	public void start() {
		frame.add(panel);
		panel.add(inputField);
		inputField.setColumns(20);
		outputField.setColumns(20);
		panel.add(convertButton);
		panel.add(outputField);
		frame.setVisible(true);
		frame.pack();
		convertButton.addActionListener(this);
	}

	// Note that these methods have been changed (notably, the parameter for the 2nd method) and the reg ex line of code
	int convertToAsciiValue(String binary) {
		if (binary.length() != 8) {
			JOptionPane.showMessageDialog(null, "Enter 8 bits, silly!!!");
			inputField.setText("");
			return 0;
		}
//		if (!Pattern.matches("\2", binary)) {
		if (!binary.matches("[01]+")) {
			JOptionPane.showMessageDialog(null, "Binary can only contain 1s or 0s, silly!!!");
			inputField.setText("");
			return 0;
		}
		try {
			int asciiValue = Integer.parseInt(binary, 2);
			return asciiValue;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Enter a binary, silly!!!");
			inputField.setText("");
			return 0;
		}
	}

	String convertToString(int asciiValue) {
		char theLetter = (char) asciiValue;
		return "" + theLetter;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String input = inputField.getText();
		int convertedNum = convertToAsciiValue(input);
		String convertedString = convertToString(convertedNum);
		outputField.setText(convertedString);
		
	}

}
