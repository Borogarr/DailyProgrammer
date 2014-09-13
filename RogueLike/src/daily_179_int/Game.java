package daily_179_int;

public class Game {
	private Board board = new Board();
	private Player player = new Player();
	private Wall wall = new Wall();
	private Coin coin = new Coin();
	private Empty empty = new Empty();
	
	public Game() {
		
	}
	
	public void init() {
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				if (i == 9 && j == 9) {
					board.addSpot(i,j,'@');
				}
				else if (i == 0 || j == 0 || j == 19 || i == 19) {
					board.addSpot(i, j, '%');
				}
				else {
					board.addSpot(i, j, '-');
				}
			}
		}
		board.printBoard();
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.init();
	}
}
