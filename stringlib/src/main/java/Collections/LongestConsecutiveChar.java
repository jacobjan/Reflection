package Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * Created by AiYeSus on 12/9/2017.
 */

public class LongestConsecutiveChar {

    public static int longestConsecutiveChar(String s, char ch) {
        int max=0, cmax=0, num;
        int sidx = s.indexOf(ch);
        if ( sidx > -1 ) {
            cmax = 1;
            for (int i = sidx + 1; i < s.length(); i++) {
                System.out.println("char max cmax " + s.charAt(i) + " " + max + " " + cmax);
                if (s.charAt(i - 1) == ch && s.charAt(i) == ch) {
                    cmax++;
                } else {
                    if (cmax > max) max = cmax;
                    cmax = 1;
                }
            }
        }
        return Math.max(max, cmax);
    }

    public static void main(String[] args) {
        System.out.println("Enter two integer to check for longest consective 1 or 0: <num> <checkfor1or0>");
        Scanner scan = new Scanner(System.in);
        String s="";
        boolean consecutive1s = false;
        int max=0, cmax=0, num;
        do {
            s = Integer.toBinaryString(scan.nextInt());
            System.out.println("longest 1s " + longestConsecutiveChar(s, '1'));
            System.out.println("longest 0s " + longestConsecutiveChar(s, '0'));
        } while ( !s.equals("0") );
    }
}
