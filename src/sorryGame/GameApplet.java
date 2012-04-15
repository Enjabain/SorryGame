package sorryGame; /**
 * CS 110 Program: sorryGame.GameApplet Programmer: Christopher Morse Date: 3/21/12
 */

import netscape.javascript.JSException;
import netscape.javascript.JSObject;

import java.applet.Applet;
import java.util.List;

public class GameApplet extends Applet {

    public SorryGame game = new SorryGame();
    private JSObject window;


//    public void init() {
//        game = new SorryGame();
//    }

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
    public boolean validateMove(String pieceID, String fromPosition, String toPosition) throws Exception {
        if(fromPosition.equals("greenstart") || fromPosition.equals("redstart") || fromPosition.equals("bluestart") || fromPosition.equals("yellowstart"))
            fromPosition = "-1";
        System.out.printf("Before Validate: pieceID: %s, fromPosition: %d, toPosition: %d%n", pieceID, Integer.parseInt(fromPosition),
                          Integer.parseInt(toPosition));
        boolean isValid = game.validateMove(pieceID, Integer.parseInt(fromPosition), Integer.parseInt(toPosition), 0, 0);
        if (isValid) {
            updatePositions(game.board.getGameArray(), "game");
            updatePositions(game.board.getGreenHomeArray(), "g");
            updatePositions(game.board.getRedHomeArray(), "r");
            updatePositions(game.board.getBlueHomeArray(), "b");
            updatePositions(game.board.getYellowHomeArray(), "y");
            updatePositions(game.board.getStartArrays(), "start");
        }
        return isValid;
    }

    /**
     * Updates all of the positions on the board using the state information contained in the 'gameArray'.
     * @return  updateComplete  True if update is successful; False otherwise.
     */
    @SuppressWarnings("UnusedDeclaration")
    public boolean updatePositions(PlayableSquare[] array, String filingName) throws Exception {
        boolean updateComplete = false;
        String pieceID, toIndex;
        System.out.println("After Validate:");
        for (sorryGame.PlayableSquare square : array) {
            if (square.isOccupied()) {
                if (square.getType().equals("start") || square.getType().equals("home")) {
                    List<String> idList = square.getPlayerIDList();
                    for (String s : idList) {
                        pieceID = s;
                        toIndex = square.getPositionID();
                        System.out.printf("pieceID: %s, finalPosition: %s%n", pieceID, toIndex);
//                        window.call("movePiece", new Object[]{pieceID, toIndex});
                    }
                }
                else{
                    pieceID = square.getPlayerPieceID();
                    toIndex = square.getPositionID();
                    System.out.printf("pieceID: %s, finalPosition: %s%n", pieceID, toIndex);
                    //                    window.call("movePiece", new Object[]{pieceID, toIndex});
                }
            }
        }
//        Serializer.serializeArray((filingName + "array"), array);
        return updateComplete;
    }

    /**
     * Returns next String value of next card in the deck.
     *
     */
    @SuppressWarnings("UnusedDeclaration")
    public int drawCard(){
        return game.drawCard();
    }

    /**
     * Internal class for Serializing/Deserializing serializable game state objects, namely 'gameArray'.
     */
    //@SuppressWarnings("UnusedDeclaration")
//    public static class Serializer {
//
//        /**
//         * Serializes an array of object that implement Serializable.
//         * @param outFile       Name of the file the object will be serialized and saved to.
//         * @param gameObject    Array of objects of class that implements Serializable.
//         * @throws Exception
//         */
//        public static void serializeArray(String outFile, Serializable[] gameObject) throws Exception {
//            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(outFile));
//            out.writeObject(gameObject);
//            out.flush();
//            out.close();
//        }
//
//        /**
//         * Deserializes a serialized object stored in file.
//         * @param inFile        Name of file containing the serialized object.
//         * @param gameObject    Object of class implementing serilizable that the object will be deserialized into.
//         * @throws IOException
//         * @throws ClassNotFoundException
//         */
//        public static void deserializeArray(String inFile, Serializable[] gameObject) throws IOException, ClassNotFoundException {
//            ObjectInputStream in = new ObjectInputStream(new FileInputStream(inFile));
//            gameObject = (Serializable[]) in.readObject();
//            in.close();
//
//            //Print out contents of deserialized int[]
//            System.out.print("Deserialized array: " + gameObject[0]);
//            for (int i=1; i<gameObject.length; i++) {
//                System.out.print(", " + gameObject[i]);
//            }
//            System.out.println();
//            }
//    }
// GameApplet

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
}