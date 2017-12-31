package com.example;

/**
 * Created by AiYeSus on 11/1/2017.
 */

public class FindAllPermutation {
    private static int count = 0;
    public static void permutation(String str) {
        permutation("", str);
    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) {
            count++;
            System.out.println("Permutation " + count + " = " + prefix);
        } else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
    }

    public static void main(String[] argList) {
        permutation("abcd");
    }
}
