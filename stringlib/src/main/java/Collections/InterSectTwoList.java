
/**
 * Created by AiYeSus on 11/28/2017.
 */

package Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
//import org.apache.commons.lang3.ArrayUtils;

public class InterSectTwoList {

    // duplicates in the result list ([1,2,2,3] and [2,2,3,4] should intersect as [2,2,3] and not just [2,3]).
    static List<Integer> GetIntersectionOfTwoLists(List<Integer> listInta, List<Integer> listIntb) {
        Hashtable<Integer, Integer> comMap = new Hashtable<>();
        List<Integer> intersect = new ArrayList<>();
        // Store 1st list into map
        int count = 0;
        for(int i : listInta) {
            comMap.put(i, 1);
        }
        System.out.println("1st List of ints "+listInta);
        for(int i : listIntb) {
            if (comMap.containsKey(i)) {
                int val = comMap.get(i);
                val++;
                comMap.put(i, val);
            }
        }
        System.out.println("add 2nd list of ints");
       for (Map.Entry<Integer, Integer> entry : comMap.entrySet()) {
            if ( entry.getValue() > 1 ) {
                intersect.add(entry.getKey());
            }
        }
        return intersect;
    }

    public static List<Integer> intersectionArrayList(List<Integer> listInta, List<Integer> listIntb) {
        List<Integer> intersect = new ArrayList<>(listInta);
        intersect.retainAll(listIntb);
        return intersect;
    }

    public static LinkedList<Integer> intersection(LinkedList<Integer> listInta, LinkedList<Integer> listIntb) {
        LinkedList<Integer> intersect = new LinkedList<>(listInta);
        intersect.retainAll(listIntb);
        return intersect;
    }

    /**
     * List<Integer> integerList = new ArrayList<Integer>();
     * Integer[] integerArray = integerList.toArray(new Integer[0]);
     * int[] intArray = ArrayUtils.toPrimitive(integerArray);
     * @param args
     */
    public static void main(String[] args) {
        LinkedList<Integer> a;
        a = new LinkedList<>(Arrays.asList(1, 2, 2, 3));
        LinkedList<Integer> b;

        a = new LinkedList<>(Arrays.asList(1, 2, 2, 3));
        b = new LinkedList<>(Arrays.asList(2, 2, 3, 4, 23));
        System.out.println("intersection of two list:" + a + "  ,  "+b);
        System.out.println("intersection of two list with loop:" + intersection(a, b));

        List<Integer> la;
        List<Integer> lb;
        la = new ArrayList<>(Arrays.asList(1, 2, 2, 3));
        lb = new ArrayList<>(Arrays.asList(2, 2, 3, 4, 23));
        Integer[] integerArray = la.toArray(new Integer[0]);
        int[] intArray = new int[integerArray.length];
        int idx=0;
        for(int i : integerArray) {
            intArray[idx] = i;
            System.out.print(intArray[idx] + " ");
            idx++;
        }
        System.out.println( "\nintersection of two list:" + la + "  ,  "+lb);
        System.out.println("intersection of two list with loop:" + intersectionArrayList(la, lb));
    }
}
