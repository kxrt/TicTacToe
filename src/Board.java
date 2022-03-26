class Board {
  private final Cell[] board;

  private final int[][] check = {
      {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // columns
      {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // rows
      {0, 4, 7}, {2, 4, 6}             // diagonals
  };

  private boolean playable;
  private Player winner;
  private int placed;

  public Board() {
    board = new Cell[9];
    for (int i = 0; i < 9; i++) {
      board[i] = new Cell();
    }

    playable = true;
    winner = null;
    placed = 0;
  }

  public boolean place(Player p, int index) {
    if (!this.playable || this.board[index - 1].isVisited()) {
      return false;
    }

    this.board[index - 1].markVisited(p);
    this.placed++;

    if (this.placed == 9) {
      this.playable = false;
    }

    for (int[] cells : check) {
      if (this.board[cells[0]].getPlayer() != null &&
          this.board[cells[0]].getPlayer() ==
          this.board[cells[1]].getPlayer() &&
          this.board[cells[1]].getPlayer() ==
              this.board[cells[2]].getPlayer()) {
        this.winner = board[cells[0]].getPlayer();
        this.playable = false;
      }
    }
    return true;
  }

  public boolean isPlayable() {
    return this.playable;
  }

  public Player getWinner() {
    return this.winner;
  }

  @Override
  public String toString() {
    StringBuilder board = new StringBuilder("|");
    for (Cell c : this.board) {
      board.append(c.toString()).append("|");
    }
    return board.substring(0, 7) + "\n|" +
           board.substring(7, 13) + "\n|" +
           board.substring(13);
  }
}
