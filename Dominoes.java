
// package programmingclub;

/**
 *
 * @author chapo
 */
public class Dominoes {
    
    public static void main(String[] args){
        // test case: should produce output 7
        System.out.println(findPath(40, 9, 7, 3, 6));
    }
    
    // this solution is not yet implemented
    // but may be a good starting point for writing in a correct solution
    
    public static int findPath(int row, int x1, int y1, int x2, int y2){
        int xdiff = Math.abs(x1 - x2);
        int ydiff = Math.abs(y1 - y2);
        
        System.out.println("XDIFF: " + xdiff + " YDIFF: " + ydiff);
        
        // logic here to produce correct output
        
        // ideas: check to see if xdiff and ydiff are odd or even
        return -1;
        }
    
    }
    
