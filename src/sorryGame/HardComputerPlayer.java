package sorryGame;

public class HardComputerPlayer extends ComputerPlayer {

	@Override
	void move() {
		Pawn[] pawns = GameBoard.getPawns(this);
		for(Pawn pawn : pawns){
		}
	}

}
