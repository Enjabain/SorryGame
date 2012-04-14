package sorryGame;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
* CS Program: PlayableSquare Programmer: Al Moataz Hassan Date: 3/23/12
*/
class PlayableSquare implements Serializable {

    private String type;
    private String squareColor;
    private boolean occupied;
    private int numOccupants;
    private List<Pawn> pawnList = new ArrayList<Pawn>();
    private String playerPieceID;
    private String positionID;

    PlayableSquare(String positionID) {
    	this.type = "regular";
    	this.squareColor = "none";
    	this.occupied = false;
    	this.numOccupants = -1;
    	this.playerPieceID = "none";
        this.positionID = positionID;
    }

    public void setType(String type){
    	this.type = type;
    }
    
    public String getType(){
    	return type;
    }
    
    public void setColor(String color){
    	this.squareColor = color;
    }
    
    public String getColor(){
    	return squareColor;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public boolean isOccupied() {
        return occupied;
    }
    
    public void setNumOccupants(int numOccupants){
    	this.numOccupants = numOccupants;
    }
    
    public int getNumOccupants(){
    	return numOccupants;
    }
    
    public void setPlayerPieceID(String playerPieceID) {
        this.playerPieceID = playerPieceID;
    }

    public String getPlayerPieceID() {
        return playerPieceID;
    }
    
    public void setToStart(String color){
    	this.type = "start";
    	this.squareColor = color;
    	this.occupied = false;
    	this.numOccupants = 0;
    	this.playerPieceID = "none";
    }
    
    public void setToHome(String color){
    	this.type = "home";
    	this.squareColor = color;
    	this.occupied = false;
    	this.numOccupants = 0;
    	this.playerPieceID = "none";
    }
    
    public void setToSafetyZone(String color){
    	this.type = "safetyZone";
    	this.squareColor = color;
    	this.occupied = false;
    	this.numOccupants = -1;
    	this.playerPieceID = "none";
    }
    
    public void setToSliderStart(String color){
    	this.type = "sliderStart";
    	this.squareColor = color;
    	this.occupied = false;
    	this.numOccupants = -1;
    	this.playerPieceID = "none";
    }
    
    public void setToSliderMid(String color){
    	this.type = "sliderMid";
    	this.squareColor = color;
    	this.occupied = false;
    	this.numOccupants = -1;
    	this.playerPieceID = "none";
    }


    public void setToSliderEnd(String color){
    	this.type = "sliderEnd";
    	this.squareColor = color;
    	this.occupied = false;
    	this.numOccupants = -1;
    	this.playerPieceID = "none";
    }
    
    public void removePiece(Pawn pawn){
    	if (this.type == "start"){
    		this.numOccupants--;
    		if (this.numOccupants == 0)
    			this.occupied = false;
            this.pawnList.remove(pawn);
    	}
    	else{
    		this.numOccupants = 0;
    		this.occupied = false;
    		this.playerPieceID = "none";
            this.pawnList.clear();
    	}
    }
    
    public void putPiece(Pawn pawn){
    	if (this.type == "start"){
    		this.numOccupants++;
    		this.occupied = true;
            this.pawnList.add(pawn);
    	}
    	else{
    		this.numOccupants = 1;
    		this.occupied = true;
    		this.playerPieceID = pawn.getID();
            this.pawnList.clear();
            this.pawnList.add(0, pawn);
    	}
    }

    public String getPositionID() {
        return positionID;
    }
}
