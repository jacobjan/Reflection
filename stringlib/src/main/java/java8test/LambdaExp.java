package java8test;

/**
 * Created by AiYeSus on 10/20/2017.
 */

// Java program to demonstrate working of Collections.sort()
// to descending order.

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class LambdaExp {

    public final static int max = 3;
    public static long seed = 217L;

    public static void main(String[] args) {
        // Create a list of strings
        ArrayList<String> al = new ArrayList<String>();
        al.add("Geeks For Geeks");
        al.add("Friends");
        al.add("Dear");
        al.add("Is");
        al.add("Superb");

        al.add(0, "Not Geek");
        al.add(1, "Families");

        /* Collections.sort method is sorting the
        elements of ArrayList in ascending order. */
  //      Collections.sort(al, Collections.reverseOrder());
        // Let us print the sorted list
        System.out.println("List after the use of" +
                " Collection.sort() :\n" + al);

        // Create a list of strings
        ArrayList<Integer> rndIntLst = new ArrayList<Integer>();
        Random rnd = new Random();
        for(int i=0; i < max; i++ ) {
            rndIntLst.add( rnd.nextInt() % 1000 );
        }
        rndIntLst.add(1, 333);

        // Let us print the list
        System.out.println("List of integers :\n" + rndIntLst);
        /* Collections.sort method is sorting the
        elements of ArrayList in ascending order. */
        Collections.sort(rndIntLst);
        System.out.println("List after the use of Collection.sort() :\n" + rndIntLst);
        // REverse
        Collections.sort(rndIntLst, Collections.reverseOrder());
        System.out.println("List after the use of Collection.reverseOrder() :\n" + rndIntLst);

        Supplier<String> sup = () -> "Car";
        Consumer<String> cosu = x -> System.out.print(x.toLowerCase());
        Consumer<String> dcos = x -> System.out.print(x.toUpperCase());
        cosu.andThen(dcos).accept(sup.get());
        System.out.println();
        //System.out.println(Stream.of("green", "yellow", "blue").max());
        // create an empty array list with an initial capacity
        ArrayList<Integer> arrlist = new ArrayList<Integer>(5);

        // use add() method to add elements in the list
        arrlist.add(15);
        arrlist.add(22);
        arrlist.add(30);
        arrlist.add(40);

        // adding element 25 at third position
        arrlist.add(2,25);

        // let us print all the elements available in list
        for (Integer number : arrlist) {
            System.out.println("Number = " + number);
        }
    }

}