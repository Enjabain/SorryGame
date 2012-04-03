package sorryGame;

import java.io.Serializable;

/**
 * CS123 Program: sorryGame.GameBoard Programmer: Christopher Morse Date: 2/16/12
 */
@SuppressWarnings({"UnusedParameters", "UnnecessaryLocalVariable", "UnusedDeclaration"})
public class GameBoard implements Serializable {


    PlayableSquare[] gameArray, redHomeArray, greenHomeArray, blueHomeArray, yellowHomeArray, startArrays;
    private int currentCard;
    private Pawn[] pawns;

    public GameBoard(int currentCard) {
        setCurrentCard(currentCard);
        intializeGameArrays();
    }

    private void intializeGameArrays() {
        makeGameArray();
        makeHomeArrays();
        makeStartArray();
    }
    
    private void placePawns(){
        for (Pawn pawn:pawns){
            PlayableSquare[] currentArray = pawn.getCurrentArray();
            PlayableSquare position = currentArray[pawn.getPositionIndex()];
            if(position.isOccupied()) {position.removePawn(position.getPawn());}
            position.setOccupied(true);
            position.addPawn(pawn);
        }
    }
    
    public void setPawns(Pawn[] pawns){
        this.pawns = pawns;
    }
    
    public PlayableSquare[] getGameArray() {
        return gameArray;
    }

	public static Pawn[] getPawns(Player player) {
		return null;
	}

    private void makeStartArray() {
        startArrays = new PlayableSquare[4];
        for (int i = 0; i < 4; i++) {
            startArrays[i] = new PlayableSquare((SorryGame.COLORS[i] + "start"), false, null, SorryGame.COLORS[i], false, false);
        }

    }

    private void makeHomeArrays() {
        greenHomeArray = new PlayableSquare[7];
        redHomeArray = new PlayableSquare[7];
        blueHomeArray = new PlayableSquare[7];
        yellowHomeArray = new PlayableSquare[7];
        for (int i = 1; i < 7; i++) {
            greenHomeArray[i] = new PlayableSquare((SorryGame.COLORS[0] + Integer.toString(i)), false, null, SorryGame.COLORS[0], false, false);
        }
        for (int i = 1; i < 7; i++) {
            redHomeArray[i] = new PlayableSquare((SorryGame.COLORS[1] + Integer.toString(i)), false, null, SorryGame.COLORS[1], false, false);
        }
        for (int i = 1; i < 7; i++) {
            blueHomeArray[i] = new PlayableSquare((SorryGame.COLORS[2] + Integer.toString(i)), false, null, SorryGame.COLORS[2], false, false);
        }
        for (int i = 1; i < 7; i++) {
            yellowHomeArray[i] = new PlayableSquare((SorryGame.COLORS[3] + Integer.toString(i)), false, null, SorryGame.COLORS[3], false, false);
        }
        greenHomeArray[0] = null; redHomeArray[0] = null; blueHomeArray[0] = null; yellowHomeArray[0] = null;
    }

    private void makeGameArray() {
        gameArray = new PlayableSquare[61];
        Integer temp = 1;
        String currentColor;
        for (int i = 0; i < 4; i++) {
            currentColor = SorryGame.COLORS[i];
            for (int j = 1; j < 16; j++) {
                if (j == 2) {gameArray[temp] = new PlayableSquare(Integer.toString(temp), true, (temp + 3), currentColor, false, false);}
                else if (j == 3) {gameArray[temp] = new PlayableSquare(Integer.toString(temp), false, 0, currentColor,  false, true);}
                else if (j == 5) {gameArray[temp] = new PlayableSquare(Integer.toString(temp), false, 0, currentColor,  true, false);}
                else if (j == 10) {gameArray[temp] = new PlayableSquare(Integer.toString(temp), true, (temp + 4), currentColor,  false, false);}
                else {gameArray[temp] = new PlayableSquare(Integer.toString(temp), false, 0, currentColor, false, false);}
                temp++;
            }
        }
        gameArray[0] = null;
    }

    public PlayableSquare[] getRedHomeArray() {
        return redHomeArray;
    }

    public PlayableSquare[] getGreenHomeArray() {
        return greenHomeArray;
    }

    public PlayableSquare[] getBlueHomeArray() {
        return blueHomeArray;
    }

    public PlayableSquare[] getYellowHomeArray() {
        return yellowHomeArray;
    }

    public PlayableSquare[] getStartArrays() {
        return startArrays;
    }
    
    private boolean validateSorry(String pieceID, String fromPosition, String toPosition){
            boolean valid = false;
            return valid;
    }
    
    private boolean validateStandardMove(String pieceID, String fromPosition, String toPosition){
            boolean valid = false;
            return valid;
    }
    
    private boolean validateOneTwo(String pieceID, String fromPosition, String toPosition){
            boolean valid = false;
            if (fromPosition.charAt(1) == 's'){}
            return valid;
    }

    private boolean validateFour(String pieceID, String fromPosition, String toPosition){
            boolean valid = false;
            return valid;
    }

    private boolean validateSeven(String pieceID, String fromPosition, String toPosition){
            boolean valid = false;
            return valid;
    }

    private boolean validateTen(String pieceID, String fromPosition, String toPosition){
            boolean valid = false;
            return valid;
    }

    private boolean validateEleven(String pieceID, String fromPosition, String toPosition){
            boolean valid = false;
            return valid;
    }

    public void setCurrentCard(int currentCard){
        this.currentCard = currentCard;
    }
    
    public boolean validateMove(String pieceID, String fromPosition, String toPosition){
        boolean valid = false;
        if (currentCard == 0) {
            valid = validateSorry(pieceID, fromPosition, toPosition);
        }
        else if (currentCard == 3 || currentCard == 5 || currentCard == 8 || currentCard == 12) { valid = validateStandardMove(pieceID, fromPosition, toPosition);
        }
        else if (currentCard == 1 || currentCard == 2) {
            valid = validateOneTwo(pieceID, toPosition, fromPosition);
        }
        else if (currentCard == 4) {
            valid = validateFour(pieceID, fromPosition, toPosition);
        }
        else if (currentCard == 7) {
            valid = validateSeven(pieceID, fromPosition, toPosition);
        }
        else if (currentCard == 10) {
            valid = validateTen(pieceID, fromPosition, toPosition);
        }    
        else if (currentCard == 11){
            valid = validateEleven(pieceID, fromPosition, toPosition);
        }
    
        return valid;
    }

    public static void main(String[] args) {
        PlayableSquare[] testGame = (new GameBoard(4)).gameArray;
        for (int i = 1; i < testGame.length; i++) {
            System.out.println(testGame[i].toString());
            if( i % 15 == 0){System.out.println();}
        }
        PlayableSquare[] greenArray = (new GameBoard(4)).greenHomeArray;
        for (int i = 1; i < greenArray.length; i++) {
            System.out.println(greenArray[i].toString());
        }
    }
    //    public PlayableSquare[][] getCombinedArrays() {
//        PlayableSquare[][] combinedArrays = {gameArray, greenHomeArray, redHomeArray, blueHomeArray, yellowHomeArray,
//                                             startArrays};
//        return combinedArrays;
//    }
}
