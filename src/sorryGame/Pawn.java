package sorryGame;

/**
 * CS Program: Pawn Programmer: Al Moataz Hassan Date: 3/23/12
 */
public class Pawn {
	private String color;
	private int num;
	private String id;
	private int location;
	
	public Pawn(String color, int number,int location){
		this.color = color;
		this.num = number;
        this.location = location;
		this.setID();
	}
    public Pawn(){

    }
	
	public void setColor(String color){
		this.color = color;
		this.setID();
	}
	
	public String getColor(){
		return this.color;
	}
	
	public void setNum(int num){
		this.num = num;
		this.setID();
	}
	
	public int getNum(){
		return this.num;
	}
	
	public void setID(){
		this.id = this.color.toCharArray()[0] + Integer.toString(this.num);
	}
	
	public String getID(){
		return this.id;
	}
	
	public void setLocation(int l){
		this.location = l;
	}
	
	public int getLocation(){
		return this.location;
	}
}
