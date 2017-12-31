package Collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by AiYeSus on 12/12/2017.
 */

public class PosNotInArray {

    public static int solution(int[] A) {
        // write your code in Java SE 8
        List<Integer> lst = new LinkedList<Integer>();
        int n=1, sz = A.length;
        for(int i=0; i<sz; i++) {
            lst.add(A[i]);
        }
        Collections.sort( lst );
        for(n=1; n<=sz; n++) {
            if ( !lst.contains(n) )
                return n;
        }
        if ( lst.get(sz-1) < 0 ) return 1;
        return lst.get(sz-1)+1;
    }

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
        System.out.println("number of distinct ints : " + solution(arr1));
    }
}
