package Collections;

/**
 * Created by AiYeSus on 12/9/2017.
 */


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LonelyInteger {

    static int lonelyinteger(int[] a) {
        // Complete this function
        int sz = a.length;
        List<Integer> lst = new ArrayList<>();
//        System.out.println(a[i]+" is added at index "+ lst.indexOf(a[i]) );

        for(int i = 0; i<sz; i++) {
            if ( !lst.contains(a[i]) )
                lst.add(a[i]);
            else {
                lst.remove( lst.indexOf(a[i]) );
            }
        }

        for(int i=0; i<lst.size();i++)
            System.out.print(" "+ lst.get(i) );

        return lst.get(0);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        do {
            n = in.nextInt();
            int[] a = new int[n];
            for (int a_i = 0; a_i < n; a_i++) {
                a[a_i] = in.nextInt();
            }
            int result = lonelyinteger(a);
            System.out.println("\n"+result);
        } while ( n > 0 );
    }
}
