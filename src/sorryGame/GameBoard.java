package sorryGame;

import java.io.Serializable;

/**
 * CS123 Program: sorryGame.GameBoard Programmer: Christopher Morse Date: 2/16/12
 */
public class GameBoard implements Serializable {

    private PlayableSquare[] SGGameArray;

    public PlayableSquare[] getGameArray() {
        return SGGameArray;
    }

    public void setSGGameArray(PlayableSquare[] SGGameArray) {
        this.SGGameArray = SGGameArray;
    }

	public static Pawn[] getPawns(Player player) {
		return null;
	}
}
