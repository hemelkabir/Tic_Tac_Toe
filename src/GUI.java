import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class GUI extends JFrame implements ActionListener {

	private Board board;
	JMenuBar bar;
	JMenu file, edit;
	JMenuItem newItem, quitItem, undo, link;

	
	
	public GUI() {
		setLayout(new BorderLayout());
		board = new Board();
		add(board, BorderLayout.CENTER);
		setTitle("Hollywood Squares");
		createMenu();
		setSize(500, 500);
		setLocation(550, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		board.disableAll(false);
	}
	
	
	
	private void createMenu() {
		bar = new JMenuBar();
		setJMenuBar(bar); 
		
		file = new JMenu("File");
		bar.add(file);
		
		newItem = new JMenuItem("Sign Up");
		newItem.addActionListener(this); 
		file.add(newItem);
		
		newItem = new JMenuItem("Log In");
		newItem.addActionListener(this); 
		file.add(newItem);
		
		quitItem = new JMenuItem("New");
		quitItem.addActionListener(this);
		file.add(quitItem);		
		
		quitItem = new JMenuItem("Quit");
		quitItem.addActionListener(this);
		file.add(quitItem); 

		
		edit = new JMenu("Edit");
		bar.add(edit);
	}


	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals("Quit")) {
			System.exit(0);
		} else if (command.equals("Log In")) {
			Game.login();
			board.NoOfPlayers = Integer.parseInt(JOptionPane.showInputDialog("Enter Number of players (1-2)", ""));
			board.disableAll(true);
		} else if (command.equals("Sign Up")) {
			try {
				Game.createPlayer();
				board.disableAll(true);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
	}

}