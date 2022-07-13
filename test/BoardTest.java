import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void getWinner() {

        // All tests for both player
        for (int playerID = 1; playerID <= 2; playerID++) {
            Player player = Player.numToPlayer(playerID);
            Player opponent = Player.getOpponent(player);

            System.out.println("Testing win conditions for player: " + playerID);
            System.out.println("Opponent: " + opponent);

            // Testing all rows / cols
            for (int i = 0; i <= 2; i++) {

                Board b1 = new Board();
                Board b2 = new Board();

                for (int j = 0; j <= 4; j++) {
                    // Setting points for row / col win
                    if (j % 2 == 0) {
                        b1.setValue(new Point(i, j / 2), player);
                        b2.setValue(new Point(j / 2, i), player);
                    } else {
                        b1.setValue(new Point((i + 1) % 2, j / 2 + 1), opponent);
                        b2.setValue(new Point(j / 2 + 1, (i + 1) % 2), opponent);
                    }

                    // Ensuring game is not won until row / col is filled
                    if (j / 2 < 2) {
                        assertEquals(Player.NO_PLAYER, b1.getWinner());
                        assertEquals(Player.NO_PLAYER, b2.getWinner());
                    }
                }

                System.out.println("Board:\n" + b1.getBoardString());
                assertEquals(player, b1.getWinner());
                System.out.println("Board:\n" + b2.getBoardString());
                assertEquals(player, b2.getWinner());
            }

            Board b3 = new Board();
            Board b4 = new Board();

            // Diag wins
            for (int i = 0; i <= 2; i++) {

                b3.setValue(new Point(i, i), player);
                b3.setValue(new Point(i, (i + 1) % 3), opponent);

                b4.setValue(new Point(2 - i, i), player);
                b4.setValue(new Point(2 - i, (i + 1) % 3), opponent);

                // Ensuring game is not won until row / col is filled
                if (i != 2) {
                    assertEquals(Player.NO_PLAYER, b3.getWinner());
                    assertEquals(Player.NO_PLAYER, b4.getWinner());
                }
            }

            System.out.println("Board:\n" + b3.getBoardString());
            assertEquals(player, b3.getWinner());
            System.out.println("Board:\n" + b4.getBoardString());
            assertEquals(player, b4.getWinner());
        }
    }
}