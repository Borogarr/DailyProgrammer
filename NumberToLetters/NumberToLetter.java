import java.lang.Integer;
public class NumberToLetter {

	private String[] singles = new String[] {"Zero ","One ","Two ","Three ","Four ","Five ","Six ","Seven ","Eight ","Nine "};
	private String[] teens = new String[] {"","Eleven ","Twelve ","Thirteen ","Fourteen ","Fifteen ","Sixteen ","Seventeen ","Eighteen ","Nineteen "};
	private String[] tens = new String[] {"","Ten ","Twenty ","Thirty ","Forty ","Fifty ","Sixty ","Seventy ","Eighty ","Ninety "};
	
	public NumberToLetter() {
	
	
	}
	
	public void run(int input) {
		System.out.println(input);
		
		String inputString = Integer.toString(input);
		int length = inputString.length();
		int[] inputArray = new int[length];
		
		for (int i = 0; i < length; i++) {
			inputArray[i] = inputString.charAt(i) - 48; // ASCII offset
		}
		
		while (length > 0) {
		
			if (length % 3 == 1 || length % 3 == 0) {
				if (length != 1 && inputArray[inputString.length() - length] == 0) {
					length--;
				}
				else {
				System.out.print(singles[inputArray[inputString.length() - length]]);
				printPlace(length);
				length--;
				}
				
			
			}
			else if (length % 3 == 2) {
			
				if (inputArray[inputString.length() - length] == 0 && inputArray[inputString.length() - length + 1] == 0) {
					if (inputArray[inputString.length() - length - 1] != 0) {
						printPlace(length);
					}
					length = length - 2;
				}
				
				else if (inputArray[inputString.length() - length] == 1 && inputArray[inputString.length() - length + 1] != 0) {
					System.out.print(teens[inputArray[inputString.length() - length + 1]]);
					printPlace(length);
					length = length - 2;
				
				}
				else {
					System.out.print(tens[inputArray[inputString.length() - length]]);
					if (inputArray[inputString.length() - length + 1] == 0) {
					}
					else {
						System.out.print(singles[inputArray[inputString.length() - length + 1]]);
					}
					printPlace(length);
					length = length - 2;
				}
			}
		
		}
		
		
	}
	
	private void printPlace(int current) {
		switch (current) {
			case 1: System.out.print("");
				break;
			case 2: System.out.print("");
				break;
			case 3: System.out.print("Hundred ");
				break;
			case 4: System.out.print("Thousand ");
				break;
			case 5: System.out.print("Thousand ");
				break;
			case 6: System.out.print("Hundred ");
				break;
			case 7: System.out.print("Million ");
				break;
			case 8: System.out.print("Million ");
				break;
			case 9: System.out.print("Hundred ");
				break;
			default: System.out.print("Dafuq bro get rekt m8");
				break;
		}
	
	
	
	}
	
	public static void main(String[] args) {
	
		NumberToLetter num = new NumberToLetter();
		num.run(540000102);
	
	}
	
	
	
}



