package Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

class arrayOfChar {
	private char charr[] = {'C', 'h', 'a', 'r', 'a', 'c', 't', 'e', 'r', 'a', 'r', 'r'};

	arrayOfChar() {
	}

	arrayOfChar(String s) {
		charr = s.toCharArray();
	}

	public void showme() {
		System.out.println();
		for(int i=0; i<charr.length; i++) {
			System.out.print(charr[i]);
		}
	}
}

public class myCollection {
	
	int[] arr1={41, 7, 13, 22},
			arr2={41, 7, 13, 22},
			arr3={41, 7, 53, 22};

	public int[] getArr1() {
		return arr1;
	}

	public void setArr1(int[] arr1) {
		this.arr1 = arr1;
	}

	public myCollection() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		myCollection myC = new myCollection();

		// int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		List lst = Arrays.asList(myC.arr1);
		ListIterator lstItr = lst.listIterator();

		System.out.println("List size :"+lst.size());
		// Use List<Integer>
		List<Integer> lstOfInt = new ArrayList<Integer>();
		for ( int i : myC.arr1 ) {
			lstOfInt.add(i);
		}
		System.out.println("List<Integer> size :"+lstOfInt.size());
		System.out.println("compare integer array arr1 & arr2 "+ " :" + Arrays.equals(myC.arr1, myC.arr2));
		System.out.println("compare integer array arr1 & arr3 "+ " :" + Arrays.equals(myC.arr1, myC.arr3));

        System.out.println("hashcode :"+myC.arr1.hashCode()+"    list of integer contain 7 ? "+lstOfInt.contains(7));
		//List<Integer> alist1 = new ArrayList<Integer>(Arrays.asList(32, 4, 56, -8, 9));
		List<Integer> alist1 = Arrays.asList(32, 4, 56, -8, 9);
		for(int i : alist1) {
			System.out.print(i + " ");
		}

        Collections.sort(alist1);
		System.out.println("\nAfter sort, Collection.sort parameter OBJECT is passed by reference ?");
		for(int i : alist1) {
			System.out.print(i + " ");
		}
		System.out.println();
		String str = "weare";
		arrayOfChar acha = new arrayOfChar();
		acha.showme();
		arrayOfChar bcha = new arrayOfChar( str );
		bcha.showme();
	}
}
