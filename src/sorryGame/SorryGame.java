package sorryGame;

public class SorryGame {
	public static void main(String[] args){
		GameBoard game = new GameBoard();
		Deck deck = new Deck();
		game.print();
		int card = deck.getCard().getRank();
		System.out.println(card);
		if (game.validateMove(card, "g1", 57, 2, 1, 60)){
            System.out.println("Move is Valid\n");
            game.makeMove(card, "g1", 57, 2, 1, 60);
		}
		else
            System.out.println("Move is Invalid\n");
		game.print();
	}
}
