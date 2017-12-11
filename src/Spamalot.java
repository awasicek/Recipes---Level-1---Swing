import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Spamalot implements ActionListener {
	static final String FAKE_USERNAME = "bobthecodeman@gmail.com";
	static final String FAKE_PASSWORD = "weakpassword";

	JFrame myFrame = new JFrame("Spamalot v1.0");
	JPanel myPanel = new JPanel();
	JTextField myTextfield = new JTextField(10);
	JButton badButton = new JButton("BAD");
	JButton goodButton = new JButton("GOOD");

	
	public static void main(String[] args) {
		new Spamalot().run();
	}
	
	public void run() {
		myFrame.add(myPanel);
		myFrame.setVisible(true);
		myPanel.add(myTextfield);
		myPanel.add(badButton);
		myPanel.add(goodButton);
		myFrame.pack();
		badButton.addActionListener(this);
		goodButton.addActionListener(this);
	}
	
	private boolean sendSpam(String recipient, String subject, String content) {

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(FAKE_USERNAME, FAKE_PASSWORD);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(FAKE_USERNAME));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
			message.setSubject(subject);
			message.setText(content);
			Transport.send(message);
			return true;

		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();		
		if (buttonPressed == badButton) {
			String recipient = myTextfield.getText();
			if (sendSpam(recipient, "test from league", "bad message")) {
				myTextfield.setBackground(Color.GREEN);
			} else {
				myTextfield.setBackground(Color.RED);
			}
		} else {
			String recipient = myTextfield.getText();
			if (sendSpam(recipient, "test from league", "good message")) {
				myTextfield.setBackground(Color.GREEN);
			} else {
				myTextfield.setBackground(Color.RED);
			}
		}
	}
}
