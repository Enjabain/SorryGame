package sorryGame;

import java.io.Serializable;

/**
* CS Program: sorryGame.PlayableSquare Programmer: Christopher Morse Date: 3/23/12
*/
@SuppressWarnings("UnusedDeclaration")
class PlayableSquare implements Serializable {

    private String positionID;
    private String playerPieceID;
    private String slideColor;
    private Pawn[] pawn;
    private boolean slideStart;
    private boolean occupied;
    private boolean startingPosition;
    private boolean finishPosition;
    private int index = 0;
    private int slideEnd;

    PlayableSquare(String positionID, boolean slideStart, Integer slideEnd, String color, boolean startingPosition, boolean finishPosition) {
        this.slideColor = color;
        this.startingPosition = startingPosition;
        this.finishPosition = finishPosition;
        this.occupied = false;
        this.positionID = positionID;
        this.slideStart = slideStart;
        this.slideEnd = slideEnd;
    }

    @Override
    public String toString() {
        return String.format("Position ID: %s, Currently Occupied: %s, Occupying Piece ID: %s, Is Slide Start: %s, Slide End index: %d, Slide Color: %s, Start: %s, Finish: %s", positionID, occupied, playerPieceID, slideStart, slideEnd, slideColor, startingPosition, finishPosition);
    }

    public void setPlayerPieceID(String playerPieceID) {
        this.playerPieceID = playerPieceID;
    }

    public String getPlayerPieceID() {
        return playerPieceID;
    }
    
    public void addPawn(Pawn pawn){
        String tmp = "grby";
        if (tmp.indexOf(positionID.charAt(0)) != -1){
            this.pawn[Integer.parseInt(pawn.getPositionID().substring(6))] = pawn;
        }
        else {this.pawn[0] = pawn;}
    }

    public void removePawn( Pawn pawn) {
        String tmp = "grby";
        if (tmp.indexOf(positionID.charAt(0)) != -1){
            this.pawn[Integer.parseInt(pawn.getPositionID().substring(6))] = null;
        }
        else {this.pawn[0] = null;}
    }
    
    public Pawn getPawn(){
        for (Pawn aPawn : pawn) {
            if (aPawn != null) {return aPawn;}
        }
        return null;
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
