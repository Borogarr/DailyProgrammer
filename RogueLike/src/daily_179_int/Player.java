

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
		if (moves == 0) {
			System.out.println("Out of Moves!");
		}
		else {
			System.out.println("Moves remaining: " + moves);
		}
	}
	
	
}
