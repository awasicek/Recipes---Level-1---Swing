import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class RPG implements ActionListener {
	public static void main(String[] args) {
		RPG rpg = new RPG();
		rpg.run();
	}

	JFrame frame = new JFrame();

	// Multiple panels. One for arranging the other panels and then specific
	// panels for each sub-area.
	JPanel mainPanel = new JPanel();
	JPanel characterPanel = new JPanel();
	JPanel enemyPanel = new JPanel();
	JPanel attackPanel = new JPanel();

	JLabel character = new JLabel();
	JLabel characterHP = new JLabel();
	JLabel enemy = new JLabel();
	JLabel enemyHP = new JLabel();
	JButton attack = new JButton("attack");

	int characterHealth = 80;
	int enemyHealth = 100;

	public void run() {
		frame.add(mainPanel);
		// FlowLayout is the default layout manager for every JPanel. It simply
		// lays out components in a single row.

		// GridBagLayout is a sophisticated, flexible layout manager. It aligns
		// components by placing them within a grid of cells, allowing
		// components to span more than one cell.
		// The rows in the grid can have different heights, and grid columns can
		// have different widths.

		// A BorderLayout places components in up to five areas: top, bottom,
		// left, right, and center.
		mainPanel.setLayout(new BorderLayout(5, 5)); // the parameters for
														// BorderLayout specify
														// horizontal and
														// vertical gaps between
														// components
		mainPanel.add(characterPanel, BorderLayout.LINE_START);
		mainPanel.add(enemyPanel, BorderLayout.LINE_END);
		mainPanel.add(attackPanel, BorderLayout.PAGE_END);

		// The BoxLayout class puts components in a single row or column.
		// It respects the components' requested maximum sizes and also lets you
		// align components.
		characterPanel.setLayout(new BoxLayout(characterPanel, BoxLayout.PAGE_AXIS)); //
		enemyPanel.setLayout(new BoxLayout(enemyPanel, BoxLayout.PAGE_AXIS)); //

		character = loadImageFromComputer("Knight.jpg");
		enemy = loadImageFromComputer("Dragon.jpg");

		characterPanel.add(character);
		characterPanel.add(characterHP);
		character.setAlignmentX(Component.CENTER_ALIGNMENT);
		characterHP.setAlignmentX(Component.CENTER_ALIGNMENT);

		characterHP.setText("HP: 80");

		enemyPanel.add(enemy);
		enemyPanel.add(enemyHP);
		enemy.setAlignmentX(Component.CENTER_ALIGNMENT);
		enemyHP.setAlignmentX(Component.CENTER_ALIGNMENT);

		enemyHP.setText("HP: 100");

		attackPanel.add(attack);

		attack.addActionListener(this);

		frame.pack();
		frame.setLocationRelativeTo(null); // centers the frame (call after
											// packing otherwise it will be off
											// center)
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit on close
																// of window
	}

	/*
	 * To use this method, the image must be placed in your Eclipse project
	 * under "default package".
	 */
	public JLabel loadImageFromComputer(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		return new JLabel(icon);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int enemyDamage = new Random().nextInt(10);
		int characterDamage = new Random().nextInt(5);
		characterHealth -= enemyDamage;
		enemyHealth -= characterDamage;
		characterHP.setText("HP: " + characterHealth);
		enemyHP.setText("HP: " + enemyHealth);
		if (enemyHealth <= 0) {
			JOptionPane.showMessageDialog(null, "You win!");
			System.exit(0);
		} else if (characterHealth <= 0) {
			JOptionPane.showMessageDialog(null, "You lose!");
			System.exit(0);
		}
	}
}
