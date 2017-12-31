package java8test;

import java.util.Scanner;

import static java8test.Lambda2.printSelectedString;

/**
 * Created by AiYeSus on 10/27/2017.
 */

public class testStrBuilder {

    public static void main(String argArray[]) {

        StringBuilder strbder = new StringBuilder();
        for ( String arg : argArray) {
            if ( arg.indexOf(arg) < 1)
                strbder.append(arg+" ");
        }
        System.out.println( strbder.toString() );

        Scanner scnr = new Scanner( strbder.toString() );
        while ( scnr.hasNext() ) {
            if ( scnr.hasNextInt() )
                System.out.println( scnr.nextInt() + " " );
            else
                scnr.next();
        }

    }
}
