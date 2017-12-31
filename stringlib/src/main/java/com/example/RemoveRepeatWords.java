package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RemoveRepeatWords {

    public void UniqueListOfSring( List<String> inList ) {
        HashSet<String> uniqSet = new HashSet<>();
        uniqSet.addAll(inList);
        inList.clear();
        inList.addAll(uniqSet);
    }

    public static void main(String[] args) {
        RemoveRepeatWords uniqCollection = new RemoveRepeatWords();
        Scanner scnr = new Scanner(System.in);
        List<String> sList = new ArrayList<String>();
        String teststr = "Use Set To Remove Dup Element HashSet Set Use KeySet";
        String sArr[] = teststr.split(" ");
        for(String s : sArr ) {
            sList.add( s );
        }
        //sList.addAll( sArr );
        System.out.println("List of string to check: "+sList.toString()+"   size:"+sList.size());
        uniqCollection.UniqueListOfSring( sList );
        System.out.println("List of string with no duplicate: "+sList.toString()+"   size:"+sList.size());
        Collections.sort(sList);
        System.out.println("List of string - Sorted: "+sList.toString()+"   size:"+sList.size());
    }
}

/*
  Comparator<Map.Entry<List<Integer>, Float>> valueComparator = new Comparator<Map.Entry<List<Integer> ,Float>>() {
            @Override
            public int compare(Map.Entry<List<Integer>, Float> e1, Map.Entry<List<Integer>, Float> e2) {
                Float v1 = e1.getValue();
                Float v2 = e2.getValue();
                if ( v1 < v2 ) return -1;
                else if ( v1 > v2 ) return 1;
                else return 0;
            }
        };

        List<String> sList = new ArrayList<String>();
        String teststr = "Use Set To Remove Dup Element HashSet Set Use KeySet";
        String sArr[] = teststr.split(" ");
        for(String s : sArr ) {
            sList.add( s );
        }
        //sList.addAll( sArr );
        System.out.println("List of string to check: "+sList.toString()+"   size:"+sList.size());
        uniq.UniqueListOfSring( sList );
        System.out.println("List of string with no duplicate: "+sList.toString()+"   size:"+sList.size());
        Collections.sort(sList);
        System.out.println("List of string - Sorted: "+sList.toString()+"   size:"+sList.size());
*/

/*        int nxt=-1;
        ListNode mList = null;
        do {
            System.out.println("enter next node ");
            nxt = scnr.nextInt();
            mList = new ListNode(nxt);
            mList.next = null;
            mList = mList.next;
        } while ( nxt != -1);
     */
