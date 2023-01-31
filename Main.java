import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Grab the pellets as fast as you can!
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt(); // size of the grid
        int height = in.nextInt(); // top left corner is (x=0, y=0)
        String[][] b = new String[width][height];
        Board board;
        String coords0 = "";
        String coords1 = "";
        String coords2 = "";
        String coords3 = "";
        String coords4 = "";
        if (in.hasNextLine()) {
            in.nextLine();
        }

        //TODO change to fill 2D array for BOARD object
        // for (int i = 0; i < height; i++) {
        //     String row = in.nextLine(); // one line of the grid: space " " is floor, pound "#" is wall
        // }
        for (int i = 0; i < width; i++) {
            String row = in.nextLine();
            for (int j = 0; j < height; j++) {
                b[i][j] = Character.toString(row.charAt(j));
            }
        }
        board = new Board(b);

        // game loop
        while (true) {
            int myScore = in.nextInt();
            int opponentScore = in.nextInt();
            int visiblePacCount = in.nextInt(); // all your pacs and enemy pacs in sight
            int myPacs = 0;
            for (int i = 0; i < visiblePacCount; i++) {
                int pacId = in.nextInt(); // pac number (unique within a team)
                boolean mine = in.nextInt() != 0; // true if this pac is yours
                if(mine)
                    myPacs++;
                    int x = in.nextInt(); // position in the grid
                    int y = in.nextInt(); // position in the grid
                if(!mine){
                    x = in.nextInt(); // position in the grid
                    y = in.nextInt(); // position in the grid

                    //TODO create pac objects
                    // if (pacObj.enemyDetect(x, y)) {
                    //     pacObj.enemyEncounter(x, y);
                    // }
                }
                    

                
                String typeId = in.next(); // unused in wood leagues
                int speedTurnsLeft = in.nextInt(); // unused in wood leagues
                int abilityCooldown = in.nextInt(); // unused in wood leagues
            }
            int visiblePelletCount = in.nextInt(); // all pellets in sight


            //TODO change to fill board state(x and y to array indicies)
            for (int i = 0; i < visiblePelletCount; i++) {
                int x = in.nextInt();
                int y = in.nextInt();
                int value = in.nextInt(); // amount of points this pellet is worth
                //TODO move and change to be in defaultMove in Pac class
                // if(i == 0)
                //     coords1 = "MOVE 1 " + x + " " + y;
                // if(myPacs == 3){
                //     if(i == visiblePelletCount / 2)
                //         coords2 = "MOVE 2 " + x + " " + y;
                // } else if(myPacs == 4){
                //     if(i == visiblePelletCount / 3)
                //         coords2 = "MOVE 2 " + x + " " + y;
                //     if(i == 2* visiblePelletCount / 3)
                //         coords3 = "MOVE 3 " + x + " " + y;
                // } else if(myPacs == 5){
                //     if(i == visiblePelletCount / 4)
                //         coords2 = "MOVE 2 " + x + " " + y;
                //     if(i == visiblePelletCount / 2)
                //         coords3 = "MOVE 3 " + x + " " + y;
                //     if(i == 3 * visiblePelletCount / 4)
                //         coords4 = "MOVE 4 " + x + " " + y;
                // }
                // coords0 = "MOVE 0 " + x + " " + y;
                
            }

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            //pacObj.getMove() + " | " + etc...
            System.out.println(coords0 + " | " + coords1 + " | " + coords2 + " | " + coords3 + " | " + coords4); // MOVE <pacId> <x> <y>
        }
    }

    

}

/*
 * intakes: coordinates of the pac(only for ally pacs)
 * will use enemy pac coordinates for enemyDetect, from main method
 */
class Pac {

    // "MOVE " + id
    String id;
    String moveX;
    String moveY;
    // id + moveX + moveY
    String move;
    // hunter = true; collector = false
    boolean hunter;

    Board board;

    int x;
    int y;

    public Pac(int x, int y, Board board) {
        this.x = x; 
        this.y = y;
        this.board = board;
    }

    public String getMove() {
        return move;
    }
    
    /*
     * prioritize big pellets(search board for biggest value and closeness?)
     * if visiblePellet > 0, go to pellet
     * else, refer to board object
     */
    public String defaultMove(Board board) {
        int bx;
        int by;
        int distance = 10000;

        //search for closest big pellet
        for (int i = 0; i < board.getBoard().length; i++) {
            for (int j = 0; j < board.getBoard()[i].length; j++) {
                if (board.getBoard()[i][j] == "10" && distance > i + j) {
                    bx = i;
                    by = j;
                    distance = bx + by;
                }
            }
        }
        //bx and by are coordinates of the closest big pellet

        //TODO
        return "";
    }

    /* 
     * check in 5x5 square around current pac to see if there are enemy pacs
     * intakes board state
     * look to see if mine variable returns false
     */
    public void enemyDetect(int ox, int oy) {
        //TODO
        int UpperX = 0;
        int LowerX = 0;
        int UpperY = 0;
        int LowerY = 0;

        if (x + 2 > board.getBoard().length) {
            UpperX = board.getBoard().length;
        }
        if (x - 2 < 0) {
            LowerX = 0;
        }
        if (y + 2 > board.getBoard()[0].length) {
            LowerY = board.getBoard()[0].length;
        }
        if (y - 2 < 0) {
            UpperY = 0;
        }

        if (LowerX < ox && UpperX > ox && LowerY < oy && UpperY > oy) {
            enemyEncounter(ox, oy);
        }
    }

    /*
     * decides action taken when encountering enemy pacman
     * if this pac is hunter, change to correct shape and chase enemy pac
     * if pac is collector, avoid enemy pac
     */
    public void enemyEncounter(int ox, int oy) {
        //TODO
        if (hunter) {
            //hunt

        }
        else {
            // if (going towards enemy) {
            //     move away from enemy (and use speed?)
            // }

            if (!(ox > x) && !board.getBoard()[x+1][y].equals("#")) {
                moveX = Integer.toString(x+1);
            }
            else if (!(ox < x) && !board.getBoard()[x-1][y].equals("#")) {
                moveX = Integer.toString(x-1);
            }
            else if (!board.getBoard()[x][y+1].equals("#")) {
                moveY = Integer.toString(y+1);
            }
            else {
                moveY = Integer.toString(y-1);
            }

            if (!(oy > y) && !board.getBoard()[x][y+1].equals("#")) {
                moveY = Integer.toString(y+1);
            }
            else if (!(oy < y) && !board.getBoard()[x][y-1].equals("#")) {
                moveY = Integer.toString(y-1);
            }
            else if (!board.getBoard()[x+1][y].equals("#")) {
                moveX = Integer.toString(x+1);
            }
            else {
                moveX = Integer.toString(x-1);
            }
        }
    }
}

class Board {
    String[][] board;
    public Board(String[][] board) {
        this.board = board;
    }

    public String[][] getBoard() {
        return board;
    }

    //update board based on pac vision?
    public void updateBoard() {

    }
}