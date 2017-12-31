package DataStructure;

/**
 * Created by AiYeSus on 12/18/2017.
 * 3, 13, 15, 28, 30,
 * 40, 51, 52, 29, 30,
 * 28, 10, 53, 54, 54,
   53, 12, 55, 53, 60,
   70, 62, 56, 20, 80,
   80, 81, 90, 95, 100
 * (0,0)->(0,1)->(0,2)->(0,3)->(1,3)->(1,4)->(2,4)->(3,4)->(4,4)->(5,4)->(5,4)
 Length: 10
 (0,0)->(0,1)->(0,2)->(0,3)->(1,3)->(1,4)->(2,4)
 Length: 118

 (0,0)->(0,1)->(1,1)->(1,2)->(2,2)->(3,2)->(3,1)->(3,0)->(4,0)->(5,0)->(5,1)->(5,2)->(5,3)->(5,4)->(5,4)
 Length: 14
 */
public class ShortestAdjPath {

    private int[][] matrix;
    private int Row;
    private int Column;

    public ShortestAdjPath(int[][] matrix, int matrixLenghRow, int matrixLenghColumn) {
        this.matrix = matrix;
        this.Row = matrixLenghRow;
        this.Column = matrixLenghColumn;
    }

    public static void main(String[] args) {
        int mRow;
        int mCol;
        int[][] matrix1 = { { 3, 13, 15, 28, 30 },
                            { 40, 51, 52, 29, 30 },
                            { 28, 10, 53, 54, 54 },
                            { 53, 12, 55, 53, 60 },
                            { 70, 62, 56, 20, 80 },
                            { 80, 81, 90, 95, 100 } };
        mRow = matrix1.length;
        mCol = matrix1[0].length;
        ShortestAdjPath finder1 = new ShortestAdjPath(matrix1, mRow, mCol);
        finder1.run();
    }

    private void run() {
        int i = 0;
        int j = 0;

        System.out.print("(" + i + "," + j + ")");
        System.out.println("\nSum: " + find(i, j));
    }

    private int find(int i, int j) {
        int value = matrix[i][j];
        int[] next = { i, j };

        int smallestNeighbour = 101;
        if (i > 0 && matrix[i - 1][j] > value) {
            smallestNeighbour = matrix[i - 1][j];
            next[0] = i - 1;
            next[1] = j;
        }
        if (j > 0 && matrix[i][j - 1] < smallestNeighbour && matrix[i][j - 1] > value) {
            smallestNeighbour = matrix[i][j - 1];
            next[0] = i;
            next[1] = j - 1;
        }
        if (i < Row - 1 && matrix[i + 1][j] < smallestNeighbour && matrix[i + 1][j] > value) {
            smallestNeighbour = matrix[i + 1][j];
            next[0] = i + 1;
            next[1] = j;
        }
        if (j < Column - 1 && matrix[i][j + 1] < smallestNeighbour && matrix[i][j + 1] > value) {
            smallestNeighbour = matrix[i][j + 1];
            next[0] = i;
            next[1] = j + 1;
        }

        System.out.print("->(" + next[0] + "," + next[1] + ")");

        if (j == Column - 1)
            return value;

        return find(next[0], next[1]) + value;
    }
}