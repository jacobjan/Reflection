package com.example;

import java.util.Scanner;

/**
 * Created by AiYeSus on 11/6/2017.
 */

class Calculator {
    int power(int n, int p) throws Exception {
        if ( n < 0 || p < 0 ) {
            throw new Exception("n and p should be non-negative");
        } else {
            return (int)Math.pow((double)n, (double)p);
        }
    }
}

public class mySqroot {
// Calculate square root of float. e.g 53.478 = 7.312866
    private float tolerance = 0.001f;

    public float sqroot(float f, float tolerance) {
        float fbase = 0.0f;
        int n = (int)f/2;
        while ( f < (float)n*n ) {
            n--;
        };
        float nfloor = n + tolerance;
        System.out.println("start fr :"+n);
        while ( nfloor * nfloor < f && nfloor < (float)(n+1)) {
            nfloor += tolerance;
            System.out.println(" sq "+(nfloor * nfloor) + " from square of "+ nfloor);
        }
        return nfloor;
    }

    public float BinarySqroot(float f, float tolerance) {
        int n = (int)f/2;
        while ( f < (float)n*n ) {
            n--;
        };
        float step = 0.5f;
        float nfloor = n + step;
        System.out.println("start fr :"+n);

        while ( Math.abs(nfloor * nfloor - f) > tolerance && nfloor < (float)(n+1)) {
            step /= 2;
            if ( nfloor*nfloor > f ) nfloor -= step;
            else if ( nfloor*nfloor < f ) nfloor += step;
            System.out.println(" sq "+(nfloor * nfloor) + " from square of "+ nfloor);
        }
        return nfloor;
    }

    public static void main(String[] arglist) {
        mySqroot msqr = new mySqroot();
        Scanner scnr = new Scanner(System.in);
        float f1 = 0.0f, fres=0;
        do {
            System.out.println("Enter float to be square rooted :");
            f1 = scnr.nextFloat();
            if ( f1 > 0 ) {
                fres = msqr.BinarySqroot(f1, msqr.tolerance);
                System.out.println("square root of " + f1
                        + " = " + fres + "  with difference "+(f1 - fres*fres));
            }
        } while( f1 > 0 );
    }
}
