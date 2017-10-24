
/** This class models a Delek in the game. A Delek has
 *  a position and can advance towards the Doctor.
 */
public class Dalek {

    //Dalek's row and column
    private int row, col;
    //Whether or not the Dalek has crashed or not
    private boolean hasCrashed;

    /**
     * Initializes the variables for a Dalek.
     *
     * @param theRow The row this Dalek starts at.
     * @param theCol The column this Dalek starts at.
     */
    public Dalek(int theRow, int theCol) {
        //Set the Dalek's starting row and column
        this.row = theRow;
        this.col = theCol;
        //Every Dalek starts in a non-crashed state
        this.hasCrashed = false;
    }

    /**
     * Attempts to move the Dalek towards the Doctor by the most direct route,
     * moving up, down, right, left or diagonally. For example, if the Doctor is
     * above and to the right of a Dalek, it will move diagonally. If the Doctor
     * is directly below a Dalek, it will move down.
     *
     * @param doc The Doctor to move towards.
     */
    public void advanceTowards(Doctor doc) {
        //Dalek's algorithm to move towards the doctor
        if(doc.getRow() > this.row){
            this.row++;
        }else if(doc.getRow() < this.row){
            this.row--;
        }else{
            
        }if(doc.getCol() > this.col){
            this.col++;
        }else if(doc.getCol() < this.col){
            this.col--;
        }else{
            
        }
    }

    /**
     * Returns the row of this Dalek.
     *
     * @return This Dalek's row.
     */
    public int getRow() {
        return row;
    }

    /**
     * Returns the column of this Dalek.
     *
     * @return This Dalek's column.
     */
    public int getCol() {
        return col;
    }

    /**
     * Sets the Dalek to be in a crashed state.
     */
    public void crash() {
        //If the Dalek has crashed, then the variable puts the Dalek into a
        //crashed state
        this.hasCrashed = true;
    }

    /**
     * Returns whether or not this Dalek has crashed.
     *
     * @return true if this Dalek has crashed, false otherwise
     */
    public boolean hasCrashed() {
        if(this.hasCrashed == true){
            return true;
        }else{
            return false;
        }
    }

}
