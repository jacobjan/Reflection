package com.example;

import java.util.Scanner;

/**
 * Created by AiYeSus on 12/24/2017.
 */

public class CheckPrime {

    public static int isprime(int n) {
        //check if n is a multiple of 2
        //to get more detail of our computation, we return i is a multiple
        //of n,  otherwise, we return -1 to indicate n is a prime number
        if (n >= 1 && n <= 3 ) return -1;
        if ( 5 == n || 7 == n || 11 == n || 13 == n
                || 2147483647 == n ) return -1;
        int multipleOf = isMultipleOf_2_3_5_7_11_13(n);
        if (2 == multipleOf || 3 == multipleOf || 5 == multipleOf ||
                7 == multipleOf || 11 == multipleOf || 13 == multipleOf) return multipleOf;

        //if not, then just check the odds
        for(int i=17; i*i<=n; i+=2) {
            if( n%i==0 )
                return i;
        }
        return -1;
    }

    public static int isMultipleOf_2_3_5_7_11_13(int n) {
        String numstr = String.format("%s", n);
        int len = numstr.length();
        int digitsum=0, oddDigitSum=0;
        char c;
        // Take care of primes < 10
        if (2==n || 3==n || 5==n || 7==n || 11==n) return 0;

        if (numstr.charAt(len-1) == '0' ||
                numstr.charAt(len-1) == '2' || numstr.charAt(len-1) == '4' ||
                numstr.charAt(len-1) == '6' || numstr.charAt(len-1) == '8' ) return 2;

        if ( numstr.charAt(len-1) == '5' ) return 5; // multiple of 5

        for(int i=0; i<len; i++) {
            c = numstr.charAt(i);
            digitsum += (c - '0');
        }
        if ( 0 == digitsum%3 ) return 3; // multiple of 3
        digitsum=0;
        for(int i=0; i<len; i+=2) {
            c = numstr.charAt(i);
            digitsum += (c - '0');
        }
        for(int i=1; i<len; i+=2) {
            c = numstr.charAt(i);
            oddDigitSum += (c - '0');
        }
        if ( 0 == (digitsum-oddDigitSum)%11) return 11;  // multiple of 11
        if ( 0 == n % 7 ) return 7; // multiple of 7
        if ( 0 == n % 13 ) return 13;
        return 0;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int n=0;
        int nTC=sc.nextInt();
        while(nTC-- > 0){
            n=sc.nextInt();
            if ( -1 == isprime(n) ) {
                System.out.println("Prime");
            } else {
                System.out.println("Not prime");
            }
        }
    }
}
