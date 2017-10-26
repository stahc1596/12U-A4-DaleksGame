
/** This class models the Doctor in the game. A Doctor has
 *  a position and can move to a new position.
 */
public class Doctor {

    //Doctor's row and column
    private int row, col;
    /**
     * Initializes the variables for a Doctor.
     *
     * @param theRow The row this Doctor starts at.
     * @param theCol The column this Doctor starts at.
     */
    public Doctor(int theRow, int theCol) {
        //Set doctor's starting row and column
        this.row = theRow;
        this.col = theCol;
    }

    /**
     * Move the Doctor. If the player clicks on one of the squares immediately
     * surrounding the Doctor, the peg is moved to that location. Clicking on
     * the Doctor does not move the peg, but instead allows the Doctor to wait
     * in place for a turn. Clicking on any other square causes the Doctor to
     * teleport to a random square (perhaps by using a �sonic screwdriver�).
     * Teleportation is completely random.
     *
     * @param newRow The row the player clicked on.
     * @param newCol The column the player clicked on.
     */
    public void move(int newRow, int newCol) {
        //Doctor's alogrithm to how he moves relative to the players click
        //If the player clicks anywhere on the board that's not beside the doctor,
        //then the doctor teleports to a random location
        if(newRow - this.row > 1 || newRow - this.row < -1
                || newCol - this.col > 1 || newCol - this.col < -1){
            int RRow = (int)(Math.random()*12);
            int RCol = (int)(Math.random()*12);
            //If statement keeps the doctor from teleporting in place
            if(RRow != this.row || RCol != this.col){
                this.row = RRow;
                this.col = RCol;
            }
            //If the player clicks anywhere on the board that is beside the doctor,
            //then the doctor moves there
        }if(newRow - this.row == 1){
            this.row++;
        }else if(newRow - this.row == -1){
            this.row--;
        }else{
            
        }if(newCol - this.col == 1){
            this.col++;
        }else if(newCol - this.col == -1){
            this.col--;
        }else{
            
        }
    }

    /**
     * Returns the row of this Doctor.
     *
     * @return This Doctor's row.
     */
    public int getRow() {
        return row;
    }

    /**
     * Returns the column of this Doctor.
     *
     * @return This Doctor's column.
     */
    public int getCol() {
        return col;
    }

}
