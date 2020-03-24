/**
 * Class to print out instructions for usage as well as any error messages
 *
 *  * @author Justin Lusby
 *  * @version 1.0
 *  * @date 2/03/19
 */
public class Usage {
    /**
     * Displays instructions on how to play the game
     */
    public static void displayInfo(int message){
        if(message == 1){
            System.out.println("Welcome to Console based Dominoes.\n\tWould you like to play");
        }
        if(message == 2) {
            System.out.println("Congratulations you won!");
        }
        if(message == 3){
            System.out.println("Sorry you lost, the computer won.");
        }
        if(message == 4){
            System.out.println("No possible moves, enter number to pick up a tile");
        }
    }

    /**
     * Displays any error messages if incorrect input is detected.
     */
    public static void printError(int error){
        if(error == 1){
            System.out.println("invalid move, please try again");
        }
        if(error == 2){
            System.out.println("BoneYard is Empty");
        }
    }

    /**
     * Prints out the current state of the board
     */
    public static void printBoard(Domino board, Domino humanTray, Domino computerTray){
        System.out.print("Computer tray");
        computerTray.printYard(0);
        System.out.println("\n");

        System.out.print("Current board state");
        board.printYard(1);
        System.out.println("\n\n");

        System.out.print("Your tray of tiles\nChoose which to play");
        humanTray.printYard(1);
    }
}