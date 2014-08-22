//Parse 8x8 bit map images from the console - /r/dailyprogrammer #171
import java.util.Scanner;
import java.util.Arrays;
public class bitmap {

	public static void main(String[] args) {
		String[] inputArray = new String[8];
		String input = "";
		String print = "";
		Scanner scanner = new Scanner(System.in);
		try {
			while (true) {
				System.out.println("Please input the Hex values.");
				input = scanner.nextLine();
				inputArray = input.split(" ");
				for (int i = 0; i < inputArray.length; i++) {
					print = Integer.toBinaryString(Integer.parseInt(inputArray[i], 16));
					print = pad(print);
					for (int j = 0; j < 8; j++) {
						if (print.charAt(j) == '1') {
							System.out.print("*");
						}
						else {
							System.out.print(" ");
						}
					}
					System.out.println();
				}
			}
		}
		catch(Exception e) {
			
		}
		scanner.close();
	}
	
	public static String pad(String string) {
		int length = string.length();
		length = 8 - length;
		while (length != 0) {
			string = "0" + string;
			length--;
		}
		return string;
	}

}
