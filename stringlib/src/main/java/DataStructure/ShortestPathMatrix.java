package DataStructure;

/**
 * Created by AiYeSus on 12/21/2017.

 * 3, 13, 15, 28, 30,
 * 40, 51, 52, 29, 30,
 * 28, 10, 53, 54, 54,
   53, 12, 55, 53, 60,
   70, 62, 56, 20, 80,
   80, 81, 90, 95, 100

 (0,0)->(0,1)->(0,2)->(0,3)->(1,3)->(1,4)->(2,4)
 Least Sum: 118

 */
public class ShortestPathMatrix {

    private int[][] matrix;
    private int Row;
    private int Column;
    String res = "";

    public ShortestPathMatrix(int[][] matrix, int matrixLenghRow, int matrixLenghColumn) {
        this.matrix = matrix;
        this.Row = matrixLenghRow;
        this.Column = matrixLenghColumn;
    }

    public static void main(String[] args) {
        int[][] matrix1 = { { 3, 4, 1, 2, 8, 6 },
                            { 6, 1, 8, 2, 7, 4},
                            { 5, 9, 3, 9, 9, 5 },
                            { 8, 4, 1, 3, 2, 6 },
                            { 3, 7, 2, 8, 6, 4 } };
        int mRow = matrix1.length;
        int mCol = matrix1[0].length;
        ShortestPathMatrix shortestPath = new ShortestPathMatrix(matrix1, mRow, mCol);
        shortestPath.run(mRow);
    }

    private void run(int numOfRow) {
        for(int r = 0; r < numOfRow; r++) {
            res = (r+1) + " ";
            find(r);
        }
    }

    private int[] getPath(int row, int col) {
        int[] path = {1, 2, 3, 4, 4, 5};
        return path;
    }

    private int find(int row) {
        int[] next = {-1, -1};  // {row, element-value}
        int r = row, sum, ShortestPath=100;
        int[] path = {1, 2, 3, 4, 4, 5};

        sum = matrix[r][0];
        System.out.print("\t(" + r + ",0,"+sum+")");
        for(int c = 1; c < Column; c++) {
            //next = leastOf(r, c);
            if ( row == 0 ) next[0] = path[c]-1;
            else next = leastOf(r, c);
            next[1] = matrix[ next[0] ][c];
            System.out.print("->(" + next[0] + "," + c + "," + next[1] + ")");
            r = next[0];
            res += (next[0]+1) + " ";
            sum += next[1];
        }
        if ( sum <= 50 ) System.out.println("\nYES");
        else System.out.println("\nNO");
        System.out.println(sum+"\n"+res);
        if ( ShortestPath > sum ) ShortestPath = sum;
        sum = 0;
        res = "";
        return ShortestPath;
    }

    private int getBoundaryRow(int atRow) {
        if (atRow < 0) {
           return (Row-1);
        } else if (atRow >= Row - 1) {
            return 0;
        } else return atRow;
    }

    private int[] leastOf(int atRow, int atCol) {
        int theLeast = matrix[atRow][atCol];
        int[] next = {atRow, theLeast};
        if ( atRow == 0 ) {
            if ( theLeast > matrix[1][atCol] ) {
                theLeast = matrix[1][atCol];
                next[0] = 1;
            }
            if ( theLeast > matrix[Row-1][atCol] ) {
                theLeast = matrix[Row-1][atCol];
                next[0] = Row-1;
            }
        } else if ( atRow == Row - 1 ) {
            if ( theLeast > matrix[atRow-1][atCol] ) {
                theLeast = matrix[atRow-1][atCol];
                next[0] = atRow-1;
            }
            if ( theLeast > matrix[0][atCol] ) {
                theLeast = matrix[0][atCol];
                next[0] = 0;
            }
        } else {
            for(int r=atRow-1; r <= atRow+1; r++) {
                if ( theLeast > matrix[r][atCol] ) {
                    theLeast = matrix[r][atCol];
                    next[0] = r;
                }
            }
        }
        next[1] = theLeast;
        return next;
    }
}
/**
 Instructions -

 1.  Can you ensure you implement the solution using TDD approach to developing the application. There are many good articles on the web about TDD development patterns.
 2.  Specifically, we are looking for tests to drive the design and development of the code. To do that, tests are written in conjunction with the code (often before the code).
 3.  Code should be properly factored into appropriately named/intentioned TDD-ed classes with appropriate separation of concerns.
 4.  Share your code through github link
 5. Please write test cases as TDD approach is followed and client requests test cases to be submitted
 6. Make sure GUI has option to input values for testing.
 7. There should be comments with code.

 After you complete the code, please check it for the below inputs. we need correct output for all the cases. You can include them as part of your test cases.

 Sample 1: (6X5 matrix normal flow)
 Input:
 3 4 1 2 8 6
 6 1 8 2 7 4
 5 9 3 9 9 5
 8 4 1 3 2 6
 3 7 2 8 6 4

 Output:
 Yes
 16
 [1 2 3 4 4 5]

 Sample 2: (6X5 matrix normal flow)
 Input:
 3 4 1 2 8 6
 6 1 8 2 7 4
 5 9 3 9 9 5
 8 4 1 3 2 6
 3 7 2 1 2 3

 Output:
 Yes
 11
 [1 2 1 5 4 5]

 Sample 3: (5X3 matrix with no path <50)
 Input:
 19 10 19 10 19
 21 23 20 19 12
 20 12 20 11 10

 Output:
 No
 48
 [1 1 1]

 Sample 4: (1X5 matrix)
 Input:
 5 8 5 3 5

 Output:
 Yes
 26
 [1 1 1 1 1]

 Sample 5: (5X1 matrix)
 Input:
 5
 8
 5
 3
 5

 Output:
 Yes
 3
 [4]

 Sample 6: (Non numeric input, Optional)
 Input:
 5 4 H
 8 M 7
 5 7 5

 Output:
 Invalid matrix

 Sample 7: (No input - Optional)
 Input:

 Output:
 Invalid matrix

 Sample 8: (Starting with >50)
 Input: 69 10 19 10 19
        51 23 20 19 12
        60 12 20 11 10

 Output: No 0   []

 Sample 9: (One value >50)
 Input: 60 3 3 6
        6 3 7 9
        5 6 8 3
 Output:    Yes 14  [3,2 1 3]

 Sample 10: (Negative values)
 Input:
 6,3,-5,9
 -5,2,4,10
 3,-2,6,10
 6,-1,-2,10

 Output:
 Yes
 0
 [2,3 4 1]

 Sample 11: Complete path vs. lower cost incomplete path
 Input:
 51 51
 0 51
 51 51
 5 5

 Expected output:
 Yes
 10
 4 4

 Sample 12: Longer incomplete path vs. shorter lower cost incomplete path
 Input:
 51 51 51
 0 51 51
 51 51 51
 5 5 51

 Expected output:
 No
 10
 4 4

 Sample 13: Large number of columns
 Input:
 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2

 Expected output:
 Yes
 20
 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1

 */