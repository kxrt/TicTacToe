public class TicTacToe {
  private final Board board;
  private final Player p1, p2;
  private Player current;
  private boolean firstMsg = true;

  public TicTacToe() {
    board = new Board();
    p1 = new Player(1);
    p2 = new Player(2);
    current = p1;
  }

  public String play(int index) {
    if (!board.isPlayable()) {
      return "The game is over!";
    } else if (index < 1 || index > 9) {
      return "This is not a playable move!";
    }
    boolean move = current.place(board, index);
    if (!move) {
      return "This is not a playable move!";
    }
    if (current == p1) {
      current = p2;
    } else {
      current = p1;
    }
    return this.toString();
  }

  @Override
  public String toString() {
    String boardStr = board + "\n" + current + "'s turn! Marker: " + current.getPiece();
    if (firstMsg) {
      firstMsg = false;
      return "Welcome to TicTacToe! \n" + boardStr;
    }
    else if (!board.isPlayable()) {
      Player p = board.getWinner();
      if (p == null) {
        return "The game has ended in a draw.";
      } else {
        return board + "\n" + p + " has won the game.";
      }
    } else {
      return boardStr;
    }
  }
}
