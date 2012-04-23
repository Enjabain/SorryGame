package sorryGame;

import java.util.Map;

public class HardComputerPlayer extends ComputerPlayer {

	public HardComputerPlayer(GameBoard board, String color) {
		super(board, color);
	}

	@Override
	public void move(int card) {
		Map<String, Pawn[]> pawnMap = board.getPawns();
		for (Map.Entry<String, Pawn[]> pawns : pawnMap.entrySet()){
			if(!pawns.getKey().equalsIgnoreCase(getColor())){
				for(Pawn pawn : pawns.getValue()){
					// if a move results in a bump
					if(board.willBumpPiece(card, pawn.getLocation())){
						if(board.validateMove(card, pawn.getID(), 0, 0, 0, 0)){
							//make the first move that results in a bump
							board.makeMove(card, pawn.getID(), 0, 0);
							return;
						}
					}
				}
			}
		}
	}

}
