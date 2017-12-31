package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by AiYeSus on 10/26/2017.
 */

public class testException {

    public static void run() {
        System.out.println("1");
        try {
            System.out.println("2");
            throw new Exception();
        } catch(Exception e) {
            System.out.println("3");
            return;
        } finally {
            System.out.println("4");
        }
    }

    public static void main(String[] args) {
        run();
    }
}
