package DataStructure;

/**
 * Created by AiYeSus on 12/21/2017.
 */

// A Java program to count all possible paths
// from top left to bottom right

public class PossiblePathMatrix {
    // Returns count of possible paths to reach
    // cell at row number m and column number n
    // from the topmost leftmost cell (cell at 1, 1)
    static int  numberOfPaths(int m, int n)
    {
        // If either given row number is first or
        // given column number is first
        System.out.print(m + ","+n+"    ");
        if (m == 1 || n == 1) {
            System.out.println();
            return 1;
        }
        // If diagonal movements are allowed then
        // the last addition is required.
        return  numberOfPaths(m-1, n) + numberOfPaths(m, n-1);
        // + numberOfPaths(m-1,n-1);
    }

    public static void main(String args[])
    {
        System.out.println(numberOfPaths(3, 3));
    }
}