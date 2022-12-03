import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class MyMain7 {

	public static void main(String[] args) {
		File inputFile;
		Scanner fileInputScan = null;
		try {
			inputFile = new File("C:/Users/malac/Desktop/java/MyClass.java");
			fileInputScan = new Scanner(inputFile);
			String str=fileInputScan.toString();
			int listcount = collectcount(fileInputScan);
			String[] Str=str.split(" ");
			Hashtable<Integer,String> hashtable=new Hashtable<>();
			for(int i=0; i<Str.length; i++) {
				hashtable.put(h(Str[i]), Str[i]);
			}
			System.out.println("Hashtable is : "+hashtable);
			System.out.println("This is the number of line in this code: "+listcount);
			System.out.println("The number of keywords is "+Str.length);
		} catch (FileNotFoundException e) {
			System.out.println("Error - This file could not be found.");
		} finally {
			if (fileInputScan != null) {
				fileInputScan.close();
			}
		}
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
	
	public  static int h(String word) {
		String[] Str = null;
		int g=31;
		int size=Str.length;
		return word.length()+(26*firstletter(word))+g*(lastword(word))%size;
	}
	
	public static int firstletter(String word) {
		return word.charAt(0);
	}
	
	public  static int lastword(String word) {
		return word.charAt(word.length()-1);
	}

}
