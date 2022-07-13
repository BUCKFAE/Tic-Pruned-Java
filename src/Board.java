import java.util.ArrayList;
import java.util.List;

public class Board {

    private int[][] field;

    public Board() {
        this.field = new int[3][3];
    }

    public Board(Board other) {
        this.field = new int[3][3];

        // Copying the other board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.field[i][j] = other.field[i][j];
            }
        }

    }

    public Player getValue(Point p) {
        return Player.numToPlayer(this.field[p.y][p.x]);
    }

    public void setValue(Point point, Player player) {

        assert player != Player.NO_PLAYER;
        assert this.field[point.y][point.x] == 0;

        this.field[point.y][point.x] = player.num;
    }

    public List<Point> getEmptySpots() {
        ArrayList<Point> emptySpots = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Point p = new Point(i, j);
                if (this.getValue(p) == Player.NO_PLAYER) {
                    emptySpots.add(p);
                }
            }
        }
        return emptySpots;
    }

    public Player getWinner() {

        for (int playerID = 1; playerID <= 2; playerID++) {
            Player player = Player.numToPlayer(playerID);

            // Row / Col win
            for (int i = 0; i < 3; i++) {

                // Counting row / col matches
                int c1 = 0;
                int c2 = 0;

                // Iterating over board
                for (int j = 0; j < 3; j++) {
                    if (this.getValue(new Point(i, j)) == player) {
                        c1++;
                    }
                    if (this.getValue(new Point(j, i)) == player) {
                        c2++;
                    }
                }

                // Current player won
                if (c1 == 3 || c2 == 3) {
                    return player;
                }
            }

            // Diag win
            if (this.getValue(new Point(0, 0)) == player &&
                    this.getValue(new Point(1, 1)) == player &&
                    this.getValue(new Point(2, 2)) == player) {
                return player;
            }
            // Other diag win
            if (this.getValue(new Point(2, 0)) == player
                    && this.getValue(new Point(1, 1)) == player
                    && this.getValue(new Point(0, 2)) == player) {
                return player;
            }
        }
        return Player.NO_PLAYER;
    }

    public String getBoardString() {
        String divider = "+-+-+-+\n";

        StringBuilder sb = new StringBuilder();
        sb.append(divider);

        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                sb.append("|").append(this.getValue(new Point(x, y)).symbol);
            }
            sb.append("|\n").append(divider);
        }
        sb.append("Winner: ").append(this.getWinner()).append("\n");
        return sb.toString();
    }
}
