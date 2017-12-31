package com.example;

import java.io.*;
import java.util.*;
/**
 * Created by AiYeSus on 12/18/2017.
 */
interface AdvancedArithmetic{
    int divisorSum(int n);
}

class CalculatorIA implements AdvancedArithmetic {
    public int divisorSum (int n) {
        int sum=n;
        for(int i=1; i<(n/2+1); i++) {
            if ( n % i == 0 ) {
                sum += i;
                System.out.print(i + " ");
            }
        }
        return sum;
    }
}

public class DivisorSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();

        AdvancedArithmetic myCalculator = new CalculatorIA();
        int sum = myCalculator.divisorSum(n);
        System.out.println("I implemented: " + myCalculator.getClass().getInterfaces()[0].getName() );
        System.out.println(sum);
    }

}
