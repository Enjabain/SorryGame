/**
 * CS Program: GameArray Programmer: Christopher Morse Date: 3/23/12
 */
public class GameArray {
    private PlayableSquare[] gameArray, redHomeArray, greenHomeArray, blueHomeArray, yellowHomeArray, startArrays;

    public GameArray() {
        intializeGameArrays();
    }

    private void intializeGameArrays() {
        gameArray = new PlayableSquare[60];
        redHomeArray = new PlayableSquare[6];
        greenHomeArray = new PlayableSquare[6];
        blueHomeArray = new PlayableSquare[6];
        yellowHomeArray = new PlayableSquare[6];
        startArrays = new PlayableSquare[4];
    }

    public PlayableSquare[] getGameArray() {
        return gameArray;
    }

}
