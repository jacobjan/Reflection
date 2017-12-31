package com.example;

import java.util.Iterator;
import java.util.LinkedList;

public class RevLinkedList {
	
    public static void printlist(Iterator itr ) {
	    System.out.println("List contain following:");
	    while(itr.hasNext()) {
	        System.out.print(itr.next() + "  ");
	    }
	    System.out.println("");
    }
    
    public static void main(String[] args) {
    	LinkedList<String> llst=new LinkedList<String>();
    	llst.add("bye");
    	llst.add("ace");
    	llst.add("cure");
    	llst.add("fragment");
    	llst.add("FragmentManager");
    	llst.add("beginTransaction");
    	llst.add("external");
    	llst.add("done");
		int iarr[] = {1,2,3,5,7,11,13,17,19};
/*
        LinkedList<Integer> llst = new LinkedList<Integer>();
        for(int i : iarr ) {
            llst.add(i);
        }
*/

        Iterator it=llst.iterator();
        printlist( it );
        
        it = llst.descendingIterator();
        System.out.println("\nReverse the list by using LinkedList.descendingIterator----.");
        printlist( it );        
                
        System.out.println("Initial Size of LINKEDLIST :"+llst.size());
        // get value and does not remove element from queue
        System.out.println("LINKEDLIST peek :"+llst.peek());
        // get first value and remove that object from queue
        System.out.println("LINKEDLIST poll :"+llst.poll());
        System.out.println("Size of LINKEDLIST after poll :"+llst.size());
		StringBuilder strBder = new StringBuilder( llst.peekLast() );
		System.out.println("Reverse string "+llst.peekLast()+ " = "+strBder.reverse().toString() );
		// Reverse a string
		Class myC = llst.getClass();
		String str2Reverse = myC.getCanonicalName();
		// Use for loop to reverse
		char[] charArr = str2Reverse.toCharArray();
		StringBuilder strbldr = new StringBuilder();
		for(int i=charArr.length; i>0; i--) {
			strbldr.append(charArr[i-1]);
		}
		System.out.println("Reverse string "+str2Reverse+ " = "+strbldr.toString() );
		str2Reverse = myC.getName() + " simple name:" + myC.getSimpleName();
		for(int i=str2Reverse.length(); i>0; i--) {
			strbldr.append( str2Reverse.charAt(i-1));
		}
		System.out.println("Reverse string "+str2Reverse+ " = "+strbldr.toString() );
    }
}