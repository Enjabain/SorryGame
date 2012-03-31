package sorryGame;

import java.util.Random;

public class ComputerPlayer extends Player {

	public ComputerPlayer() {
		super();
		setName(getRandomName());
	}

	private String getRandomName() {
		String[] names = { "Mathew Halton", "Melisa Spake", "Alana Tippens", "Jessie Bogar" };
		Random generator = new Random();
		int index = generator.nextInt(4);
		return names[index];
	}

}
