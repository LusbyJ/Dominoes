/**
 * Main game loop to control the game.
 * Entry point for the program
 *
 * @author Justin Lusby
 * @version 1.0
 * @date 1/26/19
 */

import java.util.Scanner;

public class GameManager{
    private Domino humanTray;
    private Domino computerTray;
    private Domino board;
    private Domino boneYard;
    private int isPlaying;
    public static Scanner input = new Scanner(System.in);
    private int player;  //keeps track of current player

    /**
     * Sets up and initializes the game,
     * creates the Domino object for each list of dominoes
     * fills the boneyard and shuffles the tiles
     */
    public void setUp() {
        boneYard = new Domino();
        board = new Domino();
        humanTray = new Domino();
        computerTray = new Domino();

        //Fill the boneYard with tiles
        int index = 0;
        for (int x = 0; x < 7; x++) {
            for (int y = 0; y < 7; y++) {
                if (y >= x) {
                    Tile tile = new Tile(x, y);
                    boneYard.add(index, tile);
                    index++;
                }
            }
        }
        boneYard.shuffle();
        dealTiles();
        String i = input.next();
        if (i.equals("yes")) startGame();
        else System.out.println("Goodbye");
    }

    /**
     * Deals the tiles to the players trays
     */
    public void dealTiles(){
        for(int x = 0; x < 7; x++){
            humanTray.add(0, boneYard.removeTile(x));
            computerTray.add(0, boneYard.removeTile(x));
        }
        player = 0;
        isPlaying = 1;
    }

    /**
     * Main game loop for the program
     */
    public void startGame() {
        while (isPlaying == 1) {
            int i;
            Usage.printBoard(board, humanTray, computerTray);
            //play initiates with human player = 0
            if (player % 2 == 0) {
                if (Player.checkAllMoves(humanTray, board) == 1){
                    System.out.println();
                    Usage.displayInfo(4);
                    int pickUp = input.nextInt();
                    humanTray.add(0, boneYard.removeTile(pickUp));
                }
                else {
                    //get next integer input to indicate the tile to be played
                    i = input.nextInt();
                    if(i < humanTray.getSize()) {
                        if (Player.makeMove(i, humanTray, board) == 0) player += 1;
                    }
                    else Usage.printError(1);
                }
            }

            //Check computer tiles and set first playable
            if (player % 2 != 0) {
                if (Player.checkAllMoves(computerTray, board) == 1) {
                    computerTray.add(0, boneYard.removeTile(0));
                }
                else{
                    i = Player.setComputerMove(computerTray, board);
                    if(Player.makeMove(i, computerTray, board) == 0) player += 1;
                }
            }
            //if either players tray is empty, show message and end
            if (computerTray.getSize() == 0) {
                Usage.displayInfo(3);
                isPlaying = 0;
            }
            if (humanTray.getSize() == 0) {
                Usage.displayInfo(2);
                isPlaying = 0;
            }
            if(boneYard.getSize() == 0){
                Usage.printError(2);
                isPlaying = 0;
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        Usage.displayInfo(1);
        new GameManager().setUp();
    }

}
