package com.example;

import java.util.Scanner;

/**
 * Created by AiYeSus on 12/14/2017.
 */

class iNode {
    int data;
    iNode next;
    iNode(int d) {
        data = d;
        next = null;
    }
}

public class newLinkedList {

    public static iNode insert(iNode head,int data) {
        iNode newN = new iNode( data );
        //System.out.print(data + " ");
        if ( head == null ) {
            head = newN;
        } else {
            iNode cn = head;
            while ( cn.next != null ) {
                cn = cn.next;
            }
            cn.next = newN;
        }
        return head;
    }

    public static void deleteNode(iNode head, int key)
    {
        // Store head node
        iNode temp = head, prev = null;

        // If head node itself holds the key to be deleted
        if (temp != null && temp.data == key) {
            head = temp.next; // Changed head
            return;
        }

        // Search for the key to be deleted, keep track of the
        // previous node as we need to change temp.next
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        // If key was not present in linked list
        if (temp == null) return;

        // Unlink the node from linked list
        prev.next = temp.next;
    }


    /* Method to remove duplicates from an
       unsorted linked list */
    public static iNode remove_duplicates(iNode head) {
        iNode ptr1 = null, ptr2 = null, dup = null;
        ptr1 = head;

        /* Pick elements one by one */
        while (ptr1 != null && ptr1.next != null) {
            ptr2 = ptr1;
            /* Compare the picked element 'ptr2' with rest of the elements */
            while (ptr2.next != null) {
                /* If duplicate then delete it */
                if (ptr1.data == ptr2.next.data) {
                    /* sequence of steps is important here */
                    dup = ptr2.next;
                    ptr2.next = ptr2.next.next;
                    System.gc();
                } else /* This is tricky */ {
                    ptr2 = ptr2.next;
                }
            }
            ptr1 = ptr1.next;
        }
        return head;
    }

    public static iNode reverse(iNode head) {
        iNode prev = null;
        iNode current = head;
        iNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }

    public static void display(iNode head) {
        iNode start = head;
        while(start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        iNode head = null;
        int N = sc.nextInt();

        while (N-- > 0) {
            int ele = sc.nextInt();
            head = insert(head, ele);
        }
        display(head);
        head = reverse(head);
        System.out.println("\nReverse linked list :");
        display(head);

        head = remove_duplicates(head);
        System.out.println("\nRemoved duplicated linked list :");
        display(head);

        int irm = 0;
        while (irm != -1) {
            System.out.println("\nElement to remove :");
            irm = sc.nextInt();
            deleteNode(head, irm);
            System.out.println("\nRemoved linked list :");
            display(head);
        }

        sc.close();
    }
}
