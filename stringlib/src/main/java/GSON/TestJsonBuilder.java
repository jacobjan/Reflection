package GSON;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TestJsonBuilder {

    public static void main(String args[]) {
        Integer ci = Integer.valueOf(237);

		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int i, Largest=arr[0], secLargest=0;
		List lst = Arrays.asList(arr);
		System.out.println(lst.size());

		List<Integer> listOfInt = Arrays.stream(arr).boxed().collect(Collectors.toList());
		// or This will create a list of integers:

		List<Integer> prmList = Arrays.asList(11, 23, 31, 41, 53, 67, 71, 83, 97, 103);
		for(i=2; i<arr.length; i++) {
			if (Largest < arr[i]) {
				secLargest = Largest;
				Largest = arr[i];
			} else if (secLargest < arr[i]) {
				secLargest = arr[i];
			}
		}
        System.out.println("Two largest:" + Largest + " " + secLargest + " prod:" + Largest*secLargest);

		Collections.sort(listOfInt);
		int last = listOfInt.size()-1;
		Gson gson = new GsonBuilder().create();
		gson.toJson("Two largest:" + listOfInt.get(last) + " " + listOfInt.get(last-1), System.out);
		gson.toJson(" prod:" + (int)listOfInt.get(last)*(int)listOfInt.get(last-1), System.out);
    }
}  