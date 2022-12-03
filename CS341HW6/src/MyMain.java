import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class MyMain {

	public static void main(String[] args) {
		File inputFile;
		Scanner fileInputScan = null;
		try {
			inputFile = new File("C:/Users/malac/Desktop/java/MyClass.java");
			fileInputScan = new Scanner(inputFile);
			ArrayList<String> listMCS = collectMCS(fileInputScan);
			int listcount = collectcount(fileInputScan);
			String MCSString = "";
			System.out.println("This is the number of line in this code: "+listcount);
			for (int i = 0; i < listMCS.size(); i++) {
				MCSString += listMCS.get(i) + "\n";
			}
			System.out.println("The are the method in the code "+MCSString);
		} catch (FileNotFoundException e) {
			System.out.println("Error - This file could not be found.");
		} finally {
			if (fileInputScan != null) {
				fileInputScan.close();
			}
		}
	}

	public static ArrayList<String> collectMCS(Scanner fileInputScan) {
		Stack<String> stack = new Stack<String>();
		ArrayList<String> arrayList = new ArrayList<String>();
		String codeLine = "";
		String possibleMCS = "";

		while (fileInputScan.hasNextLine()) {
			codeLine = fileInputScan.nextLine();
			codeLine = codeLine.trim();
			if (isCode(codeLine)) {
				if (!codeLine.equals("{") && !codeLine.equals("}")) {
					possibleMCS = codeLine;
				} else if (codeLine.equals("{")) {
					stack.push(possibleMCS);
					stack.toString();
				} else {
					arrayList.add(0, stack.pop());
				}
			}
		}
		return arrayList;
	}
	
	public static int collectcount(Scanner fileInputScan) {
		int x=0;
		String codeLine = "";
		String possibleMCS = "";

		while (fileInputScan.hasNextLine()) {
			codeLine = fileInputScan.nextLine();
			codeLine = codeLine.trim();
			if (isCode(codeLine)) {
				if (!codeLine.equals("//")) {
					possibleMCS = codeLine;
				}
				else {
					x++;
				}
			}
		}
		return x;
	}

	public static boolean isCode(String str) {
		return str.length() > 0;
	}

}

