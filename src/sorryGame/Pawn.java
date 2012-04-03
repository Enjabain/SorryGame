package sorryGame;

@SuppressWarnings("UnusedDeclaration")
public class Pawn {
    private int positionIndex;
    private String positionID, pieceID, color;
    private PlayableSquare[] currentArray;
    
    public Pawn (int positionIndex, PlayableSquare[] currentArray, String positionID, String pieceID, String color){
        setPositionIndex(positionIndex);
        setCurrentArray(currentArray);
        setPostionID(positionID);
        setPieceID(pieceID);
        setColor(color);
    }
    
    public void setPositionIndex(int positionIndex){
        this.positionIndex = positionIndex;
    }
    public int getPositionIndex(){
        return positionIndex;
    }
    
    public void setCurrentArray(PlayableSquare[] currentArray){
        this.currentArray = currentArray;
    }
    public PlayableSquare[] getCurrentArray(){
        return currentArray;
    }
    
    public void setPostionID(String positionID){
        this.positionID = positionID;
    }
    public String getPositionID(){
        return positionID;
    }
    
    public void setPieceID(String pieceID){
        this.pieceID = pieceID;
    }
    public String pieceID(){
        return pieceID;
    }
    
    public void setColor(String color){
        this.color = color;
    }
    public String getColor(){
        return color;
    }
}