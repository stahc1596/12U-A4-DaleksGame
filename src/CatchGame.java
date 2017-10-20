
import java.awt.Color;




/** This class manages the interactions between the different pieces of
 *  the game: the Board, the Daleks, and the Doctor. It determines when
 *  the game is over and whether the Doctor won or lost.
 */
public class CatchGame {

    /**
     * Instance variables go up here
     * Make sure to create a Board, 3 Daleks, and a Doctor
     */
    private Dalek[] dalek;
    private boolean alive;
    private Doctor doc;
    private Board b;

    /**
     * The constructor for the game. 
     * Use it to initialize your game variables.
     * (create people, set positions, etc.)
     */
    public CatchGame(){
        this.alive = true;
        Board b = new Board(12, 12);
        Doctor doc = new Doctor((int)(Math.random()*12), (int)(Math.random()*12));
        b.putPeg(Color.green, doc.getRow(), doc.getCol());
        this.dalek = new Dalek[3];
        for(int i = 0; i < 3; i++){
            Dalek c = new Dalek((int)(Math.random()*12), (int)(Math.random()*12));
            this.dalek[i] = c;
            b.putPeg(Color.black, dalek[i].getRow(), dalek[i].getCol());
        }        
    }
    
    /**
     * The playGame method begins and controls a game: deals with when the user
     * selects a square, when the Daleks move, when the game is won/lost.
     */
    public void playGame() {
        while(alive){
            for(int i = 0; i < 3; i++){
                if(dalek[i].hasCrashed() == false){
                    dalek[i].advanceTowards(doc);
                }
            }
            Coordinate click = b.getClick();
            int clickRow = click.getRow();
            int clickCol = click.getCol();
        }
    }

}
