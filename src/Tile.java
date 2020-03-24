/**
 * Class to create the domino tile object.
 *
 * @author Justin Lusby
 * @version 1.0
 * @date 1/26/19
 */
public class Tile {
    private int leftValue;
    private int rightValue;

    /**
     * Constructor for the tile object
     * @param leftValue left value of the tile
     * @param rightValue right value of the tile
     */
    public Tile(int leftValue, int rightValue){
        this.leftValue = leftValue;
        this.rightValue = rightValue;
    }

    /**
     * Swaps the values of this tile
     */
    public void flipTile(){
        int temp = leftValue;
        leftValue = rightValue;
        rightValue = temp;
    }
    /**
     * Method to return the left value of tile
     * @return leftValue
     */
    public int getLeftValue(){
        return leftValue;
    }

    /**
     * Method to return the right value of the tile
     * @return rightValue
     */
    public int getRightValue(){
        return rightValue;
    }
}