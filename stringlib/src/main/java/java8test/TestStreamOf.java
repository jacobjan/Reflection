package java8test;

import java.util.stream.Stream;

/**
 * Created by AiYeSus on 10/26/2017.
 */

public class TestStreamOf {

    public static void main(String[] args) {
        System.out.println("Test Java 8 Stream:");
        // print java.util.stream.ReferencePipeline$Head@75b84c92
        System.out.println( Stream.of("green", "yellow", "blue")
        );

        System.out.println( Stream.of("green", "yellow", "blue")
                .max((s1, s2) -> s1.compareTo(s2))
                );

        System.out.println( Stream.of("green", "yellow", "blue")
                .max((s1, s2) -> s1.compareTo(s2))
                .filter(s -> s.endsWith("n")));

        System.out.println( Stream.of("green", "yellow", "blue")
                                .max((s1, s2) -> s1.compareTo(s2))
                                .filter(s -> s.endsWith("n"))
                                .orElse("yellow"));
        // Test boolean
        boolean b = false;
        System.out.println( ( b = true ) ? "true" : "false" );

        int c = 0;
        System.out.println( ( 0 == c++ ) ? "true" : "false" );

        Double d = null;
        System.out.println( ( d instanceof Double ) ? "true" : "false" );

        String e = "1";
        System.out.println( ( "1" != e ) ? "true" : "false" );
    }

}
