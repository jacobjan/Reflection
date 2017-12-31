package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class SingleLinkedList {

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(0, input.length() - 1);
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

    public static ListNode stringToListNode(String input, boolean Ascending) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);
        Arrays.sort(nodeValues);
        int len = nodeValues.length;

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        if ( Ascending ) {
            for (int item : nodeValues) {
                ptr.next = new ListNode(item);
                ptr = ptr.next;
            }
        } else {
            for(int i=len-1; i >= 0; i--) {
                ptr.next = new ListNode(nodeValues[i]);
                ptr = ptr.next;
            }
        }
        return dummyRoot.next;
    }

    public static void prettyPrintLinkedList(ListNode node) {
        while (node != null && node.next != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }

        if (node != null) {
            System.out.println(node.val);
        } else {
            System.out.println("Empty LinkedList");
        }
    }

    public static ListNode mergeSortedLinkedLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.val < l2.val){
            l1.next = mergeSortedLinkedLists(l1.next, l2);
            return l1;
        }
        else{
            l2.next = mergeSortedLinkedLists(l1, l2.next);
            return l2;
        }
    }

    public static ListNode mergeLinkedLists(ListNode node1, ListNode node2) {
        List<Integer> listOfNode1 = new ArrayList<Integer>();
        while (node1 != null && node1.next != null) {
            listOfNode1.add(node1.val);
            node1 = node1.next;
        }
        if ( node1.next == null && node1 != null ) listOfNode1.add(node1.val);

        List<Integer> listOfNode2 = new ArrayList<Integer>();
        while (node2 != null && node2.next != null) {
            listOfNode2.add(node2.val);
            node2 = node2.next;
        }
        if ( node2.next == null && node2 != null ) listOfNode1.add(node2.val);

        if ( listOfNode1.size() == 0 && listOfNode2.size() == 0) return null;

        listOfNode1.addAll(listOfNode2);
        Collections.sort(listOfNode1);
        Iterator itr = listOfNode1.iterator();
       // List<Integer> lstOfInt = new ArrayList<Integer>();
        ListNode lnode;
        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        int intval;
        while ( itr.hasNext() ) {
            intval = (Integer) itr.next();
            ptr.next = new ListNode( intval );
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = "23, 45, 9100, 21, 98";
        ListNode frstnode = stringToListNode(line, true);
        prettyPrintLinkedList(frstnode);

        while ((line = in.readLine()) != null) {
            ListNode node = stringToListNode(line, true);
            prettyPrintLinkedList(node);
            System.out.println("\n------Merge two sorted LinkedList--------\n");
            prettyPrintLinkedList(mergeLinkedLists(frstnode, node));
            //System.out.println("\n------Reverse LinkedList--------\n");
            //ListNode revnode = stringToListNode(line, false);
            // prettyPrintLinkedList(revnode);
        }
    }
}

