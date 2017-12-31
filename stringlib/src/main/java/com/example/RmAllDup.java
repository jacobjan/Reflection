package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

/**
 * Created by AiYeSus on 11/1/2017.
 */

public class RmAllDup {
    public static Consumer<Object> StdOut = x -> System.out.print(x);

    public static void main(String[] args) {

        int iarr[] = {1, 2, 3, 5, 3, 7, 3, 17, 11, 13, 17, 2, 5, 19};
        Arrays.sort( iarr );
        List lst = Arrays.asList(iarr);
        Set set = new HashSet(lst);
        lst = new ArrayList( set );
        Iterator itr = lst.iterator();
        while ( itr.hasNext() ) StdOut.accept(itr.next() + " ");

        List<Integer> IntList = new ArrayList<Integer>();
        LinkedList<Integer> llst = new LinkedList<Integer>();
        for(int i : iarr ) {
            if ( !llst.contains(i))
                llst.add(i);
        }
        int[] noduparr = llst.stream().mapToInt(i -> i).toArray();
        for(int i : noduparr ) {
            StdOut.accept(i+" ");
        }
        //IntList = new ArrayList<Integer>(Arrays.asList( iarr ));;
    }

}
