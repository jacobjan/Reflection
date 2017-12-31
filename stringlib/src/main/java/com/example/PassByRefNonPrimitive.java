package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by AiYeSus on 11/7/2017.
 */


public class PassByRefNonPrimitive {

    public static class treeNode {
        String name;
        String id;
        treeNode nextNode;
    };

    public static void main(String[] args) {
        Integer stkI = 0;
        int iarr[] = new int[]{23, 29, 31, 37};
        List mixTypeList = new ArrayList(Arrays.asList(4,6,7,8));
        System.out.println("Printing list before method calling:" + mixTypeList);
        ParameterModified(mixTypeList);
        System.out.println("Printing list after method calling:" + mixTypeList);
        modInteger(stkI);
        System.out.println("\nstkI:" + stkI);
        modPrimitive(stkI);
        System.out.println("\nstkI after method calling:" + stkI);
        System.out.println("\nint arr:" + iarr[0] + " "+iarr[1]);
        modObj(iarr);
        System.out.println("\nint arr after method calling:" + iarr[0] + " "+iarr[1]);

        treeNode mNode = new treeNode();
        mNode.name = "groovy";
    }

    public static void ParameterModified(List ListToBeModified) {
        ListToBeModified.add("done"); // adding elements to list
        ListToBeModified.add("blah");
    }

    public static void modInteger(Integer myI) {
        myI = 5;
    }

    public static void modPrimitive(int myI) {
        myI += 5;
    }

    public static void modObj(int[] myObj) {
        int sz = myObj.length;

        myObj[0] = 91;
    }
}
