package sorryGame;

import java.awt.Color;

@SuppressWarnings("UnusedDeclaration")
abstract public class Player {

	private String name;
	private Color color;

	abstract void move();

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
