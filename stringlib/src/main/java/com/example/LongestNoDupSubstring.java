package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

/**
 * Created by AiYeSus on 11/1/2017.
 */

public class LongestNoDupSubstring {
    private static Consumer<Object> StdOut = x -> System.out.println(x);
    private static String longestSubstrNoDp = "";

    public static int getLengths(String str) {
        int sz = str.length();
        int max = 0, len;
        String substr;
        for(int strBegin=0; strBegin<sz-max+1; strBegin++) {
            substr = str.substring(strBegin);
            //StdOut.accept("Parsing for longest substring without duplicated character " + substr );
            if ( max < (len = LongestNonDup( substr ))) {
                max = len;
                longestSubstrNoDp = substr.substring(0, max);
            }
        }
        return max;
    }

    public static int LongestNonDup(String str) {
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
        if ( clst.size() == charr.length ) dupPos = charr.length;
        return dupPos;
    }

    public static void main(String[] args) {
        String s = "longest substring";
        int fidx = 0, sidx = 0;
        Scanner scnr = new Scanner(System.in);
        do {
            System.out.println("Parsing for longest substring without duplicated character :");
            s = scnr.nextLine();
            int longest = getLengths( s );
            StdOut.accept( "Longest substring: " + longestSubstrNoDp + " length:" + longest );
        } while ( !s.contains("quit") );
    }
}
