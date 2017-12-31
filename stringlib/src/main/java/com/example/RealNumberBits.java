package com.example;

/**
 * Created by AiYeSus on 10/18/2017.
 */

import java.util.Scanner;
public class RealNumberBits {

    public static String dec2bin(int decval)
    {
        StringBuffer sbuf =new StringBuffer();
        while(decval>1)
        {
            sbuf.append( decval % 2 ) ;
            decval = decval /2;
        }
        if (decval==1)
            sbuf.append(1);

        return sbuf.reverse().toString();
    }

    public static String frac2bin(double fval) {
        StringBuffer sbuf =new StringBuffer();
        while(fval != 0) {
            fval = fval * 2;
            sbuf.append((int)Math.floor(fval)) ;
         //   System.out.println(fval + " sbuf :"+sbuf.toString());
            fval = (fval>=1) ? fval-1 : fval;
        }
        return sbuf.reverse().toString();
    }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("Fractional decimal to Binary Conversion");

        System.out.println("Enter double value");
        double val=sc.nextDouble();
        sc.close();

        int decpart = (int)val;
        double fracpart = (val - decpart);

        StringBuffer bits = new StringBuffer();
        String ibits =  RealNumberBits.dec2bin(decpart);
        String fbits =  RealNumberBits.frac2bin(fracpart);

        bits.append(ibits);
        bits.append('.');
        bits.append(fbits);

        System.out.println("\nDecimal value :" + decpart);
        System.out.println("Binary :" + ibits);

        System.out.println("\nFractional value :" + fracpart);
        System.out.println("Binary :" + fbits);

        System.out.println("\nDecimal with Fraction number :" + val);
        System.out.println("Binary :" + bits);
    }
}