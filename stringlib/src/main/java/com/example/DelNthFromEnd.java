package com.example;

import java.util.Scanner;
import java.util.function.Consumer;

/**
 * Created by AiYeSus on 11/18/2017.
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class DelNthFromEnd {
    private static Consumer<Object> StdOut = x -> System.out.println(x);

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length  = 0;
        ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }
        length -= n;
        first = dummy;
        while (length > 0) {
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        int nxt=-1;
        ListNode mList = null;
        do {
            StdOut.accept("enter next node ");
            nxt = scnr.nextInt();
            mList = new ListNode(nxt);
            mList.next = null;
            mList = mList.next;
        } while ( nxt != -1);
        StdOut.accept("Parsing string to integer:");
        ListNode nList = removeNthFromEnd(mList, 2);
    }
}
