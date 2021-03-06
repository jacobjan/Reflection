package com.example;

import java.util.Date;

/**
 * Created by AiYeSus on 10/30/2017.
 */

public class testNanoTime {
    public testNanoTime() {
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

    public static void main(String[] args) {
        testNanoTime nanoT = new testNanoTime();
        System.out.println("nanoT :" + nanoT.etms());
        System.out.println("Date :" + new Date().toLocaleString());
    }
}