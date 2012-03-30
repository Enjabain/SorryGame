package sorryGame;

/**
 * CS123 Program: sorryGame.GameBoard Programmer: Christopher Morse Date: 2/16/12
 */
public class GameBoard {

    private PlayableSquare[] SGGameArray;

    public PlayableSquare[] getGameArray() {
        return SGGameArray;
    }

    public void setSGGameArray(PlayableSquare[] SGGameArray) {
        this.SGGameArray = SGGameArray;
    }
}
