package com.example;
import java.io.File;
import java.io.FileInputStream;
import java.lang.NullPointerException;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TwoLargest {

    public static void main(String args[]) {
        int arr[] = new int[args.length];
        int i, Largest=arr[0], secLargest=0;
        Integer ci = Integer.valueOf(args[0]);

		if (args.length < 2) {
				System.out.println("Array has less than two element.");
			return;
		}
		System.out.println("Integer.valueof '" + args[0] + "' = " + ci);

		for(i=0; i < args.length; i++) {
			arr[i] = Integer.parseInt(args[i]);
			System.out.println("parseInt of '" + args[i] + "' = " + arr[i]);
		}

		if ( arr[0] < arr[1] ) {
			Largest = arr[1];
			secLargest = arr[0];
		} else {
			Largest = arr[0];
			secLargest = arr[1];
		}

		for(i=2; i<arr.length; i++) {
			if (Largest < arr[i]) {
				secLargest = Largest;
				Largest = arr[i];
			} else if (secLargest < arr[i]) {
				secLargest = arr[i];
			}
		}
        System.out.println("Two largest:" + Largest + " " + secLargest + " prod:" + Largest*secLargest);

		// Store them in List
		List<Integer> iList = new ArrayList<Integer>();
		for(i=0; i<arr.length; i++) {
			iList.add(arr[i]);
		}

		Collections.sort(iList);
		int last = iList.size()-1;
		System.out.println("Two largest:" + iList.get(last) + " " + iList.get(last-1)
				+ " prod:" + (int)iList.get(last)*(int)iList.get(last-1));
    }
}  