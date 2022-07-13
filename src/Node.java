import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Node {

    private final Board board;
    private final boolean isMax;
    private final Player ownPlayer;
    final Point path;

    public Node(Board board, boolean isMax, Player ownPlayer, Point path) {
        this.board = board;
        this.isMax = isMax;
        this.ownPlayer = ownPlayer;
        this.path = path;
    }

    public boolean isLeaf() {
        return this.board.getWinner() != Player.NO_PLAYER || this.board.getEmptySpots().size() == 0;
    }

    public int getValue() {
        Player winner = board.getWinner();

        if (winner == Player.NO_PLAYER) {
            return 0;
        }
        if (this.ownPlayer == winner) {
            return 1;
        }
        return -1;

    }

    public List<Node> getChildren() {

        List<Node> children = new ArrayList<Node>();
        Player player = isMax ? ownPlayer : Player.getOpponent(ownPlayer);

        for (Point possiblePoint: board.getEmptySpots()) {
            Board b = new Board(board);
            b.setValue(possiblePoint, player);
            children.add(new Node(b, !isMax, ownPlayer, possiblePoint));
        }

        Collections.shuffle(children, new Random());
        return children;
    }
}
