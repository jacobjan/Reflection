package com.example;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RotateMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {	   	 
	   	 Scanner scnr = new Scanner(System.in);
	   	 System.out.println("**** Rotate Matrix *****\nEnter Square Matrix Dimension : ");
	   	 int msize = scnr.nextInt();
	   	 System.out.println("Enter elements ( separated by white spaces ) of square matrix size : " + msize);	   	 
	   	 
	   	 int[][] mat = new int[msize][msize];
	   	 for (int i = 0; i < msize; i++) {
	   		 for(int j=0; j < msize; j++)
	   			 mat[i][j] = scnr.nextInt();
	   	 }	
	   	 System.out.println("Matrix Entered : ");	   	 
	   	 dispMatrix( mat );
	   	 
	   	 System.out.println("Matrix Shifted : ");	   	 
	   	 int[][] shft_mat = rotateMatrix( mat );
	   	 dispMatrix( shft_mat );

	}

	public static void dispMatrix(int[][] m) {
		int row = m.length;
		if ( row > 0 ) {
			int col = m[0].length;			
			for(int i=0; i < row; i++) {
				for(int j=0; j < col; j++) System.out.print(m[i][j]+" ");
				System.out.println("");
			}
		}		
	}

	public static int[][] rotateMatrix(int[][] m) {
		int row = m.length;
		if ( row > 0 ) {
			int col = m[0].length;	
			
			int[][] resultMatrix = new int[row][col];
			resultMatrix = m;
			
			// Shift the top row.  Save top right element
			int topR = m[0][col-1];
			// Shift element to right of top row
			for(int cidx = col-1; cidx > 0; cidx--) resultMatrix[0][cidx] = m[0][cidx-1];
			
			// Shift rightmost column, save bottom right element
			int botR = m[row-1][col-1];
			// Shift element from top to bottom and move top right to 2nd row
			for(int ridx = row-1; ridx > 0; ridx--) resultMatrix[ridx][col-1] = m[ridx-1][col-1];
			resultMatrix[1][col-1] = topR;
			
			// Save bottom left element
			int botL = m[row-1][0];
			// Shift element to left of bottom row and save bottom right most element to column on left
			for(int cidx = 0; cidx < col-1; cidx++) resultMatrix[row-1][cidx] = m[row-1][cidx+1];
			resultMatrix[row-1][col-2] = botR;
			
			// Shift leftmost column, save top left element
			int topL = m[0][0];
			// Shift element from bottom to top and move bottom left element to row above
			for(int ridx = 0; ridx < row-1; ridx++) resultMatrix[ridx][0] = m[ridx+1][0];
			resultMatrix[1][0] = botL;
			
			return resultMatrix;
		}
		return null;
	}

	public boolean isThereDup(int[][] m) {
		int row = m.length;
		if ( row > 0 ) {
			int col = m[0].length;	
			Set<Integer> intmap = new HashSet<Integer>();
			for (int r=0; r < row; r++) {
			  for (int c=0; c< col; c++) {
				    if (intmap.contains(m[r][c])) return true;
				    intmap.add(m[r][c]);
			  }
			}
		} // of if
		return false;
	}
	
	static boolean duplicate_char(final char[] charray)
	{
	  Set<char[]> lump = new HashSet<char[]>();
	  for (char c : charray)
	  {
	    if (lump.contains(c)) return true;
	    lump.add(charray);
	  }
	  return false;
	}
	
	static boolean duplicates(int[] zipcodelist)
	{
	  Set<Integer> lump = new HashSet<Integer>();
	  for (int i : zipcodelist)
	  {
	    if (lump.contains(i)) return true;
	    lump.add(i);
	  }
	  return false;
	}
	
	
}
/*
    int array[] = {1,2,3,4,5,2,3,4,5,3,4,5,4,5,5};

    HashMap<Integer,Integer> duplicates = new HashMap<Integer,Integer>();
    for(int i=0; i<array.length; i++)
    {
        if(duplicates.containsKey(array[i]))
        {
            int numberOfOccurances = duplicates.get(array[i]);
            duplicates.put(array[i], (numberOfOccurances + 1));
        }else{
            duplicates.put(array[i], 1);
        }
    }
    Iterator<Integer> keys = duplicates.keySet().iterator();
    System.out.print("Duplicates : " );
    while(keys.hasNext())
    {
        int k = keys.next(); 
        if(duplicates.get(k) > 1)
        {
            System.out.print(" "+k);
        }
    }
 * 
 ==========
[0, 2, 0] would return 2, [0, 0, 0] would return 3, [0, 1, 2] = 0
So far I have it working for when all three items are equal, but I'm not sure why it's returning one less than what it should for 2 items being the same.

    int equal = 0;

    for(int i = 0; i < recent.length; i++) {
        for(int j = i; j < recent.length; j++) {
            if(i != j && recent[i].equals(recent[j])) {
                equal++;
            }
        }
    }
    
    --------
    int intArray[] = {5, 1, 2, 3, 4, 5, 3, 2};  

	String val = "";

	int c = 1;

	Map<Integer, Integer> nwmap = new HashMap<Integer, Integer>();  

	for (int i = 0; i < intArray.length; i++) {
	
    	Integer key = intArray[i];

        if(nwmap.get(key) != null && nwmap.containsKey(key)){

        	val += " Duplicate: " +String.valueOf(key)+"\n";

    	}else{

        	nwmap.put(key, c);

            c++;

    	}

	}

	LOG.debug("duplicate value:::"+val);
	=======
	public void run() {
    int[] array = createRandomArray(2000000, 1000000);
    System.out.println(countNumDups1(array));
}


private int[] createRandomArray(int numElements, int maxNumExclusive) {
    int[] array = new int[numElements];
    Random random = new Random();
    for (int i = 0; i < array.length; i++) {
        array[i] = random.nextInt(maxNumExclusive);
    }
    return array;
}

private int countNumDups1(int[] array) {
    Map<Integer, Integer> numToCountMap = new HashMap<>();
    for (int i = 0; i < array.length; i++) {
        Integer key = array[i];
        if (numToCountMap.containsKey(key)) {
            numToCountMap.put(key, numToCountMap.get(key) + 1);
        }
        else {
            numToCountMap.put(key, 1);
        }
    }
    int numDups = 0;
    for (int i = 0; i < array.length; i++) {
        Integer key = array[i];
        if (numToCountMap.get(key) > 1) {
            numDups++;
        }
    }
    return numDups;
}
 */
