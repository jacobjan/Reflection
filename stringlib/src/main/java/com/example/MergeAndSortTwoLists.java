package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by AiYeSus on 10/26/2017.
 */

public class MergeAndSortTwoLists {

    static void MergeAndSortTwoLists(List<Integer> listInta, List<Integer> listIntb) {
        listInta.addAll(listIntb);
        Collections.sort(listInta);
        System.out.println("Merge and sorted new list :" + listInta);
        // Now use Set to get remove duplcates
        Set<Integer> LinkedHashSetofint = new LinkedHashSet<Integer>();
        LinkedHashSetofint.addAll(listInta);
        listInta.clear();
        listInta.addAll(LinkedHashSetofint);
    }

    // duplicates in the result list ([1,2,2,3] and [2,2,3,4] should intersect as [2,2,3] and not just [2,3]).
    static List<Integer> GetIntersectionOfTwoLists(List<Integer> listInta, List<Integer> listIntb) {
        HashMap<Integer, Integer> comMap = new LinkedHashMap<>();
        List<Integer> intersect = new ArrayList<>();
        // Store 1st list into map
        int count = 0;
        for(int i : listInta) {
            if ( comMap.containsKey(i) ) {
                int val = comMap.get(i);
                val++;
                comMap.put(i, val);
            } else {
                comMap.put(i, ++count);
            }
            count=0;
        }
        System.out.println("1st List of ints "+listInta);
        printMap( comMap );
        for(int i : listIntb) {
            if (comMap.containsKey(i)) {
                int val = comMap.get(i);
                val++;
                comMap.put(i, val);
            }
        }
        System.out.println("add 2nd list of ints");
        printMap( comMap );
        //printMap( comMap );
        // iterate thru hashmap
        // Set remove the duplicate key.  We want to preserve the duplicate item in intersection
        //Set<Integer> kset = comMap.keySet();
/*        for(int k : kset ) {
            if ( comMap.get(k) > 1 ) {
                intersect.add(k);
            }
        }
        for (int value : comMap.values()) {
            if ( value > 1 ) {
                intersect.add(comMap.get(value));
            }
        }
 */       for (Map.Entry<Integer, Integer> entry : comMap.entrySet()) {
            if ( entry.getValue() > 1 ) {
                intersect.add(entry.getKey());
            }
        }
        return intersect;
    }

    public static void printMap(Map mp) {
        Iterator it = mp.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(7, 23, 4, 341, 89776554, 2, 1));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(12, 3, 4, 23, 7, 341, 89776554, 2, 1));
        MergeAndSortTwoLists(a, b);
        System.out.println("New list remove duplicates using LinkedHashSet:" + a);

        a = new ArrayList<>(Arrays.asList(1, 2, 2, 3));
        b = new ArrayList<>(Arrays.asList(2, 2, 3, 4, 23));

        System.out.println("intersection of two list:" + GetIntersectionOfTwoLists(a, b));
    }
}
