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
        String coords0 = "";
        String coords1 = "";
        String coords2 = "";
        String coords3 = "";
        String coords4 = "";
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < height; i++) {
            String row = in.nextLine(); // one line of the grid: space " " is floor, pound "#" is wall
        }

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
                String typeId = in.next(); // unused in wood leagues
                int speedTurnsLeft = in.nextInt(); // unused in wood leagues
                int abilityCooldown = in.nextInt(); // unused in wood leagues
            }
            int visiblePelletCount = in.nextInt(); // all pellets in sight

            for (int i = 0; i < visiblePelletCount; i++) {
                int x = in.nextInt();
                int y = in.nextInt();
                if(i == 0)
                    coords1 = "MOVE 1 " + x + " " + y;
                if(myPacs == 3){
                    if(i == visiblePelletCount / 2)
                        coords2 = "MOVE 2 " + x + " " + y;
                } else if(myPacs == 4){
                    if(i == visiblePelletCount / 3)
                        coords2 = "MOVE 2 " + x + " " + y;
                    if(i == 2* visiblePelletCount / 3)
                        coords3 = "MOVE 3 " + x + " " + y;
                } else if(myPacs == 5){
                    if(i == visiblePelletCount / 4)
                        coords2 = "MOVE 2 " + x + " " + y;
                    if(i == visiblePelletCount / 2)
                        coords3 = "MOVE 3 " + x + " " + y;
                    if(i == 3 * visiblePelletCount / 4)
                        coords4 = "MOVE 4 " + x + " " + y;
                }
                coords0 = "MOVE 0 " + x + " " + y;
                int value = in.nextInt(); // amount of points this pellet is worth
            }

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            
            System.out.println(coords0 + " | " + coords1 + " | " + coords2 + " | " + coords3 + " | " + coords4); // MOVE <pacId> <x> <y>
        }
    }
}