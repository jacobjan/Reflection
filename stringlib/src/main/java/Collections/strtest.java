package Collections;

/**
 * Created by AiYeSus on 12/13/2017.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class strtest {

    public static void main(String[] args) {
        int N=2;
        String S = "1A 2E 1F 1H";

        int[][] seats = new int[N][3];
        for(int r=0; r<N; r++)
            for(int sG=0; sG<3; sG++)
                seats[r][sG] = 0;

        String rStr="", sL="";
        int row, group;
        int tF = N * 3;
        int len=0;
        String[] r = S.split(" ");
        for( String rzd : r ) {
            Pattern replace = Pattern.compile("^\\d\\s");
            Matcher matcher = replace.matcher(rzd);
            System.out.println("Matching "+rzd);
            while (matcher.find()) {
                System.out.print("Start index: " + matcher.start());
                System.out.print(" End index: " + matcher.end() + " ");
                System.out.println(matcher.group());
            }

            len = rzd.length();
            sL = rzd.substring(len-1);
            char[] charr = rzd.toCharArray();
            charr[len-1] = ' ';
            rStr = new String( charr );
  //          System.out.println(rzd + " "+len+ " "+rzd.substring(0, 1)+ " "+rzd.substring(1));
            System.out.println(rzd + " "+len+ " "+rStr+ " "+sL);
            row = Integer.parseInt( rStr.trim() );

                if ( sL.equals("A") || sL.equals("B") || sL.equals("C") ) group = 0;
                else if ( sL.equals("E") || sL.equals("F") ) group = 2;
                else group = 2;
                tF--;

        }
        System.out.println(tF);
    }
}

/**
 *            len = rzd.length();
 sL = rzd.substring(len-1);
 char[] charr = rzd.toCharArray();
 charr[len-1] = ' ';
 rStr = new String( charr );
 //          System.out.println(rzd + " "+len+ " "+rzd.substring(0, 1)+ " "+rzd.substring(1));
 System.out.println(rzd + " "+len+ " "+rStr+ " "+sL);

 */
