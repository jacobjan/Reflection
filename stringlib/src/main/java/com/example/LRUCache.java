package com.example;

import java.util.HashMap;

/**
 * Created by AiYeSus on 11/22/2017.
 */
class Node{
    int key;
    String value;
    Node pre;
    Node next;

    public Node(int key, String value){
        this.key = key;
        this.value = value;
    }
}

public class LRUCache {
    int capacity;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    Node head=null;
    Node end=null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public String get(int key) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }
        return "";
    }

    public void remove(Node n){
        if(n.pre!=null){
            n.pre.next = n.next;
        }else{
            head = n.next;
        }

        if(n.next!=null){
            n.next.pre = n.pre;
        }else{
            end = n.pre;
        }

    }

    public void setHead(Node n){
        n.next = head;
        n.pre = null;

        if(head!=null)
            head.pre = n;

        head = n;

        if(end ==null)
            end = head;
    }

    public void set(int key, String value) {
        if(map.containsKey(key)){
            Node old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        }else{
            Node created = new Node(key, value);
            if(map.size()>=capacity){
                map.remove(end.key);
                remove(end);
                setHead(created);

            }else{
                setHead(created);
            }

            map.put(key, created);
        }
    }

    public static void main(String args[]) {
        Integer ci = Integer.valueOf(237);
        LRUCache lruCache = new LRUCache(10);
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        String keywords[] = new String[]{"Ketchikan", "Juneau", "Yukon Territory", "LRU Cache", "Get Cookies",
                "St Petersburg", "Haines", "Skgway", "getLastNonConfigurationInstance", "onRetainNonConfigurationInstance"};

        for(int i=0; i < arr.length; i++) {
            lruCache.set(arr[i], keywords[i]);
        }
        System.out.println(lruCache.get(4));
        System.out.println(lruCache.get(5));
        lruCache.set(4, "Columbia SC");
        lruCache.set(5, "Anchroage AK");
        System.out.println("After set 4 & 5 :\n"+lruCache.get(4));
        System.out.println(lruCache.get(5));

    }

}
