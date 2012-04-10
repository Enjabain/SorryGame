package src;

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
	
	private PlayableSquare[] gameArray, redHomeArray, greenHomeArray, blueHomeArray, yellowHomeArray;
	private PlayableSquare greenStart, redStart, blueStart, yellowStart;
	private Pawn[] greenPawn, redPawn, bluePawn, yellowPawn;
	private int greenStartPosition, redStartPosition, blueStartPosition, yellowStartPosition;
	private int greenHomePosition, redHomePosition, blueHomePosition, yellowHomePosition;
	private int greenSafetyIndex, redSafetyIndex, blueSafetyIndex, yellowSafetyIndex;
	
	private ArrayList<Player> players = new ArrayList<Player>();
	
	public GameBoard(){
		initializeBoard();
	}
	
	public void addPlayer(Player p){
		players.add(p);
	}
	
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
        
        for (int i=0; i<6; i++){
        	greenHomeArray[i] = new PlayableSquare("g" + Integer.toString(i));
        	greenHomeArray[i].setToSafetyZone("green");
        	redHomeArray[i] = new PlayableSquare("r" + Integer.toString(i));
        	redHomeArray[i].setToSafetyZone("red");
        	blueHomeArray[i] = new PlayableSquare("b" + Integer.toString(i));
        	blueHomeArray[i].setToSafetyZone("blue");
        	yellowHomeArray[i] = new PlayableSquare("y" + Integer.toString(i));
        	yellowHomeArray[i].setToSafetyZone("yellow");
        }
        
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
    		greenPawn[i] = new Pawn();
    		greenPawn[i].setColor("green");
    		greenPawn[i].setNum(i);
    		greenPawn[i].setLocation(0);
    		redPawn[i] = new Pawn();
    		redPawn[i].setColor("red");
    		redPawn[i].setNum(i);
    		redPawn[i].setLocation(0);
    		bluePawn[i] = new Pawn();
    		bluePawn[i].setColor("blue");
    		bluePawn[i].setNum(i);
    		bluePawn[i].setLocation(0);
    		yellowPawn[i] = new Pawn();
    		yellowPawn[i].setColor("yellow");
    		yellowPawn[i].setNum(i);
    		yellowPawn[i].setLocation(0);
    	}
    	
    	greenStart.setNumOccupants(4);
    	redStart.setNumOccupants(4);
    	blueStart.setNumOccupants(4);
    	yellowStart.setNumOccupants(4);
    	
    	gameArray[6].setOccupied(true);
    	gameArray[6].setPlayerPieceID("g1");
    	
    	gameArray[4].setOccupied(true);
    	gameArray[4].setPlayerPieceID("b1");
    	
    	gameArray[26].setOccupied(true);
    	gameArray[26].setPlayerPieceID("g2");
    	
	}
	
    public void setToSlider(PlayableSquare[] gameArray, String color, int sliderSize, int start){
    	gameArray[start].setToSliderStart(color);
    	
    	for (int i=start+1; i<start+(sliderSize-1); i++)
    		gameArray[i].setToSliderMid(color);
    	
    	gameArray[start+sliderSize-1].setToSliderEnd(color);
    }

//    public boolean validateMove(int card, String pieceID, int initialPosition, int finalPosition, int initialPosition2, int finalPosition2){
//        boolean valid = false;
//        return valid;
//    }

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
    	//Get current card from Deck Class
		
		int startPosition, homePosition, safetyZoneIndex;
		Pawn temp = new Pawn();
		char color = pieceID.toCharArray()[0];
		if (color == 'g') {
			temp.setColor("green");
			startPosition = greenStartPosition;
			homePosition = greenHomePosition;
			safetyZoneIndex = greenSafetyIndex;
		}
		else if (color == 'r') {
			temp.setColor("red");
			startPosition = redStartPosition;
			homePosition = redHomePosition;
			safetyZoneIndex = redSafetyIndex;
		}
		else if (color == 'b') {
			temp.setColor("blue");
			startPosition = blueStartPosition;
			homePosition = blueHomePosition;
			safetyZoneIndex = blueSafetyIndex;
		}
		else if (color == 'y') {
			temp.setColor("yellow");
			startPosition = yellowStartPosition;
			homePosition = yellowHomePosition;
			safetyZoneIndex = yellowSafetyIndex;
		}
		else{
			temp.setColor("none");
			startPosition = 1;
			homePosition = 1;
			safetyZoneIndex = 60;
		}
    	
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
                else if (card == 2 && ((((homePosition - initialPosition)%60 + 60)%60 + ((finalPosition - safetyZoneIndex)%60) + 60)%60 + 1 == 2))
                	return true;
                else
                    return false;
            case 3: case 5: case 8: case 10: case 12:
        		if (initialPosition2 != 0 || finalPosition2 != 0)
        			return false;
                if (((finalPosition - initialPosition)%60 + 60)%60 == card)
                    return true;
                else if ((((homePosition - initialPosition)%60 + 60)%60 + ((finalPosition - safetyZoneIndex)%60) + 60)%60 + 1 == card)
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
            	// With the following combination: Card=4, initial=64, final=65, initial2=0, final2=0 
            	// if statement below incorrectly returns true.
            	
            	/*
            	 * I think I've resolved this bug but I cannot run the code on my machine.
            	 */
            	
            	else if ((((safetyZoneIndex - initialPosition)%60 + 60)%60 + ((homePosition - finalPosition)%60) + 60)%60 + 1 == 4)
            		return true;
            	else 
            		return false;            
            case 7:
            	if (((finalPosition - initialPosition)%60 + 60)%60 == 7)
                    return true;
            	else if ((((finalPosition - initialPosition)%60 + 60)%60) + (((finalPosition2 - initialPosition2)%60 + 60)%60) == 7)
            		return true;
            	// With the following combination: Card=7, initial=64, final=65, initial2=0, final2=0
            	// if statement below incorrectly returns true.
            	else if (((((homePosition - initialPosition)%60 + 60)%60 + ((finalPosition - safetyZoneIndex)%60) + 60)%60 + 1) + ((((homePosition - initialPosition2)%60 + 60)%60 + ((finalPosition2 - safetyZoneIndex)%60) + 60)%60 + 1) == 7)
            		return true;
            	else if (((((finalPosition - initialPosition)%60 + 60)%60)) + (((((homePosition - initialPosition2)%60 + 60)%60 + ((finalPosition2 - safetyZoneIndex)%60) + 60)%60 + 1)) == 7)
            		return true;
            	else if ((((((homePosition - initialPosition)%60 + 60)%60 + ((finalPosition - safetyZoneIndex)%60) + 60)%60 + 1)) + ((((finalPosition2 - initialPosition2)%60 + 60)%60)) == 7)
            		return true;
            	else
            		return false;           
            case 11:
            	if (initialPosition2 != 0 || finalPosition2 != 0)
        			return false;
            	if (((finalPosition - initialPosition)%60 + 60)%60 == 11)
                    return true;
            	else if ((((homePosition - initialPosition)%60 + 60)%60 + ((finalPosition - safetyZoneIndex)%60) + 60)%60 + 1 == 11)
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
    /**
     * This method actually implements the move once it has been validated. It is here that things like bumps, slides and switches
     * are taken care of. This function takes the information about the move that will be performed and updates the gameArray.
     * @param card: the top card or the card at hand.
	 * @param pieceID: the id (e.g. "g1", "b4", "y2"...) of the piece being moved.
	 * @param initialPosition: current position of the piece being moved.
	 * @param finalPosition: the position to which the piece/pawn should go.
	 * @param initialPosition2: this second initial position is used in the case of the card 7 (where a player may move two pawns).
	 * @param finalPosition2: this second final position is also used if 2 pawns are being moved. 
	 * (initialPosition2 and finalPosition2 are always 0 for all cards).
	 * 
	 * This method is still not complete, the code is very messy and needs changing to be more efficient, below is the code for
	 * moving a piece from start to beginning of the board.
     */
    public void makeMove(int card, String pieceID, int initialPosition, int finalPosition, int initialPosition2, int finalPosition2){
		
		char color = pieceID.toCharArray()[0];
    	
    	switch (card){
    		case 1:
    			if (initialPosition == -1){
    				if (color == 'g'){
    					greenStart.removePiece();
    					if (gameArray[greenStartPosition].isOccupied() && gameArray[greenStartPosition].getPlayerPieceID().toCharArray()[0] != 'g'){
    						if (gameArray[greenStartPosition].getPlayerPieceID().toCharArray()[0] == 'r')
    							redStart.putPiece("red");
    						if (gameArray[greenStartPosition].getPlayerPieceID().toCharArray()[0] == 'b')
    							blueStart.putPiece("blue");
    						if (gameArray[greenStartPosition].getPlayerPieceID().toCharArray()[0] == 'y')
    							yellowStart.putPiece("yellow");
    						gameArray[greenStartPosition].removePiece();
    					}
    					gameArray[greenStartPosition].putPiece(pieceID);
    					greenPawn[pieceID.toCharArray()[1]-48].setLocation(greenStartPosition);
    				}
    				else if (color == 'r'){
    					redStart.removePiece();
    					if (gameArray[redStartPosition].isOccupied() && gameArray[redStartPosition].getPlayerPieceID().toCharArray()[0] != 'r'){
    						if (gameArray[redStartPosition].getPlayerPieceID().toCharArray()[0] == 'g')
    							greenStart.putPiece("red");
    						if (gameArray[redStartPosition].getPlayerPieceID().toCharArray()[0] == 'b')
    							blueStart.putPiece("blue");
    						if (gameArray[redStartPosition].getPlayerPieceID().toCharArray()[0] == 'y')
    							yellowStart.putPiece("yellow");
    						gameArray[redStartPosition].removePiece();
    					}
    					gameArray[redStartPosition].putPiece(pieceID);
    					redPawn[pieceID.toCharArray()[1]].setLocation(redStartPosition);
    				}
    				else if (color == 'b'){
    					blueStart.removePiece();
    					if (gameArray[blueStartPosition].isOccupied() && gameArray[blueStartPosition].getPlayerPieceID().toCharArray()[0] != 'b'){
    						if (gameArray[blueStartPosition].getPlayerPieceID().toCharArray()[0] == 'r')
    							redStart.putPiece("red");
    						if (gameArray[blueStartPosition].getPlayerPieceID().toCharArray()[0] == 'g')
    							greenStart.putPiece("blue");
    						if (gameArray[blueStartPosition].getPlayerPieceID().toCharArray()[0] == 'y')
    							yellowStart.putPiece("yellow");
    						gameArray[blueStartPosition].removePiece();
    					}
    					gameArray[blueStartPosition].putPiece(pieceID);
    					bluePawn[pieceID.toCharArray()[1]].setLocation(blueStartPosition);
    				}
    				else if (color == 'y'){
    					yellowStart.removePiece();
    					if (gameArray[yellowStartPosition].isOccupied() && gameArray[yellowStartPosition].getPlayerPieceID().toCharArray()[0] != 'y'){
    						if (gameArray[yellowStartPosition].getPlayerPieceID().toCharArray()[0] == 'r')
    							redStart.putPiece("red");
    						if (gameArray[yellowStartPosition].getPlayerPieceID().toCharArray()[0] == 'b')
    							blueStart.putPiece("blue");
    						if (gameArray[yellowStartPosition].getPlayerPieceID().toCharArray()[0] == 'g')
    							yellowStart.putPiece("yellow");
    						gameArray[yellowStartPosition].removePiece();
    					}
    					gameArray[yellowStartPosition].putPiece(pieceID);
    					yellowPawn[pieceID.toCharArray()[1]].setLocation(yellowStartPosition);
    				}
    			}
    			else {
    				// If the piece is to be moved just one space forward.
    			}
    		/* This code is being revised.	
    		case 2:
    		case 3: case 4: case 5: case 8: case 10: case 12:
    		case 7:
    		case 11:
    		case 0:
    		*/
    	}
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
        return new PlayableSquare[] {greenStart, redStart, blueStart, yellowStart};
    }
}