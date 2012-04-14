package sorryGame;

import java.io.Serializable;

/**
* CS Program: PlayableSquare Programmer: Al Moataz Hassan Date: 3/23/12
*/
class PlayableSquare implements Serializable {

    private String type;
    private String squareColor;
    private boolean occupied;
    private int numOccupants;
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
    
    public void removePiece(){
    	if (this.type == "start"){
    		this.numOccupants--;
    		if (this.numOccupants == 0)
    			this.occupied = false;
    	}
    	else{
    		this.numOccupants = 0;
    		this.occupied = false;
    		this.playerPieceID = "none";
    	}
    }
    
    public void putPiece(String id){
    	if (this.type == "start"){
    		this.numOccupants++;
    		if (this.occupied == false)
    			this.occupied = true;
    	}
    	else{
    		this.numOccupants = 1;
    		this.occupied = true;
    		this.playerPieceID = id;
    	}
    }

    public String getPositionID() {
        return positionID;
    }
}
