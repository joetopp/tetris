import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 

class Tetris implements World {
  public static int WIDTH = 20, HEIGHT = 28;
  public static int SPEED = 40, FSPEED = 2; //In # of blocks //How many ticks do we wait in between moves?
  public int speed = SPEED;
  public int count = 0;
  public static int score = 0;
  public BSet set = new BSet();
  public Tetra curr = Utilities.makeRand();
  public void draw(Graphics g) { 
    set.draw(g);
    curr.draw(g);
    g.drawString("Score: " + score, WIDTH / 2, HEIGHT - 1);
  }

  public void update() {
    if(count >= speed) {
      curr.move();
      count = 0;
    } else {
      count++;
    }
    if(Utilities.checkTetra(curr, set)) {
        curr.undo();
        set.unify(curr.body);
        curr = Utilities.makeRand();
        set.removeRows(set.rowCheck());
    }
  }

  public boolean hasEnded() { return set.highest() <= 0; }

  public void keyPressed(KeyEvent e) { 
    int c = e.getKeyCode();
    switch(c) {
      case KeyEvent.VK_UP:    this.curr.rotate();
        if(Utilities.checkTetra(this.curr, set)) {
          curr.cwrotate();
      }break;
      case KeyEvent.VK_DOWN:  this.speed = Tetris.FSPEED; break;
      case KeyEvent.VK_LEFT: curr.moveLeft();
        if(Utilities.checkTetra(curr, set)) {
        curr.moveRight();
      } break;
      case KeyEvent.VK_RIGHT: curr.moveRight();
      if(Utilities.checkTetra(curr, set)) {
        curr.moveLeft();
      } break;
      default: break;
    }
  } 

   public void keyReleased(KeyEvent e) { 
    int c = e.getKeyCode();
    switch(c) {
      case KeyEvent.VK_DOWN:  this.speed = this.SPEED;  break;
      default: break;
    }
  }

  public static void main(String[] args) {
    World world = new Tetris();
    BigBang game = new BigBang(10, world); 
    JFrame frame = new JFrame("Tetris"); 
    frame.getContentPane().add( game ); 
    frame.addKeyListener( game ); 
    frame.setResizable(false);
    frame.setVisible(true); 
    frame.setSize(Tetris.WIDTH * Block.SIZE + (frame.getInsets().left + frame.getInsets().right), Tetris.HEIGHT * Block.SIZE + (frame.getInsets().top + frame.getInsets().bottom)); 
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); 
    game.start(); 
  }
}