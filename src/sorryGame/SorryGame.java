package sorryGame;

/**
 * CS Program: sorryGame.SorryGame Programmer: Christopher Morse Date: 3/23/12
 */
@SuppressWarnings("FieldCanBeLocal")
public class SorryGame {
    static final String[] COLORS =  {"g", "r", "b", "y"};
    GameBoard gameBoard;
    private Deck deck;
    private Pawn[] pawns;
    
    public SorryGame(boolean savedGame){
        if(savedGame){restoreGame();}
        else {initGame();}
    }

    public boolean validateMove(String pieceID, String fromPosition, String toPosition) {
//        return gameBoard.validateMove(pieceID, fromPosition, toPosition);
        return true;
    }
    
    public int drawCard(){
        Deck.Card card = deck.getCard();
        gameBoard.setCurrentCard(card.getRank());
        return card.getRank();
    }
    
    private void initGame(){
        deck = new Deck();
        gameBoard = new GameBoard(deck.getCard().getRank());
        pawns = new Pawn[16];
        PlayableSquare[] currentArray = gameBoard.startArrays;
        int count = 0;
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                 pawns[count] = new Pawn(i, currentArray, (COLORS[i] + "start"), (COLORS[i] + "piece" + Integer.toString(j + 1)), COLORS[i]);
            }
        }
        gameBoard.setPawns(pawns);
    }
    
    private void restoreGame(){
        
    }
}