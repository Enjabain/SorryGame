package sorryGame;

/**
 * CS Program: Pawn Programmer: Al Moataz Hassan Date: 3/23/12
 */
public class Pawn {
	private String color;
	private int num;
	private String id;
	private int location;
	
	public Pawn(){
		this.color = "None";
		this.num = 0;
		this.id = this.color.toCharArray()[0] + Integer.toHexString(this.num);
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
		this.id = this.color.toCharArray()[0] + Integer.toHexString(this.num);
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
