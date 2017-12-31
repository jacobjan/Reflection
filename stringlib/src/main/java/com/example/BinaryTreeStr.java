package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by AiYeSus on 10/27/2017.
 */

public class BinaryTreeStr {
    private int numOfNodeInLevel[] = new int[256];
    private int maxNum=300, max=0, maxLevel=0, depth=0;
    private String rootValue;

    public static void main(String[] args) {
        if ( 1 > args.length )
            new BinaryTreeStr().run("mid");
        else
            new BinaryTreeStr().run("pretend");
    }

    static class Node {
        Node left;
        Node right;
        String value;

        public Node(String value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public void run(String root) {
        ArrayList<String> strList = new ArrayList<>(Arrays.asList("Buenos Aires", "Córdoba", "La Plata", "adb", "am",
                                        "instrument", "class", "aiyesus", "reflection", "Client", "testRunner"));
        String[] sArray2 = "JUNITCORE test runner result manifest".split(" ");
        ArrayList<String> strList2 = new ArrayList<String>(Arrays.asList(sArray2));
        strList.addAll(strList2);

        Node rootnode = new Node(root);
        rootValue = root;
        int TreeLevel = 0;
        System.out.println("Building tree with rootvalue " + rootnode.value);
        System.out.println("=================================");

        for(String s :  strList )
            insert(rootnode, s);
         System.out.println("Traversing tree in order");
        System.out.println("=================================");
        printInOrder(rootnode, depth);
        System.out.println("=================================" );
        System.out.println("Depth of tree: " + depth + "\nLevel " +
                maxLevel + " have max. # of node:" + max );

        BinaryTreeOps.Node rnode;

        searchForValue(rootnode, "rootvalue");
        searchForValue(rootnode, "JUNITCORE");
        searchForValue(rootnode, "Ansi");
        searchForValue(rootnode, "Client");
        searchForValue(rootnode, "La Plata");
    }

    public void searchForValue(Node rootnode, String valToSearch) {
        System.out.println("Searching for " + valToSearch);
        search(rootnode, valToSearch);
    }

    public void insert(Node node, String value) {
        if (value.compareTo(node.value) <= 0 ) {
            if (node.left != null) {
                insert(node.left, value);
            } else {
                System.out.println("  Inserted " + value + " to left of node " + node.value);
                node.left = new Node(value);
            }
        } else if (value.compareTo(node.value) > 0) {
            if (node.right != null) {
                insert(node.right, value);
            } else {
                System.out.println("  Inserted " + value + " 					to right of node " + node.value);
                node.right = new Node(value);
            }
        }
    }

    public void search(Node node, String value) {
        System.out.println(" Searching node:" + node.value );
        if (node != null && node.value.equalsIgnoreCase(value) ) {
            System.out.println("!! Found value:" + node.value + "\n");
            return;
        } else if ( (node.right == null && value.compareTo(node.value) > 0 ) ||
                (node.left == null && value.compareTo(node.value) < 0 ) ) {
            System.out.println(value + " Not Found\n\n");
            return;
        }

        if ( value.compareTo(node.value) > 0 && node.right != null )
            search(node.right, value);
        if ( value.compareTo(node.value) < 0 && node.left != null )
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
