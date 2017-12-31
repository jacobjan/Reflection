package com.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public class StringUtil1 {

    public final static int maxEntries = 10;

    public float round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }

    public void sortMap(int maxEntries) {
        Map<Integer, Float> movies = new HashMap<Integer, Float>();
        int id=0;
        float rating=0.0f;
        // Populate all entries
        String s;

        Random rnd = new Random();
        for(int i=0; i < maxEntries; i++) {
            id = Math.abs(rnd.nextInt()) % 1000 + 1;
            rating = (float)Math.round(rnd.nextFloat() * 5 * 100) / 100;
            if ( !movies.containsKey(id)) movies.put(id ,rating);
        }

        // Set up buffer to display all movies
        StringBuilder sb = new StringBuilder();

        // Get entry set from the map movies
        Set<Entry<Integer, Float>> moviesSet = movies.entrySet();
        for(Entry<Integer, Float> entry :moviesSet) {
            sb.append("\nMovie " + entry.getKey() + " rating:" + entry.getValue());
        }
        System.out.println( sb );
        // Store them in list to sort
        List<Entry<Integer, Float>> listOfEntries = new ArrayList<Entry<Integer, Float>>(moviesSet);
        sb.append("\nList before sort");
        for(Entry<Integer, Float> entry : listOfEntries){
            sb.append("\nIdentifier :"+entry.getKey()+"  rating:"+entry.getValue());
        }
        // Set up comparator
        // Create comparator to sort the map acending order
        Comparator<Entry<Integer, Float>> valueComparator = new Comparator<Entry<Integer, Float>>() {
            @Override
            public int compare(Entry<Integer, Float> e1, Entry<Integer, Float> e2) {
                Float v1 = e1.getValue();
                Float v2 = e2.getValue();
                if ( v1 < v2 ) return -1;
                else if ( v1 > v2 ) return 1;
                else return 0;
            }
        };
        // Use Collections to sort list
        // sorting HashMap by values using ascending order comparator
        Collections.sort(listOfEntries, valueComparator);
        sb.append("\nList after Collections.sort");
        for(Entry<Integer, Float> entry : listOfEntries){
            sb.append("\nIdentifier :"+entry.getKey()+"  rating:"+entry.getValue());
        }
        Collections.reverse(listOfEntries);
        sb.append("\nList after Collections.reverse");
        for(Entry<Integer, Float> entry : listOfEntries){
            sb.append("\nIdentifier :"+entry.getKey()+"  rating:"+entry.getValue());
        }
        System.out.println( sb );
    }

    public void sortCartByDistance(int numOfEntries, int reqEntries, int destX, int destY) {
        List<List<Integer>> allcarts = new ArrayList<List<Integer>>();
        ArrayList<String> places = new ArrayList<>(Arrays.asList("Buenos Aires", "Córdoba", "La Plata"));
        List<Integer> cartloc = new ArrayList<>();
        // Populate all carts
        Random rnd = new Random();
        int x=0, y=0;
        for(int i=0; i < numOfEntries; i++) {
            x = Math.abs(rnd.nextInt()) % 100;
            y = Math.abs(rnd.nextInt()) % 100;
            //cartloc = new ArrayList<>(Arrays.asList(x, y));
            cartloc = Arrays.asList(x, y);
            allcarts.add( cartloc );
        }
        System.out.println( "\nallcarts size " + allcarts.size() );
        Map<List<Integer>, Float> cartsLoc = new HashMap<List<Integer>, Float>();
        // Calculate and populate cartsLoc map
        float dist = 0.0f;
        int dx=0, dy=0;
        for(List<Integer> cart: allcarts) {
            dx = cart.get(0)-destX;
            dy = cart.get(1)-destY;
            dist = (float)Math.sqrt( dx*dx + dy*dy );
            cartsLoc.put(cart, dist);
            System.out.println( "Cart " + cart+ " distance to "+ destX+", "+destY + " = "+dist);
        }
        // Set up buffer to display all movies
        StringBuilder sb = new StringBuilder();
        // Get entry set from the map movies
        Set<Entry<List<Integer>, Float>> cartsLocSet = cartsLoc.entrySet();

        // Store them in list to sort
        List<Entry<List<Integer>, Float>> listOfCarts = new ArrayList<Entry<List<Integer>, Float>>(cartsLocSet);
        sb.append("\nList before sort");
        // Set up comparator
        // Create comparator to sort the map acending order
        Comparator<Entry<List<Integer>, Float>> valueComparator = new Comparator<Entry<List<Integer> ,Float>>() {
            @Override
            public int compare(Entry<List<Integer>, Float> e1, Entry<List<Integer>, Float> e2) {
                Float v1 = e1.getValue();
                Float v2 = e2.getValue();
                if ( v1 < v2 ) return -1;
                else if ( v1 > v2 ) return 1;
                else return 0;
            }
        };
        // Use Collections to sort list
        // sorting HashMap by values using ascending order comparator
        Collections.sort(listOfCarts, valueComparator);
        sb.append("\nList of " + reqEntries + " nearest carts to " + destX + ", " + destY);
        int i=0;
        for(Entry<List<Integer>, Float> entry : listOfCarts) {
            if ( i++ < reqEntries ) {
                sb.append("\nCart " + entry.getKey() + "  Distance:" + entry.getValue());
            } else {
                break;
            }
        }
        System.out.println( sb );
    }

    public void initList(int num) {
        int[] iArr = new int[]{11, 13, 17, 23, 29};
        List<Integer> myCoords = new ArrayList<Integer>(Arrays.asList( 17, 23, 29 ));
        myCoords.add(11);
        Collections.addAll(myCoords, 10, 20, 30, 40, 500, 3);
        Iterator itr = myCoords.iterator();
        while (itr.hasNext()) {
            int coord = (int)itr.next();
            System.out.print("\r" + coord + " \\r make it print at the same line...");
            try{
                Thread.sleep(1000);
            }catch(Exception e){
                // handle the exception...
            }
        }
        // iterate via "for loop" in reverse
        System.out.println("\n==> For Loop Example in reverse order.");
        for (int i=myCoords.size()-1; i >= 0; i--) {
            System.out.println(myCoords.get(i));
        }

        // iterate via "while loop"
        System.out.println("\n==> While Loop Example....");
        int i = 0;
        while (i < myCoords.size()) {
            System.out.println(myCoords.get(i));
            i++;
        }

        // collection stream() util: Returns a sequential Stream with this collection as its source
        /* System.out.println("\n==> collection stream() util....");
         myCoords.forEach((temp) -> {
            System.out.println(temp);
        });*/
        // Sort the list
        System.out.println("\n==> Sort the list with default comparator....");
        Collections.sort(myCoords);
        i = 0;
        while (i < myCoords.size()) {
            System.out.println(myCoords.get(i));
            i++;
        }
        // Sort the list
        System.out.println("\n==> Reverse the list order....");
        Collections.reverse(myCoords);
        i = 0;
        while (i < myCoords.size()) {
            System.out.println(myCoords.get(i));
            i++;
        }

    }

    private String myItoA(int n) {
        String s = "";
        int q=n, r;
        boolean neg = false;
        if ( n < 0 ) {
            neg = true;
            n = -n;
        }
        while ( q > 0 ) {
            r = q % 10;
            q = q/10;
            s = r + s;
        }
        if ( neg ) s = "-"+s;
        return s;
    };

    public static void main(String argv[]) {
        StringUtil1 sutl = new StringUtil1();
        // sutl.sortMap( 5 );
        // sutl.sortCartByDistance(100, 3, 83, 0);
        System.out.println(sutl.myItoA(-560));
        sutl.initList(7);
    }
}
