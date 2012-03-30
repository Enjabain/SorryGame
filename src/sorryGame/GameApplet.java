package sorryGame; /**
 * CS 110 Program: sorryGame.GameApplet Programmer: Christopher Morse Date: 3/21/12
 */

import netscape.javascript.JSException;
import netscape.javascript.JSObject;

import java.applet.Applet;

public class GameApplet extends Applet {

    private SorryGame game = new SorryGame();
    private JSObject window;

    public void start() {
        try {
            this.window = JSObject.getWindow(this);
        }
        catch (JSException jse) {jse.printStackTrace();}
    }

    /**
     *
     * @param pieceID   DOM 'id' of the piece being moved. Passed from javascript.
     * @param fromPosition    DOM 'id' of the position the piece passed in pieceID currently occupies.
     * @param toPosition      DOM 'id' of the position the player wishes to move the piece passed in pieceID.
     * @return isValid  True if the move was valid and completed successfully; False if the move was invalid or there
     *                  was an error.
     */
    @SuppressWarnings("UnusedDeclaration")
    public boolean validateMove(String pieceID, String fromPosition, String toPosition) {
        boolean isValid = game.validateMove(pieceID, fromPosition, toPosition);
        if (isValid) {
            sorryGame.PlayableSquare[] gameArray = game.gameBoard.getGameArray();
            for (sorryGame.PlayableSquare square : gameArray) {
                if (square.isOccupied()) {
                    pieceID = square.getPlayerPieceID();
                    window.call("movePiece", new Object[]{pieceID, toPosition});
                }
            }
        }
        return isValid;
    }

    /**
     * Updates all of the positions on the board using the state information contained in the 'gameArray'.
     * @return  updateComplete  True if update is successful; False otherwise.
     */
    @SuppressWarnings("UnusedDeclaration")
    public boolean updatePositions() {
        boolean updateComplete = false;
        sorryGame.PlayableSquare[] gameArray = game.gameBoard.getGameArray();
        for (sorryGame.PlayableSquare square : gameArray) {
            if (square.isOccupied()) {
                String pieceID = square.getPlayerPieceID();
                String toIndex = square.getPositionID();
                window.call("movePiece", new Object[]{pieceID, toIndex});
            }
        }
        return updateComplete;
    }
}// GameApplet

/**
 * Test functions for analyzing communication between javascript, applet and Java class back-end.
 */
//    public void updatePositions(String pieceID, String toPosition){
//         window.call("movePiece", new Object[]{pieceID, toPosition});
//        Integer[] gameArray = {10,35,20,53};
//        for (int i = 1; i <= 4; i++) {
//            String str = Integer.toString(gameArray[i-1]);
//            window.call("movePiece", new Object[]{("bpiece" + i), str});
//            str = Integer.toString((gameArray[i-1] + 5));
//            window.call("movePiece", new Object[]{("rpiece" + i), str});
//        }
//    }
//
//
//    public SorryGame getGame() {
//        return game;
//    }
//
//    public String getTestString(){
//        return "The test works";
//    }
//
//    public static void main(String[] args) {
//        GameApplet testApplet = new GameApplet();
//        testApplet.setGame(new SorryGame());
//    }