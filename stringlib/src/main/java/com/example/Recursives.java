package com.example;

import java.util.function.Consumer;

/**
 * Created by AiYeSus on 11/1/2017.
 * Other tasks:
 * -Describe and code an algorithm that returns the first duplicate character in a string?
 * -In a given sorted array of integers remove all the duplicates
 * -how can a particular application be tested apart from testing its functionality
 * -Write code in your favorite programming language that will accept two strings and return true if they are anagrams.
 * -Given a string (understood to be a sentence), reverse the order of the words. "Hello world" becomes "world Hello"
 *
 *
 */

public class Recursives {

    public static Consumer<Object> StdOut = x -> System.out.println(x);

    public static void partition(int n) {
        partition(n, n, "");
    }

    public static void partition(int n, int max, String prefix) {
        StdOut.accept("Calling partition with 'n max prefix' = '" + n + " " + max + " " + prefix+"'");
        if (n == 0) {
            StdOut.accept(prefix);
            return;
        }
        for (int i = Math.min(max, n); i >= 1; i--) {
            partition(n - i, i, prefix + " " + i);
        }
    }

    public static void main(String[] args) {
        int num2Partition;
        if ( args.length > 0 )
            num2Partition = Integer.parseInt(args[0]);
        else
            num2Partition = 3;

        partition(num2Partition);
    }
}
