/**
 * CS 110 Program: GameHelper Programmer: Christopher Morse Date: 3/21/12
 */

import net.sf.json.JSONObject;

public class GameHelper {
  
    private SorryGame game;

    public GameHelper(){
        playerWillMove();
        JSONObject json = new JSONObject();
        //String[] colors = {"gpiece", "red", "yellow", "blue"};
        //Character[] colorIndicators = {'g', 'r', 'y', 'b'};
        boolean isValid = game.validateMove();
        json.put("MoveValid", isValid);
        if (isValid){
            PlayableSquare[] gameArray = game.gameBoard.getGameArray();
            for (PlayableSquare square : gameArray) {
                if (square.isOccupied()) {
                    json.put(square.getPlayerPieceID(), square.getIndex());
                }
            }
        }

    }
    public void playerWillMove(){

    }

    public SorryGame getGame() {
        return game;
    }

    public void setGame(SorryGame game) {
        this.game = game;
    }

    public static void main(String[] args) {
        GameHelper testHelper = new GameHelper();
        testHelper.setGame(new SorryGame());

    }


}
