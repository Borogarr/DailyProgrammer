public class LookAndSay {

	private String base = "1";

	public LookAndSay() {
	}

	public void run(int num) {
		String ret = "";
		
		if (num < 1) {
			System.out.println("Invalid input.");
			return;
		}
		
		if (num == 1) {
			System.out.println(base);
			return;
		}
		
		System.out.println(base);
		num--;

		run(num, base);
		return;
		
	}
	
	public void run(int num, String input) {
		String ret = "";
		int current = input.charAt(0) - 48;
		int numOfCurrent = 1;
		
		if (input.length() == 1) {
			ret = ret.concat("" + numOfCurrent + current);
			System.out.println(ret);
		}
		
		
		for (int i = 1; i < input.length(); i++) {
			if (current + 48 != input.charAt(i)) {
				
				ret = ret.concat("" + numOfCurrent + current);
				numOfCurrent = 0;
			}
			
			current = input.charAt(i) - 48;
			numOfCurrent++;
			
			if (i + 1 == input.length()) {
				ret = ret.concat("" + numOfCurrent + current);
				System.out.println(ret);
			}
		}
		
		num--;
		
		if (num == 0) {
			return;
		}
		
		run(num, ret);
		return;
	
	}
	
	public static void main (String args[]) {
		LookAndSay look = new LookAndSay();
		look.run(8);
	}

}