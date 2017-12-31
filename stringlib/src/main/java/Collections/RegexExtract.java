package Collections;

/**
 * Created by AiYeSus on 12/14/2017.
 */

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExtract {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String txt="";

        String data = "<p>Test&nbsp;\n" +
                "<img alt=\"70\" width=\"70\" height=\"50\" src=\"/adminpanel/userfiles/image/1.jpg\" />\n" +
                "Test \n" +
                "<img alt=\"70\" width=\"70\" height=\"50\" src=\"/adminpanel/userfiles/image/2.jpg\" />\n" +
                "</p>";
        Pattern p0 = Pattern.compile("src=\"([^\"]+)\"");
        Matcher m = p0.matcher(data);
        System.out.println("Found " + m.groupCount());
        while (m.find()) {
            System.out.printf("found: %s%n", m.group(1));
        }
        data = "23A 3D 1H 2D";
        p0 = Pattern.compile("[\\d+][\\S]");
        m = p0.matcher(data);
        System.out.println("Found " + m.groupCount());
        while (m.find()) {
            System.out.printf("found: %s%n", m.group(0));
            System.out.printf("found: %s%n", m.group(1));
        }

    }
}
