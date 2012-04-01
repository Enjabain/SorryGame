package sorryGame;

import java.io.Serializable;

/**
 * CS123 Program: sorryGame.GameBoard Programmer: Christopher Morse Date: 2/16/12
 */
@SuppressWarnings("UnusedParameters")
public class GameBoard implements Serializable {

    private final String[] COLORS =  {"g", "r", "b", "y"};
    private PlayableSquare[] gameArray, redHomeArray, greenHomeArray, blueHomeArray, yellowHomeArray, startArrays;

    public GameBoard() {
        intializeGameArrays();
    }

    private void intializeGameArrays() {
        makeGameArray();
        makeHomeArrays();
        makeStartArray();
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
            startArrays[0] = new PlayableSquare((COLORS[i] + "start"), false, null, COLORS[i], false, false);
        }

    }

    private void makeHomeArrays() {
        greenHomeArray = new PlayableSquare[7];
        redHomeArray = new PlayableSquare[7];
        blueHomeArray = new PlayableSquare[7];
        yellowHomeArray = new PlayableSquare[7];
        for (int i = 1; i < 7; i++) {
            greenHomeArray[i] = new PlayableSquare((COLORS[0] + Integer.toString(i)), false, null, COLORS[0], false, false);
        }
        for (int i = 1; i < 7; i++) {
            redHomeArray[i] = new PlayableSquare((COLORS[1] + Integer.toString(i)), false, null, COLORS[1], false, false);
        }
        for (int i = 1; i < 7; i++) {
            blueHomeArray[i] = new PlayableSquare((COLORS[2] + Integer.toString(i)), false, null, COLORS[2], false, false);
        }
        for (int i = 1; i < 7; i++) {
            yellowHomeArray[i] = new PlayableSquare((COLORS[3] + Integer.toString(i)), false, null, COLORS[3], false, false);
        }
        greenHomeArray[0] = null; redHomeArray[0] = null; blueHomeArray[0] = null; yellowHomeArray[0] = null;
    }

    private void makeGameArray() {
        gameArray = new PlayableSquare[61];
        Integer temp = 1;
        String currentColor;
        for (int i = 0; i < 4; i++) {
            currentColor = COLORS[i];
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

    public static void main(String[] args) {
        PlayableSquare[] testGame = (new GameBoard()).gameArray;
        for (int i = 1; i < testGame.length; i++) {
            System.out.println(testGame[i].toString());
            if( i % 15 == 0){System.out.println();}
        }
        PlayableSquare[] greenArray = (new GameBoard()).greenHomeArray;
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
