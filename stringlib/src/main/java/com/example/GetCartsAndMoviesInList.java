package com.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Consumer;

/**
 * Created by AiYeSus on 11/3/2017.
 */

public class GetCartsAndMoviesInList {

    Consumer<Object> csumrObj = System.out::println;

    public static void main(String[] argList) {
        GetCartsAndMoviesInList mObj = new GetCartsAndMoviesInList();
        int reqCode = -1;
        Scanner stdIn = new Scanner( System.in );
        do {
            System.out.println("Enter String to find entries (0-top movies 1-Nearest crates :");
            System.out.println("e.g. 0 40 5 or 1 100 4 45 55");
            String inParam = stdIn.nextLine();
            String params[] = inParam.split(" ");
            try {
                reqCode = Integer.parseInt(params[0]);
                if ( reqCode == -1 ) break;
                int nEntries = 0, reqEntries = 0, cX = 0, cY = 0;

                switch (reqCode) {
                    case 0:
                        nEntries = Integer.parseInt(params[1]);
                        reqEntries = Integer.parseInt(params[2]);
                        mObj.GetMovies(nEntries, reqEntries);
                        break;
                    case 1:
                        nEntries = Integer.parseInt(params[1]);
                        reqEntries = Integer.parseInt(params[2]);
                        cX = Integer.parseInt(params[3]);
                        cY = Integer.parseInt(params[4]);
                        mObj.GetNearestCarts(nEntries, reqEntries, cX, cY);
                        break;
                    default:
                        Set<Integer> singlesSet = new HashSet<>();
                        singlesSet.add(1);
                        singlesSet.add(2);

                        Set<Integer> tensSet = new HashSet<>();
                        tensSet.add(10);
                        tensSet.add(20);

                        List<Set<Integer>> list = new ArrayList<>();
                        list.add(singlesSet);
                        list.add(tensSet);

                        System.out.println(list);
                        break;
                }
            } catch ( Exception e ) {
                e.printStackTrace();
            }
        } while ( reqCode != -1 );
    }

    private String GetMovies(int numOfEntries, int numRequested) {
        // Populate all entries
        Map<Integer, Float> movies = populateMap(numOfEntries);
        // Set up buffer to display all movies
        StringBuilder sb = new StringBuilder();

        // Get entry set from the map movies
        Set<Map.Entry<Integer, Float>> moviesSet = movies.entrySet();
        for(Map.Entry<Integer, Float> entry : moviesSet){
            sb.append("\nMovie " + entry.getKey() + " rating:" + entry.getValue());
        }

        // Create comparator to sort the map acending order
        Comparator<Map.Entry<Integer, Float>> valueComparator = new Comparator<Map.Entry<Integer, Float>>() {
            @Override
            public int compare(Map.Entry<Integer, Float> e1, Map.Entry<Integer, Float> e2) {
                Float v1 = e1.getValue();
                Float v2 = e2.getValue();
                if ( v1 < v2 ) return -1;
                else if ( v1 > v2 ) return 1;
                else return 0;
            }
        };
        // Sort method needs a List, so let's first convert Set to List in Java
        ArrayList<Map.Entry<Integer, Float>> listOfEntries = new ArrayList<Map.Entry<Integer, Float>>(moviesSet);
        // sorting HashMap by values using ascending order comparator
        Collections.sort(listOfEntries, valueComparator);
        LinkedHashMap<Integer, Float> linkedHashMap_sortedByValue = new LinkedHashMap<Integer, Float>(listOfEntries.size());
        int i=0;
        // copying entries from List back to Map

        for(Map.Entry<Integer, Float> entry : listOfEntries){
            linkedHashMap_sortedByValue.put(entry.getKey(), entry.getValue());
        }
        Set<Map.Entry<Integer, Float>> sortedMoviesSet = linkedHashMap_sortedByValue.entrySet();
        sb.append("\nHashMap after sorting entries by values in ascending order:");
        sb.append("\nFrom sorted SET of Hashmap :\n");
        Iterator setItr = sortedMoviesSet.iterator();
        StringBuilder sbder = new StringBuilder();
        String[] parts;
        while ( setItr.hasNext() ) {
            sbder.append(setItr.next().toString());
            parts = sbder.toString().split("=");
            if ( parts.length > 1 ) sb.append("Movie :"+parts[0]+"  rating:"+parts[1]+"\n");
            sbder.setLength(0);
        }

        sb.append("\n\nBottom " +  numRequested + "  movies in ascending rating order:\n");
        for(i=0; i < numRequested; i++) {
            sb.append("Movie :"+listOfEntries.get(i).getKey()+"  rating:"+listOfEntries.get(i).getValue()+"\n");
        }
        i=0;
        // Collections.reverse(listOfEntries); Don't need to reverse, list is already sorted, just treverse thru beginging or end
        sb.append("\n\nTop " + numRequested +" movies in decending rating order:\n");
        for(i=listOfEntries.size(); i >= listOfEntries.size()-numRequested+1 && i > 0; i--) {
            sb.append("Movie :"+listOfEntries.get(i-1).getKey()+"  rating:"+listOfEntries.get(i-1).getValue()+"\n");
        }
        System.out.println( sb.toString() );
        return sb.toString();
    };

    public static float round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }

    public Map<Integer, Float> populateMap(int maxEntries) {
        Map<Integer, Float> movies = new HashMap<Integer, Float>();
        Random rnd = new Random();
        int id=0;
        float rating=0.0f;

        for(int i=0; i < maxEntries; i++) {
            id = Math.abs(rnd.nextInt()) % 1000 + 1;
            rating = round(rnd.nextFloat() * 5, 2);
            if ( !movies.containsKey(id)) movies.put(id ,rating);
        }
        return movies;
    }

    private String GetNearestCarts(int numOfEntries, int reqEntries, int destX, int destY) {
        StringBuilder sb = new StringBuilder();
        List<List<Integer>> allcarts = new ArrayList<List<Integer>>();
        List<Integer> cartloc = new ArrayList<>();
        // Populate all carts
        Random rnd = new Random();
        int x=0, y=0;

        for(int i=0; i < numOfEntries; i++) {
            x = Math.abs(rnd.nextInt()) % 100;
            y = Math.abs(rnd.nextInt()) % 100;
            cartloc = Arrays.asList(x, y);
            allcarts.add( cartloc );
        }

        sb.append( "\nTotal Number of carts in warehouse :  " + allcarts.size() );
        Map<List<Integer>, Float> cartsLoc = new HashMap<List<Integer>, Float>();
        // Calculate and populate cartsLoc map
        float dist = 0.0f;
        int dx=0, dy=0;
        for(List<Integer> cart: allcarts) {
            dx = cart.get(0)-destX;
            dy = cart.get(1)-destY;
            dist = (float)Math.sqrt( dx*dx + dy*dy );
            cartsLoc.put(cart, dist);
            sb.append("\nCart " + cart.toString() + "  Distance to " + destX + ", "+ destY+ " :" + dist);
        }
        // Get entry set from the cartsLoc map
        Set<Map.Entry<List<Integer>, Float>> cartsLocSet = cartsLoc.entrySet();
        // Store them in list to sort
        List<Map.Entry<List<Integer>, Float>> listOfCarts = new ArrayList<Map.Entry<List<Integer>, Float>>(cartsLocSet);
        // Set up comparator
        // Create comparator to sort the map acending order of distance ( Float type )
        Comparator<Map.Entry<List<Integer>, Float>> valueComparator = new Comparator<Map.Entry<List<Integer> ,Float>>() {
            @Override
            public int compare(Map.Entry<List<Integer>, Float> e1, Map.Entry<List<Integer>, Float> e2) {
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
        sb.append("\nSorted list of carts");
        for(Map.Entry<List<Integer>, Float> cart: listOfCarts) {
            sb.append("\nCart " + cart.toString());
        }

        listOfCarts.iterator();


        sb.append("\nList of " + reqEntries + " nearest carts to " + destX + ", " + destY);
        int i=0, lstSize=listOfCarts.size();
        for(i=0; i<reqEntries && i<lstSize; i++) {
            sb.append("\nCart " + listOfCarts.get(i).getKey() + "  Distance:" + listOfCarts.get(i).getValue());
        }

        sb.append("\n\nList of " + reqEntries + " farest carts to " + destX + ", " + destY);
        for(i=lstSize-1; i>lstSize-reqEntries-1 && i>0; i--) {
            sb.append("\nCart " + listOfCarts.get(i).getKey() + "  Distance:" + listOfCarts.get(i).getValue());
        }
        System.out.println( sb.toString() );
        return sb.toString();
    }

    public HashMap sortMap(Map<Integer, Float> hmap) {
        HashMap<Integer, Float> rmap = new HashMap<Integer, Float>();
        return rmap;
    }

    /** Display the modifiers, name, superclass, and interfaces of a class
     *  or interface. Then go and list all constructors, fields, and methods. */
}

