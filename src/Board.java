import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Board extends JPanel implements ActionListener{
	
	private JButton[] square = new JButton[9];
	private int player;
	private BufferedReader qanda;
	private Game gameArray;
	private int playerMark = 1;
	private int wins;
	protected static int NoOfPlayers;
	
	Board() {
		setLayout(new GridLayout(3, 3));
		square = new JButton[9];
		for (int i = 0; i < square.length; i++) { 
			square[i] = new JButton("");
		}
		for (int i = 0; i < square.length; i++) {
			square[i].addActionListener(this);
			add(square[i]);
		}
		setGame();
	}
	
	public void actionPerformed(ActionEvent E) {
		JButton pressed = (JButton) E.getSource();
		for (int button = 0; button < 9; button++) {
			if (pressed == square[button]) {
				boolean won = gameArray.arrayInitialize(button / 3, button % 3, playerMark);
				setText(pressed, playerMark,won);
				playerMark = nextTurn(playerMark);
				disableSquare(pressed);
				gameArray.checkPattern(playerMark);
			}
		}
	}
	
	public void setText(JButton button, int play, boolean a) {
		if (NoOfPlayers == 2){	
			if (play == 1 && a == true) {
				button.setText(Game.user);
			}
			else if (play == 2 && a == true) { 
				button.setText("guest");
			}
			else if (play == 1 && a == false) { 
				button.setText("guest");
			}
			else if (play == 2 && a == false) { 
				button.setText(Game.user);
			}
		}
		else {
			if (play == 1 && a) {
				button.setText(Game.user);
			}
			else if (play == 2 && a == true) { 
				button.setText("computer");
			}
			else if (play == 1 && a == false) { 
				button.setText("computer");
			}
			else if (play == 2 && a == false) { 
				button.setText(Game.user);
			}
		}
	}
	
	public void setGame() {
		gameArray = new Game(this);
		defaultText();
		disableAll(true);
		player = 2;
		playerMark = 1;
	}
	
	public int nextTurn(int last) {
		if (last == 2) {
			player = 1;
			return 1;
		} else if (last == 1) {
			player = 2;
			return 2;
		} else {
			return 3;
		}
	}
	
	public void defaultText() {
		for (int i = 0; i < square.length; i++) {
			square[i].setText("");
		}
	}
	
	public void disableAll(boolean n) {
		for (int i = 0; i < square.length; i++) {
			square[i].setEnabled(n);
		}
	}

	public void disableSquare(JButton button) {
		button.setEnabled(false);
	}
	
	void chooseSquare(ActionEvent a){
		a.setSource(square);
	}
	
	void answer(String a){
		
	}
	
	@SuppressWarnings("deprecation")
	void asasignSquare(JButton a){
		a.enable();
	}
	
	int changePlayer(int a){
		if (a == 1)
			return 0;
		else
			return 1;
	}
	
	boolean checkAnswer (boolean a, boolean b){
		if (a == b)
			return true;
		else
			return false;
	}
	
	void endGame(int a){
		//if (a == 1)
			//Game.endGame();
	}
}
