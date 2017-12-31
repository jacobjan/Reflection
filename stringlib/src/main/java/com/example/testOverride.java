package com.example;

/**
 * Created by AiYeSus on 10/26/2017.
 */

class A {
    public void print() {
        System.out.println("A");
    }
}

class B extends A {
    public void print() {
        System.out.println("B");
    }
}

public class testOverride {
    static double retDbl(int a, double b) {
        return 0.0;
    }

    int retnum(int a, double b) {
        return 0;
    }

    float retnum(double b) {
        return 0.0f;
    }

    public static void main(String[] args) {
        A obja = new B();
        obja.print();

        System.out.println("Cast 'new B' to A");
        obja = (A)new B();
        obja.print();

        A obj = new A();
        obj.print();
    }
}
