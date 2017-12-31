package com.example;

/**
 * Created by AiYeSus on 10/13/2017.
 */
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class Java8Lambda {
    public static void main(String args[]){

        String ports[] = {"Icy Point ",
                        "Hoonah ",
                        "Tlingit Tribe",
                        "Ketchikan ",
                        "Haines ",
                        "Skgway",
                        "Hukon Territory",
                        "Sitka",
                        "Wrangell",
                        "Juneau "};

        List<String> J7List = new ArrayList<String>();
        for(String s:ports) {
            J7List.add(s);
        }

        List<String> J8List = new ArrayList<String>();
        for(String s:ports) {
            J8List.add(s);
        }

        Java8Lambda tester = new Java8Lambda();
        System.out.println("Sort using Java 7 syntax: ");
        tester.sortUsingJava7(J7List);
        System.out.println(J7List);

        System.out.println("Sort using Java 8 syntax: ");
        System.out.println(J8List);
        System.out.println("After sort with lambda expression:");
        Collections.sort(J8List, (s1, s2) -> s1.compareTo(s2));
        System.out.println(J8List);
    }

    //sort using java 7
    private void sortUsingJava7(List<String> names){
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
    }

    //sort using java 8
    private void sortUsingJava8(List<String> names){
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
    }
}