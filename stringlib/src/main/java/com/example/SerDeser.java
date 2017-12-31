package com.example;

/**
 * Created by AiYeSus on 10/10/2017.
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Person implements Serializable {
    private String firstName;
    private String lastName;
    // stupid example for transient
    transient private Thread myThread;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.myThread = new Thread();
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Override
    public String toString() {
        return "Person [firstName=" + firstName + ", lastName=" + lastName
                + "]";
    }
}

public class SerDeser {

    public static String itoa(int i) {
        String res = "";
        boolean neg = false;
        int q, r;
        char ch;
        StringBuilder sb = new StringBuilder();
        if ( i == 0 ) return "0";
        if ( i < 0 ) {
            neg = true;
            i = -i;
        }
        while ( i > 0 ) {
            r = i % 10;
            i = i / 10;
            ch = (char) ('0' + r);
            sb.append(ch);
        }
        if ( neg ) sb.append('-');
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String filename = "time.ser";
        Person p = new Person("Jihshin", "Zheng");

        // save the object to file
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        String city = null;
        try {
            fos = new FileOutputStream(filename);
            out = new ObjectOutputStream(fos);
             for(int i=0; i < 3; i++) {
                out.writeObject(p);
                if (i == 1) {
                    city = "Icy Point";
                } else {
                    city = "Haines";
                }
                p = new Person("Glacial - "+i, city);
             }
            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            System.out.println("City ="+city);
        }

        // read the object from file
        // save the object to file
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(filename);
            in = new ObjectInputStream(fis);
            for(int i=0; i<3; i++) {
                p = (Person) in.readObject();
                System.out.println(itoa(i) + " - " + p);
            }
            in.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println(itoa(89766544));
        System.out.println(89776554);
        System.out.println(itoa(89776554 - 189766544));
    }
}