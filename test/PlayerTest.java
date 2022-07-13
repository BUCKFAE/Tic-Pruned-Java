import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void numToPlayer() {
        assertEquals(Player.NO_PLAYER, Player.numToPlayer(0));
        assertEquals(Player.PLAYER_1, Player.numToPlayer(1));
        assertEquals(Player.PLAYER_2, Player.numToPlayer(2));
    }

    @Test
    void getOpponent() {
        assertThrows(IllegalArgumentException.class, () -> {
           Player p = Player.getOpponent(Player.NO_PLAYER);
        });
        assertEquals(Player.PLAYER_1, Player.getOpponent(Player.PLAYER_2));
        assertEquals(Player.PLAYER_2, Player.getOpponent(Player.PLAYER_1));
    }
}