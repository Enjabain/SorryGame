package sorryGame;

public class SorryGame {
    GameBoard board;
    Deck deck;
    Deck.Card currentCard;

    public SorryGame(){
        GameBoard board = new GameBoard();
        Deck deck = new Deck();

    }

    public boolean validateMove(String pieceID, int fromPosition, int toPosition, int fromPosition2, int toPosition2) {
        if (currentCard.getRank() == 7){
            return board.validateMove(currentCard.getRank(), pieceID, fromPosition, toPosition, fromPosition2, toPosition2);
        }
        else{ return board.validateMove(currentCard.getRank(), pieceID, fromPosition, toPosition, 0, 0);}

    }

    public static void main(String[] args){
		//GameBoard game = new GameBoard();
        SorryGame game = new SorryGame();
		//GameBoard board = game.board;
        board.print();
		int card = game.deck.getCard().getRank();
		System.out.println(card);
		if (game.board.validateMove(4, "g1", 64, 65, 0, 0)){
            System.out.println("Move is Valid\n");
            game.board.makeMove(4, "g1", 64, 65, 0, 0);
		}
		else
            System.out.println("Move is Invalid\n");
		game.board.print();
	}
}
