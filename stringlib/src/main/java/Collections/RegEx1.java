package Collections;

/**
 * Created by AiYeSus on 12/14/2017.
 */
import java.util.regex.Pattern;
import java.util.Scanner;
import java.util.regex.Matcher;

public class RegEx1 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String txt="";
        while ( !txt.equalsIgnoreCase("quit") ) {
            System.out.println("Enter regex pattern:");
            Pattern pattern = Pattern.compile(sc.nextLine());
            System.out.println("Enter text:");
            txt = sc.nextLine();
            Matcher matcher = pattern.matcher(txt);
            boolean found = false;
            while (matcher.find()) {
                System.out.println("Found " + matcher.groupCount()+" substring matches "+matcher.group()+" starting at index "+
                        matcher.start()+" and ending at index "+matcher.end());
                found = true;
            }
            if(!found){
                System.out.println("No match found.");
            }
        }
    }
}
