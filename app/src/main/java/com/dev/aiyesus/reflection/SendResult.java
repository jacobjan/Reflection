package com.dev.aiyesus.reflection;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * Created by AiYeSus on 9/13/2017.
 *
 */

public class SendResult extends Activity {
    boolean setup_catrs_params = false;
    EditText carts_params;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_result);

        // See assets/res/any/layout/hello_world.xml for this
        // view layout definition, which is being set here as
        // the content of our screen.

        // Watch for button clicks.
        Button b = (Button)findViewById(R.id.corky);
        b.setOnClickListener(mReflectionListener);
        b = findViewById(R.id.violet);
        b.setOnClickListener(mGetMoviesListener);
        b = findViewById(R.id.margerie);
        b.setOnClickListener(mGetNearestCartsListener);
        b = findViewById(R.id.strUtils);
        b.setOnClickListener(mRunStringUtilsListener);
        carts_params = (EditText)findViewById(R.id.edit_carts_params);
    }

    private OnClickListener mReflectionListener = new OnClickListener() {
        public void onClick(View v) {
            Intent resultIntent = new Intent();
            //SharedPreferences preferences = getSharedPreferences("RedirectData", 0);
            setResult(RESULT_OK, resultIntent.setAction(getReflectionOnClass( "android.text.style.StyleSpan" )) );
            finish();
        }
    };

    private OnClickListener mGetMoviesListener = new OnClickListener() {
        public void onClick(View v) {
            // Erase the preferences and exit!
            Intent resultIntent = new Intent();
            //SharedPreferences preferences = getSharedPreferences("RedirectData", 0);
            setResult(RESULT_OK, resultIntent.setAction(GetMovies( 3 )));
            finish();
        }
    };

    private OnClickListener mGetNearestCartsListener = new OnClickListener() {
        public void onClick(View v) {

            String params = carts_params.getText().toString();
            int numOfCarts=20,
                    requested=5,
                    destX=0,
                    destY=0;
            Log.i("Reflection", params);
            if (null != params && params.length() > 0) {
                String[] cartParams = params.split(",");
                int i=0;
                while ( i < cartParams.length ) {
                    Log.i("Reflection", ""+numOfCarts+" "+ requested+" "+  destX+" "+  destY);
                    switch ( i ) {
                        case 0: numOfCarts = Integer.parseInt(cartParams[0]);
                                break;
                        case 1: requested = Integer.parseInt(cartParams[1]);
                                break;
                        case 2: destX = Integer.parseInt(cartParams[2]);
                                break;
                        case 3: destY = Integer.parseInt(cartParams[3]);
                                break;
                    }
                    i++;
                }
            }
            // setup intent to pass run result back to main activity
            Intent resultIntent = new Intent();
            // for GetNearestCarts with parameters: numOfEntries, reqEntries, destX, destY
            setResult(RESULT_OK, resultIntent.setAction(GetNearestCarts( numOfCarts, requested, destX, destY )));
            finish();
        }
    };

    private OnClickListener mRunStringUtilsListener = new OnClickListener() {
        public void onClick(View v) {
            // Erase the preferences and exit!
            Intent resultIntent = new Intent();
            //SharedPreferences preferences = getSharedPreferences("RedirectData", 0);
            setResult(RESULT_OK, resultIntent.setAction(RunStringUtils(0)));
            finish();
        }
    };

    private String getReflectionOnClass(String className) {
        Class aClass = null;
        try {
            aClass = Class.forName(className);
            return print_class( aClass );
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    };

    private String RunStringUtils(int ops) {
        String res = null;
        switch ( ops ) {
            case 0:  // itoa
                res = myItoA( 89776 );
                break;
            case 1:
                break;
            default:
                break;
        }
        return res;
    };

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
            s = ('0' + r) + s;
        }
        if ( neg ) s = "-"+s;
        return s;
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

    protected void onCheckboxClicked() {
        setup_catrs_params = true;
    }

    private String GetMovies(int maxEntries) {
        // Populate all entries
        Map<Integer, Float> movies = populateMap(10);
        // Set up buffer to display all movies
        StringBuilder sb = new StringBuilder();

        // Get entry set from the map movies
        Set<Map.Entry<Integer, Float>> moviesSet = movies.entrySet();
        for(Entry<Integer, Float> entry : moviesSet){
            sb.append("\nMovie " + entry.getKey() + " rating:" + entry.getValue());
        }

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
        // Sort method needs a List, so let's first convert Set to List in Java
        List<Entry<Integer, Float>> listOfEntries = new ArrayList<Entry<Integer, Float>>(moviesSet);
        // sorting HashMap by values using ascending order comparator
        Collections.sort(listOfEntries, valueComparator);
        LinkedHashMap<Integer, Float> linkedHashMap_sortedByValue = new LinkedHashMap<Integer, Float>(listOfEntries.size());
        int i=0;
        // copying entries from List back to Map

        for(Entry<Integer, Float> entry : listOfEntries){
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

        sb.append("\n\nBottom " +  maxEntries + " rating movies in ascending order:\n");
        for(i=0; i < maxEntries; i++) {
            sb.append("Movie :"+listOfEntries.get(i).getKey()+"  rating:"+listOfEntries.get(i).getValue()+"\n");
        }
        i=0;
        // Collections.reverse(listOfEntries); Don't need to reverse, list is already sorted, just treverse thru beginging or end
        sb.append("\n\nTop three rating movies in decending order:\n");
        for(i=listOfEntries.size(); i >= listOfEntries.size()-maxEntries+1 && i > 0; i--) {
            sb.append("Movie :"+listOfEntries.get(i-1).getKey()+"  rating:"+listOfEntries.get(i-1).getValue()+"\n");
        }
        return sb.toString();
    };

    private String GetNearestCarts(int numOfEntries, int reqEntries, int destX, int destY) {
        StringBuilder sb = new StringBuilder();
        List<List<Integer>> allcarts = new ArrayList<List<Integer>>();
        List<Integer> cartloc = new ArrayList<>();
        // Populate all carts
        Random rnd = new Random();
        int x=0, y=0;
        Log.i("Reflection", "numOfEntries :"+numOfEntries);
        for(int i=0; i < numOfEntries; i++) {
            x = Math.abs(rnd.nextInt()) % 100;
            y = Math.abs(rnd.nextInt()) % 100;
            cartloc = Arrays.asList(x, y);
            allcarts.add( cartloc );
        }
        Log.i("Reflection", "size :"+allcarts.size());
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
        }
        // Get entry set from the map movies
        Set<Entry<List<Integer>, Float>> cartsLocSet = cartsLoc.entrySet();

        // Store them in list to sort
        List<Entry<List<Integer>, Float>> listOfCarts = new ArrayList<Entry<List<Integer>, Float>>(cartsLocSet);
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
        int i=0, lstSize=listOfCarts.size();
        for(i=0; i<reqEntries && i<lstSize; i++) {
                sb.append("\nCart " + listOfCarts.get(i).getKey() + "  Distance:" + listOfCarts.get(i).getValue());
        }
        Log.i("Reflection", "nearest :"+allcarts.size());
        sb.append("\n\nList of " + reqEntries + " farest carts to " + destX + ", " + destY);
        for(i=lstSize-1; i>lstSize-reqEntries-1 && i>0; i--) {
            sb.append("\nCart " + listOfCarts.get(i).getKey() + "  Distance:" + listOfCarts.get(i).getValue());
        }
        Log.i("Reflection", "farest :"+lstSize);
        return sb.toString();
    }

    public HashMap sortMap(Map<Integer, Float> hmap) {
        HashMap<Integer, Float> rmap = new HashMap<Integer, Float>();
        return rmap;
    }

    /** Display the modifiers, name, superclass, and interfaces of a class
     *  or interface. Then go and list all constructors, fields, and methods. */
    public String print_class(Class c) {
        StringBuffer sb = new StringBuffer();
        // Print modifiers, type (class or interface), name, and superclass.
        if (c.isInterface()) {
            // The modifiers will include the "interface" keyword here...
            sb.append(Modifier.toString(c.getModifiers()) +  c.getName()+"\n");
        }
        else
            sb.append(Modifier.toString(c.getModifiers()) + " class " +
                    c.getName() +
                    " extends " + c.getSuperclass().getName()+"\n");
        // Print interfaces or super-interfaces of the class or interface.
        Class[] interfaces = c.getInterfaces();
        if ((interfaces != null) && (interfaces.length > 0)) {
            if (c.isInterface()) System.out.println(" extends ");
            else sb.append(" implements ");
            for(int i = 0; i < interfaces.length; i++) {
                if (i > 0) System.out.print(", ");
                sb.append(interfaces[i].getName());
            }
        }
        sb.append(" {");            // Begin class member listing.
        // Now look up and display the members of the class.
        sb.append(" // Constructors"+"\n");
        Constructor[] constructors = c.getDeclaredConstructors();
        for(int i = 0; i < constructors.length; i++)      // Display constructors.
            print_method_or_constructor(constructors[i]);
        sb.append(" // Fields"+"\n");
        Field[] fields = c.getDeclaredFields();           // Look up fields.
        for(int i = 0; i < fields.length; i++)            // Display them.
            print_field(fields[i]);
        sb.append(" // Methods"+"\n");
        Method[] methods = c.getDeclaredMethods();        // Look up methods.
        for(int i = 0; i < methods.length; i++)           // Display them.
            sb.append( print_method_or_constructor(methods[i]) );
        sb.append("}\n");             // End class member listing.
        return sb.toString();
    }

    /** Return the name of an interface or primitive type, handling arrays. */
    public String typename(Class t) {
        String brackets = "";
        while(t.isArray()) {
            brackets += "[]";
            t = t.getComponentType();
        }
        return t.getName() + brackets;
    }

    /** Return a string version of modifiers, handling spaces nicely. */
    public String modifiers(int m) {
        if (m == 0) return "";
        else return Modifier.toString(m) + " ";
    }

    /** Print the modifiers, type, and name of a field. */
    public void print_field(Field f) {
        StringBuffer sb = new StringBuffer();
        sb.append("  " +
                modifiers(f.getModifiers()) +
                typename(f.getType()) + " " + f.getName() + ";");
    }

    /** Print the modifiers, return type, name, parameter types, and exception
     *  type of a method or constructor.  Note the use of the Member interface
     *  to allow this method to work with both Method and Constructor objects. */
    public String print_method_or_constructor(Member member) {
        StringBuffer sb = new StringBuffer();
        Class returntype=null, parameters[], exceptions[];
        if (member instanceof Method) {
            Method m = (Method) member;
            returntype = m.getReturnType();
            parameters = m.getParameterTypes();
            exceptions = m.getExceptionTypes();
        } else {
            Constructor c = (Constructor) member;
            parameters = c.getParameterTypes();
            exceptions = c.getExceptionTypes();
        }
        sb.append("  " + modifiers(member.getModifiers()) +
                ((returntype!=null)? typename(returntype)+" " : "") +
                member.getName() + "(");
        for(int i = 0; i < parameters.length; i++) {
            if (i > 0) sb.append(", ");
            sb.append(typename(parameters[i]));
        }
        sb.append(")");
        if (exceptions.length > 0) sb.append(" throws ");
        for(int i = 0; i < exceptions.length; i++) {
            if (i > 0) sb.append(", ");
            sb.append(typename(exceptions[i]));
        }
        sb.append(";\n");
        return sb.toString();
    }
}

