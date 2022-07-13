public enum Player {

    NO_PLAYER(0, ' '),
    PLAYER_1 (1, 'x'),
    PLAYER_2 (2, 'o');

    final int num;
    final char symbol;

    Player(int num, char symbol) {
        this.num = num;
        this.symbol = symbol;
    }

    public static Player numToPlayer(int n) {
        return switch (n) {
            case 0 -> NO_PLAYER;
            case 1 -> PLAYER_1;
            case 2 -> PLAYER_2;
            default -> throw new IllegalArgumentException("Can't convert number " + n + " to player");
        };
    }

    public static Player getOpponent(Player player) {
        return switch (player) {
            case PLAYER_1 -> PLAYER_2;
            case PLAYER_2 -> PLAYER_1;
            default -> throw new IllegalArgumentException("There is no opponent to player " + player);
        };
    }
}
