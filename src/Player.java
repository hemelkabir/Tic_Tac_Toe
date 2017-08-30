import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class Player {

	private String userName;
	private String password;
	private int score;

	Player(String a, String b) {
		userName = a;
		password = b;
		score = 0;
	}
	
	Player(String a, String b, int c) {
		userName = a;
		password = b;
		score = c;
	}
	
	public String getUsername() {
		return userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public int getScore() {
		return score;
	}

	public void setPassword(String a) {
		password = a;
	}
	
	public void setScore(int a){
		score = a;
	}

	public boolean validateUser(String a) {
		if (a == userName)
			return true;
		else
			return false;
	}

	public boolean validatePass(String a) {
		if (a == password)
			return true;
		else
			return false;
	}

	public boolean checkValidity(String userName, String password) {
		if (validateUser(userName) && validatePass(password))
			return true;
		else
			return false;
	}

	public void updatePassword(Player a) {
		String password = JOptionPane.showInputDialog("", "Enter Current Password");
		if (!validatePass(password))
			System.out.println("Incorrect Password!");
		else {
			String newP = JOptionPane.showInputDialog("", "Enter New Password");
			a.setPassword(newP);
		}

	}
	
	public void print(){
		System.out.println(userName + ", " + password + ", " + score);
	}
	
	public String toString() {
		return (getUsername() + ", " + getPassword() + ", " + getScore());
	}

}
