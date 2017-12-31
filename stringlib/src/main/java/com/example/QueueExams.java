package com.example;

import java.util.AbstractQueue;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by AiYeSus on 12/18/2017.
 */

public class QueueExams {

    Queue queue;

    public static Queue testLinkedListQueue(int count) {
        Queue<Integer> queLL = new LinkedList<Integer>();
        for (int i = count; i >= 0; i--)
            queLL.add(i);
        return queLL;
    }

    public static Queue testLinkedListQueue(String s) {
        Queue<Character> queLL = new LinkedList<Character>();
        char[] charr = s.toCharArray();
        for (char c : charr)
            queLL.add(c);
        return queLL;
    }

    public static Queue testPriorityQueue(String s) {
        // Why priority queue mess up sequence ( insert order )
        Queue<Character> quePR = new PriorityQueue<Character>();
        char[] charr = s.toCharArray();
        for (char c : charr)
            quePR.add(c);
        return quePR;
    }

    public static Queue testSynchronousQueue(String s) {
        // Why SynchronousQueue cuase queue full ?
        SynchronousQueue<Character> queSync = new SynchronousQueue<>();
        char[] charr = s.toCharArray();
        for (char c : charr)
            queSync.add(c);
        return queSync;
    }

    public static void printQueue(String title, Queue mQueue) {
        System.out.println(title+" :\n-----------------------");
        while (!mQueue.isEmpty()) {
            System.out.print(mQueue.remove()+" ");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int time = 10; //Integer.parseInt(args[0]);
        QueueExams qes = new QueueExams();
        qes.queue = testLinkedListQueue( time );
        printQueue( "\nLinkedListQueue of int ", qes.queue );
        qes.queue.clear();

        qes.queue = testLinkedListQueue( "LinkedList" );
        printQueue( "\nLinkedList Queue ", qes.queue );
        qes.queue.clear();

        qes.queue = testPriorityQueue( "LinkedList" );
        printQueue( "\nPriority Queue ", qes.queue );
        qes.queue.clear();

        qes.queue = testSynchronousQueue( "Synchronous" );
        printQueue( "Synchronous Queue ", qes.queue );
    }
}