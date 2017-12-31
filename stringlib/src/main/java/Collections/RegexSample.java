package Collections;

/**
 * Created by AiYeSus on 12/11/2017.
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexSample {
    public static String EXAMPLE_TEST = "This is my small example string which I'm going to use for pattern matching.";

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("\\w+");
        // in case you would like to ignore case sensitivity,
        // you could use this statement:
        // Pattern pattern = Pattern.compile("\\s+", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(EXAMPLE_TEST);
        // check all occurance
        while (matcher.find()) {
            System.out.print("Start index: " + matcher.start());
            System.out.print(" End index: " + matcher.end() + " ");
            System.out.println(matcher.group());
        }
        // now create a new pattern and matcher to replace whitespace with tabs
        Pattern replace = Pattern.compile("\\s+");
        Matcher matcher2 = replace.matcher(EXAMPLE_TEST);
        System.out.println(matcher2.replaceAll("\t"));
        EXAMPLE_TEST = "100001";
        replace = Pattern.compile("^[1]0+[1]$");
        matcher = replace.matcher(EXAMPLE_TEST);
        System.out.println("Matching "+EXAMPLE_TEST);
        while (matcher.find()) {
            System.out.print("Start index: " + matcher.start());
            System.out.print(" End index: " + matcher.end() + " ");
            System.out.println(matcher.group());
        }
        System.out.println("Result ? "+EXAMPLE_TEST);
        boolean b = Pattern.matches("1*1", EXAMPLE_TEST);
        System.out.println("Result ? "+b);


    }
}