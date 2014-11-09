

public class Coin extends Space {
	private int pointValue = 1;
	
	public Coin() {
		value = '$';
	}
	
	public void printValue() {
		System.out.print(value);
	}
	
	public char getValue() {
		return value;
	}
	
	public int getPointValue() {
		return pointValue;
	}
}
