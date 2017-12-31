package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

/**
 * Created by AiYeSus on 11/2/2017.
 * Check if two words are anagram
 */

public class CheckAnaGram {
    private static int count = 0;
    static Consumer<Object> cStdOut = System.out::println;
    private static List<String> anaList = new ArrayList<String>();
    public static void permutation(String str) {
        permutation("", str);
    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) {
            count++;
            if ( !anaList.contains(prefix) ) anaList.add(prefix);
            cStdOut.accept("Permutation " + count + " = " + prefix);
        } else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
    }

    public static void main(String[] argList) {
        System.out.println("enter strings to check if they are anagram : ");
        Scanner scrnr = new Scanner(System.in);
        String row = scrnr.nextLine();
        String anagrams[] = row.split(" ");
        permutation(anagrams[0]);
        StringBuilder sb = new StringBuilder();
        sb.append(anagrams[0] + " and " + anagrams[1]+ " are ");
        if ( anaList.contains(anagrams[1]) ) sb.append( "Anagram " );
        else sb.append( "NOT Anagram " );
        cStdOut.accept( sb.toString() );
    }
}
