package com.example;

import java.util.function.Consumer;

/**
 * Created by AiYeSus on 11/1/2017.
 */

public class ReverseSentence {
    public static Consumer<Object> StdOut = x -> System.out.print(x);

    public static String[] revWords(String sentence) {
        String wordsInSentence[] = sentence.split(" ");
        String resultsentence[]=new String[wordsInSentence.length];
        int j=0;
        for (int i=wordsInSentence.length; i>0; i--) {
            resultsentence[j++] = wordsInSentence[i-1];
        }
        return resultsentence;
    }

    public static void main(String[] args) {
        for (String s :  revWords("returns the first duplicate character in a string ?")) {
            StdOut.accept(s+" ");
        }
        StdOut.accept("\n");
    }
}
