package Default;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by AiYeSus on 12/11/2017.
 */

public class MaxProductOfThree {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = 0, sz, max = 0;
        int[] arr1;
        sz = scan.nextInt();
        arr1 = new int[sz];
        for (int j = 0; j < sz; j++) {
            arr1[j] = scan.nextInt();
        }

        for (int j = 0; j < sz; j++)
            for (int k = j+1; k < sz; k++)
                for (int l = k+1; l < sz; l++) {
                    max = Math.max(max, (arr1[j] * arr1[k] * arr1[l]));
                }

        System.out.println("Maximum product: " + max);
    }
}
