package Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by AiYeSus on 11/28/2017.
 */

public class ArraysMethods {
    public static void main(String[] args) {
        Random rd = new Random();
        int i, bsrchResult, temp, sz = 1000;
        int[] iarr = new int[sz];
        List<Integer> lstOfInt = new ArrayList<Integer>();
        for(i=0; i<sz; i++) {
            temp = Math.abs(rd.nextInt() % (5 * sz));
            iarr[i] = temp;
            lstOfInt.add(temp);
        }

        // Now sort it
        System.out.println("\n\nSort them ");
        Collections.sort(lstOfInt);
        Arrays.sort( iarr );
        for(i=0; i<10; i++) {
            temp = Math.abs(rd.nextInt()%2000);
            System.out.println("lstOfInt.contains "+temp+" :"+lstOfInt.contains(temp));
            if ((bsrchResult = Arrays.binarySearch(iarr, temp)) >= 0 ){
                System.out.println("bsrchResult iarr[" + bsrchResult+ "]="+iarr[bsrchResult]);
            }
        }

    }
}
