package com.example;

import java.util.Scanner;

/**
 * Created by AiYeSus on 10/30/2017.
 */

public class ScannerHasNext {
    private int numOfNodeInLevel[] = new int[256];

    public static void main(String[] args) {
        StringBuilder sBdr = new StringBuilder();
        for(String s : args ) {
            if ( sBdr.indexOf( s ) < 1 ) {
                sBdr.append( s + " ");
            }
        }
        System.out.println( sBdr.toString() + "\nScanner result:");
        Scanner sc=new Scanner( sBdr.toString() );
        while ( sc.hasNext() ) {
            if ( sc.hasNextInt() ) {
                System.out.print( sc.nextInt() + " ");
            } else {
                sc.next();
            }
        }
    }
}
