import java.io.File;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class NameMeaning {

	public static void main(String[] args) throws Exception {
		
		String yourName = (String) JOptionPane.showInputDialog("What is your name?");
		
		Scanner inputFile = new Scanner(new File("names.csv"));
		
		String answer = "";
		
		while(inputFile.hasNextLine()) {
			String[] line = inputFile.nextLine().split(",");
			if(line[0].equals(yourName.toUpperCase())) {
				answer = line[1];
			}
		}
		
		JOptionPane.showMessageDialog(null, "Your Name: " + yourName + "\nMeaning: " + answer);
		
	}

}
