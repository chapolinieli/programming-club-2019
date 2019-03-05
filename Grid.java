/*
 * Kunseok Lee
 */

import java.util.Scanner;

public class Grid {

    private int size;
    private int[] position = new int[2];
    private int[] goal = new int[2];
    private int count;

    public Grid(int size, int x1, int y1, int x2, int y2) { // n is both the number of rows and columns of dominoes.
        this.size = size;
        position[0] = x1;
        position[1] = y1;
        goal[0] = x2;
        goal[1] = y2;
        count = 0;
    }


    /* generates possible moves (3 moves possible from any point) from current position.
     * the point can move right, left, and either one of up or down.
     */
    private int[] possibleMoves() {
        int[] pm = new int[6]; //pm[0] = x pos of possible move 1, pm[1] = y pos of possible move 1, pm[2] = x pos of possible move 2, etc.
        int x = position[0];
        int y = position[1];
        int c = x%2 + y%2; //value used to determine whether point can move up or down
        pm[0] = x+1;
        pm[1] = y;
        pm[2] = x-1;
        pm[3] = y;
        if (c%2 == 0) {
            pm[4] = x;
            pm[5] = y+1;
        }
        else {
            pm[4] = x;
            pm[5] = y-1;
        }
        return pm;
    }

    private int[] correctMove() { //determines which of the possible moves is correct, i.e, which move takes it closest to the goal.
        int[] pm = possibleMoves();
        int[] cm = new int[2]; //cm[0] = x pos of correct move, cm[1] = y pos of correct move.
        int a,b;
        a = Math.abs(goal[0] - pm[0]) + Math.abs(goal[1] - pm[1]); //sum of difference of x and y values for possible move to the right or left
        b = Math.abs(goal[0] - pm[2]) + Math.abs(goal[1]- pm[3]);


        if (Math.abs(pm[5] - goal[1]) < Math.abs(position[1] - goal[1])) { //checks if moving it up/down brings it closer to goal. if it does, then it is the correct move.
            cm[0] = pm[4];
            cm[1] = pm[5];
        }
        else if (a <= b) { //if the sum of differences of a is less than b, then a is the correct move
            cm[0] = pm[0];
            cm[1] = pm[1];
        }
        else {
            cm[0] = pm[2];
            cm[1] = pm[3];
        }
        return cm;
    }

    private boolean finish() { //returns true if position = goal
        return position[0] == goal[0] && position[1] == goal[1] ;
    }

    private void moveOnce() { //moves once in the correct direction and increments count
        int[] cm = correctMove();
        position[0] = cm[0];
        position[1] = cm[1];
        count++;
    }

    public int solve() { //solves and returns count, the distance.
        while (!finish())
            moveOnce();
        return count;
    }



    public static void main (String[] args) {

        Scanner scan = new Scanner(System.in);

        //System.out.println("Enter the number of test cases: ");
        int testCases = scan.nextInt();

        while (testCases !=0) {
            // System.out.println("Enter the number of dominoes in each row and column: ");
            int size = scan.nextInt();
            // System.out.println("Enter x1:");
            int x1 = scan.nextInt();
            // System.out.println("Enter y1:");
            int y1 = scan.nextInt();
            // System.out.println("Enter x2:");
            int x2 = scan.nextInt();
            //   System.out.println("Enter y2:");
            int y2 = scan.nextInt();

            Grid grid = new Grid(size, x1, y1, x2, y2);
            System.out.println("Output: " + grid.solve());
            testCases--;
        }




    }


}
