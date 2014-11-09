import java.util.Scanner;
import java.util.Random;

public class Game {
	private Board board = new Board();
	private Player player = new Player();
	private Wall wall = new Wall();
	private Coin coin = new Coin();
	private Empty empty = new Empty();
	
	public Game() {
		
	}
	
	public void print() {
		board.printBoard();
	}
	
	public void init() {
		Random random = new Random();
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
			int randomNum = random.nextInt((2 - 0) + 2 + 0);
				if (i == 9 && j == 9) {
					board.addSpot(i,j,'@');
				}
				else if (i == 0 || j == 0 || j == 19 || i == 19) {
					board.addSpot(i, j, '%');
				}
				else {
					if (randomNum == 0) {
						board.addSpot(i, j, '$');
					}
					else {
						board.addSpot(i,j, '-');
					}
				}
			}
		}
		board.printBoard();
	}
	
	public void makeMove(Scanner scanner) {
		String move;
		try {
			System.out.println("Please make a move using WASD.");
			move = scanner.next();
			if (move.length() == 1 && move.charAt(0) == 'W' || move.charAt(0) == 'A' || move.charAt(0) == 'S' || move.charAt(0) == 'D' || move.charAt(0) == 'w' || move.charAt(0) == 'a' || move.charAt(0) == 's' || move.charAt(0) == 'd') {
				board.movePlayer(move);
			}
			else {
			System.out.println("Please make a valid move.");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Game game = new Game();
		game.init();
		boolean x = true;
		
		while (x) {
			game.makeMove(scanner);
			game.print();
			game.player.moved();
			game.board.printScore();
			
			if (game.player.getMoves() == 0) {
				x = false;
			}
		}
		
		
		scanner.close();
	}
}
