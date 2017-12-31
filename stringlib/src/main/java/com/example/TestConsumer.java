package com.example;

/**
 * Created by AiYeSus on 11/1/2017.
 */

import java.util.function.Consumer;

public class TestConsumer {
    public static void main(String[] args) {
        Consumer<Object> c1 = x -> System.out.println(x);
        Consumer<Object> c2 = System.out::println;

        c1.accept("Print via lambda");
        c2.accept("Print via method reference");
    }
}