class Cell {
  private static int cellCount = 0;
  private final int id;
  private boolean visited;
  private Player p = null;

  public Cell() {
    id = ++cellCount;
    this.visited = false;
  }

  public void markVisited(Player p) {
    this.visited = true;
    this.p = p;
  }

  public boolean isVisited() {
    return this.visited;
  }

  public Player getPlayer() {
    return this.p;
  }

  @Override
  public String toString() {
    return p == null ? Integer.toString(id) : p.getPiece();
  }
}
