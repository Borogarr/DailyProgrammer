public class Board {
	private char[][] board = new char[20][20];
	private int score = 0;
	
	public Board() {
		
	}
	
	public void printBoard() {
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	
	public void addSpot(int row, int col, char value) {
		board[row][col] = value;
	}
	
	public char getSpot(int row, int col) {
		return board[row][col];
	}
	
	public int[] findPlayer() {
		int[] temp = new int[2];
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				if (board[i][j] == '@') {
					temp[0] = i;
					temp[1] = j;
					return temp;
				}
			}
		}
		temp[0] = 0;
		temp[1] = 0;
		return temp;
	}
	
	public void movePlayer(String move) {
		int[] newMove = new int[2];
		newMove = findMove(move);
		int[] temp = new int[2];
		temp = findPlayer();
		
		if (temp[0] == 1 && newMove[0] == -1 ) {
			System.out.println("Walking into a wall.");
			return;
		}
		else if (temp[0] == 18 && newMove[0] == 1 ) {
			System.out.println("Walking into a wall.");
			return;
		}
		else if (temp[1] == 1 && newMove[1] == -1 ) {
			System.out.println("Walking into a wall.");
			return;
		}
		else if (temp[1] == 18 && newMove[1] == 1 ) {
			System.out.println("Walking into a wall.");
			return;
		}
		
		if (board[temp[0] + newMove[0]][temp[1] + newMove[1]] == '$') {
			score++;;
		}
		
		addSpot(temp[0] + newMove[0], temp[1] + newMove[1], '@');
		addSpot(temp[0], temp[1], '-');
		
	}
	
	public static int[] findMove(String move) {
		int temp[] = new int[2];
		if (move.charAt(0) == 'W' || move.charAt(0) == 'w') {
			temp[0] = -1;
			temp[1] = 0;
			return temp;
		}
		else if (move.charAt(0) == 'A' || move.charAt(0) == 'a') {
			temp[0] = 0;
			temp[1] = -1;
			return temp;
		}
		else if (move.charAt(0) == 'S'|| move.charAt(0) == 's') {
			temp[0] = 1;
			temp[1] = 0;
			return temp;
		}
		else if (move.charAt(0) == 'D' || move.charAt(0) == 'd') {
			temp[0] = 0;
			temp[1] = 1;
			return temp;
		}
		return temp;
	}
	
	public void printScore() {
		System.out.println("Current Score: " + score);
	}
	
	
}
