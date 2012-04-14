package sorryGame;

import java.util.Map;

import sorryGame.Deck.Card;

public class EasyComputerPlayer extends ComputerPlayer {

	public EasyComputerPlayer(GameBoard board) {
		super(board);
	}

	@Override
	public void move(Card card) {
		Map<String, Pawn[]> pawnMap = board.getPawns();
		for (Map.Entry<String, Pawn[]> pawns : pawnMap.entrySet()){
			if(!pawns.getKey().equalsIgnoreCase(getColor())){
				for(Pawn pawn : pawns.getValue()){
					// if a move does not result in a bump
					if(true){
						if(board.validateMove(card.getRank(), pawn.getID(), 0, 0, 0, 0)){
							//make the first move that results in a bump
							board.makeMove(card.getRank(), pawn.getID(), 0, 0);
							return;
						}
					}
				}
			}
		}
	}

}
