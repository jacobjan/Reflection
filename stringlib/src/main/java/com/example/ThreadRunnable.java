package com.example;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by AiYeSus on 10/26/2017.
 */

public class ThreadRunnable {

    public static int num = 0;

    public int idxOf1stMatch(int ele, int[] array) {
        for(int i=0; i<array.length; i++) {
            if ( ele == array[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void testThread() {
        num = 0;
        for(int i=0; i<10; i++) {
            new Thread(new Runnable() {
                public void run() {
                    num++;
                }
            }).start();
        }
        System.out.println( num );
    }

    public static void main(String[] args) {
        for(int i=0; i<10; i++) {
            System.out.print( i + " - ");
            testThread();
        }
    }

}
