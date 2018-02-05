import java.awt.Graphics;
import java.util.ArrayList;

public class BSet extends ArrayList<Block> {

  public BSet(Block b1, Block b2, Block b3, Block b4) {
    this.add(b1);
    this.add(b2);
    this.add(b3);
    this.add(b4);
  }

  public BSet() {  }

  void draw(Graphics g) {
    for (Block b : this) {
      b.draw(g);
    }
  }

  void unify(BSet other) {
    for (Block b : other) {
      this.add(b);
    }
  }

  BSet intersect(BSet other) {
    BSet result = new BSet();
    for (Block b : other) {
      for(Block a : this) {
        if(a.equals(b)) {
          result.add(a);
        }
      }
    }
    return result;
  }

  int lowest() {
    int low = 0; 
    for (Block b : this) {
      if(b.y > low) {
        low = b.y;
      }
    }
    return low;
  }

  int highest() {
    int high = Tetris.HEIGHT;
    for (Block b: this) {
      if(b.y < high) {
        high = b.y;
      }
    }
    return high;
  }

  int leftest() {
    int left = Tetris.WIDTH;
    for (Block b: this) {
      if (b.x < left) {
        left = b.x;
      }
    }
    return left;
  }

  int rightest() {
    int right = 0;
    for (Block b: this) {
      if(b.x > right) {
        right = b.x;
      }
    }
    return right;
  }

  BSet getRow(int row) {
    BSet result = new BSet();
    for (Block b: this) {
      if (b.y == row) {
        result.add(b);
      }
    }
    return result;
  }
  
  ArrayList<BSet> rowCheck() {
    ArrayList<BSet> result = new ArrayList<>();
    for(int i = 0; i < Tetris.HEIGHT; i++) {
      BSet row = getRow(i);
      if(row.size() == Tetris.WIDTH) {
        result.add(row);
      }
    }
    return result;
  }
    
    void removeRows(ArrayList<BSet> list) {
      for(BSet r : list) {
        for(Block b : r) {
          this.remove(b);
        }
        for(Block b : this) {
          if(b.y < r.get(1).y) {
            b.y = b.y + 1;
          }
        }
        Tetris.SPEED = Tetris.SPEED - 2;
        Tetris.score++;
      }
    }
}