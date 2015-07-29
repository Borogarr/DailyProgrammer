import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;
import java.lang.StringBuilder;

public class DeColumnizing {
	private File file;
	private ArrayList<String> words;
	
	public DeColumnizing(File file) {
		this.file = file;
	}
	
	public void run() {
		words = new ArrayList<String>();
		setupWords();
		
		removeHyphens();
		
		print();
	}
	
	public void setupWords() {
		try {
			Scanner scanner = new Scanner(new FileReader(file));
			int numLines = scanner.nextInt();
			
			while (scanner.hasNext()) {
				
				String next = scanner.next();
				if (next.charAt(0) >= 65 && next.charAt(0) != 124) {
					
					words.add(next);
					
					
				}
				else if (next.charAt(0) == 124) {
					next = scanner.next();
					while (next.charAt(0) != 124) {
						next = scanner.next();
					}
				}
					
			}
			scanner.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void removeHyphens() {
		for (int i = 0; i < words.size(); i++) {
			if (words.get(i).contains("-")) {
				String wordd = words.get(i);
				int length = wordd.length();
				if (wordd.charAt(length - 1) == 45) {
					String replaced = wordd.replace("-","");
					words.add(i, replaced);
					words.remove(i+1);
					String finalString = words.get(i) + words.get(i+1);
					words.remove(i);
					words.remove(i);
					words.add(i, finalString);
					
					
					
				}
				
			}
		}
	}
	
	public void print() {
		for (int i = 0; i < words.size(); i++) {
			System.out.print(words.get(i) + " ");
		}
	}
	
	public static void main(String args[]) {
	
		File file = new File("input.txt");
		DeColumnizing dc = new DeColumnizing(file);
		dc.run();
	
	}





}