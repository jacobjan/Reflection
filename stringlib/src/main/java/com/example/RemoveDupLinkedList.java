package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by AiYeSus on 11/14/2017.
 */

public class RemoveDupLinkedList {

    static class Node {
        int data;
        Node next;
        Node(int d){
            data=d;
            next=null;
        }
    }

    public static Node removeDuplicates(Node head) {
        if ( head == null || head.next == null) return head;
        List<Integer> lnkedlist = new ArrayList<Integer>();
        Node prv=head, cur = head, temp;
        while ( cur != null ) {
            if ( lnkedlist.contains(cur.data) ) {
                System.out.println(cur.data+"  removed");
                prv.next = cur.next;
                temp=cur;
                // removed
                cur = cur.next;
                temp.next=null;
            } else {
                lnkedlist.add(cur.data);
                prv = cur;
                cur = cur.next;
            }
        }
        return head;
    }

    public static Node insert(Node head,int data) {
        Node p=new Node(data);
        if(head==null)
            head=p;
        else if(head.next==null)
            head.next=p;
        else
        {
            Node start=head;
            while(start.next!=null)
                start=start.next;
            start.next=p;
        }
        return head;
    }

    public static void display(Node head) {
        Node start=head;
        while(start!=null) {
            System.out.print(start.data+" ");
            start=start.next;
        }
    }

    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        Node head=null;
        int T=sc.nextInt();
        while(T-- > 0){
            int ele=sc.nextInt();
            head=insert(head, ele);
        }
        head=removeDuplicates(head);
        display(head);
    }
}