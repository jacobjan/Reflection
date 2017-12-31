package com.example;

import java.util.Iterator;
import java.util.LinkedList;
// import org.netbeans.modules.classfile.ClassName;

/**
 * Created by AiYeSus on 10/31/2017.
 */
class ParentClass {
    protected static int count=0;
    public ParentClass() {
        count+=5;
    }
    static int getCount() {
        return count;
    }
}

public class testSubClass extends ParentClass {
    public testSubClass() {
        count++;
    }
    public static void main(String[] args) {

        System.out.println("Before instantiation, Count = " + getCount());
        testSubClass obj = new testSubClass();
        System.out.println("After instantiation which invoke constructor to add 5 on 'Count'. Count = " + getCount());
    }
}
