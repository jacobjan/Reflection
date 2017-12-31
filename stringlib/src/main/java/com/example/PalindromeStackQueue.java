package com.example;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by AiYeSus on 11/14/2017.
 */

public class PalindromeStackQueue {

    Stack<Character> stk = new Stack();
    Queue<Character> mQueue = new PriorityQueue<Character>();

    public void pushCharacter(char ch) {
        stk.push(ch);
    }

    public void enqueueCharacter(char ch) {
        mQueue.add(ch);
    }

    public char popCharacter() {
        return stk.pop();
    }

    public char dequeueCharacter() {
        return mQueue.poll();
    }

 /*   public static void main(String[] args) {
        *//*System.out.println(PalindromeStackQueue.isPalindrome("Deleveled"));
        System.out.println(PalindromeStackQueue.isPalindrome("Palindrome"));*//*

    }*/
     public static void main(String[] args) {
         Scanner scan = new Scanner(System.in);
         String input = scan.nextLine();
         scan.close();

         // Convert input String to an array of characters:
         char[] s = input.toCharArray();
         char sc, qc;

         // Create a Solution object:
         PalindromeStackQueue p = new PalindromeStackQueue();

         // Enqueue/Push all chars to their respective data structures:
         for (char c : s) {
             p.pushCharacter(c);
             p.enqueueCharacter(c);
             System.out.println(c + " ");
         }

         System.out.println("Dequeing");
         int j=0;
         while ( j++ < 7 ) {
             qc = p.mQueue.remove();
             System.out.println( qc + " ");
         }
         // Pop/Dequeue the chars at the head of both data structures and compare them:
         boolean isPalindrome = true;
          for (int i = 0; i < s.length/2; i++) {
             sc = p.popCharacter();
             qc = p.dequeueCharacter();
             System.out.println(sc + " " +qc);
             if (sc != qc) {
                 isPalindrome = false;
                 break;
             }
         }

         //Finally, print whether string s is palindrome or not.
         System.out.println( "The word, " + input + ", is "
                 + ( (!isPalindrome) ? "not a palindrome." : "a palindrome." ) );
     }
}