import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class TxtToXlsx {

	public static void main(String[] args) throws Exception {

		String length = "";
		String temp = "";

		Scanner keyboard = new Scanner(System.in);
		System.out.print("File name: ");
		String fileName = keyboard.nextLine();
		File txtFile = new File(fileName);
		Scanner fileReader = new Scanner(txtFile);

		ArrayList<String> xmlFormatList = new ArrayList<String>();
		ArrayList<String> lengthsList = new ArrayList<String>();
		ArrayList<String> tempsList = new ArrayList<String>();

		while (fileReader.hasNextLine()) {
			String fileReaderNextLine = fileReader.nextLine();
			if (fileReaderNextLine.contains("<data uid")) {
				xmlFormatList.add(fileReaderNextLine);
			}
		}

		String xmlFirstLine = xmlFormatList.get(0);
		String fixedXmlFirstLine = xmlFirstLine.replace("  <logData>", "");
		xmlFormatList.set(0, fixedXmlFirstLine);

		for (int i = 0; i < xmlFormatList.size(); i++) {
			String xmlLine = xmlFormatList.get(i);
			String fixedXmlLine1 = xmlLine.replace(
					"<data uid=\"measurement\">", "");
			String fixedXmlLine2 = fixedXmlLine1.replace("</data>", "");
			xmlFormatList.set(i, fixedXmlLine2);
		}

		for (int j = 0; j < xmlFormatList.size(); j++) {
			String[] brokenLine;
			String line = xmlFormatList.get(j);
			brokenLine = line.split(",");
			length = brokenLine[0];
			temp = brokenLine[5];

			if (Double.parseDouble(length) >= 0
					&& Double.parseDouble(length) <= 300) {
				lengthsList.add(length);
				tempsList.add(temp);
			}
		}

		for (int k = 0; k < lengthsList.size(); k++) {
			System.out.println(lengthsList.get(k) + ";" + tempsList.get(k));
			// Above is the line that prints out lenghts and temperatures.
//			System.out.println(tempsList.get(k));
			// Above is the line that prints out only temperatures.
		}
		
		//***Old instructions before program was made better
		// For the first file conversion, the lengths are needed for copying
		// over to .txt format. After the first conversion, only tempsList needs
		// to be printed out. Procedure:
		// 1) Copy .xml to .txt.
		// 2) Save as Data#.txt under Spain Research.
		// 3) Drag to TxtToXlsx folder in Eclipse.
		// 4) Run program.
		// 5) Copy data from console to TextEdit file Data#.txt.
		// 6) In Excel, import Data#.txt.
	}
}
