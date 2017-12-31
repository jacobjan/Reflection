package DataStructure;

/**
 * Created by AiYeSus on 12/19/2017.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BubbleSort {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numberOfSwaps = 0;
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        /**
         * 10
         9 23 -91 6 81 7 4 10 -123 98776
         Array is sorted in 22 swaps.
         First Element: -123
         Last Element: 98776
         */
        for (int i = 0; i < n; i++) {
            // Track number of elements swapped during a single array traversal
            for (int j = i+1; j < n; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[i] > a[j]) {
                    swap(a, i, j);
                    numberOfSwaps++;
                }
            }

            // If no elements were swapped during a traversal, array is sorted
            if (numberOfSwaps == 0) {
                break;
            }
        }
        System.out.println("Array is sorted in "+ numberOfSwaps +" swaps.");
        System.out.println("First Element: "+a[0]);
        System.out.println("Last Element: "+a[n-1]);
    }
}
