package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class RemoveDupOrders {

    public static void UniqueList( List<Order> inList ) {
        HashSet<Order> uniqSet = new HashSet<>();
        uniqSet.addAll(inList);
        inList.clear();
        inList.addAll(uniqSet);
    }

    public static void main(String args[]) {
        //Creating Order object to demonstrate Sorting of Object in Java
        Order ord1 = new Order(101, 203.34f, "11/19/2017", "11/20/2017", "Sony");
        Order ord2 = new Order(102, 439.49f, "11/19/2017", "11/20/2017","Hitachi");
        Order ord3 = new Order(103, 611.31f,"11/19/2017", "11/20/2017", "Philips");

        //putting Objects into Collection to sort
        List<Order> orders = new ArrayList<Order>();
        orders.add(ord3);
        orders.add(ord1);
        orders.add(ord2);
        orders.add(ord3);
        orders.add(ord1);

        //printing unsorted collection
        System.out.println("Unsorted Collection : " + orders);

        UniqueList( orders );
        //Sorting Order Object on natural order - ascending
        Collections.sort(orders);

        //printing sorted collection
        System.out.println("List of UNIQUE Order object sorted in natural order : " + orders);

        // Sorting object in descending order in Java
        Collections.sort(orders, Collections.reverseOrder());
        System.out.println("List of object sorted in descending order : " + orders);

        //Sorting object using Comparator in Java
        Collections.sort(orders, new Order.OrderByAmount());
        System.out.println("List of Order object sorted using Comparator - amount : " + orders);

        // Comparator sorting Example - Sorting based on customer
        Collections.sort(orders, new Order.OrderByVendor());
        System.out.println("Collection of Orders sorted using Comparator - by vendor : " + orders);
    }
}


/*
 * Order class is a domain object which implements
 * Comparable interface to provide sorting on the natural order.
 * Order also provides couple of custom Comparators to
 * sort object based upon amount and customer
 */
class Order implements Comparable<Order> {

    private int orderId;
    private float amount;
    private String dateOfExpense;
    private String dateSubmitted;
    private String vendor;

    /*
     * Comparator implementation to Sort Order object based on Amount
     */
    public static class OrderByAmount implements Comparator<Order> {

        @Override
        public int compare(Order o1, Order o2) {
            return o1.amount > o2.amount ? 1 : (o1.amount < o2.amount ? -1 : 0);
        }
    }

    /*
     * Anohter implementation or Comparator interface to sort list of Order object
     * based upon customer name.
     */
    public static class OrderByVendor implements Comparator<Order> {

        @Override
        public int compare(Order o1, Order o2) {
            return o1.vendor.compareTo(o2.vendor);
        }
    }

    public Order(int orderId, float amount, String dateOfExpense, String dateSubmitted, String vendor) {
        this.orderId = orderId;
        this.amount = amount;
        this.dateOfExpense = dateOfExpense;
        this.dateSubmitted = dateSubmitted;
        this.vendor = vendor;
    }

    public float getAmount() {return amount; }
    public void setAmount(int amount) {this.amount = amount;}

    public String getVendor() {return vendor;}
    public void setVendor(String vendor) {this.vendor = vendor;}

    public int getOrderId() {return orderId;}
    public void setOrderId(int orderId) {this.orderId = orderId;}

    /*
     * Sorting on orderId is natural sorting for Order.
     */
    @Override
    public int compareTo(Order o) {
        return this.orderId > o.orderId ? 1 : (this.orderId < o.orderId ? -1 : 0);
    }

    /*
     * implementing toString method to print orderId of Order
     */
    @Override
    public String toString(){
        return "\n"+String.valueOf(orderId) + " $"+String.valueOf(amount)+ "  Name:"+String.valueOf(vendor);
    }
}
