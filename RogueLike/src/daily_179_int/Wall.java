package daily_179_int;

public class Wall extends Space {
	

	public Wall() {
		value = '%';
	}
	
	public void printValue() {
		System.out.print(value);
	}
	
	public char getValue() {
		return value;
	}
}
