package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by AiYeSus on 10/26/2017.
 */

public class useArrayList {

    static void run(List<Integer> lstInta, List<Integer> lstIntb) {
        lstInta.addAll(lstIntb);
        lstIntb = lstInta;
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 2));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(3, 4));
        run(a, b);
        System.out.println(a.toString()+ b.toString());
    }
}
