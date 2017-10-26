
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
    //Array of three Dalek's
    private Dalek[] dalek;
    //Variable to keep track of whether the doctor is caught or not
    private boolean alive = true;
    //Doctor variable
    private Doctor doc = new Doctor((int)(Math.random()*12), (int)(Math.random()*12));
    //Board variable
    private Board b = new Board(12, 12);
    //Variable to keep track of whether or not there are any live Dalek's left
    private boolean enemy = true;

    /**
     * The constructor for the game. 
     * Use it to initialize your game variables.
     * (create people, set positions, etc.)
     */
    public CatchGame(){
        //Put a peg where the doctor spawned
        b.putPeg(Color.green, doc.getRow(), doc.getCol());
        //Create all three Dalek's and where they spawn
        this.dalek = new Dalek[3];
        for(int i = 0; i < 3; i++){
            Dalek c = new Dalek((int)(Math.random()*12), (int)(Math.random()*12));
            this.dalek[i] = c;
            //If a Dalek spawns on the doctor, the Dalek is moved to a different
            //location
            if(dalek[i].getRow() == doc.getRow() && dalek[i].getCol() == doc.getCol()){
                dalek[i] = new Dalek((int)(Math.random()*12), (int)(Math.random()*12));
            }
            //Put a peg where the Dalek's spawn
            b.putPeg(Color.black, dalek[i].getRow(), dalek[i].getCol());
        }        
    }
    
    /**
     * The playGame method begins and controls a game: deals with when the user
     * selects a square, when the Daleks move, when the game is won/lost.
     */
    public void playGame() {
        //While the doctor and the Dalek's are alive, the game will play
        while(alive && enemy){
            //Doctor clicks where he wants to go
            Coordinate click = b.getClick();
            int clickRow = click.getRow();
            int clickCol = click.getCol();
            //Doctor moves to where he clicks or teleports depending on where
            //on the board he clicks
            b.removePeg(doc.getRow(), doc.getCol());
            doc.move(clickRow, clickCol);
            b.putPeg(Color.green, doc.getRow(), doc.getCol());
            //Dalek's move in on the doctor
            for(int i = 0; i < 3; i++){
                //If the Dalek has crashed, he cannot move to the doctor
                if(!dalek[i].hasCrashed()){
                    //The Dalek moves one step closer to the doctor
                    b.removePeg(dalek[i].getRow(), dalek[i].getCol());
                    dalek[i].advanceTowards(doc);
                    //Fixes a bug where Dalek's disappear when going into a position
                    //another Dalek was just at
                    for(int n = 0; n < 3; n++){
                        b.putPeg(Color.black, dalek[n].getRow(), dalek[n].getCol());
                    }
                }
                //If a Dalek catches the doctor, then the doctor dies and the
                //Dalek's win
                if(doc.getRow() == dalek[i].getRow() && doc.getCol() == dalek[i].getCol()){
                    alive = false;
                    b.displayMessage("You Lose! Try again?");
                }
                //If statements are used to check to see if any Dalek's crash
                //into each other
            }if(dalek[2].getRow() == dalek[1].getRow()
                    && dalek[2].getCol() == dalek[1].getCol()){
                //Set both Dalek's into a crashed state
                dalek[2].crash();
                dalek[1].crash();
                //Replace a red peg to show that two or more Dalek's crashed here
                b.putPeg(Color.red, dalek[1].getRow(), dalek[1].getCol());
            }if(dalek[2].getRow() == dalek[0].getRow()
                    && dalek[2].getCol() == dalek[0].getCol()){
                //Set both Dalek's into a crashed state
                dalek[2].crash();
                dalek[0].crash();
                //Replace a red peg to show that two or more Dalek's crashed here
                b.putPeg(Color.red, dalek[0].getRow(), dalek[0].getCol());
            }if(dalek[0].getRow() == dalek[1].getRow()
                    && dalek[0].getCol() == dalek[1].getCol()){
                //Set both Dalek's into a crashed state
                dalek[0].crash();
                dalek[1].crash();
                //Replace a red peg to show that two or more Dalek's crashed here
                b.putPeg(Color.red, dalek[1].getRow(), dalek[1].getCol());
                //If every Dalek has crashed, then the doctor wins the game
            }if(dalek[1].hasCrashed() && dalek[2].hasCrashed() && dalek[0].hasCrashed()
                    && alive){
                enemy = false;
                b.displayMessage("You Win!");
            }
        }
    }

}
