package sorryGame;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * CS 205 Program: GameBoard
 * @author Al Moataz Hassan
 * Date: 03/23/2012
 */

// Just testing if I can make changes to the code


public class GameBoard {

	private PlayableSquare[] gameArray, redHomeArray, greenHomeArray, blueHomeArray, yellowHomeArray, currentHomeArray;
	private PlayableSquare greenStart, redStart, blueStart, yellowStart, currentStart;
	PlayableSquare[] startArrays;
	private Pawn[] greenPawn, redPawn, bluePawn, yellowPawn;
	private int greenStartPosition, redStartPosition, blueStartPosition, yellowStartPosition;
	private int greenHomePosition, redHomePosition, blueHomePosition, yellowHomePosition;
	private int greenSafetyIndex, redSafetyIndex, blueSafetyIndex, yellowSafetyIndex;
	int startPosition, homePosition, safetyZoneIndex;	

	private ArrayList<Player> players = new ArrayList<Player>();

	public GameBoard(){
		initializeBoard();
	}

	public void addPlayer(Player p){
		players.add(p);
	}

//    private void placePawns(){
//        for (Pawn pawn:greenPawn){
//            PlayableSquare[] currentArray = pawn.getArray();
//            PlayableSquare position = currentArray[pawn.getLocation()];
//            if(position.isOccupied()) {position.removePawn(position.getPawn());}
//            position.setOccupied(true);
//            position.addPawn(pawn);
//        }
//    }

	public ArrayList<Player> getPlayers(){
		return players;
	}

	public void print(){
		for (int i=0; i<this.gameArray.length; i++){
			System.out.println("Square " + i + " is a " + gameArray[i].getType() + " square with color set to: " + gameArray[i].getColor());
			if (gameArray[i].isOccupied())
				System.out.println(" - Occupied by: " + gameArray[i].getPlayerPieceID());
		}
	}

	public Map<String, Pawn[]> getPawns(){
		Map<String, Pawn[]> pawns = new TreeMap<String, Pawn[]>();
		pawns.put("green", greenPawn);
		pawns.put("red", redPawn);
		pawns.put("blue", bluePawn);
		pawns.put("yellow", yellowPawn);
		return pawns;
	}

	/**
	 * Initialises the board array, setting all of the sliders and their location, storing the indices of the different
	 * locations of the 'special' squares: the home, the start, and the safety zone squares. It also sets up all of the
	 * different pieces (or pawns).
	 */
	public void initializeBoard(){

		gameArray = new PlayableSquare[60];
		for (int i=0; i<60; i++)
			gameArray[i] = new PlayableSquare(Integer.toString(i));
		redHomeArray = new PlayableSquare[6];
        greenHomeArray = new PlayableSquare[6];
        blueHomeArray = new PlayableSquare[6];
        yellowHomeArray = new PlayableSquare[6];
        
        greenStart = new PlayableSquare("gstart");
        redStart = new PlayableSquare("rstart");
        blueStart = new PlayableSquare("bstart");
        yellowStart = new PlayableSquare("ystart");

        startArrays = new PlayableSquare[]{greenStart, redStart, blueStart, yellowStart};
        
        greenStart.setToStart("green");
        redStart.setToStart("red");
        blueStart.setToStart("blue");
        yellowStart.setToStart("yellow");
        
        greenStartPosition = 4;
        redStartPosition = 19;
        blueStartPosition = 34;
        yellowStartPosition = 49;
        
        greenHomePosition = 2;
        redHomePosition = 17;
        blueHomePosition = 32;
        yellowHomePosition = 47;
        
        greenSafetyIndex = 60;
        redSafetyIndex = 66;
        blueSafetyIndex = 72;
        yellowSafetyIndex = 78;
        
        for (int i=0; i<5; i++){
        	greenHomeArray[i] = new PlayableSquare(Integer.toString(i+greenSafetyIndex));
        	greenHomeArray[i].setToSafetyZone("green");
        	redHomeArray[i] = new PlayableSquare(Integer.toString(i+redSafetyIndex));
        	redHomeArray[i].setToSafetyZone("red");
        	blueHomeArray[i] = new PlayableSquare(Integer.toString(i+blueSafetyIndex));
        	blueHomeArray[i].setToSafetyZone("blue");
        	yellowHomeArray[i] = new PlayableSquare(Integer.toString(i+yellowSafetyIndex));
        	yellowHomeArray[i].setToSafetyZone("yellow");
        }
        greenHomeArray[5] = new PlayableSquare("greenhome");
        greenHomeArray[5].setToSafetyZone("green");
        redHomeArray[5] = new PlayableSquare("redhome");
        redHomeArray[5].setToSafetyZone("red");
        blueHomeArray[5] = new PlayableSquare("bluehome");
        blueHomeArray[5].setToSafetyZone("blue");
        yellowHomeArray[5] = new PlayableSquare("yellowhome");
        yellowHomeArray[5].setToSafetyZone("yellow");


        greenHomeArray[5].setToHome("green");
    	redHomeArray[5].setToHome("red");
    	blueHomeArray[5].setToHome("blue");
    	yellowHomeArray[5].setToHome("yellow");
        
    	setToSlider(gameArray, "green", 4, 1);
    	setToSlider(gameArray, "green", 5, 9);
    	setToSlider(gameArray, "red", 4, 16);
    	setToSlider(gameArray, "red", 5, 24);
    	setToSlider(gameArray, "blue", 4, 31);
    	setToSlider(gameArray, "blue", 5, 39);
    	setToSlider(gameArray, "yellow", 4, 46);
    	setToSlider(gameArray, "yellow", 5, 54);
    	
    	greenPawn = new Pawn[4];
    	redPawn = new Pawn[4];
    	bluePawn = new Pawn[4];
    	yellowPawn = new Pawn[4];
    	
    	for (int i=0; i<4; i++){
    		greenPawn[i] = new Pawn("green", "gstart", i, -1, startArrays[0], startArrays);
    		redPawn[i] = new Pawn("red", "rstart", i, -1, startArrays[1], startArrays);
    		bluePawn[i] = new Pawn("blue", "bstart", i, -1, startArrays[2], startArrays);
    		yellowPawn[i] = new Pawn("yellow", "ystart", i, -1, startArrays[3], startArrays);
    	}

        for (PlayableSquare square:startArrays) {
            square.setNumOccupants(4);
            square.setOccupied(true);
        }
        for (int i = 0; i < 4; i++){
            greenStart.putPiece(greenPawn[i]);
            redStart.putPiece(redPawn[i]);
            blueStart.putPiece(bluePawn[i]);
            yellowStart.putPiece(yellowPawn[i]);
        }

//    	gameArray[6].setOccupied(true);
//    	gameArray[6].setPlayerPieceID("g1");
//
//    	gameArray[4].setOccupied(true);
//    	gameArray[4].setPlayerPieceID("b1");
//
//    	gameArray[26].setOccupied(true);
//    	gameArray[26].setPlayerPieceID("g2");
    	
	}

    public void setToSlider(PlayableSquare[] gameArray, String color, int sliderSize, int start){
    	gameArray[start].setToSliderStart(color);
    	
    	for (int i=start+1; i<start+(sliderSize-1); i++)
    		gameArray[i].setToSliderMid(color);
    	
    	gameArray[start+sliderSize-1].setToSliderEnd(color);
    }
    
    public void setCurrentPawnInfo(String pieceID){
    	char color = pieceID.toCharArray()[0];
		if (color == 'g') {
			startPosition = greenStartPosition;
			homePosition = greenHomePosition;
			safetyZoneIndex = greenSafetyIndex;
			currentStart = greenStart;
			currentHomeArray = greenHomeArray;
		}
		else if (color == 'r') {
			startPosition = redStartPosition;
			homePosition = redHomePosition;
			safetyZoneIndex = redSafetyIndex;
			currentStart = redStart;
			currentHomeArray = redHomeArray;
		}
		else if (color == 'b') {
			startPosition = blueStartPosition;
			homePosition = blueHomePosition;
			safetyZoneIndex = blueSafetyIndex;
			currentStart = blueStart;
			currentHomeArray = blueHomeArray;
		}
		else if (color == 'y') {
			startPosition = yellowStartPosition;
			homePosition = yellowHomePosition;
			safetyZoneIndex = yellowSafetyIndex;
			currentStart = yellowStart;
			currentHomeArray = yellowHomeArray;
		}
		else{
			/*
			 * Output Error Message
			 */
			startPosition = 1;
			homePosition = 1;
			safetyZoneIndex = 60;
			currentStart = greenStart;
			currentHomeArray = greenHomeArray;
		}
    }

	/**
	 * Validates that a move is possible. Does not look at other pieces (i.e. bumps) but only checks to see if the move 
	 * meets the rules of the card at hand.
	 * NOTE: Must still add check to make sure player does not bump themselves.
	 * BUGS: Two bugs still need fixing, see comments in the code.
	 * @param card: the top card or the card at hand.
	 * @param pieceID: the id (e.g. "g1", "b4", "y2"...) of the piece being moved.
	 * @param initialPosition: current position of the piece being moved.
	 * @param finalPosition: the position to which the piece/pawn should go.
	 * @param initialPosition2: this second initial position is used in the case of the card 7 (where a player may move two pawns).
	 * @param finalPosition2: this second final position is also used if 2 pawns are being moved. 
	 * (initialPosition2 and finalPosition2 are always 0 for all cards).
	 * @return This method returns a boolean that says if a move is possible or not
	 */
    public boolean validateMove(int card, String pieceID, int initialPosition, int finalPosition, int initialPosition2, int finalPosition2){
    	
    	char color = pieceID.toCharArray()[0];
    	this.setCurrentPawnInfo(pieceID);
    	
	    if (finalPosition < 60 && gameArray[finalPosition].isOccupied() && gameArray[finalPosition].getPlayerPieceID().toCharArray()[0] == color)
	    	return false;
	    else if (finalPosition >= 60 && currentHomeArray[finalPosition - safetyZoneIndex].isOccupied() && currentHomeArray[finalPosition - safetyZoneIndex].getPlayerPieceID().toCharArray()[0] == color)
	    	return false;
//	    if (finalPosition2 < 60 && gameArray[finalPosition2].isOccupied() && gameArray[finalPosition2].getPlayerPieceID().toCharArray()[0] == color)
//	    	return false;
//	    else if (finalPosition2 >= 60 && currentHomeArray[finalPosition2 - safetyZoneIndex].isOccupied() && currentHomeArray[finalPosition2 - safetyZoneIndex].getPlayerPieceID().toCharArray()[0] == color)
//	    	return false;
    	
    	switch (card){
            case 1: case 2:
        		if (initialPosition2 != 0 || finalPosition2 != 0)
        			return false;
                if (initialPosition == -1 && finalPosition == startPosition)
                    return true;
                else if (((finalPosition - initialPosition)%60 + 60)%60 == card) 
                    return true;
                else if (card == 1 && initialPosition == homePosition && finalPosition == safetyZoneIndex)
                    return true;
                else if (card == 2 && ((((homePosition - initialPosition)%60 + 60)%60 + ((finalPosition - safetyZoneIndex)%(safetyZoneIndex+6)) + (safetyZoneIndex+6))%(safetyZoneIndex+6) + 1 == 2))
                	return true;
                else
                    return false;
            case 3: case 5: case 8: case 10: case 12:
        		if (initialPosition2 != 0 || finalPosition2 != 0)
        			return false;
                if (((finalPosition - initialPosition)%60 + 60)%60 == card)
                    return true;
                else if ((((homePosition - initialPosition)%60 + 60)%60 + ((finalPosition - safetyZoneIndex)%(safetyZoneIndex+6)) + (safetyZoneIndex+6))%(safetyZoneIndex+6) + 1 == card)
            		return true;
                else if (card == 10 && (((initialPosition - finalPosition)%60 + 60)%60 == 1))
                    return true;
            	else if (card == 10 && (initialPosition == safetyZoneIndex && finalPosition == homePosition))
                    return true;
                else 
            		return false;
            case 4:
            	if (initialPosition2 != 0 || finalPosition2 != 0)
        			return false;
            	if (((initialPosition - finalPosition)%60 + 60)%60 == 4)
                    return true;
            	else if ((((safetyZoneIndex - initialPosition)%60 + 60)%60 + ((homePosition - finalPosition)%60) + 60)%60 + 1 == 4)
            		return true;
            	else 
            		return false;            
            case 7:
            	if (((finalPosition - initialPosition)%60 + 60)%60 == 7)
                    return true;
            	else if ((((finalPosition - initialPosition)%60 + 60)%60) + (((finalPosition2 - initialPosition2)%60 + 60)%60) == 7)
            		return true;
            	else if (((((homePosition - initialPosition)%60 + 60)%60 + ((finalPosition - safetyZoneIndex)%(safetyZoneIndex+6)) + (safetyZoneIndex+6))%(safetyZoneIndex+6) + 1) + ((((homePosition - initialPosition2)%60 + 60)%60 + ((finalPosition2 - safetyZoneIndex)%(safetyZoneIndex+6)) + (safetyZoneIndex+6))%(safetyZoneIndex+6) + 1) == 7)
            		return true;
            	else if (((((finalPosition - initialPosition)%60 + 60)%60)) + (((((homePosition - initialPosition2)%60 + 60)%60 + ((finalPosition2 - safetyZoneIndex)%(safetyZoneIndex+6)) + (safetyZoneIndex+6))%(safetyZoneIndex+6) + 1)) == 7)
            		return true;
            	else if ((((((homePosition - initialPosition)%60 + 60)%60 + ((finalPosition - safetyZoneIndex)%(safetyZoneIndex+6)) + (safetyZoneIndex+6))%(safetyZoneIndex+6) + 1)) + ((((finalPosition2 - initialPosition2)%60 + 60)%60)) == 7)
            		return true;
            	else
            		return false;           
            case 11:
            	if (initialPosition2 != 0 || finalPosition2 != 0)
        			return false;
            	if (((finalPosition - initialPosition)%60 + 60)%60 == 11)
                    return true;
            	else if ((((homePosition - initialPosition)%60 + 60)%60 + ((finalPosition - safetyZoneIndex)%(safetyZoneIndex+6)) + (safetyZoneIndex+6))%(safetyZoneIndex+6) + 1 == 11)
            		return true;
            	else if (initialPosition >= 0 && initialPosition <= 59 && gameArray[finalPosition].isOccupied()){
            		if (gameArray[finalPosition].getPlayerPieceID().toCharArray()[0] != color)
            			return true;
            		else
            			return false;
            	}
            	else if (initialPosition == finalPosition)
            		return true;
            	else
            		return false;
            
            case 0:
            	if (initialPosition2 != 0 || finalPosition2 != 0)
        			return false;
            	if (initialPosition == -1 && gameArray[finalPosition].isOccupied()){
            		if (gameArray[finalPosition].getPlayerPieceID().toCharArray()[0] != color)
            			return true;
            		else
            			return false;
            	}
            	else
            		return false;                    	
            }
        System.out.println("Something went wrong!");// Still need to work on this.
        return false;
    }
    
    public void bump(int position){
        Pawn bumpedPawn = gameArray[position].getPiece();
        gameArray[position].removePiece(bumpedPawn);
        bumpedPawn.getStartSquare().putPiece(bumpedPawn);

    }
    
    /**
     * This method actually implements the move once it has been validated. It is here that things like bumps, slides and switches
     * are taken care of. This function takes the information about the move that will be performed and updates the gameArray.
     * @param card: the top card or the card at hand.
	 * @param pieceID: the id (e.g. "g1", "b4", "y2"...) of the piece being moved.
	 * @param initialPosition: current position of the piece being moved.
	 * @param finalPosition: the position to which the piece/pawn should go.
     */
    public void makeMove(int card, String pieceID, int initialPosition, int finalPosition){

		char color = pieceID.toCharArray()[0];
    	this.setCurrentPawnInfo(pieceID);
    	
    	Pawn currentPiece;
    	
    	if (initialPosition == -1){
    		currentPiece = currentStart.getPiece();
    		currentStart.removePiece(currentPiece);
    	}
    	else if (initialPosition >= 0 && initialPosition <= 59){
    		currentPiece = gameArray[initialPosition].getPiece();
    		gameArray[initialPosition].removePiece(currentPiece);
    	}
    	else {
    		currentPiece = currentHomeArray[initialPosition-safetyZoneIndex].getPiece();
    		currentHomeArray[initialPosition-safetyZoneIndex].removePiece(currentPiece);
    	}
    	////////////////////////////////////////////////////////////////////////
    	if (finalPosition >= 0 && finalPosition <= 59){
            if(gameArray[finalPosition].isOccupied()){
                if(card == 11){
                    if (gameArray[finalPosition].isOccupied() && (finalPosition-initialPosition) == 11)
                        bump(finalPosition);
                    else if (gameArray[finalPosition].isOccupied() && (finalPosition-initialPosition) != 11){
                        Pawn tempPiece = gameArray[finalPosition].getPiece();
                        gameArray[initialPosition].putPiece(tempPiece);
                    }
                }
                else bump(finalPosition);
            }
            
            if (gameArray[finalPosition].getType().equals("sliderStart") && gameArray[finalPosition].getColor().toCharArray()[0] != color){
            	while (!gameArray[finalPosition].getType().equals("sliderEnd")){
            		if (gameArray[finalPosition].isOccupied())
            			bump(finalPosition);
            		finalPosition++;
            	}
            	if (gameArray[finalPosition].isOccupied())
        			bump(finalPosition);
            }
            
    		gameArray[finalPosition].putPiece(currentPiece);
    	}
    	else if (finalPosition > 59){
    		currentHomeArray[finalPosition-safetyZoneIndex].putPiece(currentPiece);
    	}
    }
    
    public boolean willBumpPiece(int card, int initialPosition){
    	switch (card){
        case 1: case 2: case 3: case 5: case 8: case 10: case 11: case 12:
        	return gameArray[initialPosition+card].isOccupied();
        case 4:
        	return gameArray[(initialPosition-4+60)%60].isOccupied();
        case 7:
        	if(gameArray[initialPosition+7].isOccupied()){
        		return true;
        	}else{
        		for(int i = 1; i < 7; i++){
        			if(gameArray[initialPosition+i].isOccupied()){
        				return true;
        			}
        		}
        		return false;
        	}
        case 0:
        	return true;
        }
    	return true;
    }

    public PlayableSquare[] getGameArray() {
        return gameArray;
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
}
