import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SimpleCalculator implements ActionListener {

//	Create a window with 2 JTextFields and 4 JButtons to function as a simple calculator. 
//	Each mathematical function must be contained in its own method. 
//	Display the answer as a JLabel.
	
	JFrame frame = new JFrame("Calculator v1.0");
	JPanel panel = new JPanel();
	JTextField input1 = new JTextField(20);
	JTextField input2 = new JTextField(20);
	JLabel answer = new JLabel();
	JButton addButton = new JButton("+");
	JButton subButton = new JButton("-");
	JButton multButton = new JButton("x");
	JButton divButton = new JButton("/");
	
	
	public static void main(String[] args) {
		new SimpleCalculator().run();
	}
	
	void run() {
		frame.add(panel);
		panel.add(input1);
		panel.add(input2);
		input1.setText("0");
		input2.setText("0");
		panel.add(addButton);
		panel.add(subButton);
		panel.add(multButton);
		panel.add(divButton);
		panel.add(answer);
		answer.setText("Answer");
		addButton.addActionListener(this);
		subButton.addActionListener(this);
		multButton.addActionListener(this);
		divButton.addActionListener(this);
		frame.pack();
		frame.setVisible(true);
	}
	
	double add(double x, double y) {
		return x + y;
	}
	
	double subtract(double x, double y) {
		return x - y;
	}
	
	double multiply(double x, double y) {
		return x * y;
	}
	
	double divide(double x, double y) {
		return x / y;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();
		if (buttonPressed == addButton) {
			double field1 = Double.parseDouble(input1.getText());
			double field2 = Double.parseDouble(input2.getText());
			double sum = add(field1, field2);
			String sumString = String.valueOf(sum);
			answer.setText(sumString);
		} else if (buttonPressed == subButton) {
			double field1 = Double.parseDouble(input1.getText());
			double field2 = Double.parseDouble(input2.getText());
			double result = subtract(field1, field2);
			String resultString = String.valueOf(result);
			answer.setText(resultString);
		} else if (buttonPressed == multButton) {
			double field1 = Double.parseDouble(input1.getText());
			double field2 = Double.parseDouble(input2.getText());
			double product = multiply(field1, field2);
			String productString = String.valueOf(product);
			answer.setText(productString);
		} else if (buttonPressed == divButton) {
			double field1 = Double.parseDouble(input1.getText());
			double field2 = Double.parseDouble(input2.getText());
			double result = divide(field1, field2);
			String resultString = String.valueOf(result);
			answer.setText(resultString);
		}
	}
}
