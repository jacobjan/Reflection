package Collections;

/**
 * Created by AiYeSus on 12/11/2017.
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexEmail {
    public static String EXAMPLE_TEST = "riya riya@gmail.com";
    public static String[] matchStrs;

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("\\w+");
        // [A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,64}
        // in case you would like to ignore case sensitivity,
        // you could use this statement:
        // Pattern pattern = Pattern.compile("\\s+", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(EXAMPLE_TEST);
        // check all occurance
        matchStrs = new String[10];
        int i=0;
  /*      while (matcher.find()) {
            System.out.print("Start index: " + matcher.start());
            System.out.print(" End index: " + matcher.end() + " ");
            matchStrs[i] = matcher.group();
            System.out.println( matchStrs[i++] );
        }
*/        //pattern = Pattern.compile("(\\w+) ([A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,64})");
        pattern = Pattern.compile("(\\w+) ([A-Z0-9a-z._%+-]+@gmail\\.com)");
        matcher = pattern.matcher(EXAMPLE_TEST);
        // check all occurance
        i=0;
        System.out.println( "groupCount :"+matcher.groupCount() );
        while (matcher.find()) {
            System.out.println( i + " "+matcher.group(i));
            System.out.print("Start index: " + matcher.start());
            System.out.print(" End index: " + matcher.end() + " ");
            matchStrs[i] = matcher.group();
            System.out.println( matchStrs[i++] );
        }
    }
}
/**
 import java.io.*;
 import java.util.*;
 Pattern p = Pattern.compile("^\S \S[@gmail.com]");


 */