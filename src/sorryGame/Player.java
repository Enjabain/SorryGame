package sorryGame;

import java.awt.Color;

abstract public class Player {
	
	//reference to the board
	private GameBoard board;

	private String name;
	private Color color;

	abstract void move();
	
	public Player(GameBoard board){
		this.board = board;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
