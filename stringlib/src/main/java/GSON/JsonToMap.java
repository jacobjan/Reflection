package GSON;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by AiYeSus on 11/20/2017.
 */

public class JsonToMap {

    public static void main(String args[]) {
        Integer ci = Integer.valueOf(237);

        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int i, Largest=arr[0], secLargest=0;
        List lst = Arrays.asList(arr);
        System.out.println(lst.size());

        List<Integer> listOfInt = Arrays.stream(arr).boxed().collect(Collectors.toList());
        // or This will create a list of integers:
        Collections.sort(listOfInt);
        int last = listOfInt.size()-1;
        Gson gson = new GsonBuilder().create();
        gson.toJson("Two largest:" + listOfInt.get(last) + " " + listOfInt.get(last-1), System.out);
        gson.toJson(" prod:" + (int)listOfInt.get(last)*(int)listOfInt.get(last-1), System.out);
        String jsonString = "{'header': " +
            "{'alerts': [" +
                            "{'AlertID': '2', 'TSExpires': null, 'Target': '1', 'Text': 'woot', 'Type': '1'}, " +
                            "{'AlertID': '3', 'TSExpires': null, 'Target': '3', 'Text': 'Running', 'Type': '5'}" +
                        "], 'session': '0bc8d0835f93ac3ebbf11560b2c5be9a'}, " +
            "'result': '4be26bc400d3c'}";
        System.out.println("\n\n");
        Map map = gson.fromJson(jsonString, Map.class);
        System.out.println(map.getClass().toString()+"\n");

        System.out.println(map);
    }
}
