package com.example;

import java.util.Scanner;
import java.util.function.Consumer;

/**
 * Created by AiYeSus on 11/18/2017.
 */

public class longestPalindrome {
    private static Consumer<Object> StdOut = x -> System.out.println(x);

    public static String longestPalindromeBruteForce(String s) {
        int sz = s.length();
        if ( sz <= 1 ) return s;
        int i=0, j=1, maxPalinLen=0;
        String maxPalin = "";
        while (i < sz ) {
            while ( j <= sz) {
                StringBuilder sb = new StringBuilder(s.subSequence(i, j));
                String osub = sb.toString(), rev = sb.reverse().toString();
                if (rev.equalsIgnoreCase(osub) && rev.length() > maxPalinLen) {
                    maxPalin = osub;
                    maxPalinLen = osub.length();
                }
                j++;
            }
            i++;
            j=i+2;
        }
        return maxPalin;
    }

    public static String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
            StdOut.accept(len+" "+start+" "+end);
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String[] args) {
        String s = "longest substring";
        int fidx = 0, sidx = 0;
        Scanner scnr = new Scanner(System.in);
        do {
            StdOut.accept("Parsing for longest longestPalindrome substring :");
            s = scnr.nextLine();
            String longestS = longestPalindrome( s );
            StdOut.accept( "Longest longestPalindrome substring: " + longestS );
        } while ( !s.contains("quit") );
    }
}
