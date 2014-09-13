package daily_179_int;

public class Board {
	private char[][] board = new char[20][20];
	
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
	
	public void movePlayer(int newRow, int newCol) {
		int[] temp = new int[2];
		temp = findPlayer();
		addSpot(newRow, newCol, '@');
		addSpot(temp[0], temp[1], '-');
		
	}
}
