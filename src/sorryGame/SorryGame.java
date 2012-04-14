package sorryGame;

public class SorryGame {
    static final String[] COLORS =  {"g", "r", "b", "y"};

    GameBoard board;
    Deck deck;
    Deck.Card currentCard;
    Pawn[] pawns;

    public SorryGame(){
//        board = new GameBoard();
//        deck = new Deck();
        initGame();
    }

    public int drawCard(){
        currentCard = deck.getCard();
        return currentCard.getRank();
    }

    public boolean validateMove(String pieceID, int fromPosition, int toPosition, int fromPosition2, int toPosition2) {
        boolean valid = false;
        if (currentCard.getRank() == 7){
             if(board.validateMove(currentCard.getRank(), pieceID, fromPosition, toPosition, fromPosition2, toPosition2)){
                 board.makeMove(currentCard.getRank(), pieceID, fromPosition, toPosition);
                 valid = true;
             }
        }
        else{ 
        	if (board.validateMove(currentCard.getRank(), pieceID, fromPosition, toPosition, 0, 0)){
                board.makeMove(currentCard.getRank(), pieceID, fromPosition, toPosition);
                valid = true;
            }
        }
        return valid;
    }

    private void initGame(){
        deck = new Deck();
        board = new GameBoard();
    }

//    public static void main(String[] args){
//        SorryGame game = new SorryGame();
//                game.board.print();
//        		int card = game.deck.getCard().getRank();
//        		System.out.println(card);
//        		if (game.board.validateMove(7, "g1", 58, 62, 0, 0)){
//                    System.out.println("Move is Valid\n");
//        //            game.board.makeMove(7, "g1", 58, 62, 0, 0);
//        		}
//        		else
//                    System.out.println("Move is Invalid\n");
//        		game.board.print();
//        }
}
