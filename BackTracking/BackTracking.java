public class BackTracking {

	private int num = 0;
	private int[] numArray;
	
	public BackTracking(int num) {
		this.num = num;
		numArray = new numArray[2 * num];
		
		int i = 0;
		
		for (int i = 0; i < num; i++) {
			numArray[i] = i + 1;
		}
		
		for (int i = num; i < 2 * num; i++) {
			numArray[i] = i - num + 1;
		}
	}
	
	public int[] solve() {
		
	}

}