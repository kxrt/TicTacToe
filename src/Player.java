class Player {
  private final String piece;

  public Player(int index) {
    if (index == 1) {
      piece = "o";
    } else {
      piece = "x";
    }
  }

  public boolean place(Board b, int index) {
    return b.place(this, index);
  }

  public String getPiece() {
    return piece;
  }

  @Override
  public String toString() {
    return piece.equals("o") ? "P1" : "P2";
  }
}
