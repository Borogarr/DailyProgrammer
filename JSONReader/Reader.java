import java.util.Scanner;
import java.io.File;

public class Reader {

	public Reader() {
	
	}

	public static void main(String[] args) {
		
		try {
			File file = new File("Arthas.json");
			Scanner scanner = new Scanner(file);
			String in = "";
			in = scanner.next();
			in = scanner.next();
			System.out.println(in);
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}





}