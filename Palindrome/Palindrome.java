import java.util.HashMap;
import java.lang.Integer;
import java.lang.Character;
import java.util.ArrayList;

public class Palindrome {

	public Palindrome() {
	
	}

	public void run(String input) {
		HashMap<Character, Integer> occurence = new HashMap<Character, Integer>();
		ArrayList<Character> characters = new ArrayList<Character>();
		int maxOdd = 0;
		
		for (int i = 0; i < input.length(); i++) {
			
			if (!occurence.containsKey((Character)input.charAt(i))) {
				occurence.put( (Character)input.charAt(i), (Integer) 1);
			}
			else {
				int numOccur = occurence.get((Character)input.charAt(i));
				numOccur++;
				occurence.put((Character)input.charAt(i), (Integer) numOccur);
			}
			
			if (!characters.contains((Character)input.charAt(i))) {
				characters.add((Character)input.charAt(i));
			}
			
			
		}
		
		for (int i = 0; i < input.length(); i++) {
		
			if (i >= characters.size()) {
			
			}
			else {
			
				int occurCheck = occurence.get(characters.get(i));
				
				if (occurCheck % 2 != 0) {
					maxOdd++;
				}
				
				if (maxOdd > 1) {
					System.out.println("False.");
					return;
				}
			}
		}
			
			System.out.println("True.");
			
		
		
		
		
	}
	
	public static void main (String args[]) {
		Palindrome pal = new Palindrome();
		
		pal.run("cccaattb");
	}

}