package com.example;

import java.util.Scanner;
import java.util.function.Consumer;

/**
 * Created by AiYeSus on 11/18/2017.
 * public static int FirstDup(String str) {
 int dupPos = -1, i=0;
 if ( null == str || str.length() == 0) return -1;

 List<Character> clst = new ArrayList<Character>();
 char charr[] = str.toCharArray();

 do  {
 if ( !clst.contains(charr[i]) )
 clst.add( charr[i] );
 else
 dupPos = i;
 } while ( dupPos == -1 && i++ < charr.length-1);
 return dupPos;
 }

 public static void main(String[] args) {
 String s = "returns the first duplicate character in a string ?";
 int fidx = 0, sidx = 0;
 Scanner scnr = new Scanner(System.in);
 do {
 System.out.println("Enter String to find first duplicate :");
 s = scnr.nextLine();
 /*           for (int i = 0; i < s.length(); i++) {
 String firstStr = s.substring(i, i + 1);
 fidx = s.indexOf(firstStr);
 String nxtStr = s.substring(i+1);
 sidx = nxtStr.indexOf(firstStr);
 StdOut.accept("1st idx: "+fidx+"  2nd:"+sidx );
 if ( -1 != sidx && fidx != sidx ) {
 sidx += fidx+1;
 StdOut.accept("First duplicate of [ " + s + " ] :" + s.substring(i, i + 1) + " at position :"+sidx);
 break;
 }
 }

 */

public class MyAtoI {
    private static Consumer<Object> StdOut = x -> System.out.println(x);
    public static int myAtoi(String str) {
        int res = 0;
        if ( str == null || str.length() == 0) return 0;
        String buf = str.trim();
        char digits[] = buf.toCharArray();
        int sz = digits.length;
        boolean neg = false;
        int idx = 0;
        if (digits[0] == '-' || digits[0] == '+') {
            if (digits[0] == '-') neg = true;
            idx = 1;
        }

        for(int i=idx; i<sz && digits[i] >= '0' && digits[i] <= '9' ; i++) {
            res = res*10 + (digits[i] - '0');
        }
        if ( neg == true ) return -res;
        return res;
    }

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        String s = "";
        do {
            StdOut.accept("Parsing string to integer:");
            s = scnr.nextLine();
            StdOut.accept("integer from string: " + myAtoi(s));
        } while (!s.contains("-1"));
    }
}
