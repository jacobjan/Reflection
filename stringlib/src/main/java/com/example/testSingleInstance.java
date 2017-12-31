package com.example;

/**
 * Created by AiYeSus on 10/26/2017.
 */

public class testSingleInstance {
    private testSingleInstance() {
    }

    private static testSingleInstance instance;

    public synchronized static testSingleInstance getInstance() {
        if ( instance == null )
            instance = new testSingleInstance();
        return instance;
    }

    public static void main(String[] args) {
        testSingleInstance tis = new testSingleInstance();
    }
}
