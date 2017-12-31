package com.example;

/**
 * Created by AiYeSus on 11/29/2017.
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConvertListToSet {

    public static void main( String[] args ) {
        System.out.println("List values .....");
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("1");

        for (String temp : list){
            System.out.println(temp);
        }

        Set<String> set = new HashSet<String>(list);

        System.out.println("Set values .....");
        for (String temp : set){
            System.out.println(temp);
        }

        int[] iarr = {1,2,2,3,4,4,5,3};
        List ListOfInt = Arrays.asList( iarr );
        List<Integer> iaList = new ArrayList<Integer>();
        for(int i : iarr ) {
            iaList.add(i);
        }
        System.out.println("list of int ctn and size :"+iaList+" "+iaList.size());
        Set<Integer> iset = new HashSet<Integer>(iaList);

        System.out.println("Set values and size....."+iset.size());
        for (int temp : iset){
            System.out.println(temp);
        }
    }
}