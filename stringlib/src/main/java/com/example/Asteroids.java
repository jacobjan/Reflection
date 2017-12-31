package com.example;

/**
 * Created by AiYeSus on 12/2/2017.
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import static java.lang.System.exit;

class AsteroidLinked {
    int bearingAndSize;
    AsteroidLinked next;
    AsteroidLinked(int x) { bearingAndSize = x; }
}
public class Asteroids {

    public static boolean Asteroid(AsteroidLinked ast) {

        int curr, nxt, prev;
        AsteroidLinked ptr = ast, prevNode=null;
        while ( ptr != null && ptr.next != null  ) {
            curr = ptr.bearingAndSize;
            nxt = ptr.next.bearingAndSize;

            if ( curr > 0 && nxt < 0 ) {
                if (Math.abs(curr) > Math.abs(nxt)) {
                    ptr.next = ptr.next.next;
                } else if (Math.abs(curr) < Math.abs(nxt)) {
                    if ( prevNode == null ) ast = ptr.next;
                    else prevNode.next = ptr.next;
                } else {
                    if ( prevNode == null ) ast = ptr.next.next;
                    else prevNode.next = ptr.next.next;
                }
            }
            prevNode = ptr;
            ptr = ptr.next;
        }
        return prettyPrintLinkedList( ast );
    }

    public static boolean prettyPrintLinkedList(AsteroidLinked node) {
        boolean collision = false;
        while (node != null && node.next != null) {
            System.out.print(node.bearingAndSize + ",");
            if (node.bearingAndSize > 0 && node.next.bearingAndSize < 0 && !collision)
                collision = true;
            node = node.next;
        }

        if (node != null) {
            System.out.println(node.bearingAndSize);
        } else {
            System.out.println("[]");
        }
        return collision;
    }

    public static AsteroidLinked stringToListNode(String input, boolean Ascending) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);
        int len = nodeValues.length;

        // Now convert that list into linked list
        AsteroidLinked dummyRoot = new AsteroidLinked(0);
        AsteroidLinked ptr = dummyRoot;

        for (int item : nodeValues) {
            ptr.next = new AsteroidLinked(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(0, input.length() );
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static int[] linkedListToArray(AsteroidLinked node) {
        List<Integer> astList = new ArrayList<Integer>();
        while (node != null ) {
            astList.add(node.bearingAndSize);
            node = node.next;
        }
        System.out.println();
        int[] res = new int[astList.size()];
        int i=0;
        for(int a : astList) {
            res[i] = a;
            i++;
        }

        return res;
    }
// 10 3 -2 5 -7 9
    public static void main(String[] args) {
        AsteroidLinked astrs;
        int sz=0, a, idx=0;
        int[] ast;
        Scanner in = new Scanner(System.in);
        do {
            astrs = stringToListNode(in.nextLine(), true);
            while (Asteroid(astrs) == true && ++idx < 10) ;
            linkedListToArray( astrs );
        } while ( astrs.bearingAndSize != -99 );
    }
}
/*
        Integer[] integerArray = mAsteroids.toArray(new Integer[0]);
        int[] ast = ArrayUtils.toPrimitive(integerArray);
*/
 /*       StringBuffer strBuffer = new StringBuffer();

        for(Object o:mAsteroids){
            strBuffer.append(o+ " ");
        }

        int [] ast = new int[]{Integer.parseInt(strBuffer.toString())};
*/
