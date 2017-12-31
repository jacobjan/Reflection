package Collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by AiYeSus on 11/29/2017.
 */

public class SetToArray {
    public static void main(String[] args) {
        String src = "First, I suggest you you of suggest use a HashMap instead of a Hashtable, ";
        String[] strarr = src.split(" ");
        Set<String> set = new HashSet<>(Arrays.asList(strarr));
        String[] array = set.toArray(new String[0]);
        //System.out.println(Arrays.toString(array));
        for( String s : array ) {
            System.out.print(s + " ");
        }
        System.out.println();
        set.clear();
        set = new LinkedHashSet<>(Arrays.asList(strarr));
        array = set.toArray(new String[0]);
        for( String s : array ) {
            System.out.print(s + " ");
        }
    }
}
