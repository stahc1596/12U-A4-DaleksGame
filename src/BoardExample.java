
import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author stahc1596
 */
public class BoardExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Board b = new Board(8, 8);
        b.putPeg(Color.green, 3, 5);
        b.putPeg(Color.blue, 1, 2);
        b.removePeg(3, 5);
        b.displayMessage("Hello everyone!");
        while(true){
            Coordinate click = b.getClick();
            int clickRow = click.getRow();
            int clickCol = click.getCol();
            b.putPeg(Color.black, clickRow, clickCol);
        }
    }
}
