package Default;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by AiYeSus on 12/11/2017.
 */

public class DistinctMember {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i=0;
        int sz ;
        int[] arr1;
        sz = scan.nextInt();
        arr1 = new int[sz];
        for(int j=0; j < sz; j++) {
            arr1[j] = scan.nextInt();
        }

        Set<Integer> setOfInt = new HashSet<Integer>();
        for(int j=0; j < sz; j++) {
            setOfInt.add( arr1[j] );
        }
        System.out.println("number of distinct ints : " + setOfInt.size());
    }
}
