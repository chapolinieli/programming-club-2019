
package programmingclub;

/**
 *
 * @author chapo
 */
public class Dominoes {
    
    public static void main(String[] args){
        // test case: should produce output 7
        System.out.println(findPath(20, 2, 12, 2, 3) + " expected output: 19");
        
        System.out.println(findPath(25, 1, 9, 5, 5) + " expected output: 8");
        System.out.println(findPath(40, 9, 7, 3, 6) + " expected output: 7");
        System.out.println(findPath(30, 7, 8, 4, 2) + " expected output: 11");
        System.out.println(findPath(20, 1, 18, 3, 20));
        
        
        
    }
    

    
    public static int findPath(int row, int x1, int y1, int x2, int y2){
        // recursively count path from x to y
        int xpath = findXPath(row, x1, y1, x2, y2);
        int ypath = findYPath(row, x1, y1, x2, y2);
        
        //offset - this counting method double counts x coordinate moves
        // so we find number of double counted x moves and subtract
        int xoffset = (ypath + 2) / 3;
        if(xpath > 0){
            // additional offset depending on which row we start on
            // assuming we move from a higher location to a lower one
            if(y1 > y2)
                return xpath + ypath - xoffset - y2 % 2;
            else
                return xpath + ypath - xoffset - y1 % 2;
            }
        else
            return ypath + 1;
    
    }
    public static int findYPath(int row, int x1, int y1, int x2, int y2){
        int xdiff = Math.abs(x1 - x2);
        int ydiff = Math.abs(y1 - y2);
        
        if(y1 == y2)
            return 0;
        else if(y1 > y2)
            return 2 + findYPath(row, x1, y1 - 1, x2, y2);
        else if(y2 > y1)
            return 2 + findYPath(row, x1, y1, x2, y2 - 1);
        // ideas: check to see if xdiff and ydiff are odd or even
        return -1;
        }
    
    public static int findXPath(int row, int x1, int y1, int x2, int y2){
        int xdiff = Math.abs(x1 - x2);
        int ydiff = Math.abs(y1 - y2);
        
        if(x1 == x2)
            return 0;
        else if(x1 > x2)
            return 1 + findXPath(row, x1 - 1, y1, x2, y2);
        else if(x2 > x1)
            return 1 + findXPath(row, x1, y1, x2 - 1, y2);
        // ideas: check to see if xdiff and ydiff are odd or even
        return -1;
        }
    
    }
    
