import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

import javax.swing.JOptionPane;

public class Game {
	private Board board;
	private int[][] celebritySquares;
	static String user;
	static String pass;
	static boolean celebAns;
	static int ans; 
	static int questionN;
	static int count = 0;
	static int[] usedQuestions = new int[55];
	
	
	public static HashMap<Integer, Question> questionMap = new HashMap<Integer, Question>();
	public static HashMap<String, Player> userMap = new HashMap<String, Player>();

	Game() {

	}

	public Game(Board board, int[][] arrayData) {
		this.board = board;
		celebritySquares = arrayData;
	}

	public Game(Board board) {
		this.board = board;
		celebritySquares = new int[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				celebritySquares[i][j] = 0;
			}
		}
		random = new Random();
	}

	public void checkPattern(int marker) {
		
		if (Board.NoOfPlayers == 2) {
			if ((celebritySquares[0][0] == marker && celebritySquares[0][1] == marker
					&& celebritySquares[0][2] == marker)
					|| (celebritySquares[1][0] == marker && celebritySquares[1][1] == marker
							&& celebritySquares[1][2] == marker)
					|| (celebritySquares[2][0] == marker && celebritySquares[2][1] == marker
							&& celebritySquares[2][2] == marker)) {
				if (marker == 1) {
					JOptionPane.showMessageDialog(board, userMap.get(user).getUsername() + " wins!");
					userMap.get(user).setScore(userMap.get(user).getScore() + 1);
				} else if (marker == 2) {
					JOptionPane.showMessageDialog(board, "guest wins!");
				}
				board.disableAll(false);

			} else if ((celebritySquares[0][0] == marker && celebritySquares[1][0] == marker
					&& celebritySquares[2][0] == marker)
					|| (celebritySquares[0][1] == marker && celebritySquares[1][1] == marker
							&& celebritySquares[2][1] == marker)
					|| (celebritySquares[0][2] == marker && celebritySquares[1][2] == marker
							&& celebritySquares[2][2] == marker)) {

				if (marker == 1) {
					JOptionPane.showMessageDialog(board, userMap.get(user).getUsername() + " wins!");
					userMap.get(user).setScore(userMap.get(user).getScore() + 1);
				} else if (marker == 2) {
					JOptionPane.showMessageDialog(board, "guest wins!");
				}
				board.disableAll(false);

			} else if ((celebritySquares[0][0] == marker && celebritySquares[1][1] == marker
					&& celebritySquares[2][2] == marker)
					|| (celebritySquares[2][0] == marker && celebritySquares[1][1] == marker
							&& celebritySquares[0][2] == marker)) {
				if (marker == 1) {
					JOptionPane.showMessageDialog(board, userMap.get(user).getUsername() + " wins!");
					userMap.get(user).setScore(userMap.get(user).getScore() + 1);
				} else if (marker == 2) {
					JOptionPane.showMessageDialog(board, "guest wins!");
				}
				board.disableAll(false);
			}
			else{
				int count = 0;
				int count2 = 0;
				for(int i = 0; i < 3; i++){
					for(int j = 0; j < 3; j++){
						if(celebritySquares[i][j] == 1)
							count++;
						else if(celebritySquares[i][j] == 2)
							count2++;
					}
				}
				if(count == 5) {
					JOptionPane.showMessageDialog(board, userMap.get(user).getUsername() + " wins!");
					userMap.get(user).setScore(userMap.get(user).getScore() + 1);
				} else if (count2 == 5) {
					JOptionPane.showMessageDialog(board, "Guest wins!");
				}
			}
		} 
		else  {
			if ((celebritySquares[0][0] == marker && celebritySquares[0][1] == marker
					&& celebritySquares[0][2] == marker)
					|| (celebritySquares[1][0] == marker && celebritySquares[1][1] == marker
							&& celebritySquares[1][2] == marker)
					|| (celebritySquares[2][0] == marker && celebritySquares[2][1] == marker
							&& celebritySquares[2][2] == marker)) {
				if (marker == 1) {
					JOptionPane.showMessageDialog(board, userMap.get(user).getUsername() + " wins!");
					userMap.get(user).setScore(userMap.get(user).getScore() + 1);
				} else if (marker == 2) {
					JOptionPane.showMessageDialog(board, "computer wins!");
				}
				board.disableAll(false);

			} else if ((celebritySquares[0][0] == marker && celebritySquares[1][0] == marker
					&& celebritySquares[2][0] == marker)
					|| (celebritySquares[0][1] == marker && celebritySquares[1][1] == marker
							&& celebritySquares[2][1] == marker)
					|| (celebritySquares[0][2] == marker && celebritySquares[1][2] == marker
							&& celebritySquares[2][2] == marker)) {

				if (marker == 1) {
					JOptionPane.showMessageDialog(board, userMap.get(user).getUsername() + " wins!");
					userMap.get(user).setScore(userMap.get(user).getScore() + 1);
				} else if (marker == 2) {
					JOptionPane.showMessageDialog(board, "computer wins!");
				}
				board.disableAll(false);

			} else if ((celebritySquares[0][0] == marker && celebritySquares[1][1] == marker
					&& celebritySquares[2][2] == marker)
					|| (celebritySquares[2][0] == marker && celebritySquares[1][1] == marker
							&& celebritySquares[0][2] == marker)) {
				if (marker == 1) {
					JOptionPane.showMessageDialog(board, user + " wins!");
					userMap.get(user).setScore(userMap.get(user).getScore() + 1);
				} else if (marker == 2) {
					JOptionPane.showMessageDialog(board, "computer wins!");
				}
				board.disableAll(false);
			}
			else{
				int count = 0;
				int count2 = 0;
				for(int i = 0; i < 3; i++){
					for(int j = 0; j < 3; j++){
						if(celebritySquares[i][j] == 1)
							count++;
						else if(celebritySquares[i][j] == 2)
							count2++;
					}
				}
				if(count == 5) {
					JOptionPane.showMessageDialog(board, userMap.get(user).getUsername() + " wins!");
					userMap.get(user).setScore(userMap.get(user).getScore() + 1);
				} else if (count2 == 5) {
					JOptionPane.showMessageDialog(board, "Computer wins!");
				}
			}
		}
	}

	void updateArray(int a, int b) {

	}
	
	public static void questionsToHash() {
		String a = null, b = null;
		Question q;
		File file = new File("Questions.txt");
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try (BufferedReader br = new BufferedReader(new FileReader("Questions.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] splitArray = line.split(":");
				a = splitArray[1];
				b = splitArray[2];
				q = new Question(a, b);
				questionMap.put(Integer.parseInt(splitArray[0]), q);
				System.out.println(questionMap.get(Integer.parseInt(splitArray[0])).getQuestion() + ", " + questionMap.get(Integer.parseInt(splitArray[0])).getAnswer());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Random random;
	
	private static String celebAnswer(int rand){ 
		if(rand%2 == 0){
			celebAns = true;
			return "True";
		}
		else{
			celebAns = false;
			return "False";
		}
	}
	
	private static String ans(boolean ans){
		if(ans)
			return "True";
		return "False";
	}
	
	private static boolean inputAnswer(int ans){
		if(ans == 1)
			return false;
		else
			return true;
	}
	
	public boolean arrayInitialize(int i, int j, int marker) {
		ans = random.nextInt(2); 
		questionN = random.nextInt(50) + 1;
		String question = questionMap.get(questionN).getQuestion();
		checkPattern(marker);
	//	String answer = JOptionPane.showInputDialog(question, "");
		int answerInt = JOptionPane.showConfirmDialog(null, "Question:\t" + question + "\nCelebrity's Answer:\t" + celebAnswer(ans), "Q&A", 0, 3); //added by Robbi
		
		boolean b = board.checkAnswer(celebAns, inputAnswer(answerInt));
		String answer = ans(b);
		if(answer.equals(questionMap.get(questionN).getAnswer()) && marker == 1) {
			celebritySquares[i][j] = 1;
		} else if (answer.equals(questionMap.get(questionN).getAnswer()) && marker == 2) {
			celebritySquares[i][j] = 2;
		} else if(!answer.equals(questionMap.get(questionN).getAnswer()) && marker == 1) {
			celebritySquares[i][j] = 2;
		} else if(!answer.equals(questionMap.get(questionN).getAnswer()) && marker == 2) {
			celebritySquares[i][j] = 1;
		}
		if(answer.equals(questionMap.get(questionN).getAnswer())) {
			return true;
		}

		return false;
	}

	public static void playersToHash() {
		String a = null, b = null;
		Player p;
		File file = new File("Users.txt");
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try (BufferedReader br = new BufferedReader(new FileReader("Users.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] splitArray = line.split(",");
				a = splitArray[0];
				b = splitArray[1];
				p = new Player(a, b, Integer.parseInt(splitArray[2]));
				userMap.put(p.getUsername(), p);
//				System.out.println(userMap.get(user).getUsername() + ", " + userMap.get(user).getPassword() + ", " + userMap.get(user).getScore());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void createPlayer() throws IOException {
		String user = JOptionPane.showInputDialog("Enter Username", "");
		Iterator it = userMap.entrySet().iterator();
		while (it.hasNext()) {
			HashMap.Entry pair = (HashMap.Entry) it.next();
			if (pair.getKey().equals(user)){
				JOptionPane.showMessageDialog(null, "Error, Username already exists!");
				System.exit(0);
			}
		}
		String password = JOptionPane.showInputDialog("Enter Password", "");
		Player a = new Player(user, password);
		try (FileWriter fw = new FileWriter("Users.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw)) {
			out.println(a.getUsername().toLowerCase() + ',' + a.getPassword() + ',' + a.getScore());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void login() {

		user = JOptionPane.showInputDialog("Enter Username", null);
		pass = JOptionPane.showInputDialog("Enter Password", null);
		if (!userMap.get(user).getPassword().equals(pass)) {
			JOptionPane.showMessageDialog(null, "Incorrect User or Password");
			System.exit(0);
		} 
	}
	
	public static void main (String[] args) {
		playersToHash();
		questionsToHash();
	    Iterator it = userMap.entrySet().iterator();
	    while (it.hasNext()) {
	        HashMap.Entry pair = (HashMap.Entry)it.next();
	        System.out.println(pair.getKey() + " = " + pair.getValue().toString());
	        it.remove(); // avoids a ConcurrentModificationException
	    }
	    Iterator it2 = questionMap.entrySet().iterator();
	    while (it2.hasNext()) {
	        HashMap.Entry pair = (HashMap.Entry)it2.next();
	        System.out.println(pair.getKey() + " = " + pair.getValue().toString());
	        it2.remove(); // avoids a ConcurrentModificationException
	    }
	}
}