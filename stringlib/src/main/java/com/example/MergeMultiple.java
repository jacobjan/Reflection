package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by AiYeSus on 11/13/2017.
 */

public class MergeMultiple {
    public static void main(String[] argsArray) {
        // Merge two List of String into one and create a new unique list of string
        List<String> listA = new ArrayList<String>();

        listA.add("List");
        listA.add("ArrayList");
        listA.add("Set");
        listA.add("ArrayList");
        listA.add("HashSet");

        List<String> listB = new ArrayList<String>();

        listB.add("ArrayList");
        listB.add("Set");
        listB.add("HashSet");

        listB.addAll( listA );
        System.out.println("Merged List with possible duplications :\n"+listB);

        System.out.println("\nNow use 'Set<String> mSet = new HashSet<String>(listA)' to remove duplicated element");
        Set<String> setPopulateItFrom_listA = new HashSet<String>(listA);

        System.out.println("\nNow use 'mSet.addAll(listB)' from listB");
        setPopulateItFrom_listA.addAll(listB);

        // Convert back to list from Set
        List<String> newList = new ArrayList<String>(setPopulateItFrom_listA);
        System.out.println("New List :"+newList);
        Collections.sort(newList);
        System.out.println("New List - Sorted :"+newList);
    }
}
