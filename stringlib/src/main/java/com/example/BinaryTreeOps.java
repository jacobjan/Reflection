package com.example;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by AiYeSus on 10/27/2017.
 */
class getNanoTime {
    public getNanoTime() {
        reset();
    }
    public void reset() {
        t0=System.nanoTime();
    }
    public long t0() {
        return t0;
    }
    public long dt() {
        return System.nanoTime()-t0();
    }
    public double etms() {
        return etms(dt());
    }
    @Override
    public String toString() {
        return etms()+" ms.";
    }
    public static double etms(long dt) {
        return dt/1000000.; // 1_000_000. breaks cobertura
    }
    private Long t0;
}

public class BinaryTreeOps {
    private int numOfNodeInLevel[] = new int[256];
    private static int maxNum=30000;
    private int max=0, maxLevel=0, depth=0, rootValue;

    public static void main(String[] args) {
        if ( 1 > args.length )
            new BinaryTreeOps().run(Integer.parseInt(args[0]));
        else
            new BinaryTreeOps().run( (BinaryTreeOps.maxNum) / 2);
    }

    static class Node {
        Node left;
        Node right;
        int value;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public void run(int root) {
        Node rootnode = new Node(root);
        rootValue = root;
        int TreeLevel = 0;
        System.out.println("Building tree with rootvalue " + rootnode.value);
        System.out.println("=================================");
        Random rnd = new Random();
        for(int j=0; j < 5000; j++ )
            insert(rootnode, rnd.nextInt() % maxNum);
        insert(rootnode, 63);
        insert(rootnode, 15);
        insert(rootnode, 231);
         insert(rootnode, 91);
        insert(rootnode, 105);
        insert(rootnode, 160);
        insert(rootnode, 231);
        insert(rootnode, 79);
        System.out.println("Traversing tree in order");
        System.out.println("=================================");
        printInOrder(rootnode, depth);
        System.out.println("=================================" );
        System.out.println("Depth of tree: " + depth + "\nLevel " +
                maxLevel + " have max. # of node:" + max );

        Scanner sc=new Scanner(System.in);
        int int2Search = 15;
        do {
            getNanoTime currNaneTime = new getNanoTime();
            searchForValue(rootnode, int2Search);
            System.out.println("Time Elapse :"+currNaneTime.toString());
            // Compare it with binery search on sorted int array, Arraylist

            System.out.println("Another integer to search (-1 to stop ) ?");
            int2Search = sc.nextInt();
        } while ( int2Search != -1 );
    }

    public void searchForValue(Node rootnode, int valToSearch) {
        System.out.println("Searching for " + valToSearch);
        search(rootnode, valToSearch);
    }

    public void insert(Node node, int value) {
        if (value <= node.value) {
            if (node.left != null) {
                insert(node.left, value);
            } else {
                System.out.println("  Inserted " + value + " to left of node " + node.value);
                node.left = new Node(value);
            }
        } else if (value > node.value) {
            if (node.right != null) {
                insert(node.right, value);
            } else {
                System.out.println("  Inserted " + value + " 					to right of node " + node.value);
                node.right = new Node(value);
            }
        }
    }

     public void search(Node node, int value) {
        System.out.println(" Searching node:" + node.value );
        if (node != null && node.value == value) {
            System.out.println("!! Found value:" + node.value + "\n");
            return;
        } else if ( (node.right == null && value > node.value ) ||
                    (node.left == null && value < node.value ) ) {
            System.out.println(value + " Not Found\n\n");
            return;
        }

        if ( node.value < value && node.right != null )
            search(node.right, value);
        if ( node.value > value && node.left != null )
            search(node.left, value);

    }

    public void printInOrder(Node node, int level) {

        if (node != null) {
            numOfNodeInLevel[level]++;
            System.out.println("Level " + level + " value:"
                    + node.value + " # of node:"+ numOfNodeInLevel[level]);
            if ( max < numOfNodeInLevel[level] ) {
                maxLevel = level;
                max = numOfNodeInLevel[level];
            }
            level++;
            depth = level;
            printInOrder(node.left, level);
            printInOrder(node.right, level);
        }
    }
}
