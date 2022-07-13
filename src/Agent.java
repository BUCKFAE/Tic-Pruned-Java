import java.util.List;
import java.util.Random;


public class Agent {

    public static Point getNextMove(Board board, Player ownPlayer) {
        Node n = new Node(board, true, ownPlayer, null);
        MinMaxResult res = alphaBeta(n, Integer.MIN_VALUE, Integer.MAX_VALUE, true);
        return res.p;

    }

    private record MinMaxResult(Point p, int value) {};

    private static MinMaxResult alphaBeta(Node node, int alpha, int beta, boolean isMax) {

        if (node.isLeaf()) {
            return new MinMaxResult(node.path, node.getValue());
        }

        if (isMax) {
            MinMaxResult bestValue = new MinMaxResult(null, Integer.MIN_VALUE);
            for (Node child: node.getChildren()) {

                MinMaxResult res = alphaBeta(child, alpha, beta, false);
                if (res.value > bestValue.value) {
                    bestValue = new MinMaxResult(child.path, res.value);
                }

                // beta cutoff
                if (bestValue.value >= beta) {
                    break;
                }

                alpha = Math.max(alpha, bestValue.value);
            }
            return bestValue;
        } else {
            MinMaxResult bestValue = new MinMaxResult(null, Integer.MAX_VALUE);
            for (Node child: node.getChildren()) {

                MinMaxResult res = alphaBeta(child, alpha, beta, true);
                if (res.value < bestValue.value) {
                    bestValue = new MinMaxResult(child.path, res.value);
                }

                // beta cutoff
                if (bestValue.value <= alpha) {
                    break;
                }

                beta = Math.min(beta, bestValue.value);
            }
            return bestValue;
        }

    }
}
