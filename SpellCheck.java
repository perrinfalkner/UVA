import java.io.File;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class SpellCheck {

	public static void main(String[] args) throws Exception {
		String yourWord = (String) JOptionPane
				.showInputDialog("What word?");

		Scanner inputFile = new Scanner(new File("misspellings.csv"));

		String answer = "";

		while (inputFile.hasNextLine()) {
			String[] line = inputFile.nextLine().split(",");
			if (line[0].equals(yourWord.toLowerCase())) {
				answer = line[1];
			}
		}

		JOptionPane.showMessageDialog(null, "Your Word: " + yourWord
				+ "\nDid you mean: " + answer);

	}

}
