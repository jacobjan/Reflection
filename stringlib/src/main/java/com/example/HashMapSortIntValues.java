package com.example;

/**
 * Created by AiYeSus on 11/3/2017.
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/** * How to sort HashMap in Java by keys and values.
 *
 */

public class HashMapSortIntValues {

    public static void main(String args[]) throws ParseException, FileNotFoundException {
        int[][] incM;
        HashMap<Integer, Integer> freqList = new HashMap<>();
        String infile = "C:\\Jihshin\\AndroidStudio\\Reflection\\stringlib\\src\\main\\java\\com\\example\\incomingMissile.txt";
        Scanner in = new Scanner( new FileInputStream( infile ));            //(System.in);
        int nMSL = in.nextInt(), targetFreq = in.nextInt();
        int nMneeded = 1, iIncoming=0;
        incM = new int[nMSL][2];
        for(int iMissile=0; iMissile<nMSL; iMissile++) {
            incM[iMissile][0] = in.nextInt();
            incM[iMissile][1] = in.nextInt();
            freqList.put( incM[iMissile][0], Math.abs(incM[iMissile][1]-targetFreq ));
        }

        System.out.println("HashMap before sorting, random order ");
        Set<Entry<Integer, Integer>> entries = freqList.entrySet();
        for(Entry<Integer, Integer> entry : entries){
            System.out.println(entry.getKey() + " ==> " + entry.getValue());
        }
        // Now let's sort HashMap by keys first
        // all you need to do is create a TreeMap with mappings of HashMap
        // TreeMap keeps all entries in sorted order
        TreeMap<Integer, Integer> sorted = new TreeMap<>(freqList);
        Set<Entry<Integer, Integer>> mappings = sorted.entrySet();
        System.out.println("HashMap after sorting by keys in ascending order ");
        for(Entry<Integer, Integer> mapping : mappings){
            System.out.println(mapping.getKey() + " ==> " + mapping.getValue());
        }
        // Now let's sort the HashMap by values
        // there is no direct way to sort HashMap by values but you
        // can do this by writing your own comparator, which takes
        // Map.Entry object and arrange them in order increasing
        // or decreasing by values.
        Comparator<Entry<Integer, Integer>> valueComparator = new Comparator<Entry<Integer,Integer>>() {
            @Override
            public int compare(Entry<Integer, Integer> e1, Entry<Integer, Integer> e2) {
                Integer v1 = e1.getValue();
                Integer v2 = e2.getValue();
                return v1 > v2 ? 1 : -1;
            }
        };
        // Sort method needs a List, so let's first convert Set to List in Java
        List<Entry<Integer, Integer>> listOfEntries = new ArrayList<Entry<Integer, Integer>>(entries);

        // sorting HashMap by values using comparator
        Collections.sort(listOfEntries, valueComparator);
        LinkedHashMap<Integer, Integer> sortedByValue = new LinkedHashMap<Integer, Integer>(listOfEntries.size());
        // copying entries from List to LinkedHashMap
        for(Entry<Integer, Integer> entry : listOfEntries){
            sortedByValue.put(entry.getKey(), entry.getValue());
        }
        System.out.println("HashMap after sorting entries by values ");
        Set<Entry<Integer, Integer>> entrySetSortedByValue = sortedByValue.entrySet();
        for(Entry<Integer, Integer> mapping : entrySetSortedByValue){
            System.out.println(mapping.getKey() + " ==> " + mapping.getValue());
        }
      } // of main
}

    //Read more: http: www.java67.com/2015/01/how-to-sort-hashmap-in-java-based-on.html#ixzz50Wl0Mr8E