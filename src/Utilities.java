import java.awt.*;
import java.util.Random;

public class Utilities {
  
  //This class is used to store the methods that make the different shapes. Each shape starts just above the top, in the middle
  
  public static boolean checkTetra(Tetra t, BSet set) { //Returns true if the given tetra is in an invalid position
    boolean floor, left, right, collide;
    collide = (t.body.intersect(set).size() != 0); //true if the tetra intersects the BSet
    left = (t.body.leftest() < 0); //true if the leftest is furhter left than the side
    right = (t.body.rightest() > Tetris.WIDTH - 1); //true if the rightest is further right than the side
    floor = (t.body.lowest() > Tetris.HEIGHT - 1); //true if it's too far down
    return collide || left || right || floor;
  }
    
    
  static Tetra makeRand() {
    Random rand = new Random();
    int x = rand.nextInt(7);
    Tetra result;
    switch (x) {
      case 0: result = makeLine();
              break;
      case 1: result = makeSquare();
              break;
      case 2: result = makeLDog();
              break;
      case 3: result = makeRDog();
              break;
      case 4: result = makeL();
              break;
      case 5: result = makeBackL();
              break;
      case 6: result = makeT();
              break;
      default: result = makeSquare();
    }
    return result;
  }
  static Tetra makeLine() {
    return new Tetra(new Point(Tetris.WIDTH / 2, 1),
                     new BSet(new Block((Tetris.WIDTH / 2) - 1, 1, Color.ORANGE),
                              new Block((Tetris.WIDTH / 2)    , 1, Color.ORANGE),
                              new Block((Tetris.WIDTH / 2) + 1, 1, Color.ORANGE),
                              new Block((Tetris.WIDTH / 2) + 2, 1, Color.ORANGE)));}
  
  static Tetra makeSquare() {
    return new Tetra(new Point(Tetris.WIDTH / 2, 1),
                     new BSet(new Block((Tetris.WIDTH / 2) + 1, 1, Color.RED),
                              new Block((Tetris.WIDTH / 2)    , 1, Color.RED),
                              new Block((Tetris.WIDTH / 2) + 1, 0, Color.RED),
                              new Block((Tetris.WIDTH / 2)    , 0, Color.RED)));}
  
  static Tetra makeLDog() {
    return new Tetra(new Point(Tetris.WIDTH / 2, 1),
                     new BSet(new Block((Tetris.WIDTH / 2) - 1, 1, Color.BLUE),
                              new Block((Tetris.WIDTH / 2)    , 1, Color.BLUE),
                              new Block((Tetris.WIDTH / 2)    , 0, Color.BLUE),
                              new Block((Tetris.WIDTH / 2) + 1, 0, Color.BLUE)));}
  
  static Tetra makeRDog() {
    return new Tetra(new Point(Tetris.WIDTH / 2, 1),
                     new BSet(new Block((Tetris.WIDTH / 2) - 1, 0, Color.YELLOW),
                              new Block((Tetris.WIDTH / 2)    , 1, Color.YELLOW),
                              new Block((Tetris.WIDTH / 2)    , 0, Color.YELLOW),
                              new Block((Tetris.WIDTH / 2) + 1, 1, Color.YELLOW)));}
  
  static Tetra makeL() {
    return new Tetra(new Point(Tetris.WIDTH / 2, 1),
                     new BSet(new Block((Tetris.WIDTH / 2)    , 2, Color.GREEN),
                              new Block((Tetris.WIDTH / 2)    , 1, Color.GREEN),
                              new Block((Tetris.WIDTH / 2)    , 0, Color.GREEN),
                              new Block((Tetris.WIDTH / 2) + 1, 0, Color.GREEN)));}
    
  static Tetra makeBackL() {
    return new Tetra(new Point(Tetris.WIDTH / 2, 1),
                     new BSet(new Block((Tetris.WIDTH / 2)    , 2, Color.PINK),
                              new Block((Tetris.WIDTH / 2)    , 1, Color.PINK),
                              new Block((Tetris.WIDTH / 2)    , 0, Color.PINK),
                              new Block((Tetris.WIDTH / 2) - 1, 0, Color.PINK)));}
      
  static Tetra makeT() {
    return new Tetra(new Point(Tetris.WIDTH / 2, 1),
                     new BSet(new Block((Tetris.WIDTH / 2) - 1, 1, Color.CYAN),
                              new Block((Tetris.WIDTH / 2)    , 1, Color.CYAN),
                              new Block((Tetris.WIDTH / 2) + 1, 1, Color.CYAN),
                              new Block((Tetris.WIDTH / 2)    , 2, Color.CYAN)));}
  
}
  