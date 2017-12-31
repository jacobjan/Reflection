package com.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by AiYeSus on 11/19/2017.
 */
public class UseSetRemoveDup {

    List<Expense> expenseList = new ArrayList<Expense>();

    public static void RemoveDuplicate( List<Expense> inList ) {
        HashSet<Expense> uniqSet = new HashSet<Expense>();
        uniqSet.addAll(inList);
        inList.clear();
        inList.addAll(uniqSet);
    }

    // Read more: http://www.java67.com/2012/10/how-to-sort-object-in-java-comparator-comparable-example.html#ixzz4yveuxFvZ
    public static void main(String[] args) {
        List<Expense> expList = new ArrayList<>();
        Expense exp1 = new Expense("1007", 234.77f, "11/15/2017", "11/17/2017", "DELPHI");
        Expense exp2 = new Expense("1002", 6784.24f, "11/13/2017", "11/18/2017", "DELOITTE");
        Expense exp3 = new Expense("1005", 2311.29f, "11/13/2017", "11/19/2017", "WALMART");
        expList.add( exp1 );
        expList.add( exp2 );
        expList.add( exp3 );
        expList.add( exp1 );
        expList.add( exp3 );
        expList.add( exp1 );

        System.out.println("Original List :");
        System.out.println( expList );
        RemoveDuplicate( expList );
        System.out.println("Remove duplicates List :");
        System.out.println( expList );

        Collections.sort(expList, new Expense.ExpenseById());
        System.out.println("Sorted List :");
        System.out.println( expList );
    }
}

class Expense implements Comparable<Expense> {

    private String Id;
    private float amount;
    private String dateOfExpense;
    private String dateSubmitted;
    private String vendor;

    public Expense(String Id, float amount, String dateOfExpense, String dateSubmitted, String vendor) {
        this.Id = Id;
        this.amount = amount;
        this.dateOfExpense = dateOfExpense;
        this.dateSubmitted = dateSubmitted;
        this.vendor = vendor;
    }

    public static class ExpenseById implements Comparator<Expense> {

        @Override
        public int compare(Expense o1, Expense o2) {
            return o1.Id.compareTo(o2.Id);
        }
    }

    public float getAmount() {return amount; }
    public void setAmount(int amount) {this.amount = amount;}

    public String getVendor() {return vendor;}
    public void setVendor(String vendor) {this.vendor = vendor;}

    public String getId() {return Id;}
    public void setId(String Id) {this.Id = Id;}
    /*
     * implementing toString method to print orderId of Order
     */
    @Override
    public String toString(){
        return "\n"+Id + " $"+String.valueOf(amount)+ "  Name:"+ vendor;
    }

    @Override
    public int compareTo(Expense e) {
        return Id.compareTo(e.Id);
    }
}
