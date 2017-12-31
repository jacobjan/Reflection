package Default;

import java.util.Scanner;

/**
 * Created by AiYeSus on 12/9/2017.
 */

public class MaximumXOR {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nL, nR, max=0, xr;
        while ( (nL = in.nextInt()) > 0 ) {
            nR = in.nextInt();
            max=(nL ^ nR);
            for(int i = nL; i<=nR; i++) {
                for (int j = i+1; j <= nR; j++) {
                    System.out.println(i+" "+j);
                    xr = i^j;
                    if (max < xr) max = xr;
                }
            }
            System.out.println("\n"+max);
        };
    }
}
