package Collections;

/**
 * Created by AiYeSus on 12/13/2017.
 * Find remaining 3 connected seats for from row 1 - N
 * e.g. existing rez seats: "1A 2E 1F 3D 2J 1H";
 * Row   A B C  D E F G  H J K
 *  1    x _ _  _ _ x _  x _ _
 *  2    _ _ _  _ x _ _  _ x _
 *  3    _ _ _  x _ _ _  _ _ _
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeatsRez747 {

    public static void main(String[] args) {
        int N=3;
       // String S = "1A 2E 1F 3D 2J 1H";
        String S = "1A 2E 1F 3D 2J 1H 1C 2D 2C 3G";

        int[][] seats = new int[N][3];
        for(int r=0; r<N; r++)
            for(int sG=0; sG<3; sG++)
                seats[r][sG] = 4;

        String rStr="", sL="";
        int row, group;
        int tF = N * 3;
        System.out.println("Total 3 consecutive seats for three member family :" +tF);
        int len=0;
        String[] r = S.split(" ");
        for( String rzd : r ) {

            len = rzd.length();
            sL = rzd.substring(len - 1);
            char[] charr = rzd.toCharArray();
            charr[len - 1] = ' ';
            rStr = new String(charr);
            //          System.out.println(rzd + " "+len+ " "+rzd.substring(0, 1)+ " "+rzd.substring(1));
            System.out.println(rzd + " " + len + " " + rStr + " " + sL);
            row = Integer.parseInt(rStr.trim());
            row--;

            if (sL.equals("A") || sL.equals("B") || sL.equals("C")) group = 0;
            else if (sL.equals("H") || sL.equals("J") || sL.equals("K")) group = 2;
            else group = 1;

            if (group == 1 && seats[row][group] >= 3 && (sL.equals("D") || sL.equals("G"))) {
                seats[row][group]--;
                if (seats[row][group] == 2) {
                    seats[row][group] = 0;
                    tF--;
                }
            } else {
                if (seats[row][group] > 0) {
                    seats[row][group] = 0;
                    tF--;
                }
            }
            String[] gpDesc = {"A-C", "D-G", "H-K"};
            System.out.println("Remaining 3 consecutive seats for three member family :" + tF + "  as following:");
            for (int pr = 1; pr <= N; pr++)
                for (int psG = 1; psG <= 3; psG++)
                    if (seats[pr - 1][psG - 1] > 0) {
                        System.out.println("Row " + pr + "  Seat Group :" + gpDesc[psG - 1]);
                    }
        }
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
/** Use regex

 Pattern replace = Pattern.compile("^\\d\\s");
 Matcher matcher = replace.matcher(rzd);
 System.out.println("Matching "+rzd);
 while (matcher.find()) {
 System.out.print("Start index: " + matcher.start());
 System.out.print(" End index: " + matcher.end() + " ");
 System.out.println(matcher.group());
 }
*/