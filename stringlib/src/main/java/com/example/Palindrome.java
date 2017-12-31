package com.example;

/**
 * Created by AiYeSus on 11/14/2017.
 */

public class Palindrome {

    public static boolean isPalindrome(String word) {
        StringBuilder sb1 = new StringBuilder(word);

        return (sb1.reverse().toString()).equalsIgnoreCase( word );

    }

    public static void main(String[] args) {
        System.out.println(Palindrome.isPalindrome("Deleveled"));
        System.out.println(Palindrome.isPalindrome("Palindrome"));
    }
}