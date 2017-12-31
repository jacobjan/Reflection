package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by AiYeSus on 10/26/2017.
 */

public class TestClassInstantiate {

/*
    TestClassInstantiate instance;

    // new TestClassInstantiate will cause stackoverflow runtime error
    private TestClassInstantiate() {
        instance = new TestClassInstantiate();
    }
*/
    static List<Integer> pickOddNumbers(List<Integer> listInt) {
        List<Integer> resultList = new ArrayList<Integer>();
        for(int num : listInt) {
            if ( num % 2 == 0) {
                continue;
            }
            resultList.add(num);
        }
        return resultList;
    }

    static boolean isNumber(String str) {
        for(char ch : str.toCharArray()) {
            if ( ch < '0' || ch > '9' ) {
                return false;
            }
         }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<Integer> mIntList = new ArrayList<>(Arrays.asList(37, 6, 23, 4, 2, 1));
        System.out.println( pickOddNumbers( mIntList ) );
        System.out.println( isNumber("123fe") + "  and 89776554 is number :"+isNumber("89776554"));
    }
}
