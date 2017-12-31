package com.example;

/**
 * Created by AiYeSus on 12/2/2017.
 */


import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

import static java.lang.System.exit;

public class StairCase {

    static int birthdayCakeCandles(int n, int[] ar) {
        // Complete this function
        Arrays.sort( ar );
        int sz = ar.length, count=1;
        for(int i=sz-1; i>0; i--) {
            if ( ar[i] > ar[i-1] ) break;
            count++;
        }
        return count;
    }

    static String timeConversion(String s) {
        s = s.toUpperCase();

        String[] parts = s.split(":");
        int hr=Integer.parseInt(parts[0]);
        if ( s.endsWith("PM") ) {
            if (hr < 12) {
                hr += 12;
            }
        } else if ( s.endsWith("AM") ) {
            if (hr == 12) {
                hr = 0;
            }
        }
        parts[0] = String.format("%02d", hr);
        return parts[0]+":"+parts[1]+":"+parts[2].substring(0,2);
    }

    public static void PlusMinus(int n, float p, float neg, float z) {
        String ratio = String.format("%.6f",(float)(p/n));
        System.out.println(ratio);
        ratio = String.format("%.6f",(float)(neg/n));
        System.out.println(ratio);
        ratio = String.format("%.6f",(float)(z/n));
        System.out.println(ratio);
    }

    public static long[] MinMax(int[] arr) {
        long[] minmax = new long[2];

        Arrays.sort(arr);
        int sz = arr.length;
        int numOfSum=4;
        for(int i=0; i<numOfSum; i++) {
            minmax[0] += arr[i];
        }
        for(int i=sz-1; i>=sz-numOfSum; i--) {
            minmax[1] += arr[i];
        }
        System.out.println(minmax[0]+" "+minmax[1]);
        return minmax;
    }

    public static void StairCase(int n) {
        String stair = "";
        char[] row = new char[n];
        char[] toPrint;
        for(int i=0; i<n; i++) {
            row[i] = ' ';
        }
        for(int i=0; i<n; i++) {
            toPrint = row;
            for (int col = 0; col <= i; col++) {
                toPrint[n-col-1] = '#';
            }
            System.out.println(new String(toPrint));
        }
    }


    public static String padRight(String s, int n) {
        return String.format("%1$-" + n + "s", s);
    }

    public static String padLeft(String s, int n) {
        return String.format("%1$" + n + "s", s);
    }

    public static void main(String[] args) {

        List<Integer> mAsteroids = new ArrayList<>();
        int sz=0, a;
        int[] ast;
        Scanner in = new Scanner(System.in);
        String[] timeArray = {"12:29:54AM",
                "12:39:59PM",
                "00:00:00AM",
                "7:21:38PM"};
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        for(String s : timeArray ) {
            System.out.println(timeConversion(s));
        }

        float p=0, neg=0, z=0f; int num;
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            num = in.nextInt();
            arr[ar_i] = num;
            if( num > 0 ) p++;
            else if ( num < 0 ) neg++;
            else z++;
        }
        System.out.println(padRight("Howto", 10) + "*");
        System.out.println(padLeft("Howto", 10) + "*");
        StairCase( n );
        MinMax(arr);
    }
}