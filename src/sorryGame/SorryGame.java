package sorryGame;

public class SorryGame {
    GameBoard board;
    Deck deck;
    Deck.Card currentCard;

    public SorryGame(){
        board = new GameBoard();
        deck = new Deck();
    }

    public boolean validateMove(String pieceID, int fromPosition, int toPosition, int fromPosition2, int toPosition2) {
        if (currentCard.getRank() == 7){
            return board.validateMove(currentCard.getRank(), pieceID, fromPosition, toPosition, fromPosition2, toPosition2);
        }
        else{ 
        	return board.validateMove(currentCard.getRank(), pieceID, fromPosition, toPosition, 0, 0);
        }
    }

    public static void main(String[] args){
        SorryGame game = new SorryGame();
        game.board.print();
		int card = game.deck.getCard().getRank();
		System.out.println(card);
		if (game.board.validateMove(7, "g1", 58, 62, 0, 0)){
            System.out.println("Move is Valid\n");
            game.board.makeMove(7, "g1", 58, 62);
		}
		else
            System.out.println("Move is Invalid\n");
		game.board.print();
	}
}
