import java.util.Arrays;
public class BackTracking {

	private int num = 0;
	private int[] numArray;
	
	
	public BackTracking(int num) {
		this.num = num;
		numArray = new int[2*num];
		
		numArray[0] = num;
		
		for (int i = 1; i < 2*num; i++) {
			if (i == num+1) {
				numArray[i] = num;
			}
			else {
			numArray[i] = 1;
			}
		}
	}
	
	public boolean checkNumOfDigits() {
		
		int[] temp = new int[num*2];
		System.arraycopy(numArray, 0, temp, 0, numArray.length);
		
		Arrays.sort(temp);
		
		for (int i = 0; i < 2*num; i = i + 2) {
			if (temp[i] != temp[i+1]) {
				return false;
			}
			
			if (i != 2*num -2) {
				if (temp[i+1] == temp[i+2]) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public void print() {
		for (int i = 0; i < numArray.length; i++) {
			System.out.print(numArray[i]);
		}
		
		System.out.println();
	}
	
	public boolean run() {
	
		if (num < 3) {
			return false;
		}
	
		int sum = 0;
		boolean ret = false;
		boolean breakOut = false;
		boolean incrementSuccess = true;
		
		while (ret != true) {
			sum = 0;
			breakOut = false;
			print();
			if (checkNumOfDigits()) {
				for (int i = 1; i <= num; i++) {
					for (int j = 0; j < 2*num; j++) {
						if (numArray[j] == i  && j < 2*num - i - 1) {
							if (numArray[j] == numArray[j+i+1]) {
								sum++;
								break;
							}
							else {
								breakOut = true;
							}
						}
						
						if (breakOut == true) {
							break;
						}
					}
				}
			}
			
			if (sum == num) {
				ret = true;
				break;
			}
			
			increment(num*2-1);
			
			if (numArray[0] == 1) {
				return false;
			}
			
		}
		
		return ret;
		
		
	}
	
	public void increment(int index) {
	
		if (index == -1) {
			return;
		}
	
		if (numArray[index] == num) {
			numArray[index] = 1;
			increment(index - 1);
		}
		else {
			numArray[index]++;
		}
		
		
	}
	
	public static void main(String[] args) {
		BackTracking back = new BackTracking(8);
		boolean x = back.run();
		System.out.println(x);
		back.print();
	}
	
}