package IO;

/**
 * Created by AiYeSus on 12/8/2017.
 */

import java.io.*;
import java.util.*;

public class TimeInWords {


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        String[] hrstr = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve"};
        String[] minstr = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve",
                "thirteen", "fourteen", "quarter", "sixteen", "seventeen", "eighteen", "nineteen", "twenty"};
        Scanner stdin = new Scanner(System.in);
        int hr;
        int min;

        do {
            hr = stdin.nextInt();
            min = stdin.nextInt();
            String past = " past ";
            String minuteStr ="";

            if (min > 30) {
                hr++;
                min = 60 - min;
                past = " to ";
            }

            if ( min > 0 ) {
                if (min > 20 && min < 30) {
                    minuteStr = minstr[19] + " " + hrstr[min - 21];
                } else {
                    if (min == 30) minuteStr = "half";
                    else minuteStr = minstr[min - 1];
                }
            }
            String hrStr = hrstr[hr - 1];
            if (min == 0) {
                System.out.println(hrStr + " o'clock");
            } else {

                System.out.println(minuteStr + ((min != 15) ? " minutes" : "") + past + hrStr);
            }
        } while ( min != 29 );
    }
}