package DataStructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
public class ShortestPath {

    private int[][] matrix;
    private String leastPath;
    private int Row, Column, leastSum=Integer.MAX_VALUE, numCol=0;
    private boolean LT50 = true;
    String res = "";
    Map<String, Integer> pathMap = new HashMap<>(),
                            midPath = new HashMap<>();

    public ShortestPath(int[][] matrix, int matrixRow, int matrixColumn) {
        this.matrix = matrix;
        this.Row = matrixRow;
        this.Column = matrixColumn;
    }

    public static void main(String[] args) {

        int[][] matrix1L = { { 3, 4, 1, 2, 8, 6 },
                            { 6, 1, 8, 2, 7, 5 },
                            { 5, 9, 3, 9, 9, 5 },
                            { 8, 4, 1, 3, 2, 6 },
                            { 3, 7, 2, 1, 2, 3 } };
        int[][] matrix1 = { { 3, 4, 1, 2, 8, 6 },
                            { 6, 1, 8, 2, 7, 5 },
                            { 5, 9, 3, 9, 9, 5 },
                            { 8, 4, 1, 3, 2, 6 },
                            { 3, 7, 2, 8, 6, 4 } };

        int[][] matrix2 = { { 60, 3, 3, 6 },
                            { 6, 3, 7, 9 },
                            { 5, 6, 8, 3 } };
        int[][] matrix1f = {{ 69, 10, 19, 10, 19 },
                            { 51, 23, 20, 19, 12 },
                            { 60, 12, 20, 11, 10 }};


        int[][] matrix1c = {{ 19, 10, 19, 10, 19 },
                            { 21, 23, 20, 19, 12 },
                            { 20, 12, 20, 11, 10 }};

        int mRow = matrix1.length;
        int mCol = matrix1[0].length;
        ShortestPath shortestPath = new ShortestPath(matrix1, mRow, mCol);
        shortestPath.displayMatrix(matrix1 );
        shortestPath.run(mRow, mCol);
    }

    private void displayMatrix(int[][] mat) {
        for(int r = 0; r < Row; r++) {
            for(int c = 0; c < Column; c++) {
                System.out.print(mat[r][c]+" ");
            }
            System.out.println();
        }
    }
    private void run(int numOfRow, int numOfColumn) {
        pathMap.clear();
        List<Integer> larr = new ArrayList<>();
        for(int c = 0; c < numOfColumn && LT50; c++) {
            for(int r = 0; r < numOfRow && LT50; r++) {
                res = "";
                int sum = 0;
                leastSumOf(r, c, res, sum);
            }
            if ( !LT50 ) {
                findShortest(pathMap);
                break;
            } else pathMap.clear();
        }
        findShortest(pathMap);

        if ( LT50 ) res = "YES";
        else {
            res = "NO";
            if ( leastPath == null || leastPath.length() <= 2 ) {
                leastSum = 0;
            } else {
                findShortest( midPath );
            }
        }
        System.out.println(res);
        System.out.println(leastSum);
        if ( leastPath == null || leastPath.length() <= 2 ) {
            System.out.println( larr );
        } else {
            System.out.println( leastPath );
        }
    }

    private void leastSumOf(int row, int col, String path, int cSum) {
        if ( col >= Column-1 || cSum > 50) {
            // get least one from last column
            int[] leastRowValue = getRowWithLeastElement(row, col);
            path += (leastRowValue[0]+1);
            cSum += leastRowValue[1];
            pathMap.put(path, cSum);
            return;
        } else {
            cSum += matrix[row][col];
            path += (row+1) + " ";

//            System.out.println("Path dist:" + cSum+ "  Path:" + path + " at row " + row);
            if ( cSum > 50 ) {
                midPath.put(path, cSum);
                numCol = path.split(" ").length;
                leastPath = path;
                LT50 = false;
                return;
            }
        }

        if ( col+1 == Column-1 ) {
            leastSumOf(getRow(row), col + 1, path, cSum);
        } else {
            leastSumOf(getRow(row - 1), col + 1, path, cSum);
            leastSumOf(getRow(row), col + 1, path, cSum);
            leastSumOf(getRow(row + 1), col + 1, path, cSum);
        }
    }

    private void findShortest(Map<String, Integer> pathMap) {
        // Get entry set from the path map
        Set<Map.Entry<String, Integer>> pathSet = pathMap.entrySet();
        // Create comparator to sort the map acending order
        Comparator<Map.Entry<String, Integer>> valueComparator = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                Integer v1 = e1.getValue();
                Integer v2 = e2.getValue();

                if ( v1 < v2 ) return -1;
                else if ( v1 > v2 ) return 1;
                else return 0;
            }
        };
        // Sort method needs a List, so let's first convert Set to List in Java
        ArrayList<Map.Entry<String, Integer>> listOfPath = new ArrayList<Map.Entry<String, Integer>>(pathSet);
        // sorting HashMap by values using ascending order comparator
        Collections.sort(listOfPath, valueComparator);
        for(int i=0; i < listOfPath.size(); i++) {
            System.out.println("\tPath :" + listOfPath.get(i).getKey() + "  sum:" + listOfPath.get(i).getValue());
        }

        if ( listOfPath.size() > 0 && leastSum >= listOfPath.get(0).getValue() ) {
            leastSum = listOfPath.get(0).getValue();
            leastPath = listOfPath.get(0).getKey();
        }
    }

    private void showMapMidpath( Map<String, Integer> pathMap, int nCol ) {
        // Get entry set from the path map
        Set<Map.Entry<String, Integer>> pathSet = pathMap.entrySet();
        // Create comparator to sort the map acending order
        Comparator<Map.Entry<String, Integer>> valueComparator = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                Integer v1 = e1.getValue();
                Integer v2 = e2.getValue();

                if ( v1 < v2 ) return -1;
                else if ( v1 > v2 ) return 1;
                else return 0;
            }
        };
        // Sort method needs a List, so let's first convert Set to List in Java
        ArrayList<Map.Entry<String, Integer>> listOfPath = new ArrayList<Map.Entry<String, Integer>>(pathSet);
        // sorting HashMap by values using ascending order comparator
        Collections.sort(listOfPath, valueComparator);
        int entryIndex=0, lr;
        for(int i=0; i < listOfPath.size(); i++) {
             if ( nCol == listOfPath.get(i).getKey().split(" ").length ) {
                entryIndex = i;
                System.out.println("nCol :" +nCol+ "\tPath :" + listOfPath.get(i).getKey() + "  sum:" + listOfPath.get(i).getValue());
                break;
            }
        }
        leastPath = "";
        String[] pathComp = listOfPath.get(entryIndex).getKey().split(" ");
        for(int c=0; c < pathComp.length-1; c++ ) {
            leastPath += pathComp[c] + " ";
        }
        lr = Integer.parseInt( pathComp[pathComp.length-1] );
        leastSum = listOfPath.get(entryIndex).getValue() - matrix[lr-1][nCol-1];
    }

    private int getRow(int currRow) {
        if (currRow < 0) {
            return (Row-1);
        } else if (currRow > Row - 1) {
            return 0;
        } else return currRow;
    }

    private int[] getRowWithLeastElement(int atRow, int Col) {
        int rowAbove=getRow(atRow-1), rowBelow=getRow(atRow+1);
        int[] vals = {rowAbove, matrix[rowAbove][Col]};

        if (matrix[atRow][Col] < vals[1]) {
            vals[0] = atRow;
            vals[1] = matrix[atRow][Col];
        }
        if (matrix[rowBelow][Col] < vals[1]) {
            vals[0] = rowBelow;
            vals[1] = matrix[rowBelow][Col];
        }

        return vals;
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

 int[][] matrix0 = { { 3, 4, 1, 2, 8, 6 },
 { 6, 1, 8, 2, 7, 5 },
 { 5, 9, 3, 9, 9, 5 },
 { 8, 4, 1, 3, 2, 6 },
 { 3, 7, 2, 1, 2, 3 } };
 int[][] matrix1 = { { 3, 4, 1, 2, 8, 6 },
 { 6, 1, 8, 2, 7, 5 },
 { 5, 9, 3, 9, 9, 5 },
 { 8, 4, 1, 3, 2, 6 },
 { 3, 7, 2, 8, 6, 4 } };

 int[][] matrix2 = { { 60, 3, 3, 6 },
 { 6, 3, 7, 9 },
 { 5, 6, 8, 3 } };

 */