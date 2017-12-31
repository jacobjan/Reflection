package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

/**
 * Created by AiYeSus on 11/1/2017.
 */

public class get1stDup {
    public static Consumer<Object> StdOut = x -> System.out.println(x);

    public static String[] revWords(String sentence) {
        String wordsInSentence[] = sentence.split(" ");
        String resultsentence[]=new String[wordsInSentence.length];
        int j=0;
        for (int i=wordsInSentence.length; i>0; i--) {
            resultsentence[j++] = wordsInSentence[i-1];
        }
        return resultsentence;
    }

    public static int FirstDup(String str) {
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
 */         if ( (fidx = FirstDup(s)) != -1 ) {
                StdOut.accept("First duplicated char in [ " + s + " ] :" + s.charAt(fidx) + " at pos:" + (fidx + 1));
                StdOut.accept("Longest substring w/out dup char : " + s.substring(0, fidx) );
            }
            else StdOut.accept("No duplicated char in " + s );
        } while ( !s.contains("quit") );
     }
}
