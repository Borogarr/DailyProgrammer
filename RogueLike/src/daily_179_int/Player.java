package daily_179_int;

public class Player extends Space {
	private int moves = 100;
	
	public Player() {
		value = '@';
	}
	
	public void printValue() {
		System.out.print(value);
	}
	
	public char getValue() {
		return value;
	}
	
	public int getMoves() {
		return moves;
	}
	
	public void setMoves(int moves) {
		this.moves = moves;
	}
	
	public void moved() {
		moves--;
	}
	
	
}
