import java.awt.Color;
import java.awt.Graphics;

public class Block {
  int x, y;
  static int SIZE = 30;
  private Color c;

  public Block (int x, int y, Color c) {
    this.x = x;
    this.y = y;
    this.c = c;
  }

  public void rotate(Point p) {
    int dy = this.y - p.y;
    int dx = this.x - p.x;
    this.x = p.x + dy;
    this.y = p.y - dx;
  }

  public void draw(Graphics g) {
    int px = this.x * SIZE; //The leftmost column is 0
    int py = this.y * SIZE;
    g.setColor(this.c);
    g.fill3DRect(px, py, SIZE, SIZE, true);
    g.setColor(Color.BLACK);
    g.drawRect(px, py, SIZE, SIZE);
  }

  public boolean equals(Block other) {
    return this.x == other.x && this.y == other.y;
  }

  public String toString() {
    return "x: " + this.x + ", y: " + this.y;
  }
}