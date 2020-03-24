public class Player {
    /**
     * Checks to see if a move is possible and where the move is made
     * @param index of tile
     * @param tray current players tray
     * @param board
     * @return
     */
    public static int checkMove(int index, Domino tray, Domino board){
        if (index < tray.getSize()) {
            if (board.getSize() == 0) {
                return 0;
            }

            if (board.checkTileRight(board.getSize() - 1) == tray.checkTileLeft(index)) {
                return 1;
            }

            if (board.checkTileLeft(0) == tray.checkTileRight(index)) {
                return 2;
            }

            //Check tiles on the left side of the board
            if (board.checkTileLeft(0) == tray.checkTileLeft(index)) {
                return 3;
            }

            //Check tiles on the right side of the board
            if (board.checkTileRight(board.getSize() - 1) == tray.checkTileRight(index)) {
                return 4;
            }
        }
        else Usage.printError(1);
        return 5;
    }

    /**
     * Check all moves to determine if any are possible
     * @param tray current players tray
     * @param board current board
     * @return 1 if no plays found else return 0
     */
    public static int checkAllMoves(Domino tray, Domino board){
        int miss = 0;
        for(int x = 0; x < tray.getSize(); x++){
            if(Player.checkMove(x, tray, board) == 5){
                miss++;
            }
        }
        if(miss < tray.getSize()){
            return 0;
        }
        else return 1;
    }

    /**
     * sets the index for the computers move
     * @param tray
     * @param board
     * @return
     */
    public static int setComputerMove(Domino tray, Domino board){
        for (int x = 0; x < tray.getSize(); x++) {
            if (Player.checkMove(x, tray, board) < 5) {
                return x;
            }
        }
        System.out.println("\nComputer plays");
        return 5;
    }

    /**
     * Makes the players move
     * @param x
     * @param tray
     * @param board
     * @return
     */
    public static int makeMove(int x, Domino tray, Domino board){
        //check the players move and act accordingly
        int outcome = Player.checkMove(x, tray, board);
        if (outcome == 0) {
            board.add(0, tray.removeTile(x));
            return 0;
        }
        if (outcome == 1) {
            board.add(board.getSize(), tray.removeTile(x));
            return 0;
        }
        if (outcome == 2) {
            board.add(0, tray.removeTile(x));
            return 0;
        }
        if (outcome == 3) {
            tray.getTile(x);
            board.add(0, tray.removeTile(x));
            return 0;
        }
        if (outcome == 4) {
            tray.getTile(x);
            board.add(board.getSize(), tray.removeTile(x));
            return 0;
        }
        return 1;
    }
}