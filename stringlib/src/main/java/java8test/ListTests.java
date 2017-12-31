package java8test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class ListTests {
	
    public static void printlist(Iterator itr ) {
	    System.out.println("List contain following:");
	    while(itr.hasNext()) {
	        System.out.print(itr.next() + "  ");
	    }
	    System.out.println("");
    }

    public void printOddNumber() {
        for(int i=1; i <=99; i++){
            if ( i % 2 == 1 )
                System.out.println(i);
        }
        System.out.println("");
    }

    public static int largestInt(int[] arr) {
        int largest;
        ArrayList<Integer> iLst = new ArrayList<Integer>();

        for(int i=0; i<arr.length; i++) {
            iLst.add( arr[i] );
        }

        Collections.sort(iLst);
        return iLst.get(iLst.size()-1);
    }


    public static void main(String[] args) {
/*
    	LinkedList<String> llst=new LinkedList<String>();
    	llst.add("bye");
    	llst.add("ace");
    	llst.add("cure");
    	llst.add("fragment");
    	llst.add("FragmentManager");
    	llst.add("beginTransaction");
    	llst.add("external");
    	llst.add("done");
*/
		int iarr[] = {1,32,-5, 2, 3, 455, 7, 211, 103, 217, 19}; //{1,32,-5,2,3,5,7,11,13,17,19};
		List iLst = Arrays.asList(iarr);
		System.out.println("List Size :"+iLst.size());
        List<Integer> ListfromIntArray = Arrays.stream(iarr).boxed().collect(Collectors.toList());
        Collections.sort( ListfromIntArray );
        System.out.println("Largest Int :"+ListfromIntArray.get( ListfromIntArray.size()-1 ));
        System.out.println("ListfromIntArray Size :"+ListfromIntArray.size());
        Iterator it=ListfromIntArray.iterator();
        printlist( it );
        StringBuffer sb = new StringBuffer("asd");
        System.out.println("Largest Int (after Collection.sort :"+largestInt( iarr ));
 /*       LinkedList<Integer> llst = new LinkedList<>();
        for(int i : iarr ) {
            llst.add(i);
        }
		System.out.println("Size :"+llst.size());

        it=llst.iterator();
        printlist( it );
        
        it = llst.descendingIterator();
        System.out.println("\nReverse the list by using LinkedList.descendingIterator----.");
        printlist( it );        
                
        System.out.println("Initial Size of LINKEDLIST :"+llst.size());
        // get value and does not remove element from queue
        System.out.println("LINKEDLIST peek :"+llst.peek());
        // get first value and remove that object from queue
        System.out.println("LINKEDLIST poll :"+llst.poll());
        System.out.println("Size of LINKEDLIST after poll :"+llst.size());*/
    }
}