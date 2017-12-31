package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Created by AiYeSus on 12/2/2017.
 */

public class intArrayAsteroids {

    public static List<Integer> ListOfAsteroid = new ArrayList<Integer>();

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
        return isThereCollision( ast );
    }

    public static boolean isThereCollision(AsteroidLinked headOfLinkedList) {
        boolean collision = false;
        AsteroidLinked node = headOfLinkedList;
        while (node != null && node.next != null) {
            if (node.bearingAndSize > 0 && node.next.bearingAndSize < 0 && !collision)
                collision = true;
            node = node.next;
        }

        if (!collision) {
            node = headOfLinkedList;
            while ( node != null ) {
                ListOfAsteroid.add( node.bearingAndSize );
                node = node.next;
            }
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

    public static void printArray(List<Integer> Asteroids) {
        for(int a : Asteroids) {
            System.out.print( a + " ");
        }
        System.out.println();
    }
    // 10, 3, -2, 5, -7, 9
    public static void main(String[] args) {
        AsteroidLinked astrs;
        int sz=0, a, idx=0;
        int[] ast;
        Scanner in = new Scanner(System.in);
        do {
            astrs = stringToListNode(in.nextLine(), true);
            while (Asteroid(astrs) == true) ;
            System.out.println(ListOfAsteroid);
            ListOfAsteroid.clear();
        } while( astrs.bearingAndSize != -1);
    }
}
