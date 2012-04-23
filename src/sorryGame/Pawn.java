package sorryGame;

/**
 * CS Program: Pawn Programmer: Al Moataz Hassan Date: 3/23/12
 */
public class Pawn {
	private int num;
	private String id, positionID, color;
	private int location;
    PlayableSquare[] array;
    PlayableSquare startSquare;
    int startIndex;

	public Pawn(String color, String positionID, int number, int location, PlayableSquare startSquare, PlayableSquare[] array){
		this.color = color;
		this.num = number;
        this.location = location;
        this.startSquare = startSquare;
        setArray(array);
        setStartIndex();
		this.setID(number);
	}

    private void setStartIndex() {
        if(color.equals("green")) startIndex = 4;
        else if(color.equals("red")) startIndex = 19;
        else if(color.equals("blue")) startIndex = 34;
        else if(color.equals("yellow")) startIndex = 49;
    }

    public Pawn(){

    }

	public void setColor(String color){
		this.color = color;
        this.setID(this.num);
	}

	public String getColor(){
		return this.color;
	}

	public void setNum(int num){
		this.num = num;
		this.setID(num);
	}

	public int getNum(){
		return this.num;
	}

	public void setID(int number){
		this.id = this.color.toCharArray()[0] + Integer.toString(number);
	}

	public String getID(){
		return this.id;
	}

    public PlayableSquare[] getArray(){
        return this.array;
    }

    public void setArray(PlayableSquare[] array){
        this.array = array;
    }
	public void setLocation(int l){
		this.location = l;
	}

	public int getLocation(){
		return this.location;
	}

    public PlayableSquare getStartSquare() {
        return startSquare;
    }
}

