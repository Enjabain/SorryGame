package sorryGame;

import java.io.Serializable;

/**
* CS Program: sorryGame.PlayableSquare Programmer: Christopher Morse Date: 3/23/12
*/
class PlayableSquare implements Serializable {

    private String playerPieceID;
    private boolean occupied;
    private int index;
    private String positionID;
    private boolean slideStart;
    private Integer slideEnd;
    private String slideColor;
    private final boolean startingPosition;
    private final boolean finishPosition;

    PlayableSquare(String positionID, boolean slideStart, Integer slideEnd, String color, boolean startingPosition, boolean finishPosition) {
        this.slideColor = color;
        this.startingPosition = startingPosition;
        this.finishPosition = finishPosition;
        this.occupied = false;
        this.positionID = positionID;
        this.slideStart = slideStart;
        this.slideEnd = slideEnd;
    }

    @Override public String toString() {
        String str = String.format("Position ID: %s, Currently Occupied: %s, Occupying Piece ID: %s, Is Slide Start: %s, Slide End index: %d, Slide Color: %s, Start: %s, Finish: %s", positionID, occupied, playerPieceID, slideStart, slideEnd, slideColor, startingPosition, finishPosition);

        return str;
    }

    public void setPlayerPieceID(String playerPieceID) {
        this.playerPieceID = playerPieceID;
    }

    public String getPlayerPieceID() {
        return playerPieceID;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public String getPositionID() {
        return positionID;
    }

    public boolean isSlideStart() {
        return slideStart;
    }

    public Integer getSlideEnd() {
        return slideEnd;
    }

    public String getSlideColor() {
        return slideColor;
    }

    public boolean isStartingPosition() {
        return startingPosition;
    }

    public boolean isFinishPosition() {
        return finishPosition;
    }
}
