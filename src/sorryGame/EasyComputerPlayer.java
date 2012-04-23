package sorryGame;

import java.util.Map;

public class EasyComputerPlayer extends ComputerPlayer {

	public EasyComputerPlayer(GameBoard board, String color) {
		super(board, color);
	}

	@Override
	public void move(int card) {
        System.out.println(getColor());
        Map<String, Pawn[]> pawnMap = board.getPawns();
        for (Map.Entry<String, Pawn[]> pawns : pawnMap.entrySet()) {
            if (pawns.getKey().equalsIgnoreCase(getColor())) {
                for (Pawn pawn : pawns.getValue()) {
                    // if a move does not result in a bump ]
                    System.out.println(pawn.getLocation());
                    if (pawn.getLocation() == -1 && (card == 1 || card == 2) && !board.getGameArray()[pawn.startIndex].isOccupied()) {
                        board.makeMove(card, pawn.getID(), pawn.getLocation(), pawn.startIndex);
                        return;
                    }
                    else if (pawn.getLocation() >= 0 && pawn.getLocation() <= 59) {
                        if (!board.willBumpPiece(card, pawn.getLocation())) {
                            if (board.validateMove(card, pawn.getID(), pawn.getLocation(),
                                                   ((pawn.getLocation() + card) % 60), 0, 0)) {
                                //make rthe first move that results in a bump
                                board.makeMove(card, pawn.getID(), pawn.getLocation(),
                                               ((pawn.getLocation() + card) % 60));
                                return;
                            }
                        }
                        else {
                            System.out.println("should move " + pawn.getID() + " from " + pawn.getLocation() +  " to " + ((pawn.getLocation() + card) % 60));
                            board.makeMove(card, pawn.getID(), pawn.getLocation(), ((pawn.getLocation() + card) % 60));
                            return;
                        }
                    }
                }
            }
        }
    }

}
