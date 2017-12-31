package Collections;

import java.util.Scanner;

/**
 * Created by AiYeSus on 12/9/2017.
 * Use regex to match longest consecutive 0 between leading and trailing 1s
 * e.g. 9 = 1001 => 2
 */

public class BinaryGap {

    public static int longest0sbtn1(String s, char ch) {
        int max=0, cmax=0, temp=0;
        int sidx = 0;
        while ( sidx != -1 && 0 < s.length() ) {
            if ( (sidx = s.indexOf(ch)) > -1 ) {
                temp = sidx;
                sidx = s.substring(sidx).indexOf('1');
                max = Math.max(max, (sidx - temp));
                sidx = sidx + temp;
                s = s.substring(++sidx);
                System.out.println("substring  " + s);
            }
        }
        return Math.max(max, (sidx - temp));
 /*       if ( sidx > -1 ) {
            while (sidx < s.length() && sidx != -1) {
                temp = sidx;
                sidx = s.substring(sidx+1).indexOf(ch);
                max = Math.max(max, sidx - temp);
                System.out.println("indexOf char " + sidx + " "+max);
            }
        }
        return max;*/
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s="";
        int max=0, cmax=0, num;
        do {
            s = Integer.toBinaryString(scan.nextInt());
            System.out.println("longest 0s " + longest0sbtn1(s, '0'));
        } while ( !s.equals("1") );
    }
}
