package IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by AiYeSus on 12/24/2017.
 */

public class GetMatrixFromFile {
    private static BufferedReader in = null;
    private static int rows = 0;
    private static int columns = 0;
    private static int [][] matrix = null;

    public static void main(String []args) throws Exception {
        try {
            String filepath = "matrix1.txt";  //args[0];
            File source = new File( filepath );
            Scanner instrm = new Scanner(source);
            rows = instrm.nextInt();
            columns = instrm.nextInt();
            System.out.println("r c Matrix " +rows+"    col "+columns );
            matrix = new int[rows][columns];
            for (int r=0; r < rows; r++)
              for (int c=0; c < columns; c++) {
                  matrix[r][c] = instrm.nextInt();
              }
        } catch (Exception ex) {
            System.out.println("Invalid Matrix");
            System.out.println(ex.getMessage());
        } finally {
            if (in!=null) in.close();
        }
        System.out.println("The matrix: ");
        for (int i=0; i < rows; i++) {
            for(int j=0; j < columns; j++)
                System.out.print(matrix[i][j]+" ");
            System.out.println("");
        }
    }
}