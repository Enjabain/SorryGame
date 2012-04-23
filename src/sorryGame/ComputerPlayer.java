package sorryGame;

import java.util.Random;

abstract public class ComputerPlayer extends Player {

	public ComputerPlayer(GameBoard board, String color) {
		super(board);
		setName(getRandomName());
        setColor(color);
	}

	private String getRandomName() {
		String[] names = { "Mathew Halton", "Melisa Spake", "Alana Tippens", "Jessie Bogar" };
		Random generator = new Random();
		int index = generator.nextInt(4);
		return names[index];
	}

}
