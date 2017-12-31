package com.example;

import java.util.Arrays;

/**
 * Created by AiYeSus on 11/13/2017.
 */

public class CompareTwoCollections {
    public static void main(String[] argsArray) {

        int[] a = {1, 2, 3};
        int[] b = a;
        System.out.println(a == b);
        //returns true as b and a refer to the same array

        int[] aArr = {1, 2, 3};
        int[] bArr = {1, 2, 3};
        System.out.println(Arrays.equals(aArr, bArr));
        //returns true as a and b are meaningfully equal

        System.out.println("Are two array point to the same obj ? "+ (aArr == bArr));

        int[] cArr = {1, 2, 3, 90};
        System.out.println("After add a element to 2nd array :" + Arrays.equals(aArr, cArr));

        int[] arndArr = {15, 2, 13};
        int[] brndArr = {13, 15, 2};
        System.out.println(Arrays.equals(arndArr, brndArr));
        Arrays.sort(arndArr);
        Arrays.sort(brndArr);
        System.out.println("Sorted array :" + Arrays.equals(arndArr, brndArr));


    }
}
