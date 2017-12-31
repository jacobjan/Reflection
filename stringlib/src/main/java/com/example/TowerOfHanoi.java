package com.example;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by AiYeSus on 11/5/2017.
 * 	private static int start_pole = 1;
     private static int end_pole = 3;
     static int steps = 0;

     private static void toHanoi(int n, int startPole, int endPole) {
     if ( 0 == n ) return;

     int mid = 6 - startPole - endPole;
     toHanoi(n-1, startPole, mid);
     //		disp("Move "+n+" from "+startPole+" to "+endPole, true);
     disp("TowerOfHanoi :"+n+", "+startPole+", "+endPole, true);
     toHanoi(n-1, mid, endPole);
     }

 private static void disp(String str, boolean show) {
     steps++;
     if ( show )	System.out.println(steps + " : " + str);
 }

 public static void main(String[] args) {
     for(int peck=2; peck<4; peck++) {
         toHanoi(peck, start_pole, end_pole);
         System.out.println("# of peck:"+peck+ " take "+steps+ "  steps");
         steps = 0;
     }
 }
 */
// Use stacks to move pecks from pole 1 to pole 3
public class TowerOfHanoi {

    public static void disp(Stack stack) {
        Iterator itr = stack.iterator();
        while ( itr.hasNext() ) {
            System.out.println( itr.next()+" " );
        }
    }
    public static Stack populateStack(int arr[]) {
        Stack mstk = new Stack();
        for(int i=0; i<arr.length; i++)
            mstk.push( arr[i] );
        return mstk;
    }
    public static int[] popStack(Stack stk) {
        int[] intArr=new int[stk.size()];
        int idx=0;
        while ( !stk.empty() ) {
            intArr[idx++] = (int) stk.pop();
        }
        return intArr;
    }

    public static void main(String[] args) {
        Stack pole1 = new Stack(), pole2 = new Stack(), pole3 = new Stack();
        int npecks[]=new int[]{1,2,3,4};

        pole1 = populateStack(npecks);
        System.out.print( "pole1 Size :" + pole1.size()+"\n");
        disp( pole1 );
        npecks = popStack( pole1 );

        pole2 = populateStack(npecks);
        System.out.print( "pole1 Size :" + pole2.size()+"\n");
        disp( pole2 );

        pole3 = populateStack(npecks);
        System.out.print( "pole1 Size :" + pole3.size()+"\n");
        disp( pole3 );
    }
}
