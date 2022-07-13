public class Main {
    public static void main(String[] args) {
        System.out.println("Tic-Pruned-Java - by BUCKFAE");


        while (true) {

            Player player = Player.PLAYER_1;
            Board board = new Board();

            while (true) {

                Point nextMove = Agent.getNextMove(board, player);

                System.out.println("Move: " + nextMove);

                board.setValue(nextMove, player);
                System.out.println(board.getBoardString());

                Player winner = board.getWinner();

                // Game is over
                if (winner != Player.NO_PLAYER || board.getEmptySpots().size() == 0) {
                    assert winner == Player.NO_PLAYER;
                    break;
                }

                player = Player.getOpponent(player);

            }
        }

    }
}