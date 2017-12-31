package Collections;

import java.util.Scanner;

/**
 * Created by AiYeSus on 12/10/2017.
 */

public class MaxHourGlassSum {

    public static int hgSum(int[][] mat, int startrow, int startcol) {
        int sum = 0;
        for(int c=startcol; c < startcol+2; c++)
            sum += mat[startrow][c];
        for(int c=startcol; c < startcol+2; c++)
            sum += mat[startrow+2][c];
        sum += mat[startrow+1][startcol+1];
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int max = 0, csum;
        int arr[][] = new int[6][6];
        for(int i=0; i < 6; i++){
            for(int j=0; j < 6; j++){
                arr[i][j] = in.nextInt();
            }
        }

        for(int r=0; r < 4; r++){
            for(int c=0; c < 4; c++){
                csum = hgSum(arr, r, c);
                if ( max < csum )
                    max = csum;
            }
        }
        System.out.println(max);
    }
}
