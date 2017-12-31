package Default;

/**
 * Created by AiYeSus on 12/16/2017.
 */


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SuperDigit {

    static int superDigit(String n, int k) {
        // Complete this function
        StringBuilder dgsBdr = new StringBuilder();
        for(int i=0; i<k; i++) {
            dgsBdr.append(n);
        }
        return super_digit( dgsBdr.toString() );
    }

    static int super_digit(String n) {
        int dsum = 0;
        if ( n.length() == 1 ) return Integer.parseInt(n);
        else {
            char[] charr = n.toCharArray();
            for(char ch : charr) {
                dsum += ch - '0';
            }
            return super_digit(String.format("%d", dsum));
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n = in.next();
        int k = in.nextInt();
        int result = superDigit(n, k);
        System.out.println(result);
        in.close();
    }
}

