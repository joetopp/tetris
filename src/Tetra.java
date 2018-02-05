import java.awt.Graphics;

public class Tetra {
  private Point center;
  BSet body;

  public Tetra(Point p, BSet b) {
    this.center = p;
    this.body = b;
  }

  public void rotate() {
    for (Block b : body) {
      b.rotate(center);
    }
  }

  public void cwrotate() {
    this.rotate();
    this.rotate();
    this.rotate();
  }
  
  public void moveLeft() {
    center.x = center.x - 1;
    for (Block b: body) {
      b.x = b.x - 1;
    }
  }
  
   public void moveRight() {
    center.x = center.x + 1;
    for (Block b: body) {
      b.x = b.x + 1;
    }
  }
   
  public void move() {
    center.y = center.y + 1;
    for (Block b : body) {
      b.y = b.y + 1;
    }
  }

  public void undo() {
    center.y = center.y - 1;
    for (Block b: body) {
      b.y = b.y - 1;
    }
  }

  public void draw(Graphics g) {
    this.body.draw(g);
  }
}