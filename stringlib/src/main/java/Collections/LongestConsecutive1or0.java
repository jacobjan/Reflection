package Collections;

import java.util.Scanner;

/**
 * Created by AiYeSus on 12/9/2017.
 */

public class LongestConsecutive1or0 {

    public static int longestConsective1or0(String s, boolean ConsecutiveOnes) {
        int max=0, tmp=0;
        String substr = s;
        char[] usech = new char[2];
        if ( ConsecutiveOnes ) {
            usech[0] = '1';
            usech[1] = '0';
        } else {
            usech[0] = '0';
            usech[1] = '1';
        }
        int sidx = s.indexOf(usech[0]);

        if ( sidx > -1 ) {
            while ( tmp > -1 && substr.length() >= 1 ) {
                substr = substr.substring( sidx );
                tmp = substr.indexOf( usech[1] );
                if ( tmp == -1 ) {
                    tmp = substr.length();
                    break;
                }
                else if ( tmp == 0 ) tmp++;
                substr = substr.substring( tmp );
                if (tmp > max) max = tmp;
            }
        }
        return Math.max(max, tmp);
    }

    public static void main(String[] args) {
        System.out.println("Enter two integer to check for longest consective 1 or 0: <num> <checkfor1or0>");
        Scanner scan = new Scanner(System.in);
        String s="";
        boolean consecutive1s = false;
        int max=0, cmax=0, num;
        do {
           // s = Integer.toBinaryString(scan.nextInt());
            double d = Math.sqrt(scan.nextInt());
            System.out.println("sqrt "+ d + " " + (int)d );
            System.out.println("sqrt "+ (d == (int)d) );
            s = Integer.toBinaryString(scan.nextInt());
 /*           if ( scan.nextInt() == 1 ) consecutive1s = true;
            else consecutive1s = false;
            System.out.println("longest 1/0s of "+s+" :" + longestConsective1or0( s, consecutive1s ));
*/        } while ( !s.equals("0") );
    }
}
