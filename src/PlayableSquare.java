/**
* CS Program: PlayableSquare Programmer: Christopher Morse Date: 3/23/12
*/
class PlayableSquare {

    private String playerPieceID;
    private boolean occupied;
    private int index;

    PlayableSquare() {
        this.occupied = occupied;
        playerPieceID = getPlayerPieceID();
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
}
