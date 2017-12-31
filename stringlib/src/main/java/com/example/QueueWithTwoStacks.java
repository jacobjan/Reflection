package com.example;

import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by AiYeSus on 11/28/2017.
 * In the constructor initialize 2 stacks, “entryStack” and “exitStack”. The enqueue method pushes the value
 onto entryStack. The dequeue method pops from exitStack if it’s not empty, otherwise pop all items from
 entryStack onto exitStack. If they’re both empty throw an exception.

 */

public class QueueWithTwoStacks<Item> {

    private Stack<Item> stack1;    // back of queue
    private Stack<Item> stack2;    // front of queue
    Queue<Item> mQueue = new SynchronousQueue<Item>();

    // create an empty queue
    public QueueWithTwoStacks() {
        stack1 = new Stack<Item>();
        stack2 = new Stack<Item>();
    }

    // move all items from stack1 to stack2
    private void moveStack1ToStack2() {
        while (!stack1.isEmpty())
            stack2.push(stack1.pop());
    }

    // is the queue empty?
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }


    // return the number of items in the queue.
    public int size() {
        return stack1.size() + stack2.size();
    }

    // return the item least recently added to the queue.
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        if (stack2.isEmpty()) moveStack1ToStack2();
        return stack2.peek();
    }

    // add the item to the queue
    public void enqueue(Item item) {
        stack1.push(item);
    }

    // remove and return the item on the queue least recently added
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        if (stack2.isEmpty()) moveStack1ToStack2();
        return stack2.pop();
    }


    // a test client
    public static void main(String[] args) {
        QueueWithTwoStacks<String> q = new QueueWithTwoStacks<String>();
        Scanner scnr = new Scanner(System.in);
        while (scnr.hasNext()) {
            String item = scnr.nextLine();
            if ( item.equalsIgnoreCase("exit")) break;
            if (!item.equals("-")) q.enqueue(item);
            else if (!q.isEmpty()) System.out.println(q.dequeue() + " ");
        }
        System.out.println("(" + q.size() + " left on queue)");
    }
}
